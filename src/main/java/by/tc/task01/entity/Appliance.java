package by.tc.task01.entity;

import by.tc.task01.extra.Strings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Appliance {

    public static String[] readCurrentCatalogue(Class context) {
        String[] catalogue;
        FileInputStream catalogueReader;
        try {
            URL source = context.getClassLoader().getResource(Strings.CATALOGUE);
            if (source == null) {
                System.out.println(Strings.CATALOGUE_NOT_AVAILABLE);
                return null;
            }
            catalogueReader = new FileInputStream(new File(source.getFile()));
            byte[] content = new byte[catalogueReader.available()];
            catalogueReader.read(content);
            catalogueReader.close();
            catalogue = new String(content, Strings.CHARSET_NAME).split(Strings.NEW_LINE);
        } catch (FileNotFoundException e) {
            System.out.println(Strings.CATALOGUE_NOT_AVAILABLE);
            return null;
        } catch (IOException e) {
            System.out.println(Strings.ERROR_READING);
            return null;
        }
        return catalogue;
    }
}
