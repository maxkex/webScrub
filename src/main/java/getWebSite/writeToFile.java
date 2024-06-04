package getWebSite;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
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
    // Your code here
    public static void main(String[] args) throws IOException {
        //test code
        University[] universityData = new University[1]; 
        universityData[0] = new University();
        universityData[0].setUrlCollegeBoard("https://bigfuture.collegeboard.org/colleges/university-of-california-davis");

        String path = "./data/";
        String excelFileName = "universityData.xlsx";
        String excelFile2Read = "myUniverData2024.xlsx";
        String sheetName = "MyUniversities";
        int headerRow = 0;
        int headerColumn = 0;
        //writeToFile.writToExcell(universityData, fullFilePath);
        readExcelFile(path + excelFile2Read, sheetName, headerRow, headerColumn);
    }
    public static void readExcelFile(String excelFile2Read, String sheetName , int headerRow, int headerColumn) {
        System.out.println("Reading Excel file: " + excelFile2Read);
        List<columnMap> columnMap = new ArrayList<>();
        
        try {
            FileInputStream fileIn = new FileInputStream(excelFile2Read);
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sh = workbook.getSheet(sheetName);
            System.out.println("Sheet name: " + sh.getSheetName());
            int rowIndex = headerRow+1; // Index of the first data row
            int columnIndex = headerColumn; // Index of the first data column
            int rowCount = 0;
            
            //read and map columns in the header row
            Row hrow = sh.getRow(headerRow);
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

                    for (Field field : University.class.getDeclaredFields()) {
                        if (field.getName().equals(cR.getFileColmName())) {
                            cR.setUniverColmID(field.getName());
                        }
                    }
            }

            while (rowIndex < sh.getPhysicalNumberOfRows()) {
                Row currentRow = sh.getRow(rowIndex);
                int phisicalRowNumber = rowIndex+1;
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
            System.out.println("An error occurred while reading from Excel file: " + e.getMessage());
        }
    }
    public static void writToExcell(University[] universityData,String excelFilePath) {
        // Write universityData to Excel file
        try {
            FileInputStream fileIn = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(fileIn);
            String sheetName = workbook.getSheetName(0);
            System.out.println("Sheet name: " + sheetName);
            workbook.close();
            System.out.println("fileIn: " + fileIn);
            fileIn.close();
            
            System.out.println("......Excel file read successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while I/O to Excel file: " + e.getMessage());
        }
    }

    public static void writeToTXTFile (University[] universityData, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            StringBuilder sb = new StringBuilder();
            String delim = "|";
            // Append the data for each university
            //sb.append((countOfUnivrFound - udInx) + " of " + countOfUnivrFound);
            sb.append(delim);
            //sb.append(universityData[udInx].getUniverName());
            sb.append('\n');
            writer.append(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
