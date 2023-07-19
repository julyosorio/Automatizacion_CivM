package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.metro.civicaweb.ui.RechargeTransactionRegister.RESULT_OF_LOAD;
import static co.com.metro.civicaweb.ui.RechargeTransactionRegister.SCROLL_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckResultTable implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(RESULT_OF_LOAD),
                Scroll.to(SCROLL_BUTTON)
        );

   }

    public static CheckResultTable checkResultTable() {
        return instrumented(CheckResultTable.class);
    }
}
