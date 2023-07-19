package co.com.metro.civicaweb.data.querys;

import co.com.metro.civicaweb.data.QueryResult;

import java.util.List;
import java.util.Map;

public class QueryCar_idSes_id {
    private static List<Map<String, Object>> resultqueryCar_id;

    public static List<Map<String, Object>> query(int numberOfRecords){

        resultqueryCar_id = QueryResult.queryResult("SELECT CAR_ID, SES_ID FROM METRO.CARTAO A JOIN METRO.MOVIMENTO_SESSAO B ON A.MOS_ID = B.MOS_ID WHERE CAR_ID > 99999 ORDER BY CAR_ID FETCH FIRST " + numberOfRecords + " ROWS ONLY");

        return resultqueryCar_id;
    }

}
