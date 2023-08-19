import java.util.HashMap;

public class Notebook extends Product{
    public static HashMap<Integer, Product> noteBooks = new HashMap<>();
    private static int nextNotebookId = 1;
    public Notebook(String name, Brand brandOfProduct, double screenSize, double batteryPower, int memory, int ram, String color, double price, int stock, double discountRate) {
        super(name, brandOfProduct, screenSize, batteryPower, memory, ram, color, price, stock, discountRate, nextNotebookId);
        noteBooks.put(nextNotebookId, this);
        nextNotebookId++;
    }

    static {
        new Notebook("HUAWEI Matebook 14", new Brand("Huawei"),14.0,5000,512,16,"black",24000,5,0.2);
        new Notebook("LENOVO V14 IGL", new Brand("Lenovo"),14.0,5000,1024,8,"white",16000,5,0.25);
    }
}
