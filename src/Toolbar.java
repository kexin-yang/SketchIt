import javafx.application.Application;

import java.awt.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.io.File;
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
import javafx.stage.Stage;
import javafx.stage.FileChooser;

public class Toolbar {
    double x;
    double y;
    boolean clicked;
    Image image;
    int num;
    ImageView imageView;
    Toolbar(int num) {
        if (num == 1) {
            image = new Image("images/select.png", 45, 45, true, true);
            this.x = 0;
            this.y = 10;
        } else if (num == 2) {
            image = new Image("images/eraser.png", 45, 45, true, true);
            this.x = 40;
            this.y = 10;
        } else if (num == 3) {
            image = new Image("images/circle.png", 45, 45, true, true);
            this.x = 0;
            this.y = 40;
        } else if (num == 4) {
            image = new Image("images/rectangle.png", 45, 45, true, true);
            this.x = 40;
            this.y = 40;
        } else if (num == 5) {
            image = new Image("images/line.png", 45, 45, true, true);
            this.x = 0;
            this.y = 70;
        } else if (num == 6) {
            image = new Image("images/paint.png", 45, 45, true, true);
            this.x = 40;
            this.y = 70;
        } else if (num == 7) {
            image = new Image("images/thinLine.png",40,40,true,true);
        } else if (num == 8) {
            image = new Image("images/midWidthLine.png",40,40,true,true);
        } else if (num == 9) {
            image = new Image("images/thickLine.png",40,40,true,true);
        } else if (num == 10) {
            image = new Image("images/lineStyle1.png",40,40,true,true);
        } else if (num == 11) {
            image = new Image("images/lineStyle2.png",40,40,true,true);
        } else if (num == 12) {
            image = new Image("images/lineStyle3.png",40,40,true,true);
        }



        imageView = new ImageView(image);
        imageView.setLayoutX(this.x);
        imageView.setLayoutY(this.y);
    }
}

// constructor 里能有判断？
