package com.vmo.nopcommerce.utils;

import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtil {
    public static final String testDataExcelFileName = "Testdata.xlsx";
    public static String testDataExcelPath = null; //Location of Test data excel file
    private  XSSFWorkbook excelWBook; //Excel WorkBook
    private  XSSFSheet excelWSheet; //Excel Sheet
    private static XSSFCell cell; //Excel cell
    private static XSSFRow row; //Excel row
    public static int rowNumber; //Row Number
    public static int columnNumber; //Column Number

    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
    @SneakyThrows
    public void setExcelFileSheet(String sheetName) {
        testDataExcelPath = "src/test/resources/";
        // Open the Excel file
        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
    }

    //This method reads the test data from the Excel cell.
    //We are passing row number and column number as parameters.
    public String getCellData(int RowNum, int ColNum) {
        cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    //This method takes row number as a parameter and returns the data of given row number.
    public XSSFRow getRowData(int RowNum) {
        row = excelWSheet.getRow(RowNum);
        return row;
    }


    //This method gets excel file, row and column number and set a value to the that cell.
    @SneakyThrows
    public void setCellData(String value, int RowNum, int ColNum) {
        row = excelWSheet.getRow(RowNum);
        cell = row.getCell(ColNum);
        if (cell == null) {
            cell = row.createCell(ColNum);
            cell.setCellValue(value);
        } else {
            cell.setCellValue(value);
        }
        // Constant variables Test Data path and Test Data file name
        FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    public Object[][] data(){
        int rowCount = excelWSheet.getLastRowNum();
        int cellCount = excelWSheet.getRow(rowCount).getLastCellNum();
        Object[][] data1 = new Object[rowCount][cellCount];
        for (int i=0; i<=rowCount; i++){
            for (int j= 0; j<=cellCount; j++){
                data1[i][j] = excelWSheet.getRow(i).getCell(j).getStringCellValue();

            }
        }
        return data1;
    }
}
