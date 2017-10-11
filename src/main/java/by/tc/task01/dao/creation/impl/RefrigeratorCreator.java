package by.tc.task01.dao.creation.impl;

import by.tc.task01.dao.creation.ApplianceCreator;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.extra.Strings;

public class RefrigeratorCreator implements ApplianceCreator {

    public Refrigerator create(String[] parameters) {
        Refrigerator refrigerator = new Refrigerator();
        for (int j = 1; j < parameters.length; j++) {
            String[] parsedForResponse = parameters[j].trim().split(Strings.EQUAL);
            String parameter = parsedForResponse[0];
            String value = parsedForResponse[1];
            if (parameter.equalsIgnoreCase(Strings.POWER_CONSUMPTION)) {
                refrigerator.setPowerConsumption(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.WEIGHT)) {
                refrigerator.setWeight(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.FREEZER_CAPACITY)) {
                refrigerator.setFreezerCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.OVERALL_CAPACITY)) {
                refrigerator.setOverallCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.HEIGHT)) {
                refrigerator.setHeight(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.WIDTH)) {
                refrigerator.setWidth(Double.valueOf(value));
            }
        }
        return refrigerator;
    }
}
