import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Observer interface
interface Observer {
    void update(String country, double discount);
}

// Subject interface
interface Subject {
    void registerObserver(String country, Observer observer);
    void removeObserver(String country, Observer observer);
    void notifyObservers(String country, double discount);
}

// Concrete subject class
class DecathlonStore implements Subject {
    private Map<String, List<Observer>> observers;
    private Map<String, Double> discounts;

    public DecathlonStore() {
        this.observers = new HashMap<>();
        this.discounts = new HashMap<>();
    }

    @Override
    public void registerObserver(String country, Observer observer) {
        List<Observer> countryObservers = observers.getOrDefault(country, new ArrayList<>());
        countryObservers.add(observer);
        observers.put(country, countryObservers);
    }

    @Override
    public void removeObserver(String country, Observer observer) {
        List<Observer> countryObservers = observers.getOrDefault(country, new ArrayList<>());
        countryObservers.remove(observer);
        observers.put(country, countryObservers);
    }

    @Override
    public void notifyObservers(String country, double discount) {
        List<Observer> countryObservers = observers.getOrDefault(country, new ArrayList<>());
        for (Observer observer : countryObservers) {
            observer.update(country, discount);
        }
    }

    public void setDiscount(String country, double discount) {
        this.discounts.put(country, discount);
        notifyObservers(country, discount);
    }

    public double getDiscount(String country) {
        return discounts.getOrDefault(country, 0.0);
    }
}

// Concrete observer class
class Customer implements Observer {
    private String name;
    private String country;

    public Customer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public void update(String country, double discount) {
        if (this.country.equals(country)) {
            System.out.println(name + ", the discount for your country has been updated to " + discount + "%.");
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        DecathlonStore store = new DecathlonStore();

        // Create customers in different countries
        Customer c1 = new Customer("John", "USA");
        Customer c2 = new Customer("Jane", "USA");
        Customer c3 = new Customer("Bob", "Canada");
        Customer c4 = new Customer("Alice", "Canada");

        // Register customers as observers for their respective countries
        store.registerObserver("USA", c1);
        store.registerObserver("USA", c2);
        store.registerObserver("Canada", c3);
        store.registerObserver("Canada", c4);

        // Set discounts for different countries
        store.setDiscount("USA", 20.0);
        store.setDiscount("Canada", 15.0);
    }
}
