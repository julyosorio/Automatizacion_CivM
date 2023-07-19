package co.com.metro.civicaweb.stepdefinitions.Atencion;

import co.com.metro.civicaweb.assertions.ReportCompareTransactionsCarriedOutInThePAC2;
import co.com.metro.civicaweb.tasks.FormTransactionsCarriedOutInThePAC;
import co.com.metro.civicaweb.tasks.GoToMenuTransactionsCarriedOutInThePAC;
import co.com.metro.civicaweb.tasks.Login;
import co.com.metro.civicaweb.utils.RemoveFileDownloads;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.metro.civicaweb.ui.PopUp.*;
import static co.com.metro.civicaweb.utils.Constant.*;


public class TransactionsCarriedOutInThePACStepDefinition {


    // @29430 Escenario: Consulta Transacciones realizadas en el PAC, ingresando solo la fecha
    @Dado("que se ingresa al formulario de consulta Transacciones realizadas en el PAC")
    public void que_se_ingresa_al_formulario_de_consulta_transacciones_realizadas_en_el_pac() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToMenuTransactionsCarriedOutInThePAC.goToTheMenu()
        );

    }

    @Cuando("se selecciona únicamente la informacion en los campos fecha y se pulsa el boton generar reporte")
    public void se_selecciona_únicamente_la_informacion_en_los_campos_fecha_y_se_pulsa_el_boton_generar_reporte() {
        RemoveFileDownloads.removeFileDownloads("ReporteCargasRealizadasPac");
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormTransactionsCarriedOutInThePAC.goToForm(1, "/01022022/", "/17022022/")
        );

    }

    @Entonces("se realiza la descarga del archivo Reporte en Excel")
    public void se_realiza_la_descarga_del_archivo_Reporte_en_Excel() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ReportCompareTransactionsCarriedOutInThePAC2.compareExcelFilesTitles()).isTrue(),
                Ensure.that(ReportCompareTransactionsCarriedOutInThePAC2.compareExcelFilesRegister("2022-02-01", "2022-02-17")).isTrue()
        );

    }



    //  @29432 Escenario: Consultar seleccionando varias opciones los campos multiselect
    @Cuando("se seleccionan en los campos multiselect varias opciones y se pulsa el boton generar reporte")
    public void se_seleccionan_en_los_campos_multiselect_varias_opciones_y_se_pulsa_el_boton_generar_reporte() {
        RemoveFileDownloads.removeFileDownloads("ReporteRegistroTransaccionRecargas");
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormTransactionsCarriedOutInThePAC.goToForm(2, "/01022022/", "/17022022/")
        );
    }


    //@29435 Escenario: Consultar selccionando una opción en los campos multiselect

    @Cuando("se seleccionan en los campos multiselect una opcion y se pulsa el boton generar reporte")
    public void se_seleccionan_en_los_campos_multiselect_una_opcion_y_se_pulsa_el_boton_generar_reporte() {

        RemoveFileDownloads.removeFileDownloads("ReporteCargasRealizadasPac");
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormTransactionsCarriedOutInThePAC.goToForm(3, "/01022022/", "/17022022/")
        );
    }

    //@30112  Escenario: Consultar sin seleccion tipo de transaccion ni PAC
    @Cuando("no seleccionan en los campos multiselect ninguna de las opciones en los campos Tipo transaccion y PAC y se pulsa el boton generar reporte")
    public void no_seleccionan_en_los_campos_multiselect_ninguna_de_las_opciones_en_los_campos_tipo_transaccion_y_pac_y_se_pulsa_el_boton_generar_reporte() {
        RemoveFileDownloads.removeFileDownloads("ReporteCargasRealizadasPac");
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormTransactionsCarriedOutInThePAC.goToForm(4, "/01022022/", "/17022022/")
        );

    }

    //@29436 Escenario: Validar la búsqueda dinamica del operador
    @Cuando("se realiza la consulta por el campo operador dicha consulta se haga de manera dinamica y se pulsa el boton generar reporte")
    public void se_realiza_la_consulta_por_el_campo_operador_dicha_consulta_se_haga_de_manera_dinamica_y_se_pulsa_el_boton_generar_reporte() {
        RemoveFileDownloads.removeFileDownloads("ReporteCargasRealizadasPac");
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormTransactionsCarriedOutInThePAC.goToForm(5, "/01022022/", "/17022022/")
        );
    }

    //@33416 Escenario: Validar al ingresar los valores en la formulario que no existan registros en BD, el sistema no genere el archivo excel

    @Cuando("se realiza la consulta ingresando todos los datos validos en el formulario, pero no existen registros en BD")
    public void se_realiza_la_consulta_ingresando_todos_los_datos_validos_en_el_formulario_pero_no_existen_registros_en_bd() {
        RemoveFileDownloads.removeFileDownloads("ReporteCargasRealizadasPac");
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormTransactionsCarriedOutInThePAC.goToForm(6, "/01022022/", "/17022022/")
        );
    }
    @Entonces("No se realiza la descarga del archivo Reporte en Excel")
    public void no_se_realiza_la_descarga_del_archivo_reporte_en_excel() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
               Ensure.that(MESSAGE).text().containsIgnoringCase("Ningún registro encontrado"),
                Click.on(BTN_OK)
        );
    }


}
