import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.util.ArrayList;
import javafx.application.Application;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

public class Rec extends Shape {
    static public ArrayList<Rec> recList = new ArrayList<>();
    double sx;
    double sy;
    double ex;
    double ey;
    String shapeType;
    boolean shapeSelected;
    String shapeFillColor;
    String shapeLineColor;
    int shapeLineStyle;
    int shapeLineWeight;

    public Rec(double sx, double sy, double ex, double ey, String shapeType, boolean shapeSelected,
                String shapeFillColor, String shapeLineColor, int shapeLineStyle, int shapeLineWeight) {
//        super(sx,sy,ex,ey,shapeType, shapeSelected, shapeFillColor, shapeLineColor, shapeLineStyle, shapeLineWeight);
        this.sx = sx;
        this.sy = sy;
        this.ex = ex;
        this.ey = ey;
        this.shapeType = shapeType;
        this.shapeSelected = shapeSelected;
        this.shapeFillColor = shapeFillColor;
        this.shapeLineColor = shapeLineColor;
        this.shapeLineStyle = shapeLineStyle;
        this.shapeLineWeight = shapeLineWeight;
    }
    public static void addIntoRecList(Rec rec){
        recList.add(rec);
//        Shape.addIntoShapeList(rec);
        Model.notifyObserver();
       }
    public static void draw(Rec rec, double sx, double sy, double ex, double ey) {
        Rectangle r = new Rectangle();
        r.setX(Math.min(sx,ex));
        r.setY(Math.min(sy,ey));
        r.setWidth(Math.abs(ex - sx));
        r.setHeight(Math.abs(ey - sy));
        r.setStroke(Paint.valueOf(Model.selectedLineColor));
        r.setFill(Paint.valueOf(Model.selectedFillColor));
        System.out.println(r);
        CanvasView.drawingCanvas.getChildren().add(r);
    }
    public static boolean contains (Rec rec, double x, double y) {
        double CenterX = 0.5 * (rec.sx + rec.ex);
        double CenterY = 0.5 * (rec.sy + rec.ey);
        double rx = 0.5 * (Math.abs(rec.ex-rec.sx));
        double ry = 0.5 * (Math.abs(rec.ey - rec.sy));
        if (((CenterX - rx) < x) && (x < (CenterX + rx)) && ((CenterY - ry) < y) && (y < (CenterY + ry))){
            System.out.println("Rec: it is true!!!!");
            return true;
        } else {System.out.println("Rec: it is false!!!!");
            return false;}
    }
    public static void removeFromList(Rec r){
        r.shapeFillColor = "WHITE";
        r.shapeLineColor = "WHITE";
        Model.notifyObserver();
    }
}

