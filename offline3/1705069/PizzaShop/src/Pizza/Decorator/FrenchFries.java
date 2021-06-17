package Pizza.Decorator;

import Pizza.Pizza;

public class FrenchFries extends PizzaDecorator{
    public FrenchFries (Pizza pizza){
        super.pizza = pizza;
        System.out.println("Added french fries");
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice() + 100.0;
    }
}
