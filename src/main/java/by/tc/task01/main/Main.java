package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria<Oven> criteriaOven = new Criteria<Oven>();
		criteriaOven.add(Oven.CAPACITY, 33);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria<Oven>();
		criteriaOven.add(Oven.HEIGHT, 45.5);
		criteriaOven.add(Oven.DEPTH, 60);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
		criteriaTabletPC.add(TabletPC.COLOR, "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);

		appliance = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliance);

		Criteria <Laptop> criteriaLaptop = new Criteria<Laptop>();
		criteriaLaptop.add (Laptop.BATTERY_CAPACITY, 1);
		criteriaLaptop.add(Laptop.OS, "Windows");
		appliance = service.find(criteriaLaptop);
		PrintApplianceInfo.print(appliance);

		Criteria<VacuumCleaner> criteriaVacuumCleaner = new Criteria<VacuumCleaner>();
		criteriaVacuumCleaner.add(VacuumCleaner.WAND_TYPE, "all-in-one");
		criteriaVacuumCleaner.add(VacuumCleaner.BAG_TYPE, "AA-89");
		criteriaVacuumCleaner.add(VacuumCleaner.FILTER_TYPE, "B");
		criteriaVacuumCleaner.add(VacuumCleaner.POWER_CONSUMPTION, 110);
		appliance = service.find(criteriaVacuumCleaner);
		PrintApplianceInfo.print(appliance);

		Criteria<Refrigerator> criteriaRefrigerator = new Criteria<Refrigerator>();
		criteriaRefrigerator.add(Refrigerator.FREEZER_CAPACITY, 15);
		criteriaRefrigerator.add(Refrigerator.POWER_CONSUMPTION, 200);
		appliance = service.find(criteriaRefrigerator);
		PrintApplianceInfo.print(appliance);
	}

}
