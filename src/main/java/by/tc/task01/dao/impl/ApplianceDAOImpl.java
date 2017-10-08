package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Iterator;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    public <E> Appliance find(Criteria<E> criteria) {
        Iterator<Map.Entry<E, Object>> criteriaIterator = criteria.getCriteria().entrySet().iterator();
        String[] catalogue = Appliance.readCurrentCatalogue(getClass());
        if (catalogue != null) {
            while (criteriaIterator.hasNext()) {

                Map.Entry<E, Object> parameter = criteriaIterator.next();
                E searchCriteria = parameter.getKey();
                Object value = parameter.getValue();
                if (searchCriteria instanceof SearchCriteria.Laptop) {
                    for (String catalogueData : catalogue) {
                        if (catalogueData.contains("Laptop") || catalogueData.contains("LAPTOP") ||
                                catalogueData.contains("laptop")) {
                            String[] parameters = catalogueData.split("[ :,]+");
                            for (int i = 1; i < parameters.length; i++) {
                                String[] parsedParam = parameters[i].split("=");
                                if (searchCriteria == SearchCriteria.Laptop.valueOf(parsedParam[0]) ||
                                        value.equals(parsedParam[1])) {
                                    Laptop laptop = new Laptop();
                                    for (int j = 1; j < parameters.length; j++) {
                                        String[] parsedForResponse = parameters[j].split("=");
                                        if (parsedForResponse[0].trim().equalsIgnoreCase("BATTERY_CAPACITY")) {
                                            laptop.setBattery_capacity(Float.valueOf(parsedForResponse[1].trim()));
                                        } else if (parsedForResponse[0].trim().equalsIgnoreCase("CPU")){
                                            laptop.setCpu(Float.valueOf(parsedForResponse[1].trim()));
                                        } else if (parsedForResponse[0].trim().equalsIgnoreCase("DISPLAY_INCHS")){
                                            laptop.setDisplay_inchs(Integer.valueOf(parsedForResponse[1].trim()));
                                        } else if (parsedForResponse[0].trim().equalsIgnoreCase("MEMORY_ROM")){
                                            laptop.setMemory_rom(Integer.valueOf(parsedForResponse[1].trim()));
                                        } else if (parsedForResponse[0].trim().equalsIgnoreCase("OS")){
                                            laptop.setOs(parsedForResponse[1].trim());
                                        } else if (parsedForResponse[0].trim().equalsIgnoreCase("OS")){
                                            laptop.setSystem_memory(Integer.valueOf(parsedForResponse[1].trim()));
                                        }
                                    }
                                    return laptop;
                                }

                            }
                        }
                    }
                } else if (searchCriteria instanceof SearchCriteria.Oven) {

                } else if (searchCriteria instanceof SearchCriteria.Refrigerator) {

                } else if (searchCriteria instanceof SearchCriteria.TabletPC) {

                } else if (searchCriteria instanceof SearchCriteria.Speakers) {

                } else if (searchCriteria instanceof SearchCriteria.VacuumCleaner) {

                }
            }

        }
        return null;
    }

    // you may add your own code here

}


//you may add your own new classes