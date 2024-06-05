package getWebSite;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeToFile {
    private static List<columnMap> columnMap = new ArrayList<>();
    private static Field[] UniverFields = University.class.getDeclaredFields();

    public static void main(String[] args) throws IOException{
        //test code
        University[] universityData = new University[1]; 
        universityData[0] = new University();
        universityData[0].setUniverName("University of California, Davis");
        universityData[0].setCollegeBoardCode("4834");
        universityData[0].setURLCollegeBoard("https://bigfuture.collegeboard.org/colleges/university-of-california-davis");

        String path = "./data/";
        String excelFileName = "universityData.xlsx";
        String excelFile2Read = "myUniverData2024.xlsx";
        String sheetName = "MyUniversities";
        Integer headerRow = 0;
        Integer headerColumn = 0;
        //writeToFile.writToExcell(universityData, fullFilePath);
        readExcelFile(path + excelFile2Read, sheetName, headerRow, headerColumn, universityData);
    }

    private static void mapHeader(Row hrow) {
    Integer columnIndex = 0; // Index of the first data column
        //read and map columns in the header row
        while (columnIndex <= hrow.getPhysicalNumberOfCells()) {
            Cell currentCell = hrow.getCell(columnIndex);
            CellAddress cellAddr;
            String cellValue = "";
            try {
                cellAddr = currentCell.getAddress();
                cellValue = currentCell.getStringCellValue();
                columnMap cR = new columnMap(columnIndex, cellAddr, currentCell, cellValue, "");
                columnMap.add(cR);
                //cR.printLn();
            } catch (NullPointerException e) {
                // Handle null cell value
            }
            columnIndex++;
        }
        // mathch file columps with university columns
        for (columnMap cR : columnMap) {

                for (Field field : UniverFields) {
                    Integer col = getColmnID(field.getName());
                    System.out.println("Col " + col + " Field: " + field.getName());
                }
            //cR.printLn();
        }
        String header = "| ";
        for (columnMap cR : columnMap) {
            header = header + cR.getColumnIndex() +":" +cR.getCellAddress() + " " + cR.getFileColmName() + " | ";
        }
        System.out.println(header);

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
    public static void readExcelFile(String excelFile2Read, String sheetName , Integer headerRow, Integer headerColumn, University[] universityData) {
        
        try {
            FileInputStream fileIn = new FileInputStream(excelFile2Read);
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sh = workbook.getSheet(sheetName);
            System.out.println("Sheet name: " + sh.getSheetName());
            Integer rowIndex = headerRow+1; // Index of the first data row

            //ieterate trough each university from webscrabing
            for (University uD : universityData) {
                mapHeader(sh.getRow(headerRow)); // Map the header columns for passed heaer row in the sheet form the file
                
                // iterate over each column on the webscrabed data
                for (Field field : UniverFields) {
                    Integer cID = null; // Column ID if found in the header (exists in the file)
                    String fName = field.getName();
                    String mName = "get"+fName;
                    try {
                        Method m = University.class.getMethod(mName);
                        System.out.println(mName + " : " + m.invoke(uD));  
                        cID = getColmnID(fName);       
                        System.out.println("Column ID: " + cID);
                        // write data to the cell, if column ID is found in the header
                        if (cID != null) {
                            Row currentRow = sh.getRow(rowIndex);
                            Cell currentCell = currentRow.getCell(cID);
                            try {   
                            String cellValue = currentCell.getStringCellValue();
                            System.out.print("Row: " + rowIndex + "| "+ cellValue + " |\n");
                               //m.invoke(uD, cellValue);
                            } catch (NullPointerException e) {
                                System.out.println("Blank cell found at row: " + currentCell.getAddress());
                                //break;
                            } 
                        }
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        //e.printStackTrace();
                        System.out.println('"' + mName + '"' +" method not found");
                    }                 
                }
            }
        //cR.printLn();

            while (rowIndex < sh.getPhysicalNumberOfRows()) {
                Row currentRow = sh.getRow(rowIndex);
                Integer phisicalRowNumber = rowIndex+1;
                Cell currentCell = currentRow.getCell(headerColumn);
                String cellValue = currentCell.getStringCellValue();
                if (currentCell.getCellType() == CellType.BLANK) {
                    //System.out.println("Blank cell found at row: " + phisicalRowNumber);
                    //break;
                } else {
                    System.out.print("Row: " + phisicalRowNumber + "| "+ cellValue + " |\n");
                }
                rowIndex++;
            }
            workbook.close();
            fileIn.close();
            System.out.println("Excel file read successfully.");

    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}