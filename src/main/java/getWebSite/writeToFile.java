package getWebSite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeToFile {
    // Your code here

    public static void writToExcell(University[] universityData,String excelFilePath) {
        // Write universityData to Excel file
        File file = new File(excelFilePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileOutputStream fileOut = new FileOutputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook()) {
            workbook.createSheet("University Data");
            Sheet sheet = workbook.getSheet("University Data");
            int rowNum = 0;
            Row headerRow = sheet.createRow(rowNum++);
            Field[] fields = University.class.getDeclaredFields();
            int cellNum = 0;
            for (Field field : fields) {
                headerRow.createCell(cellNum++).setCellValue(field.getName());
            }
            // Set the column names using class variable names
            // Example: headerRow.createCell(cellNum++).setCellValue("UniverName");
            for (University university : universityData) {
                Row row = sheet.createRow(rowNum++);
                cellNum = 0;
                Field[] dataFields = university.getClass().getDeclaredFields();
                for (Field dataField : dataFields) {
                    row.createCell(cellNum++).setCellValue(dataField.get(university).toString());
                }
                // Example: row.createCell(cellNum++).setCellValue(university.getUniverName());
            }
            workbook.write(fileOut);
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
