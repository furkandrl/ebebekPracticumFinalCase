import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    /*    var b1 = new Brand("SAMSUNG");
        var b2 = new Brand("LENOVO");
        var b3 = new Brand("APPLE");
        var b4 = new Brand("HUAWEI");
        var b5 = new Brand("CASPER");
        var b6 = new Brand("ASUS");
        var b7 = new Brand("HP");
        var b8 = new Brand("XIAOMI");
        var b9 = new Brand("MONSTER");

        Map<String, String> brands = new HashMap<>();
        brands.put(b1.getId(), b1.getName());
        brands.put(b2.getId(), b2.getName());
        brands.put(b3.getId(), b3.getName());
        brands.put(b4.getId(), b4.getName());
        brands.put(b5.getId(), b5.getName());
        brands.put(b6.getId(), b6.getName());
        brands.put(b7.getId(), b7.getName());
        brands.put(b8.getId(), b8.getName());
        brands.put(b9.getId(), b9.getName());
*/
        var input = new Scanner(System.in);

        var product = new Product();

        Map<String, Product> products = new HashMap<>();
       // Map<String, MobilePhone> mobilePhone = new HashMap<>();
        Map<String, Notebook> notebook = new HashMap<>();



        var m1 = new MobilePhone("galaxy", 1300, 0.1, 600, Brand.getBrands()[0], 64,
                6.21, 4, 4000, "kırmızı");
        var m2 = new MobilePhone("mate 20", 4200, 0.05, 212, Brand.getBrands()[7], 128,
                6.3, 3, 3750, "mavi");
        products.put(m1.getId(), m1);
        MobilePhone.mobilePhone.put(m1.getId(), m1);
        products.put(m2.getId(), m2);
        MobilePhone.mobilePhone.put(m2.getId(), m2);

        var n1 = new Notebook("nitro", 4500, 0.2, 100, Brand.getBrands()[8],
                512, 15.3, 16);
        products.put(n1.getId(), n1);
        notebook.put(n1.getId(), n1);

        var n2 = new Notebook("abra", 4500, 0.2, 100, Brand.getBrands()[8],
                512, 15.3, 16);
        products.put(n2.getId(), n2);
        notebook.put(n2.getId(), n2);


        System.out.println();
        System.out.println(Arrays.asList(Brand.getBrands()));



        System.out.println("PatikaStore'a Hoş Geldiniz!");
        boolean quit = false;
        while (quit != true) {
            System.out.print("""
                    Lütfen seçim yapınız
                    1 - Ürünleri listele
                    2 - Ürünleri filtrele
                    3 - Ürün ekle
                    4 - Ürün sil
                    5 - Çıkış
                    (numara olarak giriş yapın)
                    """);
            System.out.print("Seçimiz: ");
            int select = input.nextInt();
            if (select == 1) {
                boolean returnToMenu = false;

                while (returnToMenu == false) {

                    System.out.print("""
                            1 - Tüm ürünleri listele
                            2 - Cep telefonlarını listele
                            3 - Notebookları listele
                            0 - Ana menüye dön
                            """);
                    System.out.print("Seçiminiz: ");
                    int listSelect = input.nextInt();

                    System.out.println("");

                    switch (listSelect) {
                        case 1:
                            System.out.println("---------------------------------------------------------------------");
                            System.out.printf("%25s %20s %10s %12s %12s %8s %15s %10s %8s %10s %7s","ID","NAME",
                                    "PRICE","DISCOUNT", "IN STOCK","BRAND","STORAGE","SCREEN","RAM","BATTERY","COLOR");
                            System.out.println();
                            products.forEach((key, value) -> value.print());
                            System.out.println();
                            System.out.println("---------------------------------------------------------------------");
                            break;
                        case 2:
                            /*
                            System.out.println("---------------------------------------------------------------------");
                            System.out.printf("%25s %20s %10s %12s %12s %8s %15s %10s %8s %10s %7s","ID","NAME",
                                    "PRICE","DISCOUNT", "IN STOCK","BRAND","STORAGE","SCREEN","RAM","BATTERY","COLOR");
                            System.out.println();
                            mobilePhone.forEach((key, value) -> value.print());
                            System.out.println();
                            System.out.println("---------------------------------------------------------------------");
                            */
                            MobilePhone.printTable();
                            break;
                        case 3:
                            System.out.println("---------------------------------------------------------------------");
                            System.out.printf("%25s %20s %10s %12s %12s %8s %15s %10s %8s","ID","NAME",
                                    "PRICE","DISCOUNT", "IN STOCK","BRAND","STORAGE","SCREEN","RAM");
                            System.out.println();
                            notebook.forEach((key, value) -> value.print());
                            System.out.println();
                            System.out.println("---------------------------------------------------------------------");
                            break;
                        case 0:
                            returnToMenu = true;
                            break;
                    }
                }
            }

            if (select == 2) {
                boolean returnToMenu = false;

                while (returnToMenu == false) {
                    System.out.print("""
                            1 - ID'sine göre filtrele
                            2 - Markasına göre filtrele
                            0 - Ana menüye dön
                            """);
                    System.out.print("Seçimiz: ");
                    int filterSelect = input.nextInt();

                    if (filterSelect == 1) {
                        System.out.print("ID giriniz: ");
                        String filterId = input.next();

                        Map<String, Product> result = products.entrySet()
                                .stream()
                                .filter(map -> filterId.equals(map.getValue().getId()))
                                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

                        System.out.println("---------------------------------------------------------------------");
                        System.out.printf("%25s %20s %10s %12s %12s %8s %15s %10s %8s %10s %7s","ID","NAME",
                                "PRICE","DISCOUNT", "IN STOCK","BRAND","STORAGE","SCREEN","RAM","BATTERY","COLOR");
                        System.out.println();
                        result.forEach((key, value) -> value.print());
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------");


                    } else if (filterSelect == 2) {
                        System.out.println("Marka giriniz: ");
                        String filterBrand = input.next().toUpperCase();

                        Map<String, Product> result = products.entrySet()
                                .stream()
                                .filter(map -> filterBrand.equals(map.getValue().getBrand().getName()))
                                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

                        System.out.println("---------------------------------------------------------------------");
                        System.out.printf("%25s %20s %10s %12s %12s %8s %15s %10s %8s %10s %7s","ID","NAME",
                                "PRICE","DISCOUNT", "IN STOCK","BRAND","STORAGE","SCREEN","RAM","BATTERY","COLOR");
                        System.out.println();
                        result.forEach((key, value) -> value.print());
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------");

                    } else if (filterSelect == 0) {
                        returnToMenu = true;
                    }
                }
            }

                if (select == 3) {
                    System.out.print("İsim: ");
                    String n = input.next();
                    System.out.print("Fiyat: ");
                    double p = input.nextDouble();
                    System.out.print("İndirim oranı: ");
                    double d = input.nextDouble();
                    System.out.print("Stok miktarı: ");
                    int a = input.nextInt();
                    System.out.print("Marka: ");
                    int i = input.nextInt();
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

                    //new MobilePhone() ;
                      //price discount ratio stock brand storage size screen size ram size battery capacity color

                    String name = "m"+((int) (Math.random()*(1000+1)));

                    products.put(name, new MobilePhone(n, p, d, a, Brand.getBrands()[i], st, sc, r, b, c));


                }

                if (select == 4) {/*
                        System.out.print("Ürün silmek için ID giriniz: ");
                        var deleteSelect = input.next();
                        if (mobilePhone.containsKey(deleteSelect)) {
                            mobilePhone.remove(deleteSelect);
                            System.out.println("Ürün silindi");
                            System.out.println();
                        } else if (notebook.containsKey(deleteSelect)) {
                            mobilePhone.remove(deleteSelect);
                            System.out.println("Ürün silindi");
                            System.out.println();
                        } else {
                            System.out.println("Bu ID'ye sahip bir ürün yok");
                            System.out.println();
                        }*/
                }

                if (select == 5) {
                    System.out.println("Çıkış yapılıyor...");
                    quit = true;
                }
            }
        }
    }

