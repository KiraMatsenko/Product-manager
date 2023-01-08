import ru.netology.product.product_manager.product_item.Product;

public class Smartphone extends Product {

    private String brand;

    public Smartphone() {

    }

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getBrand().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
