package MainClass_GenshinGacha;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import util.EnkaNetwork_DatabaseManager;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import MainClass_GenshinGacha.Models_Character;

public class EnkaNetwork_OwnedCharacterPage implements EventHandler<MouseEvent> {
	private Scene owned_Scene;
	
	private BorderPane bp_OwnedCharacter;
	private GridPane gp_OwnedCharacter, gp_TitleLayout, gp_TableView, 
		gp_CharacterValue, gp_SellButton, gp_BackButton, gp_DiamondValue;
	
	private Label lbl_OwnedPageTitle, lbl_CharacterName, 
		lbl_CharacterVision, lbl_CharacterValue, lbl_ObtainMessage,
		lbl_ValueDiamond;
	
	private Button btn_Sell, btn_Back;
	
	private TableView<Models_OwnedCharacter> tv_OwnedCharacter;
	private Alert sell_Validation, owned_Validation;
	
	private EnkaNetwork_DatabaseManager connect = EnkaNetwork_DatabaseManager.getInstance();
	private EnkaNetwork_MenuPage menuPages = new EnkaNetwork_MenuPage();
	
	private Image img_Background;
	private BackgroundImage bg_Owned;
	
	private void initialize () {
		img_Background = new Image ("file:GifModels/OwnedPage.gif");
		
		bp_OwnedCharacter = new BorderPane ();
		
		gp_OwnedCharacter = new GridPane ();
		gp_TitleLayout = new GridPane ();
		gp_TableView = new GridPane ();
		gp_CharacterValue = new GridPane ();
		gp_SellButton = new GridPane ();
		gp_BackButton = new GridPane ();
		gp_DiamondValue = new GridPane ();
		
		lbl_OwnedPageTitle = new Label ("Owned Character");
		lbl_ObtainMessage = new Label ("Your Character Overview");
		lbl_CharacterName = new Label ();
		lbl_CharacterVision = new Label ();
		lbl_CharacterValue = new Label ();
		lbl_ValueDiamond = new Label ();
		
		btn_Sell = new Button ("Sell");
		btn_Back = new Button ("Back");
			btn_Back.setOnAction(event -> {
				Stage menuStage = new Stage();
				try {
					menuPages.start(menuStage);
				} catch (Exception ex) {
					ex.printStackTrace();
				} Stage currentStage = (Stage) btn_Back.getScene().getWindow();
				currentStage.close();
			});
		
		tv_OwnedCharacter = new TableView<>();
	}
	
