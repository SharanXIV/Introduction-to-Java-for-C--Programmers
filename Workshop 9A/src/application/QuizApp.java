// JAC444 - Workshop 9 - Task 1
// Filename:     QuizApp.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-11-29

package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class QuizApp extends BorderPane {
	
	// Creating a Grid Pane
	GridPane root = new GridPane();
	GridPane randomNumGrid = new GridPane();
	GridPane resultsGrid = new GridPane();
	GridPane tryAgainGrid = new GridPane();

	// Labels
	Text introLabel = new Text("Two randomly generated numbers are: ");
	Text randomNumLabel = new Text("");
	Text additionLabel = new Text("What is the addition of ");
	Text subtractionLabel = new Text("What is the subtraction of ");
	Text multiplicationLabel = new Text("What is the multiplication of ");
	Text divisionLabel = new Text("What is the division of ");
	Text correctLabel = new Text("Number of correct answers: ");
	Text wrongLabel = new Text("Number of wrong answers: ");
	Text wrongAnsLabel = new Text("");
	Text correctAnsLabel = new Text("");
	Text alreadyAnsweredLabel = new Text("");
	Text tryAgainLabel = new Text("Would you like to try with two other different numbers?");

	// Text fields
	TextField additionField = new TextField();
	TextField subtractionField = new TextField();
	TextField multiplicationField = new TextField();
	TextField divisionField = new TextField();
	TextField tryAgainField = new TextField();

	public QuizApp() {
		create();
	}

	public void create() {
		
		// Set flag to true to view grid. 
//		root.setGridLinesVisible(true);
//		randomNumGrid.setGridLinesVisible(true);
//		resultsGrid.setGridLinesVisible(true);
//		tryAgainGrid.setGridLinesVisible(true);

		// Setting the padding around the grid
		root.setPadding(new Insets(10, 10, 10, 10));
		randomNumGrid.setPadding(new Insets(10, 10, 10, 10));
		resultsGrid.setPadding(new Insets(10, 10, 10, 10));
		tryAgainGrid.setPadding(new Insets(10, 10, 10, 10));

		// Setting the gap between cells
		randomNumGrid.setVgap(5);
		randomNumGrid.setHgap(5);
		resultsGrid.setVgap(5);
		resultsGrid.setHgap(5);
		tryAgainGrid.setVgap(5);
		tryAgainGrid.setHgap(5);

		// Setting the Grid alignment
		root.setAlignment(Pos.TOP_CENTER);
		randomNumGrid.setAlignment(Pos.TOP_CENTER);
		resultsGrid.setAlignment(Pos.TOP_CENTER);
		GridPane.setHalignment(additionLabel, HPos.RIGHT);
		GridPane.setHalignment(subtractionLabel, HPos.RIGHT);
		GridPane.setHalignment(multiplicationLabel, HPos.RIGHT);
		GridPane.setHalignment(divisionLabel, HPos.RIGHT);
		GridPane.setHalignment(correctLabel, HPos.RIGHT);
		GridPane.setHalignment(wrongLabel, HPos.RIGHT);

		// Arranging all the nodes in the grid
		randomNumGrid.add(introLabel, 1, 1);
		randomNumGrid.add(randomNumLabel, 2, 1);

		root.add(randomNumGrid, 1, 1);

		resultsGrid.add(additionLabel, 1, 1);
		resultsGrid.add(additionField, 2, 1);
		resultsGrid.add(subtractionLabel, 1, 2);
		resultsGrid.add(subtractionField, 2, 2);
		resultsGrid.add(multiplicationLabel, 1, 3);
		resultsGrid.add(multiplicationField, 2, 3);
		resultsGrid.add(divisionLabel, 1, 4);
		resultsGrid.add(divisionField, 2, 4);
		resultsGrid.add(correctLabel, 1, 5);
		resultsGrid.add(correctAnsLabel, 2, 5);
		resultsGrid.add(wrongLabel, 1, 6);
		resultsGrid.add(wrongAnsLabel, 2, 6);

		root.add(resultsGrid, 1, 2);

		tryAgainGrid.add(alreadyAnsweredLabel, 1, 1);
		tryAgainGrid.add(tryAgainLabel, 1, 2);
		tryAgainGrid.add(tryAgainField, 2, 2);
		tryAgainField.setPrefWidth(40);

		root.add(tryAgainGrid, 1, 3);
	}

}
