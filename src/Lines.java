import java.util.ArrayList;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

class Lines extends Shape {
    static ArrayList<Lines> lineList = new ArrayList<>();

    public Lines(double sx, double sy, double ex, double ey, String shapeType, boolean shapeSelected,
                 String shapeFillColor, String shapeLineColor, int shapeLineStyle, int shapeLineWeight) {
        super(sx,sy,ex,ey,shapeType, shapeSelected, shapeFillColor, shapeLineColor, shapeLineStyle, shapeLineWeight);
    }
    public static void addIntoLineList(Lines line){
        lineList.add(line);
        Shape.addIntoShapeList(line);
        Model.notifyObserver();
    }
    public static void draw(double sx, double sy, double ex, double ey) {
        Line l = new Line();
        l.setStrokeWidth(Model.selectedLineWeight);
        l.setStroke(Paint.valueOf(Model.selectedLineColor));
        l.setStartX(sx);
        l.setStartY(sy);
        l.setEndX(ex);
        l.setEndY(ey);
        CanvasView.drawingCanvas.getChildren().add(l);
    }
}

