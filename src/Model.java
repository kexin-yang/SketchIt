import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Model {
    //view
    private ArrayList<IView> views = new ArrayList<IView>();
   // feature selected
    public static String shapeType = "";
    public static int selectedLineWeight = 3;
    public static int selectedLineStyle = 1;
    public static String selectedFillColor = "Yellow";
    public static String selectedLineColor = "Brown";

    // Button chosen state
    public static boolean selectChosen = false;
    public static boolean eraserChosen = false;
    public static boolean circleChosen = false;
    public static boolean rectangleChosen = false;
    public static boolean lineChosen = false;
    public static boolean paintChosen = false;


    // drawing coordinates
    public static double ovalStartingPosX;
    public static double ovalStartingPosY;
    public static double recStartingPosX;
    public static double recStartingPosY;
    public static double lineStartingPosX;
    public static double lineStartingPosY;

    // shapes drawn
    public static ArrayList shapes;

    public void addView(IView view) {
        views.add(view);
//        view.updateView();
    }


    // draw circle
    public static void notifyObserver(){
        CanvasView.updateView();
        //todo suspect this is not working, suspect that I can draw line, square then circle, because of the sequence of code writing, or hieearychy

        // only one thing in the toolbar can be active
        if (selectChosen == true) {
            eraserChosen = false;
            circleChosen = false;
            rectangleChosen = false;
            lineChosen = false;
            paintChosen = false;
        }
        else if (eraserChosen == true) {
            selectChosen = false;
            circleChosen = false;
            rectangleChosen = false;
            lineChosen = false;
            paintChosen = false;
        }
        else if (circleChosen == true) {
            shapeType = "oval";
            selectChosen = false;
            eraserChosen = false;
            rectangleChosen = false;
            lineChosen = false;
            paintChosen = false;
        }
        else if (rectangleChosen == true) {
            shapeType = "rectangle";
            selectChosen = false;
            circleChosen = false;
            eraserChosen = false;
            lineChosen = false;
            paintChosen = false;
        }
        else if (lineChosen == true) {
            shapeType = "line";
            selectChosen = false;
            circleChosen = false;
            rectangleChosen = false;
            eraserChosen = false;
            paintChosen = false;
        }
        else if (paintChosen == true) {
            selectChosen = false;
            circleChosen = false;
            rectangleChosen = false;
            lineChosen = false;
            eraserChosen = false;
        }
    }

    public void addOval(MouseEvent e){
        Oval oval = new Oval(ovalStartingPosX,ovalStartingPosY, e.getX(), e.getY(), "oval",
                false, selectedFillColor, selectedLineColor, selectedLineStyle, selectedLineWeight);
        System.out.println(oval);
        Oval.addIntoOvalList(oval);
        Model.notifyObserver();
    }
    public void addRec(MouseEvent e) {
        System.out.println("enter add rec");
        Rec rec = new Rec(recStartingPosX,recStartingPosY, e.getX(),e.getY(),"rectangle",
                false, selectedFillColor, selectedLineColor, selectedLineStyle, selectedLineWeight);
        Rec.addIntoRecList(rec);
        Model.notifyObserver();
    }
    public void addLine(MouseEvent e) {
        System.out.println("enter add line");
        Lines l = new Lines(lineStartingPosX,lineStartingPosY,e.getX(),e.getY(),"line",false,
                selectedFillColor,selectedLineColor,selectedLineStyle,selectedLineWeight);
        Lines.addIntoLineList(l);
        Model.notifyObserver();
    }

}


    /* todo: draw circle
        we need to know: center X, center Y, radius
        what we have: start point, end point, the radius can be half its distance, and the center can be the mid point of start and end
         todo: draw rectangle
         need to know: upper left point, lower right point, width, height
         we have: start point, end point
         todo: draw line
         need to know and have: start point, end point
        */





