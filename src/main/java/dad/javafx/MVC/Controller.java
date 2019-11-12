package dad.javafx.MVC;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {

	private Calculadora calculadora = new Calculadora();

	// MODEL

	private StringProperty numero = new SimpleStringProperty();

	// VIEW
	@FXML
	private GridPane view;

	@FXML
	private TextField operadoresText;

	@FXML
	private Button ceButton, cButton, restButton, comaButton, sumButton, multiButton, divButton, resultButton;

	@FXML
	private List<Button> buttonsList;

	public Controller() throws IOException {

		FXMLLoader cargadorVista = new FXMLLoader(getClass().getResource("/FXML/calculadoraViewFXML.fxml"));
		cargadorVista.setController(this);
		cargadorVista.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		operadoresText.textProperty().bind(numero);

		// Recogida de numeros

		for (Button button : buttonsList) {

			button.setOnAction(event -> onNumberAction(button.getText()));

		}

		// Funciones de los botones

		ceButton.setOnAction(event -> onSeleccionAction(ceButton.getText()));
		cButton.setOnAction(event -> onSeleccionAction(cButton.getText()));
		restButton.setOnAction(event -> onSeleccionAction(restButton.getText()));
		sumButton.setOnAction(event -> onSeleccionAction(sumButton.getText()));
		multiButton.setOnAction(event -> onSeleccionAction(multiButton.getText()));
		divButton.setOnAction(event -> onSeleccionAction(divButton.getText()));
		comaButton.setOnAction(event -> onSeleccionAction(comaButton.getText()));
		resultButton.setOnAction(event -> onSeleccionAction(resultButton.getText()));

	}

	private void onSeleccionAction(String text) {

		switch (text) {
		case "+":
			calculadora.operar(text.charAt(0));
			break;
		case "-":
			calculadora.operar(text.charAt(0));
			break;
		case "*":
			calculadora.operar(text.charAt(0));
			break;
		case "/":
			calculadora.operar(text.charAt(0));
			break;
		case "=":
			calculadora.operar(text.charAt(0));
			break;
		case ".":
			calculadora.insertarComa();
			break;
		case "C":
			calculadora.borrar();
			break;
		case "CE":
			calculadora.borrarTodo();
			break;
		}
		
		numero.set(calculadora.getPantalla());

	}

	private void onNumberAction(String text) {

		calculadora.insertar(text.charAt(0));
		numero.set(calculadora.getPantalla());

	}
	
	public GridPane getView() {
		return view;
	}

}
