package by.tc.task01.dao.creation;

import by.tc.task01.dao.creation.impl.*;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;

public class CreationCommander {

    private final Map<String, ApplianceCreator> commandsMap;
    private static final CreationCommander instance = new CreationCommander();

    private CreationCommander() {
        commandsMap = new HashMap<String, ApplianceCreator>();
        commandsMap.put(SearchCriteria.Laptop.class.getSimpleName(), new LaptopCreator());
        commandsMap.put(SearchCriteria.Oven.class.getSimpleName(), new OvenCreator());
        commandsMap.put(SearchCriteria.Refrigerator.class.getSimpleName(), new RefrigeratorCreator());
        commandsMap.put(SearchCriteria.TabletPC.class.getSimpleName(), new TabletPcCreator());
        commandsMap.put(SearchCriteria.Speakers.class.getSimpleName(), new SpeakersCreator());
        commandsMap.put(SearchCriteria.VacuumCleaner.class.getSimpleName(), new VacuumCleanerCreator());
    }

    public static CreationCommander getInstance() {
        return instance;
    }

    public ApplianceCreator getApplianceCreator(String appliance) {
        return commandsMap.get(appliance);
    }
}
