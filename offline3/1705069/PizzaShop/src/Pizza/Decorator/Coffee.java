package Pizza.Decorator;

import Pizza.Decorator.PizzaDecorator;
import Pizza.Pizza;

public class Coffee extends PizzaDecorator {
    public Coffee (Pizza pizza)
    {
        super.pizza = pizza;
        System.out.println("Added coffee");
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice() + 80.0;
    }
}
