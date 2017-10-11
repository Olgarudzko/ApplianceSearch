package by.tc.task01.entity.criteria;

import by.tc.task01.extra.Strings;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

	private String applianceType;

	private Map<E, Object> criteria = new HashMap<E, Object>();

	public void add(E searchCriteria, Object value) {
		if (criteria.isEmpty()){
			if (searchCriteria instanceof SearchCriteria.Laptop){
				applianceType= Strings.LAPTOP;
			} else if (searchCriteria instanceof SearchCriteria.Oven){
				applianceType=Strings.OVEN;
			} else if (searchCriteria instanceof SearchCriteria.TabletPC){
				applianceType=Strings.TABLET_PC;
			} else if (searchCriteria instanceof SearchCriteria.Refrigerator){
				applianceType=Strings.REFRIGERATOR;
			} else if (searchCriteria instanceof SearchCriteria.VacuumCleaner){
				applianceType=Strings.VACUUM_CLEANER;
			}else if (searchCriteria instanceof SearchCriteria.Speakers){
				applianceType=Strings.SPEAKERS;
			}
		}
		criteria.put(searchCriteria, value);
	}

	public Map<E, Object> getCriteria() {
		return criteria;
	}
	// you may add your own code here

	public String getApplianceType() {
		return applianceType;
	}

	public void setApplianceType(String applianceType) {
		this.applianceType = applianceType;
	}
}
