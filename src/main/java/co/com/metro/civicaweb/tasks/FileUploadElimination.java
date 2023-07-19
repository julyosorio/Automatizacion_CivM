package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

import static co.com.metro.civicaweb.ui.RechargeTransactionElimination.LOAD_BUTTON_ELIMINATION;
import static co.com.metro.civicaweb.ui.RechargeTransactionElimination.SELECT_FILE_ELIMINATION;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class FileUploadElimination implements Task {

    private String file;

    public FileUploadElimination(String file) {
        this.file = file;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SendKeys.of(System.getProperty("user.dir") + "/target/data/" + file + ".xlsx").into(SELECT_FILE_ELIMINATION).performAs(actor);
        Click.on(LOAD_BUTTON_ELIMINATION).performAs(actor);
    }

    public static FileUploadElimination fileUpload(String fileName) {
        return instrumented(FileUploadElimination.class, fileName);
    }
}
