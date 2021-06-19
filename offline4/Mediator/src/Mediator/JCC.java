package Mediator;

import Component.Organization;
import Request.Request;

import java.util.ArrayList;

public class JCC implements Mediator{

    ArrayList<Organization> organizations = new ArrayList<>();

    @Override
    public void handleRequest(Organization requestSource, String service) {
        Organization serviceProvider = getOrganization(service);
        Request request = new Request(requestSource, serviceProvider);
        serviceProvider.addRequest(request);
    }

    @Override
    public void handleService(Request request) {
        request.getSource().receiveService(request);
    }

    @Override
    public void init(ArrayList<Organization> organizationList) {
        this.organizations = organizationList;
        for (Organization org : this.organizations){
            org.setMediator(this);
        }
        System.out.println("All four services are initiated through mediator");
    }

    public Organization getOrganization(String service){
        for (Organization org : organizations){
            if (org.getService().equalsIgnoreCase(service)){
                return org;
            }
        }
        return null;
    }
}
