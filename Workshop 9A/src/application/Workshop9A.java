// JAC444 - Workshop 9 - Task 1
// Filename:     Workshop9A.java
// Author:       Sharan Shanmugaratnam
// Student No.:  153601174
// Date:         2019-11-29

package application;

import java.util.HashSet;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Workshop9A extends Application {
	int num1 = (int) (10.0 * Math.random()) + 1;
	int num2 = (int) (10.0 * Math.random()) + 1;

	String randomNums = num1 + " and " + num2;
	HashSet<String> answers = new HashSet();
	public QuizApp window = new QuizApp();

	@Override
	public void start(Stage primaryStage) {

		// Append the fields with the random numbers.
		setNumbers();

		// Event Handlers
		window.additionField.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				evalAndStore();
			}
		});

		window.subtractionField.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				evalAndStore();
			}
		});

		window.multiplicationField.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				evalAndStore();
			}
		});

		window.divisionField.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				evalAndStore();
			}
		});

		window.tryAgainField.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				{
					if (window.tryAgainField.getText().equalsIgnoreCase("y")) {
						Workshop9A app = new Workshop9A();
						app.start(primaryStage);
					}
				}
			}
		});

		// Setting title to the stage
		primaryStage.setTitle("Quiz Application");

		// Creating a scene object
		Scene scene = new Scene(window.root, 400, 300);

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();
	}

	public void evalAndStore() {
		int addition = num1 + num2;
		int subtraction = num1 - num2;
		int multiplication = num1 * num2;
		double division = ((double) num1 / (double) num2);

		int userAdd = Integer.parseInt(window.additionField.getText());
		int userSub = Integer.parseInt(window.subtractionField.getText());
		int userMult = Integer.parseInt(window.multiplicationField.getText());
		double userDiv = Double.parseDouble(window.divisionField.getText());
		int correct = 0;
		int wrong = 0;

		if (userAdd == addition) {
			correct++;
		} else {
			wrong++;
		}

		if (userSub == subtraction) {
			correct++;
		} else {
			wrong++;
		}

		if (userMult == multiplication) {
			correct++;
		} else {
			wrong++;
		}

		if (userDiv == division) {
			correct++;
		} else {
			wrong++;
		}

		window.correctAnsLabel.setText(String.valueOf(correct));
		window.wrongAnsLabel.setText(String.valueOf(wrong));

		if (!answers.contains(window.additionField.getText())) {
			answers.add(window.additionField.getText());
		} else {
			window.alreadyAnsweredLabel.setText("You already answered this, try a different answer.");
		}

		if (!answers.contains(window.subtractionField.getText())) {
			answers.add(window.subtractionField.getText());
		} else {
			window.alreadyAnsweredLabel.setText("You already answered this, try a different answer.");
		}

		if (!answers.contains(window.multiplicationField.getText())) {
			answers.add(window.multiplicationField.getText());
		} else {
			window.alreadyAnsweredLabel.setText("You already answered this, try a different answer.");
		}

		if (!answers.contains(window.divisionField.getText())) {
			answers.add(window.divisionField.getText());
		} else {
			window.alreadyAnsweredLabel.setText("You already answered this, try a different answer.");
		}

		System.out.println(answers);

	}

	// Append the fields with the random numbers.
	public void setNumbers() {
		window.randomNumLabel.setText(randomNums);
		window.additionLabel.setText(window.additionLabel.getText() + randomNums + ":");
		window.subtractionLabel.setText(window.subtractionLabel.getText() + randomNums + ":");
		window.multiplicationLabel.setText(window.multiplicationLabel.getText() + randomNums + ":");
		window.divisionLabel.setText(window.divisionLabel.getText() + randomNums + ":");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
