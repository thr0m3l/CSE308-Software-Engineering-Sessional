package Device;

import Device.Builder.ATMega32Builder;
import Device.Builder.AbstractDeviceBuilder;
import Device.Builder.ArduinoMegaBuilder;
import Device.Builder.RaspberryPiBuilder;
import Device.Microcontroller.Microcontroller;

public class DeviceBuilderDirector {

    private AbstractDeviceBuilder deviceBuilder;

    public DeviceBuilderDirector(String type) {
        if(type.equalsIgnoreCase("ATMega32")){
            deviceBuilder = new ATMega32Builder();
        } else if (type.equalsIgnoreCase("Arduino")){
            deviceBuilder = new ArduinoMegaBuilder();
        } else if (type.equalsIgnoreCase("RaspberryPi")) {
            deviceBuilder = new RaspberryPiBuilder();
        }
    }

    public Microcontroller buildAll(){

        Microcontroller microcontroller = deviceBuilder.buildAll();
        return microcontroller;

    }


}
