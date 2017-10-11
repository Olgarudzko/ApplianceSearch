package by.tc.task01.dao.analysis.impl;

import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Iterator;
import java.util.Map;

public class RefrigeratorAnalyzer implements Analyzer {

    public <E> boolean isApplianceMatches(String[] catalogueLine, E searchCriteria, Object value,
                                          Iterator<Map.Entry<E, Object>> criteriaIterator) {
        if (catalogueLine == null) {
            return false;
        }

        for (int i = 1; i < catalogueLine.length; i++) {
            String[] applianceParams = catalogueLine[i].split(Strings.EQUAL);
            if (searchCriteria == SearchCriteria.Refrigerator.valueOf(applianceParams[0]) &&
                    Validator.checkNumberValue(applianceParams[1], value)) {
                while (criteriaIterator.hasNext()) {
                    Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                    E nextSearchCriteria = nextParameter.getKey();
                    Object nextValue = nextParameter.getValue();
                    for (int j = 1; j < catalogueLine.length; j++) {
                        String[] params = catalogueLine[j].split(Strings.EQUAL);
                        if (nextSearchCriteria == SearchCriteria.Refrigerator.valueOf(params[0])) {
                            if (!Validator.checkNumberValue(params[1], nextValue)) {
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
}
