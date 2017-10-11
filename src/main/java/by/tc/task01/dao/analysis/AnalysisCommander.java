package by.tc.task01.dao.analysis;

import by.tc.task01.dao.analysis.impl.*;
import by.tc.task01.extra.Strings;

import java.util.HashMap;
import java.util.Map;

public class AnalysisCommander {

    private Map<String, Analyzer> commandsMap;
    private static final AnalysisCommander instance = new AnalysisCommander();

    private AnalysisCommander() {
        commandsMap = new HashMap<String, Analyzer>();
        commandsMap.put(Strings.LAPTOP, new LaptopAnalyzer());
        commandsMap.put(Strings.OVEN, new OvenAnalyzer());
        commandsMap.put(Strings.REFRIGERATOR, new RefrigeratorAnalyzer());
        commandsMap.put(Strings.TABLET_PC, new TabletPcAnalyzer());
        commandsMap.put(Strings.SPEAKERS, new SpeakersAnalyzer());
        commandsMap.put(Strings.VACUUM_CLEANER, new VacuumCleanerAnalyzer());
    }

    public static AnalysisCommander getInstance() {
        return instance;
    }

    public Analyzer getApplianceAnalyzer(String appliance) {
        return commandsMap.get(appliance);
    }
}
