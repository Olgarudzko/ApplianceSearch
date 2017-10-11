package by.tc.task01.dao.analysis.impl;

import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Map;

public class LaptopAnalyzer implements Analyzer {

    public <E> boolean isApplianceMatches(String[] description, Map<E, Object> request) {

        if (description == null) {
            return false;
        }

        for (Map.Entry<E, Object> desiredParam : request.entrySet()) {
            for (int j = 1; j < description.length; j++) {
                String[] laptopParam = description[j].split(Strings.EQUAL);
                if (SearchCriteria.Laptop.valueOf(laptopParam[0]) == desiredParam.getKey()) {
                    if (!isLaptopParameterMatching(desiredParam.getKey(), laptopParam, desiredParam.getValue())) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private <E> boolean isLaptopParameterMatching(E searchCriteria, String[] laptopParam, Object desiredValue) {
        return (searchCriteria == SearchCriteria.Laptop.OS &&
                laptopParam[1].equalsIgnoreCase((String) desiredValue))
                || (searchCriteria != SearchCriteria.Laptop.OS &&
                searchCriteria == SearchCriteria.Laptop.valueOf(laptopParam[0]) &&
                Validator.checkNumberValue(laptopParam[1], desiredValue));
    }
}
