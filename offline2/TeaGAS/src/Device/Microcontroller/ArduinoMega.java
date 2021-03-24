package Device.Microcontroller;

import Device.Enumerations.Connection;
import Device.Exceptions.InvalidConnectionTypeException;

public class ArduinoMega extends Microcontroller{

    public ArduinoMega() {
        super.setType("Arduino Mega");
    }

    @Override
    public void setConnection(Connection connection) throws InvalidConnectionTypeException {
        if(connection == Connection.WIFI || connection == Connection.GSM){
            super.setConnection(connection);
        } else throw new InvalidConnectionTypeException();
    }


}
