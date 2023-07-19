package co.com.metro.civicaweb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class TransactionsCarriedOutInThePAC {

    public static final Target LINK_ATTENTION = Target.the("Atencion").located(By.id("ctl00_Header1_repModulos_ctl02_hypLink"));
    public static final Target LINK_REPORT = Target.the("Reportes").located(By.id("ctl00_MenuLateral_repLista_ctl07_hypLink"));
    public static final Target LINK_TRANSACTIONS_CARRIED_OUT_IN_THE_PAC = Target.the("Transacciones realizadas en el PAC").located(By.id("ctl00_MenuLateral_repLista_ctl07_repItens_ctl12_hypLinkItem"));
    //FORMULARIO
    public static final Target INITIAL_DATE = Target.the("Fecha Inicial").located(By.id("ctl00_ContentPlaceHolder1_txtFechaIni"));
    public static final Target FINAL_DATE = Target.the("Fecha Final").located(By.id("ctl00_ContentPlaceHolder1_txtFechaFim"));
    //TIPO TRANSACCION
    public static final Target TRANSACTION_TYPE_BTN = Target.the("Btn Tipo de Transaccion").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel tr:nth-child(2) > td:nth-child(2) > div > button[type=\"button\"] "));
    public static final Target TRANSACTION_TYPE_ALL = Target.the("Tipo de Transaccion Todos").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(2) > div > div > ul > li.ms-select-all"));
    public static final Target TRANSACTION_TYPE_ITEMS1 = Target.the("Tipo de Transaccion items 1").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(2) > div > div > ul > li:nth-child(2) > label > input[type=\"checkbox\"]"));
    public static final Target TRANSACTION_TYPE_ITEMS2 = Target.the("Tipo de Transaccion items 2").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(2) > div > div > ul > li:nth-child(3) > label > input[type=\"checkbox\"]"));
    public static final Target TRANSACTION_TYPE_ITEMS3 = Target.the("Tipo de Transaccion items 3").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(2) > div > div > ul > li:nth-child(4) > label > input[type=\"checkbox\"]"));
    public static final Target TRANSACTION_TYPE_ITEMS4 = Target.the("Tipo de Transaccion items 4").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(2) > div > div > ul > li:nth-child(5) > label > input[type=\"checkbox\"]"));
    public static final Target TRANSACTION_TYPE_ITEMS5 = Target.the("Tipo de Transaccion items 5").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(2) > div > div > ul > li:nth-child(6) > label > input[type=\"checkbox\"]"));
    public static final Target TRANSACTION_TYPE_ITEMS6 = Target.the("Tipo de Transaccion items 6").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(2) > div > div > ul > li:nth-child(7) > label > input[type=\"checkbox\"]"));
    public static final Target TRANSACTION_TYPE_ITEMS7 = Target.the("Tipo de Transaccion items 7").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(2) > div > div > ul > li:nth-child(8) > label > input[type=\"checkbox\"]"));
    //PAC
    public static final Target PAC_BTN = Target.the("Menu PAC").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(4) > div > button[type=\"button\"]"));
    public static final Target PAC_ALL = Target.the("Menu PAC Item Todos").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(4) > div > div > ul > li.ms-select-all > label > input[type=\"checkbox\"]"));
    public static final Target PAC_ITEM1 = Target.the("Menu PAC Item 1").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(4) > div > div > ul > li:nth-child(2) > label > input[type=\"checkbox\"]"));
    public static final Target PAC_ITEM2 = Target.the("Menu PAC Item 2").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(4) > div > div > ul > li:nth-child(3) > label > input[type=\"checkbox\"]"));
    public static final Target PAC_ITEM3 = Target.the("Menu PAC Item 3").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(4) > div > div > ul > li:nth-child(4) > label > input[type=\"checkbox\"]"));
    public static final Target PAC_ITEM4 = Target.the("Menu PAC Item 4").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(4) > div > div > ul > li:nth-child(5) > label > input[type=\"checkbox\"]"));
    public static final Target PAC_ITEM5 = Target.the("Menu PAC Item 4").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(4) > div > div > ul > li:nth-child(6) > label > input[type=\"checkbox\"]"));
    public static final Target PAC_ITEM6 = Target.the("Menu PAC Item 4").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel td:nth-child(4) > div > div > ul > li:nth-child(7) > label > input[type=\"checkbox\"]"));
    public static final Target OUT_FORM = Target.the("fuera del formulario").located(By.cssSelector("form#aspnetForm table:nth-child(4) > tbody > tr:nth-child(1) > td:nth-child(3)"));
    //OPERADOR
    public static final Target BTN_OPERATOR = Target.the("Boton Operador").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel tr:nth-child(3) > td.ColunaSubTitulo > div > button[type=\"button\"]"));
    public static final Target TEXT_OPERATOR = Target.the("Texto Operador").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel div > input[type=\"text\"]"));
    //ojo tener encuenta que se debe cambiar dependiendo del operador que se desea buscar
    public static final Target SELECT_OPERATOR = Target.the("CheckBox Operador").located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel li:nth-child(265) > label > input[type=\"radio\"]"));
    public static final Target CLEAN_BUTTON = Target.the("Boton limpiar").located(By.id("ctl00_ContentPlaceHolder1_btnLipiarOperador"));
    public static final Target CLEAN_BUTTON_FORM = Target.the("Boton limpiar Formulario").located(By.id("Button2"));
    public static final Target GENERATE_REPORT_BUTTON = Target.the("Boton Generar Reporte").located(By.id("ctl00_ContentPlaceHolder1_Button1"));
    //
    public static final Target TYPETRANSACTION = Target.the("TIPO TRANSACCION").
            located(By.cssSelector("div#ctl00_ContentPlaceHolder1_updPanel tr:nth-child(2) > td:nth-child(2) > div > div > ul > li:nth-child(2) > label > span"));



}
