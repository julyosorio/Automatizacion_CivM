package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.metro.civicaweb.ui.DeleteConciliationsSentToSAP.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToDeleteConciliationsSendToSAP implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_COMPENSATION),
                Click.on(LINK_CONCILIATION),
                Click.on(LINK_DELETE_CONCILIATION)
        );
    }

    public static GoToDeleteConciliationsSendToSAP goToTheMenu() {
        return instrumented(GoToDeleteConciliationsSendToSAP.class);
    }
}
