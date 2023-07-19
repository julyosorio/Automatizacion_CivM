package co.com.metro.civicaweb.stepdefinitions.Adquisicion;

import co.com.metro.civicaweb.assertions.CompareExcelFiles;
import co.com.metro.civicaweb.data.querys.QueryAuditFile;
import co.com.metro.civicaweb.tasks.CheckResultTable;
import co.com.metro.civicaweb.tasks.FileUploadRegister;
import co.com.metro.civicaweb.tasks.GoToTheMenuRechargeTransactionRecord;
import co.com.metro.civicaweb.tasks.Login;
import co.com.metro.civicaweb.utils.ExcelReload.*;
import co.com.metro.civicaweb.utils.RemoveFileDownloads;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.metro.civicaweb.ui.PopUp.MESSAGE;
import static co.com.metro.civicaweb.ui.PopUp.POP_UP_WINDOW_TITLE;
import static co.com.metro.civicaweb.ui.RechargeTransactionRegister.*;
import static co.com.metro.civicaweb.utils.Constant.*;

public class RechargeTransactionRecordStepDefinitions {

    //@23520 Escenario: Registro de transacciones recarga con archivo excel vacio
    @Dado("que se tiene un archivo excel vacio")
    public void que_se_tiene_un_archivo_excel_vacio() {

        ExcelEmpty.createExcelEmpty("ArchivoRecarga1");
    }

