public class Main {
    public static void main(String[] args) {
        DebitAccount dbt1 = new DebitAccount();
        DebitAccount dbt2 = new DebitAccount(25);
        DebitAccount dbt3 = new DebitAccount(25);
        CreditAccount dbt4 = new CreditAccount(500);
        LoanAccount dbt5 = new LoanAccount(500, .15);

        // dbt1.deposit(100);
        // dbt1.withdraw(25);
        // System.out.println(dbt1.toString());

        // testing out the credit card class
        dbt4.deposit(100);
        dbt4.withdraw(60);
        dbt4.withdraw(30);
        System.out.println(dbt4.getBalance());
        System.out.println(dbt4.getUsedLimit());

        // testing out the loan account class
        dbt5.deposit(100);
        System.out.println(dbt5.getBalance());
        dbt5.deposit(80);
        System.out.println(dbt5.getBalance());
    }
}