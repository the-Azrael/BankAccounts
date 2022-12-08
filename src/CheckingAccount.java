public class CheckingAccount extends Account {

    public CheckingAccount(String number, double balance) {
        super(number, balance);
    }

    @Override
    public String getType() {
        return "Рассчетный счет";
    }

    @Override
    public void pay(double sum) {
        if(check(sum)) {
            this.balance -= sum;
            showInfo();
        } else {
            System.out.println("Недостаточно средств");
        }
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
