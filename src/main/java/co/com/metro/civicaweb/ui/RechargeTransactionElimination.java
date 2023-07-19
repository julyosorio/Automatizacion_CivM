package co.com.metro.civicaweb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RechargeTransactionElimination {


    public static final Target RECHARGE_TRANSACTION_ELIMINATION = Target.the("Eliminacion Transaccion Recarga").located(By.id("ctl00_MenuLateral_repLista_ctl07_repItens_ctl01_hypLinkItem"));
    public static final Target SELECT_FILE_ELIMINATION = Target.the("Boton Seleccionar Archivo a Cargar").located(By.id("ctl00_ContentPlaceHolder1_flpArchivo"));
    public static final Target LOAD_BUTTON_ELIMINATION = Target.the("Boton Cargar").located(By.id("ctl00_ContentPlaceHolder1_btnCargar"));
    public static final Target OBSERVATIONS_TEXT_FIELD_ELIMINATION = Target.the("Campo de Texto Observaciones").located(By.id("ctl00_ContentPlaceHolder1_txtObservaciones"));
    public static final Target CONFIRMATION_INSERTION_ELIMINATION = Target.the("CheckBox Confirmacion Borrado").located(By.id("ctl00_ContentPlaceHolder1_chkObservaciones"));
    public static final Target APPROVE_INSERTION_ELIMINATION = Target.the("Boton Aprobar").located(By.id("ctl00_ContentPlaceHolder1_btnAprobarBorrado"));
    public static final Target GENERATE_REPORT = Target.the("Boton Generar Reporte").located(net.serenitybdd.core.annotations.findby.By.id("ctl00_ContentPlaceHolder1_btnGenerarReporte"));
   // GRID
    public static final Target TITLE_GRID_VIEW = Target.the("Registro gridView").located(By.className("headerDataGrid"));
    public static final Target REGISTER_GRID_VIEW = Target.the("Registro gridView").located(By.className("linhaDataGrid"));
    public static final Target REGISTER_GRID_VIEW2 = Target.the("Registro gridView").located(By.className("linhaDataGridAlt"));
    public static final Target REGISTER_FOUND = Target.the("Registros Encontrados").located(net.serenitybdd.core.annotations.findby.By.id("ctl00_ContentPlaceHolder1_UsrRegistrosGrid2_panRegistrosEncontrados"));
    public static final Target SCROLL_BUTTON2 = Target.the("Boton Desplazamiento").located(net.serenitybdd.core.annotations.findby.By.id("hlVolverArriba"));




}
