package Editor;

public class Editor {
    private static Editor editor = null;
    private static FactoryDirector director = null;

    private Editor(){

    }

    public static synchronized Editor getEditor(){
        if(editor == null){
            editor = new Editor();
            System.out.println("Editor opened");
        } else System.out.println("Editor is already open");

        return editor;
    }

    public void setLanguage(String name){
        if (director == null){
            director = new FactoryDirector(name);
        }

        director.setAesthetics(name);
        director.setParser(name);
        director.apply();
    }


}
