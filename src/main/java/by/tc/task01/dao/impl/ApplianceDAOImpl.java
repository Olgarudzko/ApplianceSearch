package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.creation.CreationCommander;
import by.tc.task01.dao.creation.ApplianceCreator;
import by.tc.task01.dao.search.Analyzer;
import by.tc.task01.dao.search.AnalyzeCommander;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
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

                Analyzer analyzer = AnalyzeCommander.getInstance().getApplianceAnalyzer(criteria.getApplianceType());
                ApplianceCreator creator = CreationCommander.getInstance().getApplianceCreator(criteria.getApplianceType());
                for (String catalogueLine : catalogue) {
                    String[] parsedDescription = findApplianceWithMatchingName(catalogueLine, criteria.getApplianceType());
                    if (analyzer.isApplianceMatches(parsedDescription, searchCriteria, value, criteriaIterator)){
                        return creator.create(parsedDescription);
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
}


