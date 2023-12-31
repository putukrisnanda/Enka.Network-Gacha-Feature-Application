package MainClass_GenshinGacha;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

import javax.swing.border.StrokeBorder;

import util.EnkaNetwork_DatabaseManager;
import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class EnkaNetwork_GachaPage implements EventHandler<MouseEvent>{
	Scene gacha_Scene;
	
	private GridPane gp_Gacha, gp_TitleGacha, gp_ButtonGacha, gp_congratulation, 
		gp_ButtonBack, gp_DiamondShop;;
	private BorderPane bp_Gacha;
	
	private Label lbl_GachaTitle, lbl_GachaDescription, lbl_CharacterName, lbl_Congratulation, 
		lbl_CharacterVision, lbl_CharacterValue, lbl_OwnedDiamond;
	
	private Button btn_Gacha, btn_Back, btn_Shop, btn_CheckRolls;;
	
	private Set<String> ObtainCharacter;
	private Map<String, Map<String, Image>> gameImages;
	
	private ImageView characterImageView, iv_Shop;
	private Image img_background, img_Shop;
	private BackgroundImage bg_gacha;

	EnkaNetwork_DatabaseManager connect = EnkaNetwork_DatabaseManager.getInstance();
	EnkaNetwork_MenuPage menuPages = new EnkaNetwork_MenuPage();
	
	private boolean shopPageOpened = false;
	private int btn_gachaClicks = 0;
    private Models_User currentUser;
    
    private HBox hbox_DiamondShop;
    private VBox vbox_DiamondShop;
  
    private MediaPlayer mp_MenuClick, mp_WishEffect;
    
    private int count = 0;
	
private void initialize () {
	String sf_MenuClick = "SoundModels/menu_select.mp3";
	Media sound_MenuClick = new Media(new File(sf_MenuClick).toURI().toString());
	mp_MenuClick = new MediaPlayer(sound_MenuClick);
	
	String sf_WishEffect = "SoundModels/Wish Sound.mp3";
	Media sound_WishEffect = new Media(new File(sf_WishEffect).toURI().toString());
	mp_WishEffect = new MediaPlayer(sound_WishEffect);
	
	
	gp_Gacha = new GridPane ();
	gp_TitleGacha = new GridPane ();
	gp_ButtonGacha = new GridPane ();
	gp_congratulation = new GridPane ();
	gp_ButtonBack = new GridPane ();
	gp_DiamondShop = new GridPane ();
	
	bp_Gacha = new BorderPane ();
	
	lbl_GachaTitle = new Label ("Gacha 🎲");
	lbl_GachaDescription = new Label ("Welcome to the gacha pull page! Here, you can use your "
			+ "hard-earned resources to acquire new characters for your Genshin "
			+ "Impact and Honkai Star Rail journeys.");
	lbl_CharacterName = new Label ();
	lbl_CharacterVision = new Label ();
	lbl_CharacterValue = new Label ();
	lbl_Congratulation = new Label ();
	
	lbl_OwnedDiamond = new Label ();
	
	btn_Gacha = new Button ("Gacha");	
	btn_Back = new Button ("Back");
	btn_Shop = new Button ("Shop");
	btn_CheckRolls = new Button("Check Rolls");
	
	characterImageView = new ImageView();
	ObtainCharacter = new HashSet<>();
	
	hbox_DiamondShop = new HBox ();
	vbox_DiamondShop = new VBox ();
	
	img_background = new Image ("file:shin-w.jpg");
	img_Shop = new Image ("file:IconModels/Cart.png");
	
	iv_Shop = new ImageView (img_Shop);
		iv_Shop.setFitWidth(35);
		iv_Shop.setFitHeight(35);
		
}

private void setLayout () {
// Image Layout
	gp_Gacha.add(characterImageView, 1, 0, 1, 3);
    GridPane.setValignment(characterImageView, VPos.CENTER);
	
// GridPane Layout
	gp_Gacha.setPadding(new Insets(10));
	gp_Gacha.setHgap(10);
	gp_Gacha.setVgap(10);
	gp_Gacha.setAlignment(Pos.CENTER);
	
// Title Layout
	gp_TitleGacha.setPadding(new Insets(3));
	gp_TitleGacha.setHgap(3);
	gp_TitleGacha.setVgap(3);
	gp_TitleGacha.setAlignment(Pos.CENTER);
	
	lbl_GachaTitle.setFont(Font.font("Minecraft", FontWeight.BOLD, 60));
	lbl_GachaTitle.setTextFill(Color.FLORALWHITE);
		lbl_GachaTitle.setPrefSize(300, 30);
		lbl_GachaTitle.setMaxWidth(300);
	
	// Title Gacha
	gp_TitleGacha.add(lbl_GachaTitle, 0, 0);
	gp_TitleGacha.add(lbl_GachaDescription, 0, 1);
		
		lbl_GachaDescription.setFont(new Font("Lato", 18));
		lbl_GachaDescription.setWrapText(true);
			lbl_GachaDescription.setPrefSize(300, 150);
			lbl_GachaDescription.setMaxWidth(300);
				lbl_GachaTitle.setAlignment(Pos.CENTER);
				lbl_GachaDescription.setAlignment(Pos.CENTER);

// Button
	gp_ButtonGacha.setAlignment(Pos.CENTER);
				
	gp_TitleGacha.add(gp_ButtonGacha, 0, 2, 1, 1);
	gp_ButtonGacha.add(btn_Gacha, 0, 0);
		btn_Gacha.setPrefSize(80, 30);
		btn_Gacha.setMaxWidth(80);
	// Button Check Gacha
	btn_CheckRolls.setPrefSize(100, 30);
	btn_CheckRolls.setMaxWidth(100);
		gp_ButtonGacha.add(btn_CheckRolls, 1, 0);
	
	// Button Back Layout
	gp_ButtonBack.setAlignment(Pos.CENTER);	
	gp_ButtonBack.setPadding(new Insets(20));
	gp_ButtonBack.add(btn_Back, 0, 0);
		btn_Back.setPrefSize(80, 30);
		btn_Back.setMaxWidth(600);
		
// Label Layout
	// Character Name
	gp_Gacha.add(lbl_CharacterName, 0, 0);
		lbl_CharacterName.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		lbl_CharacterName.setTextFill(Color.BLACK);
		
	// Character Vision
	gp_Gacha.add(lbl_CharacterVision, 0, 1);
		lbl_CharacterVision.setFont(Font.font("Lato", FontWeight.SEMI_BOLD, 18));
		lbl_CharacterVision.setTextFill(Color.BLACK);
			lbl_CharacterVision.setPrefSize(600, 30);
			lbl_CharacterVision.setMaxWidth(600);

	// Congratulation Message
	gp_Gacha.add(lbl_Congratulation, 0, 2);
	lbl_Congratulation.setFont(Font.font("Lato", FontWeight.SEMI_BOLD, 16));
	lbl_Congratulation.setTextFill(Color.BLACK);
		lbl_Congratulation.setWrapText(true);
			lbl_Congratulation.setPrefSize(600, 60);
			lbl_Congratulation.setMaxWidth(600);
	
	// Character Value
	gp_Gacha.add(lbl_CharacterValue, 0, 3);
	lbl_CharacterValue.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 18));
	lbl_CharacterValue.setTextFill(Color.BLACK);
		lbl_CharacterValue.setPrefSize(600, 30);
		lbl_CharacterValue.setMaxWidth(600);
		
