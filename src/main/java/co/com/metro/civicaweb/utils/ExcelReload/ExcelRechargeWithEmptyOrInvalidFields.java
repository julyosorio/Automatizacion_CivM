package co.com.metro.civicaweb.utils.ExcelReload;

import co.com.metro.civicaweb.data.QueryResult;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.com.metro.civicaweb.utils.Constant.*;

public class ExcelRechargeWithEmptyOrInvalidFields {

    public static void createExcelRechargeWithEmptyOrInvalidFields(int numberOfRecords, String fileName, String field1, String field2) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();

        ArrayList<String> columnTitles = LIST();

        List<Map<String, Object>> registerList;
        registerList = QueryResult.queryResult("SELECT " +field1+ " FROM METRO.CARTAO A JOIN METRO.MOVIMENTO_SESSAO B ON A.MOS_ID = B.MOS_ID FETCH FIRST " + numberOfRecords + " ROWS ONLY");

        for (int i = 0; i < numberOfRecords; i++) {
            if (i % 2 == 0) {
                registerList.get(i).put(field2, "");
                registerList.get(i).put("VALOR3", VALUE);
                registerList.get(i).put("VALOR4", "$" + BALANCE);
                registerList.get(i).put("VALOR5", "");
                registerList.get(i).put("VALOR6", HOUR_FORMAT);

                VALUE = VALUE + 255;
                BALANCE = BALANCE + 63;
            } else {
                registerList.get(i).put(field2, NUM_RANDOM + "METRO*");
                registerList.get(i).put("VALOR3", VALUE);
                registerList.get(i).put("VALOR4", BALANCE);
                registerList.get(i).put("VALOR5", DATE_FORMAT);
                registerList.get(i).put("VALOR6", "10:00AM");
                VALUE = VALUE + 255;
                BALANCE = BALANCE + 63;
            }
        }
        inputFile.createExcelDB(fileName, columnTitles, registerList);

    }
}
