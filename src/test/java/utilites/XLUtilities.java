package utilites;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XLUtilities {
    private final String path;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;
    public XLUtilities(String path){
        this.path=path;
    }
    public int getRowCount(String sheetName) {
        try {
            fileInputStream =new FileInputStream(path);
            workbook=new XSSFWorkbook(fileInputStream);
            sheet= workbook.getSheet(sheetName);
            int row=sheet.getLastRowNum();
            workbook.close();
            fileInputStream.close();
            return row;
        } catch (IOException e) {
//            logger.error(e.getMessage());
        }
        return -1;
    }
    public int getCellCount(String sheetName, int rowNumber)  {
        try {
            fileInputStream =new FileInputStream(path);
            workbook=new XSSFWorkbook(fileInputStream);
            sheet= workbook.getSheet(sheetName);
            int cell=sheet.getRow(rowNumber).getLastCellNum();
            workbook.close();
            fileInputStream.close();
            return cell;
        } catch (IOException e) {
//            logger.error(e.getMessage());
        }
        return -1;
    }
    public Object getCellData(String sheetName,int rowNumber,int columNumber)  {
        try {
            fileInputStream =new FileInputStream(path);
            workbook=new XSSFWorkbook(fileInputStream);
            sheet= workbook.getSheet(sheetName);
            Object datum =sheet.getRow(rowNumber).getCell(columNumber);
            workbook.close();
            fileInputStream.close();
            return datum;
        } catch (IOException e) {
//            logger.error(e.getMessage());
        }
        return -1;
    }
    public Object[][] getAllData(String sheetName) {
        Object[][] data = null;
        try {
            fileInputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int cellCount = sheet.getRow(0).getLastCellNum();
            List<Object[]> validData = new ArrayList<>();
            for (int i = 1; i <= rowCount; i++) {
                row = sheet.getRow(i);
                if (row != null && !isRowBlank(row, cellCount)) {
                    Object[] rowData = new Object[cellCount];
                    for (int j = 0; j < cellCount; j++) {
                        cell = row.getCell(j);
                        if (cell != null) {
                            rowData[j] = getCellValueAsString(cell);
                        } else {
                            rowData[j] = "";
                        }
                    }
                    validData.add(rowData);
                }
            }
            data = new Object[validData.size()][cellCount];
            for (int i = 0; i < validData.size(); i++) {
                data[i] = validData.get(i);
            }

        } catch (IOException e) {
            // Handle exceptions
            // logger.error("Error reading Excel file: " + e.getMessage());
        } finally {
            try {
                // Close resources
                if (fileInputStream != null) fileInputStream.close();
                if (workbook != null) workbook.close();
            } catch (IOException e) {
                // logger.error("Error closing resources: " + e.getMessage());
            }
        }
        return data;
    }

    private boolean isRowBlank(Row row, int cellCount) {
        for (int i = 0; i < cellCount; i++) {
            Cell cell = row.getCell(i);
            String cellValue = (cell != null) ? getCellValueAsString(cell) : "";
            if (!cellValue.trim().isEmpty()) {
                return false; // The row has at least one non-empty cell
            }
        }
        return true;
    }

    private String getCellValueAsString(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula(); // Handle formulas
            case BLANK, default -> ""; // Handle empty or unexpected cell types
        };
    }


    public Object[][] getAllData(int index){
        Object[][] data=null;
        try {
            fileInputStream = new FileInputStream(path);
            workbook =new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheetAt(index);
            int rowCount = sheet.getLastRowNum();
            int cellCount =sheet.getRow(0).getLastCellNum();
            data = new String[rowCount][cellCount];
            for (int i=1;i<=rowCount;i++){
                row=sheet.getRow(i);
                for (int j=0;j<cellCount;j++) {
                    if (row!=null){
                        cell=row.getCell(j);
                        if (cell!=null){
                            switch (cell.getCellType()) {
                                case STRING -> data[i - 1][j] = cell.getStringCellValue();
                                case NUMERIC -> data[i - 1][j] = cell.getNumericCellValue();
                                case BOOLEAN -> data[i - 1][j] = cell.getBooleanCellValue();
                                default -> data[i - 1][j] = "";
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
//            logger.error(e.getMessage());
        }
        return data;
    }

    /**
     * TODO
     * @param sheetName
     */
    private void setCellData(String sheetName){

    }

    public Object[] getRowValues(int rowNumber,String sheetName) {
        Object[] output=null;
        try {
        workbook=new XSSFWorkbook(fileInputStream);
        sheet= workbook.getSheet(sheetName);
        row= sheet.getRow(rowNumber);
        output=new Object[row.getLastCellNum()];
        for (int i=0;i<row.getLastCellNum();i++){
            cell = row.getCell(i);
            if (cell != null) {
                try {
                    switch (cell.getCellType()) {
                        case STRING -> output[i] = cell.getStringCellValue();
                        case NUMERIC -> output[i] = cell.getNumericCellValue();
                        case BOOLEAN -> output[i] = cell.getBooleanCellValue();
                        case FORMULA -> output[i] = cell.getCellFormula();
                        default -> output[i] = "";
                    }
                } catch (IllegalArgumentException e) {
                    output[i] = "";
                }
            } else {
                output[i] = "";
            }
        }}
        catch (Exception e){
            e.getMessage();
        }
        return output;
    }

}
