import javafx.application.Application;

import javafx.event.EventHandler;
import java.io.File;

import javafx.scene.control.Label;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

public class ToolbarView extends Pane implements IView {
    public VBox toolbarBox = new VBox();
    Button bCircle = new Button();
    private Model model;
    ToolbarView(Model model) {
        this.model = model;
        VBox root = new VBox();
        VBox toolbarBox = new VBox();
        HBox lineWidthBox = new HBox();
        Label lineWidthLabel = new Label();
        Label lineStyleLabel = new Label();
        HBox lineStyleBox = new HBox();
        HBox toolAndCanvas = new HBox();


        // 6 buttons
        for (int i = 1; i < 13; i++) {
            Button bSelect;
            Button bEraser = null;
            Button bRectangle = null;
            Button bLine = null;
            Button bPaint = null;
            Button bThinLine = null;
            Button bMidWidthLine = null;
            Button bThickLine = null;
            Button bLineStyle1 = null;
            Button bLineStyle2 = null;
            Button bLineStyle3 = null;
            lineWidthLabel.setText("Line Width");
            lineWidthLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:ROSYBROWN");
            lineStyleLabel.setText("Line Style");
            lineStyleLabel.setStyle("-fx-font-weight: bold; -fx-text-fill:ROSYBROWN");
            Toolbar tool = new Toolbar(i);
            ImageView view = tool.imageView;
            if (i == 1) {
                bSelect = new Button("", view);
                toolbarBox.getChildren().add(bSelect);
                bSelect.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                System.out.println("Select button clicked");
                                Model.selectChosen = true;
                                Model.circleChosen = false;
                                Model.lineChosen = false;
                                Model.rectangleChosen = false;
                                Model.paintChosen = false;
                            }
                        });
            } else if (i == 2) {
                bEraser = new Button("", view);
                toolbarBox.getChildren().add(bEraser);
                bEraser.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                System.out.println("Eraser button clicked");
                                Model.eraserChosen = true;
                                Model.selectChosen = false;
                                Model.circleChosen = false;
                                Model.lineChosen = false;
                                Model.rectangleChosen = false;
                                Model.paintChosen = false;
                            }
                });
            } else if (i == 3) {
                bCircle = new Button("", view);
                toolbarBox.getChildren().add(bCircle);
                // circle button action
                bCircle.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent e) {
                                System.out.println("Circle Button clicked");
                                Model.circleChosen = true;
                                Model.rectangleChosen = false;
                                Model.lineChosen = false;
                                Model.selectChosen = false;
                                Model.paintChosen = false;
                                System.out.println(Model.circleChosen);
                                Model.notifyObserver();
                            }
                        });
            } else if (i == 4) {
                bRectangle = new Button("", view);
                toolbarBox.getChildren().add(bRectangle);
                bRectangle.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                System.out.println("Rec Button Clicked");
                                Model.rectangleChosen = true;
                                Model.circleChosen = false;
                                Model.lineChosen = false;
                                Model.selectChosen = false;
                                Model.paintChosen = false;
                                Model.notifyObserver();
                            }
                        });
            } else if (i == 5) {
                bLine = new Button("", view);
                toolbarBox.getChildren().add(bLine);
                EventHandler<MouseEvent> bLineHandler = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        System.out.println("Line button clicked");
                        Model.lineChosen = true;
                        Model.circleChosen = false;
                        Model.rectangleChosen = false;
                        Model.selectChosen = false;
                        Model.paintChosen = false;
                        Model.notifyObserver();
                    }
                };
                bLine.addEventHandler(MouseEvent.MOUSE_CLICKED, bLineHandler);
            }
            else if (i == 6) {
                bPaint = new Button("", view);
                toolbarBox.getChildren().add(bPaint);
            } else if (i == 7) {
                bThinLine = new Button("", view);
                lineWidthBox.getChildren().add(bThinLine);
                bThinLine.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                System.out.println("Thinline Button Clicked");
                                Model.rectangleChosen = false;
                                Model.circleChosen = false;
                                Model.lineChosen = false;
                                Model.selectChosen = false;
                                Model.paintChosen = false;
                                Model.selectedLineWeight = 1;
                                Model.notifyObserver();
                            }});
            } else if (i == 8) {
                bMidWidthLine = new Button("", view);
                lineWidthBox.getChildren().add(bMidWidthLine);
                bMidWidthLine.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                System.out.println("Midline Button Clicked");
                                Model.rectangleChosen = false;
                                Model.circleChosen = false;
                                Model.lineChosen = false;
                                Model.selectChosen = false;
                                Model.paintChosen = false;
                                Model.selectedLineWeight = 5;
                                Model.notifyObserver();
                            }});
            } else if (i == 9) {
                bThickLine = new Button("", view);
                lineWidthBox.getChildren().add(bThickLine);
                bThickLine.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                System.out.println("Thinline Button Clicked");
                                Model.rectangleChosen = false;
                                Model.circleChosen = false;
                                Model.lineChosen = false;
                                Model.selectChosen = false;
                                Model.paintChosen = false;
                                Model.selectedLineWeight = 10;
                                Model.notifyObserver();
                            }});
                toolbarBox.getChildren().add(lineWidthLabel);
                toolbarBox.getChildren().add(lineWidthBox);
            } else if (i == 10) {
                bLineStyle1 = new Button("", view);
                lineStyleBox.getChildren().add(bLineStyle1);
            } else if (i == 11) {
                bLineStyle2 = new Button("", view);
                lineStyleBox.getChildren().add(bLineStyle2);
            } else if (i == 12) {
                bLineStyle3 = new Button("", view);
                lineStyleBox.getChildren().add(bLineStyle3);
                toolbarBox.getChildren().add(lineStyleLabel);
                toolbarBox.getChildren().add(lineStyleBox);
                this.getChildren().add(toolbarBox);
            }
        }
    }
}


