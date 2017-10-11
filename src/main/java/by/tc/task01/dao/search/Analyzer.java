package by.tc.task01.dao.search;

import java.util.Iterator;
import java.util.Map;

public interface Analyzer {
    <E> boolean isApplianceMatches(String [] catalogueLine, E searchCriteria, Object value, Iterator<Map.Entry<E, Object>> criteriaIterator);
}
