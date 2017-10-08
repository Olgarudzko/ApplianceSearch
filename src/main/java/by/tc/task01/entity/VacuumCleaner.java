package by.tc.task01.entity;

public class VacuumCleaner extends Appliance{

    private int power_consumption;
    private String filter_type;
    private String bag_type;
    private String wand_type;
    private int motor_speed_regulation;
    private int cleaning_width;

    public VacuumCleaner() { }

    public int getPower_consumption() {
        return power_consumption;
    }

    public void setPower_consumption(int power_consumption) {
        this.power_consumption = power_consumption;
    }

    public String getFilter_type() {
        return filter_type;
    }

    public void setFilter_type(String filter_type) {
        this.filter_type = filter_type;
    }

    public String getBag_type() {
        return bag_type;
    }

    public void setBag_type(String bag_type) {
        this.bag_type = bag_type;
    }

    public String getWand_type() {
        return wand_type;
    }

    public void setWand_type(String wand_type) {
        this.wand_type = wand_type;
    }

    public int getMotor_speed_regulation() {
        return motor_speed_regulation;
    }

    public void setMotor_speed_regulation(int motor_speed_regulation) {
        this.motor_speed_regulation = motor_speed_regulation;
    }

    public int getCleaning_width() {
        return cleaning_width;
    }

    public void setCleaning_width(int cleaning_width) {
        this.cleaning_width = cleaning_width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacuumCleaner that = (VacuumCleaner) o;

        if (power_consumption != that.power_consumption) return false;
        if (motor_speed_regulation != that.motor_speed_regulation) return false;
        if (cleaning_width != that.cleaning_width) return false;
        if (filter_type != null ? !filter_type.equals(that.filter_type) : that.filter_type != null) return false;
        if (bag_type != null ? !bag_type.equals(that.bag_type) : that.bag_type != null) return false;
        return wand_type != null ? wand_type.equals(that.wand_type) : that.wand_type == null;
    }

    @Override
    public int hashCode() {
        int result = power_consumption;
        result = 31 * result + (filter_type != null ? filter_type.hashCode() : 0);
        result = 31 * result + (bag_type != null ? bag_type.hashCode() : 0);
        result = 31 * result + (wand_type != null ? wand_type.hashCode() : 0);
        result = 31 * result + motor_speed_regulation;
        result = 31 * result + cleaning_width;
        return result;
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "power_consumption=" + power_consumption +
                ", filter_type='" + filter_type +'\'' +
                ", bag_type='" + bag_type + '\'' +
                ", wand_type='" + wand_type + '\'' +
                ", motor_speed_regulation=" + motor_speed_regulation +
                ", cleaning_width=" + cleaning_width +
                '}';
    }
}
