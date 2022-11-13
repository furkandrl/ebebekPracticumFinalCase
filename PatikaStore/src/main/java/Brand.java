import java.util.UUID;

public class Brand implements Comparable<Brand>{
    private  int id; //UUID.randomUUID().toString();
    private String name;

    public Brand(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static Brand[] brands;

    static{
        brands = new Brand[9];
        brands[0] = new Brand(0, "SAMSUNG");
        brands[1] = new Brand(1, "LENOVO");
        brands[2] = new Brand(2, "APPLE");
        brands[3] = new Brand(3, "HUAWEI");
        brands[4] = new Brand(4, "CASPER");
        brands[5] = new Brand(5, "ASUS");
        brands[6] = new Brand(6, "HP");
        brands[7] = new Brand(7, "XIAOMI");
        brands[8] = new Brand(8, "MONSTER");
    }

    public static Brand[] getBrands(){
        return Brand.brands;
    }

    @Override
    public int compareTo(Brand o) {
        return Brand.brands.getClass().getName().compareTo(Brand.brands.getClass().getName());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name+ "}"
                ;
    }
}
