package application;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.text.Font;

import java.io.*;
import java.util.*;

public class CurInfo {
	Label loop, name, length, status;
	VBox mainPane;
	
	void loop(boolean l) {
		this.loop.setText("Loop: " + (l ? "on" : "off"));
	}
	
	void updateNewFile(File f){
		this.name.setText("Now play: " + f.getName());
		this.length.setText("Length: " + (new Media(f.toURI().toString())).getDuration().toSeconds() + "s");
	}

	void updateNewStatus(boolean playing) {
		this.status.setText("Statues: " + (playing ? "paused" : "playing"));
	}
	
	void clear() {
		this.name.setText("no files selected");
		this.length.setText("Length: 0:00");
		this.loop.setText("Loop: off");
		this.status.setText("Statues: paused");
	}
	
	public CurInfo() {
		this.name = new Label("no files selected");
		this.length = new Label("Length: 0:00");
		this.loop = new Label("Loop: off");
		this.status = new Label("Statues: paused");
		
		this.name.setFont(Font.font("Cambria", 26));
		this.length.setFont(Font.font("Cambria", 26));
		this.loop.setFont(Font.font("Cambria", 26));
		this.status.setFont(Font.font("Cambria", 26));
		
		mainPane = new VBox();
		mainPane.setPrefSize(100, 100);
		
		mainPane.getChildren().add(this.loop);
		mainPane.getChildren().add(this.name);
		mainPane.getChildren().add(this.length);
		mainPane.getChildren().add(this.status);
	}
}
