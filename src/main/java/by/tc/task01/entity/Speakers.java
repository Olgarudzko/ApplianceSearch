package by.tc.task01.entity;

public class Speakers extends Appliance{

    private int power_consumption;
    private short number_of_speakers;
    private short frequency;
    private  short cord_lenght;

    public Speakers() { }

    public int getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(int power_consumption) {
        this.power_consumption = power_consumption;
    }

    public short getNumber_of_speakers() {
        return number_of_speakers;
    }

    public void setNumber_of_speakers(short number_of_speakers) {
        this.number_of_speakers = number_of_speakers;
    }

    public short getFrequency() {
        return frequency;
    }

    public void setFrequency(short frequency) {
        this.frequency = frequency;
    }

    public short getCord_lenght() {
        return cord_lenght;
    }

    public void setCord_lenght(short cord_lenght) {
        this.cord_lenght = cord_lenght;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speakers speakers = (Speakers) o;

        if (power_consumption != speakers.power_consumption) return false;
        if (number_of_speakers != speakers.number_of_speakers) return false;
        if (frequency != speakers.frequency) return false;
        return cord_lenght == speakers.cord_lenght;
    }

    @Override
    public int hashCode() {
        int result = power_consumption;
        result = 31 * result + (int) number_of_speakers;
        result = 31 * result + (int) frequency;
        result = 31 * result + (int) cord_lenght;
        return result;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "power_consumption=" + power_consumption +
                ", number_of_speakers=" + number_of_speakers +
                ", frequency=" + frequency +
                ", cord_lenght=" + cord_lenght +
                '}';
    }
}
