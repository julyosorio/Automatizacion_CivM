package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.metro.civicaweb.ui.TransactionsCarriedOutInThePAC.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FormTransactionsCarriedOutInThePAC implements Task {

    int options;
    String dateInitial;
    String dateFinal;


    public FormTransactionsCarriedOutInThePAC(int options, String dateInitial, String dateFinal) {
        this.options = options;
        this.dateInitial = dateInitial;
        this.dateFinal = dateFinal;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (options) {
            case 1:
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_DATE),
                        Enter.theValue(dateFinal).into(FINAL_DATE),
                        Click.on(GENERATE_REPORT_BUTTON)
                );
                break;
            case 2:
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_DATE),
                        Enter.theValue(dateFinal).into(FINAL_DATE),
                        Click.on(TRANSACTION_TYPE_BTN),
                        Click.on(TRANSACTION_TYPE_ALL),
                        Click.on(TRANSACTION_TYPE_ITEMS4),
                        Click.on(TRANSACTION_TYPE_ITEMS5),
                        Click.on(TRANSACTION_TYPE_ITEMS6),
                        Click.on(PAC_BTN),
                        Click.on(PAC_BTN),
                        Click.on(PAC_ALL),
                        Click.on(PAC_ITEM1),
                        Click.on(PAC_ITEM2),
                        Click.on(PAC_ITEM3),
                        Click.on(GENERATE_REPORT_BUTTON)
                );
                break;
            case 3:
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_DATE),
                        Enter.theValue(dateFinal).into(FINAL_DATE),
                        Click.on(TRANSACTION_TYPE_BTN),
                        Click.on(TRANSACTION_TYPE_ALL),
                        Click.on(TRANSACTION_TYPE_ITEMS4),
                        Click.on(PAC_BTN),
                        Click.on(PAC_BTN),
                        Click.on(PAC_ALL),
                        Click.on(PAC_ITEM1),
                        Click.on(GENERATE_REPORT_BUTTON)
                );
                break;
            case 4:
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_DATE),
                        Enter.theValue(dateFinal).into(FINAL_DATE),
                        Click.on(TRANSACTION_TYPE_BTN),
                        Click.on(TRANSACTION_TYPE_ALL),
                        Click.on(PAC_BTN),
                        Click.on(PAC_BTN),
                        Click.on(PAC_ALL),
                        Click.on(GENERATE_REPORT_BUTTON)
                );
                break;
            case 5:
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_DATE),
                        Enter.theValue(dateFinal).into(FINAL_DATE),
                        Click.on(BTN_OPERATOR),
                        Enter.theValue("JONATHAN MEJIA TEJADA").into(TEXT_OPERATOR),
                        Click.on(SELECT_OPERATOR),
                        Click.on(GENERATE_REPORT_BUTTON)
                );
                break;
            case 6:
                actor.attemptsTo(
                        Enter.theValue(dateInitial).into(INITIAL_DATE),
                        Enter.theValue(dateFinal).into(FINAL_DATE),
                        Click.on(TRANSACTION_TYPE_BTN),
                        Click.on(TRANSACTION_TYPE_ALL),
                        Click.on(TRANSACTION_TYPE_ITEMS1),
                        Click.on(GENERATE_REPORT_BUTTON)
                );
                break;
        }
    }

    public static FormTransactionsCarriedOutInThePAC goToForm(int options, String dateInitial, String dateFinal) {
        return instrumented(FormTransactionsCarriedOutInThePAC.class, options, dateInitial, dateFinal);
    }
}
