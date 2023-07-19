package co.com.metro.civicaweb.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateExcelXLSX {
    private static int row;
    private static int column;
    private static XSSFWorkbook book = new XSSFWorkbook();
    private static Sheet sheet = book.createSheet("Hoja1");
    private static ArrayList<String> titles;
    private static List<Map<String, Object>> registerList;

    public static void createExcelDB(String fileName, ArrayList<String> columnTitles, List<Map<String, Object>> register) {

        titles = columnTitles;
        registerList = register;

        Row titlesRow = sheet.createRow(0);
        for (int i = 0; i < titles.size(); i++) {
            String titulo = titles.get(i);
            Cell cell = titlesRow.createCell(i);
            cell.setCellValue(titulo);
            sheet.autoSizeColumn(0);
        }
        row = 1;
        registerList.forEach(
                rowValue -> {
                    column = 0;
                    Row registerFile = sheet.createRow(row);
                    rowValue.forEach(
                            (key, value) -> {
                                Cell cell = registerFile.createCell(column++);
                                cell.setCellValue(value.toString());
                            }
                    );

                    sheet.autoSizeColumn(row);
                    row++;

                }
        );

        try {
            FileOutputStream file = new FileOutputStream(new File("target/data/" + fileName + ".xlsx"));
            book.write(file);
            file.close();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }


    }

    public static void createEmptyExcel(String fileName) {
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);

        try {
            FileOutputStream file = new FileOutputStream(new File("target/data/" + fileName + ".xlsx"));

            book.write(file);
            file.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    public static void createExcelWithoutTitles(String fileName, List<Map<String, Object>> register) {
        registerList = register;

        row = 0;

        registerList.forEach(
                rowValue -> {
                    column = 0;
                    Row registerFile = sheet.createRow(row);
                    rowValue.forEach(
                            (key, value) -> {
                                Cell cell = registerFile.createCell(column++);
                                cell.setCellValue(value.toString());
                            }
                    );

                    sheet.autoSizeColumn(row);
                    row++;
                }
        );
        try {
            FileOutputStream file = new FileOutputStream(new File("target/data/" + fileName + ".xlsx"));

            book.write(file);
            file.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

}
