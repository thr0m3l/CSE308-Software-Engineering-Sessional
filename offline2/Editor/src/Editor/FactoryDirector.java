package Editor;

import Aesthetics.*;
import Parser.*;

public class FactoryDirector {
    private Aesthetics aesthetics;
    private Parser parser;

    public FactoryDirector(String language){

    }

    public void setAesthetics(String language){
        AestheticsFactory factory = new AestheticsFactory(language);
        aesthetics = factory.getAesthetics();
    }

    public void setParser(String language){
        ParserFactory factory = new ParserFactory(language);
        parser = factory.getParser();
    }

    public void apply(){
        aesthetics.setStyle();
        aesthetics.setFont();
        aesthetics.setColor();
        parser.parse();
    }
}
