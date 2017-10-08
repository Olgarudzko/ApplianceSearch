package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Iterator;
import java.util.Map;

public class Validator {
	
	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
		// you may add your own code here
		Iterator<Map.Entry<E, Object>> criteriaIterator=criteria.getCriteria().entrySet().iterator();
		while (criteriaIterator.hasNext()){
			Map.Entry<E, Object> parameter=criteriaIterator.next();
			E searchCriteria = parameter.getKey();
			Object value = parameter.getValue();

		}
		return true;
	}

}

//you may add your own new classes