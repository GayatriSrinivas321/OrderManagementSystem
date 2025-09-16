public class Order {
    int userId;
    ORDER_STATUS status;
    List<Item> items;
    double totalAmount;
    LocalDateTime date;
    int version;
}