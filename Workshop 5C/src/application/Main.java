// JAC444 - Workshop 5 - Task 3
// Filename:     Main.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-11-01

package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Creating a Pane
		Pane root = new Pane();

		// Setting title to the stage
		primaryStage.setTitle("Welcome to Java");

		// Creating a scene object
		Scene scene = new Scene(root, 400, 400);

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();

		// Setting the string and font
		String[] string = "Welcome to Java".split("");
		Font font = Font.font("Times New Roman", 30);

		double angle = 0;
		double rotation = 90;

		for (int i = 0; i < string.length; i++, angle += 22, rotation += 22) {

			// Find the points along a circle.
			double x = 100 * Math.cos(Math.toRadians(angle)) + 200;
			double y = 100 * Math.sin(Math.toRadians(angle)) + 200;

			// Place each letter on point along circle.
			Text letter = new Text(x, y, string[i]);

			// Rotate the letter towards the circle
			letter.setRotate(rotation);
			letter.setFont(font);
			root.getChildren().add(letter);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
