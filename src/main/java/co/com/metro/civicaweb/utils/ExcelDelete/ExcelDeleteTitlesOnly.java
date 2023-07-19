package co.com.metro.civicaweb.utils.ExcelDelete;

import co.com.metro.civicaweb.utils.CreateExcelXLS;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static co.com.metro.civicaweb.utils.Constant.*;

public class ExcelDeleteTitlesOnly {

    public static void createExcelDeleteTitlesOnly(String fileName) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();

        ArrayList<String> columnTitles = new ArrayList<>();
        columnTitles.add(MOS_ID);

        Map<String, Object> list = new TreeMap<>();
        list.put("MOS_ID", "");

        List<Map<String, Object>> registerList = new ArrayList<>();
        registerList.add(list);

        inputFile.createExcelDB(fileName, columnTitles, registerList);

    }
}
