public abstract class Customer {
    protected String name;
    protected int age;
    protected boolean isSenior;
    protected double discount;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.isSenior = age >= 60;
    }

    public double calculateDiscount(double amount) {
        return amount * discount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSenior() {
        return isSenior;
    }
}


public class RegularCustomer extends Customer {
    public RegularCustomer(String name, int age) {
        super(name, age);
        discount = 0.12;
    }
}

public class SeniorCitizenCustomer extends Customer {
    public SeniorCitizenCustomer(String name, int age) {
        super(name, age);
        discount = 0.10;
    }
}

public class FirstTimeCustomer extends Customer {
    public FirstTimeCustomer(String name, int age) {
        super(name, age);
        discount = 0.15;
    }
}

// More concrete customer classes can be added here


public class CustomerFactory {
    public static Customer createCustomer(String type, String name, int age) {
        if (type.equalsIgnoreCase("regular")) {
            return new RegularCustomer(name, age);
        } else if (type.equalsIgnoreCase("senior")) {
            return new SeniorCitizenCustomer(name, age);
        } else if (type.equalsIgnoreCase("first")) {
            return new FirstTimeCustomer(name, age);
        } else {
            throw new IllegalArgumentException("Invalid customer type");
        }
    }
}
