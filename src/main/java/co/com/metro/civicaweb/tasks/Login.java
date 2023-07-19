package co.com.metro.civicaweb.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.metro.civicaweb.ui.LoginPage.*;
import static co.com.metro.civicaweb.utils.Constant.URL;


public class Login implements Task {

    private String user;
    private String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL),
                Enter.theValue(user).into(TXT_USER),
                Enter.theValue(password).into(TXT_PASSWORD),
                Click.on(BOTON_OK)
        );

    }

    public static Login withUserAndPass(String user, String password) {
        return Tasks.instrumented(Login.class, user, password);
    }
}
