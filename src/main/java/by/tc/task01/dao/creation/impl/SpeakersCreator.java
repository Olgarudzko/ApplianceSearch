package by.tc.task01.dao.creation.impl;

import by.tc.task01.dao.creation.ApplianceCreator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.extra.Strings;

public class SpeakersCreator implements ApplianceCreator {

    public Speakers create(String[] parameters) {
        Speakers speakers = new Speakers();
        for (int j = 1; j < parameters.length; j++) {
            String[] parsedDescription = parameters[j].trim().split(Strings.EQUAL);
            String parameter = parsedDescription[0];
            String value = parsedDescription[1];
            if (parameter.equalsIgnoreCase(Strings.POWER_CONSUMPTION)) {
                speakers.setPowerConsumption(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.NUMBER_OF_SPEAKERS)) {
                speakers.setNumberOfSpeakers(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.CORD_LENGTH)) {
                speakers.setCordLenght(Double.valueOf(value));
            } else if (parameter.equalsIgnoreCase(Strings.FREQUENCY_RANGE)) {
                speakers.setFrequency(value);
            }
        }
        return speakers;
    }
}
