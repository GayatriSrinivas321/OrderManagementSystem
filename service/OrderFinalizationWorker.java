public class OrderFinalizationWorker {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public void finalizeOrderAsync(int orderId, Order order) {
        executor.submit(() -> {
            System.out.println("Finalizing order: " + order);
            new BasicOrderCalculatorService().calculate(order);
            new OrderService().update(orderId, ORDER_STATUS.CONFIRMED, order.getVersion);
            System.out.println("Order finalized: " + order);
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}
