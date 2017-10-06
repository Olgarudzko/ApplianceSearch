package by.tc.task01.entity;

public class TabletPC extends Appliance{

    public enum Color{RED, GREEN, BLUE}

    private short battery_capacity;
    private int display_inches;
    private int memory_rom;
    private short flash_memory_capacity;
    private Color color;

    public TabletPC() { }

    public short getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(short battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public int getDisplay_inches() {
        return display_inches;
    }

    public void setDisplay_inches(int display_inches) {
        this.display_inches = display_inches;
    }

    public int getMemory_rom() {
        return memory_rom;
    }

    public void setMemory_rom(int memory_rom) {
        this.memory_rom = memory_rom;
    }

    public short getFlash_memory_capacity() {
        return flash_memory_capacity;
    }

    public void setFlash_memory_capacity(short flash_memory_capacity) {
        this.flash_memory_capacity = flash_memory_capacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (battery_capacity != tabletPC.battery_capacity) return false;
        if (display_inches != tabletPC.display_inches) return false;
        if (memory_rom != tabletPC.memory_rom) return false;
        if (flash_memory_capacity != tabletPC.flash_memory_capacity) return false;
        return color == tabletPC.color;
    }

    @Override
    public int hashCode() {
        int result = battery_capacity;
        result = 31 * result + display_inches;
        result = 31 * result + memory_rom;
        result = 31 * result + flash_memory_capacity;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
