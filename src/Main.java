public class Main {
    private static Account savingsAccount;
    private static Account creditAccount;
    private static Account checkingAccount;

    private static final double INIT_SAVING_ACCOUNT = 10_000;
    private static final double INIT_CREDIT_ACCOUNT = 60_000;
    private static final double INIT_CHECKING_ACCOUNT = 20_000;
    private static final double ZARPALTA = 65_000;
    private static final double KVARPLATA = 3_500;
    private static final double MIN_CREDIT_PAY = 4_000;
    private static final double IPHONE_PRICE = 120_000;

    public static void showInfo() {
        System.out.println("\n--- Состояние ваших счетов ---");
        savingsAccount.showInfo();
        creditAccount.showInfo();
        checkingAccount.showInfo();
    }

    public static void main(String[] args) {
        savingsAccount = new SavingsAccount("1234567890", INIT_SAVING_ACCOUNT);
        creditAccount = new CreditAccount("1234567891", INIT_CREDIT_ACCOUNT);
        checkingAccount = new CheckingAccount("1234567892", INIT_CHECKING_ACCOUNT);
        showInfo();

        System.out.println("\nУра! Зарплата!");
        checkingAccount.update(ZARPALTA);

        System.out.println("\nПлатим за квартиру");
        checkingAccount.pay(KVARPLATA);

        System.out.println("\nПлатим за кредит");
        checkingAccount.transfer(MIN_CREDIT_PAY, creditAccount);

        System.out.println("\nОтложим на накопления");
        checkingAccount.transfer(5_000, savingsAccount);

        System.out.println("\nБлин хочу последнй iPhone");
        checkingAccount.pay(IPHONE_PRICE);
        savingsAccount.pay(IPHONE_PRICE);
        creditAccount.pay(IPHONE_PRICE);

        System.out.println("\nСтарый продам");
        checkingAccount.update(30_000);

        System.out.println("Все на погашение кредита!");
        savingsAccount.transfer(savingsAccount.balance, creditAccount);
        checkingAccount.transfer(checkingAccount.balance, creditAccount);

        showInfo();
    }
}
