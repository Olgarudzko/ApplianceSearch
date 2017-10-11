package by.tc.task01.dao.creation.impl;

import by.tc.task01.dao.creation.ApplianceCreator;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.extra.Strings;

public class VacuumCleanerCreator implements ApplianceCreator {

    public VacuumCleaner create(String[] parameters) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        for (int j = 1; j < parameters.length; j++) {
            String[] parsedDescription = parameters[j].trim().split(Strings.EQUAL);
            String parameter = parsedDescription[0];
            String value = parsedDescription[1];
            if (parameter.equalsIgnoreCase(Strings.POWER_CONSUMPTION)) {
                vacuumCleaner.setPowerConsumption(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.MOTOR_SPEED_REGULATION)) {
                vacuumCleaner.setMotorSpeedRegulation(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.CLEANING_WIDTH)) {
                vacuumCleaner.setCleaningWidth(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.FILTER_TYPE)) {
                vacuumCleaner.setFilterType(value);
            } else if (parameter.equalsIgnoreCase(Strings.BAG_TYPE)) {
                vacuumCleaner.setBagType(value);
            } else if (parameter.equalsIgnoreCase(Strings.WAND_TYPE)) {
                vacuumCleaner.setWandType(value);
            }
        }
        return vacuumCleaner;
    }
}
