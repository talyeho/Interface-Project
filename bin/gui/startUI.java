package gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class startUI extends Application {

	public static void main( String args[] ) throws Exception
	   { 
		    launch(args);  
	   } // end main
	 
	@Override
	public void start(Stage primaryStage) throws Exception {
		mainFrameController aFrame = new mainFrameController();
		aFrame.start(primaryStage);
	}
}