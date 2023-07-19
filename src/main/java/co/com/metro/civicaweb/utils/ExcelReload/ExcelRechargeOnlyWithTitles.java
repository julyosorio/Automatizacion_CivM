package co.com.metro.civicaweb.utils.ExcelReload;

import co.com.metro.civicaweb.utils.CreateExcelXLS;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static co.com.metro.civicaweb.utils.Constant.LIST;

public class ExcelRechargeOnlyWithTitles {

    public static void createExcelRechargeOnlyWithTitles(String fileName) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();

        ArrayList<String> columnTitles = LIST();

        Map<String, Object> list = new TreeMap<>();
        list.put("CAR_ID", "");
        list.put("SES_ID", "");
        list.put("VALOR_RECARGA", "");
        list.put("SALDO_RECARGA", "");
        list.put("FECHA_RECARGA", "");
        list.put("FECHA_RECARGA", "");

        List<Map<String, Object>> registerList = new ArrayList<>();
        registerList.add(list);


        inputFile.createExcelDB(fileName, columnTitles, registerList);


    }
}
