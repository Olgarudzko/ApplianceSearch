package by.tc.task01.dao.creation;

import by.tc.task01.entity.Appliance;

public interface Command {
    Appliance execute(String[] parameters);
}
