package co.com.metro.civicaweb.utils;

import co.com.metro.civicaweb.data.querys.QueryMos_ID;
import co.com.metro.civicaweb.utils.ExcelDelete.ExcelDeleteSuccessful;
import co.com.metro.civicaweb.utils.ExcelReload.ExcelRechargeSuccessful;

public class Main {

    public static void main(String[] args) {

        ExcelRechargeSuccessful.createExcelRechargeSuccessful(4500,"RECARGA 4500 QA");
        //ExcelDeleteSuccessful.createExcelDeleteSuccessful(10,"ARCH_ELIMINACION_CON_10_REG_DEV");


    }
}
