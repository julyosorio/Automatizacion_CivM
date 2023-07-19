package co.com.metro.civicaweb.assertions;

import co.com.metro.civicaweb.data.QueryResult;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static co.com.metro.civicaweb.ui.DeleteConciliationsSentToSAP.BTN_COMFIRM;

public class ConfirmDeleteConciliations {

    public static boolean  confirmDelete(){
        String codConciliation;
        List<WebElement> listGridConciliations = Serenity.getDriver().findElements(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdEliminarConciliaciones']/tbody/tr[contains(@class,'linhaDataGrid')]/td"));
        codConciliation= listGridConciliations.get(0).getText();
        boolean result;
        List<Map<String, Object>> listConciliations;

        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_COMFIRM)
        );

        listConciliations = QueryResult.queryResult("SELECT ES.ID_CONTABILIZA CODIGO_CONCILIACION,TES.TES_ABREV TIPO_ENVIO " +
                ",TO_CHAR(CA.FECHA_ENVIO, 'YYYY/MM/DD HH24:MI:SS')  FECHA_ENVIO,TO_CHAR(ES.FEC_GENERACION, 'YYYY/MM/DD HH24:MI:SS') FECHA_CONCILIACION, " +
                "TO_CHAR(CA.FECHA_CERTIFICACION, 'YYYY/MM/DD') FECHA_CERTIFICACION,TO_CHAR(CA.FECHA_DOCUMENTO, 'YYYY/MM/DD') FECHA_DOCUMENTO,EES.ESTADO_DESC ESTADO " +
                ",CA.REFERENCIA REFERENCIA,C.CERTIFICA_DESC TIPO_CERTIFICACION,NVL (OS.OSI_LOGIN, CA.OSI_LOGIN) OPERADOR " +
                "FROM ENVIOS_SAP ES LEFT JOIN OPERADOR_SISTEMA OS ON OS.OSI_ID = ES.OSI_ID INNER JOIN ESTADOS_ENVIOS_SAP EES ON EES.ESTADO_ID = ES.ESTADO_ID " +
                "INNER JOIN CONTABILIZA_AUTO CA ON CA.ID_CONTABILIZA = ES.ID_CONTABILIZA INNER JOIN CERTIFICACION C ON C.CERTIFICA_ID = ES.CERTIFICA_ID " +
                "INNER JOIN METRO.TIPO_ENVIO_SAP TES ON TES.TES_ID = CA.TES_ID WHERE ES.TIPO_ENVIO IN (1,3)" +
                "AND ES.ID_CONTABILIZA IN ('"+codConciliation+"') " +
                "AND 1 = CASE WHEN NULL IS NOT NULL AND ES.CERTIFICA_ID IN ( " +
                "SELECT COLUMN_VALUE FROM TABLE (METRO.FN_SPLIT3 (NULL,',')))THEN 1 WHEN NULL IS NULL THEN 1 END ORDER BY  ES.FEC_GENERACION,ES.ID_CONTABILIZA");

        if (listConciliations.size()==0){
            result = true;
        }else{
            result = false;
        }
        return result;
    }
}
