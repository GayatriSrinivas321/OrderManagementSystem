public class TaxCalculator implements Calculator{
    private double taxPerCentage = 18;
    
    public TaxCalculator(double taxPerCentage) {
        this.taxPerCentage = taxPerCentage;
    }
    
    @Override
    public double calculate(Order order) {
        return order.totalAmount * taxPerCentage/100;
    }
}
