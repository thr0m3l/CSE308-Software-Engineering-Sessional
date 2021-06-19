package Request;

import Component.Organization;

public class Request {
    private Organization source;
    private Organization dest;
    private boolean isServed = false;

    public Request(Organization source, Organization dest) {
        this.source = source;
        this.dest = dest;
        isServed = false;
    }

    public Organization getSource() {
        return source;
    }

    public void setSource(Organization source) {
        this.source = source;
    }

    public Organization getDest() {
        return dest;
    }

    public void setDest(Organization dest) {
        this.dest = dest;
    }

    public boolean isServed() {
        return isServed;
    }

    public void setServed(boolean served) {
        isServed = served;
    }
}
