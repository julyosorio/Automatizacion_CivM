package co.com.metro.civicaweb.utils.ExcelReload;

import co.com.metro.civicaweb.utils.CreateExcelXLS;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.*;

public class ExcelEmpty {

    public static void createExcelEmpty(String fileName) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();

        ArrayList<String> columnTitles = new ArrayList<>();
        columnTitles.add("");

        Map<String, Object> list = new TreeMap<>();
        list.put("MOS_ID", "");
        List<Map<String, Object>> registerList = new ArrayList<>();
        registerList.add(list);

        inputFile.createEmptyExcel(fileName);

    }


}
