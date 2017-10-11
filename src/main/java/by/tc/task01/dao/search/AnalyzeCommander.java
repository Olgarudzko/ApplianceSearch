package by.tc.task01.dao.search;

import by.tc.task01.dao.search.impl.*;
import by.tc.task01.extra.Strings;

import java.util.HashMap;
import java.util.Map;

public class AnalyzeCommander {

    private Map<String, Analyzer> commandsMap;
    private static final AnalyzeCommander instance = new AnalyzeCommander();

    private AnalyzeCommander() {
        commandsMap = new HashMap<String, Analyzer>();
        commandsMap.put(Strings.LAPTOP, new LaptopAnalyzer());
        commandsMap.put(Strings.OVEN, new OvenAnalyzer());
        commandsMap.put(Strings.REFRIGERATOR, new RefrigeratorAnalyzer());
        commandsMap.put(Strings.TABLET_PC, new TabletPcAnalyzer());
        commandsMap.put(Strings.SPEAKERS, new SpeakersAnalyzer());
        commandsMap.put(Strings.VACUUM_CLEANER, new VacuumCleanerAnalyzer());
    }

    public static AnalyzeCommander getInstance(){
        return instance;
    }

    public Analyzer getApplianceAnalyzer(String appliance){
        return commandsMap.get(appliance);
    }
}
