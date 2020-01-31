// JAC444 - Workshop 5 - Task 1
// Filename:     Main.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-11-01

package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		// Creating a Pane
		Pane root = new Pane();

		// Draw a large black background
		Rectangle board = new Rectangle(5, 5, 400, 400);
		board.setFill(Color.BLACK);
		root.getChildren().add(board);

		//Create a grid (8 by 8 squares)
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				// Fill in every other square with white.
				if (row % 2 == col % 2) {
					Rectangle tile = new Rectangle((5 + col * 50), (5 + row * 50), 50, 50);
					tile.setFill(Color.WHITE);
					root.getChildren().add(tile);
				}
			}
		}

		// Setting title to the stage
		primaryStage.setTitle("Chess Board");
		
		// Creating a scene object
		Scene scene = new Scene(root, 410, 410, Color.GREEN);
		
		// Adding scene to the stage
		primaryStage.setScene(scene);
		
		// Displaying the contents of the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}