package image;
import javafx.scene.paint.Color;
import static util.Matrices.*;

public class PaletteRasterImage implements Image {

    private Color[][] pixels;
    private int width;
    private int height;

    public PaletteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        pixels = new Color[height][width];
        for(int x = 0 ; x < height ; x++)
            for(int y = 0 ; y < width ; y++)
                this.pixels[x][y] = color;
    }

    public PaletteRasterImage(Color[][] colors){
        this.pixels = colors;
        this.height = getColumnCount(colors);
        this.width = getRowCount(colors);
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
    }

    public void createRepresentation(){
        pixels = new Color[this.width][this.height];
    }

    public void setPixelColor(Color color, int x, int y){

        pixels[x][y] = color;
    }

    public Color getPixelColor(int x, int y){

        return pixels[x][y];
    }

    private void setPixelsColor (Color[][] colors){
        for(int x = 0 ; x < getColumnCount(colors) ; x++)
            for(int y = 0 ; y < getRowCount(colors) ; y++)
                this.pixels[x][y] = colors[x][y];
    }

    private void setPixelsColor (Color color){
        for(int x = 0 ; x < height ; x++)
            for(int y = 0 ; y < width ; y++)
                this.pixels[x][y] = color;
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
