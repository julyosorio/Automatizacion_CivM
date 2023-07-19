package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;

import static co.com.metro.civicaweb.ui.RechargeTransactionRegister.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class FileUploadRegister implements Task {

    private String file;

    public FileUploadRegister(String file) {
        this.file = file;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SendKeys.of(System.getProperty("user.dir") + "/target/data/" + file + ".xlsx").into(SELECT_FILE).performAs(actor);
        SelectFromOptions.byVisibleText("VENTA DE RECARGA").from(TRANSACTION_TYPE_MENU).performAs(actor);
        Click.on(LOAD_BUTTON).performAs(actor);
    }

    public static FileUploadRegister fileUpload(String fileName) {
        return instrumented(FileUploadRegister.class, fileName);
    }
}
