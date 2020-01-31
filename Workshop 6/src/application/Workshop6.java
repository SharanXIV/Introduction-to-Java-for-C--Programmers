package application;

import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Workshop6 extends Application {
	public AddressBook window = new AddressBook();
	static final String FILEPATH = "addressBook.txt";
	int record = 0;
	int firstName = 15;
	int lastName = 15;
	int city = 20;
	int province = 2;
	int postalCode = 6;

	@Override
	public void start(Stage primaryStage) {

		// Create event handlers
		window.buttonAdd.setOnAction(e -> {
			try {
				add();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		window.buttonFirst.setOnAction(e -> {
			try {
				first();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		window.buttonNext.setOnAction(e -> {
			try {
				next();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		window.buttonPrev.setOnAction(e -> {
			try {
				prev();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		window.buttonLast.setOnAction(e -> {
			try {
				last();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		window.buttonUpd.setOnAction(e -> {
			try {
				update();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		// Setting title to the stage
		primaryStage.setTitle("Address Book");

		// Creating a scene object
		Scene scene = new Scene(window.root, 550, 200);

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();
	}

	public void add() throws IOException {
		RandomAccessFile file = new RandomAccessFile(FILEPATH, "rw");
		file.seek(file.length());
		write(file);
	}

	public void first() throws IOException {
		RandomAccessFile file = new RandomAccessFile(FILEPATH, "rw");
		file.seek(0);
		read(file);
		record = 1;
	}

	public void next() throws IOException {
		RandomAccessFile file = new RandomAccessFile(FILEPATH, "rw");
		file.seek(record * 58);
		read(file);
		record++;
	}

	public void prev() throws IOException {
		RandomAccessFile file = new RandomAccessFile(FILEPATH, "rw");

		if (record > 1) {
			record--;
		} else {
			record = 1;
		}

		file.seek((record * 58) - 58);
		read(file);
	}

	public void last() throws IOException {
		RandomAccessFile file = new RandomAccessFile(FILEPATH, "rw");
		record = (int) file.length() / 58;
		file.seek((record * 58) - 58);
		read(file);
	}

	public void update() throws IOException {
		RandomAccessFile file = new RandomAccessFile(FILEPATH, "rw");
		file.seek((record * 58) - 58);
		write(file);
	}

	// Writes to the file from the fields.
	public void write(RandomAccessFile file) throws IOException {
		file.write(fixedBytes(window.fNameField.getText().getBytes(), firstName));
		file.write(fixedBytes(window.lNameField.getText().getBytes(), lastName));
		file.write(fixedBytes(window.cityField.getText().getBytes(), city));
		file.write(fixedBytes(((String)window.provChoiceBox.getValue()).getBytes(),province));
		file.write(fixedBytes(window.pcField.getText().getBytes(), postalCode));
	}

	// Reads from the file and sets the appropriate fields.
	public void read(RandomAccessFile file) throws IOException {
		int pos;
		byte[] firstNameB = new byte[firstName];
		pos = file.read(firstNameB);
		window.fNameField.setText(new String(firstNameB));
		
		byte[] lastNameB = new byte[lastName];
		pos += file.read(lastNameB);
		window.lNameField.setText(new String(lastNameB));
		
		byte[] cityB = new byte[city];
		pos += file.read(cityB);
		window.cityField.setText(new String(cityB));
		
		byte[] provinceB = new byte[province];
		pos += file.read(provinceB);
		window.provChoiceBox.setValue(new String(provinceB));

		byte[] pcB = new byte[postalCode];
		pos += file.read(pcB);
		window.pcField.setText(new String(pcB));
		
	}

	// Ensures only fixed length of bytes, truncates remainder.
	public byte[] fixedBytes(byte[] bytes, int x) {
		byte[] f = new byte[x];

		// Copy into new byte array.
		for (int i = 0; i < bytes.length; i++) {
			f[i] = bytes[i];
		}

		return f;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
