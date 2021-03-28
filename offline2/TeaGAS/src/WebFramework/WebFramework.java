package WebFramework;

public abstract class WebFramework {
    String name;
    String language;

    WebFramework (String name, String language){
        this.name = name;
        this.language = language;
    }

    @Override
    public String toString() {
        return "WebFramework{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
