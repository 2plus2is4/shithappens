package eg.edu.alexu.csd.oop.draw.cs04_06;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;
import javafx.scene.paint.Color;

public class MyShape implements eg.edu.alexu.csd.oop.draw.Shape {
    public void setPosition(Point position) {
        this.position = new Point(0,0);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFillcolor(Color fillcolor) {
        this.fillcolor = fillcolor;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private Point position=new Point(0,0);
    private Map<String, Double> properties = new HashMap<>();
    private Color color=new Color(0,0,0,1);


    public int getIndex() {
        return index;
    }

    private Color fillcolor=new Color(0,0,0,0);;
    private int index;

    public MyShape(Point position, Map<String, Double> properties, Color color, Color fillcolor) {
        this.position = position;
        this.properties = properties;
        this.color = color;
        this.fillcolor = fillcolor;
    }

    public MyShape() {
    }

    @Override
    public void setPosition(Object position) {
        this.position = ((Point) position);
    }

    @Override
    public Object getPosition() {
        return this.position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return this.properties;
    }

    @Override
    public void setColor(Object color) {
        this.color = ((javafx.scene.paint.Color) color);
    }

    @Override
    public Object getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Object color) {
        this.fillcolor = ((Color)color);
    }

    @Override
    public Object getFillColor() {
        return this.fillcolor;
    }

    @Override
    public void draw(Object canvas) {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyShape c = new MyShape();
        c.setColor(this.getColor());
        c.setFillColor(this.getFillColor());
        Point p = new Point(((Point) this.getPosition()).x,((Point) this.getPosition()).y);
        c.setPosition(p);
        Map<String,Double> temp = new HashMap<>();
        for(Map.Entry<String,Double> s:this.getProperties().entrySet()){
            temp.put(s.getKey(),s.getValue());
        }
        c.setProperties(temp);
        return c;
    }

    public void clone(Shape cs) {
    }
}
