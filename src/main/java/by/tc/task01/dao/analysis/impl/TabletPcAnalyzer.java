package by.tc.task01.dao.analysis.impl;

import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Map;

public class TabletPcAnalyzer implements Analyzer {

    public <E> boolean isApplianceMatches(String[] description, Map<E, Object> request) {
        if (description == null) {
            return false;
        }

        for (Map.Entry<E, Object> desiredParam : request.entrySet()) {
            for (int j = 1; j < description.length; j++) {
                String[] params = description[j].split(Strings.EQUAL);
                if (SearchCriteria.TabletPC.valueOf(params[0]) == desiredParam.getKey()) {
                    if (!isTabletPCParameterMatching(desiredParam.getKey(), params, desiredParam.getValue())) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private <E> boolean isTabletPCParameterMatching(E searchCriteria, String[] tabletPcParam, Object desiredValue) {
        return (searchCriteria == SearchCriteria.TabletPC.COLOR &&
                tabletPcParam[1].equalsIgnoreCase((String) desiredValue))
                || (searchCriteria != SearchCriteria.TabletPC.COLOR &&
                searchCriteria == SearchCriteria.TabletPC.valueOf(tabletPcParam[0]) &&
                Validator.checkNumberValue(tabletPcParam[1], desiredValue));
    }
}
