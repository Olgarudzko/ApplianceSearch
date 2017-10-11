package by.tc.task01.dao.analysis;

import java.util.Map;

public interface Analyzer {
    <E> boolean isApplianceMatches(String[] description, Map <E, Object> request);
}
