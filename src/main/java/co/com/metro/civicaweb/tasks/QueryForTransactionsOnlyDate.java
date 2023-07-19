package co.com.metro.civicaweb.tasks;

import co.com.metro.civicaweb.utils.CalculateDate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.metro.civicaweb.ui.AuditAndControl.*;
import static co.com.metro.civicaweb.utils.Constant.DATE_FORMAT3;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class QueryForTransactionsOnlyDate implements Task {

    private String car_id;
    private String mos_id;
    private String sesion;


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(CalculateDate.calculatePreviousDay()).into(INITIAL_DATE2),
                Enter.theValue(DATE_FORMAT3).into(FINAL_DATE2),
                Enter.theValue(car_id).into(CAR_ID_FIELD),
                Enter.theValue(mos_id).into(MOS_ID_FIELD),
                Enter.theValue(sesion).into(SESION_FIELD),
                Click.on(SEARCH_BUTTON2)
        );
    }

    public static QueryForTransactionsOnlyDate queryForTransactions(String car_id, String mos_id, String sesion) {
        return instrumented(QueryForTransactionsOnlyDate.class, car_id, mos_id, sesion);
    }
}
