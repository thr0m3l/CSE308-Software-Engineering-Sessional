package Device.Builder;

import Device.ArduinoMega;
import Device.Enumerations.Connection;
import Device.Enumerations.Controller;
import Device.Enumerations.Display;
import Device.Enumerations.Identification;
import Device.Exceptions.InvalidConnectionTypeException;
import Device.Microcontroller;

public class ArduinoMegaBuilder implements AbstractDeviceBuilder{
    private Microcontroller microcontroller;
    private Connection connection;

    @Override
    public Microcontroller buildMicrocontroller() {
        return new ArduinoMega();
    }

    @Override
    public void buildConnection() throws InvalidConnectionTypeException {
        this.microcontroller.setConnection(connection);
    }

    @Override
    public void addDisplay() {
        this.microcontroller.setDisplay(Display.LED);
    }

    @Override
    public void addIdentification() {
        this.microcontroller.setIdentification(Identification.RFID);
    }

    @Override
    public void addController() {
        this.microcontroller.setController(Controller.Buttons);
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
