import java.util.HashMap;
import java.util.Map;

public class MobilePhone extends Product {
    //private final String id = UUID.randomUUID().toString();
   // private String name;

    private int storageSize;
    private double screenSize;
    private int ramSize;
    private int batteryCapacity;
    private String color;

    public MobilePhone(){}

    public MobilePhone(String name, double price, double discountRatio, int stockAmount, Brand brand, int storageSize,
    double screenSize, int ramSize, int batteryCapacity, String color) {
        super(name,
                price,
                discountRatio,
                stockAmount,
                brand);
        this.storageSize = storageSize;
        this.screenSize = screenSize;
        this.ramSize = ramSize;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public MobilePhone(String n, double p, double d, int a, int st, double sc, int r, int b, String c) {
    }


    /*public String getId() {
        return id;
    }*/
/*
    public String getName() {
        return name;
    }*/
/*
    public void setName(String name) {
        this.name = name;
    }*/
/*
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRatio() {
        return discountRatio;
    }

    public void setDiscountRatio(double discountRatio) {
        this.discountRatio = discountRatio;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
*/
    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void print(){
        System.out.format("%25s %10s %10s %10s %10s %12s %12s %12s %7s %9s %10s", getId(), getName(), getPrice(),
                getDiscountRatio(), getStockAmount(), getBrand().getName(), storageSize,screenSize, ramSize,
                batteryCapacity,color);
        System.out.println();
    }

    public static Map<String, MobilePhone> mobilePhone;
    static {
            mobilePhone = new HashMap<>();
    }

    public static void printTable(){
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%25s %20s %10s %12s %12s %8s %15s %10s %8s %10s %7s","ID","NAME",
                "PRICE","DISCOUNT", "IN STOCK","BRAND","STORAGE","SCREEN","RAM","BATTERY","COLOR");
        System.out.println();
        mobilePhone.forEach((key, value) -> value.print());
        System.out.println();
        System.out.println("---------------------------------------------------------------------");
    }

    public void add(){

        System.out.print("Enter name: ");

        new MobilePhone("iphone 13", 25000, 0.01, 870,
                Brand.getBrands()[2], 256, 6.06, 4, 3227, "white");
        MobilePhone MobilePhone = null;
        mobilePhone.put(MobilePhone.getId() ,MobilePhone);

    }
}
