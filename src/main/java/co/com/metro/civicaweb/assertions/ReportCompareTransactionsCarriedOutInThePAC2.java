package co.com.metro.civicaweb.assertions;

import co.com.metro.civicaweb.data.StoreProcedure.QueryResultSP;
import co.com.metro.civicaweb.utils.ReadExcelXLSX;

import java.util.List;
import java.util.Map;

public class ReportCompareTransactionsCarriedOutInThePAC2 {

    private static boolean result;

    public static boolean compareExcelFilesTitles() {
        String home = System.getProperty("user.home");
        List<Map<String, Object>> titles;

        titles = ReadExcelXLSX.readExcelXLS(home + "/Downloads/ReporteCargasRealizadasPac.xlsx", 4);

        result = titles.get(0).get("VALOR0").toString().equals("Operador del PAC") &&
                titles.get(0).get("VALOR1").toString().equals("Punto de Atención") &&
                titles.get(0).get("VALOR2").toString().equals("Fecha y Hora") &&
                titles.get(0).get("VALOR3").toString().equals("Tipo de Transacción") &&
                titles.get(0).get("VALOR4").toString().equals("Medio de actualización") &&
                titles.get(0).get("VALOR5").toString().equals("Valor/Cantidad") &&
                titles.get(0).get("VALOR6").toString().equals("Número de Tarjeta") &&
                titles.get(0).get("VALOR7").toString().equals("Perfil");
        return result;
    }


    public static boolean compareExcelFilesRegister(String initialDate, String finalDate) {

        String home = System.getProperty("user.home");

        List<Map<String, Object>> listExcel;
        List<Map<String, Object>> listSP;

        listExcel = ReadExcelXLSX.readExcelXLS(home + "/Downloads/ReporteCargasRealizadasPac.xlsx", 5);
        listSP = QueryResultSP.queryResultSP("{call SEL_REL_TRANSACCIONES_PAC_MS (?,?,?,?,?,?)}", "2022-02-01", "2022-02-17");


        for (int i = 0; i < listExcel.size(); i++) {

            String dateListSP = listSP.get(i).get("FECHA_HORA").toString().replace("-", "/");
            dateListSP = dateListSP.substring(0, dateListSP.length() - 2);


            String regExcel = listExcel.get(i).get("VALOR0").toString() + listExcel.get(i).get("VALOR1").toString() +
                    listExcel.get(i).get("VALOR2").toString() + listExcel.get(i).get("VALOR3").toString() + listExcel.get(i).get("VALOR7").toString();

            String regSP = listSP.get(i).get("OPERADOR").toString() + listSP.get(i).get("PUNTO_ATENCION").toString() + dateListSP +
                    listSP.get(i).get("TIPO_TRANSACCION").toString() + listSP.get(i).get("PERFIL").toString();

            if (listExcel.get(i).get("VALOR4").toString() != "") {
                regExcel += listExcel.get(i).get("VALOR4").toString();
                regSP += listSP.get(i).get("ACTUALIZA_DATOS").toString();
            }

            if (listExcel.get(i).get("VALOR5").toString() != "") {
                regExcel += listExcel.get(i).get("VALOR5").toString().replace(".0","");

                regSP += listSP.get(i).get("VALOR_CANTIDAD").toString();
            }

            if (listExcel.get(i).get("VALOR6").toString() != "") {
                regExcel += listExcel.get(i).get("VALOR6").toString().replace(".0","");
                regSP += listSP.get(i).get("TARJETA").toString();
            }

            result = regExcel.equals(regSP);

            if (result == false) {
                return false;
            }

        }
        return true;
    }
}