// Background
	bg_gacha = new BackgroundImage(
			img_background,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
			new BackgroundSize(1.0, 1.0, true, true, false, false)
			);
	bp_Gacha.setBackground(new Background(bg_gacha));
	
// Diamond Value
	gp_DiamondShop.setPadding(new Insets(10));
	gp_DiamondShop.setHgap(10);
	gp_DiamondShop.setAlignment(Pos.TOP_LEFT);
	
	gp_DiamondShop.add(btn_Shop, 0, 0);
	gp_DiamondShop.add(lbl_OwnedDiamond, 1, 0);
		btn_Shop.setGraphic(iv_Shop);
		btn_Shop.setContentDisplay(ContentDisplay.CENTER);
		btn_Shop.setStyle("-fx-shape: \"M 15 0 A 15 15 0 1 1 14.49 0 Z\";" +
						"-fx-min-width: 30px; -fx-min-height: 30px; " +
						"-fx-max-width: 30px; -fx-max-height: 30px; " +
						"-fx-background-color: #CCCCCC, #FFFFFF; " +
						"-fx-background-insets: 0, 0;"
						);
// Comic Sans MS
		lbl_OwnedDiamond.setFont(Font.font("Pixel Square", FontWeight.SEMI_BOLD,  20));
		lbl_OwnedDiamond.setTextFill(Color.YELLOWGREEN);
			hbox_DiamondShop.getChildren().add(gp_DiamondShop);
			hbox_DiamondShop.setAlignment(Pos.CENTER_LEFT);
				vbox_DiamondShop.getChildren().addAll(hbox_DiamondShop, gp_TitleGacha);
				vbox_DiamondShop.setAlignment(Pos.TOP_LEFT);

}

