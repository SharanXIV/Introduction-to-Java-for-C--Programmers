package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	public NameRanker window = new NameRanker();
	static final String FILEPATH = "babynamesranking";

	@Override
	public void start(Stage primaryStage) {

		// Create event handlers
		window.buttonSubmit.setOnAction(e -> {
			try {
				submit();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		window.buttonExit.setOnAction(e -> {
			System.exit(1);
		});

		// Setting title to the stage
		primaryStage.setTitle("Search Name Ranking Application");

		// Creating a scene object
		Scene scene = new Scene(window.root, 300, 250);

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();
	}

	public void submit() throws IOException {
		String year = window.yearField.getText();
		File file = new File(FILEPATH + year + ".txt");

		// Check if the file exists.
		if (!file.exists()) {
			window.displayLabel.setText("Records not found for year " + year);
		}

		int ranking = 0;

		Scanner readFile = new Scanner(file);

		while (readFile.hasNext()) {
			String readLine = readFile.nextLine();

			// Separate the read line by space delimiter.
			String[] splitFields = readLine.split(" ");

			// If gender is male and name matches within fields, get ranking.
			if (window.genderField.getText().equalsIgnoreCase("M")
					&& splitFields[1].contains(window.nameField.getText())) {
				ranking = Integer.parseInt(splitFields[0]);
			}
			// Else, find match within female fields.
			else if (splitFields[2].contains(window.nameField.getText())) {
				ranking = Integer.parseInt(splitFields[0]);
			}
		}

		String gender;

		if (window.genderField.getText().equalsIgnoreCase("M")) {
			gender = "Boy";
		} else {
			gender = "Girl";
		}

		// Update the display label with the results. If no ranking is found, it is assumed that name not ranked that year.
		if (ranking != 0) {
			window.displayLabel.setText(gender + " name " + window.nameField.getText() + " is ranked #" + ranking
					+ " in " + year + " year");
		} else {
			window.displayLabel.setText("The name " + window.nameField.getText() + " is not found in the year " + year);
		}
	}

	public void build(String[] args) {
		launch(args);
	}
}
