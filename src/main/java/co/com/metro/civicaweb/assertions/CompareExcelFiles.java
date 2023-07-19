package co.com.metro.civicaweb.assertions;

import co.com.metro.civicaweb.data.querys.QueryAuditFile;
import co.com.metro.civicaweb.utils.ReadExcelXLSX;

import java.util.List;
import java.util.Map;

public class CompareExcelFiles {

    private static boolean result;

    public static boolean compareExcelFiles(String excelFileDownload, String excelFileUpload) {

        String home = System.getProperty("user.home");
        List<Map<String, Object>> listDownloads;
        List<Map<String, Object>> listLoad;

        listDownloads = ReadExcelXLSX.readExcelXLS(home+"/Downloads/" + excelFileDownload + ".xlsx", 5);
        listLoad = ReadExcelXLSX.readExcelXLS("target/data/" + excelFileUpload + ".xlsx", 2);


        for (int i = 0; i < listLoad.size(); i++) {

            String value1 = listDownloads.get(i).get("VALOR3").toString().replace("$", "").replace(".", "");
            value1 = value1.replace(" ", "");

            String value2 = listDownloads.get(i).get("VALOR4").toString().replace("$", "").replace(".", "");
            value2 = value2.replace(" ", "");

            listDownloads.get(i).remove("VALOR0");
            listDownloads.get(i).remove("VALOR7");
            listDownloads.get(i).remove("VALOR8");
            listDownloads.get(i).put("VALOR3", value1);
            listDownloads.get(i).put("VALOR4", value2);

            result = listDownloads.get(i).get("VALOR1").toString().equals(listLoad.get(i).get("VALOR0").toString()) &&
                    listDownloads.get(i).get("VALOR2").toString().equals(listLoad.get(i).get("VALOR1").toString()) &&
                    listDownloads.get(i).get("VALOR3").toString().equals(listLoad.get(i).get("VALOR2").toString()) &&
                    listDownloads.get(i).get("VALOR4").toString().equals(listLoad.get(i).get("VALOR3").toString()) &&
                    listDownloads.get(i).get("VALOR5").toString().equals(listLoad.get(i).get("VALOR4").toString()) &&
                    listDownloads.get(i).get("VALOR6").toString().equals(listLoad.get(i).get("VALOR5").toString());
        }

        return result;
    }

    public static boolean comparedExcelFileBD(String excelFileUpload, String observation) {

        List<Map<String, Object>> listLoad;
        List<Map<String, Object>> listAudit;

        listAudit = QueryAuditFile.queryDetailAuditFile(observation);

        listLoad = ReadExcelXLSX.readExcelXLS("target/data/" + excelFileUpload + ".xlsx", 2);


        for (int i = 0; i < listLoad.size(); i++) {

            listLoad.get(i).remove("VALOR4");
            listLoad.get(i).remove("VALOR5");

            result = listLoad.get(i).get("VALOR0").toString().equals(listAudit.get(i).get("CAR_ID").toString()) &&
                    listLoad.get(i).get("VALOR1").toString().equals(listAudit.get(i).get("SES_ID").toString()) &&
                    listLoad.get(i).get("VALOR2").toString().equals(listAudit.get(i).get("DARE_VLR_TRAN").toString()) &&
                    listLoad.get(i).get("VALOR3").toString().equals(listAudit.get(i).get("DARE_SALDO_ANTERIOR").toString());
        }
        return result;
    }

    public static boolean comparedExcelFileDeleteBD(String excelFileUpload, String observation) {

        List<Map<String, Object>> listLoad;
        List<Map<String, Object>> listAudit;

        listAudit = QueryAuditFile.queryDetailAuditFileDelete(observation);
        listLoad = ReadExcelXLSX.readExcelXLS("target/data/" + excelFileUpload + ".xlsx", 2);

        for (int i = 0; i < listLoad.size(); i++) {
            result = listLoad.get(i).get("VALOR0").toString().equals(listAudit.get(i).get("MOS_ID").toString());
        }
        return result;
    }

    public static boolean compareExcelFilesDelete(String excelFileDownload, String excelFileUpload) {

        List<Map<String, Object>> listDownloads;
        List<Map<String, Object>> listLoad;
        listDownloads = ReadExcelXLSX.readExcelXLS("target/data/" + excelFileDownload + ".xlsx", 5);
        listLoad = ReadExcelXLSX.readExcelXLS("target/data/" + excelFileUpload + ".xlsx", 2);

        for (int i = 0; i < listLoad.size(); i++) {
            result = listDownloads.get(i).get("VALOR2").toString().equals(listLoad.get(i).get("VALOR0").toString());
        }
        return result;
    }

    public static boolean compareAuditFilesLoadReport(String reportGenerationFile, String fileUpload) {

        List<Map<String, Object>> listDownloadedFileAudit;
        List<Map<String, Object>> listReportGenerationFile;

        listReportGenerationFile = ReadExcelXLSX.readExcelXLS("target/data/" + reportGenerationFile + ".xlsx", 5);
        listDownloadedFileAudit = ReadExcelXLSX.readExcelXLS("target/data/" + fileUpload + ".xlsx", 5);


        for (int i = 0; i < listReportGenerationFile.size(); i++) {
            String valorRecarga = listReportGenerationFile.get(i).get("VALOR3").toString().replace("$", "");
            valorRecarga = valorRecarga.replace(" ", "");
            String saldo = listReportGenerationFile.get(i).get("VALOR4").toString().replace("$", "");
            saldo = saldo.replace(" ", "");

            listReportGenerationFile.get(i).put("VALOR3", valorRecarga);
            listReportGenerationFile.get(i).put("VALOR4", saldo);

            result = listDownloadedFileAudit.get(i).get("VALOR1").toString().equals(listReportGenerationFile.get(i).get("VALOR1").toString()) &&
                    listDownloadedFileAudit.get(i).get("VALOR2").toString().equals(listReportGenerationFile.get(i).get("VALOR2").toString()) &&
                    listDownloadedFileAudit.get(i).get("VALOR3").toString().equals(listReportGenerationFile.get(i).get("VALOR3").toString()) &&
                    listDownloadedFileAudit.get(i).get("VALOR4").toString().equals(listReportGenerationFile.get(i).get("VALOR4").toString()) &&
                    listDownloadedFileAudit.get(i).get("VALOR5").toString().equals(listReportGenerationFile.get(i).get("VALOR5").toString()) &&
                    listDownloadedFileAudit.get(i).get("VALOR6").toString().equals(listReportGenerationFile.get(i).get("VALOR6").toString()) &&
                    listDownloadedFileAudit.get(i).get("VALOR7").toString().equals(listReportGenerationFile.get(i).get("VALOR7").toString()) &&
                    listDownloadedFileAudit.get(i).get("VALOR8").toString().equals(listReportGenerationFile.get(i).get("VALOR8").toString());
        }

        return result;
    }


}
