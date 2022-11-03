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
	private static LinkedList<File> toPlay;
	private static boolean ifLoop = false;
	public static MediaPlayer mediaPlayer;
	
	@Override
	public void start(Stage primaryStage) {
		//setup the buttons and other elements
		
		Button fileButton = new Button("Open file");
		Button play = new Button("Play");
		Button loop = new Button("Loop");
		
		
		FileChooser fc = new FileChooser();
		Label fileName = new Label("no files selected");
		
		
		toPlay = new LinkedList<File>();
		//____________________________________________________________________________
		//setup the events
		
		EventHandler<ActionEvent> getFile =
		        new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
	        {
	            File file = fc.showOpenDialog(primaryStage);

	            if (file != null) {
	            	toPlay.add(file);
	                fileName.setText(file.getName());
	            }
	        }
		};
		
		EventHandler<ActionEvent> playFile =
		        new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
	        {
				//Media hit = new Media(toPlay.remove().toURI().toString());
				Media hit = new Media("http://www.sovmusic.ru/sam/s12264.mp3");
				mediaPlayer = new MediaPlayer(hit);
				mediaPlayer.play();
	        }
		};
		
		EventHandler<ActionEvent> loopFile =
		        new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
	        {
				if(ifLoop) {
					mediaPlayer.setCycleCount(1);
				}else {
					mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
				}
				ifLoop = !ifLoop;
	        }
		};
		//____________________________________________________________________________
   		//Assign the events
		fileButton.setOnAction(getFile);
		play.setOnAction(playFile);
		loop.setOnAction(loopFile);
		
		//Stage
		BorderPane root = new BorderPane();
		root.setPrefSize(840, 645);
		root.setLeft(fileButton);
		root.setCenter(loop);
		root.setBottom(play);
		
		Scene scene = new Scene(root);
   		primaryStage.setScene(scene);
   		primaryStage.setResizable(false);
   		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
