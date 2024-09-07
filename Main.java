public class Main {
    public static void main(String[] args) {
        DebitAccount dbt1 = new DebitAccount();
        DebitAccount dbt2 = new DebitAccount(25);
        DebitAccount dbt3 = new DebitAccount(25);

        dbt1.deposit(100);
        dbt1.withdraw(25);
        System.out.println(dbt1.toString());
    }
}