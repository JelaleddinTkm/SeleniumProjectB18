package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- we created properties object
    private static Properties properties = new Properties();

    static {
        // why we put everything on static block?
        // bec we want to run everything in one's
        // 1.we can not write our method directly on class level, it has to be in some kind of block...
        // 2.we run before everything else...

        //2- get the path and store in String, or directly pass into fileInputStream obj
        String path = "configuration.properties";


        //3- we need to open the file
        try {
            FileInputStream file = new FileInputStream( path );

            //4- we need to load the file
            properties.load(file);

            //5- close.file
            file.close();

        } catch (IOException e) {

            System.out.println("Properties file not found");
        }



    }


    //Our own custom method t read and get values from configuration.properties file
    public static String getProperty(String keyWord) {
        return properties.getProperty(keyWord);
    }



}
