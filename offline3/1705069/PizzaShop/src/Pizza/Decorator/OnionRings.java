package Pizza.Decorator;

import Pizza.Pizza;

public class OnionRings extends PizzaDecorator{
    public OnionRings (Pizza pizza){
        super.pizza = pizza;
        System.out.println("Added onion rings");
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice() + 100.0;
    }

}
