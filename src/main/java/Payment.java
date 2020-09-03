import java.time.Instant;

public class Payment {
    private final Order order;
    private final String paymentMethod;
    private final Instant paidAt;
    private final long authorizationNumber;
    private final int amount;
    private final Invoice invoice;

    public Payment(Order order, String paymentMethod) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.paidAt = Instant.now();
        this.authorizationNumber = paidAt.toEpochMilli();
        this.amount = order.totalAmount();
        this.invoice = new Invoice(order);
    }
}
