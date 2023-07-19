package co.com.metro.civicaweb.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.metro.civicaweb.ui.RechargeTransactionRegister.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToTheMenuRechargeTransactionRecord implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ACQUISITION),
                Click.on(EXTERNAL_RECHARGE_NETWORK),
                Click.on(RECHARGE_TRANSACTION_REGISTER)
        );

    }

    public static GoToTheMenuRechargeTransactionRecord goToTheMenu() {
        return instrumented(GoToTheMenuRechargeTransactionRecord.class);
    }
}
