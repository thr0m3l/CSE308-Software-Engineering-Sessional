package Bank;

public class Loan {
    public Double amount;
    public String name;

    public Loan(Double amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Loan))
            return false;
        Loan o = (Loan) obj;
        return o.amount == this.amount && o.name == this.name;
    }
}
