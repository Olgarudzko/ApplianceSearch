package by.tc.task01.dao.creation.impl;

import by.tc.task01.dao.creation.ApplianceCreator;
import by.tc.task01.entity.Laptop;
import by.tc.task01.extra.Strings;

public class LaptopCreator implements ApplianceCreator {

    public Laptop create(String[] parameters) {
        Laptop laptop = new Laptop();
        for (int j = 1; j < parameters.length; j++) {
            String[] parsedDescription = parameters[j].trim().split(Strings.EQUAL);
            String parameter = parsedDescription[0];
            String value = parsedDescription[1];
            if (parameter.equalsIgnoreCase(Strings.BATTERY_CAPACITY)) {
                laptop.setBatteryCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.CPU)) {
                laptop.setCpu(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.DISPLAY_INCHS)) {
                laptop.setDisplayInchs(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.MEMORY_ROM)) {
                laptop.setMemoryRom(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.OS)) {
                laptop.setOs(value);
            } else if (parameter.equalsIgnoreCase(Strings.SYSTEM_MEMORY)) {
                laptop.setSystemMemory(Double.valueOf(value));
            }
        }
        return laptop;
    }
}
