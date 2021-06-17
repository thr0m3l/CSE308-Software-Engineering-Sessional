package Device.Builder;

import Device.Microcontroller.Microcontroller;

public interface AbstractDeviceBuilder {

    Microcontroller buildMicrocontroller();

    void addDisplay();

    void addIdentification();

    void addController();

    void addStorage();

    Microcontroller buildAll();

}
