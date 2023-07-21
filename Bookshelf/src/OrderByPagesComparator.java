import java.util.Comparator;

public class OrderByPagesComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTotalPage() - o2.getTotalPage();
    }
}
