package fileIO;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dataObjects.University;
import static fileIO.getPhysicalNumberOfRows.getRowCount;
import static fileIO.mapHeader.getColmnID;

public class readFile {
        public static University[] readExcelFile (String excelFilePath, String sheetName) {
        University[] univerData = new University[getRowCount(excelFilePath, sheetName)-1]; // -1 to skip header row
        //System.out.println("univerData: rowscount" + univerData.length);
        ZipSecureFile.setMinInflateRatio(0.0001);
        try {
            FileInputStream fileIn = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(fileIn);
            Sheet sh = workbook.getSheet(sheetName);
            Integer univerNameColmID = getColmnID("UniverName",sh);
            Integer URLCollegeBoardColmID = getColmnID("URLCollegeBoard",sh);

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
                try {
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
                } catch (Exception e) {
                    
                    System.err.println("readFile.readExcelFile: Unable to read value of URLCollegeBoard!");
                }
                // add values to the University object

                Integer univerDataInx = rowIndex-1;// -1 to skip header row
                univerData[univerDataInx] = new University(UniverName, URLCollegeBoard);
                //System.out.println("UniverDataRow: " + univerDataInx + " | " + univerData[univerDataInx].getUniverName() + " | " + univerData[univerDataInx].getURLCollegeBoard() + " |");
                rowIndex++;
            }   
            workbook.close();
            fileIn.close();
        } catch (IOException e) {
           System.err.println("Exception occurred in readFile.readExcelFile: " + e.getMessage());
        }
        return univerData;
    }
}
