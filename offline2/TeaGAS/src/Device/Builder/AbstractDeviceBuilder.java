package Device.Builder;

import Device.Enumerations.Connection;
import Device.Exceptions.InvalidConnectionTypeException;
import Device.Microcontroller;

public interface AbstractDeviceBuilder {

    Microcontroller buildMicrocontroller();

    void buildConnection() throws InvalidConnectionTypeException;

    void addDisplay();

    void addIdentification();

    void addController();

    Microcontroller buildAll(Connection connection);

}
