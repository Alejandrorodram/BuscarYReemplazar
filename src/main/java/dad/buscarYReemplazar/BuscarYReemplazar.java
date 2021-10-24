package dad.buscarYReemplazar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;

public class BuscarYReemplazar extends Application{
	private TextField textBuscar;
	private TextField textReemplazarCon;
	private Button buttonBuscar;
	private Button buttonReemplazar;
	private Button buttonReemplazarTodo;
	private Button buttonCerrar;
	private Button buttonAyuda;
	private CheckBox checkMayusMinus;
	private CheckBox checkExpresionRegular;
	private CheckBox checkBuscarHaciaAtrás;
	private CheckBox checkResaltarResultados;
	private Label espacio;

	@Override
	public void start(Stage primaryStage) throws Exception {

		textBuscar = new TextField();
		textReemplazarCon = new TextField();

		espacio = new Label("");

		checkMayusMinus = new CheckBox("Mayúsculas y minúsculas");
		checkExpresionRegular = new CheckBox("Expresion Regular");
		checkBuscarHaciaAtrás = new CheckBox("Buscar hacia átras");
		checkResaltarResultados = new CheckBox("Resaltar resultados");
		buttonBuscar = new Button("Buscar");
		buttonReemplazar = new Button("Reemplazar");
		buttonReemplazarTodo = new Button("Reemplazar todo");
		buttonCerrar = new Button("Cerrar");
		buttonAyuda = new Button("Ayuda");
		
		buttonBuscar.setMinWidth(110);
		buttonReemplazar.setMinWidth(110);
		buttonReemplazarTodo.setMinWidth(110);
		buttonCerrar.setMinWidth(110);
		buttonAyuda.setMinWidth(110);

		VBox vBox1 = new VBox(5, buttonBuscar, buttonReemplazar, buttonReemplazarTodo, buttonCerrar, buttonAyuda);
		
		GridPane checkBoxes = new GridPane();
		checkBoxes.setHgap(10);
		checkBoxes.setVgap(5);
		checkBoxes.addRow(0, checkMayusMinus, checkBuscarHaciaAtrás);
		checkBoxes.addRow(1, checkExpresionRegular, checkResaltarResultados);
		
		GridPane root = new GridPane();
		root.setHgap(3);
		root.setVgap(6);
		root.addRow(0, new Label("Buscar: "), textBuscar);
		root.addRow(1, new Label("Reemplazar con: "), textReemplazarCon);
		root.addRow(2, espacio, checkBoxes);

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints(), };
		root.getColumnConstraints().setAll(cols);
		cols[0].setHalignment(HPos.LEFT);
		cols[0].setFillWidth(true);
		cols[1].setHalignment(HPos.CENTER);
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setFillWidth(true);

		BorderPane entirePane = new BorderPane();
		entirePane.setRight(vBox1);
		entirePane.setCenter(root);

		BorderPane.setAlignment(root, Pos.CENTER);
		BorderPane.setAlignment(vBox1, Pos.TOP_LEFT);

		Scene scene = new Scene(entirePane, 640, 480);
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
