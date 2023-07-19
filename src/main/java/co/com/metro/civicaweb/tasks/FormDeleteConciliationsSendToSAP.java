package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.metro.civicaweb.ui.DeleteConciliationsSentToSAP.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FormDeleteConciliationsSendToSAP implements Task {

    int options;
    String dateInitial;
    String dateFinal;
    String references;
    String cod_conciliation;


    public FormDeleteConciliationsSendToSAP(int options, String dateInitial, String dateFinal, String references, String cod_conciliation) {
        this.options = options;
        this.dateInitial = dateInitial;
        this.dateFinal = dateFinal;
        this.references = references;
        this.cod_conciliation = cod_conciliation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (options) {
            case 1:
                //uno
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_CERTIFICATION_DATE_1),
                        Enter.theValue(dateFinal).into(FINAL_CERTIFICATION_DATE_1),
                        Click.on(CERTIFICATION_TYPE),
                        Click.on(CERTIFICATION_TYPE_ITEM_ALL),
                        Click.on(CERTIFICATION_TYPE_ITEM_15),
                        Click.on(CERTIFICATION_TYPE),
                        Click.on(SHIPPING_TYPE_BTN),
                        Click.on(SHIPPING_TYPE_ITEM_ALL),
                        Click.on(SHIPPING_TYPE_ITEM_1),
                        Click.on(SHIPPING_TYPE_BTN),
                        Click.on(STATE_BTN),
                        Click.on(STATE_ITEM_ALL),
                        Click.on(STATE_ITEM_2),
                        Click.on(STATE_BTN),
                        Click.on(SEARCH_BUTTON)
                );
                break;
            case 2:
                //varios
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_CERTIFICATION_DATE_1),
                        Enter.theValue(dateFinal).into(FINAL_CERTIFICATION_DATE_1),
                        Click.on(CERTIFICATION_TYPE),
                        Click.on(CERTIFICATION_TYPE_ITEM_ALL),
                        Click.on(CERTIFICATION_TYPE_ITEM_15),
                        Click.on(CERTIFICATION_TYPE_ITEM_13),
                        Click.on(CERTIFICATION_TYPE),
                        Click.on(SHIPPING_TYPE_BTN),
                        Click.on(SHIPPING_TYPE_ITEM_ALL),
                        Click.on(SHIPPING_TYPE_ITEM_3),
                        Click.on(SHIPPING_TYPE_ITEM_2),
                        Click.on(SHIPPING_TYPE_BTN),
                        Click.on(STATE_BTN),
                        Click.on(STATE_ITEM_ALL),
                        Click.on(STATE_ITEM_1),
                        Click.on(STATE_ITEM_2),
                        Click.on(STATE_ITEM_4),
                        Click.on(STATE_BTN),
                        Click.on(SEARCH_BUTTON)
                );
                break;
            case 3:
                //todos
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_CERTIFICATION_DATE_1),
                        Enter.theValue(dateFinal).into(FINAL_CERTIFICATION_DATE_1),
                        Click.on(SEARCH_BUTTON)
                );
                break;
            case 4:
                //Referencia
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_CERTIFICATION_DATE_1),
                        Enter.theValue(dateFinal).into(FINAL_CERTIFICATION_DATE_1),
                        Enter.theValue(references).into(REFERENCE),
                        Click.on(SEARCH_BUTTON)
                );
                break;
            case 5:
                //Codigo Conciliacion
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_CERTIFICATION_DATE_1),
                        Enter.theValue(dateFinal).into(FINAL_CERTIFICATION_DATE_1),
                        Enter.theValue(cod_conciliation).into(CONCILIATION_CODE),
                        Click.on(SEARCH_BUTTON)
                );
                break;
        }
    }

    public static FormDeleteConciliationsSendToSAP goToForm(int options, String dateInitial, String dateFinal, String references, String cod_conciliation) {
        return instrumented(FormDeleteConciliationsSendToSAP.class, options, dateInitial, dateFinal, references, cod_conciliation);
    }
}
