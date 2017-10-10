package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.creation.impl.*;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.extra.Strings;

import java.util.Iterator;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    public <E> Appliance find(Criteria<E> criteria) {
        Iterator<Map.Entry<E, Object>> criteriaIterator = criteria.getCriteria().entrySet().iterator();
        String[] catalogue = Appliance.readCurrentCatalogue(getClass());
        if (catalogue != null) {
            if (criteriaIterator.hasNext()) {

                Map.Entry<E, Object> firstParameter = criteriaIterator.next();
                E searchCriteria = firstParameter.getKey();
                Object value = firstParameter.getValue();

                String[] parsedDescription;

                if (searchCriteria instanceof SearchCriteria.Laptop) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, Strings.LAPTOP);
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] laptopParam = parsedDescription[i].split(Strings.EQUAL);
                                if (isLaptopParameterMatching(searchCriteria, laptopParam, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split(Strings.EQUAL);
                                            if (nextSearchCriteria == SearchCriteria.Laptop.valueOf(params[0])) {
                                                if (!isLaptopParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return new LaptopCreator().execute(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.Oven) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, Strings.OVEN);
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split(Strings.EQUAL);
                                if (searchCriteria == SearchCriteria.Oven.valueOf(applianceParams[0]) &&
                                        checkNumberValue(applianceParams[1], value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split(Strings.EQUAL);
                                            if (nextSearchCriteria == SearchCriteria.Oven.valueOf(params[0])) {
                                                if (!checkNumberValue(params[1], nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return new OvenCreator().execute(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.Refrigerator) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, Strings.REFRIGERATOR);
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split(Strings.EQUAL);
                                if (searchCriteria == SearchCriteria.Refrigerator.valueOf(applianceParams[0]) &&
                                        checkNumberValue(applianceParams[1], value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split(Strings.EQUAL);
                                            if (nextSearchCriteria == SearchCriteria.Refrigerator.valueOf(params[0])) {
                                                if (!checkNumberValue(params[1], nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return new RefrigeratorCreator().execute(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.TabletPC) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, Strings.TABLET_PC);
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split(Strings.EQUAL);
                                if (isTabletPCParameterMatching(searchCriteria, applianceParams, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split(Strings.EQUAL);
                                            if (nextSearchCriteria == SearchCriteria.TabletPC.valueOf(params[0])) {
                                                if (!isTabletPCParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return new TabletPcCreator().execute(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.Speakers) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, Strings.SPEAKERS);
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split(Strings.EQUAL);
                                if (isSpeakersParameterMatching(searchCriteria, applianceParams, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split(Strings.EQUAL);
                                            if (nextSearchCriteria == SearchCriteria.Speakers.valueOf(params[0])) {
                                                if (!isSpeakersParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return new SpeakersCreator().execute(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.VacuumCleaner) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, Strings.VACUUM_CLEANER);
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split(Strings.EQUAL);
                                if (isVacuumCleanerParameterMatching(searchCriteria, applianceParams, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split(Strings.EQUAL);
                                            if (nextSearchCriteria == SearchCriteria.VacuumCleaner.valueOf(params[0])) {
                                                if (!isVacuumCleanerParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return new VacuumCleanerCreator().execute(parsedDescription);
                                }
                            }
                        }
                    }
                }
            }

        }
        return null;
    }

    private String[] findApplianceWithMatchingName(String catalogueLine, String applianceType) {
        if (catalogueLine.contains(applianceType) || catalogueLine.contains(applianceType.toUpperCase()) ||
                catalogueLine.contains(applianceType.toLowerCase())) {
            return catalogueLine.trim().split(Strings.SEPARATORS);
        }
        return null;
    }

    private boolean checkNumberValue(String apllianceValue, Object desiredValue) {
        return Double.valueOf(apllianceValue).equals(
                (desiredValue instanceof Integer) ? Double.valueOf((Integer) desiredValue) :
                        (desiredValue instanceof Double) ? (Double) desiredValue :
                                (desiredValue instanceof Float) ? Double.valueOf((Float) desiredValue) :
                                        (desiredValue instanceof Short) ? Double.valueOf((Short) desiredValue) :
                                                (desiredValue instanceof Long) ? Double.valueOf((Long) desiredValue) :
                                                        Double.valueOf((Byte) desiredValue));

    }

    private <E> boolean isLaptopParameterMatching(E searchCriteria, String[] laptopParam, Object desiredValue) {
        return (searchCriteria == SearchCriteria.Laptop.OS &&
                laptopParam[1].equalsIgnoreCase((String) desiredValue))
                || (searchCriteria != SearchCriteria.Laptop.OS &&
                searchCriteria == SearchCriteria.Laptop.valueOf(laptopParam[0]) &&
                checkNumberValue(laptopParam[1], desiredValue));
    }

    private <E> boolean isTabletPCParameterMatching(E searchCriteria, String[] tabletPcParam, Object desiredValue) {
        return (searchCriteria == SearchCriteria.TabletPC.COLOR &&
                tabletPcParam[1].equalsIgnoreCase((String) desiredValue))
                || (searchCriteria != SearchCriteria.TabletPC.COLOR &&
                searchCriteria == SearchCriteria.TabletPC.valueOf(tabletPcParam[0]) &&
                checkNumberValue(tabletPcParam[1], desiredValue));
    }

    private <E> boolean isSpeakersParameterMatching(E searchCriteria, String[] speakersParams, Object value) {
        return (searchCriteria == SearchCriteria.Speakers.FREQUENCY_RANGE &&
                speakersParams[1].equalsIgnoreCase((String) value))
                || (searchCriteria != SearchCriteria.Speakers.FREQUENCY_RANGE &&
                searchCriteria == SearchCriteria.Speakers.valueOf(speakersParams[0]) &&
                checkNumberValue(speakersParams[1], value));
    }

    private <E> boolean isVacuumCleanerParameterMatching(E searchCriteria, String[] vacuumCleanerParams, Object value) {
        return ((searchCriteria == SearchCriteria.VacuumCleaner.FILTER_TYPE ||
                searchCriteria == SearchCriteria.VacuumCleaner.BAG_TYPE ||
                searchCriteria == SearchCriteria.VacuumCleaner.WAND_TYPE) &&
                vacuumCleanerParams[1].equalsIgnoreCase((String) value))
                || (searchCriteria != SearchCriteria.VacuumCleaner.FILTER_TYPE &&
                searchCriteria != SearchCriteria.VacuumCleaner.BAG_TYPE &&
                searchCriteria != SearchCriteria.VacuumCleaner.WAND_TYPE &&
                searchCriteria == SearchCriteria.VacuumCleaner.valueOf(vacuumCleanerParams[0]) &&
                checkNumberValue(vacuumCleanerParams[1], value));
    }
}


