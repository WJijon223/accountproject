public class LoanAccount extends Account {
    // interest rates will be monthly and balance will be amount owed
    private double interestRate;
    private double interestOwed;
    private boolean paymentMade;
    private double lastPayment;

    // constructor (interest rate and balance will be parameters)
    public LoanAccount(double amount, double interestRate) {
        super(amount);
        this.interestRate = interestRate;
        this.paymentMade = false;
    }

    // getters and setters
    public double getInterestedOwed() {
        return this.interestOwed;
    }

    public double getLastPayment() {
        return this.lastPayment;
    }

    public void setInterestOwed() {
        this.interestOwed = this.interestRate * getBalance();
    }

    public void setPaymentStatus() {
        this.paymentMade = true;
    }

    public void setLastPayment(double amount) {
        this.lastPayment = amount;
    }

    /*
     * override deposit method
     * (this will serve as money paid towards outstanding balance since a loan
     * account doesn't store money)
     */
    @Override
    public boolean deposit(double amount) {
        setInterestOwed();
        if (amount <= getInterestedOwed()) {
            System.out.println("Amount must be greater than interest owed. You owe $"
                    + getInterestedOwed() + " in interest fees");
            return false;
        }
        if (!this.paymentMade) {
            setPaymentStatus();
            setLastPayment(amount);
        } else {
            System.out.println("Your last payment was $" + getLastPayment());
        }

        System.out.println("You owe a total of $" + (getBalance() + getInterestedOwed()));
        System.out.println("$" + getInterestedOwed() + " will go towards your interest balance and $"
                + (amount - getInterestedOwed()) + " will go to your remaining balance");
        setBalance(getBalance() + getInterestedOwed() - amount);
        setLastPayment(amount);
        setInterestOwed();
        System.out.println("Success! You now owe $" + (getBalance() + getInterestedOwed()) + " including fees");
        return true;
    }

    // override withdraw method (this will return false, as a loan account doesn't
    // store money)
    @Override
    public boolean withdraw(double amount) {
        System.out.println("Unable to withdraw " + amount + " with this account type");
        return false;
    }
}
