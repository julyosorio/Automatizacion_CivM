package co.com.metro.civicaweb.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;


public class RechargeTransactionRegister {

    public static final Target ACQUISITION = Target.the("Adquisicion").located(By.id("ctl00_Header1_repModulos_ctl01_hypLink"));
    public static final Target EXTERNAL_RECHARGE_NETWORK = Target.the("Red Recarga Externa").located(By.id("ctl00_MenuLateral_repLista_ctl07_hypLink"));
    public static final Target RECHARGE_TRANSACTION_REGISTER = Target.the("Registro Transaccion Recarga").located(By.id("ctl00_MenuLateral_repLista_ctl07_repItens_ctl03_hypLinkItem"));
    public static final Target SELECT_FILE = Target.the("Boton Seleccionar Archivo").located(By.id("ctl00_ContentPlaceHolder1_flpRegistroRecargaExterna"));
    public static final Target TRANSACTION_TYPE_MENU = Target.the("Menu Tipo Transaccion").located(By.id("ctl00_ContentPlaceHolder1_ddlTipoTransaccion"));
    public static final Target LOAD_BUTTON = Target.the("Boton Cargar Archivo").located(By.id("ctl00_ContentPlaceHolder1_btnCargar"));
    public static final Target VALID_REGISTER = Target.the("Registros Validos").located(By.id("ctl00_ContentPlaceHolder1_lblRegistrosValidos"));
    public static final Target NO_VALID_REGISTER = Target.the("Registros No Validos").located(By.id("ctl00_ContentPlaceHolder1_lblRegistrosNoValidos"));
    public static final Target TOTAL_REGISTER = Target.the("Registros totales").located(By.id("ctl00_ContentPlaceHolder1_lblTotalRegistros"));
    public static final Target OBSERVATIONS_TEXT_FIELD = Target.the("Campo de Texto Observaciones").located(By.id("ctl00_ContentPlaceHolder1_txtObserv"));
    public static final Target CONFIRMATION_INSERTION = Target.the("CheckBox Confirmacion Insercion").located(By.id("ctl00_ContentPlaceHolder1_chkConfirmar"));
    public static final Target APPROVE_INSERTION = Target.the("Boton Aprobar").located(By.id("ctl00_ContentPlaceHolder1_btnAprobar"));
    public static final Target GENERATE_REPORT = Target.the("Boton Generar Reporte").located(By.id("ctl00_ContentPlaceHolder1_btnGenerarReporte"));
    public static final Target RESULT_OF_LOAD_TEXT = Target.the("Texto Resultado de Carga").located(By.id("ctl00_ContentPlaceHolder1_lblTituloGrid"));
    //GRID
    public static final Target RESULT_OF_LOAD = Target.the("Grid Resultado de Carga").located(By.id("ctl00_ContentPlaceHolder1_tblGrid"));
    public static final Target GRID_TITLES = Target.the("Titulos Grid").located(By.className("headerDataGrid"));
    public static final Target REGISTER_GRID_VIEW = Target.the("Registro gridView").located(By.className("linhaDataGrid"));
    public static final Target REGISTER_GRID_VIEW2 = Target.the("Registro gridView").located(By.className("linhaDataGridAlt"));
    public static final Target SCROLL_BUTTON = Target.the("Boton Desplazamiento").located(By.id("ctl00_ContentPlaceHolder1_hpVolverArriba"));
    public static final Target REGISTER_FOUND = Target.the("Registros Encontrados").located(By.id("ctl00_ContentPlaceHolder1_UsrRegistrosGrid2_panRegistrosEncontrados"));
    //PAGINATION
    public static final Target PAGINATION = Target.the("Paginacion").located(By.linkText("2"));



}
