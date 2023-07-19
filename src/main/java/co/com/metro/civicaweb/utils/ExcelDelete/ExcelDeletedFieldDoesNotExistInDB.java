package co.com.metro.civicaweb.utils.ExcelDelete;

import co.com.metro.civicaweb.data.QueryResult;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.com.metro.civicaweb.utils.Constant.*;

public class ExcelDeletedFieldDoesNotExistInDB {
    public static void createExcelDeletedFieldDoesNotExistInDB(int numberOfRecords, String fileName) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();

        ArrayList<String> columnTitles = new ArrayList<>();
        columnTitles.add(MOS_ID);

        List<Map<String, Object>> registerList;
        registerList = QueryResult.queryResult("SELECT MOV_ID FROM METRO.MOVIMENTACAO FETCH FIRST " + numberOfRecords + " ROW ONLY");


        inputFile.createExcelDB(fileName, columnTitles, registerList);

    }
}
