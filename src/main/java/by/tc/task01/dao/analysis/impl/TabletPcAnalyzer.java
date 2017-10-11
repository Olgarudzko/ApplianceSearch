package by.tc.task01.dao.analysis.impl;

import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Iterator;
import java.util.Map;

public class TabletPcAnalyzer implements Analyzer {

    public <E> boolean isApplianceMatches(String[] catalogueLine, E searchCriteria, Object value,
                                          Iterator<Map.Entry<E, Object>> criteriaIterator) {
        if (catalogueLine == null) {
            return false;
        }

        for (int i = 1; i < catalogueLine.length; i++) {
            String[] applianceParams = catalogueLine[i].split(Strings.EQUAL);
            if (isTabletPCParameterMatching(searchCriteria, applianceParams, value)) {
                while (criteriaIterator.hasNext()) {
                    Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                    E nextSearchCriteria = nextParameter.getKey();
                    Object nextValue = nextParameter.getValue();
                    for (int j = 1; j < catalogueLine.length; j++) {
                        String[] params = catalogueLine[j].split(Strings.EQUAL);
                        if (nextSearchCriteria == SearchCriteria.TabletPC.valueOf(params[0])) {
                            if (!isTabletPCParameterMatching(nextSearchCriteria, params, nextValue)) {
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

    private <E> boolean isTabletPCParameterMatching(E searchCriteria, String[] tabletPcParam, Object desiredValue) {
        return (searchCriteria == SearchCriteria.TabletPC.COLOR &&
                tabletPcParam[1].equalsIgnoreCase((String) desiredValue))
                || (searchCriteria != SearchCriteria.TabletPC.COLOR &&
                searchCriteria == SearchCriteria.TabletPC.valueOf(tabletPcParam[0]) &&
                Validator.checkNumberValue(tabletPcParam[1], desiredValue));
    }
}
