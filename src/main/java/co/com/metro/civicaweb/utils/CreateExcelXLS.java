package co.com.metro.civicaweb.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateExcelXLS {
    private static int row;
    private static int column;
    private static HSSFWorkbook bookxls = new HSSFWorkbook();
    private static HSSFSheet sheetxls = bookxls.createSheet("Hoja1");
    private static ArrayList<String> titles;
    private static List<Map<String, Object>> registerList;

    public static void createExcelDBXls(String fileName, ArrayList<String> columnTitles, List<Map<String, Object>> register) {

        titles = columnTitles;
        registerList = register;

        HSSFRow titlesRow = sheetxls.createRow(0);
        for (int i = 0; i < titles.size(); i++) {
            String titulo = titles.get(i);
            HSSFCell cell = titlesRow.createCell(i);
            cell.setCellValue(titulo);
            sheetxls.autoSizeColumn(0);

        }
        row = 1;
        registerList.forEach(
                rowValue -> {
                    column = 0;
                    HSSFRow registerFile = sheetxls.createRow(row);
                    rowValue.forEach(
                            (key, value) -> {
                                HSSFCell cell = registerFile.createCell(column++);
                                cell.setCellValue(value.toString());
                            }
                    );
                    sheetxls.autoSizeColumn(row);
                    row++;
                }
        );
        try {
            FileOutputStream file = new FileOutputStream(new File("target/data/" + fileName + ".xls"));
            bookxls.write(file);
            file.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    public static void createEmptyExcelXLS(String fileName) {
        HSSFRow row = sheetxls.createRow(0);
        HSSFCell cell = row.createCell(0);

        try {
            FileOutputStream file = new FileOutputStream(new File("target/data/" + fileName + ".xls"));
            bookxls.write(file);
            file.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }


    public static void createExcelWithoutTitlesXLS(String fileName, List<Map<String, Object>> register) {
        registerList = register;

        row = 0;

        registerList.forEach(
                rowValue -> {
                    column = 0;
                    HSSFRow registerFile = sheetxls.createRow(row);
                    rowValue.forEach(
                            (key, value) -> {
                                HSSFCell cell = registerFile.createCell(column++);
                                cell.setCellValue(value.toString());
                            }
                    );
                    sheetxls.autoSizeColumn(row);
                    row++;
                }
        );
        try {
            FileOutputStream file = new FileOutputStream(new File("target/data/" + fileName + ".xls"));
            bookxls.write(file);
            file.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

}
