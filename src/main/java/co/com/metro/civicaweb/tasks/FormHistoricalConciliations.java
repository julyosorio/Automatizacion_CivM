package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.metro.civicaweb.ui.DeleteConciliationsSentToSAP.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FormHistoricalConciliations implements Task {

    String dateInitial;
    String dateFinal;

    public FormHistoricalConciliations(String dateInitial, String dateFinal) {
        this.dateInitial = dateInitial;
        this.dateFinal = dateFinal;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(dateInitial).into(INITIAL_CERTIFICATION_DATE_2),
                Enter.theValue(dateFinal).into(FINAL_CERTIFICATION_DATE_2),
                Click.on(GENERATE_REPORT_BUTTON),
                Click.on(SEARCH_BUTTON2)
        );
    }

    public static FormHistoricalConciliations goToForm(String dateInitial, String dateFinal) {
        return instrumented(FormHistoricalConciliations.class, dateInitial, dateFinal);
    }
}
