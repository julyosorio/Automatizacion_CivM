package co.com.metro.civicaweb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DeleteConciliationsSentToSAP {

    public static final Target LINK_COMPENSATION = Target.the("link Compesacion").located(By.id("ctl00_Header1_repModulos_ctl04_hypLink"));
    public static final Target LINK_CONCILIATION = Target.the("link Conciliacion").located(By.id("ctl00_MenuLateral_repLista_ctl00_hypLink"));
    public static final Target LINK_DELETE_CONCILIATION = Target.the("link Eliminar Conciliaciones Enviadas a SAP").located(By.xpath("//td/a[text()='Eliminar Conciliaciones Enviadas a SAP']"));
    //Formulario Eliminar Conciliaciones Enviadas a SAP
    public static final Target INITIAL_CERTIFICATION_DATE_1 = Target.the("Fecha Certificacion Inicial").located(By.id("ctl00_ContentPlaceHolder1_txtFechaCertInicial"));
    public static final Target FINAL_CERTIFICATION_DATE_1 = Target.the("Fecha Certificacion Final").located(By.id("ctl00_ContentPlaceHolder1_txtFechafinal"));
    //TIPO CERTIFICACION
    public static final Target CERTIFICATION_TYPE = Target.the("Tipo Certificacion").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > button[type=\"button\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_ALL = Target.the("Tipo Certificacion Todos").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li.ms-select-all > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_1 = Target.the("Tipo Certificacion Bco Occidente").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(2) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_2 = Target.the("Tipo Certificación Cargas Empresariales").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(3) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_3 = Target.the("Tipo Certificación Compusafe").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(4) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_4 = Target.the("Tipo Certificacion Daviplata").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(5) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_5 = Target.the("Tipo Certificación en SAP").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(6) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_6 = Target.the("Tipo Certificacion GMP").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(7) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_7 = Target.the("Tipo Certificación Línea H").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(8) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_8 = Target.the("Tipo Certificacion Linea1 GANA").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(9) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_9 = Target.the("Tipo Certificación Metro").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(10) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_10 = Target.the("Tipo Certificación MRA Metro").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(11) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_11 = Target.the("Tipo Certificacion MRA Tranvia").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(12) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_12 = Target.the("Tipo Certificación NEQUI").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(13) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_13 = Target.the("Tipo Certificación Otros Conceptos").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(14) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_14 = Target.the("Tipo Certificación PSE").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(15) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_15 = Target.the("Tipo Certificación Recepción FF").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(16) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_16 = Target.the("Tipo Certificación Recicla").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(17) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_17 = Target.the("Tipo Certificacion Redex").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(18) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_18 = Target.the("Tipo Certificación RV GANA").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(19) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_19 = Target.the("Tipo Reporte Civica Pay - Cash In").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(20) > label > input[type=\"checkbox\"]"));
    public static final Target CERTIFICATION_TYPE_ITEM_20 = Target.the("Tipo Sin certificación").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(2) > div > div > ul > li:nth-child(21) > label > input[type=\"checkbox\"]"));
    //TIPO ENVIO
    public static final Target SHIPPING_TYPE_BTN = Target.the("Boton Tipo Envio").located(By.cssSelector("form#aspnetForm tr.ColunaTitulo > td:nth-child(2) > div > button[type=\"button\"]"));
    public static final Target SHIPPING_TYPE_ITEM_ALL = Target.the("Tipo Envio Todos").located(By.cssSelector("form#aspnetForm tr.ColunaTitulo > td:nth-child(2) > div > div > ul > li.ms-select-all > label > input[type=\"checkbox\"]"));
    public static final Target SHIPPING_TYPE_ITEM_1 = Target.the("Tipo Envio PA").located(By.cssSelector("form#aspnetForm tr.ColunaTitulo > td:nth-child(2) > div > div > ul > li:nth-child(2) > label > input[type=\"checkbox\"]"));
    public static final Target SHIPPING_TYPE_ITEM_2 = Target.the("Tipo Envio CMNC").located(By.cssSelector("form#aspnetForm tr.ColunaTitulo > td:nth-child(2) > div > div > ul > li:nth-child(3) > label > input[type=\"checkbox\"]"));
    public static final Target SHIPPING_TYPE_ITEM_3 = Target.the("Tipo Envio CMC").located(By.cssSelector("form#aspnetForm tr.ColunaTitulo > td:nth-child(2) > div > div > ul > li:nth-child(4) > label > input[type=\"checkbox\"]"));
    public static final Target SHIPPING_TYPE_ITEM_4 = Target.the("Tipo Envio CIV").located(By.cssSelector("form#aspnetForm tr.ColunaTitulo > td:nth-child(2) > div > div > ul > li:nth-child(5) > label > input[type=\"checkbox\"]"));
    public static final Target SHIPPING_TYPE_ITEM_5 = Target.the("Tipo Envio C").located(By.cssSelector("form#aspnetForm tr.ColunaTitulo > td:nth-child(2) > div > div > ul > li:nth-child(6) > label > input[type=\"checkbox\"]"));
    public static final Target SHIPPING_TYPE_ITEM_6 = Target.the("Tipo Envio NC").located(By.cssSelector("form#aspnetForm tr.ColunaTitulo > td:nth-child(2) > div > div > ul > li:nth-child(7) > label > input[type=\"checkbox\"]"));
    //ESTADO
    public static final Target STATE_BTN = Target.the("Boton Estado").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(4) > div > button[type=\"button\"] > div"));
    public static final Target STATE_ITEM_ALL = Target.the("Item Estado Todos").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(4) > div > div > ul > li.ms-select-all > label > input[type=\"checkbox\"]"));
    public static final Target STATE_ITEM_1 = Target.the("Item Estado Exitoso").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(4) > div > div > ul > li:nth-child(2) > label > input[type=\"checkbox\"]"));
    public static final Target STATE_ITEM_2 = Target.the("Item Estado Con error validación SAP").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(4) > div > div > ul > li:nth-child(3) > label > input[type=\"checkbox\"]"));
    public static final Target STATE_ITEM_3 = Target.the("Item Estado Con error conciliación SAP").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(4) > div > div > ul > li:nth-child(4) > label > input[type=\"checkbox\"]"));
    public static final Target STATE_ITEM_4 = Target.the("Item Estado En proceso").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(4) > div > div > ul > li:nth-child(5) > label > input[type=\"checkbox\"]"));
    public static final Target STATE_ITEM_5 = Target.the("Item Estado No enviado a SAP").located(By.cssSelector("tr#ctl00_ContentPlaceHolder1_ordenfila td:nth-child(4) > div > div > ul > li:nth-child(6) > label > input[type=\"checkbox\"]"));
    //
    public static final Target CONCILIATION_CODE = Target.the("Codigo Conciliacion").located(By.id("ctl00_ContentPlaceHolder1_txtCodigoConc"));
    public static final Target REFERENCE = Target.the("Referencia").located(By.id("ctl00_ContentPlaceHolder1_txtReferencia"));
    public static final Target SEARCH_BUTTON = Target.the("Boton Buscar").located(By.id("ctl00_ContentPlaceHolder1_btnBuscar"));
    //POPUP
    public static final Target OBSERVATION = Target.the("campo texto observacion").located(By.id("ctl00_ContentPlaceHolder1_txtObserv"));
    public static final Target BTN_COMFIRM = Target.the("Boton confirmacion de eliminacion").located(By.id("ctl00_ContentPlaceHolder1_btnAceptar"));
    public static final Target BTN_CANCEL = Target.the("Boton cancelar eliminacion").located(By.id("ctl00_ContentPlaceHolder1_btnCancelar"));
    //GRID
    public static final Target GRID_TITLE = Target.the("Titulos del Grid").located(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdEliminarConciliaciones']/tbody/tr[contains(@class,'headerDataGrid')]"));
    public static final Target BTN_DELETE = Target.the("Boton Accion Eliminar").located(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdEliminarConciliaciones']/tbody/tr[contains(@class,'linhaDataGrid')]/*[last()]"));
    //Formulario Historico Conciliaciones
    public static final Target INITIAL_CERTIFICATION_DATE_2 = Target.the("Fecha Certificacion Inicial").located(By.id("ctl00_ContentPlaceHolder1_txtFechaInicialDos"));
    public static final Target FINAL_CERTIFICATION_DATE_2 = Target.the("Fecha Certificacion Final").located(By.id("ctl00_ContentPlaceHolder1_txtFechaFinalDos"));
    public static final Target SEARCH_BUTTON2 = Target.the("Boton Buscar").located(By.id("ctl00_ContentPlaceHolder1_btnBuscarHistorico"));
    public static final Target GENERATE_REPORT_BUTTON = Target.the("Boton Generar Reporte").located(By.id("ctl00_ContentPlaceHolder1_btnGenerarReporte"));
    //Grid Historico
    public static final Target POP_UP_GRID = Target.the("pop_up Grid").located(By.id("mdlPopUpGridHistorico_foregroundElement"));
    public static final Target GRID_TITLE_HISTORICO = Target.the("Titulos del Grid").located(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr[@class ='headerDataGrid']"));
    public static final Target GRID_VIEW_CONC_CIVICA = Target.the("Link Ver XML CONC CIVICA").located(By.id("ctl00_ContentPlaceHolder1_grvHistConcEliminadas_ctl02_lnkConciliaCivica"));
    public static final Target GRID_VIEW_VALID_SAP = Target.the("Link Ver XML VALID SAP").located(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas_ctl02_lnkValidaSAP']"));
    public static final Target GRID_VIEW_CONC_SAP = Target.the("Link Ver XML CONC SAP").located(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas_ctl02_lnkConciliaSAP']"));
    public static final Target GRID_VIEW_RESP_CIVICA = Target.the("Link Ver XML RESP CIVICA").located(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas_ctl02_lnkRespuestaCivica']"));
    //POP UP XML
    public static final Target POP_UP_XML = Target.the("ventana emergente para ver xml").located(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_pnlVisorXML']"));
    public static final Target CONTENT_XML = Target.the("contenido xml").located(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_textoXml']"));
    public static final Target BTN_TEXT_DOWNLOAD = Target.the("Boton descargar texto xml").located(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnDescargar']"));
    public static final Target BTN_CLOSE = Target.the("Boton cerrar").located(By.id("ctl00_ContentPlaceHolder1_btnOkMotivos"));




}
