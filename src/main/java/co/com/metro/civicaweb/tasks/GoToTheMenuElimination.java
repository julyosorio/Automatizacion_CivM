package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.metro.civicaweb.ui.RechargeTransactionElimination.RECHARGE_TRANSACTION_ELIMINATION;
import static co.com.metro.civicaweb.ui.RechargeTransactionRegister.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToTheMenuElimination implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ACQUISITION),
                Click.on(EXTERNAL_RECHARGE_NETWORK),
                Click.on(RECHARGE_TRANSACTION_ELIMINATION)
        );
    }

    public static GoToTheMenuElimination goToTheMenu() {
        return instrumented(GoToTheMenuElimination.class);
    }
}
