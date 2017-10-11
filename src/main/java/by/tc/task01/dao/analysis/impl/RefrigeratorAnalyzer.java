package by.tc.task01.dao.analysis.impl;

import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Map;

public class RefrigeratorAnalyzer implements Analyzer {

    public <E> boolean isApplianceMatches(String[] description, Map<E, Object> request) {

        if (description == null) {
            return false;
        }

        for (Map.Entry<E, Object> desiredParam : request.entrySet()) {
            for (int j = 1; j < description.length; j++) {
                String[] params = description[j].split(Strings.EQUAL);
                if (SearchCriteria.Refrigerator.valueOf(params[0]) == desiredParam.getKey()) {
                    if (!Validator.checkNumberValue(params[1], desiredParam.getValue())) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
