package by.tc.task01.entity;

public class Oven extends Appliance{

    private int power_consumption;
    private int weight;
    private int capacity;
    private int depth;
    private float height;
    private float width;

    public Oven() { }

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oven oven = (Oven) o;

        if (power_consumption != oven.power_consumption) return false;
        if (weight != oven.weight) return false;
        if (capacity != oven.capacity) return false;
        if (depth != oven.depth) return false;
        if (height != oven.height) return false;
        return width == oven.width;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = power_consumption;
        result = 31 * result + weight;
        result = 31 * result + capacity;
        result = 31 * result + depth;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
