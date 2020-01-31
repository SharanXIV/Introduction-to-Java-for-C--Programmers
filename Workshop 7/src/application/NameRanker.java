package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class NameRanker extends BorderPane {
	
	// Creating a Grid Pane
	GridPane root = new GridPane();
	GridPane buttonGrid = new GridPane();
	GridPane fieldGrid = new GridPane();
	GridPane resultGrid = new GridPane();

	// Labels
	Text yearLabel = new Text("Enter the Year:");
	Text genderLabel = new Text("Enter the Gender:");
	Text nameLabel = new Text("Enter the Name:");
	Text displayLabel = new Text("");

	// Text fields
	TextField yearField = new TextField();
	TextField genderField = new TextField();
	TextField nameField = new TextField();

	// Buttons
	Button buttonSubmit = new Button("Submit Query");
	Button buttonExit = new Button("Exit");
	
	public NameRanker() {
		create();
	}

	public void create() {
		
		// Set flag to true to view grid. 
		root.setGridLinesVisible(false);
		fieldGrid.setGridLinesVisible(false);
		buttonGrid.setGridLinesVisible(false);
		resultGrid.setGridLinesVisible(false);
		
		// Make buttons uniform size
		buttonSubmit.setPrefWidth(100);
		buttonExit.setPrefWidth(100);

		// Setting the padding around the grid
		root.setPadding(new Insets(10, 10, 10, 10));
		buttonGrid.setPadding(new Insets(10, 10, 10, 10));
		fieldGrid.setPadding(new Insets(10, 10, 10, 10));
		resultGrid.setPadding(new Insets(10, 10, 10, 10));
		
		// Setting the gap between cells
		buttonGrid.setHgap(15);
		fieldGrid.setVgap(5);
		fieldGrid.setHgap(5);


		// Setting the Grid alignment
		root.setAlignment(Pos.TOP_CENTER);
		fieldGrid.setAlignment(Pos.TOP_CENTER);
		buttonGrid.setAlignment(Pos.TOP_CENTER);
		resultGrid.setAlignment(Pos.TOP_CENTER);
		
		// Arranging all the nodes in the grid
		fieldGrid.add(yearLabel, 1, 1);
		fieldGrid.add(yearField, 2, 1, 2, 1);
		fieldGrid.add(genderLabel, 1, 3);
		fieldGrid.add(genderField, 2, 3, 2, 1);
		fieldGrid.add(nameLabel, 1, 5);
		fieldGrid.add(nameField, 2, 5, 2, 1);

		root.add(fieldGrid, 1, 1);
		
		resultGrid.add(displayLabel, 1, 1);
		
		root.add(resultGrid, 1, 2);

		buttonGrid.add(buttonSubmit, 1, 1);
		buttonGrid.add(buttonExit, 2, 1);
		
		root.add(buttonGrid, 1, 3);
	}
}
