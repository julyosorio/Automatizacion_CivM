package co.com.metro.civicaweb.utils.ExcelDelete;

import co.com.metro.civicaweb.data.QueryResult;
import co.com.metro.civicaweb.data.querys.QueryMos_ID;
import co.com.metro.civicaweb.utils.CreateExcelXLS;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.com.metro.civicaweb.utils.Constant.*;

public class ExcelDeleteAdditionalColumn {
    public static void createExcelDeleteAdditionalColumn(int numberOfRecords, String fileName) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();

        ArrayList<String> columnTitles = new ArrayList<>();
        columnTitles.add(MOS_ID);
        columnTitles.add(ADDITIONAL_COLUMN);

        List<Map<String, Object>> registerList;
        registerList = QueryMos_ID.query(numberOfRecords);
        for (int i = 0; i < numberOfRecords; i++) {
            registerList.get(i).put("VALOR3", NUM_RANDOM * 2);
            NUM_RANDOM++;
        }

        inputFile.createExcelDB(fileName, columnTitles, registerList);

    }
}
