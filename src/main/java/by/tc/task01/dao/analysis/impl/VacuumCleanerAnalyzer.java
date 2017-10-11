package by.tc.task01.dao.analysis.impl;

import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Map;

public class VacuumCleanerAnalyzer implements Analyzer {
    public <E> boolean isApplianceMatches(String[] description, Map<E, Object> request) {

        if (description == null) {
            return false;
        }

        for (Map.Entry<E, Object> desiredParam : request.entrySet()) {
            for (int j = 1; j < description.length; j++) {
                String[] params = description[j].split(Strings.EQUAL);
                if (SearchCriteria.VacuumCleaner.valueOf(params[0]) == desiredParam.getKey()) {
                    if (!isVacuumCleanerParameterMatching(desiredParam.getKey(), params, desiredParam.getValue())) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private <E> boolean isVacuumCleanerParameterMatching(E searchCriteria, String[] vacuumCleanerParams, Object value) {
        return ((searchCriteria == SearchCriteria.VacuumCleaner.FILTER_TYPE ||
                searchCriteria == SearchCriteria.VacuumCleaner.BAG_TYPE ||
                searchCriteria == SearchCriteria.VacuumCleaner.WAND_TYPE) &&
                vacuumCleanerParams[1].equalsIgnoreCase((String) value))
                || (searchCriteria != SearchCriteria.VacuumCleaner.FILTER_TYPE &&
                searchCriteria != SearchCriteria.VacuumCleaner.BAG_TYPE &&
                searchCriteria != SearchCriteria.VacuumCleaner.WAND_TYPE &&
                searchCriteria == SearchCriteria.VacuumCleaner.valueOf(vacuumCleanerParams[0]) &&
                Validator.checkNumberValue(vacuumCleanerParams[1], value));
    }
}
