package application;

import javafx.scene.control.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

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
				//nowLoop.setText("Loop: " + (alice.loop ? "On" : "Off"));
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
		
		//Pane buttonPane = new Pane();
		BorderPane buttonPane = new BorderPane();
		VBox column1 = new VBox();
		VBox column2 = new VBox();
		VBox column3 = new VBox();
		column1.getChildren().addAll(add, loop);
		column2.getChildren().addAll(clear, play);
		column3.getChildren().addAll(insert, skip);
		
		//buttonPane.setPrefSize(1200,800);
		
		buttonPane.setLeft(column1);
		buttonPane.setCenter(column2);
		buttonPane.setRight(column3);
		//buttonPane.setPrefSize(570, 300);
		buttonPane.setMinSize(570, 300);
		buttonPane.setMaxSize(570, 300);
		
//		VBox curInfo = new VBox();
//		curInfo.getChildren().addAll(nowPlay, nowLength, nowLoop, nowStatus);
		
		BorderPane mediaPane = new BorderPane();
		mediaPane.setPrefSize(800, 800);
		mediaPane.setBottom(buttonPane);
		alice.ci.mainPane.setAlignment(Pos.CENTER);
		mediaPane.setTop(alice.ci.mainPane);
		mediaPane.setAlignment(buttonPane, Pos.CENTER);
		
		BorderPane root = new BorderPane();
		root.setPrefSize(1200, 800);
		
		root.setLeft(mediaPane);
		root.setRight(alice.qi.mainPane);
		
		Scene scene = new Scene(root);
   		primaryStage.setScene(scene);
   		primaryStage.setResizable(false);
   		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
