package application;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;

import java.util.*;
import java.io.*;

public class QueuePane {
	ScrollPane mainPane;
	VBox vbox;
	
	void update(LinkedList<File> list) {
		vbox = new VBox(); 
		vbox.setPrefSize(210, 645);
		
		int cnt = 1;
		for(File f : list) {
			vbox.getChildren().add(getLabel((cnt++) + ". " + f.getName()));
		}
	}
	
	Label getLabel(String name) {
		Label l = new Label(name);
		l.setPrefSize(210, 100);
		return l;
	}
	
	public QueuePane() {
		this.mainPane = new ScrollPane();
		this.vbox = new VBox();
		
		vbox.setPrefSize(210, 645);
		mainPane.setContent(vbox);
		mainPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	}
}