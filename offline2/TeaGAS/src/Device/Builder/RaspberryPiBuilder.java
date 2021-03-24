package Device.Builder;

import Device.Enumerations.Controller;
import Device.Enumerations.Display;
import Device.Enumerations.Identification;
import Device.Enumerations.Storage;
import Device.Microcontroller.Microcontroller;
import Device.Microcontroller.RaspberryPi;

public class RaspberryPiBuilder implements AbstractDeviceBuilder{

    private Microcontroller microcontroller;

    @Override
    public Microcontroller buildMicrocontroller() {
        return new RaspberryPi();
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
    public void addStorage() {
        this.microcontroller.setStorage(Storage.Internal);
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
