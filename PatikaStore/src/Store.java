import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Store {

    Scanner scan = new Scanner(System.in).useLocale(Locale.US);

    public void run(){

        boolean status = true;
        while (status){
            System.out.println("----------- PATIKA STORE -----------");
            System.out.println("""
                    Lütfen yapacağınız işlemi seçiniz:
                    1- NoteBook İşlemleri
                    2- Cep Telefonu İşlemleri
                    3- Marka Listeleme
                    0- Çıkış
                    """);

            int choose = scan.nextInt();
            switch (choose){
                case 1: new ProductManager(Notebook.noteBooks).run(); break;
                case 2: new ProductManager(MobilePhone.mobilePhones).run(); break;
                case 3: sortAndPrintBrands(); break;
                case 0: status = false; break;
                default: System.out.println("Lütfen geçerli bir işlem giriniz!");

            }
        }
    }


    public void sortAndPrintBrands() {
        // İsimlere göre sıralama yapacak bir Comparator oluştur
        Comparator<Brand> nameComparator = Comparator.comparing(Brand::getName);

        // Brands ArrayList'ini isimlere göre sırala
        Collections.sort(Brand.myBrands, nameComparator);

        System.out.println("\nMarkalarımız");
        // Sıralanmış listeyi yazdır
        for (Brand brand : Brand.myBrands) {
            System.out.println("- "+brand.getName());
        }
    }
}
