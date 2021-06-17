package Device.Microcontroller;

import Device.Enumerations.*;
import Device.Exceptions.InvalidConnectionTypeException;

public abstract class Microcontroller {

    private String type;
    private Connection connection;
    private Controller controller;
    private Identification identification;
    private Storage storage;
    private Display display;
    private WeightMeasure weightMeasure;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) throws InvalidConnectionTypeException {
        this.connection = connection;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public WeightMeasure getWeightMeasure() {
        return weightMeasure;
    }

    public void setWeightMeasure(WeightMeasure weightMeasure) {
        this.weightMeasure = weightMeasure;
    }

    @Override
    public String toString() {
        return "Microcontroller{" +
                "type='" + type + '\'' +
                ", connection=" + connection +
                ", controller=" + controller +
                ", identification=" + identification +
                ", storage=" + storage +
                ", display=" + display +
                ", weightMeasure=" + weightMeasure +
                '}';
    }


}
