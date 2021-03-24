package Device;

import Device.Enumerations.*;
import Device.Exceptions.InvalidConnectionTypeException;

public class ATMega32 extends Microcontroller{
    public ATMega32() {
        super.setType("ATMega32");
        super.setController(Controller.Buttons);
        super.setDisplay(Display.LCD);
        super.setStorage(Storage.SDCard);
        super.setIdentification(Identification.RFID);
    }

    @Override
    public void setConnection(Connection connection) throws InvalidConnectionTypeException {
        if(connection == Connection.WIFI || connection == Connection.GSM){
            super.setConnection(connection);
        } else throw new InvalidConnectionTypeException();
    }
}
