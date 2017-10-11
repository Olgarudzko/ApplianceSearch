package by.tc.task01.dao.creation;

import by.tc.task01.dao.creation.impl.*;
import by.tc.task01.extra.Strings;

import java.util.HashMap;
import java.util.Map;

public class CreationCommander {

    private Map<String, ApplianceCreator> commandsMap;
    private static final CreationCommander instance = new CreationCommander();

    private CreationCommander() {
        commandsMap = new HashMap<String, ApplianceCreator>();
        commandsMap.put(Strings.LAPTOP, new LaptopCreator());
        commandsMap.put(Strings.OVEN, new OvenCreator());
        commandsMap.put(Strings.REFRIGERATOR, new RefrigeratorCreator());
        commandsMap.put(Strings.TABLET_PC, new TabletPcCreator());
        commandsMap.put(Strings.SPEAKERS, new SpeakersCreator());
        commandsMap.put(Strings.VACUUM_CLEANER, new VacuumCleanerCreator());
    }

    public static CreationCommander getInstance() {
        return instance;
    }

    public ApplianceCreator getApplianceCreator(String appliance) {
        return commandsMap.get(appliance);
    }
}
