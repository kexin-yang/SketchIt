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

public class Oval extends Shape {
    static public ArrayList<Oval> ovalList = new ArrayList<>();
    double sx;
    double sy;
    double ex;
    double ey;
    public Oval(double sx, double sy, double ex, double ey, String shapeType, boolean shapeSelected,
                String shapeFillColor, String shapeLineColor, int shapeLineStyle, int shapeLineWeight) {
        super(sx,sy,ex,ey,shapeType, shapeSelected, shapeFillColor, shapeLineColor, shapeLineStyle, shapeLineWeight);
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
    public static void addIntoOvalList(Oval oval) {
        ovalList.add(oval);
        Shape.addIntoShapeList(oval);
        Model.notifyObserver();
    }
    public static boolean contains (Oval oval, double x, double y) {
        double CenterX = 0.5 * (oval.sx + oval.ex);
        double CenterY = 0.5 * (oval.sy + oval.ey);
        double rx = 0.5 * (Math.abs(oval.ex-oval.sx));
        double ry = 0.5 * (Math.abs(oval.ey - oval.sy));
        if ((Math.pow((x-CenterX),2)/Math.pow(rx,2) + Math.pow((y-CenterY),2)/Math.pow(ry,2)) <= 1) {
            System.out.println("it is true!!!!");
            return true;
        } else {System.out.println("it is false!!!!");
            return false;}
    }

    public static void draw(Oval oval, double sx, double sy, double ex, double ey) {
        Ellipse o = new Ellipse();
        o.setStrokeWidth(oval.shapeLineWeight);
        o.setFill(Paint.valueOf(oval.shapeFillColor));
        o.setStroke(Paint.valueOf(oval.shapeLineColor));
        o.setCenterX((ex + sx)/2);
        o.setCenterY((ey + sy)/2);
        o.setRadiusX(Math.abs(ex-sx)/2);
        o.setRadiusY(Math.abs(ey-sy)/2);
        System.out.println(o);
        CanvasView.drawingCanvas.getChildren().add(o);
    }
    public static void removeFromList(Oval o){
        o.shapeFillColor = "WHITE";
        o.shapeLineColor = "WHITE";
        Model.notifyObserver();
    }

}

