// Abstraction
public abstract class Customer {
    protected Discount discount;

    public Customer(Discount discount) {
        this.discount = discount;
    }

    public abstract void purchase(Item item);
}

// Refined Abstractions
public class SeniorCitizenCustomer extends Customer {
    public SeniorCitizenCustomer(Discount discount) {
        super(discount);
    }

    public void purchase(Item item) {
        double discountedPrice = discount.calculateDiscount(item.getPrice());
        System.out.println("Senior citizen customer purchased " + item.getName() + " with a " + discountedPrice + "% discount.");
    }
}

public class RegularCustomer extends Customer {
    public RegularCustomer(Discount discount) {
        super(discount);
    }

    public void purchase(Item item) {
        double discountedPrice = discount.calculateDiscount(item.getPrice());
        System.out.println("Regular customer purchased " + item.getName() + " with a " + discountedPrice + "% discount.");
    }
}

// Implementor
public interface Discount {
    public double calculateDiscount(double price);
}

// Concrete Implementors
public class ThirtyPercentDiscount implements Discount {
    public double calculateDiscount(double price) {
        return price * 0.7; // 30% discount
    }
}

public class TwentyFivePercentDiscount implements Discount {
    public double calculateDiscount(double price) {
        return price * 0.75; // 25% discount
    }
}

// Refined Implementors
public class ItemCategoryDiscount implements Discount {
    private double discountPercentage;

    public ItemCategoryDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double calculateDiscount(double price) {
        return price * (1 - discountPercentage);
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        // Create concrete implementors
        Discount thirtyPercentDiscount = new ThirtyPercentDiscount();
        Discount twentyFivePercentDiscount = new TwentyFivePercentDiscount();
        Discount tennisRacketDiscount = new ItemCategoryDiscount(0.2);
        Discount cricketBatDiscount = new ItemCategoryDiscount(0.15);

        // Create abstractions with different discounts
        Customer seniorCitizenCustomer = new SeniorCitizenCustomer(thirtyPercentDiscount);
        Customer regularCustomer = new RegularCustomer(twentyFivePercentDiscount);

        // Purchase items with different discounts
        Item tennisRacket = new Item("Tennis Racket", 100);
        Item cricketBat = new Item("Cricket Bat", 200);
        seniorCitizenCustomer.purchase(tennisRacket); // Output: Senior citizen customer purchased Tennis Racket with a 80.0% discount.
        regularCustomer.purchase(cricketBat); // Output: Regular customer purchased Cricket Bat with a 150.0% discount.
    }
}

// Product
public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
