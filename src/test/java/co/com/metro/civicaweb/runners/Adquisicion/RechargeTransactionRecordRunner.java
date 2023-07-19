package co.com.metro.civicaweb.runners.Adquisicion;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Adquisicion/registroTransaccionRecarga.feature",
        glue = "co.com.metro.civicaweb.stepdefinitions",
        tags = "@23520"
)
public class RechargeTransactionRecordRunner {
}
