package Component;

import Mediator.Mediator;
import Request.Request;

public interface Colleague {
    public void serveRequest();
    public void setMediator(Mediator mediator);
    public void addRequest(Request request);
    public void sendRequest(String service);
    public void receiveService(Request request);
}
