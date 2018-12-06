package image;
import javafx.scene.paint.Color;
import java.util.HashMap;
import static util.Matrices.getColumnCount;
import static util.Matrices.getRowCount;

public class Rectangle implements Shape {

    private Color color;
    private int width;
    private int height;
    private Point depart;
    
    public Rectangle(int x, int y, int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.depart = new Point(x, y);
    }

    public boolean contains(Point point){
        boolean width = (depart. x <= point.x && point.x <= depart.x + this.width);
        boolean height = (depart.y <= point.y && point.y <= depart.y + this.height);
        return (width && height);
    }

    public Color getColor(){return this.color; }

}
