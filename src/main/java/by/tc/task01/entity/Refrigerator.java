package by.tc.task01.entity;

public class Refrigerator extends Appliance{

    private int power_consumption;
    private int weight;
    private int freezer_capacity;
    private int overall_capacity;
    private int height;
    private int width;

    public Refrigerator() {  }

    public int getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(int power_consumption) {
        this.power_consumption = power_consumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFreezer_capacity() {
        return freezer_capacity;
    }

    public void setFreezer_capacity(int freezer_capacity) {
        this.freezer_capacity = freezer_capacity;
    }

    public int getOverall_capacity() {
        return overall_capacity;
    }

    public void setOverall_capacity(int overall_capacity) {
        this.overall_capacity = overall_capacity;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Refrigerator that = (Refrigerator) o;

        if (power_consumption != that.power_consumption) return false;
        if (weight != that.weight) return false;
        if (freezer_capacity != that.freezer_capacity) return false;
        if (overall_capacity != that.overall_capacity) return false;
        if (height != that.height) return false;
        return width == that.width;
    }

    @Override
    public int hashCode() {
        int result = power_consumption;
        result = 31 * result + weight;
        result = 31 * result + freezer_capacity;
        result = 31 * result + overall_capacity;
        result = 31 * result + height;
        result = 31 * result + width;
        return result;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "power_consumption=" + power_consumption +
                ", weight=" + weight +
                ", freezer_capacity=" + freezer_capacity +
                ", overall_capacity=" + overall_capacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
