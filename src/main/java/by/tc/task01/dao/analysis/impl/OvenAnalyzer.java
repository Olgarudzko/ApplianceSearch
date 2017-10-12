package by.tc.task01.dao.analysis.impl;

import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Map;

public class OvenAnalyzer implements Analyzer {

    public <E> boolean isApplianceMatches(String[] description, Map<E, Object> request) {

        if (description == null) {
            return false;
        }

        for (Map.Entry<E, Object> desiredParam : request.entrySet()) {
            for (int j = 1; j < description.length; j++) {
                String[] ovenParam = description[j].split(Strings.EQUAL);
                try {
                    if (SearchCriteria.Oven.valueOf(ovenParam[0]) == desiredParam.getKey()) {
                        if (!Validator.compareNumericValues(ovenParam[1], desiredParam.getValue())) {
                            return false;
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(Strings.UNKNOWN_PARAMETER + ovenParam[0]);
                }
            }
        }

        return true;
    }
}
