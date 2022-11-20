import java.util.*;

public class Notebook extends Product{
    private int storageSize;
    private double screenSize;
    private int ramSize;

    public Notebook(String name, double price, double discountRatio, int stockAmount, String brand, int storageSize,
                    double screenSize, int ramSize) {
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
                getDiscountRatio(), getStockAmount(),getBrand(), storageSize, screenSize, ramSize);
        System.out.println();
    }

    public static void printTable(){
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%25s %20s %10s %12s %12s %8s %15s %10s %8s","ID","NAME",
                "PRICE","DISCOUNT", "IN STOCK","BRAND","STORAGE","SCREEN","RAM");
        System.out.println();
        notebook.forEach((key, value) -> value.print());
        System.out.println();
        System.out.println("---------------------------------------------------------------------");
    }

    private static Map<String, Notebook> notebook;
    static {
        notebook = new HashMap<>();
    }

    public static Map<String, Notebook> getNotebook() {
        return notebook;
    }

    public static void add(){
        var input = new Scanner(System.in);

        var addNotebook = new Notebook();

        System.out.print("İsim: ");
        addNotebook.setName(input.next());
        System.out.print("Fiyat: ");
        addNotebook.setPrice(input.nextDouble());
        System.out.print("İndirim oranı: ");
        addNotebook.setDiscountRatio(input.nextDouble());
        System.out.print("Stok miktarı: ");
        addNotebook.setStockAmount(input.nextInt());
        Arrays.sort(Brand.getBrands());
        System.out.println(Arrays.toString(Brand.getBrands()));
        System.out.print("Marka: ");
        addNotebook.setBrand(input.next().toUpperCase());
        System.out.print("Depolama boyutu: ");
        addNotebook.setStorageSize(input.nextInt());
        System.out.print("Ekran boyutu: ");
        addNotebook.setScreenSize(input.nextDouble());
        System.out.print("Ram boyutu: ");
        addNotebook.setRamSize(input.nextInt());

        notebook.put(addNotebook.getId(), addNotebook);
        System.out.println("Ürün eklendi");
    }

    public static void filter(String toFilter){
        if(notebook.containsKey(toFilter)){
            System.out.println("---------------------------------------------------------------------");
            System.out.printf("%25s %20s %10s %12s %12s %8s %15s %10s %8s","ID","NAME",
                    "PRICE","DISCOUNT", "IN STOCK","BRAND","STORAGE","SCREEN","RAM");
            System.out.println();
            notebook.get(toFilter).print();
            System.out.println();
            System.out.println("---------------------------------------------------------------------");
        }
    }


}
