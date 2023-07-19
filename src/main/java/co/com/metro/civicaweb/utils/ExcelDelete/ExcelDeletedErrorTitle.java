package co.com.metro.civicaweb.utils.ExcelDelete;

import co.com.metro.civicaweb.data.QueryResult;
import co.com.metro.civicaweb.data.querys.QueryMos_ID;
import co.com.metro.civicaweb.utils.CreateExcelXLS;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelDeletedErrorTitle {
    public static void createExcelDeletedErrorTitle(int numberOfRecords, String fileName) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();


        ArrayList<String> columnTitles = new ArrayList<>();
        columnTitles.add("#Colmuna#");

        List<Map<String, Object>> registerList;
        registerList = QueryMos_ID.query(numberOfRecords);


        inputFile.createExcelDB(fileName, columnTitles, registerList);


    }
}