	private void setLayout () {
// Image Background
		bg_Owned = new BackgroundImage(
				img_Background,
					BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.DEFAULT,
				new BackgroundSize(1.0, 1.0, true, true, false, false)
			);
			bp_OwnedCharacter.setBackground(new Background(bg_Owned));

// GridPane Layout
	gp_OwnedCharacter.setPadding(new Insets(10));
	gp_OwnedCharacter.setHgap(10);
	gp_OwnedCharacter.setVgap(10);
	gp_OwnedCharacter.setAlignment(Pos.CENTER);
	
// Title Label Layout
	gp_TitleLayout.setPadding(new Insets(10));
	gp_TitleLayout.setHgap(10);
	gp_TitleLayout.setVgap(10);
	gp_TitleLayout.setAlignment(Pos.CENTER);
	
	lbl_OwnedPageTitle.setFont(Font.font("Minecraft", FontWeight.BOLD, 20));
	lbl_OwnedPageTitle.setTextFill(javafx.scene.paint.Color.WHITE);
	// Title Layout
	gp_TitleLayout.add(lbl_OwnedPageTitle, 0, 0, 1, 1);
		lbl_OwnedPageTitle.setPrefSize(300, 30);
		lbl_OwnedPageTitle.setMaxWidth(300);
			lbl_OwnedPageTitle.setAlignment(Pos.CENTER);

	// Table Layout
	gp_TableView.setPadding(new Insets(5));
	gp_TableView.setHgap(5);
	gp_TableView.setVgap(5);
	gp_TableView.setAlignment(Pos.CENTER);	
		
	tv_OwnedCharacter.setPadding(new Insets (5));
		gp_TitleLayout.add(gp_TableView, 0, 1, 1, 1);
		gp_TableView.add(tv_OwnedCharacter, 0, 0);
	
	// Diamond Earn Value
	gp_DiamondValue.setPadding(new Insets(5));
	gp_DiamondValue.setHgap(5);
	gp_DiamondValue.setVgap(5);
	gp_DiamondValue.setAlignment(Pos.CENTER);	
	
		gp_TitleLayout.add(gp_DiamondValue, 0, 2, 1, 1);
		gp_DiamondValue.add(lbl_ValueDiamond, 0, 0);
				lbl_ValueDiamond.setPrefSize(300, 30);
				lbl_ValueDiamond.setMaxWidth(300);
	
// Owned Character Description Layout
	gp_OwnedCharacter.add(lbl_ObtainMessage, 0, 0);
	gp_OwnedCharacter.add(lbl_CharacterName, 0, 1);
	gp_OwnedCharacter.add(lbl_CharacterVision, 0, 2);
	// Value Layout
		gp_OwnedCharacter.add(gp_CharacterValue, 0, 3, 1, 1);
		gp_CharacterValue.add(lbl_CharacterValue, 0, 0);
		
		lbl_ValueDiamond.setFont(Font.font("Pixel Square", FontWeight.BOLD, 20));
		lbl_ValueDiamond.setTextFill(javafx.scene.paint.Color.WHITE);
			lbl_ValueDiamond.setPrefSize(300, 30);
			lbl_ValueDiamond.setMaxWidth(300);
				lbl_ValueDiamond.setAlignment(Pos.CENTER);
		// Label Design
			// Obtain Message
			lbl_ObtainMessage.setFont(Font.font("Lato", FontWeight.SEMI_BOLD, 18));
			lbl_ObtainMessage.setTextFill(javafx.scene.paint.Color.WHITE);
				lbl_ObtainMessage.setPrefSize(300, 20);
				lbl_ObtainMessage.setMaxWidth(300);
					lbl_ObtainMessage.setAlignment(Pos.CENTER);
			
			// Character Name
			lbl_CharacterName.setFont(Font.font("Impact", 22));
			lbl_CharacterName.setTextFill(javafx.scene.paint.Color.WHITE);
				lbl_CharacterName.setPrefSize(300, 30);
				lbl_CharacterName.setMaxWidth(300);
			
			// Character Vision
			lbl_CharacterVision.setFont(Font.font("Lato", 16));
			lbl_CharacterVision.setTextFill(javafx.scene.paint.Color.WHITE);
				lbl_CharacterVision.setPrefSize(300, 30);
				lbl_CharacterVision.setMaxWidth(300);
				
			// Character Value
			lbl_CharacterValue.setFont(Font.font("Lato",FontWeight.BOLD, 16));
			lbl_CharacterValue.setTextFill(javafx.scene.paint.Color.WHITE);
				lbl_CharacterValue.setPrefSize(300, 20);
				lbl_CharacterValue.setMaxWidth(300);
	
// Button Layout
	gp_SellButton.setPadding(new Insets(10));
	gp_SellButton.setHgap(10);
	gp_SellButton.setVgap(10);
	gp_SellButton.setAlignment(Pos.CENTER);
	
	gp_OwnedCharacter.add(gp_SellButton, 0, 4, 1, 1);
	gp_SellButton.add(btn_Sell, 0, 0);
	// Back Button Layout
		gp_BackButton.setPadding(new Insets(10));
		gp_BackButton.setHgap(10);
		gp_BackButton.setVgap(10);
		gp_BackButton.setAlignment(Pos.CENTER);

		btn_Sell.setPrefSize(150, 30);
		btn_Sell.setMaxWidth(600);
		
		gp_BackButton.add(btn_Back, 0, 0);
			btn_Back.setPrefSize(80, 30);
			btn_Back.setMaxWidth(600);
		
	}
	
