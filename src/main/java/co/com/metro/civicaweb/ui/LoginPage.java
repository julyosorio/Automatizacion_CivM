package co.com.metro.civicaweb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target TXT_USER = Target.the("Nombre Usuario").located(By.id("txtLogin"));
    public static final Target TXT_PASSWORD = Target.the("Contraseña").located(By.id("txtSena"));
    public static final Target BOTON_OK = Target.the("Boton OK").located(By.id("btnOk"));

}
