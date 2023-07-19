package co.com.metro.civicaweb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AuditAndControl {

    //consulta por carga
    public static final Target AUDIT_AND_CONTROL_INSERTION_AND_DELETION = Target.the("Menu Auditoria y Control").located(By.id("ctl00_MenuLateral_repLista_ctl07_repItens_ctl00_hypLinkItem"));
    public static final Target INITIAL_DATE = Target.the("Fecha Inicial").located(By.id("ctl00_ContentPlaceHolder1_txtFechaInicial"));
    public static final Target FINAL_DATE = Target.the("Fecha Final").located(By.id("ctl00_ContentPlaceHolder1_txtFechaFinal"));
    public static final Target SEARCH_BUTTON = Target.the("Boton Buscar").located(By.id("ctl00_ContentPlaceHolder1_btnBuscar"));
    public static final Target REGISTER_GRID_VIEW = Target.the("fila de registros de la consulta").located(By.className("linhaDataGrid"));
    public static final Target REGISTER_GRID_VIEW2 = Target.the("fila de registros de la consulta").located(By.className("linhaDataGridAlt"));
    public static final Target DOWNLOAD_UPLOADED_FILE = Target.the("descarga de archivo cargado").located(By.id("ctl00_ContentPlaceHolder1_gv_Transaccion_Recarga_ctl02_imgBtnDescargarProc"));
    public static final Target DOWNLOAD_PROCESSED_FILE = Target.the("descarga de archivo procesado").located(By.id("ctl00_ContentPlaceHolder1_gv_Transaccion_Recarga_ctl02_imgBtnDescargarProcRealizados"));
    public static final Target GO_UP_BUTTON = Target.the("Boton ir arriba").located(By.id("ctl00_ContentPlaceHolder1_FlechaCarga"));

    //consulta por transacciones
    public static final Target INITIAL_DATE2 = Target.the("Fecha Inicial").located(By.id("ctl00_ContentPlaceHolder1_txtFechaIni"));
    public static final Target FINAL_DATE2 = Target.the("Fecha Final").located(By.id("ctl00_ContentPlaceHolder1_txtFechaFin"));
    public static final Target CAR_ID_FIELD = Target.the("Numero de Tarjeta").located(By.id("ctl00_ContentPlaceHolder1_txtNumeroTarjeta"));
    public static final Target SESION_FIELD = Target.the("Sesion").located(By.id("ctl00_ContentPlaceHolder1_txtSesion"));
    public static final Target MOS_ID_FIELD = Target.the("Mos_id").located(By.id("ctl00_ContentPlaceHolder1_txtMosID"));
    public static final Target SEARCH_BUTTON2 = Target.the("Mos_id").located(By.name("ctl00$ContentPlaceHolder1$ctl00"));
    public static final Target DOWNLOAD_UPLOADED_FILE2 = Target.the("Descarga del archivo cargado").located(By.id("ctl00_ContentPlaceHolder1_gv_Trans_Recarga_ctl02_imgBtnDescargarCruce"));
    public static final Target SEE_MOVEMENTS = Target.the("Ver Movimientos").located(By.id("ctl00_ContentPlaceHolder1_gv_Trans_Recarga_ctl02_btnDetalles"));
    public static final Target POP_UP_SEE_MOVEMENTS = Target.the("Ventana Ver Movimientos").located(By.id("ctl00_ContentPlaceHolder1_pnlMspDet"));
    public static final Target POP_UP_SEE_MOVEMENTS2 = Target.the("Ventana Ver Movimientos").located(By.className("linhaDataGrid"));
    public static final Target FINISH_BUTTON = Target.the("Boton Finalizar").located(By.id("ctl00_ContentPlaceHolder1_btnVoltar"));





}
