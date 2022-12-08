public class CreditAccount extends Account {

    public CreditAccount(String number, double balance) {
        super(number, -balance);
    }

    @Override
    public String getType() {
        return "Кредитный счет";
    }

    @Override
    public void pay(double sum) {
        this.balance -= sum;
        showInfo();
    }

    @Override
    public void transfer(double sum, Account account) {
        if (check(sum) && account.update(sum)) {
            this.balance -= sum;
        } else {
            System.out.println("Невозможно выполнить операцию");
        }
        showInfo();
    }

    @Override
    public boolean update(double sum) {
        if (check(sum)) {
            this.balance += sum;
            showInfo();
            return true;
        } else {
            System.out.println("Невозможно пополнить счет");
            return false;
        }
    }

    @Override
    public boolean check(double sum) {
        return (Math.abs(this.balance) >= sum);
    }
}
