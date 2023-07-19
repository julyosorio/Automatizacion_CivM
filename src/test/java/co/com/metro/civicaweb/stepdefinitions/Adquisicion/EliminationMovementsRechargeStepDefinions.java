package co.com.metro.civicaweb.stepdefinitions.Adquisicion;

import co.com.metro.civicaweb.data.querys.QueryAuditFile;
import co.com.metro.civicaweb.data.querys.QueryObservationsField;
import co.com.metro.civicaweb.tasks.*;
import co.com.metro.civicaweb.assertions.CompareExcelFiles;
import co.com.metro.civicaweb.utils.ExcelDelete.ExcelDeleteSuccessful;
import co.com.metro.civicaweb.utils.ExcelDelete.ExcelDeleteTitlesOnly;
import co.com.metro.civicaweb.utils.ExcelDelete.ExcelDeletedFieldDoesNotExistInDB;
import co.com.metro.civicaweb.utils.ExcelReload.ExcelEmpty;
import co.com.metro.civicaweb.utils.RemoveFileDownloads;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.metro.civicaweb.ui.PopUp.MESSAGE;
import static co.com.metro.civicaweb.ui.PopUp.POP_UP_WINDOW_TITLE;
import static co.com.metro.civicaweb.ui.RechargeTransactionElimination.*;
import static co.com.metro.civicaweb.utils.Constant.*;

public class EliminationMovementsRechargeStepDefinions {

    // @23545 Escenario: Eliminacion de movimientos recarga con archivo excel vacio
    @Dado("que se tiene un archivo excel para eliminacion vacio")
    public void que_se_tiene_un_archivo_excel_para_eliminacion_vacio() {
        ExcelEmpty.createExcelEmpty("ArchivoBorrado1");

    }

