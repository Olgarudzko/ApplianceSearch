package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class ApplianceServiceImpl implements ApplianceService {

    public <E> Appliance find(Criteria<E> criteria) {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        return applianceDAO.find(criteria);
    }

    public static String[] readCurrentCatalogue(Class context) {
        String[] catalogue;
        FileInputStream catalogueReader = null;
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
        } finally {
            if (catalogueReader != null) {
                try {
                    catalogueReader.close();
                } catch (IOException e) {
                    System.out.println(Strings.ERROR_STREAM_CLOSING + e.getLocalizedMessage());
                }
            }
        }
        return catalogue;
    }
}
