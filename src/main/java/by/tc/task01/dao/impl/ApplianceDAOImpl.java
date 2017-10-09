package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

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

                String[] parsedApplianceDescription;
                if (searchCriteria instanceof SearchCriteria.Laptop) {
                    for (String catalogueLine : catalogue) {
                        parsedApplianceDescription = findApplianceWithMatchingName(catalogueLine, "Laptop");
                        if (parsedApplianceDescription != null) {
                            for (int i = 1; i < parsedApplianceDescription.length; i++) {
                                String[] laptopParam = parsedApplianceDescription[i].split("=");
                                if (isLaptopParameterMatching(searchCriteria, laptopParam, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedApplianceDescription.length; j++) {
                                            String[] params = parsedApplianceDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.Laptop.valueOf(params[0])) {
                                                if (!isLaptopParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractLaptopFomCatalogue(parsedApplianceDescription);
                                }
                            }
                        }
                    }
                } else if (searchCriteria instanceof SearchCriteria.Oven) {
                    for (String catalogueLine : catalogue) {
                        parsedApplianceDescription = findApplianceWithMatchingName(catalogueLine, "Oven");
                        if (parsedApplianceDescription != null) {
                            for (int i = 1; i < parsedApplianceDescription.length; i++) {
                                String[] applianceParams = parsedApplianceDescription[i].split("=");
                                if (searchCriteria == SearchCriteria.Oven.valueOf(applianceParams[0]) &&
                                        checkNumberValue(applianceParams[1], value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedApplianceDescription.length; j++) {
                                            String[] params = parsedApplianceDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.Oven.valueOf(params[0])) {
                                                if (!checkNumberValue(params[1], nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractOvenFomCatalogue(parsedApplianceDescription);
                                }
                            }
                        }
                    }
                } else if (searchCriteria instanceof SearchCriteria.Refrigerator) {
                    for (String catalogueLine : catalogue) {
                        parsedApplianceDescription = findApplianceWithMatchingName(catalogueLine, "Refrigerator");
                        if (parsedApplianceDescription != null) {
                            for (int i = 1; i < parsedApplianceDescription.length; i++) {
                                String[] applianceParams = parsedApplianceDescription[i].split("=");
                                if (searchCriteria == SearchCriteria.Refrigerator.valueOf(applianceParams[0]) &&
                                        checkNumberValue(applianceParams[1], value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedApplianceDescription.length; j++) {
                                            String[] params = parsedApplianceDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.Refrigerator.valueOf(params[0])) {
                                                if (!checkNumberValue(params[1], nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractRefrigeratorFomCatalogue(parsedApplianceDescription);
                                }
                            }
                        }
                    }
                } else if (searchCriteria instanceof SearchCriteria.TabletPC) {
                    for (String catalogueLine : catalogue) {
                        parsedApplianceDescription = findApplianceWithMatchingName(catalogueLine, "TabletPC");
                        if (parsedApplianceDescription != null) {
                            for (int i = 1; i < parsedApplianceDescription.length; i++) {
                                String[] applianceParams = parsedApplianceDescription[i].split("=");
                                if (isTabletPCParameterMatching(searchCriteria, applianceParams, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedApplianceDescription.length; j++) {
                                            String[] params = parsedApplianceDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.TabletPC.valueOf(params[0])) {
                                                if (!isTabletPCParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractLaptopFomCatalogue(parsedApplianceDescription);
                                }
                            }
                        }
                    }
                } else if (searchCriteria instanceof SearchCriteria.Speakers) {
                    for (String catalogueLine : catalogue) {
                        parsedApplianceDescription = findApplianceWithMatchingName(catalogueLine, "Speakers");
                        if (parsedApplianceDescription != null) {
                            for (int i = 1; i < parsedApplianceDescription.length; i++) {
                                String[] applianceParams = parsedApplianceDescription[i].split("=");
                                if (isSpeakersParameterMatching(searchCriteria, applianceParams, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedApplianceDescription.length; j++) {
                                            String[] params = parsedApplianceDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.Speakers.valueOf(params[0])) {
                                                if (!isSpeakersParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractSpeakersFomCatalogue(parsedApplianceDescription);
                                }
                            }
                        }
                    }
                } else if (searchCriteria instanceof SearchCriteria.VacuumCleaner) {

                }
            }

        }
        return null;
    }

    private String[] findApplianceWithMatchingName(String catalogueLine, String applianceType) {
        if (catalogueLine.contains(applianceType) || catalogueLine.contains(applianceType.toUpperCase()) ||
                catalogueLine.contains(applianceType.toLowerCase())) {
            return catalogueLine.trim().split("[ :,;]+");
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

    private Laptop extractLaptopFomCatalogue(String[] laptopDescription) {
        Laptop laptop = new Laptop();
        for (int j = 1; j < laptopDescription.length; j++) {
            String[] parsedDescription = laptopDescription[j].trim().split("=");
            String parameter = parsedDescription[0];
            String value = parsedDescription[1];
            if (parameter.equalsIgnoreCase("BATTERY_CAPACITY")) {
                laptop.setBattery_capacity(Float.valueOf(value));
            } else if (parameter.equalsIgnoreCase("CPU")) {
                laptop.setCpu(Float.valueOf(value));
            } else if (parameter.equalsIgnoreCase("DISPLAY_INCHS")) {
                laptop.setDisplay_inchs(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("MEMORY_ROM")) {
                laptop.setMemory_rom(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("OS")) {
                laptop.setOs(value);
            } else if (parameter.equalsIgnoreCase("SYSTEM_MEMORY")) {
                laptop.setSystem_memory(Integer.valueOf(value));
            }
        }
        return laptop;
    }


    private Oven extractOvenFomCatalogue(String[] ovenDescription) {
        Oven oven = new Oven();
        for (int j = 1; j < ovenDescription.length; j++) {
            String[] parsedForResponse = ovenDescription[j].trim().split("=");
            String parameter = parsedForResponse[0];
            String value = parsedForResponse[1];
            if (parameter.equalsIgnoreCase("POWER_CONSUMPTION")) {
                oven.setPower_consumption(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("WEIGHT")) {
                oven.setWeight(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("CAPACITY")) {
                oven.setCapacity(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("DEPTH")) {
                oven.setDepth(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("HEIGHT")) {
                oven.setHeight(Float.valueOf(value));
            } else if (parameter.equalsIgnoreCase("WIDTH")) {
                oven.setWidth(Float.valueOf(value));
            }
        }
        return oven;
    }

    private Refrigerator extractRefrigeratorFomCatalogue(String[] fridgeDescription) {
        Refrigerator refrigerator = new Refrigerator();
        for (int j = 1; j < fridgeDescription.length; j++) {
            String[] parsedForResponse = fridgeDescription[j].trim().split("=");
            String parameter = parsedForResponse[0];
            String value = parsedForResponse[1];
            if (parameter.equalsIgnoreCase("POWER_CONSUMPTION")) {
                refrigerator.setPower_consumption(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("WEIGHT")) {
                refrigerator.setWeight(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("FREEZER_CAPACITY")) {
                refrigerator.setFreezer_capacity(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("OVERALL_CAPACITY")) {
                refrigerator.setOverall_capacity(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("HEIGHT")) {
                refrigerator.setHeight(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("WIDTH")) {
                refrigerator.setWidth(Integer.valueOf(value));
            }
        }
        return refrigerator;
    }

    private Speakers extractSpeakersFomCatalogue(String[] speakersDescription) {
        Speakers speakers = new Speakers();
        for (int j = 1; j < speakersDescription.length; j++) {
            String[] parsedDescription = speakersDescription[j].trim().split("=");
            String parameter = parsedDescription[0];
            String value = parsedDescription[1];
            if (parameter.equalsIgnoreCase("POWER_CONSUMPTION")) {
                speakers.setPower_consumption(Integer.valueOf(value));
            } else if (parameter.equalsIgnoreCase("NUMBER_OF_SPEAKERS")) {
                speakers.setNumber_of_speakers(Short.valueOf(value));
            } else if (parameter.equalsIgnoreCase("CORD_LENGTH")) {
                speakers.setCord_lenght(Short.valueOf(value));
            } else if (parameter.equalsIgnoreCase("FREQUENCY_RANGE")) {
                speakers.setFrequency(value);
            }
        }
        return speakers;
    }

    private <E> boolean isLaptopParameterMatching(E searchCriteria, String[] laptopParam, Object desiredValue) {
        return (searchCriteria == SearchCriteria.Laptop.OS &&
                laptopParam[1].equalsIgnoreCase((String) desiredValue))
                || (searchCriteria != SearchCriteria.Laptop.OS &&
                searchCriteria == SearchCriteria.Laptop.valueOf(laptopParam[0]) &&
                checkNumberValue(laptopParam[1], desiredValue));
    }

    private <E> boolean isTabletPCParameterMatching(E searchCriteria, String[] TabletPCParam, Object desiredValue) {
        return (searchCriteria == SearchCriteria.TabletPC.COLOR &&
                TabletPCParam[1].equalsIgnoreCase((String) desiredValue))
                || (searchCriteria != SearchCriteria.TabletPC.COLOR &&
                searchCriteria == SearchCriteria.TabletPC.valueOf(TabletPCParam[0]) &&
                checkNumberValue(TabletPCParam[1], desiredValue));
    }

    private <E> boolean isSpeakersParameterMatching(E searchCriteria, String[] speakersParams, Object value) {
        return (searchCriteria == SearchCriteria.Speakers.FREQUENCY_RANGE &&
                speakersParams[1].equalsIgnoreCase((String) value))
                || (searchCriteria != SearchCriteria.Speakers.FREQUENCY_RANGE &&
                searchCriteria == SearchCriteria.Speakers.valueOf(speakersParams[0]) &&
                checkNumberValue(speakersParams[1], value));
    }

}


