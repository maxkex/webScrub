package fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dataObjects.University;

public class mapHeader {
    private static final List<columnMap> columnMap = new ArrayList<>();
    private static final Field[] UniverFields = University.class.getDeclaredFields();

    public static Integer getColmnID(String colmnName, Sheet sh) {
        Integer colmnID = null;
        readSheetHeader(sh); 
        for (columnMap h : columnMap) {
            if (h.getFileColmName().toLowerCase().equals(colmnName.toLowerCase())) {
                colmnID = h.getColumnIndex();
            }
        }
        return colmnID;
    }
    private static Integer getColmnID(String colmnName) {
        Integer colmnID = null;
        for (columnMap h : columnMap) {
            if (h.getFileColmName().toLowerCase().equals(colmnName.toLowerCase())) {
                colmnID = h.getColumnIndex();
            }
        }
        return colmnID;
    }

    private static void readSheetHeader(Sheet sh) {
            // Index of the first data column
            columnMap.clear(); //reset columnMap
            Integer headerRow = 0; // Index of the header row
            try {
                Row hRow = sh.getRow(headerRow);
                //read and map columns in the header row
                Integer columnCount = hRow.getPhysicalNumberOfCells();
                for (int cIdx = 0; cIdx < columnCount; cIdx++) {
                    Cell currentCell = hRow.getCell(cIdx);
                    CellAddress cellAddr;
                    //String cellValue = "";
                    String cellValue;
                    try {
                        cellAddr = currentCell.getAddress();
                        cellValue = currentCell.getStringCellValue();
                        columnMap cR = new columnMap(cIdx, cellAddr, currentCell, cellValue, "");
                        columnMap.add(cR);
                        //cR.printLn();
                    } catch (NullPointerException e) {
                        System.err.println("MapHeader: readSheetHeader: Error reading header row in the sheet!");
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("Header row not found in the sheet: " + sh.getSheetName());
            }
    }

    public static void updateHeaderInFile(String sheetName, String excelFile) {
        
        //System.out.println("mapHeader excelFile..." + excelFile + " sheetName: " + sheetName);
        ZipSecureFile.setMinInflateRatio(0.0001);
        try (FileInputStream fis = new FileInputStream(excelFile)){
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sh = workbook.getSheet(sheetName);
            // chedk if shet exists, if not create it
            if (sh == null) {
                sh = workbook.createSheet(sheetName);
            }
            // Index of the first data column
            columnMap.clear(); //reset columnMap
            Integer headerRow = 0; // Index of the header row
            Integer columnCount = 0;
            //Row hRow = null;
            Row hRow;
            try {
                hRow = sh.getRow(headerRow);
                //read and map columns in the header row
                columnCount = hRow.getPhysicalNumberOfCells();
            } catch (NullPointerException e) {
                System.out.println("Header row not found in the sheet: " + sheetName + " in the file: " + excelFile);
                hRow = sh.createRow(headerRow);
            }
            for (int cIdx = 0; cIdx < columnCount; cIdx++) {
                Cell currentCell = hRow.getCell(cIdx);
                CellAddress cellAddr;
                //String cellValue = "";
                String cellValue;
                try {
                    cellAddr = currentCell.getAddress();
                    cellValue = currentCell.getStringCellValue();
                    columnMap cR = new columnMap(cIdx, cellAddr, currentCell, cellValue, "");
                    columnMap.add(cR);
                    //cR.printLn();
                } catch (NullPointerException e) {
                    // Handle null cell value
                }
            }
            Boolean columnsAdded = false; // check if columns are added to the file
                // mathch FILE columps with University Array columns
            for (Field field : UniverFields) {
                //check if column exists in the file
                //Integer col = null;
                String fieldName = field.getName();
                Integer col = getColmnID(fieldName);
                if (col == null) {
                    int lastCellID = 0;
                    try {
                        lastCellID = hRow.getLastCellNum();
                        if (lastCellID < 0) {
                            lastCellID = 0;
                        }
                    } catch (NullPointerException e) {
                        System.out.println("No cells found in the header row: " + sheetName + " in the file: " + excelFile);
                    }
                    Cell c = hRow.createCell(lastCellID);
                    c.setCellValue(fieldName);
                    System.err.println("Created Colm: " + fieldName + " Column ID: " + lastCellID);
                    columnsAdded = true;
                }   
                // priont matched column ID and field names
                // System.out.println("Col " + col + " Field: " + field.getName());
            }
            if (columnsAdded == true) {
            // Write changes to the file
                try (FileOutputStream fos = new FileOutputStream(excelFile)) {
                workbook.write(fos);
                workbook.close();
                System.out.println("mapHeader: Header row updated and Excel file saved successfully.");
                //updateHeaderInFile(sheetName, excelFile);
            }catch (IOException e) {
                System.err.println( "mapHeader: Error writing to the file: " + excelFile);
             }
        }
         fis.close(); // close the file
        }   catch (IOException ex) {
        }
    }
}
