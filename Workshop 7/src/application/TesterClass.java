package application;

import javafx.application.Application;

public abstract class TesterClass extends Application {

	public void build(String[] args) {
		Main x = new Main();
		x.build(args);
	}
}