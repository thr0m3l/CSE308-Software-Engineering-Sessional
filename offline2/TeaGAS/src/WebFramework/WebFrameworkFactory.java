package WebFramework;

public class WebFrameworkFactory {
    public WebFrameworkFactory(){

    }

    public WebFramework getFramework(String name){
        if (name.equalsIgnoreCase("Django")){
            return new Django();
        }
        else if (name.equalsIgnoreCase("Laravel")){
            return new Laravel();
        }
        else if (name.equalsIgnoreCase("Spring")){
            return new Spring();
        }
        return null;
    }
}
