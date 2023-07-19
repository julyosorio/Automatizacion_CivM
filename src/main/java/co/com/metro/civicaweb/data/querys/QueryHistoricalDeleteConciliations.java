package co.com.metro.civicaweb.data.querys;

import co.com.metro.civicaweb.data.QueryResult;

import java.util.List;
import java.util.Map;

public class QueryHistoricalDeleteConciliations {
    private static List<Map<String, Object>> result;

    public static List<Map<String, Object>> queryHistoricalDeleteConciliation(String dateInitial, String dateFinal)
    {
        result = QueryResult.queryResult("SELECT ID_CONTABILIZA COD_CONCILIACION " +
                "FROM HISTORICO_CONCILIACIONES_ELIMINADAS " +
                "WHERE FECHA_CERTIFICACION BETWEEN TO_DATE(TO_CHAR('"+dateInitial+"')||'00:00:00','DD/MM/YYYY HH24:MI:SS') " +
                "AND TO_DATE(TO_CHAR('"+dateFinal+"')||'23:59:59','DD/MM/YYYY HH24:MI:SS')");
        return result;
    }

}
