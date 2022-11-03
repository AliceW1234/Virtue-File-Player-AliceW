package application;

import javafx.scene.control.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



import java.io.*;
import java.util.*;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		//setup the buttons and other elements
		
		Button add = new Button("Open file");
		Button clear = new Button("Clear");
		Button insert = new Button("Insert");
		Button loop = new Button("Loop");
		Button play = new Button("Play/Pause");
		Button skip = new Button("Skip");
		
		FileChooser fc = new FileChooser();
		Alice alice = new Alice();
		QueueInfo qi = new QueueInfo();
		
		Label nowPlay = new Label("no files selected");
		Label nowLength = new Label("Length: 0:00");
		Label nowLoop = new Label("Loop: off");
		Label nowStatus = new Label("Statues: pause");
		
		//____________________________________________________________________________
		//setup the events
		
		EventHandler<ActionEvent> addFile =
		        new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
	        { 
				File file = fc.showOpenDialog(primaryStage);

				if (file != null) {
					alice.add(file);
				}
	        }
		};
		
		EventHandler<ActionEvent> clearFile =
		        new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
	        {
				alice.clear();
	        }
		};
		
		EventHandler<ActionEvent> insertFile =
		        new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
	        {
				File file = fc.showOpenDialog(primaryStage);

				if (file != null) {
					alice.insert(file);
				}
	        }
		};
		
		EventHandler<ActionEvent> loopFile =
				new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				alice.loop();
			}
		};
		
		EventHandler<ActionEvent> playFile =
		        new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
	        {
				alice.play();
	        }
		};
		
		EventHandler<ActionEvent> skipFile =
		        new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
	        {
				alice.skip();
	        }
		};
		
		//____________________________________________________________________________
   		//Assign the events
		add.setOnAction(addFile);
		clear.setOnAction(clearFile);
		insert.setOnAction(insertFile);
		loop.setOnAction(loopFile);
		play.setOnAction(playFile);
		skip.setOnAction(skipFile);
		//____________________________________________________________________________
		//Stage
		add.setPrefSize(190, 150);
		clear.setPrefSize(190, 150);
		insert.setPrefSize(190, 150);
		loop.setPrefSize(190, 150);
		play.setPrefSize(190, 150);
		skip.setPrefSize(190, 150);
		
		
		BorderPane mediaPane = new BorderPane();
		mediaPane.setPrefSize(800, 800);
		
		BorderPane root = new BorderPane();
		root.setPrefSize(1200, 800);
		
		root.setLeft(mediaPane);
		root.setRight(qi.mainPane);
		
		Scene scene = new Scene(root);
   		primaryStage.setScene(scene);
   		primaryStage.setResizable(false);
   		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
