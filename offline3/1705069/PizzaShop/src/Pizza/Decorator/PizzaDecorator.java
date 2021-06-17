package Pizza.Decorator;

import Pizza.Pizza;

public abstract class PizzaDecorator implements Pizza {
    Pizza pizza;

    @Override
    public abstract Double getPrice();


}
