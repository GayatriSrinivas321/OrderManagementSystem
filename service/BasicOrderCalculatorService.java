public class BasicOrderCalculatorService {
    // @Async
    public double calculate(Order order) {
        double totalAmount = 0.0;
        for(Item e: order.items) {
            totalAmount += e.quantity * e.price;
        }
        return totalAmount;
    }
}