private void gachaHandler() {
	btn_Gacha.setOnMouseClicked(event -> {
		if (btn_gachaClicks == 0) {
			if (gacha_Validation(currentUser)) {
				Models_Character character = getRandomCharacter();
				if (character != null) {
					mp_MenuClick.play();
					mp_WishEffect.stop();
					mp_WishEffect.play();
					
					setGachaValidation(currentUser);
					
					btn_Gacha.setDisable(true);
					clearCharacter();
					characterImageView.setImage(null);
					btn_gachaClicks++;

					String imagePath = "file:gifModels/genshin-impact-pull.gif";
					Image img_Wish = new Image(imagePath);	
					
				// Image validation
				if (img_Wish.isError()) {
					System.out.println("Error loading background image. Check the file path.");
					btn_Gacha.setDisable(false);
					return;
					}
				
				BackgroundImage bg_Gacha = new BackgroundImage(
					img_Wish,
					BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.DEFAULT,
					new BackgroundSize(1360, 320, false, false, false, false)
				);
				gp_Gacha.setBackground(new Background(bg_Gacha));
				
				PauseTransition img_Delay = new PauseTransition(Duration.seconds(6.1));
				img_Delay.setOnFinished(e -> {
					gp_Gacha.setBackground(null);
					btn_Gacha.setDisable(false);
					btn_gachaClicks = 0;
					
					displayTransition(character);
					
					
				});
				img_Delay.play();
			
			} else {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Gacha Result");
				alert.setHeaderText("Congratulations! You've already obtained all characters! 🎉");
				alert.setContentText("Please wait for the next update for more additional characters!");
				alert.showAndWait();
				}
		} else {

			}
		}
	});
	
	btn_Shop.setOnMouseClicked(event -> {
		if (!shopPageOpened) {
			EnkaNetwork_ShopPage shopPage = new EnkaNetwork_ShopPage(currentUser, this);
			mp_MenuClick.play();
			shopPage.show();
			shopPage.setResizable(false);
			
			shopPageOpened = true;
		} else {	
			shopPageOpened = false;
		}
	});
	
	btn_CheckRolls.setOnAction(event -> {
	String username = "User";
	
	String query = "SELECT PurchasedGachaCount, GachaCount FROM visitor WHERE Username = '" + username + "'";
	ResultSet rs = connect.execQuery(query);
	
	int maxGacha = 6;
	int performedGacha = 0;
	
	try {
		if (rs.next()) {
			int purchasedGachaCount = rs.getInt("PurchasedGachaCount");
			int gachaCount = rs.getInt("GachaCount");
			
			maxGacha = 6 + purchasedGachaCount;
			performedGacha = gachaCount;
		}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	
	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	alert.setTitle("Check Gacha Rolls");
	alert.setHeaderText("Maximum Gacha Rolls: " + maxGacha);
	alert.setContentText("Available Gacha Rolls  : " + (maxGacha - performedGacha) +
			"\nTotal Gacha Performed : " + performedGacha);
	alert.showAndWait();
	});
	
	btn_Back.setOnAction(event -> {
		mp_MenuClick.play();
		Stage menuStage = new Stage();
		try {
			menuPages.start(menuStage);
		} catch (Exception ex) {
			ex.printStackTrace();
		} Stage currentStage = (Stage) btn_Back.getScene().getWindow();
			currentStage.close();
		});
	}

	protected void updateDiamondValue (int newDiamondCount) {
		lbl_OwnedDiamond.setText("💎 " + newDiamondCount + " Diamonds");
	}
	
	private void getDiamondData () {
		String username = "User";
		
		String diamondQuery = "SELECT DiamondValue FROM Visitor WHERE Username = '" + username + "'";
		ResultSet diamond_rs = connect.execQuery(diamondQuery);
		try {
				int diamondCount = 0; 
				while (diamond_rs.next()) {
				diamondCount += diamond_rs.getInt("DiamondValue");
			}
				lbl_OwnedDiamond.setText("💎 "+diamondCount+" Diamonds");	
			} catch (Exception e) {
				e.printStackTrace();
				}
			}

				private boolean gacha_Validation(Models_User user) {
					String username = "User";
					int maxGacha = 6;
					
					String query = "SELECT LastGachaTimestamp, GachaCount, PurchasedGachaCount FROM visitor "
							+ "WHERE Username = '" + username + "'";
					ResultSet rs = connect.execQuery(query);
					try {
						if (rs.next()) {
							LocalDateTime lastGachaTimestamp = rs.getTimestamp("LastGachaTimestamp").toLocalDateTime();
							int gachaCount = rs.getInt("GachaCount");
							int purchasedGachaCount = rs.getInt("PurchasedGachaCount");
							LocalDateTime currentTimestamp = LocalDateTime.now();
						
						if (lastGachaTimestamp != null) {
							LocalDateTime nextAvailableTime = lastGachaTimestamp.plusMinutes(1);
							
							if (currentTimestamp.isBefore(nextAvailableTime)) {
								maxGacha = 6 + purchasedGachaCount;
								long secondsLeft = java.time.Duration.between(currentTimestamp, nextAvailableTime).getSeconds();
								long minutes = secondsLeft / 60;
								long seconds = secondsLeft % 60;
								if (gachaCount >= maxGacha) {
									String alertMessage = String.format("You've reached the gacha limit for this cooldown period.\n" +
											"Please wait for the cooldown period to perform more gachas.\n" +
											"Time left until next gacha: %d minutes, %d seconds", minutes, seconds);
									timeAlert("Gacha Limit Exceeded", alertMessage, Alert.AlertType.WARNING);
			                    }
								return gachaCount < maxGacha;
								} else {
									String updateQuery = "UPDATE visitor SET GachaCount = 0, LastGachaTimestamp = NOW() WHERE Username = '" + username + "'";
				                    connect.execUpdate(updateQuery);
								}
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return true; 
				}
				
				private void timeAlert(String title, String message, Alert.AlertType alertType) {
				    Alert alert = new Alert(alertType);
				    alert.setTitle(title);
				    alert.setHeaderText(null);
				    alert.setContentText(message);
				    alert.showAndWait();
				}
				
				private void setGachaValidation(Models_User user) {
					String updateQuery = "UPDATE visitor SET GachaCount = GachaCount + 1, LastGachaTimestamp = NOW() WHERE Username = 'User'";
					connect.execUpdate(updateQuery);
				}
		
	private Set<String> validate_character() {
		Set<String> owned_character = new HashSet<>();
		String query = "SELECT OwnedCharacterName FROM OwnedCharacter";
			ResultSet rs = connect.execQuery(query);
			try {
				while (rs.next()) {
					String characterName = rs.getString("OwnedCharacterName");
					owned_character.add(characterName);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return owned_character;
	}

		  	private Models_Character getRandomCharacter() {
		  		Set<String> owned_character = validate_character();
		  		String query = "SELECT * FROM CharacterLore WHERE CharacterName NOT IN " + ObtainableCharacterList(owned_character)
		  				+ " ORDER BY RAND() LIMIT 1";
		  		ResultSet rs = connect.execQuery(query);
		  	try {
		  		if (rs.next()) {
		  			String name = rs.getString("CharacterName");
		  			String vision = rs.getString("CharacterVision");
		  			int value = rs.getInt("CharacterValue");
		  			String imagec = rs.getString("characterImage");
		  			
		  		return new Models_Character(name, vision, "", "", value, imagec);
		  		}
		  		} catch (SQLException e) {
		  			e.printStackTrace();
		  		}
		  		return null;
		  	}
		  	
		  	private String ObtainableCharacterList(Set<String> owned_character) {
		  		if (owned_character.isEmpty()) {
		  			return "('')";
		  			} else {
		  				StringBuilder sb_Gacha = new StringBuilder();
						sb_Gacha.append("('").append(String.join("', '", owned_character)).append("')");
			            return sb_Gacha.toString();
					}
		  		}
	
		private void displayTransition (Models_Character character) {
		// Character Detail
		if (character != null) {
			lbl_CharacterName.setText(character.getName());
			lbl_CharacterVision.setText("Vision: " + character.getVision());
			lbl_Congratulation.setText("Congratulations! " + character.getName() + " is such a popular character, "
									+ "you're going to dominate the game with them! Release their full potential!");
			lbl_CharacterValue.setText("Value: " + character.getValue() + " Diamonds");
			
			String imagePath = character.getImagec();
	        Image characterImage = new Image(imagePath);
	        characterImageView.setImage(characterImage);
	        
	        characterImageView.setFitWidth(450);
	        characterImageView.setFitHeight(350); 
			
			ScaleTransition scaleTransition1 = new ScaleTransition(Duration.seconds(0.3), lbl_CharacterName);
			scaleTransition1.setFromX(3);
			scaleTransition1.setFromY(3);
			scaleTransition1.setToX(1.0);
			scaleTransition1.setToY(1.0);
			scaleTransition1.play();

			ScaleTransition scaleTransition2 = new ScaleTransition(Duration.seconds(0.3), lbl_CharacterVision);
			scaleTransition2.setFromX(3);
			scaleTransition2.setFromY(3);
			scaleTransition2.setToX(1.0);
			scaleTransition2.setToY(1.0);
			scaleTransition2.play();
			
			ScaleTransition scaleTransition3 = new ScaleTransition(Duration.seconds(0.3), lbl_Congratulation);
			scaleTransition3.setFromX(3);
			scaleTransition3.setFromY(3);
			scaleTransition3.setToX(1.0);
			scaleTransition3.setToY(1.0);
			scaleTransition3.play();
			
			ScaleTransition scaleTransition4 = new ScaleTransition(Duration.seconds(0.3), lbl_CharacterValue);
			scaleTransition4.setFromX(3);
			scaleTransition4.setFromY(3);
			scaleTransition4.setToX(1.0);
			scaleTransition4.setToY(1.0);
			scaleTransition4.play();
			
			ScaleTransition scaleTransition5 = new ScaleTransition(Duration.seconds(0.3),  characterImageView);
			scaleTransition5.setFromX(3);
			scaleTransition5.setFromY(3);
			scaleTransition5.setToX(1.0);
			scaleTransition5.setToY(1.0);
			scaleTransition5.play();
			
			btn_gachaClicks = 0;
			ownedCharacter(character);
			
	    } else {
    	Alert alert = new Alert(Alert.AlertType.WARNING);
    	alert.setTitle("Gacha Result");
    	alert.setHeaderText("Congratulations! you've already obtain all character! 🎉");
    	alert.setContentText("");
    	alert.showAndWait();
      	}
		}

	  	private void ownedCharacter (Models_Character character) {
	  	if (character != null) {
	  		ObtainCharacter.add(character.getName());
	  		String insertQuery = "INSERT INTO OwnedCharacter (OwnedCharacterName, OwnedCharacterVision, OwnedCharacterValue) " +
				           "VALUES ('" + character.getName() + "', '" + character.getVision() + "', " + character.getValue() + ")";
	  		connect.execUpdate(insertQuery);	
				}
	  		}
	  		private void clearCharacter() {
	  			lbl_CharacterName.setText("");
	  			lbl_CharacterVision.setText("");
	  			lbl_Congratulation.setText("");
	  			lbl_CharacterValue.setText("");
	  		}
  	
	public EnkaNetwork_GachaPage(Stage MenuStage) {
		initialize ();
		setLayout ();
		gachaHandler();
		getDiamondData();
		
		bp_Gacha.setTop(vbox_DiamondShop);
		bp_Gacha.setCenter(gp_Gacha);
		bp_Gacha.setBottom(gp_ButtonBack);

		gacha_Scene = new Scene (bp_Gacha, 1360, 768);
		
		MenuStage.setTitle("EnkaNetwork.exe");
		MenuStage.setScene(gacha_Scene);
		MenuStage.setResizable(false);
		MenuStage.show();
	}
	

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
