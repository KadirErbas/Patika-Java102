public class Product
{
    private String name;
    private double price;
    private double discountRate;
    private int quality;
    private Brand brandOfProduct;
    private double screenSize;
    private double batteryPower;
    private  int memory;
    private int ram;
    private String color;
    private int id;

    public Product(String name, Brand brandOfProduct, double screenSize, double batteryPower, int memory, int ram, String color, double price, int quality, double discountRate, int id) {
        this.name = name;
        this.brandOfProduct = brandOfProduct;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.memory = memory;
        this.ram = ram;
        this.color = color;
        this.price = price;
        this.quality = quality;
        this.discountRate = discountRate;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getLastPrice(){return this.getPrice() * (1 - this.getDiscountRate());}

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public Brand getBrandOfProduct() {
        return brandOfProduct;
    }

    public void setBrandOfProduct(Brand brandOfProduct) {
        this.brandOfProduct = brandOfProduct;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(double batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printProduct(){
        String format = "| %-8s | %-30s | %-22s | %-12s | %-22s | %-25s | %-16s | %-22s | %-22s | %-16s | %-22s | %-22s |\n";
        System.out.format(format, this.getId(), this.getName(), this.getBrandOfProduct().getName(), this.getScreenSize(), this.getBatteryPower(), this.getMemory(), this.getRam(), this.getColor(), this.getPrice(), this.getQuality(), this.getDiscountRate(), this.getLastPrice());
    }
}