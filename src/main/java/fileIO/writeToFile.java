package fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dataObjects.University;
import static fileIO.findInSheet.getRowID;
import static fileIO.mapHeader.getColmnID;

public class writeToFile {
    private static final Field[] UniverFields = University.class.getDeclaredFields();

    public static void main(String[] args) throws IOException{
        //test code
        University[] universityData = new University[1]; 
        universityData[0] = new University();
        universityData[0].setUniverName("University of California, Davis");
        universityData[0].setCollegeBoardCode("=HYPERLINK(\"https://bigfuture.collegeboard.org/colleges/university-of-california-davis\",\"4834\")");
        universityData[0].setURLCollegeBoard("https://bigfuture.collegeboard.org/colleges/university-of-california-davis");
               String path = "./data/";
        String excelFile2Read = "myUniverData2024.xlsx";
        String sheetName = "wu";
        //writeToFile.writToExcell(universityData, fullFilePath);
        writeExcelFile(path + excelFile2Read, sheetName, universityData);
    }

       public static void writeExcelFile(String excelFile, String sheetName, University[] universityData){
                    
            //ieterate trough each university from webscrabing
            for (University university : universityData) {
                writeToFile.writeExcelFile(excelFile, sheetName, university);
            }
    }

    public static void writeExcelFile(String excelFile, String sheetName, University uD) {
        ZipSecureFile.setMinInflateRatio(0.0001);
        File mFile = new File(excelFile);
        try {
            FileInputStream fileIn = new FileInputStream(mFile);
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sh = workbook.getSheet(sheetName);
            //System.out.println("Sheet name: " + sh.getSheetName());
            Integer rowIndex = 1; // Index of the first data row

                // get university ID in the file, if exists
                Integer univerRowID = getRowID(uD, sh);
                //System.out.println("University ID:" + uD.getCollegeBoardCode() +" in the Row ID: " + univerRowID);

                // create new row if university not found in the file
                if (univerRowID == null) {
                    // if university not found in the file, add it to the end of the file
                    Integer newUniverRowID = sh.getPhysicalNumberOfRows();
                    sh.createRow(newUniverRowID);
                    rowIndex = newUniverRowID;
                }   else {
                    rowIndex = univerRowID;
                }
                
                // iterate over each column on the webscrabed data
                for (Field field : UniverFields) {
                    Integer cID = null; // Column ID if found in the header (exists in the file)
                    String fName = field.getName();
                    String mName = "get"+fName;
                    try {
                        Method m = University.class.getMethod(mName);
                        // print values from University object
                        String webFoundValue = "";
                        try {
                            webFoundValue = m.invoke(uD).toString();

                        } catch (NullPointerException e) {
                            System.out.println("writeExcelFile: Method: "+'"' + mName + '"' +" did not return value!");
                        }
                        //System.out.println(mName + " : " + webFoundValue);  
                        cID = getColmnID(fName, sh);      
                        //System.out.println("writeExcelFile: Column ID: " + cID);
                        // write data to the cell, if column ID is found in the header
                        if (cID != null) {
                            Row currentRow = sh.getRow(rowIndex);
                            Cell currentCell = currentRow.getCell(cID);
                            if (currentCell == null) {
                                currentCell = currentRow.createCell(cID);
                            }
                                try {   
                                    String cellValue = "";
                                        switch (currentCell.getCellType()) {
                                            case STRING:
                                                cellValue = currentCell.getStringCellValue();
                                                if (cellValue.length() < 1 || cellValue == null || fName.toLowerCase().equals("univerName".toLowerCase())) { // if university name - overrwrite with University name with URL
                                                    if (webFoundValue.startsWith("=")) {
                                                        currentCell.setCellFormula(webFoundValue.substring(1));
                                                        FormulaEvaluator evaluator = currentCell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
                                                        currentCell.setCellStyle(getBlueUnderlinedCellStyle(workbook));
                                                        evaluator.evaluateFormulaCell(currentCell);
                                                    } else {
                                                        currentCell.setCellValue(webFoundValue);
                                                    }
                                                }
                                                break;
                                            case NUMERIC:
                                                cellValue = String.valueOf(currentCell.getNumericCellValue());
                                                if (cellValue.length() < 1 || cellValue == null) {
                                                    if (webFoundValue.startsWith("=")) {
                                                        currentCell.setCellFormula(webFoundValue.substring(1));
                                                        FormulaEvaluator evaluator = currentCell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
                                                        currentCell.setCellStyle(getBlueUnderlinedCellStyle(workbook));
                                                        evaluator.evaluateFormulaCell(currentCell);
                                                    } else {
                                                        currentCell.setCellValue(webFoundValue);
                                                    }
                                                }
                                                break;
                                            case BOOLEAN:
                                                cellValue = String.valueOf(currentCell.getBooleanCellValue());
                                                if (cellValue.length() < 1 || cellValue == null) {
                                                    if (webFoundValue.startsWith("=")) {
                                                        currentCell.setCellFormula(webFoundValue.substring(1));
                                                        FormulaEvaluator evaluator = currentCell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
                                                        currentCell.setCellStyle(getBlueUnderlinedCellStyle(workbook));
                                                        evaluator.evaluateFormulaCell(currentCell);
                                                    } else {
                                                        currentCell.setCellValue(webFoundValue);
                                                    }
                                                }
                                                break;
                                            case FORMULA:
                                                cellValue = currentCell.getCellFormula();
                                                if (cellValue.length() < 1 || cellValue == null) {
                                                    if (webFoundValue.startsWith("=")) {
                                                        currentCell.setCellFormula(webFoundValue.substring(1));
                                                        FormulaEvaluator evaluator = currentCell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
                                                        currentCell.setCellStyle(getBlueUnderlinedCellStyle(workbook));
                                                        evaluator.evaluateFormulaCell(currentCell);
                                                    } else {
                                                        currentCell.setCellValue(webFoundValue);
                                                    }
                                                }
                                                break;
                                            default:
                                                if (cellValue.length() < 1 || cellValue == null) {
                                                    if (webFoundValue.startsWith("=")) {
                                                        currentCell.setCellFormula(webFoundValue.substring(1));
                                                        FormulaEvaluator evaluator = currentCell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
                                                        currentCell.setCellStyle(getBlueUnderlinedCellStyle(workbook));
                                                        evaluator.evaluateFormulaCell(currentCell);
                                                    } else {
                                                        currentCell.setCellValue(webFoundValue);
                                                    }
                                                }
                                                /*  missing values for 
                                                "MajorsAvailable"

                                                URLMapLinkFriendly
                                                URLCollegeBoardFriendly
                                                UniverURLfriendly
                                                schoolTypeByDesignation
                                                */
                                                break;
                                        }
                                    // print values from University object and matching columns in the file
                                    //System.out.print("| Row: " + rowIndex + " | ColumnID : " + cID + " | "+ cellValue + " |\n");
                                    } catch (NullPointerException e) {
                                        System.out.println("Unhandled cell type found at row: " + rowIndex + " | ColumnID :" + cID + " | " + e + "\n");
                                        //break;
                                    } 
                        }
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        //e.printStackTrace();
                        // System.out.println("writeExcelFile: "+'"' + mName + '"' +" method not found!");
                    }                 
                }
        // Write changes to the file
        try (FileOutputStream fos = new FileOutputStream(mFile)) {
            workbook.write(fos);
            //System.out.println("ReadFile: File updated and Excel file saved successfully.");
            //mapHeader(sheetName, excelFile);
        }catch (IOException e) {
            e.printStackTrace();
            }
        workbook.close();
        fileIn.close();
        System.out.println("File successfully updated: " + excelFile);
    } catch (IOException e) {
        e.printStackTrace();
    } 
    }
    public static CellStyle getBlueUnderlinedCellStyle(Workbook workbook) {
        // Create a new font in the workbook
        Font font = workbook.createFont();
        font.setColor(IndexedColors.BLUE.getIndex()); // Set font color to blue
        font.setUnderline(Font.U_SINGLE); // Set underline (optional)

        // Create a cell style and set the font
        CellStyle style = workbook.createCellStyle();
        style.setFont(font);

        return style;
    }
}