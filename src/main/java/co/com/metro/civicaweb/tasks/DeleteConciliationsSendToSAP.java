package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.metro.civicaweb.ui.DeleteConciliationsSentToSAP.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteConciliationsSendToSAP implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
         actor.attemptsTo(
                 Click.on(BTN_DELETE),
                 Enter.theValue("Eliminacion de Concialiaciones Enviadas a SAP").into(OBSERVATION)
         );
    }

    public static DeleteConciliationsSendToSAP goToTheMenuDeleteConciliations() {
        return instrumented(DeleteConciliationsSendToSAP.class);
    }
}
