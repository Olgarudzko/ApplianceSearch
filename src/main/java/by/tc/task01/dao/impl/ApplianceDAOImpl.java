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

                String[] parsedDescription;

                if (searchCriteria instanceof SearchCriteria.Laptop) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, "Laptop");
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] laptopParam = parsedDescription[i].split("=");
                                if (isLaptopParameterMatching(searchCriteria, laptopParam, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.Laptop.valueOf(params[0])) {
                                                if (!isLaptopParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractLaptopFomCatalogue(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.Oven) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, "Oven");
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split("=");
                                if (searchCriteria == SearchCriteria.Oven.valueOf(applianceParams[0]) &&
                                        checkNumberValue(applianceParams[1], value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.Oven.valueOf(params[0])) {
                                                if (!checkNumberValue(params[1], nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractOvenFomCatalogue(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.Refrigerator) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, "Refrigerator");
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split("=");
                                if (searchCriteria == SearchCriteria.Refrigerator.valueOf(applianceParams[0]) &&
                                        checkNumberValue(applianceParams[1], value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.Refrigerator.valueOf(params[0])) {
                                                if (!checkNumberValue(params[1], nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractRefrigeratorFomCatalogue(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.TabletPC) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, "TabletPC");
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split("=");
                                if (isTabletPCParameterMatching(searchCriteria, applianceParams, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.TabletPC.valueOf(params[0])) {
                                                if (!isTabletPCParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractTabletPCFomCatalogue(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.Speakers) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, "Speakers");
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split("=");
                                if (isSpeakersParameterMatching(searchCriteria, applianceParams, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.Speakers.valueOf(params[0])) {
                                                if (!isSpeakersParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractSpeakersFomCatalogue(parsedDescription);
                                }
                            }
                        }
                    }


                } else if (searchCriteria instanceof SearchCriteria.VacuumCleaner) {
                    for (String catalogueLine : catalogue) {
                        parsedDescription = findApplianceWithMatchingName(catalogueLine, "VacuumCleaner");
                        if (parsedDescription != null) {
                            for (int i = 1; i < parsedDescription.length; i++) {
                                String[] applianceParams = parsedDescription[i].split("=");
                                if (isVacuumCleanerParameterMatching(searchCriteria, applianceParams, value)) {
                                    while (criteriaIterator.hasNext()) {
                                        Map.Entry<E, Object> nextParameter = criteriaIterator.next();
                                        E nextSearchCriteria = nextParameter.getKey();
                                        Object nextValue = nextParameter.getValue();
                                        for (int j = 1; j < parsedDescription.length; j++) {
                                            String[] params = parsedDescription[j].split("=");
                                            if (nextSearchCriteria == SearchCriteria.VacuumCleaner.valueOf(params[0])) {
                                                if (!isVacuumCleanerParameterMatching(nextSearchCriteria, params, nextValue)) {
                                                    return null;
                                                }
                                            }
                                        }
                                    }
                                    return extractVacuumCleanerFomCatalogue(parsedDescription);
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
                laptop.setBatteryCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("CPU")) {
                laptop.setCpu(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("DISPLAY_INCHS")) {
                laptop.setDisplayInchs(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("MEMORY_ROM")) {
                laptop.setMemoryRom(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("OS")) {
                laptop.setOs(value);
            } else if (parameter.equalsIgnoreCase("SYSTEM_MEMORY")) {
                laptop.setSystemMemory(Double.valueOf(value));
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
                oven.setPowerConsumption(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("WEIGHT")) {
                oven.setWeight(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("CAPACITY")) {
                oven.setCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("DEPTH")) {
                oven.setDepth(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("HEIGHT")) {
                oven.setHeight(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("WIDTH")) {
                oven.setWidth(Double.valueOf(value));
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
                refrigerator.setPowerConsumption(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("WEIGHT")) {
                refrigerator.setWeight(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("FREEZER_CAPACITY")) {
                refrigerator.setFreezerCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("OVERALL_CAPACITY")) {
                refrigerator.setOverallCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("HEIGHT")) {
                refrigerator.setHeight(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("WIDTH")) {
                refrigerator.setWidth(Double.valueOf(value));
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
                speakers.setPowerConsumption(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("NUMBER_OF_SPEAKERS")) {
                speakers.setNumberOfSpeakers(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("CORD_LENGTH")) {
                speakers.setCordLenght(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("FREQUENCY_RANGE")) {
                speakers.setFrequency(value);
            }
        }
        return speakers;
    }

    private TabletPC extractTabletPCFomCatalogue(String[] tabletPCDescription) {
        TabletPC tabletPC = new TabletPC();
        for (int j = 1; j < tabletPCDescription.length; j++) {
            String[] parsedDescription = tabletPCDescription[j].trim().split("=");
            String parameter = parsedDescription[0];
            String value = parsedDescription[1];
            if (parameter.equalsIgnoreCase("BATTERY_CAPACITY")) {
                tabletPC.setBatteryCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("DISPLAY_INCHES")) {
                tabletPC.setDisplayInches(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("MEMORY_ROM")) {
                tabletPC.setMemoryRom(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("FLASH_MEMORY_CAPACITY")) {
                tabletPC.setFlashMemoryCapacity(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("COLOR")) {
                tabletPC.setColor(value);
            }
        }
        return tabletPC;
    }

    private Appliance extractVacuumCleanerFomCatalogue(String[] vacuumCleanerDescription) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        for (int j = 1; j < vacuumCleanerDescription.length; j++) {
            String[] parsedDescription = vacuumCleanerDescription[j].trim().split("=");
            String parameter = parsedDescription[0];
            String value = parsedDescription[1];
            if (parameter.equalsIgnoreCase("POWER_CONSUMPTION")) {
                vacuumCleaner.setPowerConsumption(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("MOTOR_SPEED_REGULATION")) {
                vacuumCleaner.setMotorSpeedRegulation(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("CLEANING_WIDTH")) {
                vacuumCleaner.setCleaningWidth(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase("FILTER_TYPE")) {
                vacuumCleaner.setFilterType(value);
            } else if (parameter.equalsIgnoreCase("BAG_TYPE")) {
                vacuumCleaner.setBagType(value);
            } else if (parameter.equalsIgnoreCase("WAND_TYPE")) {
                vacuumCleaner.setWandType(value);
            }
        }
        return vacuumCleaner;
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


