package co.com.metro.civicaweb.data.querys;

import co.com.metro.civicaweb.data.QueryResult;

import java.util.List;
import java.util.Map;

public class QueryOperator {
    private static List<Map<String, Object>> result;

    public static List<Map<String, Object>> queryAuditFile() {

        result = QueryResult.queryResult("SELECT  " +
                "PF.PFI_NOME || ' ' || PF.PFI_SNOME NOMBRE_OPERADOR " +
                "FROM METRO.OPERADOR_SISTEMA OS " +
                "INNER JOIN METRO.PESSOA_OPE_SISTEMA POS ON POS.OSI_ID = OS.OSI_ID " +
                "INNER JOIN METRO.PESSOA_FISICA PF ON PF.PES_ID = POS.PES_ID " +
                "INNER JOIN METRO.PESSOA PES ON PES.PES_ID = PF.PES_ID " +
                "INNER JOIN METRO.CARTAO_PESSOA CP ON CP.PES_ID = PF.PES_ID " +
                "INNER JOIN METRO.CARTAO C ON C.CAR_ID = CP.CAR_ID " +
                "INNER JOIN METRO.MODULO_OPERADOR MO ON MO.OSI_ID = POS.OSI_ID " +
                "INNER JOIN METRO.MODULO MD ON MD.MOD_ID = MO.MOD_ID " +
                "LEFT JOIN METRO.PESSOAFIS_PESSOAJUR PFPJ ON PFPJ.PFI_ID = POS.PES_ID " +
                "WHERE MD.MOD_ID  IN (487,484,485) " +
                "ORDER BY NOMBRE_OPERADOR ");

        return result;
    }
}