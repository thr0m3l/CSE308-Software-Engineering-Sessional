package Component;

import Mediator.Mediator;
import Request.Request;
import java.util.ArrayDeque;
import java.util.Queue;

public abstract class Organization implements Colleague{
    private Queue<Request> requests = new ArrayDeque<>();
    private Mediator mediator = null;
    private String name = "";
    private String service;

    public Organization(String name, String service) {
        this.name = name;
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void serveRequest() {
        Request servedRequest = requests.poll();
        if (servedRequest != null) {
            servedRequest.setServed(true);
            mediator.handleService(servedRequest);
        } else {
            System.err.println("No requests left");
        }

    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void addRequest(Request request) {
        requests.add(request);
    }

    @Override
    public void sendRequest(String service) {
        mediator.handleRequest(this, service);
        System.out.println(name + " requests for " + service);
    }

    @Override
    public void receiveService(Request request) {
        if (request.isServed()){
            String requestSrc = request.getSource().getName();
            String serviceProvider = request.getDest().getName();
            System.out.println(serviceProvider + " serves the request of " + requestSrc);
        } else {
            System.err.println("Request was not served properly");
        }
    }
}
