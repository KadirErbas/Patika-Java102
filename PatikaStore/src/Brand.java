import java.util.ArrayList;

public class Brand {
    private int id;
    private static int nextId = 1;
    private String name;

    public static ArrayList<Brand> myBrands = new ArrayList<>();

    public Brand(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static {
        myBrands.add(new Brand("Samsung"));
        myBrands.add(new Brand("Lenovo"));
        myBrands.add(new Brand("Apple"));
        myBrands.add(new Brand("Huawei"));
        myBrands.add(new Brand("Casper"));
        myBrands.add(new Brand("Asus"));
        myBrands.add(new Brand("HP"));
        myBrands.add(new Brand("Xiomi"));
        myBrands.add(new Brand("Monster"));
    }
    public static Brand getBrandById(int id){
        for (Brand brand: myBrands) {
            if(id == brand.id){
                return brand;
            }
        }
        return null;
    }

}
