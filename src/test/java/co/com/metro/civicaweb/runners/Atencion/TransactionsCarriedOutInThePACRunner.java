package co.com.metro.civicaweb.runners.Atencion;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/transactionsCarriedOutInThePAC.feature",
        glue = "co.com.metro.civicaweb.stepdefinitions",
        tags = "@29430"
)


public class TransactionsCarriedOutInThePACRunner {
}
