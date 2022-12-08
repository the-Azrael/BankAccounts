public abstract class Account {
    protected double balance = 0;
    protected String number = "";
    protected String type = "";

    public abstract String getType();
    public abstract void pay(double sum);
    public abstract void transfer(double sum, Account account);
    public abstract boolean update(double sum);
    public abstract boolean check(double sum);

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getNumber() {
        return this.number;
    }

    public void showInfo() {
        System.out.println("На счете: " + this.number + " [" +this.getType() + "] " + " : " + this.balance + " рублей");
    }
}
