package co.com.metro.civicaweb.utils.ExcelReload;

import co.com.metro.civicaweb.data.querys.QueryTransactionActiveStatus;
import co.com.metro.civicaweb.utils.CreateExcelXLS;
import co.com.metro.civicaweb.utils.CreateExcelXLSX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static co.com.metro.civicaweb.utils.Constant.LIST;

public class ExcelRechargeTransactionActiveStatus {

    public static void createExcelRechargeTransactionActiveStatus(int numberOfRecords, String fileName) {
        CreateExcelXLSX inputFile = new CreateExcelXLSX();

        ArrayList<String> columnTitles = LIST();

        List<Map<String, Object>> registerList= QueryTransactionActiveStatus.query(numberOfRecords);

        for (int i = 0; i < numberOfRecords; i++) {

            Object dateObject = registerList.get(i).get("VALOR5");
            String yearString = String.valueOf(dateObject);
            String monthString = String.valueOf(dateObject);
            String dayString = String.valueOf(dateObject);
            String hourString = String.valueOf(dateObject);
            yearString = yearString.substring(0, 4);
            monthString = monthString.substring(5,7);
            dayString= dayString.substring(8,10);
            String dateString = dayString+"/"+monthString+"/"+yearString;
            hourString = hourString.substring(11, 19);

            registerList.get(i).put("VALOR5", dateString);
            registerList.get(i).put("VALOR6", hourString);

        }

        inputFile.createExcelDB(fileName, columnTitles, registerList);

    }
}
