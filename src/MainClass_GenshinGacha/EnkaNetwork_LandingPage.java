package MainClass_GenshinGacha;

import javafx.util.Duration;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.File;

import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class EnkaNetwork_LandingPage extends Application{
	private Scene scene_Landing;
	private BorderPane bp_Landing;
	private GridPane gp_EnterMessage;
	
	private Label lbl_EnterMessage;
	private Image img_Background;
	private BackgroundImage bg_LandingPage;
	
	private Media sound_LandingOST;
	private MediaPlayer mp_MenuClick, mp_MenuOST;

	private void initialize_Landing () {
		// Menu OST
		String sf_MenuOST= "SoundModels/LandingPageOST.mp3";
		sound_LandingOST = new Media(new File(sf_MenuOST).toURI().toString());
		mp_MenuOST = new MediaPlayer(sound_LandingOST);
		
		play_OST();
		// Button Effect
		String sf_MenuClick = "SoundModels/menu_select.mp3";
		Media sound_MenuClick = new Media(new File(sf_MenuClick).toURI().toString());
		mp_MenuClick = new MediaPlayer(sound_MenuClick);
		
		bp_Landing = new BorderPane ();
		gp_EnterMessage = new GridPane ();
		lbl_EnterMessage = new Label ("Press Enter to Continue...");
		
		img_Background = new Image ("file:GifModels/landingPage.gif");
	}
	
			private void play_OST () {
				mp_MenuOST.setOnEndOfMedia(() -> mp_MenuOST.seek(Duration.ZERO));
				mp_MenuOST.play();
					mp_MenuOST.setCycleCount(MediaPlayer.INDEFINITE);
			}
			
			private void stop_OST() {
				double fadeDuration = 2.0;
				double endVolume = 0.0;
				
				final Timeline timeline = new Timeline(
						new KeyFrame(Duration.seconds(fadeDuration),
								new KeyValue(mp_MenuOST.volumeProperty(), endVolume))
						);
				timeline.setOnFinished(event -> {
					mp_MenuOST.stop();
				});
			timeline.play();
		}
			
	private void setLayout () {
// Background
		bg_LandingPage = new BackgroundImage (
				img_Background,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
			new BackgroundSize(1.0, 1.0, true, true, false, false)
		);
		bp_Landing.setBackground(new Background(bg_LandingPage));
// Label
	gp_EnterMessage.setPadding(new Insets (20));
	gp_EnterMessage.setVgap(10);
	gp_EnterMessage.setAlignment(Pos.CENTER);
	
	gp_EnterMessage.add(lbl_EnterMessage, 0, 0);
		lbl_EnterMessage.setFont(Font.font("Pixel Square", FontWeight.SEMI_BOLD, 20));
		lbl_EnterMessage.setTextFill(Color.WHITE);
	}
	
	private void displayAnimation () {
		FadeTransition fadeInBackground = new FadeTransition(Duration.seconds(2), bp_Landing);
        fadeInBackground.setFromValue(0);
        fadeInBackground.setToValue(1);
        fadeInBackground.play();

        Timeline timeline = new Timeline(
        		new KeyFrame(Duration.seconds(0),
                        new KeyValue(lbl_EnterMessage.opacityProperty(), 0)),
                new KeyFrame(Duration.seconds(2),
                        new KeyValue(lbl_EnterMessage.opacityProperty(), 1)),
                new KeyFrame(Duration.seconds(3),
                        new KeyValue(lbl_EnterMessage.opacityProperty(), 1)),
                new KeyFrame(Duration.seconds(5),
                        new KeyValue(lbl_EnterMessage.opacityProperty(), 0))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
	}
	
	private void eventHandler(Stage LandingStage) {
		bp_Landing.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				mp_MenuClick.play();
				stop_OST();
			try {
				EnkaNetwork_MenuPage menuPage = new EnkaNetwork_MenuPage();
				menuPage.start(new Stage());
				LandingStage.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
	}

	@Override
	public void start(Stage LandingStage) throws Exception {
		initialize_Landing ();
		setLayout ();
		displayAnimation ();
		eventHandler(LandingStage);
		
		bp_Landing.setBottom(gp_EnterMessage);
		
		scene_Landing = new Scene (bp_Landing, 1360, 768);
		
		LandingStage.setTitle("EnkaNetwork.exe");
		LandingStage.setScene(scene_Landing);
		LandingStage.setResizable(false);
		LandingStage.show();
		
		bp_Landing.requestFocus();
	}
	
	public static void main(String[] args) {
		launch (args);
		}
}
