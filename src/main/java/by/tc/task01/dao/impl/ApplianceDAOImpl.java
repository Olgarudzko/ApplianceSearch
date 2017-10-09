package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
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
                        String[] applianceDescription = findApplianceWithMatchingName(catalogueLine, "Laptop");
                        if (applianceDescription != null) {
                            for (int i = 1; i < applianceDescription.length; i++) {
                                String[] applianceParams = applianceDescription[i].split("=");
                                if (searchCriteria == SearchCriteria.Laptop.valueOf(applianceParams[0]) &&
                                        checkNumberValue(applianceParams[1], value)) {
                                    return extractLaptopFomCatalogue(applianceDescription);
                                }
                            }
                        }
                    }
                } else if (searchCriteria instanceof SearchCriteria.Oven) {
                    for (String catalogueLine : catalogue) {
                        String[] applianceDescription = findApplianceWithMatchingName(catalogueLine, "Oven");
                        if (applianceDescription != null) {
                            for (int i = 1; i < applianceDescription.length; i++) {
                                String[] applianceParams = applianceDescription[i].split("=");
                                if (searchCriteria == SearchCriteria.Oven.valueOf(applianceParams[0]) &&
                                        checkNumberValue(applianceParams[1], value)) {
                                    return extractOvenFomCatalogue(applianceDescription);
                                }
                            }
                        }
                    }
                } else if (searchCriteria instanceof SearchCriteria.Refrigerator) {

                } else if (searchCriteria instanceof SearchCriteria.TabletPC) {

                } else if (searchCriteria instanceof SearchCriteria.Speakers) {

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


}


