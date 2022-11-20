import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public  class Product {
   private final String id = UUID.randomUUID().toString();
   private String name;
   private double price;
   private double discountRatio;
   private int stockAmount;
   private String brand;

   public Product() {
   }

   public Product(String name, double price, double discountRatio, int stockAmount, String brand) {
      this.name = name;
      this.price = price;
      this.discountRatio = discountRatio;
      this.stockAmount = stockAmount;
      this.brand = brand;
   }

   public static Map<String, Product> products;
   static {
      products = new HashMap<>();
   }  // her ürünü aynı hashmapte tutmak için kulllanılabilir

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

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
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

   public static void delete(String deleteSelect){
      if (MobilePhone.getMobilePhone().containsKey(deleteSelect)) {
         System.out.println(MobilePhone.getMobilePhone().get(deleteSelect).getName()+"isimli ürün silindi");
         MobilePhone.getMobilePhone().remove(deleteSelect);
         System.out.println();
      } else if (Notebook.getNotebook().containsKey(deleteSelect)) {
         System.out.println(Notebook.getNotebook().get(deleteSelect).getName()+" isimli ürün silindi");
         Notebook.getNotebook().remove(deleteSelect);
         System.out.println();
      } else {
         System.out.println("Bu ID'ye sahip bir ürün yok.");
         System.out.println();
      }
   }

}
