package vista;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import vista.AdminGUI.ModificarSalario;

public class Administrar {

	public static VBox base = new VBox(20);
	public MenuBar mainMenuBarActions = new MenuBar();;
	public static Label mainTitle;
	public static Label about;
	public static Scene mainWindowActions = new Scene(base, 800, 600);

	public void mainAccionesGUIMain() {

		Menu archivo = new Menu("Archivo");
		MenuItem salir = new MenuItem("Salir");
		MenuItem regresar = new MenuItem("Regresar");
		archivo.getItems().addAll(regresar, salir);

		Menu procesos = new Menu("Empleado");
		MenuItem fun1 = new MenuItem("Ver informacion");
		fun1.setOnAction(new Eventos());
		MenuItem fun2 = new MenuItem("Modificar salario");
		fun2.setOnAction(new Eventos());
		MenuItem fun3 = new MenuItem("Modificar contrato");
		fun3.setOnAction(new Eventos());
		MenuItem fun4 = new MenuItem("Contratar");
		fun4.setOnAction(new Eventos());

		procesos.getItems().addAll(fun1, fun2, fun3, fun4);

		Menu ayuda = new Menu("Ayuda");
		MenuItem acerca = new MenuItem("Acerca de");
		ayuda.getItems().add(acerca);
		mainMenuBarActions.getMenus().addAll(archivo, procesos, ayuda);

		mainTitle = new Label("Administrador");
		Font tipoletraTit = new Font("Times New Roman", 30);
		mainTitle.setFont(tipoletraTit);
		mainTitle.setTextFill(Color.web("#FFF"));
		mainTitle.setTextAlignment(TextAlignment.CENTER);

		about = new Label("Administra tu negocio de SuperEnvios desde las opciones de la barra de menús");
		Font tipoletraTex = new Font("Times New Roman", 18);
		about.setFont(tipoletraTex);
		about.setTextFill(Color.web("#FFF"));
		about.setWrapText(true);
		about.setTextAlignment(TextAlignment.CENTER);

		Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/SuperEnvios.jpg"), 450, 350, false, false);
		Label label = new Label("", new ImageView(imagen));
		base.getChildren().addAll(mainMenuBarActions, mainTitle, about, label);
		base.setStyle("-fx-background-color: #04843c;");
		base.setAlignment(Pos.TOP_CENTER);
	}

	public Scene getMainAccionesGUIMain() {
		mainAccionesGUIMain();
		return mainWindowActions;
	}
	
	class Eventos implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			MenuItem seleccion = (MenuItem) e.getSource();
			if (seleccion.getText().equals("Ver informacion")) {
				Administrar.mainTitle.setText(("Información del empleado actual"));
				Administrar.about.setText("A continuación encontrará de forma detallada la información del empleado contratado actualmente");
				TextArea info = new TextArea();
				info.setWrapText(true);
				info.setText("AQUÍ VA LA INFO");
				info.setEditable(false);
				info.setPrefSize(50,150);
				Administrar.base.getChildren().add(info);
				Administrar.base.getChildren().remove(3);
				VBox.setMargin(Administrar.base.getChildren().get(3), new Insets(10,10,10,10));
			}
		}
	}
}
