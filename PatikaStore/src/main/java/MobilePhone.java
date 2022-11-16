import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MobilePhone extends Product {
    private int storageSize;
    private double screenSize;
    private int ramSize;
    private int batteryCapacity;
    private String color;

    public MobilePhone(String name, double price, double discountRatio, int stockAmount, String brand, int storageSize,
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
                getDiscountRatio(), getStockAmount(), getBrand(), storageSize,screenSize, ramSize,
                batteryCapacity,color);
        System.out.println();
    }

    private static Map<String, MobilePhone> mobilePhone;
    static {
            mobilePhone = new HashMap<>();
    }

    public static Map<String, MobilePhone> getMobilePhone() {
        return mobilePhone;
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

    public static void add(){
        var input = new Scanner(System.in);

        System.out.print("İsim: ");
        String n = input.next();
        System.out.print("Fiyat: ");
        double p = input.nextDouble();
        System.out.print("İndirim oranı: ");
        double d = input.nextDouble();
        System.out.print("Stok miktarı: ");
        int a = input.nextInt();
        System.out.println("Aşağıdaki markalardan birini giriniz");
        Arrays.sort(Brand.getBrands());
        System.out.println(Arrays.toString(Brand.getBrands()));
        System.out.print("Marka: ");
        String i = input.next().toUpperCase();
        System.out.print("Depolama boyutu: ");
        int st = input.nextInt();
        System.out.print("Ekran boyutu: ");
        double sc = input.nextDouble();
        System.out.print("Ram boyutu: ");
        int r = input.nextInt();
        System.out.print("Pil kapasitesi: ");
        int b = input.nextInt();
        System.out.print("Renk: ");
        String c = input.next();

        var addPhone = new MobilePhone(n, p, d, a, i, st, sc, r, b, c);
        mobilePhone.put(addPhone.getId(), addPhone);
        System.out.println("Ürün eklendi");
    }

    public static Map filter(String deleteSelect){
        Map<String, Product> resultMobilePhone = MobilePhone.getMobilePhone().entrySet()
                .stream()
                .filter(map -> deleteSelect.equals(map.getValue()))
                .collect(Collectors.toMap(map -> map.getValue().getId(), map -> map.getValue()));

        return resultMobilePhone;
    }

}