	private void setTable () {
	TableColumn <Models_OwnedCharacter, String> col_CharacterName = new TableColumn<>("Owned Character");
	col_CharacterName.setCellValueFactory(new PropertyValueFactory<>("name"));
	col_CharacterName.setMinWidth(250);
	
	tv_OwnedCharacter.getColumns().addAll(col_CharacterName);
	
		tv_OwnedCharacter.setOnMouseClicked(event -> {
			Models_OwnedCharacter selectedCharacter = tv_OwnedCharacter.getSelectionModel().getSelectedItem();
			if (selectedCharacter != null) {
				displayOwnedCharacter(selectedCharacter);
				btn_Sell.setDisable(false);
			} else { 
				btn_Sell.setDisable(true);
			}
		});
	}
	
	private void displayOwnedCharacter (Models_OwnedCharacter ownedCharacter) {
	String name = ownedCharacter.getName();
	String vision = ownedCharacter.getVision();
	int value = ownedCharacter.getValue();
		
		lbl_CharacterName.setText(name);
		lbl_CharacterVision.setText("Vision : "+vision);
		lbl_CharacterValue.setText("Value : "+String.valueOf(value)+" Diamonds");
		
		btn_Sell.setOnAction(event -> {
			sell_Validation = new Alert(Alert.AlertType.CONFIRMATION);
			sell_Validation.setTitle("Confirmation");
			sell_Validation.setHeaderText("Confirm Selling Character");
			sell_Validation.setContentText("Are you sure you want to sell "+ownedCharacter.getName()+"?");
			
			Optional<ButtonType> result = sell_Validation.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				String selectedName = ownedCharacter.getName();
				
				String deleteQuery = "DELETE FROM OwnedCharacter WHERE OwnedCharacterName = '" + selectedName + "'";
				connect.execUpdate(deleteQuery);
				
				int diamondCount = 0;
				ResultSet diamond_rs = connect.execQuery("SELECT DiamondValue FROM Visitor");
				
				try {
					while (diamond_rs.next())
						diamondCount += diamond_rs.getInt("DiamondValue");
					
					tv_OwnedCharacter.getItems().remove(ownedCharacter);
					
					int diamondValue = diamondCount + value;
					String query = "UPDATE Visitor SET DiamondValue = " + diamondValue;
					connect.execUpdate(query);
					
					getDiamondData();
				
				lbl_CharacterName.setText("");
				lbl_CharacterVision.setText("");
				lbl_CharacterValue.setText("");
				btn_Sell.setDisable(true);
					 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
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
	lbl_ValueDiamond.setText("💎 : "+diamondCount+" Diamonds");	
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	private void getData () {
	String query = "SELECT * FROM OwnedCharacter";
		ResultSet rs = connect.execQuery(query);
	
		try {
			while(rs.next()) {
				String name = rs.getString("OwnedCharacterName");
				String vision = rs.getString("OwnedCharacterVision");
				int value = rs.getInt("OwnedCharacterValue");
				
				tv_OwnedCharacter.getItems().add(new Models_OwnedCharacter(name, vision, value));
				}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	
	private EnkaNetwork_MenuPage menuPage;
	public EnkaNetwork_OwnedCharacterPage(Stage MenuStage, EnkaNetwork_MenuPage menuPage) {
		initialize ();
		setLayout ();
		setTable ();
		getData();
		getDiamondData();
		
		this.menuPage = menuPage;
		
		bp_OwnedCharacter.setTop(gp_TitleLayout);
		bp_OwnedCharacter.setBottom(gp_BackButton);
		bp_OwnedCharacter.setCenter(gp_OwnedCharacter);
		
		owned_Scene = new Scene (bp_OwnedCharacter, 1360, 768);

		MenuStage.setTitle("EnkaNetwork.exe");
		MenuStage.setScene(owned_Scene);
		MenuStage.setResizable(false);
		MenuStage.show();
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
