import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order {

    private final Customer customer;
    private final Address address;
    private final List<OrderItem> items;
    private Temporal closedAt;
    private Payment payment;

    public Order(Customer customer, Address address) {
        this.customer = customer;
        this.address = address;
        this.items = new ArrayList<>();
        this.closedAt = null;
        this.payment = null;
    }

    public void addProduct(Product product, int quantity) throws Exception {
        Optional<OrderItem> productAlreadyAdded = items.stream()
                .filter(orderItem -> orderItem.product().equals(product))
                .findFirst();

        if (productAlreadyAdded.isPresent()) {
            throw new Exception("The product have already been added. Change the amount if you want more.");
        }
        items.add(new OrderItem(product, quantity));
    }

    public void pay(String paymentMethod) throws Exception {
        if (payment != null) {
            throw new Exception("The order has already been paid");
        }

        if (items.size() == 0) {
            throw new Exception("Empty order can not be paid");
        }

        payment = new Payment(this, paymentMethod);

        closedAt = Instant.now();
    }

    public int totalAmount() {
        return items.stream().map(OrderItem::total).reduce(0, Integer::sum);
    }

    public Address address() {
        return this.address;
    }
}
