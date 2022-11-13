public class Notebook extends Product{

    private int storageSize;
    private double screenSize;
    private int ramSize;


    public Notebook(String name, double price, double discountRatio, int stockAmount, Brand brand, int storageSize, double screenSize, int ramSize) {
        super(name,
                price,
                discountRatio,
                stockAmount,
                brand);
        this.storageSize = storageSize;
        this.screenSize = screenSize;
        this.ramSize = ramSize;
    }

    public Notebook() {

    }
/*
    public String getId() {
        return id;
    }*/
/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public void print(){
        System.out.format("%25s %10s %10s %10s %10s %12s %12s %12s %7s", getId(), getName(), getPrice(),
                getDiscountRatio(), getStockAmount(),getBrand().getName(), storageSize, screenSize, ramSize);
        System.out.println();
    }


}
