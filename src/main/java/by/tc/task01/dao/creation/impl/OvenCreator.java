package by.tc.task01.dao.creation.impl;

import by.tc.task01.dao.creation.ApplianceCreator;
import by.tc.task01.entity.Oven;
import by.tc.task01.extra.Strings;

public class OvenCreator implements ApplianceCreator {

    public Oven create(String[] parameters) {
        Oven oven = new Oven();
        for (int j = 1; j < parameters.length; j++) {
            String[] parsedForResponse = parameters[j].trim().split(Strings.EQUAL);
            String parameter = parsedForResponse[0];
            String value = parsedForResponse[1];
            if (parameter.equalsIgnoreCase(Strings.POWER_CONSUMPTION)) {
                oven.setPowerConsumption(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.WEIGHT)) {
                oven.setWeight(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.CAPACITY)) {
                oven.setCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.DEPTH)) {
                oven.setDepth(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.HEIGHT)) {
                oven.setHeight(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.WIDTH)) {
                oven.setWidth(Double.valueOf(value));
            }
        }
        return oven;
    }
}
