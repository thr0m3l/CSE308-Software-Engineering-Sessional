package Message;

import Client.Observer;
import Client.User;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 2L;
    public String message = "";
    public Observer user;

    public Observer getUser() {
        return user;
    }

    public void setUser(Observer user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
