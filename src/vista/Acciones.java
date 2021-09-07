package vista;

import java.util.Optional;

import javafx.application.Application;
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

public class Acciones {

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

		Menu procesos = new Menu("Procesos y consultas");
		MenuItem fun1 = new MenuItem("Administrar");
		fun1.setOnAction(new Eventos());
		MenuItem fun2 = new MenuItem("Realizar Envio");
		MenuItem fun3 = new MenuItem("Rastrear o ver detalles de envío");
		MenuItem fun4 = new MenuItem("Historial de envíos realizados");

		procesos.getItems().addAll(fun1, fun2, fun3, fun4);

		Menu ayuda = new Menu("Ayuda");
		MenuItem acerca = new MenuItem("Acerca de");
		ayuda.getItems().add(acerca);
		mainMenuBarActions.getMenus().addAll(archivo, procesos, ayuda);

		mainTitle = new Label("SuperEnvios");
		Font tipoletraTit = new Font("Times New Roman", 30);
		mainTitle.setFont(tipoletraTit);
		mainTitle.setTextFill(Color.web("#FFF"));
		mainTitle.setTextAlignment(TextAlignment.CENTER);

		about = new Label("Utiliza las opciones de la barra de menús");
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
}

class Eventos implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		MenuItem accion = (MenuItem) e.getSource();

		if (accion.getText().equals("Administrar")) {
			TextInputDialog dialog = new TextInputDialog("Contraseña");
			dialog.setContentText("Ingresa la contraseña del admin:");
			String pwd = "12345";
			Optional<String> result;
			result = dialog.showAndWait();
			if (result.isPresent()) {
				String res = result.get();
				if (pwd.equals(res)) {
					GUIMain.mainStage.setScene(new Administrar().getMainAccionesGUIMain());
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Contraseña incorrecta");
					alert.showAndWait();
				}
			}
		}
	}
}
