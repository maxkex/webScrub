package fileIO;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getPhysicalNumberOfRows {
        public static Integer getRowCount(String excelFile, String sheetName) {
        Integer rowCount = 0;
        ZipSecureFile.setMinInflateRatio(0.0001);
        try (FileInputStream fis = new FileInputStream(excelFile)){
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sh = workbook.getSheet(sheetName);
            rowCount = sh.getPhysicalNumberOfRows();
            workbook.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("getPhysicalNumberOfRows: Unable to read worksheet: " + sheetName + " in the file: " + excelFile);
        }
        return rowCount;
    }
}
