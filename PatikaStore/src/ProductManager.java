import java.util.*;

public class ProductManager {
    Scanner scan = new Scanner(System.in).useLocale(Locale.US);
    public HashMap<Integer,Product> myProductList;
    ProductManager(HashMap<Integer, Product> myProductList){
        this.myProductList= myProductList;
    }
    public void run(){
        boolean status = true;
        Transactions transactions = new Transactions();
        while (status){
            System.out.println("""
                    Lütfen yapmak istediğiniz işlemi seçiniz:
                    1- Ürün ekleme
                    2- Ürün silme
                    3- Ürün listeleme
                    4- Filtreleme ile ürün listeleme
                    0- Çıkış yapma""");

            int choose = scan.nextInt();
            switch (choose) {
                case 1 -> transactions.addProduct();
                case 2 -> transactions.deleteProduct();
                case 3 -> transactions.listProducts();
                case 4 -> transactions.searchByFilter();
                case 0 -> status = false;
                default -> System.out.println("Lütfen geçerli bir işlem giriniz!");
            }
        }
    }

    class Transactions{
        void addProduct(){
            scan.nextLine();
            String productName;
            Brand brandOfProduct;
            double screenSize;
            double batteryPower;
            int memory;
            int ram;
            String color;
            double price;
            int stock;
            double discountRate;



            System.out.print("Lütfen ürünün adını giriniz: ");
            productName = scan.nextLine();
            System.out.print("Lütfen ürünün markasını seçiniz:\n");
            for (Brand b: Brand.myBrands) {
                System.out.println(b.getId() +"- "+ b.getName());
            }
            int selectBrand = scan.nextInt();
            while (true){
                if(Brand.getBrandById(selectBrand) != null){
                    brandOfProduct = Brand.getBrandById(selectBrand);
                    break;
                }else {
                    System.out.println("Geçerli ID giriniz!");
                }
            }
            System.out.print("Lütfen ürünün ekran boyutunu giriniz: ");
            screenSize = scan.nextDouble();

            System.out.print("Lütfen ürünün batarya gücünü giriniz: ");
            batteryPower = scan.nextDouble();

            System.out.print("Lütfen ürünün hafıza kapasitesinin giriniz: ");
            memory = scan.nextInt();

            System.out.print("Lütfen ürünün ram miktarını giriniz: ");
            ram = scan.nextInt();

            System.out.print("Lütfen ürünün rengini giriniz "); scan.nextLine();
            color = scan.nextLine();

            System.out.print("Lütfen ürünün fiyatını giriniz: ");
            price = scan.nextDouble();

            System.out.print("Lütfen ürünün stok adedini giriniz: ");
            stock = scan.nextInt();

            System.out.print("Lütfen ürünün indirim oranını giriniz ");
            discountRate = scan.nextDouble();

            int lastId = 0;
            for (int key : myProductList.keySet()) {
                lastId = key;
            }
            int nextId = lastId + 1;
            Product newProduct = new Product(productName, brandOfProduct, screenSize, batteryPower, memory, ram, color, price, stock, discountRate , nextId);
            myProductList.put(newProduct.getId(), newProduct);

        }

        void deleteProduct(){
            listProducts();
            System.out.println("Silmek istediğiniz ürün ID'sini giriniz: ");
            int selectId = scan.nextInt();
            myProductList.remove(selectId);
            System.out.println(selectId + "'li ürün silindi.");
        }

        void listProducts(){
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+------------------------+\n");
            System.out.format("| ID       | Ürün Adı                       | Marka                  | Ekran Boyutu | Batarya Kapasitesi     | Depolama Kapasitesi       | RAM Kapasitesi   | Renk                   | Fiyat                  | Adet             | İndirim Oranı          | Son Fiyat              |\n");
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+------------------------+\n");
            for (Product product: myProductList.values()) {
                product.printProduct();
            }
        }

        void searchByFilter(){
            System.out.println("arama işlemi");
            System.out.println("Filtrele: ");
            scan.nextLine();
            String filter = scan.nextLine();

            // Filtrenin bir sayı mı yoksa harf mi olduğunu kontrol ediyoruz
            if (filter.matches("\\d+")) {
                int ourFilter = Integer.parseInt(filter);
                Product product = myProductList.get(ourFilter);
                if (product != null) {
                    // Ürün detaylarını yazdırmak için printProductDetails metodu çağrılıyor
                    printProductDetails(product);
                } else {
                    System.out.println("Bu id numarasına sahip ürün bulunamadı");
                }
            } else if (filter.matches("\\D+")) {
                // Markaya göre ürünleri filtrelemek için bir akış kullanılıyor
                List<Product> matchingProducts = myProductList.values().stream()
                        .filter(p -> p.getBrandOfProduct().getName().equals(filter))
                        .toList();

                if (!matchingProducts.isEmpty()) {
                    for (Product product : matchingProducts) {
                        // Ürün detaylarını yazdırmak için printProductDetails metodu çağrılıyor
                        printProductDetails(product);
                    }
                } else {
                    System.out.println("Belirtilen marka ile eşleşen bir ürün bulunamadı");
                }
            } else {
                System.out.println("Filtreleme id veya markaya göre yapılıyor lütfen bu değerlerden birini giriniz");
            }
        }
        void printProductDetails(Product product) {
            String format = "| %-8s | %-30s | %-22s | %-12s | %-22s | %-25s | %-16s | %-22s | %-22s | %-16s | %-22s |\n";
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
            System.out.format("| ID       | Ürün Adı                       | Marka                  | Ekran Boyutu | Batarya Kapasitesi     | Depolama Kapasitesi       | RAM Kapasitesi   | Renk                   | Fiyat                  | Adet             | İndirim Oranı          |\n");
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
            System.out.format(format, product.getId(), product.getName(), product.getBrandOfProduct().getName(), product.getScreenSize(), product.getBatteryPower(), product.getMemory(), product.getRam(), product.getColor(), product.getPrice(), product.getQuality(), product.getDiscountRate());
            System.out.format("+----------+--------------------------------+------------------------+--------------+------------------------+---------------------------+------------------+------------------------+------------------------+------------------+------------------------+\n");
        }


    }
}
