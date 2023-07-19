package co.com.metro.civicaweb.utils;

import java.io.File;

public class RemoveFileDownloads {

    public static void removeFileDownloads(String fileName){
        String home = System.getProperty("user.home");
        File file = new File(home+"/Downloads/"+fileName+".xlsx");
        boolean deleteFile = file.delete();

    }

}
