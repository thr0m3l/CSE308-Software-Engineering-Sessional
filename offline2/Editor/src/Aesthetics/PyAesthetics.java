package Aesthetics;

public class PyAesthetics implements Aesthetics{
    @Override
    public void setFont() {
        System.out.println("Font: " + Font.Consolas);
    }

    @Override
    public void setStyle() {
        System.out.println("Style: Normal");
    }

    @Override
    public void setColor() {
        System.out.println("Color: Normal");
    }
}
