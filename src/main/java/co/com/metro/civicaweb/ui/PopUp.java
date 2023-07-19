package co.com.metro.civicaweb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PopUp {

    public static final String POP_UP_WINDOW_TITLE= "Metro Medellín - [ Mensaje ]";
    public static final Target MESSAGE = Target.the("Pop-up Registro Transaccion Recarga").located(By.xpath("//*[@id='lblMensagem']"));
    public static final Target BTN_OK = Target.the("Boton OK").located(By.id("btnOk"));

}
