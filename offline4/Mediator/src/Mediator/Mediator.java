package Mediator;

import Component.Organization;
import Request.Request;

import java.util.ArrayList;

public interface Mediator {
    void handleRequest(Organization requestSource, String serviceProvider);
    void handleService(Request request);
    void init(ArrayList<Organization> organizationList);
}
