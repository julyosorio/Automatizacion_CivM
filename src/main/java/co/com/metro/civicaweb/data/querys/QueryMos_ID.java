package co.com.metro.civicaweb.data.querys;

import co.com.metro.civicaweb.data.QueryResult;

import java.util.List;
import java.util.Map;

public class QueryMos_ID {
    private static List<Map<String, Object>> resultquery;

    public static List<Map<String, Object>> query(int numberOfRecords){

        resultquery =  QueryResult.queryResult("SELECT MC.MOS_ID FROM METRO.SESSAO S " +
                "INNER JOIN METRO.MOVIMENTO_SESSAO MS ON S.SES_ID=MS.SES_ID " +
                "INNER JOIN METRO.DOM_STATUS_MOVIMENTO_SESSAO DSMS ON MS.SMS_ID=DSMS.SMS_ID " +
                "INNER JOIN METRO.MOVIMENTACAO MC ON MS.MOS_ID=MC.MOS_ID AND MC.TMO_ID = 37" +
                "INNER JOIN METRO.CARTAO C ON MC.CAR_ID=C.CAR_ID " +
                "WHERE rownum <= "+numberOfRecords);
        System.out.println(resultquery);

        return resultquery;
    }

}
