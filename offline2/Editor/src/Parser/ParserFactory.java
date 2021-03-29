package Parser;

public class ParserFactory {
    private Parser parser;

    public ParserFactory(String name) {
        setParser(name);
    }

    public void setParser(String name){
        if (name.equalsIgnoreCase("c")){
            parser = new CParser();
        } else if (name.equalsIgnoreCase("cpp")){
            parser = new CppParser();
        } else if (name.equalsIgnoreCase("python")){
            parser = new PyParser();
        }
    }

    public Parser getParser(){
        return parser;
    }

}
