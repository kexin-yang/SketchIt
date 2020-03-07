import javafx.application.Application;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
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
import javafx.stage.Stage;
import javax.swing.*;
import java.io.File;

public class SketchIt extends Application{
        static double WIDTH = 1000;
        static double HEIGHT = 600;

    public void start(Stage stage) throws Exception {
        Model model = new Model();
        stage.setTitle("SketchIt");
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        FileChooser fileChooser;
        GridPane root = new GridPane();
//        root.widthProperty().addListener(((observableValue, number, t1) -> canvas.setWidth((Double)t1/1.2)));
//        root.heightProperty().addListener(((observableValue, number, t1) -> canvas.setHeight((Double)t1/1.2)));
        //canvas.prefWidth().bind(root.widthProperty().divide(1.2));

        MenuBar menubar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem New = new MenuItem("New");
        MenuItem Load = new MenuItem("Load");
        MenuItem Save = new MenuItem("Save");
        MenuItem Quit = new MenuItem("Quit");

        Menu editMenu = new Menu("Edit");
        // put menus together
        fileMenu.getItems().add(New);
        fileMenu.getItems().add(Load);
        fileMenu.getItems().add(Save);
        fileMenu.getItems().add(Quit);
        menubar.getMenus().addAll(fileMenu, editMenu);

        // Map shortcut keys to menu items
        New.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        Load.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
        Save.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        Quit.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));

        // button functions
        Quit.setOnAction(actionEvent -> {
            System.exit(0);
        });
        fileChooser = new FileChooser();
        Load.setOnAction(actionEvent -> {
            System.out.println("Load file");
            File file = fileChooser.showOpenDialog(stage);
            if (file == null) {
                System.out.println("Open dialog returns NULL");
            } else {
                System.out.println("Open dialog returns\n" + file.getPath());
            }
        });
        Save.setOnAction(actionEvent -> {
            System.out.println("Save File");
            File file = fileChooser.showSaveDialog(stage);
            if (file == null) {
                System.out.println("Save dialog returns Null");
            } else {
                System.out.println("Save dialog returns \n" + file.getPath());
            }
        });

        CanvasView canvasView = new CanvasView(model);
        ToolbarView toolbarView = new ToolbarView(model);
        root.add(menubar, 0,0);
        root.add(canvasView, 0,1);
        root.add(toolbarView, 1,1);
        stage.setScene(new Scene(root));
        stage.show();
    }
}


//    public static void main(String[] args) {
//        try{
//            runa3();
//        }
//        catch(Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//    public static void runa3(){
//        new CanvasView();
//    }