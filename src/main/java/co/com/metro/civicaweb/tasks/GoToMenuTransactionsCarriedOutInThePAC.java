package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.metro.civicaweb.ui.TransactionsCarriedOutInThePAC.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToMenuTransactionsCarriedOutInThePAC implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_ATTENTION),
                Click.on(LINK_REPORT),
                Click.on(LINK_TRANSACTIONS_CARRIED_OUT_IN_THE_PAC)
        );
    }

    public static GoToMenuTransactionsCarriedOutInThePAC goToTheMenu() {
        return instrumented(GoToMenuTransactionsCarriedOutInThePAC.class);
    }
}
