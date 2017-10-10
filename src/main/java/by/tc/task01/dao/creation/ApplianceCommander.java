package by.tc.task01.dao.creation;

import by.tc.task01.dao.creation.impl.*;
import by.tc.task01.extra.Strings;

import java.util.HashMap;
import java.util.Map;

public class ApplianceCommander {

    private Map <String, Command> commandsMap;
    private static final  ApplianceCommander instance = new ApplianceCommander();
    private ApplianceCommander() {
        commandsMap = new HashMap<String, Command>();
        commandsMap.put(Strings.LAPTOP, new LaptopCreator());
        commandsMap.put(Strings.OVEN, new OvenCreator());
        commandsMap.put(Strings.REFRIGERATOR, new RefrigeratorCreator());
        commandsMap.put(Strings.TABLET_PC, new TabletPcCreator());
        commandsMap.put(Strings.SPEAKERS, new SpeakersCreator());
        commandsMap.put(Strings.VACUUM_CLEANER, new VacuumCleanerCreator());
    }

    public static ApplianceCommander getInstance(){
        return instance;
    }

    public Command getApplianceCreator(String appliance){
        return commandsMap.get(appliance);
    }
}
