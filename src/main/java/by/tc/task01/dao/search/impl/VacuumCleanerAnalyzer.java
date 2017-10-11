package by.tc.task01.dao.search.impl;

import by.tc.task01.dao.search.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Iterator;
import java.util.Map;

public class VacuumCleanerAnalyzer implements Analyzer {
    public <E> boolean isApplianceMatches(String[] catalogueLine, E searchCriteria, Object value,
                                          Iterator<Map.Entry<E, Object>> criteriaIterator) {
        if (catalogueLine == null) {
            return false;
        }

        for (int i = 1; i < catalogueLine.length; i++) {
            String[] applianceParams = catalogueLine[i].split(Strings.EQUAL);
            if (isVacuumCleanerParameterMatching(searchCriteria, applianceParams, value)) {
                while (criteriaIterator.hasNext()) {
                    Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                    E nextSearchCriteria = nextParameter.getKey();
                    Object nextValue = nextParameter.getValue();
                    for (int j = 1; j < catalogueLine.length; j++) {
                        String[] params = catalogueLine[j].split(Strings.EQUAL);
                        if (nextSearchCriteria == SearchCriteria.VacuumCleaner.valueOf(params[0])) {
                            if (!isVacuumCleanerParameterMatching(nextSearchCriteria, params, nextValue)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }

        return false;
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
