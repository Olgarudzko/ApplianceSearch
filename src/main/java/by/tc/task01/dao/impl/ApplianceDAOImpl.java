package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.analysis.AnalysisCommander;
import by.tc.task01.dao.analysis.Analyzer;
import by.tc.task01.dao.creation.ApplianceCreator;
import by.tc.task01.dao.creation.CreationCommander;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.extra.Strings;

public class ApplianceDAOImpl implements ApplianceDAO {

    public <E> Appliance find(Criteria<E> criteria) {

        String[] catalogue = Appliance.readCurrentCatalogue(getClass());

        if (catalogue == null) {
            return null;
        }

        Analyzer analyzer = AnalysisCommander.getInstance().getApplianceAnalyzer(criteria.getApplianceType());
        ApplianceCreator creator = CreationCommander.getInstance().getApplianceCreator(criteria.getApplianceType());

        for (String catalogueLine : catalogue) {
            String[] parsedDescription = findApplianceWithMatchingName(catalogueLine, criteria.getApplianceType());

            if (analyzer.isApplianceMatches(parsedDescription, criteria.getCriteria())) {
                return creator.create(parsedDescription);
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


