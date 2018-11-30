package image;
import java.awt.*;
import static util.Matrices.*;


public class BruteRasterImage implements Image {

    private Color[][] colors;
    private int width;
    private int height;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        colors = new Color[width][height];
        for(int x = 0 ; x < width ; x++)
            for(int y = 0 ; y < height ; y++)
                this.colors[x][y] = color;
    }

    public BruteRasterImage(Color[][] colors){
        this.colors = colors;
        this.width = getColumnCount(colors);
        this.height = getRowCount(colors);
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
    }

    public void createRepresentation(){

    }




}
