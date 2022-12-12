package com.example.egorov;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Dannie {
    public ArrayList<String> AvtoIBenz() throws IOException {
        ArrayList<String> Vse = new ArrayList<String>();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\mihai\\OneDrive\\Desktop\\numbz.xls");
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        for (Row row : workbook.getSheetAt(0)) {
            for (Cell cell : row) {
                Vse.add(getCellText(cell).toString());
            }
        }
        fileInputStream.close();
        return Vse;
    }
    public Double Rushet(Double rast, Double rashod){
        Double benz = rast*(rashod/100);
        return benz;

    }
    public static String getCellText(Cell cell) {
        String result = null;
        switch (cell.getCellType()) {
            case STRING:
                result = (cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = cell.getDateCellValue().toString();
                } else {
                    result = Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                result=Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                result = cell.getCellFormula().toString();
                break;
            default:
                break;
        }
        return result;
    }
}
