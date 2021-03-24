package Device.Builder;

import Device.ATMega32;
import Device.Enumerations.Connection;
import Device.Enumerations.WeightMeasure;
import Device.Microcontroller;

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

    public Microcontroller buildAll(String connection, String weightMeasure){
        Connection conn = null;
        WeightMeasure wm;

        if (connection.equalsIgnoreCase("GSM")){
            conn = Connection.GSM;
        } else if (connection.equalsIgnoreCase("WIFI")){
            conn = Connection.WIFI;
        } else {
            conn = Connection.Ethernet;
        }

        if (weightMeasure.equalsIgnoreCase("LoadSensor")){
            wm = WeightMeasure.LoadSensor;
        } else if (weightMeasure.equalsIgnoreCase("WeightModule")){
            wm = WeightMeasure.WeightModule;
        }

        Microcontroller microcontroller = deviceBuilder.buildAll(conn);
        return microcontroller;

    }


}
