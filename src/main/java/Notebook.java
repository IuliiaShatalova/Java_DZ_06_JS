public class Notebook {
    String brand;
    String year;
    String color;
    String system;
    String RAM;
    String SSD;



    @Override
    public String toString() {
        return brand + ", " + year + ", " + color + ", " + "ОС - " +
                system + ", " + "RAM - " + RAM + ", " + "SSD - " + SSD;
    }
}
