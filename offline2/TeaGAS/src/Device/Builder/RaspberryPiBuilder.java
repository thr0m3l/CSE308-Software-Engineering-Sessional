package Device.Builder;

import Device.Enumerations.Connection;
import Device.Enumerations.Controller;
import Device.Enumerations.Display;
import Device.Enumerations.Identification;
import Device.Exceptions.InvalidConnectionTypeException;
import Device.Microcontroller;
import Device.RaspberryPi;

public class RaspberryPiBuilder implements AbstractDeviceBuilder{

    private Microcontroller microcontroller;
    private Connection connection;

    @Override
    public Microcontroller buildMicrocontroller() {
        return new RaspberryPi();
    }

    @Override
    public void buildConnection() throws InvalidConnectionTypeException {
        this.microcontroller.setConnection(connection);
    }

    @Override
    public void addDisplay() {
        this.microcontroller.setDisplay(Display.TouchScreen);
    }

    @Override
    public void addIdentification() {
        this.microcontroller.setIdentification(Identification.NFC);
    }

    @Override
    public void addController() {
        this.microcontroller.setController(Controller.TouchScreen);
    }

    @Override
    public Microcontroller buildAll(Connection connection) {

        this.connection = connection;

        this.microcontroller = buildMicrocontroller();
        try {
            buildConnection();
        } catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
        addDisplay();
        addController();
        addIdentification();

        System.out.println(microcontroller);
        return this.microcontroller;
    }
}
