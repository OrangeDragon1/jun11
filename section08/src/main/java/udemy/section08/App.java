package udemy.section08;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank("Woori Bank");

        bank.addBranch("Seoul");
        bank.addCustomer("Seoul", "Rose", 30122.3);
        bank.addCustomer("Seoul", "Jennie", 29304.35);
        bank.addCustomer("Seoul", "Jisoo", 30923.33);

        bank.addBranch("Bangkok");
        bank.addCustomer("Bangkok", "Lisa", 30022.11);

        bank.addCustomerTransaction("Seoul", "Jisoo", 230.33);
        bank.addCustomerTransaction("Seoul", "Jisoo", 123.67);
        bank.addCustomerTransaction("Seoul", "Jisoo", 118.29);

        bank.listCustomers("Seoul", false);
    }
}
