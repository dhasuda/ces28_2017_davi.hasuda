package lab1;

public class Money implements MoneyInterface {
    private int _amount;
    private Currency _currency;

    public Money(Currency currency) {
        setCurrency(currency);

    }

    public MoneyInterface add(Money m) {
        Money money = new Money(m.getCurrency());
        money.setAmount(this.getAmount() + m.getAmount());
        money.setCurrency(this.getCurrency());
        return money;
    }

    public int getAmount()
    {
        return _amount;
    }

    public void setAmount(int amount)
    {
        this._amount = amount;
    }

    public Currency getCurrency() { return _currency; }

    public void setCurrency(Currency currency)
    {
        this._currency = currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            Money newMoney = (Money)obj;
            if (newMoney.getCurrency().equals(this.getCurrency()) && newMoney.getAmount() == this.getAmount()) {
                return true;
            }
        }
        return false;
    }
}