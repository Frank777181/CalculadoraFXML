package dad.javafx.calculadoraFXML;

import dad.javafx.MVC.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraFXML extends Application {
	
	Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new Controller();
		
		Scene scene = new Scene(controller.getView());
		primaryStage.setTitle("CalculadoraFXML");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}

	public static void main(String[] args) {
		launch(args);

	}

}