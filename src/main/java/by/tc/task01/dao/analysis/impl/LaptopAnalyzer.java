package by.tc.task01.dao.analysis.impl;

import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Iterator;
import java.util.Map;

public class LaptopAnalyzer implements Analyzer {

    public <E> boolean isApplianceMatches(String[] catalogueLine, E searchCriteria, Object value,
                                          Iterator<Map.Entry<E, Object>> criteriaIterator) {
        if (catalogueLine == null) {
            return false;
        }

        for (int i = 1; i < catalogueLine.length; i++) {
            String[] laptopParam = catalogueLine[i].split(Strings.EQUAL);
            if (isLaptopParameterMatching(searchCriteria, laptopParam, value)) {
                while (criteriaIterator.hasNext()) {
                    Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                    E nextSearchCriteria = nextParameter.getKey();
                    Object nextValue = nextParameter.getValue();
                    for (int j = 1; j < catalogueLine.length; j++) {
                        String[] params = catalogueLine[j].split(Strings.EQUAL);
                        if (nextSearchCriteria == SearchCriteria.Laptop.valueOf(params[0])) {
                            if (!isLaptopParameterMatching(nextSearchCriteria, params, nextValue)) {
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

    private <E> boolean isLaptopParameterMatching(E searchCriteria, String[] laptopParam, Object desiredValue) {
        return (searchCriteria == SearchCriteria.Laptop.OS &&
                laptopParam[1].equalsIgnoreCase((String) desiredValue))
                || (searchCriteria != SearchCriteria.Laptop.OS &&
                searchCriteria == SearchCriteria.Laptop.valueOf(laptopParam[0]) &&
                Validator.checkNumberValue(laptopParam[1], desiredValue));
    }
}
