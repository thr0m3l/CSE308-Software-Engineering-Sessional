package Aesthetics;

public class CppAesthetics implements Aesthetics {
    @Override
    public void setFont() {
        System.out.println("Font: " + Font.Monaco);
    }

    @Override
    public void setStyle() {
        System.out.println("Style: Normal" );
    }

    @Override
    public void setColor() {
        System.out.println("Color: Blue");
    }
}
