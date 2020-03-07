import java.util.ArrayList;

public class Shape {
    // feature of a shape
    public static ArrayList<Shape> shapeList = new ArrayList<>();
    double sx;
    double sy;
    double ex;
    double ey;
    public String shapeType;
    public Boolean shapeSelected;
    public String shapeFillColor;
    public String shapeLineColor;
    public int shapeLineStyle;
    public int shapeLineWeight;

    public Shape (double sx, double sy, double ex, double ey, String shapeType, boolean shapeSelected, String shapeFillColor, String shapeLineColor,
                          int shapeLineStyle, int shapeLineWeight){
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

    public static void addIntoShapeList(Shape s){
        // add shape (of any kind) into the shape list)
        shapeList.add(s);
    }
    public static boolean contains (Shape s, double x, double y) {
        System.out.println("Enter 自定义 contains");
        if (s.shapeType == "oval") {
            System.out.println("Enter 自定义 contains 并且进入oval");
            System.out.println("this oval contains the point?: " + Oval.contains(s, x, y));
            return Oval.contains(s, x, y); }
//        else if (s.shapeType == "rectangle") {
//            return;
//        }
        return false;
    }


    }

