import java.time.Instant;

public class Payment {
    private final Order order;
    private final Instant paidAt;
    private final long authorizationNumber;
    private final int amount;
    private final Invoice invoice;

    public Payment(Order order) {
        this.order = order;
        this.paidAt = Instant.now();
        this.authorizationNumber = paidAt.toEpochMilli();
        this.amount = order.totalAmount();
        this.invoice = new Invoice(order);
    }

}
