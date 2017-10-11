package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Iterator;
import java.util.Map;

public class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        Iterator<Map.Entry<E, Object>> criteriaIterator = criteria.getCriteria().entrySet().iterator();
        while (criteriaIterator.hasNext()) {
            Map.Entry<E, Object> parameter = criteriaIterator.next();
            E searchCriteria = parameter.getKey();
            Object value = parameter.getValue();

            if (!(searchCriteria instanceof SearchCriteria.Laptop ||
                    searchCriteria instanceof SearchCriteria.Oven ||
                    searchCriteria instanceof SearchCriteria.Refrigerator ||
                    searchCriteria instanceof SearchCriteria.TabletPC ||
                    searchCriteria instanceof SearchCriteria.Speakers ||
                    searchCriteria instanceof SearchCriteria.VacuumCleaner)) {
                return false;
            }

            if (!(value instanceof String || value instanceof Number)) {
                return false;
            }

            if (!(searchCriteria == SearchCriteria.Laptop.OS ||
                    searchCriteria == SearchCriteria.TabletPC.COLOR ||
                    searchCriteria == SearchCriteria.VacuumCleaner.FILTER_TYPE ||
                    searchCriteria == SearchCriteria.VacuumCleaner.BAG_TYPE ||
                    searchCriteria == SearchCriteria.VacuumCleaner.WAND_TYPE ||
                    searchCriteria == SearchCriteria.Speakers.FREQUENCY_RANGE)) {
                if (value instanceof String) {
                    return false;
                }
            } else {
                if (value instanceof Number) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkNumberValue(String apllianceValue, Object desiredValue) {
        return Double.valueOf(apllianceValue).equals(
                (desiredValue instanceof Integer) ? Double.valueOf((Integer) desiredValue) :
                        (desiredValue instanceof Double) ? (Double) desiredValue :
                                (desiredValue instanceof Float) ? Double.valueOf((Float) desiredValue) :
                                        (desiredValue instanceof Short) ? Double.valueOf((Short) desiredValue) :
                                                (desiredValue instanceof Long) ? Double.valueOf((Long) desiredValue) :
                                                        Double.valueOf((Byte) desiredValue));

    }
}
