package getWebSite;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellAddress;

public class columnMap {
        private int columnIndex;
        private CellAddress cellAddress;
        private Cell cellObj;
        private String fileColmName;
        private String univerColmID;

    public columnMap() {
    }

    public columnMap(int columnIndex, CellAddress cellAddress, Cell cellObj, String fileColmName, String univerColmID) {
        this.cellAddress = cellAddress;
        this.cellObj = cellObj;
        this.columnIndex = columnIndex;
        this.fileColmName = fileColmName;
        this.univerColmID = univerColmID;
    }

    public Cell getCellObj() {
        return cellObj;
    }

    public void setCellObj(Cell cellObj) {
        this.cellObj = cellObj;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public CellAddress getCellAddress() {
        return cellAddress;
    }

    public void setCellAddress(CellAddress cellAddress) {
        this.cellAddress = cellAddress;
    }

    public String getUniverColmID() {
        return univerColmID;
    }

    public void setUniverColmID(String univerColmID) {
        this.univerColmID = univerColmID;
    }

    public String getFileColmName() {
        return fileColmName;
    }

    public void setFileColmName(String fileColmName) {
        this.fileColmName = fileColmName;
    }

    public void print() {
        System.out.println("Column Index: " + columnIndex);
        System.out.println("Cell Address: " + cellAddress);
        System.out.println("Cell Object: " + cellObj);
        System.out.println("File Column Name: " + fileColmName);
        System.out.println("University Column ID: " + univerColmID);
    }
    public void printLn() {
        System.out.println("|" + columnIndex + "|" + cellAddress + "|"  + cellObj + "|" + fileColmName  + "|" + univerColmID + "|");
    }
}
