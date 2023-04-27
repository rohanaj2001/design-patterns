// Context class
public class Customer {
    private PricingStrategy pricingStrategy;
    private double purchaseAmount;
    
    public Customer(PricingStrategy pricingStrategy, double purchaseAmount) {
        this.pricingStrategy = pricingStrategy;
        this.purchaseAmount = purchaseAmount;
    }
    
    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
    
    public double calculateDiscount() {
        return pricingStrategy.calculateDiscount(purchaseAmount);
    }
}

// Strategy interface
public interface PricingStrategy {
    double calculateDiscount(double purchaseAmount);
}

// Concrete strategy classes
public class RegularCustomerPricingStrategy implements PricingStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.12;
    
    @Override
    public double calculateDiscount(double purchaseAmount) {
        return purchaseAmount * DISCOUNT_PERCENTAGE;
    }
}

public class SeniorCitizenPricingStrategy implements PricingStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.10;
    
    @Override
    public double calculateDiscount(double purchaseAmount) {
        return purchaseAmount * DISCOUNT_PERCENTAGE;
    }
}

public class FirstTimeCustomerPricingStrategy implements PricingStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.15;
    
    @Override
    public double calculateDiscount(double purchaseAmount) {
        return purchaseAmount * DISCOUNT_PERCENTAGE;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(new RegularCustomerPricingStrategy(), 2000.0);
        double discount = customer.calculateDiscount();
        System.out.println("Discount for regular customer: " + discount);
        
        customer.setPricingStrategy(new SeniorCitizenPricingStrategy());
        discount = customer.calculateDiscount();
        System.out.println("Discount for senior citizen: " + discount);
        
        customer.setPricingStrategy(new FirstTimeCustomerPricingStrategy());
        discount = customer.calculateDiscount();
        System.out.println("Discount for first time customer: " + discount);
    }
}
