public class DebitAccount extends Account {

    // Using the super keyword
    DebitAccount() {
        super();
    }

    DebitAccount(double promo) {
        setBalance(promo);
    }

    // Method overriding from Account class
    @Override
    public boolean deposit(double _amount) {
        if (_amount <= 0) {
            System.out.println("Invalid Amount. Value is less than or equal to zero");
            return false;
        }

        // Need to use the setter/getters
        setBalance(getBalance() + _amount);
        return true;
    }

    @Override
    public boolean withdraw(double _amount) {
        if (_amount > getBalance()) {
            System.out.println("You have no money my friend");
            return false;
        }

        if (_amount <= 0) {
            System.out.println("Really?");
            return false;
        }

        // using the getter
        setBalance(getBalance() - _amount);

        return false;
    }

    @Override
    public String toString() {
        String content = "The current balance = " + getBalance();
        return content;
    }
}