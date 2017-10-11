package by.tc.task01.dao.creation.impl;

import by.tc.task01.dao.creation.ApplianceCreator;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.extra.Strings;

public class TabletPcCreator implements ApplianceCreator {

    public TabletPC create(String[] parameters) {
        TabletPC tabletPC = new TabletPC();
        for (int j = 1; j < parameters.length; j++) {
            String[] parsedDescription = parameters[j].trim().split(Strings.EQUAL);
            String parameter = parsedDescription[0];
            String value = parsedDescription[1];
            if (parameter.equalsIgnoreCase(Strings.BATTERY_CAPACITY)) {
                tabletPC.setBatteryCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.DISPLAY_INCHES)) {
                tabletPC.setDisplayInches(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.MEMORY_ROM)) {
                tabletPC.setMemoryRom(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.FLASH_MEMORY_CAPACITY)) {
                tabletPC.setFlashMemoryCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.COLOR)) {
                tabletPC.setColor(value);
            }
        }
        return tabletPC;
    }
}
