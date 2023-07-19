package co.com.metro.civicaweb.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase contiene los métodos para leer el archivos .properties con las credenciales de la conexion a la base de datos
 */
public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath;
    static Logger logger = Logger.getLogger(ConfigFileReader.class.getName());

    /**
     * Leer el archivo .properties
     * @param filePath Ruta del archivo a leer
     */
    public ConfigFileReader(String filePath){
        propertyFilePath = filePath;

        try (FileInputStream reader = new FileInputStream (new File(propertyFilePath))){
            properties = new Properties();

            try {
                properties.load(new InputStreamReader(reader, StandardCharsets.UTF_8));
            }
            catch (IOException e) {
                logger.log(Level.WARNING, "Error en lectura de archivo .properties: ", e);
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
        }

    }

    /**
     * Lee parámetros especificas del archivo .properties
     * @param key parámetro a leer
     * @return Valor del parámetro
     */
    public String getPropertyByKey(String key) {
        try{
            String p = properties.getProperty(key);

            if(p!= null)
                return p;
            else
                throw new RuntimeException("Property not specified in the " + propertyFilePath + " file for the Key: " + key);
        }
        catch (Exception e) {
            throw new RuntimeException("Property not specified in the " + propertyFilePath + " file for the Key: " + key);
        }
    }

}