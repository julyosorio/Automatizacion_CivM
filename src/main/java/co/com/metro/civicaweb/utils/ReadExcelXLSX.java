package co.com.metro.civicaweb.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static co.com.metro.civicaweb.utils.Constant.DATE_SDF4;
import static co.com.metro.civicaweb.utils.Constant.DATE_SDF5;

public class ReadExcelXLSX {


    public static List<Map<String, Object>> readExcelXLS(String path, int numRow) {
        List<Map<String, Object>> list = new ArrayList<>();

        try {
            String filePath = path;
            FileInputStream inputStream = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Row> iteratorRow = sheet.iterator();
            Row row;
            int headerStart = numRow;
            int count = 1;
            while (iteratorRow.hasNext()) {
                iteratorRow.next();
                count++;
                if (headerStart == count) {
                    break;
                }
            }

            while (iteratorRow.hasNext()) {
                Map<String, Object> listRow = new TreeMap<>();
                row = iteratorRow.next();
                Iterator<Cell> iteratorCell = row.cellIterator();
                Cell cell;
                String type = "";
                Object content = null;
                while (iteratorCell.hasNext()) {
                    cell = iteratorCell.next();
                    type = cell.getCellType().toString();
                    int format = cell.getCellStyle().getDataFormat();

                    if ((type != "BLANK" && type != "STRING") && (format == 164)) {
                        content = cell.getLocalDateTimeCellValue();
                        String formatDate = content.toString().length()>16?"yyyy-MM-dd HH:mm:ss":"yyyy-MM-dd HH:mm";
                        Date date = new SimpleDateFormat(formatDate).parse(content.toString().replace('T', ' '));
                        String newDate = DATE_SDF4.format(date);
                        content = newDate;

                    } else if ((type != "BLANK" && type != "STRING") && (format == 165)) {
                        content = cell.getLocalDateTimeCellValue();
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(content.toString());
                        String newDate = DATE_SDF5.format(date);
                        content = newDate;
                    } else {
                        switch (type) {
                            case "STRING":
                                content = cell.getStringCellValue();
                                break;
                            case "NUMERIC":
                                content = cell.getNumericCellValue();
                                break;
                            case "DATE":
                                content = cell.getDateCellValue();
                                break;
                            case "BLANK":
                                content = cell.getStringCellValue();
                                break;
                        }
                    }

                    String key = String.valueOf(cell.getColumnIndex());
                    listRow.put("VALOR" + key, content);
                }
                list.add(listRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
