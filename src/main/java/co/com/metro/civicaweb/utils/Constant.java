package co.com.metro.civicaweb.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Constant {

    public static Random random = new Random();
    public static int NUM_RANDOM = random.nextInt();
    public static int VALUE = random.nextInt(10000) + 10000;
    public static int BALANCE = random.nextInt(500);
    public static Date DATE = new Date();
    public static SimpleDateFormat DATE_SDF = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat DATE_SDF3 = new SimpleDateFormat("/ddMMyyyy/");
    public static SimpleDateFormat DATE_SDF2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static SimpleDateFormat DATE_SDF4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static SimpleDateFormat DATE_SDF5 = new SimpleDateFormat("yyyy/MM/dd");
    public static SimpleDateFormat HOUR_SDF = new SimpleDateFormat("HH:mm:ss");
    public static final String DATE_FORMAT = DATE_SDF.format(DATE);
    public static final String DATE_FORMAT3 = DATE_SDF3.format(DATE);
    public static final String HOUR_FORMAT = HOUR_SDF.format(DATE);


    //TITULOS ARCHIVOS EXCEL
    public static final String CAR_ID = "CAR_ID";
    public static final String MOS_ID = "MOS_ID";
    public static final String ADDITIONAL_COLUMN = "COLUMNA_ADICIONAL";


    //CIVICA WEB
    public static final String URL = "http://52.6.253.8:8120/Index.aspx"; //Ambiente Desarrollo
    //public static final String URL = "https://64.76.48.106/CivicaWeb261/Index.aspx"; //Ambiente Calidad 2
   // public static final String URL = "http://64.76.48.106/civica/Index.aspx"; //Ambiente Calidad

    public static final String USER_CIVICA = "41957964";
    public static final String PASS_CIVICA = "12345678";
    public static final String OSI_ID = "1978452";

    public static ArrayList<String> LIST() {

        ArrayList<String> columnTitles = new ArrayList<>();
        columnTitles.add("CAR_ID");
        columnTitles.add("SESION");
        columnTitles.add("VALOR_RECARGA");
        columnTitles.add("SALDO_ANTERIOR");
        columnTitles.add("FECHA_RECARGA");
        columnTitles.add("HORA_RECARGA");

        return columnTitles;
    }

}
