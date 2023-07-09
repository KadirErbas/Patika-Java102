public class Main {
    public static void main(String[] args) {


        System.out.println("--------------------------------------------");

        MyList<Integer> liste = new MyList<>();
        System.out.println("Number of elements in the array : " + liste.size());
        System.out.println("Array capacity : " + liste.getCapacity());
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Number of elements in the array : " + liste.size());
        System.out.println("Array Capacity : " + liste.getCapacity());
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Number of elements in the array : " + liste.size());
        System.out.println("Array capacity : " + liste.getCapacity());
        liste.clear();
        System.out.println("---------------------------------------------");

        liste.add(10);
        liste.add(20);
        liste.add(30);
        System.out.println("The value of index 2 : " + liste.get(2));
        liste.remove(2);
        liste.add(40);
        liste.set(0, 100);
        System.out.println("The value of index 2 : " + liste.get(2));
        System.out.println(liste.toString());
        liste.clear();

        System.out.println("---------------------------------------------");

        System.out.println("List status : " + (liste.isEmpty() ? "Empty" : "Full"));
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        liste.add(20);
        liste.add(50);
        liste.add(60);
        liste.add(70);

        System.out.println("List status : " + (liste.isEmpty() ? "Empty" : "Full"));

        // Bulduğu ilk indeksi verir
        System.out.println("Indeks : " + liste.indexOf(20));

        // Bulamazsa -1 döndürür
        System.out.println("Indeks :" + liste.indexOf(100));

        // Bulduğu son indeksi verir
        System.out.println("Indeks : " + liste.lastIndexOf(20));

        // Listeyi Object[] dizisi olarak geri verir.
        Object[] dizi = liste.toArray();
        System.out.println("First element of object array :" + dizi[0]);

        // Liste veri türünde alt bir liste oluşturdu
        MyList<Integer> altListem = liste.subList(0, 3);
        System.out.println(altListem.toString());

        // Değerim listedeki olup olmadığını sorguladı
        System.out.println("Is it exist 20 in my list? : " + liste.contains(20));
        System.out.println("Is it exist 120 in my list? : " + liste.contains(120));

        // Listeyi tamamen boşaltır ve varsayılan boyutuna çevirir
        liste.clear();
        System.out.println(liste.toString());
        System.out.println(liste.getCapacity());
    }
}
