public interface TaxCalculator {
    public double calculateSalesTax(double amount);
    public double calculateVat(double amount);
}



public class MauriTaxAdapter implements TaxCalculator {
    private MauriTax mauriTax;

    public MauriTaxAdapter(MauriTax mauriTax) {
        this.mauriTax = mauriTax;
    }

    public double calculateSalesTax(double amount) {
        // call the 'calculateSalesTaxMauritius' method of 'MauriTax'
        double tax = mauriTax.calculateSalesTaxMauritius(amount);
        // convert the result to the expected format
        return tax / 100.0;
    }

    public double calculateVat(double amount) {
        // call the 'calculateVatMauritius' method of 'MauriTax'
        double vat = mauriTax.calculateVatMauritius(amount);
        // convert the result to the expected format
        return vat / 100.0;
    }
}


// create an instance of the 'MauriTax' system
MauriTax mauriTax = new MauriTax();

// create an instance of the 'MauriTaxAdapter' and pass the 'MauriTax' instance to it
TaxCalculator taxCalculator = new MauriTaxAdapter(mauriTax);

// use the 'TaxCalculator' interface to perform tax calculations
double salesTax = taxCalculator.calculateSalesTax(100.0);
double vat = taxCalculator.calculateVat(100.0);
