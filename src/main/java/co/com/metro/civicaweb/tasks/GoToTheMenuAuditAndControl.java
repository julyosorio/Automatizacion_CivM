package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.metro.civicaweb.ui.AuditAndControl.AUDIT_AND_CONTROL_INSERTION_AND_DELETION;
import static co.com.metro.civicaweb.ui.RechargeTransactionRegister.ACQUISITION;
import static co.com.metro.civicaweb.ui.RechargeTransactionRegister.EXTERNAL_RECHARGE_NETWORK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToTheMenuAuditAndControl implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ACQUISITION),
                Click.on(EXTERNAL_RECHARGE_NETWORK),
                Click.on(AUDIT_AND_CONTROL_INSERTION_AND_DELETION)
        );
    }

    public static GoToTheMenuAuditAndControl goToTheMenu() {
        return instrumented(GoToTheMenuAuditAndControl.class);
    }
}
