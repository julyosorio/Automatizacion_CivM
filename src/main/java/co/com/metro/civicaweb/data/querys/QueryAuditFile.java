package co.com.metro.civicaweb.data.querys;

import co.com.metro.civicaweb.data.QueryResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static co.com.metro.civicaweb.utils.Constant.OSI_ID;

public class QueryAuditFile {
    private static List<Map<String, Object>> result;
    private static List<Map<String, Object>> are_id;
    private static List<Map<String, Object>> result2;
    private static List<Map<String, Object>> result3;
    public static Date DATE = new Date();
    public static SimpleDateFormat DATE_SDF2 = new SimpleDateFormat("dd/MM/yy");
    public static final String DATE_FORMAT2 = DATE_SDF2.format(DATE);


    public static List<Map<String, Object>>  queryAuditFile(String observation) {
        System.out.println(DATE_FORMAT2);

        result = QueryResult.queryResult("SELECT * FROM METRO.AUDITORIA_RECARGA_EXTERNA WHERE OSI_ID= " + OSI_ID +
                " AND ARE_OBSERVACION = '"+observation+"' AND TO_DATE(are_fecha,'dd/mm/yy') = '"+DATE_FORMAT2+"'");

        return result;

    }
    
    public static List<Map<String, Object>> queryDetailAuditFile(String observation){

        if (observation==""){

            are_id = QueryResult.queryResult("SELECT * FROM METRO.AUDITORIA_RECARGA_EXTERNA WHERE OSI_ID= " + OSI_ID +
                    " AND ARE_OBSERVACION IS NULL AND TO_DATE(are_fecha,'dd/mm/yy') = '"+DATE_FORMAT2+"'");
        }else{
            are_id = QueryResult.queryResult("SELECT * FROM METRO.AUDITORIA_RECARGA_EXTERNA WHERE OSI_ID= " + OSI_ID +
                    " AND ARE_OBSERVACION = '"+observation+"' AND TO_DATE(are_fecha,'dd/mm/yy') = '"+DATE_FORMAT2+"'");
        }

        result2 = QueryResult.queryResult("SELECT CAR_ID,SES_ID,DARE_VLR_TRAN,DARE_SALDO_ANTERIOR FROM METRO.DETALLE_AUDITORIA_RECARGA_EXTERNA WHERE ARE_ID= "+are_id.get(0).get("ARE_ID")+" ORDER BY CAR_ID");

        return result2;

    }

    public static List<Map<String, Object>> queryDetailAuditFileDelete(String observation){

        if (observation==""){

            are_id = QueryResult.queryResult("SELECT * FROM METRO.AUDITORIA_RECARGA_EXTERNA WHERE OSI_ID= " + OSI_ID +
                    " AND ARE_OBSERVACION IS NULL ");
        }else{
            are_id = QueryResult.queryResult("SELECT * FROM METRO.AUDITORIA_RECARGA_EXTERNA WHERE OSI_ID= " + OSI_ID +
                    " AND ARE_OBSERVACION LIKE '%"+observation+"%'");
        }
        System.out.println("are_id"+are_id);

        result2 = QueryResult.queryResult("SELECT MOS_ID FROM METRO.DETALLE_AUDITORIA_RECARGA_EXTERNA WHERE ARE_ID= "+are_id.get(0).get("ARE_ID")+" ORDER BY CAR_ID");


        System.out.println("queryDetailAuditFileDelete: "+result2);
        return result2;

    }





}
