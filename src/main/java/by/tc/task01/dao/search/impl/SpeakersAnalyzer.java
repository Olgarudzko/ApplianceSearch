package by.tc.task01.dao.search.impl;

import by.tc.task01.dao.search.Analyzer;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;
import by.tc.task01.service.validation.Validator;

import java.util.Iterator;
import java.util.Map;

public class SpeakersAnalyzer implements Analyzer {

    public <E> boolean isApplianceMatches(String[] catalogueLine, E searchCriteria, Object value,
                                          Iterator<Map.Entry<E, Object>> criteriaIterator) {
        if (catalogueLine == null) {
            return false;
        }
        for (int i = 1; i < catalogueLine.length; i++) {
            String[] applianceParams = catalogueLine[i].split(Strings.EQUAL);
            if (isSpeakersParameterMatching(searchCriteria, applianceParams, value)) {
                while (criteriaIterator.hasNext()) {
                    Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                    E nextSearchCriteria = nextParameter.getKey();
                    Object nextValue = nextParameter.getValue();
                    for (int j = 1; j < catalogueLine.length; j++) {
                        String[] params = catalogueLine[j].split(Strings.EQUAL);
                        if (nextSearchCriteria == SearchCriteria.Speakers.valueOf(params[0])) {
                            if (!isSpeakersParameterMatching(nextSearchCriteria, params, nextValue)) {
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

    private <E> boolean isSpeakersParameterMatching(E searchCriteria, String[] speakersParams, Object value) {
        return (searchCriteria == SearchCriteria.Speakers.FREQUENCY_RANGE &&
                speakersParams[1].equalsIgnoreCase((String) value))
                || (searchCriteria != SearchCriteria.Speakers.FREQUENCY_RANGE &&
                searchCriteria == SearchCriteria.Speakers.valueOf(speakersParams[0]) &&
                Validator.checkNumberValue(speakersParams[1], value));
    }
}
