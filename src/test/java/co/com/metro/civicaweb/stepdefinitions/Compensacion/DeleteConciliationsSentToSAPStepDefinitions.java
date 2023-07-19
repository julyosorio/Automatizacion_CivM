package co.com.metro.civicaweb.stepdefinitions.Compensacion;

import co.com.metro.civicaweb.assertions.ConfirmDeleteConciliations;
import co.com.metro.civicaweb.assertions.HistoryConciliations;
import co.com.metro.civicaweb.assertions.DeleteConciliationsSendToSAP;
import co.com.metro.civicaweb.tasks.*;
import co.com.metro.civicaweb.utils.RemoveFileDownloads;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.metro.civicaweb.ui.DeleteConciliationsSentToSAP.*;
import static co.com.metro.civicaweb.utils.Constant.PASS_CIVICA;
import static co.com.metro.civicaweb.utils.Constant.USER_CIVICA;

public class DeleteConciliationsSentToSAPStepDefinitions {

    //@29440 Escenario:Consulta ingresando fecha inicial y fecha final, ademas de seleccionar un item de la lista desplegable en los campos Tipo certificacion, estado y tipo envio del formulario

    @Dado("que se ingresa al formulario Eliminar Conciliaciones Enviadas a SAP")
    public void que_se_ingresa_al_formulario_eliminar_conciliaciones_enviadas_a_sap() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToDeleteConciliationsSendToSAP.goToTheMenu()
        );
    }

    @Cuando("selecciona la fecha inicial, fecha final y un item en las listas desplegables de Tipo certificacion, estado y tipo envio, se pulsa el boton buscar")
    public void selecciona_la_fecha_inicial_fecha_final_y_un_item_en_las_listas_desplegables_de_tipo_certificacion_estado_y_tipo_envio_se_pulsa_el_boton_buscar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormDeleteConciliationsSendToSAP.goToForm(1, "01122021", "18022022", "", "")
        );

    }

    @Entonces("en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, el Tipo certificacion, estado y tipo envio seleccionado e ingresados en el formulario")
    public void en_la_pantalla_se_visualiza_un_grid_la_informacion_correspondiente_a_la_fecha_inicial_y_fecha_final_el_tipo_certificacion_estado_y_tipo_envio_seleccionado_e_ingresados_en_el_formulario() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(GRID_TITLE).text().containsIgnoringCase("Cód. Conc. Tipo Envío SAP Fecha Envío Fecha Conc. Fecha Cert. Fecha Doc. Estado Referencia Certificación Operador Eliminar"),
                Ensure.that(DeleteConciliationsSendToSAP.compareGrid("01/12/2021", "18/02/2022", "'Certificación Recepción FF'", "'PA'", "'Con error validación SAP'")).isTrue()
        );
    }

    @Entonces("al pulsar la accion eliminar en alguno de uno de los registros del grid, se debera mostrar una ventana que permita ingresar una observacion")
    public void al_pulsar_la_accion_eliminar_en_alguno_de_uno_de_los_registros_del_grid_se_debera_mostrar_una_ventana_que_permita_ingresar_una_observacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                co.com.metro.civicaweb.tasks.DeleteConciliationsSendToSAP.goToTheMenuDeleteConciliations()
        );

    }

    @Entonces("al pulsar el boton de confirmar, se debe eliminar y actualizar el registro en la BD")
    public void al_pulsar_el_boton_de_confirmar_se_debe_eliminar_y_actualizar_el_registro_en_la_bd() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ConfirmDeleteConciliations.confirmDelete()).isTrue()
        );

    }


    //  @29442 Escenario:Consulta ingresando fecha inicial y fecha final, ademas de seleccionar varios items de la lista desplegable en los campos Tipo certificacion, estado y tipo envio del formulario

    @Cuando("selecciona la informacion en los campos fecha y varios items en las listas desplegables de Tipo certificacion, estado y tipo envio, se pulsa el boton buscar")
    public void selecciona_la_informacion_en_los_campos_fecha_y_varios_items_en_las_listas_desplegables_de_tipo_certificacion_estado_y_tipo_envio_se_pulsa_el_boton_buscar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormDeleteConciliationsSendToSAP.goToForm(2, "01122021", "18022022", "", "")
        );
    }

    @Entonces("en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, los Tipo certificacion, los estados y tipos envios seleccionados e ingresados en el formulario")
    public void en_la_pantalla_se_visualiza_un_grid_la_informacion_correspondiente_a_la_fecha_inicial_y_fecha_final_los_tipo_certificacion_los_estados_y_tipos_envios_seleccionados_e_ingresados_en_el_formulario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(DeleteConciliationsSendToSAP.compareGrid("01/12/2021", "31/01/2022", "'Certificación Recepción FF', 'Certificación Otros Conceptos'", "'CMNC','CMC'", "'Exitoso','Con error validación SAP','En proceso'")).isTrue()

        );
    }


    // @30844 Escenario:Consulta ingresando fecha inicial y fecha final, ademas de seleccionar el item todos de la lista desplegable en los campos Tipo certificacion, estado y tipo envio del formulario

    @Cuando("selecciona la informacion en los campos fecha y el item Todos, en las listas desplegables de Tipo certificacion, estado y tipo envio, se pulsa el boton buscar")
    public void selecciona_la_informacion_en_los_campos_fecha_y_el_item_todos_en_las_listas_desplegables_de_tipo_certificacion_estado_y_tipo_envio_se_pulsa_el_boton_buscar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormDeleteConciliationsSendToSAP.goToForm(3, "01122021", "18022022", "", "")
        );
    }

    @Entonces("en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, todos los Tipo certificacion, todos los estados y todos los tipos de envios seleccionados e ingresados en el formulario")
    public void en_la_pantalla_se_visualiza_un_grid_la_informacion_correspondiente_a_la_fecha_inicial_y_fecha_final_todos_los_tipo_certificacion_todos_los_estados_y_todos_los_tipos_de_envios_seleccionados_e_ingresados_en_el_formulario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(DeleteConciliationsSendToSAP.compareGridAll("01/12/2021", "31/01/2022")).isTrue()

        );
    }

    //@30845 Escenario: Consulta ingresando Codigo de conciliacion
    @Cuando("se ingresa informacion valida en los campos: Fecha inicial, Fecha final, Tipo certificacion, Tipo de envio, Estado y Codigo Conciliacion, luego pulsar el boton buscar")
    public void se_ingresa_informacion_valida_en_los_campos_fecha_inicial_fecha_final_tipo_certificacion_tipo_de_envio_estado_y_codigo_conciliacion_luego_pulsar_el_boton_buscar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormDeleteConciliationsSendToSAP.goToForm(5, "01122021", "18022022/", "", "18532")
        );
    }

    @Entonces("en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, el codigo de conciliacion, todos los Tipo certificacion, todos los estados y todos los tipos de envios seleccionados e ingresados en el formulario")
    public void en_la_pantalla_se_visualiza_un_grid_la_informacion_correspondiente_a_la_fecha_inicial_y_fecha_final_el_codigo_de_conciliacion_todos_los_tipo_certificacion_todos_los_estados_y_todos_los_tipos_de_envios_seleccionados_e_ingresados_en_el_formulario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(DeleteConciliationsSendToSAP.compareGridCodConciliations("18532")).isTrue()

        );

    }


    // @30846 Escenario: Consulta ingresando en informacion en el campo Referencia

    @Cuando("se ingresa informacion valida en los campos: Fecha inicial, Fecha final, Tipo certificacion, Tipo de envio, Estado y Referencia, luego pulsar el boton buscar")
    public void se_ingresa_informacion_valida_en_los_campos_fecha_inicial_fecha_final_tipo_certificacion_tipo_de_envio_estado_y_referencia_luego_pulsar_el_boton_buscar() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormDeleteConciliationsSendToSAP.goToForm(4, "01122021", "18012022", "TKOTROMDE211223", "")
        );
    }

    @Entonces("en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, el numero de referencia, todos los Tipo certificacion, todos los estados y todos los tipos de envios seleccionados e ingresados en el formulario")
    public void en_la_pantalla_se_visualiza_un_grid_la_informacion_correspondiente_a_la_fecha_inicial_y_fecha_final_el_numero_de_referencia_todos_los_tipo_certificacion_todos_los_estados_y_todos_los_tipos_de_envios_seleccionados_e_ingresados_en_el_formulario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(DeleteConciliationsSendToSAP.compareGridReferences("TKOTROMDE211223")).isTrue()
        );
    }

    // @29443 Escenario: Consultar Histórico de conciliaciones eliminadas ingresando fechas y Varios campos de búsqueda

    @Dado("que se ingresa al formulario Historico de Conciliaciones Eliminadas")
    public void que_se_ingresa_al_formulario_historico_de_conciliaciones_eliminadas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToDeleteConciliationsSendToSAP.goToTheMenu()
        );
    }

    @Cuando("selecciona unicamente la informacion en los campos fecha y pulso el boton buscar")
    public void selecciona_unicamente_la_informacion_en_los_campos_fecha_y_pulso_el_boton_buscar() {
        RemoveFileDownloads.removeFileDownloads("ReporteHistóricoConciliacionesEliminadas");
        OnStage.theActorInTheSpotlight().attemptsTo(
                FormHistoricalConciliations.goToForm("01122021", "18022022/")
        );
    }


    @Entonces("en la pantalla se visualiza un grid con el resultado de la busqueda al pulsar el boton generar reporte se debera generar y descarga el archivo excel con la informacion encontrada en el grid")
    public void en_la_pantalla_se_visualiza_un_grid_con_el_resultado_de_la_busqueda_al_pulsar_el_boton_generar_reporte_se_debera_generar_y_descarga_el_archivo_excel_con_la_informacion_encontrada_en_el_grid() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(HistoryConciliations.compared()).isTrue()
        );

    }
}
