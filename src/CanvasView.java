import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.geometry.Point2D;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class CanvasView extends Pane implements IView {
    private Model model;
    public static Canvas canvas;
    public static Group drawingCanvas = new Group();
    public static Point2D point;

    CanvasView(Model model) {
    FileChooser fileChooser;
    Button bCircle = new Button();
    Button bRectangle = new Button();
    Button bLine = new Button();
    double canvasWidth = 750;
    double canvasHeight = 500;

    // the place to draw - actual canvas
    canvas = new Canvas(canvasWidth, canvasHeight);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setLineWidth(5);
    gc.setStroke(Color.BLACK);
    gc.setFill(Color.WHITE);
    gc.fillRect(80, 0, canvas.getWidth(), canvas.getHeight());
    //draw circle
        Ellipse pe = new Ellipse();
        pe.setStrokeWidth(2.0);
        pe.setFill(Color.TRANSPARENT);
        pe.setStroke(Color.BLACK);
        EventHandler<MouseEvent> ovalHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                // When circle is Chosen
                if (Model.circleChosen == true) {
                    Model.notifyObserver();
                    if (Model.circleChosen == true) {
                    if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
                        Model.ovalStartingPosX = e.getX();
                        Model.ovalStartingPosY = e.getY();
                        pe.setCenterX(Model.ovalStartingPosX);
                        pe.setCenterY(Model.ovalStartingPosY);
                        pe.setRadiusX(0);
                        pe.setRadiusY(0);
                        drawingCanvas.getChildren().add(pe);
                    }
                    else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
                        drawingCanvas.getChildren().remove(pe);
                        model.addOval(e);}
                    else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                        pe.setCenterX((e.getX() + Model.ovalStartingPosX)/2);
                        pe.setCenterY((e.getY() + Model.ovalStartingPosY)/2);
                        pe.setRadiusX(Math.abs(e.getX() - Model.ovalStartingPosX)/2);
                        pe.setRadiusY(Math.abs(e.getY() - Model.ovalStartingPosY)/2);
                    }
                }}
            }
        };
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, ovalHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, ovalHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, ovalHandler);

        // draw Rectangle
        Rectangle pr = new Rectangle();
        pr.setStrokeWidth(2.0);
        pr.setFill(javafx.scene.paint.Color.TRANSPARENT);
        pr.setStroke(Color.BLACK);
        EventHandler<MouseEvent> recHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (Model.rectangleChosen == true) {
                    Model.notifyObserver();
                    if (Model.rectangleChosen == true) {
                    if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
                        System.out.println("MousePressed in Rect");
                        Model.recStartingPosX = e.getX();
                        Model.recStartingPosY = e.getY();
                        pr.setX(Model.recStartingPosX);
                        pr.setY(Model.recStartingPosY);
                        pr.setWidth(0);
                        pr.setHeight(0);
                        drawingCanvas.getChildren().add(pr);
                    } else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                        pr.setX(Math.min(Model.recStartingPosX, e.getX()));
                        pr.setY(Math.min(Model.recStartingPosY, e.getY()));
                        pr.setWidth(Math.abs(e.getX() - Model.recStartingPosX));
                        pr.setHeight(Math.abs(e.getY() - Model.recStartingPosY));
                    } else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
                        drawingCanvas.getChildren().remove(pr);
                        model.addRec(e);}
                    }}
                }
        };
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, recHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, recHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, recHandler);
        // drawLine
        Line pl = new Line();
        pl.setStrokeWidth(1.0);
        pl.setFill(Color.TRANSPARENT);
        pl.setStroke(Color.BLACK);
        EventHandler<MouseEvent> lineHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (Model.lineChosen == true) {
                    Model.notifyObserver();
                    if (Model.lineChosen == true){
                    if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
                        System.out.println("MousePressed in Line");
                        Model.lineStartingPosX = e.getX();
                        Model.lineStartingPosY = e.getY();
                        pl.setStartX(Model.lineStartingPosX);
                        pl.setStartY(Model.lineStartingPosY);
                        pl.setEndX(Model.lineStartingPosX);
                        pl.setEndY(Model.lineStartingPosY);
                        drawingCanvas.getChildren().add(pl);
                    } else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                        pl.setStartX(Model.lineStartingPosX);
                        pl.setStartY(Model.lineStartingPosY);
                        pl.setEndX(e.getX());
                        pl.setEndY(e.getY());
                    } else if (e.getEventType() == MouseEvent.MOUSE_RELEASED) {
                        drawingCanvas.getChildren().remove(pl);
                        model.addLine(e);;
                    }
                    }
                }
            }
        };
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, lineHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, lineHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, lineHandler);
        // select shape
        EventHandler<MouseEvent> selectHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (Model.selectChosen == true)
//                {for (Shape s: Shape.shapeList) {
//                    if  (s.contains(s,e.getX(),e.getY())){
//                        s.shapeSelected = true;
//                    }
//                }}
                {for (Oval o: Oval.ovalList){
                    if (o.contains(o,e.getX(), e.getY())){
                        o.shapeSelected = true;
                        o.shapeFillColor = "PINK";
                        Model.notifyObserver();
                    }
                }
                }
                for (Rec r: Rec.recList) {
                    if (r.contains(r,e.getX(), e.getY())) {
                        r.shapeSelected = true;
                        r.shapeFillColor = "LIGHTPURPLE";
                        Model.notifyObserver();
                    }
                }
            } };
        drawingCanvas.addEventHandler(MouseEvent.MOUSE_CLICKED, selectHandler);
        EventHandler<MouseEvent> eraserHandler = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                if (Model.eraserChosen == true) {
                    for (Oval o:Oval.ovalList){
                    if (o.contains(o, e.getX(), e.getY())){ Oval.removeFromList(o);
                    }}
                    for (Rec r: Rec.recList){
                        if (r.contains(r,e.getX(), e.getY())){
                            Rec.removeFromList(r);
                        }
                    }
//                    ArrayList<Oval> list = Oval.ovalList;
//                    for (Iterator<Oval> iterator = list.iterator(); iterator.hasNext();) {
//                        Oval o = iterator.next();
//                        if (o.contains(o, e.getX(), e.getY())){
//                            Oval.removeFromList(o);
//                        }
//                    }
                }
            }
        };
        drawingCanvas.addEventHandler(MouseEvent.MOUSE_CLICKED, eraserHandler);
        // start!
        drawingCanvas.getChildren().add(canvas);
        this.getChildren().add(drawingCanvas);
        System.out.println("In CanvasVIEW, drawingCanvas is " + drawingCanvas);
    }
    public static void updateView(){
        // draw every oval in the oval List
        for (Oval oval: Oval.ovalList) {
            System.out.println("oval 1: " + oval + " at sx : " + oval.sx );
            double sx = oval.sx;
            double sy = oval.sy;
            double ex = oval.ex;
            double ey = oval.ey;
            Oval.draw(oval, sx,sy,ex,ey);
        }
        // draw every rec in the rec list
        for (Rec rec: Rec.recList) {
            double sx = rec.sx;
            double sy = rec.sy;
            double ex = rec.ex;
            double ey = rec.ey;
            Rec.draw(rec, sx,sy,ex,ey);
        }
        // draw every line in the line list
        for (Lines l: Lines.lineList) {
            double sx = l.sx;
            double sy = l.sy;
            double ex = l.ex;
            double ey = l.ey;
            Lines.draw(sx,sy,ex,ey);
        }
    }
}
