package co.com.metro.civicaweb.data.querys;

import co.com.metro.civicaweb.data.QueryResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static co.com.metro.civicaweb.utils.Constant.OSI_ID;

public class QueryObservationsField {
    private static List<Map<String, Object>> result;
    public static Date DATE = new Date();
    public static SimpleDateFormat DATE_SDF2 = new SimpleDateFormat("dd/MM/yy");
    public static final String DATE_FORMAT2 = DATE_SDF2.format(DATE);


    public static boolean query(String observation) {

        result = QueryResult.queryResult("SELECT LENGTH(ARE_OBSERVACION) as VALOR1 FROM METRO.AUDITORIA_RECARGA_EXTERNA WHERE OSI_ID= " + OSI_ID +
                " AND ARE_OBSERVACION LIKE '%" + observation + "%' ");

        int text = Integer.parseInt(result.get(0).get("VALOR1").toString());
        boolean res;

        if (text < 254) {
            res = true;

        }else{
            res = false;
        }

        return res;

    }

}
