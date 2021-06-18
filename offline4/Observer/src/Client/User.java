package Client;
import Server.*;

import java.io.Serializable;

public class User implements Observer, Serializable {
    private Observable observable;
    private static final long serialVersionUID = 3L;

    @Override
    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Server.Server.Stock updated " + stock);
    }
}
