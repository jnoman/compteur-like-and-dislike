package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;


public class Main extends Application {
	
	static int cpt = 0;
	static String icon_like = "greyLike.png";
	static String icon_dislike = "dislikeVide.png";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Label compteur = new Label("- Compteur -");
			compteur.relocate(160, 40);
			compteur.getStyleClass().add("label-compteur");
			root.getChildren().add(compteur);
			
			Label resultat = new Label("Résultat : " + cpt);
			resultat.relocate(200, 160);
			resultat.getStyleClass().add("label-resultat");
			root.getChildren().add(resultat);
			
			
			Button btn_like = new Button("J'AI GAGNE UN POINT");
			btn_like.relocate(40, 200);
			btn_like.getStyleClass().add("button-like");
			setIcon(btn_like, icon_like);
			root.getChildren().add(btn_like);
			
			Button btn_dislike = new Button("J'AI PERDU UN POINT");
			btn_dislike.relocate(260, 200);
			btn_dislike.getStyleClass().add("button-dislike");
			setIcon(btn_dislike, icon_dislike);
			btn_dislike.setDisable(true);
			root.getChildren().add(btn_dislike);
			
			
			
			btn_like.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					if(cpt == 0) {
						btn_dislike.setDisable(false);
					}
					cpt++;
					resultat.setText("Résultat : " + cpt);
					if(icon_like == "greyLike.png") {
						icon_like = "redLike.png";
					} else {
						icon_like = "greyLike.png";
					}
					setIcon(btn_like, icon_like);
				}
			});
			
			btn_dislike.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					cpt--;
					if(cpt == 0) {
						btn_dislike.setDisable(true);
					}
					resultat.setText("Résultat : " + cpt);
					if(icon_dislike == "dislikeVide.png") {
						icon_dislike = "dislike.png";
					} else {
						icon_dislike = "dislikeVide.png";
					}
					setIcon(btn_dislike, icon_dislike);
				}
			});
			
			
			primaryStage.setTitle("Hello javaFX !");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setIcon(Button button, String chemin) {
		button.setGraphic(new ImageView(new Image("file:"+chemin)));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
