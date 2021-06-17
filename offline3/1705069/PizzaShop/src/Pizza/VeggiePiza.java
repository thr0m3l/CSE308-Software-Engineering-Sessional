package Pizza;

public class VeggiePiza implements Pizza{
    public VeggiePiza(){
        System.out.println("Added veggie pizza");
    }

    public Double getPrice() {
        return 300.0;
    }
}
