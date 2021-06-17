package Pizza.Decorator;

import Pizza.Decorator.PizzaDecorator;
import Pizza.Pizza;

public class Coke extends PizzaDecorator {

    public Coke (Pizza pizza)
    {
        super.pizza = pizza;
        System.out.println("Added coke");
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice() + 40.0;
    }
}
