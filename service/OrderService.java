@Service
class OrderService {
    
    List<Order> orders;
    
    UserService userService = new UserService();
    
    public String create(Order order) throws Exception {
        order.status = ORDER_STATUS.PENDING;
        if(!userService.checkUserExists(order.userId)) {
            throw new Exception("User Doesn't Exists");
        }
        for(Item item: order.items) {
            //check if item is present and quantity is available. If not cacncel the order 
        }
        orders.add(order);
        return "Your order Created SuccessFully";
    }
    
    public List<Order> get(int userId) {
        List<Order> orders = new ArrayList<>();
        for(Order order: orders) {
            if(order.userId == userId)
                orders.add(order);
        }
        return orders;
    } 
    
    public synchronized String update(int orderid, ORDER_STATUS status, int expectedVersion) {
        Order order = orders.get(orderid);
        if(order.version == expectedVersion) {
            order.status = status;  
            orders.set(orderid, order);
            order.version++;
            return "Your Order Status Updated to " + order.status;
        } else {
            return "Unable to Updated the Order";
        }
    }
    
    public double getAmount(int orderId) {
        return orders.get(orderId).totalAmount;
    }
}