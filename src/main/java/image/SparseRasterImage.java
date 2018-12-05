package image;
import javafx.scene.paint.Color;
import java.util.HashMap;
import static util.Matrices.*;
import static util.Matrices.requiresRectangularMatrix;

public class SparseRasterImage extends RasterImage {

    private HashMap<Point, Color> sparse;
    private int width;
    private int height;

    public SparseRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public SparseRasterImage(Color[][] pixels){
        this.height = getColumnCount(pixels);
        this.width = getRowCount(pixels);
        createRepresentation();
        setPixelsColor(pixels);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        requiresRectangularMatrix(pixels);
    }

    public void createRepresentation() {
        sparse = new HashMap<Point, Color>();
    }

    public void setPixelColor(Color color, int x, int y){
        sparse.put(new Point(x, y), color);
    }

    public Color getPixelColor(int x, int y){
        return sparse.get(new Point(x,y));
    }

    private void setPixelsColor(Color[][] pixels){
        for(int x = 0 ; x < getRowCount(pixels) ; x++)
            for(int y = 0 ; y < getColumnCount(pixels) ; y++)
                sparse.put(new Point(x, y), pixels[x][y]);
    }

    private void setPixelsColor(Color color){
        for(int x = 0 ; x < height ; x++)
            for(int y = 0 ; y < width ; y++)
                sparse.put(new Point(x, y), color);
    }

    public int getWidth(){ return this.width; }

    public int getHeight(){ return this.height; }

    protected void setWidth(int width){ this.width = width; }

    protected void setHeight(int height){ this.height = height;}

}
