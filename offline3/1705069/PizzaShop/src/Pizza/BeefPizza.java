package Pizza;

public class BeefPizza implements Pizza{
    public BeefPizza() {
        System.out.println("Added Beef pizza");
    }

    @Override
    public Double getPrice(){
        return 400.0;
    }

}
