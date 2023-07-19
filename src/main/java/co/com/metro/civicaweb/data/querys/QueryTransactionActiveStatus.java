package co.com.metro.civicaweb.data.querys;

import co.com.metro.civicaweb.data.QueryResult;

import java.util.List;
import java.util.Map;

public class QueryTransactionActiveStatus {
    private static List<Map<String, Object>> resultquery;

    public static List<Map<String, Object>> query(int numberOfRecords){

        resultquery = QueryResult.queryResult("SELECT B.CAR_ID AS VALOR1 , A.SES_ID AS VALOR2,A. MOS_VLR_TOTAL AS VALOR3,B.MOV_SLD_ANTERIOR AS VALOR4,B.MOV_DTA_TRANS AS VALOR5 " +
                "FROM METRO.MOVIMENTO_SESSAO A JOIN METRO.MOVIMENTACAO B ON A.MOS_ID = B.MOS_ID AND A.TMO_ID = B.TMO_ID " +
                "WHERE ROWNUM <= " + numberOfRecords + "AND A. MOS_VLR_TOTAL >0 AND B.MOV_SLD_ANTERIOR >0");

        return resultquery;
    }
}
