package Device.Builder;

import Device.ATMega32;
import Device.Enumerations.Connection;
import Device.Enumerations.Controller;
import Device.Enumerations.Display;
import Device.Enumerations.Identification;
import Device.Exceptions.InvalidConnectionTypeException;
import Device.Microcontroller;

public class ATMega32Builder implements AbstractDeviceBuilder{

    private Microcontroller microcontroller;
    private Connection connection;

    @Override
    public Microcontroller buildMicrocontroller() {
        return new ATMega32();
    }

    @Override
    public void buildConnection() throws InvalidConnectionTypeException {
        this.microcontroller.setConnection(this.connection);
    }

    @Override
    public void addDisplay() {
        this.microcontroller.setDisplay(Display.LCD);
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
        this.microcontroller = buildMicrocontroller();

        this.connection = connection;


        try {
            buildConnection();
        } catch (InvalidConnectionTypeException e) {
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
