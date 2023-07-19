package co.com.metro.civicaweb.assertions;

import co.com.metro.civicaweb.utils.ReadExcelXLSX;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class HistoryConciliations {


    public static boolean compared() {
        boolean result = false;

        String home = System.getProperty("user.home");

        List<Map<String, Object>> listDownloads;

        listDownloads = ReadExcelXLSX.readExcelXLS(home + "/Downloads/ReporteHistóricoConciliacionesEliminadas.xlsx", 6);


        for (int i = 0; i < listDownloads.size(); i++) {


            String registerExcel = listDownloads.get(i).get("VALOR0").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR1").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR2").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR3").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR4").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR5").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR6").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR7").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR8").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR9").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR10").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR11").toString().replace(" ", "")  +" "+
                    listDownloads.get(i).get("VALOR12").toString().replace(" ", "") ;

            WebElement codConc = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[1]"));
            WebElement shippingType = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[2]"));
            WebElement shippingDate = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[3]"));
            WebElement concDate = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[4]"));
            WebElement certDate = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[5]"));
            WebElement docDate = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[6]"));
            WebElement status = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[7]"));
            WebElement reference = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[8]"));
            WebElement cert = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[9]"));
            WebElement operator = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[10]"));
            WebElement observation = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[15]"));
            WebElement deleteDate = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[16]"));
            WebElement deleteOperator = Serenity.getDriver().findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grvHistConcEliminadas']/tbody/tr["+(i+2)+"]/td[17]"));

            String regListGrid = codConc.getText().replace(" ", "")+" "+
                    shippingType.getText().replace(" ", "") +" "+
                    shippingDate.getText()+concDate.getText().replace(" ", "")+" "+
                    certDate.getText().replace(" ", "")+" "+
                    docDate.getText().replace(" ", "")+" "+
                    status.getText().replace(" ", "")+" "+
                    reference.getText().replace(" ", "")+" "+
                    cert.getText().replace(" ", "")+" "+
                    operator.getText().replace(" ", "")+" "+
                    deleteDate.getText().replace(" ", "")+" "+
                    deleteOperator.getText().replace(" ", "")+" "+
                    observation.getText().replace(" ", "");


            result = (regListGrid.replace(" ", "").compareToIgnoreCase(registerExcel.replace(" ", ""))) < 0 ? false : true;
            if (result == false) {
                return false;
            }
        }
        return result;
    }
}
