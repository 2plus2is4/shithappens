package eg.edu.alexu.csd.oop.draw.cs04_06;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Rectangle extends MyShape{
    private Point upleft, downright;

    public void setUpleft(Point upleft) {
        this.upleft = upleft;
        this.getProperties().put("upleftx",(double)upleft.x);
        this.getProperties().put("uplefty",(double)upleft.y);
    }

    public void setDownright(Point downright) {
        this.downright = downright;
        this.getProperties().put("downrightx",(double)downright.x);
        this.getProperties().put("downrighty",(double)downright.y);
    }

    public Rectangle(Point a, Point b ){
        this.upleft = a;
        this.downright = b;
        this.setPosition(new Point(upleft.x,upleft.y));
        Map<String,Double> temp=new HashMap<>();
        temp.put("upleftx",(double)upleft.x);
        temp.put("uplefty",(double)upleft.y);
        temp.put("downrightx",(double)downright.x);
        temp.put("downrighty",(double)downright.y);
        temp.put("t3x",null);
        temp.put("t3y",null);
        temp.put("shapeNo",4.0);
        this.setProperties(temp);
    }

    public Rectangle() {
        this.upleft =new Point(0,0);
        this.downright = new Point(0,0);
        this.setPosition(new Point(0,0));
        Map<String,Double>temp=new HashMap<>();
        temp.put("upleftx",(double)upleft.x);
        temp.put("uplefty",(double)upleft.y);
        temp.put("downrightx",(double)downright.x);
        temp.put("downrighty",(double)downright.y);
        temp.put("t3x",null);
        temp.put("t3y",null);
        temp.put("shapeNo",4.0);
        this.setProperties(temp);
    }

    @Override
    public Object clone(){
        Rectangle r = new Rectangle();
        r.setColor(this.getColor());
        r.setFillColor(this.getFillColor());
        Point p = new Point(((Point) this.getPosition()).x,((Point) this.getPosition()).y);
        r.setPosition(p);
        Map<String,Double> temp = new HashMap<>();
        int[] x = new int[0];
        for(Map.Entry<String,Double> s:this.getProperties().entrySet()){
            temp.put(s.getKey(),s.getValue());
        }
        r.setProperties(temp);
        return r;
    }
    @Override
    public void draw (Object canvas) {
        ((GraphicsContext) canvas).setStroke((javafx.scene.paint.Paint) this.getColor());
        ((GraphicsContext) canvas).setFill((Paint) this.getFillColor());
        ((GraphicsContext) canvas).strokeRect(upleft.x,upleft.y,downright.x,downright.y);
        ((GraphicsContext) canvas).fillRect(upleft.x,upleft.y,downright.x,downright.y);
    }
}
