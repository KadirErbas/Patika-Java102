import java.util.HashMap;

public class MobilePhone extends Product{
    public static HashMap<Integer, Product> mobilePhones = new HashMap<>();
    private static int nextPhoneId = 1;
    public MobilePhone(String name, Brand brandOfProduct, double screenSize, double batteryPower, int memory, int ram, String color, double price, int stock, double discountRate) {
        super(name, brandOfProduct, screenSize, batteryPower, memory, ram, color, price, stock, discountRate, nextPhoneId);
        mobilePhones.put(nextPhoneId, this);
        nextPhoneId++;
    }
    static {
        new MobilePhone("SAMSUNG GALAXY A51", new Brand("Samsung"),6.5,3000,128,6,"black",12000,5,0.2);
        new MobilePhone("iPhone 11 64 GB", new Brand("Apple"),6.1,3046,64,6,"white",12000,5,0.2);

    }
}
