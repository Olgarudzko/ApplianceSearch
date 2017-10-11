package by.tc.task01.dao.analysis.impl;

import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Map;

public class SpeakersAnalyzer implements Analyzer {

    public <E> boolean isApplianceMatches(String[] description, Map<E, Object> request) {

        if (description == null) {
            return false;
        }

        for (Map.Entry<E, Object> desiredParam : request.entrySet()) {
            for (int j = 1; j < description.length; j++) {
                String[] params = description[j].split(Strings.EQUAL);
                if (SearchCriteria.Speakers.valueOf(params[0]) == desiredParam.getKey()) {
                    if (!isSpeakersParameterMatching(desiredParam.getKey(), params, desiredParam.getValue())) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private <E> boolean isSpeakersParameterMatching(E searchCriteria, String[] speakersParams, Object value) {
        return (searchCriteria == SearchCriteria.Speakers.FREQUENCY_RANGE &&
                speakersParams[1].equalsIgnoreCase((String) value))
                || (searchCriteria != SearchCriteria.Speakers.FREQUENCY_RANGE &&
                searchCriteria == SearchCriteria.Speakers.valueOf(speakersParams[0]) &&
                Validator.checkNumberValue(speakersParams[1], value));
    }
}
