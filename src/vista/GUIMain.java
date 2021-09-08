package vista;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GUIMain extends Application {

	public static Stage mainStage;
	public static Scene mainScene;
	public static Label mainLabel;
	Scene  accionesGUI = new Acciones().getMainAccionesGUIMain();

	@Override
	public void start(Stage mainStage) throws Exception {
		GUIMain.mainStage = mainStage;
		mainStage.setTitle("SuperEnvios");

		// SALUDO INICIAL SuperEnvios
		VBox mainLeft = new VBox();
		Label bienvenidaLabel = new Label("Bienvenido(a) de devuelta a SuperEnvios");
		bienvenidaLabel.setWrapText(true);
		bienvenidaLabel.setPrefSize(450, 200);
		bienvenidaLabel.setFont(new Font("Arial", 25));
		bienvenidaLabel.setTextFill(Color.web("#FFF"));
		bienvenidaLabel.setTextAlignment(TextAlignment.CENTER);
		bienvenidaLabel.setStyle("-fx-background-color: #18944c;");
		mainLeft.setPadding(new Insets(10, 15, 10, 15));
		mainLeft.setSpacing(10);
		mainLeft.setPrefSize(460, 500);

		// IMAGENES SuperEnvios Y BOTÓN INCIO FUNCIONALIDADES
		BorderPane imagenesSE = new BorderPane();
		Button btnStart = new Button("Empezar");
		btnStart.setOnAction(new Eventos());
		btnStart.setPadding(new Insets(10, 10, 10, 10));
		Image imagen = new Image(getClass().getResourceAsStream("./Imagenes/SuperEnvios.jpg"), 350, 250, false, false);
		mainLabel = new Label("", new ImageView(imagen));
		BorderPane.setAlignment(mainLabel, Pos.TOP_CENTER);
		BorderPane.setAlignment(btnStart, Pos.TOP_CENTER);
		imagenesSE.setTop(mainLabel);
		imagenesSE.setOnMouseEntered(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent e) {
		        Image SEImagen1 = new Image(getClass().getResourceAsStream("./Imagenes/SE1.jpg"), 350, 250, false, false);
		        Image SEImagen2 = new Image(getClass().getResourceAsStream("./Imagenes/SE2.jpg"), 350, 250, false, false);
		        Image SEImagen3 = new Image(getClass().getResourceAsStream("./Imagenes/SE3.jpg"), 350, 250, false, false);
		        Image SEImagen4 = new Image(getClass().getResourceAsStream("./Imagenes/SE4.png"), 350, 250, false, false);
		        Image[] SEImagenes = { imagen, SEImagen1, SEImagen2, SEImagen3, SEImagen4 };
		        int imagenNum = (int) (Math.random() * 4 + 1);

		        if (mainLabel.getGraphic() == null) {
		            mainLabel.setText("");
		            mainLabel.setGraphic(new ImageView(imagen));
		        }

		        if (!mainLabel.getGraphic().equals(SEImagenes[imagenNum])) {
		            mainLabel.setGraphic(new ImageView(SEImagenes[imagenNum]));
		        }

		    }
		});
		mainLeft.setStyle("-fx-background-color: #04843c;");
		imagenesSE.setStyle("-fx-background-color:#04843c;");
		imagenesSE.setBottom(btnStart);
		mainLeft.getChildren().addAll(bienvenidaLabel, imagenesSE);

		// BIOGRAFÍA
		VBox mainRight = new VBox();
		mainRight.setSpacing(10);
		mainRight.setPadding(new Insets(10, 15, 10, 15));
		mainRight.setPrefSize(460, 500);
		mainRight.setStyle("-fx-background-color: #04843c;");
		Label hojaVidaLabel = new Label();
		hojaVidaLabel.setTextFill(Color.web("#FFF"));
		hojaVidaLabel.setTextAlignment(TextAlignment.CENTER);
		hojaVidaLabel.setStyle("-fx-background-color: #18944c;");
		hojaVidaLabel.setText("Hoja de vida de los colaboradores");
		hojaVidaLabel.setPrefSize(450, 164);
		hojaVidaLabel.setWrapText(true);
		hojaVidaLabel.setFont(new Font("Arial", 25));
		hojaVidaLabel.setPadding(new Insets(0, 20, 0, 20));
		mainRight.getChildren().add(hojaVidaLabel);

		// IMÁGENES GRIDPANE
		GridPane imagenesGridPane = new GridPane();
		imagenesGridPane.setStyle("-fx-background-color:#04843c;");
		imagenesGridPane.setVgap(5);
		imagenesGridPane.setHgap(5);
		Image imagenGridPane1 = new Image(getClass().getResourceAsStream("./Imagenes/SE1.jpg"), 187.5, 150, false,
				false);
		Label imagenLabel1 = new Label("", new ImageView(imagenGridPane1));
		Image imagenGridPane2 = new Image(getClass().getResourceAsStream("./Imagenes/SE2.jpg"), 187.5, 150, false,
				false);
		Label imagenLabel2 = new Label("", new ImageView(imagenGridPane2));
		Image imagenGridPane3 = new Image(getClass().getResourceAsStream("./Imagenes/SE3.jpg"), 187.5, 150, false,
				false);
		Label imagenLabel3 = new Label("", new ImageView(imagenGridPane3));
		Image imagenGridPane4 = new Image(getClass().getResourceAsStream("./Imagenes/SE4.png"), 187.5, 150, false,
				false);
		Label imagenLabel4 = new Label("", new ImageView(imagenGridPane4));
		imagenesGridPane.add(imagenLabel1, 0, 0);
		imagenesGridPane.add(imagenLabel2, 1, 0);
		imagenesGridPane.add(imagenLabel3, 0, 1);
		imagenesGridPane.add(imagenLabel4, 1, 1);
		imagenesGridPane.setAlignment(Pos.CENTER);
		mainRight.getChildren().add(imagenesGridPane);
		
		mainRight.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e) {
				boolean expandido;
				expandido = e.getClickCount() == 2;
				String hvDavid = ""
						+ "\t\t\t\tHoja de vida\n"
						+  (!expandido ? "\t\tDoble click aquí para expandir\n" : "\t\t\tClick aquí para contraer\n")
						+ "\nNombre: David Alejandro Ruiz González"
						+ "\nCorreo: drruizg@unal.edu.co\n"
						+ "\nOcupación: Estudiante de Ciencas de la Computación en la U.N."
						+ "\nPersona apacionada por las matemáticas y su relación con la criptografía, me gusta leer, hacer deporte y desarrollar aplicaciones web.";
				hojaVidaLabel.setText(hvDavid);
				hojaVidaLabel.setFont(new Font("Times New Roman", 18));
				hojaVidaLabel.setTextAlignment(TextAlignment.JUSTIFY);
				hojaVidaLabel.setTextFill(Color.web("#FFF"));
				hojaVidaLabel.setPrefSize(450, 300);
				Image imagenGridPane1 = new Image(getClass().getResourceAsStream("./Imagenes/SEDavid1.jpg"), 187.5, 150, false,
						false);
				Label imagenLabel1 = new Label("", new ImageView(imagenGridPane1));
				Image imagenGridPane2 = new Image(getClass().getResourceAsStream("./Imagenes/SEDavid2.png"), 187.5, 150, false,
						false);
				Label imagenLabel2 = new Label("", new ImageView(imagenGridPane2));
				Image imagenGridPane3 = new Image(getClass().getResourceAsStream("./Imagenes/SEDavid3.jpg"), 187.5, 150, false,
						false);
				Label imagenLabel3 = new Label("", new ImageView(imagenGridPane3));
				Image imagenGridPane4 = new Image(getClass().getResourceAsStream("./Imagenes/SEDavid4.jpg"), 187.5, 150, false,
						false);
				Label imagenLabel4 = new Label("", new ImageView(imagenGridPane4));
				imagenesGridPane.add(imagenLabel1, 0, 0);
				imagenesGridPane.add(imagenLabel2, 1, 0);
				imagenesGridPane.add(imagenLabel3, 0, 1);
				imagenesGridPane.add(imagenLabel4, 1, 1);
				imagenesGridPane.setAlignment(Pos.CENTER);
				if (expandido) imagenesGridPane.getChildren().clear();
			}
		});

		// CONFIGURACIÓN VENTANA PRINCIPAL
		BorderPane mainWindow = new BorderPane();
		MenuBar mainMenuBar = new MenuBar();
		Menu mainInicio = new Menu("Inicio");
		mainMenuBar.getMenus().add(mainInicio);
		mainWindow.setTop(mainMenuBar);
		mainWindow.setStyle("-fx-background-color: #04843c;"); // Color de fondo principal
		MenuItem exit = new MenuItem("Salir");
		exit.setOnAction(new Eventos());
		MenuItem about = new MenuItem("Descripción");
		about.setOnAction(new Eventos());
		SeparatorMenuItem separatorMenuLine = new SeparatorMenuItem();
		mainInicio.getItems().addAll(about, separatorMenuLine, exit);
		mainWindow.setLeft(mainLeft);
		mainWindow.setRight(mainRight);

		// INICIO
		mainScene = new Scene(mainWindow, 1024, 600);
		mainStage.setResizable(false);
		mainStage.setScene(mainScene);
		mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	class Eventos implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Object control = e.getSource();
			if (control instanceof MenuItem) {
				if (((MenuItem) control).getText().equals("Salir")) {
					Platform.exit();
				} else if (((MenuItem) control).getText().equals("Descripción")) {
					mainLabel.setText(
							"¡Bienvenido(a) a SuperEnvios, donde todo es posible!"
							+ "\n\nEsta aplicación te permitirá gestionar todo lo relacionado"
							+ "\ncon envio, recepción y restreo de encomiendas de tu localidad."
							+ "\nTambién puedes administrar tu negocio de manera fácil de segura"
							+ " por medio de una sección a la que sólo puedes acceder si eres"
							+ " administrador o tienes permisos suficientes."
							+ "\n\n¡Muchas gracias por elegirnos!"
							+ "\n\nNota: Al pasar el mouse por aquí volverás a ver las imágenes"
							);
					mainLabel.setGraphic(null);
					mainLabel.setWrapText(true);
					mainLabel.setTextAlignment(TextAlignment.JUSTIFY);
					mainLabel.setTextFill(Color.web("#FFF"));
					Font tipoletra = new Font("Arial", 15);
					mainLabel.setFont(tipoletra);
				}
			} else if (control instanceof Button) {
				if (((Button) control).getText().equals("Empezar")) {
					GUIMain.mainStage.setScene(accionesGUI);
				}
			}
		}
	}
}
