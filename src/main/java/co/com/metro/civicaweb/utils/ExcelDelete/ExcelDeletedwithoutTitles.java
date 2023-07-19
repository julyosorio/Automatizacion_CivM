package co.com.metro.civicaweb.utils.ExcelDelete;

import co.com.metro.civicaweb.data.QueryResult;
import co.com.metro.civicaweb.data.querys.QueryMos_ID;
import co.com.metro.civicaweb.utils.CreateExcelXLS;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.List;
import java.util.Map;

public class ExcelDeletedwithoutTitles {
    public static void createExcelDeletedwithoutTitles(int numberOfRecords, String fileName) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();


        List<Map<String, Object>> registerList;
        registerList = QueryMos_ID.query(numberOfRecords);

        inputFile.createExcelWithoutTitles(fileName, registerList);


    }
}
