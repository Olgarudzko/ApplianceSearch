package by.tc.task01.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Appliance {

    public static String[] readCurrentCatalogue(Class context){
        String [] catalogue;
        FileInputStream catalogueReader;
        try {
            catalogueReader = new FileInputStream(new File(context.getClassLoader().getResource("appliances_db.txt").getFile()));
            byte[] content = new byte[catalogueReader.available()];
            catalogueReader.read(content);
            catalogueReader.close();
            catalogue = new String(content, "UTF-8").split("\n");
        } catch (FileNotFoundException e) {
            System.out.println("Catalogue is currently not available.");
            return null;
        } catch (IOException e){
            System.out.println("Error reading catalogue.");
            return null;
        }
        return catalogue;
    }
}
