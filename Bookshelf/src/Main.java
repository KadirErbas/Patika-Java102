import java.util.*;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> books = new TreeSet<>();

        books.add(new Book("Animal Farm", 568, "George Orwell",
                "22.07.2023"));
        books.add(new Book("Pia Mater", 354, "Serkan Karaismailoğlu",
                "22.07.2023"));
        books.add(new Book("Homo Sapiens", 11, "Yuval Noah Harari",
                "22.07.2023"));
        books.add(new Book("Homo Deus", 1345, "Yuval Noah Harari",
                "22.07.2023"));
        books.add(new Book("A Brief History Of Time", 200, "Stephen Hawking",
                "22.07.2023"));

        System.out.println("Kitaplar isme gore siralandi:\n");
        for (Book book : books) {
            System.out.println(book);
        }

        TreeSet<Book> books2 = new TreeSet<>(new OrderByPagesComparator());
        books2.addAll(books);

        System.out.println("\n\nKitaplar sayfalarina gore siralandi:\n");
        for (Book book : books2) {
            System.out.println(book);
        }

    }
}