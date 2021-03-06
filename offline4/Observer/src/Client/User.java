package Client;
import Message.Message;
import Server.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Observer, Serializable {
    private Observable observable;
    private static final long serialVersionUID = 3L;
    private boolean isAdmin = false;

    @Override
    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update(Stock stock) {
        sendMessage("Stock updated " + stock);
    }

    public void sendMessage(String msg){
        Message message = new Message();
        message.setMessage(msg);
        ObjectOutputStream outputStream  = Server.getStream(this);
        try {
            outputStream.writeObject(message);
        } catch (IOException e) {
            System.err.println("Error sending update to user");
        }
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
