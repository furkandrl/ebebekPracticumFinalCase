import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);// mainde input almak için
//program başladığında tabloda veri olması için eklenen ürünler
        var m2 = new MobilePhone("mate 20", 4200, 0.05, 212, "HUAWEI", 128,
                6.3, 3, 3750, "mavi");
        var m1 = new MobilePhone("galaxy", 1300, 0.1, 600, "SAMSUNG", 64,
                6.21, 4, 4000, "kırmızı");
        MobilePhone.getMobilePhone().put(m1.getId(), m1);
        MobilePhone.getMobilePhone().put(m2.getId(), m2);
        var n1 = new Notebook("nitro", 4500, 0.2, 100, "MONSTER",
                512, 15.3, 16);
        Notebook.getNotebook().put(n1.getId(), n1);
        var n2 = new Notebook("abra", 4500, 0.2, 100, "MONSTER",
                512, 15.3, 16);
        Notebook.getNotebook().put(n2.getId(), n2);


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
            System.out.print("Seçiminiz: ");
            int select = input.nextInt();
            if (select == 1) {
                boolean returnToMenu = false;

                while (returnToMenu == false) {

                    System.out.print("""
                            1 - Cep telefonlarını listele
                            2 - Notebookları listele
                            0 - Ana menüye dön
                            """);
                    System.out.print("Seçiminiz: ");
                    int listSelect = input.nextInt();

                    System.out.println("");

                    switch (listSelect) {
                        case 1:
                            MobilePhone.printTable();
                            break;
                        case 2:
                            Notebook.printTable();
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
                    System.out.print("Seçiminiz: ");
                    int filterSelect = input.nextInt();

                    if (filterSelect == 1) {
                        System.out.print("ID giriniz: ");
                        String filterId = input.next();
                        MobilePhone.filter(filterId);
                        Notebook.filter(filterId);
                    } else if (filterSelect == 2) {
                        System.out.println("Marka giriniz: ");
                        String filterBrand = input.next().toUpperCase();

                        Map<String, Product> result = MobilePhone.getMobilePhone().entrySet()
                                .stream()
                                .filter(map -> filterBrand.equals(map.getValue().getBrand()))
                                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

                        Map<String, Product> result2 = Notebook.getNotebook().entrySet()
                                .stream()
                                .filter(map -> filterBrand.equals(map.getValue().getBrand()))
                                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

                        System.out.println("---------------------------------------------------------------------");
                        System.out.printf("%25s %20s %10s %12s %12s %8s %15s %10s %8s %10s %7s","ID","NAME",
                                "PRICE","DISCOUNT", "IN STOCK","BRAND","STORAGE","SCREEN","RAM","BATTERY","COLOR");
                        System.out.println();
                        result.forEach((key, value) -> value.print());
                        result2.forEach((key, value) -> value.print());
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------");

                    } else if (filterSelect == 0) {
                        returnToMenu = true;
                    }
                }
            }

                if (select == 3) {boolean returnToMenu = false;

                    while (returnToMenu == false) {

                        System.out.print("""
                            1 - Cep telefonu ekle
                            2 - Notebook ekle
                            0 - Ana menüye dön
                            """);
                        System.out.print("Seçiminiz: ");
                        int listSelect = input.nextInt();

                        System.out.println("");

                        switch (listSelect) {
                            case 1:
                                MobilePhone.add();
                                break;
                            case 2:
                                Notebook.add();
                                break;
                            case 0:
                                returnToMenu = true;
                                break;
                        }
                    }
                }

                if (select == 4) {
                        System.out.print("Ürün silmek için ID giriniz: ");
                        var deleteSelect = input.next();
                        Product.delete(deleteSelect);
                }

                if (select == 5) {
                    System.out.println("Çıkış yapılıyor...");
                    quit = true;
                }
            }
        }
    }

