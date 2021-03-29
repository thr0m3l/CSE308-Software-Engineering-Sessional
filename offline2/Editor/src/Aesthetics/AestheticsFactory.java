package Aesthetics;

public class AestheticsFactory {
    private Aesthetics aesthetics = null;

    public AestheticsFactory(String language) {
        setAesthetics(language);
    }

    public void setAesthetics(String language){
        if (language.equalsIgnoreCase("cpp")){
            this.aesthetics = new CppAesthetics();
        } else if(language.equalsIgnoreCase("c")){
            this.aesthetics = new CAesthetics();
        } else if(language.equalsIgnoreCase("python")){
            this.aesthetics = new PyAesthetics();
        }
    }

    public Aesthetics getAesthetics(){
        return aesthetics;
    }
}