    @Cuando("se carga el archivo excel vacio en el formulario de eliminacion de movimientos")
    public void se_carga_el_archivo_excel_vacio_en_el_formulario_de_eliminacion_de_movimientos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuElimination.goToTheMenu(),
                FileUploadElimination.fileUpload("ArchivoBorrado1"),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE)
        );
    }

    @Entonces("en pantalla se visualiza un pop-up con el mensaje de error de archivo vacio")
    public void en_pantalla_se_visualiza_un_pop_up_con_el_mensaje_de_error_de_archivo_vacio() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(MESSAGE).text().containsIgnoringCase("El archivo no contiene ningún registro")
        );
    }

    // @23546 Escenario: Eliminacion de movimientos recarga con archivo excel, con solo la fila del titulo
    @Dado("que se tiene el archivo excel insumo con solo la fila con el titulo")
    public void que_se_tiene_el_archivo_excel_insumo_con_solo_la_fila_con_el_titulo() {
        ExcelDeleteTitlesOnly.createExcelDeleteTitlesOnly("ArchivoBorrado2");
    }

    @Cuando("se carga el archivo excel solo con los titulos, en el formulario de Eliminacion de movimientos")
    public void se_carga_el_archivo_excel_solo_con_los_titulos_en_el_formulario_de_eliminacion_de_movimientos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuElimination.goToTheMenu(),
                FileUploadElimination.fileUpload("ArchivoBorrado2"),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE)
        );
    }

    @Entonces("se observa en pantalla un pop-up con el mensaje de error sin registros")
    public void se_observa_en_pantalla_un_pop_up_con_el_mensaje_de_error_sin_registros() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(MESSAGE).text().isEqualTo("El archivo no contiene ningún registro")
        );
    }

    // @23548 Escenario: Eliminacion de movimientos recarga con archivo excel, con uno o mas registros con el MOS_ID que no existe en base de datos

    @Dado("que se tiene el archivo excel insumo con uno o mas registros con MOS_ID que no exista en la BD")
    public void que_se_tiene_el_archivo_excel_insumo_con_uno_o_mas_registros_con_mos_id_que_no_exista_en_la_bd() {
        ExcelDeletedFieldDoesNotExistInDB.createExcelDeletedFieldDoesNotExistInDB(10, "ArchivoBorrado3");

    }

    @Cuando("se carga el archivo excel con uno o mas registros con el MOS_ID que no existe en base de datos, en el formulario Eliminacion de transacciones recarga")
    public void se_carga_el_archivo_excel_con_uno_o_mas_registros_con_el_mos_id_que_no_existe_en_base_de_datos_en_el_formulario_eliminacion_de_transacciones_recarga() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuElimination.goToTheMenu(),
                FileUploadElimination.fileUpload("ArchivoBorrado3"),
                Scroll.to(SCROLL_BUTTON2)
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RemoveFileDownloads.removeFileDownloads("ReporteEliminaciónRegistros");
    }

    @Entonces("el sistema  muestra en pantalla la informacion cargada")
    public void el_sistema_muestra_en_pantalla_la_informacion_cargada() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TITLE_GRID_VIEW).text().containsIgnoringCase("# Sesión Mos_Id Tmo_Id Fecha Transacción Valor Transacción Card_Id Estado Observación")
        );

    }

    @Entonces("en el campo ESTADO para los registros con el MOS_ID no existente en la BD debe estar con el texto: Error y en el campo OBSERVACION debe decir: MOS_ID no encontrado")
    public void en_el_campo_estado_para_los_registros_con_el_mos_id_no_existente_en_la_bd_debe_estar_con_el_texto_error_y_en_el_campo_observacion_debe_decir_mos_id_no_encontrado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(REGISTER_GRID_VIEW).text().containsIgnoringCase("CON ERROR Mos_Id inexistente"),
                Ensure.that(REGISTER_GRID_VIEW2).text().containsIgnoringCase("CON ERROR Mos_Id inexistente")
        );
    }

    @Entonces("se crea y descarga un archivo excel Reporte con la informacion cargada en el excel inicial")
    public void se_crea_y_descarga_un_archivo_excel_reporte_con_la_informacion_cargada_en_el_excel_inicial() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(CompareExcelFiles.compareExcelFilesDelete("ReporteEliminaciónRegistros", "ArchivoBorrado3")).isTrue()
        );
    }

    // @24475 Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, ingresando en el campo Observación texto con menos de doscientos cincuenta y cuatro  caracteres

    @Dado("que se tiene un archivo excel insumo para el borrado, exitoso")
    public void que_se_tiene_un_archivo_excel_insumo_para_el_borrado_exitoso() {
        ExcelDeleteSuccessful.createExcelDeleteSuccessful(2, "ArchivoBorrado4");
    }

    @Cuando("se ingresa en el campo OBSERVACION un texto con menos doscientos cincuenta y cuatro  caracteres")
    public void se_ingresa_en_el_campo_observacion_un_texto_con_menos_doscientos_cincuenta_y_cuatro_caracteres() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuElimination.goToTheMenu(),
                FileUploadElimination.fileUpload("ArchivoBorrado4"),
                Click.on(GENERATE_REPORT),
                Scroll.to(SCROLL_BUTTON2)
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RemoveFileDownloads.removeFileDownloads("ReporteEliminaciónRegistros");
    }

    @Entonces("se realiza el borrado exitoso")
    public void se_realiza_el_borrado_exitoso() {
        RemoveFileDownloads.removeFileDownloads("ReporteEliminaciónRegistros");
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(CompareExcelFiles.compareExcelFilesDelete("ReporteEliminaciónRegistros", "ArchivoBorrado4")).isTrue(),
                Enter.theValue("Borrado Archivo exitosos " + DATE).into(OBSERVATIONS_TEXT_FIELD_ELIMINATION),
                Click.on(CONFIRMATION_INSERTION_ELIMINATION),
                Click.on(APPROVE_INSERTION_ELIMINATION),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
                Ensure.that(MESSAGE).text().containsIgnoringCase("Los registros se han eliminado de forma satisfactoria.")
        );

    }

    @Entonces("se actualiza las tablas de auditoria con las registros cargados en el excel inicial")
    public void se_actualiza_las_tablas_de_auditoria_con_las_registros_cargados_en_el_excel_inicial() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(QueryAuditFile.queryDetailAuditFileDelete("Borrado Archivo exitosos " + DATE)).isNotNull(),
                Ensure.that(CompareExcelFiles.comparedExcelFileDeleteBD("ArchivoBorrado4", "Borrado Archivo exitosos" + DATE)).isTrue()
        );
    }


    //  @24476 Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, ingresando en el campo Observación texto con mas de doscientos cincuenta y cuatro  caracteres

    @Dado("que se tiene un archivo excel insumo para el borrado de registros")
    public void que_se_tiene_un_archivo_excel_insumo_para_el_borrado_de_registros() {
        ExcelDeleteSuccessful.createExcelDeleteSuccessful(2, "ArchivoBorrado5");
    }

    @Cuando("se ingresa en el campo OBSERVACION un texto de mas doscientos cincuenta y cuatro  caracteres")
    public void se_ingresa_en_el_campo_observacion_un_texto_de_mas_doscientos_cincuenta_y_cuatro_caracteres() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuElimination.goToTheMenu(),
                FileUploadElimination.fileUpload("ArchivoBorrado5"),
                Scroll.to(SCROLL_BUTTON2),
                Enter.theValue(DATE + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's " +
                        "standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry").into(OBSERVATIONS_TEXT_FIELD_ELIMINATION)
        );

    }

    @Entonces("en el campo Observacion solo permite doscientos cincuenta y cuatro  caracteres")
    public void en_el_campo_observacion_solo_permite_doscientos_cincuenta_y_cuatro_caracteres() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(OBSERVATIONS_TEXT_FIELD_ELIMINATION).text().hasSizeBetween(0, 254)
        );
    }

    @Entonces("se hace el borrado exitoso")
    public void se_hace_el_borrado_exitoso() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(CONFIRMATION_INSERTION_ELIMINATION),
                Click.on(APPROVE_INSERTION_ELIMINATION),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
                Ensure.that(MESSAGE).text().containsIgnoringCase("Los registros se han eliminado de forma satisfactoria.")
        );
    }

    @Entonces("al consultar la tabla auditoria en el campo ARE_OBSERVACION se observa texto doscientos cincuenta y cuatro  caracteres")
    public void al_consultar_la_tabla_auditoria_en_el_campo_are_observacion_se_observa_texto_doscientos_cincuenta_y_cuatro_caracteres() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(QueryObservationsField.query(DATE + "Lorem Ipsum is simply dummy text of the printing and typesetting industry.")).isTrue(),
                Ensure.that(CompareExcelFiles.comparedExcelFileDeleteBD("ArchivoBorrado5", DATE + "Lorem Ipsum is simply dummy text of the printing and typesetting industry.")).isTrue()
        );
    }


    //@24477 Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, ingresando en el campo Observación texto con doscientos cincuenta y cuatro  caracteres

    @Dado("que se tiene un archivo excel insumo para el borrado")
    public void que_se_tiene_un_archivo_excel_insumo_para_el_borrado() {
        ExcelDeleteSuccessful.createExcelDeleteSuccessful(2, "ArchivoBorrado6");
    }

    @Cuando("se ingresa en el campo OBSERVACION un texto de doscientos cincuenta y cuatro  caracteres")
    public void se_ingresa_en_el_campo_observacion_un_texto_de_doscientos_cincuenta_y_cuatro_caracteres() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuElimination.goToTheMenu(),
                FileUploadElimination.fileUpload("ArchivoBorrado6"),
                Scroll.to(SCROLL_BUTTON2),
                Enter.theValue(DATE + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's " +
                        "standard dummy text ever since the 1500s, when an unknown printer took a ").into(OBSERVATIONS_TEXT_FIELD_ELIMINATION)
        );
    }

    @Entonces("al consultar la tabla auditoria_recarga_externa en el campo ARE_OBSERVACION se observa texto doscientos cincuenta y cuatro  caracteres")
    public void al_consultar_la_tabla_auditoria_recarga_externa_en_el_campo_are_observacion_se_observa_texto_doscientos_cincuenta_y_cuatro_caracteres() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(OBSERVATIONS_TEXT_FIELD_ELIMINATION).text().hasSizeBetween(0, 254)
        );
    }

    //@24478 Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, sin ingresar texto en el campo Observación

    @Dado("que se tiene un archivo excel para el borrado")
    public void que_se_tiene_un_archivo_excel_para_el_borrado() {
        ExcelDeleteSuccessful.createExcelDeleteSuccessful(2, "ArchivoBorrado7");
    }

    @Cuando("no se ingresa texto en el campo OBSERVACION")
    public void no_se_ingresa_texto_en_el_campo_observacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuElimination.goToTheMenu(),
                FileUploadElimination.fileUpload("ArchivoBorrado7"),
                Scroll.to(SCROLL_BUTTON2),
                Enter.theValue("").into(OBSERVATIONS_TEXT_FIELD_ELIMINATION)
        );
    }

    @Entonces("se hace el borrado exitoso de los registros ingresados")
    public void se_hace_el_borrado_exitoso_de_los_registros_ingresados() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(CONFIRMATION_INSERTION_ELIMINATION),
                Click.on(APPROVE_INSERTION_ELIMINATION),
                Switch.toWindowTitled(POP_UP_WINDOW_TITLE),
                Ensure.that(MESSAGE).text().containsIgnoringCase("Los registros se han eliminado de forma satisfactoria.")
        );
    }

    @Entonces("al consultar la tabla auditoria_recarga_externa en el campo ARE_OBSERVACION se observa vacio")
    public void al_consultar_la_tabla_auditoria_recarga_externa_en_el_campo_are_observacion_se_observa_vacio() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(QueryObservationsField.query("")).isTrue(),
                Ensure.that(CompareExcelFiles.comparedExcelFileDeleteBD("ArchivoBorrado7", "")).isTrue()
        );
    }

    // @23550 Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, Aprobar borrado sin seleccionar casilla de confirmación de borrado

    @Dado("que se tiene un archivo excel exitoso de borrado")
    public void que_se_tiene_un_archivo_excel_exitoso_de_borrado() {
        ExcelDeleteSuccessful.createExcelDeleteSuccessful(2, "ArchivoBorrado8");
    }

    @Cuando("se pulsa el boton Aprobar borrado sin seleccionar casilla de confirmacion de borrado")
    public void se_pulsa_el_boton_aprobar_borrado_sin_seleccionar_casilla_de_confirmacion_de_borrado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withUserAndPass(USER_CIVICA, PASS_CIVICA),
                GoToTheMenuElimination.goToTheMenu(),
                FileUploadElimination.fileUpload("ArchivoBorrado8"),
                Scroll.to(SCROLL_BUTTON2),
                Enter.theValue("ArchivoBorradoExitoso" + DATE).into(OBSERVATIONS_TEXT_FIELD_ELIMINATION)
        );
    }

    @Entonces("no se hace el borrado exitoso")
    public void no_se_hace_el_borrado_exitoso() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(APPROVE_INSERTION_ELIMINATION).isDisabled()
        );
    }

}
