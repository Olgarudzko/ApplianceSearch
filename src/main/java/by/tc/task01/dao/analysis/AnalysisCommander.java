package by.tc.task01.dao.analysis;

import by.tc.task01.dao.analysis.impl.*;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;

public class AnalysisCommander {

    private Map<String, Analyzer> commandsMap;
    private static final AnalysisCommander instance = new AnalysisCommander();

    private AnalysisCommander() {
        commandsMap = new HashMap<String, Analyzer>();
        commandsMap.put(SearchCriteria.Laptop.class.getSimpleName(), new LaptopAnalyzer());
        commandsMap.put(SearchCriteria.Oven.class.getSimpleName(), new OvenAnalyzer());
        commandsMap.put(SearchCriteria.Refrigerator.class.getSimpleName(), new RefrigeratorAnalyzer());
        commandsMap.put(SearchCriteria.TabletPC.class.getSimpleName(), new TabletPcAnalyzer());
        commandsMap.put(SearchCriteria.Speakers.class.getSimpleName(), new SpeakersAnalyzer());
        commandsMap.put(SearchCriteria.VacuumCleaner.class.getSimpleName(), new VacuumCleanerAnalyzer());
    }

    public static AnalysisCommander getInstance() {
        return instance;
    }

    public Analyzer getApplianceAnalyzer(String appliance) {
        return commandsMap.get(appliance);
    }
}
