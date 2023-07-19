package co.com.metro.civicaweb.assertions;

import co.com.metro.civicaweb.data.querys.QueryDeleteConciliationsSendToSAP;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class DeleteConciliationsSendToSAP {

    public static boolean compareGrid(String dateInitial, String dateFinal, String certificationType, String shippingType, String status) {
        List<Map<String, Object>> listConciliationsDB;
        String register;
        boolean result = false;

        listConciliationsDB = QueryDeleteConciliationsSendToSAP.queryDeleteConciliationsSendToSAP_One(dateInitial, dateFinal, certificationType, shippingType, status);

        for (int i = 0; i < listConciliationsDB.size(); i++) {

            register = listConciliationsDB.get(i).get("CODIGO_CONCILIACION").toString() + " " + listConciliationsDB.get(i).get("TIPO_ENVIO").toString() + " " +
                    listConciliationsDB.get(i).get("FECHA_ENVIO").toString() + " " + listConciliationsDB.get(i).get("FECHA_CONCILIACION").toString() + " " +
                    listConciliationsDB.get(i).get("FECHA_CERTIFICACION").toString() + " " + listConciliationsDB.get(i).get("FECHA_DOCUMENTO").toString() + " " +
                    listConciliationsDB.get(i).get("ESTADO").toString() + " " + listConciliationsDB.get(i).get("REFERENCIA").toString() + " " +
                    listConciliationsDB.get(i).get("TIPO_CERTIFICACION").toString() + " " + listConciliationsDB.get(i).get("OPERADOR").toString();

            List<WebElement> listGridConciliations = Serenity.getDriver().findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdEliminarConciliaciones']/tbody/tr[contains(@class,'linhaDataGrid')]"));
            result = (listGridConciliations.get(i).getText().compareToIgnoreCase(register)) < 0 ? false : true;
        }
        return result;
    }


    public static boolean compareGridAll(String dateInitial, String dateFinal) {
        List<Map<String, Object>> listConciliationsDB;
        String register;
        boolean result = false;

        listConciliationsDB = QueryDeleteConciliationsSendToSAP.queryDeleteConciliationsSendToSAP_All(dateInitial, dateFinal);

        for (int i = 0; i < listConciliationsDB.size(); i++) {

            register = listConciliationsDB.get(i).get("CODIGO_CONCILIACION").toString() + " " + listConciliationsDB.get(i).get("TIPO_ENVIO").toString() + " " +
                    listConciliationsDB.get(i).get("FECHA_ENVIO").toString() + " " + listConciliationsDB.get(i).get("FECHA_CONCILIACION").toString() + " " +
                    listConciliationsDB.get(i).get("FECHA_CERTIFICACION").toString() + " " + listConciliationsDB.get(i).get("FECHA_DOCUMENTO").toString() + " " +
                    listConciliationsDB.get(i).get("ESTADO").toString() + " " + listConciliationsDB.get(i).get("REFERENCIA").toString() + " " +
                    listConciliationsDB.get(i).get("TIPO_CERTIFICACION").toString() + " " + listConciliationsDB.get(i).get("OPERADOR").toString();

            List<WebElement> listGridConciliations = Serenity.getDriver().findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdEliminarConciliaciones']/tbody/tr[contains(@class,'linhaDataGrid')]"));
            result = (listGridConciliations.get(i).getText().compareToIgnoreCase(register)) < 0 ? false : true;
        }
        return result;
    }

    public static boolean compareGridCodConciliations(String codConciliations) {
        List<Map<String, Object>> listConciliationsDB;
        String register;
        boolean result = false;

        listConciliationsDB = QueryDeleteConciliationsSendToSAP.queryDeleteConciliationsSendToSAP_CodCociliations(codConciliations);

        for (int i = 0; i < listConciliationsDB.size(); i++) {

            register = listConciliationsDB.get(i).get("CODIGO_CONCILIACION").toString() + " " + listConciliationsDB.get(i).get("TIPO_ENVIO").toString() + " " +
                    listConciliationsDB.get(i).get("FECHA_ENVIO").toString() + " " + listConciliationsDB.get(i).get("FECHA_CONCILIACION").toString() + " " +
                    listConciliationsDB.get(i).get("FECHA_CERTIFICACION").toString() + " " + listConciliationsDB.get(i).get("FECHA_DOCUMENTO").toString() + " " +
                    listConciliationsDB.get(i).get("ESTADO").toString() + " " + listConciliationsDB.get(i).get("REFERENCIA").toString() + " " +
                    listConciliationsDB.get(i).get("TIPO_CERTIFICACION").toString() + " " + listConciliationsDB.get(i).get("OPERADOR").toString();

            List<WebElement> listGridConciliations = Serenity.getDriver().findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdEliminarConciliaciones']/tbody/tr[contains(@class,'linhaDataGrid')]"));
            result = (listGridConciliations.get(i).getText().compareToIgnoreCase(register)) < 0 ? false : true;
            if (result == false) {
                return false;
            }
        }
        return result;
    }

    public static boolean compareGridReferences(String references) {
        List<Map<String, Object>> listConciliationsDB;
        String register;
        boolean result = false;

        listConciliationsDB = QueryDeleteConciliationsSendToSAP.queryDeleteConciliationsSendToSAP_References(references);

        for (int i = 0; i < listConciliationsDB.size(); i++) {

            register = listConciliationsDB.get(i).get("CODIGO_CONCILIACION").toString() + " " + listConciliationsDB.get(i).get("TIPO_ENVIO").toString() + " " +
                    listConciliationsDB.get(i).get("FECHA_ENVIO").toString() + " " + listConciliationsDB.get(i).get("FECHA_CONCILIACION").toString() + " " +
                    listConciliationsDB.get(i).get("FECHA_CERTIFICACION").toString() + " " + listConciliationsDB.get(i).get("FECHA_DOCUMENTO").toString() + " " +
                    listConciliationsDB.get(i).get("ESTADO").toString() + " " + listConciliationsDB.get(i).get("REFERENCIA").toString() + " " +
                    listConciliationsDB.get(i).get("TIPO_CERTIFICACION").toString() + " " + listConciliationsDB.get(i).get("OPERADOR").toString();


            List<WebElement> listGridConciliations = Serenity.getDriver().findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdEliminarConciliaciones']/tbody/tr[contains(@class,'linhaDataGrid')]"));

            result = (listGridConciliations.get(i).getText().compareToIgnoreCase(register)) < 0 ? false : true;
        }
        return result;
    }
}
