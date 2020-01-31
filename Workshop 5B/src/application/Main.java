// JAC444 - Workshop 5 - Task 2
// Filename:     Main.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-11-01

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		// Creating a Grid Pane
		GridPane root = new GridPane();
		GridPane buttonGrid = new GridPane();
		GridPane nameGrid = new GridPane();
		GridPane addressGrid = new GridPane();
		
		// Set flag to true to view grid. 
		root.setGridLinesVisible(false);
		nameGrid.setGridLinesVisible(false);

		// Labels
		Text fNameLabel = new Text("First Name:");
		Text lNameLabel = new Text("Last Name:");
		Text cityLabel = new Text("City:");
		Text provLabel = new Text("Province:");
		Text pcLabel = new Text("Postal Code:");

		// Text fields
		TextField fNameField = new TextField();
		TextField lNameField = new TextField();
		TextField cityField = new TextField();
		TextField pcField = new TextField();
		
		// Buttons
	    Button buttonAdd = new Button("Add");  
	    Button buttonFirst = new Button("First");
	    Button buttonNext = new Button("Next");  
	    Button buttonPrev = new Button("Previous");  
	    Button buttonLast = new Button("Last");  
	    Button buttonUpd = new Button("Update");
	    
	    // Make buttons uniform size
	    buttonAdd.setPrefWidth(75);
	    buttonFirst.setPrefWidth(75);
	    buttonNext.setPrefWidth(75);
	    buttonPrev.setPrefWidth(75);
	    buttonLast.setPrefWidth(75);
	    buttonUpd.setPrefWidth(75);


		// Choice box for Province
	    ChoiceBox provChoiceBox = new ChoiceBox(); 
        provChoiceBox.getItems().add("AB");


		// Setting the padding around the grid
		root.setPadding(new Insets(10,10,10,10));
		nameGrid.setPadding(new Insets(10,10,10,10));
		addressGrid.setPadding(new Insets(10,10,10,10));
		buttonGrid.setPadding(new Insets(10,10,10,10));
		
		// Setting the gap between cells
		nameGrid.setVgap(5);
		nameGrid.setHgap(5);
		buttonGrid.setVgap(5);
		buttonGrid.setHgap(5);
		addressGrid.setVgap(5);
		addressGrid.setHgap(5);

		// Setting the Grid alignment
		root.setAlignment(Pos.TOP_LEFT);
		buttonGrid.setAlignment(Pos.TOP_CENTER);


		// Arranging all the nodes in the grid
		nameGrid.add(fNameLabel, 1, 1);
		nameGrid.add(fNameField, 2, 1,90,1);
		nameGrid.add(lNameLabel, 1, 4);
		nameGrid.add(lNameField, 2, 4,90,1);
		
		root.add(nameGrid, 1, 1);

		addressGrid.add(cityLabel, 1, 1);
		addressGrid.add(cityField, 2, 1);
		addressGrid.add(provLabel, 3, 1);
		addressGrid.add(provChoiceBox, 4, 1);
		addressGrid.add(pcLabel, 5, 1);
		addressGrid.add(pcField, 6, 1);

		root.add(addressGrid, 1, 2);
		 
		buttonGrid.add(buttonAdd, 1, 1);
		buttonGrid.add(buttonFirst, 2, 1);
		buttonGrid.add(buttonNext, 3, 1);
		buttonGrid.add(buttonPrev, 4, 1);
		buttonGrid.add(buttonLast, 5, 1);
		buttonGrid.add(buttonUpd, 6, 1);
		
		root.add(buttonGrid, 1, 3);
		
		// Setting title to the stage
		primaryStage.setTitle("Address Book");

		// Creating a scene object
		Scene scene = new Scene(root, 550, 200);

		// Adding scene to the stage
		primaryStage.setScene(scene);
		
		// Displaying the contents of the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
