package image;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import static util.Matrices.*;

public class PaletteRasterImage implements Image {

    private List<Color> palette;
    private int[][] pixels;
    private int width;
    private int height;

    public PaletteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels){
        this.height = getColumnCount(pixels);
        this.width = getRowCount(pixels);
        createRepresentation();
        setPixelsColor(pixels);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        requiresRectangularMatrix(pixels);
    }

    public void createRepresentation(){
        palette = new ArrayList();
        pixels = new int[this.width][this.height];
    }

    public void setPixelColor(Color color, int x, int y){
        if( !(palette.contains(color)) )
            palette.add(color);

        pixels[x][y] = palette.indexOf(color);
    }

    public Color getPixelColor(int x, int y){

        return palette.get(pixels[x][y]);
    }

    private void setPixelsColor (Color[][] pixels){
        for(int x = 0 ; x < getRowCount(pixels) ; x++)
            for(int y = 0 ; y < getColumnCount(pixels) ; y++)
                setPixelColor(pixels[x][y] ,x ,y);
    }

    private void setPixelsColor (Color color){
        for(int x = 0 ; x < height ; x++)
            for(int y = 0 ; y < width ; y++)
                setPixelColor(color,x,y);
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected void setHeight(int height){
        this.height = height;
    }


}
