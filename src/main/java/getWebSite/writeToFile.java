package getWebSite;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
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
        universityData[0].setCollegeBoardCode("=HYPERLINK(\"https://bigfuture.collegeboard.org/colleges/university-of-california-davis\",\"4834\")");
        universityData[0].setURLCollegeBoard("https://bigfuture.collegeboard.org/colleges/university-of-california-davis");
               String path = "./data/";
        String excelFile2Read = "myUniverData2024.xlsx";
        String sheetName = "wu";
        //writeToFile.writToExcell(universityData, fullFilePath);
        //writeExcelFile(path + excelFile2Read, sheetName, universityData);
    }
    private static void mapHeader(String sheetName, String excelFile) {
        //System.out.println("mapHeader excelFile..." + excelFile + " sheetName: " + sheetName);
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
            Row hRow = null;
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
                String cellValue = "";
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
                Integer col = null;
                String fieldName = field.getName();
                col = getColmnID(fieldName);
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
                System.out.println("Header row updated and Excel file saved successfully.");
                mapHeader(sheetName, excelFile);
            }catch (IOException e) {
                e.printStackTrace();
             }
    
        }
            /* print header columns with IDs
            String header = "| ";
            for (columnMap cR : columnMap) {
                header = header + cR.getColumnIndex() +":" +cR.getCellAddress() + " " + cR.getFileColmName() + " | ";
            }
            // print header columns with IDs
            System.out.println(header);
            */
    
        }   catch (IOException ex) {
        }
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
    private static Integer findInFile (University uD, Sheet sh) {
        String collegeBoardCode = uD.getCollegeBoardCode();
        String univerName = uD.getUniverName();

        // find if univercity is already in the file
        Integer rowID = null;
        Integer colIDCB = getColmnID("CollegeBoardCode");
        Integer colIDuName = getColmnID("UniverName");
        //System.out.println("findInFile: collegeBoardCode Column ID: " + colID);
        Integer rowCount = sh.getPhysicalNumberOfRows();
        for (int i = 1; i < rowCount; i++) {
            Row row = sh.getRow(i);
            Cell currentCBID = row.getCell(colIDCB);
            Cell currentUName = row.getCell(colIDuName);
            String cellValueCB = ""; // College Board Code from the file
            String cellValueUName = ""; // University Name from the file
            try { // get College Board Code from the file
            switch (currentCBID.getCellType()) {
                case STRING:
                    cellValueCB = currentCBID.getStringCellValue();
                    break;
                case NUMERIC:
                    cellValueCB= String.valueOf(Math.round(currentCBID.getNumericCellValue()));
                    break;
                case BOOLEAN:
                     cellValueCB = String.valueOf(currentCBID.getBooleanCellValue());
                    break;
                case FORMULA:
                    cellValueCB = currentCBID.getCellFormula();
                    break;
                default:
                    cellValueCB = "";
                    break;
            }
            if (cellValueCB.toLowerCase().contains("not available")) {
                cellValueCB = "";
            }
            //System.out.println("findInFile: currentCBID: " + currentCBID);
            } catch (NullPointerException e) {
             //System.out.println("findInFile: " + collegeBoardCode + " collegeBoardCode not foud in the file!");
            }
            try { // get University Name from the file
                switch (currentUName.getCellType()) {
                    case STRING:
                        cellValueUName = currentUName.getStringCellValue();
                        break;
                    case FORMULA:
                        cellValueUName = currentUName.getCellFormula();
                        break;
                    default:
                        cellValueUName = "";
                        break;
                }
            } catch (NullPointerException e) {
                //System.out.println("findInFile: " + univerName + " University Name not foud in the file!");
            }
        // clean and compare values
        String cleanCellValueCB = cellValueCB.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // remove all non umberic and letter characters
            //System.out.println("findInFile: cleanCellValueCB: " + cleanCellValueCB);
        String cleanCollegeBoardCode = collegeBoardCode.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // remove all non umberic and letter characters   
            //System.out.println("findInFile: cleanCollegeBoardCode: " + cleanCollegeBoardCode);
        String cleanUniverName = univerName.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // remove all non umberic and letter characters
            //System.out.println("findInFile: cleanUniverName: " + cleanUniverName);  
        String cleranCellValueUName = cellValueUName.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // remove all non umberic and letter characters
            //System.out.println("findInFile: cleranCellValueUName: " + cleranCellValueUName);

        if (cleanCellValueCB.contains(cleanCollegeBoardCode) && cleanCellValueCB.length()>0 && cleanCollegeBoardCode.length()>0) {
            rowID = row.getRowNum();
            //System.out.println("findInFile: CollegeBoardCode found at Row ID: " + rowID);
            break;
        }else if (cleanCollegeBoardCode.contains(cleanCellValueCB) && cleanCellValueCB.length()>0 && cleanCollegeBoardCode.length()>0) {
            rowID = row.getRowNum();
            //System.out.println("findInFile: CollegeBoardCode found at Row ID: " + rowID); 
            break;
        } else if (cleanUniverName.contains(cleranCellValueUName) && cleanUniverName.length()>0 && cleranCellValueUName.length()>0){
            rowID = row.getRowNum();
            //System.out.println("findInFile: University Name found at Row ID: " + rowID);
            break;
        } else if (cleranCellValueUName.contains(cleanUniverName) && cleanUniverName.length()>0 && cleranCellValueUName.length()>0) {
            rowID = row.getRowNum();
            //System.out.println("findInFile: University Name found at Row ID: " + rowID);
            break;
        }
     }
     return rowID;
    }
    private static Integer getPhysicalNumberOfRows(String excelFile, String sheetName) {
        Integer rowCount = 0;
        try (FileInputStream fis = new FileInputStream(excelFile)){
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sh = workbook.getSheet(sheetName);
            rowCount = sh.getPhysicalNumberOfRows();
            workbook.close();
        } catch (IOException e) {
            System.out.println("getPhysicalNumberOfRows: Unable to read worksheet: " + sheetName + " in the file: " + excelFile);
        }
        return rowCount;
    }

    public static University[] readExcelFile (String excelFile, String sheetName) {
        mapHeader(sheetName, excelFile); 
        University[] univerData = new University[getPhysicalNumberOfRows(excelFile, sheetName)-1]; // -1 to skip header row
        //System.out.println("univerData: rowscount" + univerData.length);
        try {
            FileInputStream fileIn = new FileInputStream(excelFile);
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sh = workbook.getSheet(sheetName);
            Integer univerNameColmID = getColmnID("UniverName");
            Integer URLCollegeBoardColmID = getColmnID("URLCollegeBoard");

            Integer rowIndex = 1; // Index of the first data row. Skipp row 0 - header
            // read the each row in the file
            while (rowIndex < sh.getPhysicalNumberOfRows()) {
                Row currentRow = sh.getRow(rowIndex);
                Cell  univerNameCell = currentRow.getCell(univerNameColmID);
                Cell  URLCollegeBoardCell = currentRow.getCell(URLCollegeBoardColmID);

                // get univerName from the file
                String UniverName = "";
                switch (univerNameCell.getCellType()) {
                    case STRING:
                        UniverName = univerNameCell.getStringCellValue();
                        break;
                    case FORMULA:
                        UniverName = univerNameCell.getCellFormula();
                        break;
                    default:
                        UniverName = "";
                        break;
                }
               
                // get URLCollegeBoard from the file
                String URLCollegeBoard = "";
                switch (URLCollegeBoardCell.getCellType()) {
                    case STRING:
                         URLCollegeBoard = URLCollegeBoardCell.getStringCellValue();
                        break;
                    case FORMULA:
                        URLCollegeBoard = URLCollegeBoardCell.getCellFormula();
                        break;
                    default:
                        URLCollegeBoard = "";
                        break;
                }
                // add values to the University object

                Integer univerDataInx = rowIndex-1;// -1 to skip header row
                univerData[univerDataInx] = new University(UniverName, URLCollegeBoard);
                System.out.println("Row: " + univerDataInx + " | " + univerData[univerDataInx].getUniverName() + " | " + univerData[univerDataInx].getURLCollegeBoard() + " |");
                rowIndex++;
            }   
            workbook.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return univerData;
    }
    public static void writeExcelFile(String excelFile, String sheetName, University[] universityData){
                    
            //ieterate trough each university from webscrabing
            for (University university : universityData) {
                writeToFile.writeExcelFile(excelFile, sheetName, university);
            }
    }

    public static void writeExcelFile(String excelFile, String sheetName, University uD) {
        mapHeader(sheetName, excelFile); 
        try {
            FileInputStream fileIn = new FileInputStream(excelFile);
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sh = workbook.getSheet(sheetName);
            //System.out.println("Sheet name: " + sh.getSheetName());
            Integer rowIndex = 1; // Index of the first data row

                // get university ID in the file, if exists
                Integer univerRowID = findInFile(uD, sh);
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
                        cID = getColmnID(fName);      
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
        try (FileOutputStream fos = new FileOutputStream(excelFile)) {
            workbook.write(fos);
            workbook.close();
            //System.out.println("ReadFile: File updated and Excel file saved successfully.");
            mapHeader(sheetName, excelFile);
        }catch (IOException e) {
            e.printStackTrace();
            }
            // read the each row in the file
            /*
            while (rowIndex < sh.getPhysicalNumberOfRows()) {
                Row currentRow = sh.getRow(rowIndex);
                Integer phisicalRowNumber = rowIndex+1;
                Cell currentCell = currentRow.getCell(0);
                String cellValue = "";
                switch (currentCell.getCellType()) {
                    case STRING:
                        cellValue = currentCell.getStringCellValue();
                        break;
                    case NUMERIC:
                        cellValue = String.valueOf(currentCell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        cellValue = String.valueOf(currentCell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        cellValue = currentCell.getCellFormula();
                        break;
                    default:
                        cellValue = "";
                        break;
                }
                if (currentCell.getCellType() == CellType.BLANK) {
                    //System.out.println("Unclonw cell type found at row: " + phisicalRowNumber);
                    //break;
                } else {
                    //System.out.print("Row: " + phisicalRowNumber + "| "+ cellValue + " |\n");
                }
                rowIndex++;
            } 
            */
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