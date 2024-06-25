package fileIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import dataObjects.University;
import static fileIO.mapHeader.getColmnID;

public class findInSheet {
     public static Integer getRowID (University uD, Sheet sh) {
        String collegeBoardCode = uD.getCollegeBoardCode();
        String univerName = uD.getUniverName();

        // find if univercity is already in the file
        Integer rowID = null;
        Integer colIDCB = getColmnID("CollegeBoardCode", sh);
        Integer colIDuName = getColmnID("UniverName", sh);
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
}
