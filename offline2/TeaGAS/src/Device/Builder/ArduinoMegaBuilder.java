package Device.Builder;

import Device.Enumerations.Storage;
import Device.Microcontroller.ArduinoMega;
import Device.Enumerations.Controller;
import Device.Enumerations.Display;
import Device.Enumerations.Identification;
import Device.Microcontroller.Microcontroller;

public class ArduinoMegaBuilder implements AbstractDeviceBuilder{
    private Microcontroller microcontroller;

    @Override
    public Microcontroller buildMicrocontroller() {
        return new ArduinoMega();
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

        return this.microcontroller;
    }
}
