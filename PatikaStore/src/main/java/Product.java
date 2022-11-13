import java.util.UUID;

public  class Product {
   private final String id = UUID.randomUUID().toString();
   private String name;
   private double price;
   private double discountRatio;
   private int stockAmount;
   private Brand brand;

   public Product() {
   }

   public Product(String name, double price, double discountRatio, int stockAmount, Brand brand) {
      this.name = name;
      this.price = price;
      this.discountRatio = discountRatio;
      this.stockAmount = stockAmount;
      this.brand = brand;
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

   public String getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void print() {
   }
}
