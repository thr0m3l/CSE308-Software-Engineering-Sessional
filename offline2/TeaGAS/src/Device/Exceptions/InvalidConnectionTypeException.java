package Device.Exceptions;

public class InvalidConnectionTypeException extends Exception{
    public InvalidConnectionTypeException() {
        super("Connection type is not supported for this type of Microcontroller");
    }
}
