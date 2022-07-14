package udemy.section08p2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != null) {
            return false;
        }
        this.branches.add(new Branch(branchName));
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branchFound = findBranch(branchName); // if branch exists, we can add customers
        if (branchFound != null) {
            return branchFound.newCustomer(customerName, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branchFound = findBranch(branchName);
        if (branchFound != null) {
            return branchFound.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getName().equals(branchName)) {
                return this.branches.get(i);
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branchFound = findBranch(branchName);
        if (branchFound != null) {
            System.out.println("Customer details for branch " + branchFound.getName());
            ArrayList<Customer> customers = branchFound.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                System.out.printf("Customer: %s[%d]\n", customers.get(i).getName(), (i + 1));
                if (printTransactions) {
                    ArrayList<Double> transactions = customers.get(i).getTransactions();
                    System.out.println("Transactions");
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.printf("[%d]  Amount %.2f\n", (j + 1), transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
