public class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int total() {
        return product.price() * quantity;
    }

    public Product product() {
        return null;
    }
}
