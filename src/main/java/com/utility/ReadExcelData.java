package com.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

    public static String readParticularData(int rowValue, int columnValue) {

        String data = null;   // declare outside try

        try {
            File file = new File("C:\\Users\\91842\\Downloads\\DataDriven_IPT.xlsx");
            FileInputStream fis = new FileInputStream(file);

            Workbook book = new XSSFWorkbook(fis);
            Sheet sheet = book.getSheet("Sheet1");

            Row row = sheet.getRow(rowValue);
            Cell cell = row.getCell(columnValue);

            DataFormatter dataFormat = new DataFormatter(); // converts any type to String
            data = dataFormat.formatCellValue(cell);

            System.out.println(data);

            book.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
