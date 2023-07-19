package co.com.metro.civicaweb.utils.ExcelReload;

import co.com.metro.civicaweb.data.querys.QueryCar_idSes_id;
import co.com.metro.civicaweb.utils.CreateExcelXLS;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.com.metro.civicaweb.utils.Constant.*;

public class ExcelRechargeTitlesInDisorder {

    public static void createExcelRechargeTitlesInDisorder(int numberOfRecords, String fileName) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();

        ArrayList<String> columnTitles = new ArrayList<>();
        columnTitles.add("CAR_ID");
        columnTitles.add("VALOR_RECARGA");
        columnTitles.add("SESION");
        columnTitles.add("HORA_RECARGA");
        columnTitles.add("SALDO_ANTERIOR");
        columnTitles.add("FECHA_RECARGA");


        List<Map<String, Object>> registerList;
        registerList = QueryCar_idSes_id.query(numberOfRecords);

        for (int i = 0; i < numberOfRecords; i++) {
            registerList.get(i).put("VALOR3", VALUE);
            registerList.get(i).put("VALOR4", BALANCE);
            registerList.get(i).put("VALOR5", DATE_FORMAT);
            registerList.get(i).put("VALOR6", HOUR_FORMAT);

            VALUE = VALUE + 255;
            BALANCE = BALANCE + 63;
        }

        inputFile.createExcelDB(fileName, columnTitles, registerList);


    }
}
