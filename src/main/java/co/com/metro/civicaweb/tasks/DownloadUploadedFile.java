package co.com.metro.civicaweb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.io.File;

import static co.com.metro.civicaweb.ui.AuditAndControl.DOWNLOAD_UPLOADED_FILE2;
import static co.com.metro.civicaweb.ui.RechargeTransactionRegister.GENERATE_REPORT;

public class DownloadUploadedFile implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
              Click.on(DOWNLOAD_UPLOADED_FILE2)
        );

    }

    public static DownloadUploadedFile downloadUploadedFile() {
        return Tasks.instrumented(DownloadUploadedFile.class);
    }
}
