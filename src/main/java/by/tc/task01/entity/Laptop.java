package by.tc.task01.entity;

public class Laptop extends Appliance{

    private float battery_capacity;
    private int os;
    private int memory_rom;
    private int system_memory;
    private float cpu;
    private int display_inchs;

    public Laptop() {  }

    public float getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(float battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public int getMemory_rom() {
        return memory_rom;
    }

    public void setMemory_rom(int memory_rom) {
        this.memory_rom = memory_rom;
    }

    public int getSystem_memory() {
        return system_memory;
    }

    public void setSystem_memory(int system_memory) {
        this.system_memory = system_memory;
    }

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public int getDisplay_inchs() {
        return display_inchs;
    }

    public void setDisplay_inchs(int display_inchs) {
        this.display_inchs = display_inchs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (battery_capacity != laptop.battery_capacity) return false;
        if (os != laptop.os) return false;
        if (memory_rom != laptop.memory_rom) return false;
        if (system_memory != laptop.system_memory) return false;
        if (cpu != laptop.cpu) return false;
        return display_inchs == laptop.display_inchs;
    }

    @Override
    public int hashCode() {
        int result = (battery_capacity != +0.0f ? Float.floatToIntBits(battery_capacity) : 0);
        result = 31 * result + os;
        result = 31 * result + memory_rom;
        result = 31 * result + system_memory;
        result = 31 * result + (cpu != +0.0f ? Float.floatToIntBits(cpu) : 0);
        result = 31 * result + display_inchs;
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "battery_capacity=" + battery_capacity +
                ", os=" + os +
                ", memory_rom=" + memory_rom +
                ", system_memory=" + system_memory +
                ", cpu=" + cpu +
                ", display_inchs=" + display_inchs +
                '}';
    }
}