    @Cuando("se carga el archivo excel vacio en el formulario Registro de transacciones recarga")
    public void se_carga_el_archivo_excel_vacio_en_el_formulario_registro_de_transacciones_recarga() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga1"));

    }

    @Entonces("en pantalla se visualiza un pop-up con el mensaje de error indicando que el archivo esta vacio")
    public void en_pantalla_se_visualiza_un_pop_up_con_el_mensaje_de_error_indicando_que_el_archivo_esta_vacio() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
                Ensure.that(MESSAGE).text().containsIgnoringCase("El archivo no contiene ningun registro")
        );
    }

    //@23521 Escenario: Registro de transacciones recarga con archivo excel, con solo la fila de titulos en el orden correcto

    @Dado("que se tiene el archivo excel insumo con solo la fila con los titulos en el orden correcto \\(CAR_ID, SESION, VALOR RECARGA, SALDO ANTERIOR, FECHA RECARGA, HORA RECARGA)")
    public void que_se_tiene_el_archivo_excel_insumo_con_solo_la_fila_con_los_titulos_en_el_orden_correcto_car_id_sesion_valor_recarga_saldo_anterior_fecha_recarga_hora_recarga() {
        ExcelRechargeOnlyWithTitles.createExcelRechargeOnlyWithTitles("ArchivoRecarga2");
    }

    @Cuando("se carga el archivo excel con solo la fila de titulos en el orden correcto, en el formulario Registro de transacciones recarga")
    public void se_carga_el_archivo_excel_con_solo_la_fila_de_titulos_en_el_orden_correcto_en_el_formulario_registro_de_transacciones_recarga() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga2"),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE)
        );
    }

    @Entonces("en pantalla se visualiza un pop-up con el mensaje de error indicando que el archivo no contiene ningun registro")
    public void en_pantalla_se_visualiza_un_pop_up_con_el_mensaje_de_error_indicando_que_el_archivo_no_contiene_ningun_registro() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(MESSAGE).text().containsIgnoringCase("El archivo no contiene ningún registro")
        );
    }


    //@23522 Escenario: Registro de transacciones recarga con archivo excel, con los titulos de las columnas en el orden incorrecto

    @Dado("que se tiene el archivo excel insumo en la fila de los titulos, los nombres  en el orden no definido")
    public void que_se_tiene_el_archivo_excel_insumo_en_la_fila_de_los_titulos_los_nombres_en_el_orden_no_definido() {
        ExcelRechargeTitlesInDisorder.createExcelRechargeTitlesInDisorder(10, "ArchivoRecarga3");
    }

    @Cuando("se carga el archivo excel con los titulos de las columnas en el orden incorrecto, en el formulario Registro de transacciones recarga")
    public void se_carga_el_archivo_excel_con_los_titulos_de_las_columnas_en_el_orden_incorrecto_en_el_formulario_registro_de_transacciones_recarga() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga3"),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE)
        );
    }

    @Entonces("en pantalla se visualiza un pop-up con el mensaje de error indicando que el orden de las columnas es incorrecto")
    public void en_pantalla_se_visualiza_un_pop_up_con_el_mensaje_de_error_indicando_que_el_orden_de_las_columnas_es_incorrecto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(MESSAGE).text().containsIgnoringCase("El orden de las columnas es incorrecto")
        );
    }

    //@24473 Escenario: Registro de transacciones recarga con archivo excel, con solo la fila con datos, sin fila de titulos

    @Dado("que se tiene el archivo excel insumo esta sin la fila de los titulos, solo con datos")
    public void que_se_tiene_el_archivo_excel_insumo_esta_sin_la_fila_de_los_titulos_solo_con_datos() {
        ExcelRechargeWithoutTitles.createExcelRechargeWithoutTitles(10, "ArchivoRecarga4");
    }

    @Cuando("se carga el archivo excel con solo la fila con datos, sin fila de titulos, en el formulario Registro de transacciones recarga")
    public void se_carga_el_archivo_excel_con_solo_la_fila_con_datos_sin_fila_de_titulos_en_el_formulario_registro_de_transacciones_recarga() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga4"),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE)

        );
    }

    @Entonces("en pantalla se visualiza un pop-up con el mensaje de error indicando que el archivo seleccionado tiene una estructura invalida")
    public void en_pantalla_se_visualiza_un_pop_up_con_el_mensaje_de_error_indicando_que_el_archivo_seleccionado_tiene_una_estructura_invalida() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(MESSAGE).text().containsIgnoringCase("El archivo seleccionado tiene una estructura inválida")
        );
    }

    //@24474 Escenario: Registro de transacciones recarga con archivo excel, con mas de las columnas definidas
    @Dado("que se tiene el archivo excel insumo con mas de las columnas definidas, pero con los datos correctos en las columnas CAR_ID, SESION, VALOR RECARGA, SALDO ANTERIOR, FECHA RECARGA, HORA RECARGA")
    public void que_se_tiene_el_archivo_excel_insumo_con_mas_de_las_columnas_definidas_pero_con_los_datos_correctos_en_las_columnas_car_id_sesion_valor_recarga_saldo_anterior_fecha_recarga_hora_recarga() {
        ExcelRechargeAdditionalColumn.createExcelRechargeAdditionalColumn(3, "ArchivoRecarga5");
        RemoveFileDownloads.removeFileDownloads("ReporteRegistroTransaccionRecargas");
    }

    @Cuando("se carga el archivo excel con mas de las columnas definidas, en el formulario Registro de transacciones recarga")
    public void se_carga_el_archivo_excel_con_mas_de_las_columnas_definidas_en_el_formulario_registro_de_transacciones_recarga() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga5"),
                Click.on(GENERATE_REPORT),
                CheckResultTable.checkResultTable()
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Entonces("el sistema  muestra en pantalla un grid solo con las siguientes columnas: #, CAR_ID, SESION, VALOR RECARGA, SALDO ANTERIOR, FECHA RECARGA, HORA RECARGA, ESTADO, OBSERVACION, con la informacion correspondiente")
    public void el_sistema_muestra_en_pantalla_un_grid_solo_con_las_siguientes_columnas_car_id_sesion_valor_recarga_saldo_anterior_fecha_recarga_hora_recarga_estado_observacion_con_la_informacion_correspondiente() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(GRID_TITLES).text().containsIgnoringCase("# Car_id Sesión Valor Recarga Saldo Anterior Fecha Recarga Hora Recarga Estado Observación")
        );
    }

    @Entonces("se puede generar un archivo excel Reporte con la informacion contenida en el grid que se ve en pantalla, sin incluir las columnas adicionales contenidas en el archivo excel cargado")
    public void se_puede_generar_un_archivo_excel_reporte_con_la_informacion_contenida_en_el_grid_que_se_ve_en_pantalla_sin_incluir_las_columnas_adicionales_contenidas_en_el_archivo_excel_cargado() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(CompareExcelFiles.compareExcelFiles("ReporteRegistroTransaccionRecargas", "ArchivoRecarga5")).isTrue()
        );
    }

    @Entonces("se hace la insercion de manera exitosa")
    public void se_hace_la_insercion_de_manera_exitosa() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue("Archivo Recarga con columnas adicionales" + DATE).into(OBSERVATIONS_TEXT_FIELD),
                Click.on(CONFIRMATION_INSERTION),
                Click.on(APPROVE_INSERTION),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
                Ensure.that(MESSAGE).text().containsIgnoringCase("Los registros se han insertado de forma satisfactoria")
        );
    }

    @Entonces("se insertan los registros en tablas de auditoria")
    public void se_insertan_los_registros_en_tablas_de_auditoria() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(QueryAuditFile.queryAuditFile("Archivo Recarga con columnas adicionales" + DATE)).isNotNull(),
                Ensure.that(CompareExcelFiles.comparedExcelFileBD("ArchivoRecarga5", "Archivo Recarga con columnas adicionales" + DATE)).isTrue()
        );

    }

    //@23524 Escenario: Registro de transacciones recarga con archivo excel, con uno o mas registros con el CAR_ID que no existe en base de datos

    @Dado("que se tiene el archivo excel insumo con uno o mas registros con todos los datos correctos, solo con CAR_ID que no exista en la BD")
    public void que_se_tiene_el_archivo_excel_insumo_con_uno_o_mas_registros_con_todos_los_datos_correctos_solo_con_car_id_que_no_exista_en_la_bd() {
        ExcelRechargeFieldDoesNotExistInDB.createExcelRechargeFieldDoesNotExistInDB(10, "ArchivoRecarga6", "B.MOS_ID", "B.SES_ID");
    }

    @Cuando("se carga el archivo excel con uno o mas registros con el CAR_ID que no existe en base de datos, en el formulario Registro de transacciones recarga")
    public void se_carga_el_archivo_excel_con_uno_o_mas_registros_con_el_car_id_que_no_existe_en_base_de_datos_en_el_formulario_registro_de_transacciones_recarga() {
        RemoveFileDownloads.removeFileDownloads("ReporteRegistroTransaccionRecargas");

        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga6"),
                Click.on(GENERATE_REPORT)
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Entonces("en el campo ESTADO para los registros con el CAR_ID no existente en la BD debe estar con el texto: Error y en el campo OBSERVACION debe decir: CAR_ID no encontrado")
    public void en_el_campo_estado_para_los_registros_con_el_car_id_no_existente_en_la_bd_debe_estar_con_el_texto_error_y_en_el_campo_observacion_debe_decir_car_id_no_encontrado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CheckResultTable.checkResultTable(),
                Ensure.that(REGISTER_GRID_VIEW).text().containsIgnoringCase("CON ERROR Car_Id no encontrado"),
                Ensure.that(REGISTER_GRID_VIEW2).text().containsIgnoringCase("CON ERROR Car_Id no encontrado")
        );
    }

    @Entonces("se genera un archivo excel Reporte con la informacion contenida en el grid que se ve en pantalla")
    public void se_genera_un_archivo_excel_reporte_con_la_informacion_contenida_en_el_grid_que_se_ve_en_pantalla() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(CompareExcelFiles.compareExcelFiles("ReporteRegistroTransaccionRecargas", "ArchivoRecarga6")).isTrue()
        );


    }


    //@23527 Escenario: Registro de transacciones recarga con archivo excel, con uno o mas registros con SESION que no existe en base de datos

    @Dado("que se tiene el archivo excel insumo con uno o mas registros con todos los datos correctos, solo con SESION que no exista en la BD")
    public void que_se_tiene_el_archivo_excel_insumo_con_uno_o_mas_registros_con_todos_los_datos_correctos_solo_con_sesion_que_no_exista_en_la_bd() {
        ExcelRechargeFieldDoesNotExistInDB.createExcelRechargeFieldDoesNotExistInDB(10, "ArchivoRecarga7", "A.CAR_ID", "B.MOS_ID");
    }

    @Cuando("se carga el archivo excel con uno o mas registros con SESION que no existe en base de datos, en el formulario Registro de transacciones recarga")
    public void se_carga_el_archivo_excel_con_uno_o_mas_registros_con_sesion_que_no_existe_en_base_de_datos_en_el_formulario_registro_de_transacciones_recarga() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga7"),
                Click.on(GENERATE_REPORT)
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RemoveFileDownloads.removeFileDownloads("ReporteRegistroTransaccionRecargas");
    }

    @Entonces("en el campo ESTADO para los registros con el SESION no existente en la BD debe estar con el texto: Error y en el campo OBSERVACION debe decir: SESION no encontrada")
    public void en_el_campo_estado_para_los_registros_con_el_sesion_no_existente_en_la_bd_debe_estar_con_el_texto_error_y_en_el_campo_observacion_debe_decir_sesion_no_encontrada() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CheckResultTable.checkResultTable(),
                Ensure.that(REGISTER_GRID_VIEW).text().containsIgnoringCase("CON ERROR Sesión no encontrada"),
                Ensure.that(REGISTER_GRID_VIEW2).text().containsIgnoringCase("CON ERROR Sesión no encontrada")
        );
    }

    @Entonces("se genera un archivo excel Reporte con el contenido en el grid que se ve en pantalla")
    public void se_genera_un_archivo_excel_reporte_con_el_contenido_en_el_grid_que_se_ve_en_pantalla() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(CompareExcelFiles.compareExcelFiles("ReporteRegistroTransaccionRecargas", "ArchivoRecarga7")).isTrue()
        );
    }

    // @25673 Escenario: Registro de transacciones recarga con archivo excel, con uno o mas registros que en 2 o mas columnas vacias o con caracteres invalidos
    @Dado("que se tiene el archivo excel insumo con uno o mas registros con dos o mas columnas vacias o con caracteres invalidos")
    public void que_se_tiene_el_archivo_excel_insumo_con_uno_o_mas_registros_con_dos_o_mas_columnas_vacias_o_con_caracteres_invalidos() {
        ExcelRechargeWithEmptyOrInvalidFields.createExcelRechargeWithEmptyOrInvalidFields(100, "ArchivoRecarga8", "B.SES_ID", "CAR_ID");
    }

    @Cuando("se carga el archivo excel con uno o mas registros que en dos o mas columnas vacias o con caracteres invalidos, en el formulario Registro de transacciones recarga")
    public void se_carga_el_archivo_excel_con_uno_o_mas_registros_que_en_dos_o_mas_columnas_vacias_o_con_caracteres_invalidos_en_el_formulario_registro_de_transacciones_recarga() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga8"),
                Click.on(GENERATE_REPORT)
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RemoveFileDownloads.removeFileDownloads("ReporteRegistroTransaccionRecargas");

    }

    @Entonces("en el campo ESTADO para los registros con columnas vacias o con caracteres invalidos debe estar con Error")
    public void en_el_campo_estado_para_los_registros_con_columnas_vacias_o_con_caracteres_invalidos_debe_estar_con_error() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CheckResultTable.checkResultTable(),
                Ensure.that(REGISTER_GRID_VIEW).text().containsIgnoringCase("CON ERROR"),
                Ensure.that(REGISTER_GRID_VIEW2).text().containsIgnoringCase("CON ERROR")
        );
    }

    @Entonces("se genera un archivo excel Reporte con la informacion contenida en el gridView que se ve en pantalla")
    public void se_genera_un_archivo_excel_reporte_con_la_informacion_contenida_en_el_gridView_que_se_ve_en_pantalla() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(CompareExcelFiles.compareExcelFiles("ReporteRegistroTransaccionRecargas", "ArchivoRecarga8")).isTrue()
        );
    }

    //@23529 Escenario: Registro de transacciones recarga con archivo excel, con registros que con Fecha, Hora, Valor de recarga, Sesión y Tipo de movimiento no exista una transacción en estado Activa.

    @Dado("que se tiene el archivo excel insumo con uno o mas registros con Fecha, Hora, Valor de recarga, Sesion y Tipo de movimiento no exista una transaccion en estado Activa.")
    public void que_se_tiene_el_archivo_excel_insumo_con_uno_o_mas_registros_con_fecha_hora_valor_de_recarga_sesion_y_tipo_de_movimiento_no_exista_una_transaccion_en_estado_activa() {
        ExcelRechargeTransactionActiveStatus.createExcelRechargeTransactionActiveStatus(10, "ArchivoRecarga9");
    }

    @Cuando("se carga el archivo excel con registros que con Fecha, Hora, Valor de recarga, Sesion y Tipo de movimiento no exista una transaccion en estado Activa, en el formulario Registro de transacciones recarga")
    public void se_carga_el_archivo_excel_con_registros_que_con_fecha_hora_valor_de_recarga_sesion_y_tipo_de_movimiento_no_exista_una_transaccion_en_estado_activa_en_el_formulario_registro_de_transacciones_recarga() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga9"),
                Click.on(GENERATE_REPORT)
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RemoveFileDownloads.removeFileDownloads("ReporteRegistroTransaccionRecargas");
    }

    @Entonces("en el campo ESTADO para los registros con el HORA_RECARGA con caracteres no validos debe estar con el texto: Error y en OBSERVACION debe decir: Transaccion activa para el registro")
    public void en_el_campo_estado_para_los_registros_con_el_hora_recarga_con_caracteres_no_validos_debe_estar_con_el_texto_error_y_en_observacion_debe_decir_transaccion_activa_para_el_registro() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CheckResultTable.checkResultTable(),
                Ensure.that(REGISTER_GRID_VIEW).text().containsIgnoringCase("CON ERROR"),
                Ensure.that(REGISTER_GRID_VIEW2).text().containsIgnoringCase("CON ERROR")
        );
    }

    @Entonces("se genera un archivo excel con la informacion contenida en el grid que se ve en pantalla")
    public void se_genera_un_archivo_excel_con_la_informacion_contenida_en_el_grid_que_se_ve_en_pantalla() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(CompareExcelFiles.compareExcelFiles("ReporteRegistroTransaccionRecargas", "ArchivoRecarga9")).isTrue()
        );
    }


    //  @24470 Escenario: Registro de transacciones recarga con archivo excel, ingresando en el campo Observación un texto con mas de doscientos cincuenta y cuatro  caracteres
    @Dado("que se tiene un archivo excel insumo con registros exitosos")
    public void que_se_tiene_un_archivo_excel_insumo_con_registros_exitosos() {
        ExcelRechargeSuccessful.createExcelRechargeSuccessful(500, "ArchivoRecarga11");
    }

    @Cuando("se ingresa en el campo OBSERVACION un texto de mas de doscientos cincuenta y cuatro  caracteres")
    public void se_ingresa_en_el_campo_observacion_un_texto_de_mas_de_doscientos_cincuenta_y_cuatro_caracteres() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga11"),
                Click.on(GENERATE_REPORT)
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RemoveFileDownloads.removeFileDownloads("ReporteRegistroTransaccionRecargas");
    }

    @Entonces("se genera archivo excel Reporte con la informacion cargada al inicio")
    public void se_genera_archivo_excel_Reporte_con_la_informacion_cargada_al_inicio() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(CompareExcelFiles.compareExcelFiles("ReporteRegistroTransaccionRecargas", "ArchivoRecarga11")).isTrue()
        );
    }

    @Entonces("campo observacion solo tiene 254 caracteres, se habilita el Boton Aprobar Insercion, haciendo exitosa la insercion")
    public void campo_observacion_solo_tiene_254_caracteres_se_habilita_el_boton_aprobar_insercion_haciendo_exitosa_la_insercion_de_mil_registros() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's " +
                        "standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry").into(OBSERVATIONS_TEXT_FIELD),
                Ensure.that(OBSERVATIONS_TEXT_FIELD).text().hasSizeBetween(0, 254),
                Click.on(CONFIRMATION_INSERTION),
                Click.on(APPROVE_INSERTION),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
                Ensure.that(MESSAGE).text().containsIgnoringCase("Los registros se han insertado de forma satisfactoria")

        );
    }

