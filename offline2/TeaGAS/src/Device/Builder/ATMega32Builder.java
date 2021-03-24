package Device.Builder;

import Device.Enumerations.Storage;
import Device.Microcontroller.ATMega32;
import Device.Enumerations.Controller;
import Device.Enumerations.Display;
import Device.Enumerations.Identification;
import Device.Microcontroller.Microcontroller;

public class ATMega32Builder implements AbstractDeviceBuilder{

    private Microcontroller microcontroller;

    @Override
    public Microcontroller buildMicrocontroller() {
        return new ATMega32();
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
    public void addStorage() {
        this.microcontroller.setStorage(Storage.SDCard);
    }

    @Override
    public Microcontroller buildAll() {
        this.microcontroller = buildMicrocontroller();

        addDisplay();
        addController();
        addIdentification();
        addStorage();

        System.out.println(microcontroller);
        return this.microcontroller;


    }
}
