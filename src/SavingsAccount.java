public class SavingsAccount extends Account{

    public SavingsAccount(String number, double balance) {
        super(number, balance);
    }

    @Override
    public String getType() {
        return "Сберегательный счет";
    }

    @Override
    public void pay(double sum) {
        System.out.println("С данного счета оплата невозможна");
    }

    @Override
    public void transfer(double sum, Account account) {
        if (check(sum) && account.update(sum)) {
            this.balance -= sum;
            showInfo();
        } else {
            System.out.println("Невозможно выполнить операцию");
        }
    }

    @Override
    public boolean update(double sum) {
        this.balance += sum;
        showInfo();
        return true;
    }

    @Override
    public boolean check(double sum) {
        return (this.balance >= sum);
    }
}