//@24471 Escenario: Registro de transacciones recarga con archivo excel insumo exitoso, ingresando en el campo Observación texto con menos de doscientos cincuenta y cuatro  caracteres

    @Dado("que se tiene un archivo excel exitoso")
    public void que_se_tiene_un_archivo_excel_exitoso() {
        ExcelRechargeSuccessful.createExcelRechargeSuccessful(500, "ArchivoRecarga12");
    }

    @Cuando("se ingresa en el campo OBSERVACION un texto con menos de doscientos cincuenta y cuatro  caracteres")
    public void se_ingresa_en_el_campo_observacion_un_texto_con_menos_de_doscientos_cincuenta_y_cuatro_caracteres() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga12"),
                CheckResultTable.checkResultTable()
        );


    }

    @Entonces("se habilita el Boton Aprobar Insercion, haciendo exitosa la insercion, campo observacion texto con menos de doscientos cincuenta y cuatro  caracteres")
    public void se_habilita_el_Boton_Aprobar_Insercion_haciendo_exitosa_la_insercion_campo_observacion_texto_con_menos_de_doscientos_cincuenta_y_cuatro_caracteres() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue("Los registros se han insertado de forma satisfactoria").into(OBSERVATIONS_TEXT_FIELD),
                Ensure.that(OBSERVATIONS_TEXT_FIELD).text().hasSizeBetween(0, 254),
                Click.on(CONFIRMATION_INSERTION),
                Click.on(APPROVE_INSERTION),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
                Ensure.that(MESSAGE).text().containsIgnoringCase("Los registros se han insertado de forma satisfactoria")
        );
    }

    // @25781 Escenario: Registro de transacciones recarga con archivo excel, sin ingresar texto en el campo Observación

    @Dado("que se tiene un archivo excel de carga exitoso")
    public void que_se_tiene_un_archivo_excel_de_carga_exitoso() {
        ExcelRechargeSuccessful.createExcelRechargeSuccessful(1500, "ArchivoRecarga13");
    }

    @Cuando("no se ingresa en el campo OBSERVACION ningun caracter")
    public void no_se_ingresa_en_el_campo_observacion_ningun_caracter() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga13"),
                CheckResultTable.checkResultTable()
        );
    }

    @Entonces("se habilita el Boton Aprobar Insercion, haciendo exitosa la insercion sin ingresar texto en el campo Observacion")
    public void se_habilita_el_Boton_Aprobar_Insercion_haciendo_exitosa_la_insercion_sin_ingresar_texto_en_el_campo_Observacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue("").into(OBSERVATIONS_TEXT_FIELD),
                Ensure.that(OBSERVATIONS_TEXT_FIELD).text().hasSize(0),
                Click.on(CONFIRMATION_INSERTION),
                Click.on(APPROVE_INSERTION),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
                Ensure.that(MESSAGE).text().containsIgnoringCase("Los registros se han insertado de forma satisfactoria")
        );


    }


    //@23542    Escenario: Registro de transacciones recarga con archivo excel insumo exitoso, sin seleccionar checkbox confirmacion de insercion

    @Dado("que se tiene un archivo excel de transacciones recarga exitoso")
    public void que_se_tiene_un_archivo_excel_de_transacciones_recarga_exitoso() {
        ExcelRechargeSuccessful.createExcelRechargeSuccessful(10, "ArchivoRecarga14");
    }

    @Cuando("no se selecciona el checkbox de confirmacion de Insercion")
    public void no_se_selecciona_el_checkbox_de_confirmacion_de_insercion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga14"),
                CheckResultTable.checkResultTable()
        );

    }

    @Entonces("no se habilita el boton de Aprobar insercion")
    public void no_se_habilita_el_boton_de_aprobar_insercion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue("").into(OBSERVATIONS_TEXT_FIELD),
                Ensure.that(APPROVE_INSERTION).isDisabled()
        );
    }

    // @23541 Escenario: Registro de transacciones recarga con archivo excel exitoso
    @Dado("que se tiene un archivo excel insumo con diez mil registros exitosos")
    public void que_se_tiene_un_archivo_excel_insumo_con_diez_mil_registros_exitosos() {
        ExcelRechargeSuccessful.createExcelRechargeSuccessful(10002, "ArchivoRecarga15");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Cuando("se selecciona el checkbox de confirmacion de Insercion")
    public void se_selecciona_el_checkbox_de_confirmacion_de_insercion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuRechargeTransactionRecord.goToTheMenu(),
                FileUploadRegister.fileUpload("ArchivoRecarga15"),
                CheckResultTable.checkResultTable()
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Entonces("se habilita el boton de Aprobar insercion")
    public void se_habilita_el_boton_de_aprobar_insercion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue("Los registros se han insertado de forma satisfactoria " + DATE).into(OBSERVATIONS_TEXT_FIELD),
                Click.on(CONFIRMATION_INSERTION),
                Click.on(APPROVE_INSERTION),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
                Ensure.that(MESSAGE).text().containsIgnoringCase("Los registros se han insertado de forma satisfactoria")
        );
    }

    @Entonces("se hace la insercion en las tablas de BD para auditoria")
    public void se_hace_la_insercion_en_las_tablas_de_bd_para_auditoria() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(QueryAuditFile.queryAuditFile("Los registros se han insertado de forma satisfactoria " + DATE)).isNotNull(),
                Ensure.that(CompareExcelFiles.comparedExcelFileBD("ArchivoRecarga15", "Los registros se han insertado de forma satisfactoria" + DATE)).isTrue()
        );
    }

}