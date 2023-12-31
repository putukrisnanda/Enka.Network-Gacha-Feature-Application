package MainClass_GenshinGacha;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.stage.Stage;

import java.io.File;

public class EnkaNetwork_MenuPage extends Application {
	private Scene scene_Menu;
	
	private BorderPane bp_Menu;
	private GridPane gp_Menu, gp_Copyright;
	
	private Label lbl_Copyrigt, lbl_nama1, lbl_nama2, lbl_nama3;
	
	private Button btn_CharacterLore, btn_GachaCharacter, btn_OwnedCharacter;
	private ToggleButton tgl_Volume;
	
	private Image img_Title, icon_SoundOn, icon_SoundOff, backgroundImage;
	private ImageView iv_Home, icon_Sound;
	private BackgroundImage bg_Menu;
	
	private StackPane imageContainer;
	
	private VBox vbox_Button, vbox_CenterAlignment;
	private HBox vlm_Box;
	
	private Media sound_MenuOST;
	private MediaPlayer mp_MenuOST, mp_MenuHover, mp_MenuClick;
	
	int diamondPoints = 0;

	void initialize_Menu () {
// Background music
	String sf_MenuOST = "SoundModels/Genshin-OST.mp3";
	sound_MenuOST = new Media(new File(sf_MenuOST).toURI().toString());
	mp_MenuOST = new MediaPlayer(sound_MenuOST);
		play_OST ();
		// Button hover sound effect
		String sf_MenuHover = "SoundModels/sound.mp3";
			Media sound_MenuHover = new Media(new File(sf_MenuHover).toURI().toString());
			mp_MenuHover = new MediaPlayer(sound_MenuHover);
			// Button click sound effect
			String sf_MenuClick = "SoundModels/menu_select.mp3";
				Media sound_MenuClick = new Media(new File(sf_MenuClick).toURI().toString());
				mp_MenuClick = new MediaPlayer(sound_MenuClick);
		
	bp_Menu = new BorderPane ();
	
	gp_Menu = new GridPane ();
	gp_Copyright = new GridPane ();
	
	lbl_Copyrigt = new Label ("Created By :");
	lbl_nama1 = new Label ("Fatecha Rizqi Putra");
	lbl_nama2 = new Label ("Muhammad Afif Kamali");
	lbl_nama3 = new Label ("Putu Krisnanda");
	// Change Color
		lbl_Outline(lbl_Copyrigt, "white", "black", 1.5);
		lbl_Outline(lbl_nama1, "white", "black", 1.5);
		lbl_Outline(lbl_nama2, "white", "black", 1.5);
		lbl_Outline(lbl_nama3, "white", "black", 1.5);
	
	btn_CharacterLore = new Button ("Character Lore");
	btn_GachaCharacter = new Button ("Gacha");
	btn_OwnedCharacter = new Button ("Owned Character");
	// Animation
		button_effect(btn_CharacterLore);
		button_effect(btn_GachaCharacter);
		button_effect(btn_OwnedCharacter);
	
	tgl_Volume = new ToggleButton ("");
// Images
	img_Title = new Image("file:Enka.network.transparent.png");
	icon_SoundOn = new Image ("file:IconModels/Sound On.png");
	icon_SoundOff = new Image ("file:IconModels/Sound Off.png");
	// Image view
		icon_Sound = new ImageView(icon_SoundOn);
		icon_Sound.setFitWidth(25);
		icon_Sound.setFitHeight(25);
		
	backgroundImage = new Image("file:GifModels/genshin-impact-enkanomiya.gif");
	
	iv_Home = new ImageView(img_Title);
	
	imageContainer = new StackPane(iv_Home);
	
	vbox_Button = new VBox (10);
	vbox_CenterAlignment = new VBox (20);
	
	vlm_Box = new HBox(tgl_Volume);
	}
	  
