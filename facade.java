public class DecathlonPOS {
    private RuleEngine ruleEngine;

    public DecathlonPOS() {
        // Instantiate the Sport 2000 rule engine as a 3rd-party subsystem
        this.ruleEngine = new Sport2000RuleEngine();
    }

    public void makeNewSale(Sale sale) {
        // Apply the set of rules defined by the rule engine to the sale
        boolean isValidSale = ruleEngine.validateSale(sale);

        // If the sale is valid, process the payment
        if (isValidSale) {
            Payment payment = sale.getPayment();
            processPayment(payment);
        } else {
            System.out.println("Sale is invalid due to rule violations.");
        }
    }

    private void processPayment(Payment payment) {
        // Handle payment processing logic here
    }
}

public interface RuleEngine {
    boolean validateSale(Sale sale);
}

public class Sport2000RuleEngine implements RuleEngine {
    @Override
    public boolean validateSale(Sale sale) {
        // Apply the specific set of rules defined by the Sport 2000 rule engine
        // to the sale object and return true if the sale is valid, false otherwise.
        return true;
    }
}

public class Sale {
    private List<Item> items;
    private Payment payment;

    // getters and setters omitted for brevity
}

public class Item {
    private String name;
    private double price;

    // getters and setters omitted for brevity
}

public class Payment {
    private double amount;
    private boolean isGiftCertificate;

    // getters and setters omitted for brevity
}