	void layout_Menu () {
// Image Layout
	iv_Home.setFitWidth(450);
	iv_Home.setFitHeight(150);	
	
	bg_Menu = new BackgroundImage(
		backgroundImage,
			BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.DEFAULT,
		new BackgroundSize(1.0, 1.0, true, true, false, false)
	);
	bp_Menu.setBackground(new Background(bg_Menu));
	// Title Image Layout
	imageContainer.setAlignment(Pos.CENTER);
			iv_Home.setFitWidth(450);
			iv_Home.setFitHeight(150);
	
// GridPane Layout
	gp_Menu.setPadding(new Insets(10));
	gp_Menu.setHgap(10);
	gp_Menu.setVgap(10);
	gp_Menu.setAlignment(Pos.CENTER);
	
// Button Layout
	gp_Menu.add(btn_CharacterLore, 0, 1);
	gp_Menu.add(btn_GachaCharacter, 0, 2);
	gp_Menu.add(btn_OwnedCharacter, 0, 3);
		btn_CharacterLore.setPrefSize(400, 30);
		btn_CharacterLore.setMaxWidth(400);
			btn_GachaCharacter.setPrefSize(400, 30);
			btn_GachaCharacter.setMaxWidth(400);
				btn_OwnedCharacter.setPrefSize(400, 30);
				btn_OwnedCharacter.setMaxWidth(400);
	// Button Alignment
		vbox_Button.getChildren().addAll(btn_CharacterLore, btn_GachaCharacter, 
					btn_OwnedCharacter);
		vbox_Button.setAlignment(Pos.CENTER);
	// Toggle Button Layout
		tgl_Volume.setGraphic(icon_Sound);
			tgl_Volume.setStyle(
					 "-fx-shape: \"M 12.5 0 A 12.5 12.5 0 1 1 12.49 0 Z\";" +
							 	"-fx-min-width: 25px; -fx-min-height: 25px; " +
							 	"-fx-max-width: 25px; -fx-max-height: 25px; " +
							 	"-fx-background-color: #CCCCCC, #FFFFFF; "
		                        );
		
		tgl_Volume.setSelected(true);
		tgl_Volume.setOnAction(event -> {
			if (tgl_Volume.isSelected()) {
				mp_MenuOST.setVolume(1.0);
				icon_Sound.setImage(icon_SoundOn);
			} else {
				mp_MenuOST.setVolume(0.0);
				icon_Sound.setImage(icon_SoundOff);
			}	
		});

// CopyRight Label
	gp_Copyright.setPadding(new Insets(10));
	gp_Copyright.setHgap(5);
	gp_Copyright.setVgap(5);
	gp_Copyright.setAlignment(Pos.CENTER);	
	
	// Copyright Detail	
		gp_Copyright.add(lbl_Copyrigt, 0, 0);
		gp_Copyright.add(lbl_nama1, 0, 1);
		gp_Copyright.add(lbl_nama2, 0, 2);
		gp_Copyright.add(lbl_nama3, 0, 3);
		// Size Label
			lbl_Copyrigt.setPrefSize(220, 0);
			lbl_nama1.setPrefSize(220, 0);
			lbl_nama2.setPrefSize(220, 0);
			lbl_nama3.setPrefSize(220, 0);
			// Label Layout
			lbl_Copyrigt.setAlignment(Pos.CENTER);
			lbl_nama1.setAlignment(Pos.CENTER);
			lbl_nama2.setAlignment(Pos.CENTER);
			lbl_nama3.setAlignment(Pos.CENTER);

// VBox Layout
	vbox_CenterAlignment.getChildren().addAll(imageContainer, vbox_Button);
	vbox_CenterAlignment.setAlignment(Pos.CENTER);
	
		gp_Menu.add(vbox_CenterAlignment, 0, 1);

// HBox Layout
	vlm_Box.setAlignment(Pos.CENTER_LEFT);
	vlm_Box.setPadding(new Insets(10));
	
	}
	
	private void eventHandler (Stage MenuStage) {
		btn_CharacterLore.setOnMouseClicked(event -> {
			new EnkaNetwork_CharacterLorePage(MenuStage);
			mp_MenuClick.play();
				transition_OST();
		});
		
		btn_GachaCharacter.setOnMouseClicked(event -> {
			new EnkaNetwork_GachaPage(MenuStage);
			mp_MenuClick.play();
				transition_OST();
		});
		
		btn_OwnedCharacter.setOnMouseClicked(event -> {
			new EnkaNetwork_OwnedCharacterPage(MenuStage, this);
			mp_MenuClick.play();
				transition_OST();
		});
	}
	
	private void lbl_Outline (Label lbl, String text_Color, String outline_Color, double outline_Width) {
		lbl.setStyle(
	    	"-fx-text-fill: " + text_Color + "; " +
	    	"-fx-font-weight: bold; " + 
	    	"-fx-effect: dropshadow(one-pass-box, " 
	    		+ outline_Color + ", " + outline_Width + ", 0, 0, 0);"
	    );
	}
	
	private void button_effect (Button button) {
	ScaleTransition scale_Button = new ScaleTransition(Duration.millis(200), button);
		button.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
			scale_Button.setToX(1.1);
			scale_Button.setToY(1.1);
			scale_Button.play();
			btn_SoundEffect();

	for (Node node_Scale : button.getParent().getChildrenUnmodifiable()) {
		if (node_Scale instanceof Button && node_Scale != button) {
			ScaleTransition transition_Button = new ScaleTransition(Duration.millis(200), node_Scale);
				transition_Button.setToX(1.0);
				transition_Button.setToY(1.0);
				transition_Button.play();
				btn_SoundEffect();
				}
			}
		});
		button.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
			scale_Button.setToX(1.0);
			scale_Button.setToY(1.0);
			scale_Button.play();
			btn_SoundEffect();
		});
		scale_Button.setAutoReverse(true);
	}
	
	private void play_OST () {
		mp_MenuOST.setOnEndOfMedia(() -> mp_MenuOST.seek(Duration.ZERO));
		mp_MenuOST.play();
			mp_MenuOST.setCycleCount(MediaPlayer.INDEFINITE);
	}
	
	private void stop_OST () {
		mp_MenuOST.stop();
	}
	
	private void btn_SoundEffect () {
		mp_MenuHover.seek(mp_MenuHover.getStartTime());
		mp_MenuHover.play();
	}
	
	private void transition_OST () {
		mp_MenuOST.setVolume(1.0);
		
		final double fadeDuration = 2.0;
		final double endVolume = 0.0;
		
		final Timeline timeline = new Timeline(
			new KeyFrame(Duration.seconds(fadeDuration),
					new KeyValue(mp_MenuOST.volumeProperty(), endVolume))
		);
		timeline.setOnFinished(event -> mp_MenuOST.stop());
		timeline.play();
	}
	
	@Override
	public void start(Stage MenuStage) throws Exception {
		initialize_Menu ();
		layout_Menu();
		
		eventHandler(MenuStage);
		
		bp_Menu.setTop(vlm_Box);
		bp_Menu.setCenter(gp_Menu);
		bp_Menu.setBottom(gp_Copyright);
		
		BorderPane.setAlignment(vlm_Box, Pos.TOP_LEFT);
		
		scene_Menu = new Scene (bp_Menu, 1360, 768);
		
		MenuStage.setOnCloseRequest(event -> stop_OST());
		
		MenuStage.setTitle("EnkaNetwork.exe");
		MenuStage.setScene(scene_Menu);
		MenuStage.setResizable(false);
		MenuStage.show();
	}
	
public static void main(String[] args) {
	launch (args);
	}
}
