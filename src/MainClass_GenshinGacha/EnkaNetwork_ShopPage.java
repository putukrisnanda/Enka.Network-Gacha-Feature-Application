package MainClass_GenshinGacha;

import javafx.stage.Stage;
import util.EnkaNetwork_DatabaseManager;

//import java.awt.font.*;
//import java.awt.FontFormatException;
//import java.awt.GraphicsEnvironment;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnkaNetwork_ShopPage extends Stage {
	private Scene shop_Scene;
	
	private BorderPane bp_Shop;
	private GridPane gp_Shop, gp_ShopTitle, gp_Button;
	
	private Label lbl_ShopTitle, lbl_OwnedDiamond, lbl_ShopDescription;
	
	private Button btn_Rolls;
	private Models_User currentUser;
	private Image img_Background;
	private BackgroundImage bg_Shop;
	
	EnkaNetwork_DatabaseManager connect = EnkaNetwork_DatabaseManager.getInstance();
	
	int btnClick = 0;

private void initialize_Shop() {
	bp_Shop = new BorderPane ();
	
	gp_Shop = new GridPane ();
	gp_Button = new GridPane ();
	gp_ShopTitle = new GridPane ();
	
	lbl_ShopTitle = new Label("SHOP");
	lbl_OwnedDiamond = new Label ();
	
	lbl_ShopDescription = new Label("You can add perks from the diamonds you have to add new benefits!");
	
	btn_Rolls = new Button ("+1 Gacha");
	
	img_Background = new Image ("file:BackgroundModels/shopBackground.jpg");
}

private void setLayout() {
// Background
	bg_Shop = new BackgroundImage(
			img_Background,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
			new BackgroundSize(1.0, 1.0, true, true, false, false)
			);
	bp_Shop.setBackground(new Background(bg_Shop));
	
// GridPane Layout
	gp_Shop.setPadding(new Insets(10));
	gp_Shop.setVgap(10);
	gp_Shop.setAlignment(Pos.CENTER);
	
	gp_ShopTitle.setAlignment(Pos.CENTER);

// Label Layout
	gp_Shop.add(lbl_OwnedDiamond, 0, 0);
	gp_Shop.add(lbl_ShopDescription, 0, 2);
		lbl_ShopDescription.setWrapText(true);
		lbl_OwnedDiamond.setFont(Font.font("Pixel Square", 15));
			lbl_OwnedDiamond.setTextFill(Color.DARKGREEN);
		lbl_ShopTitle.setFont(Font.font("Minecraft", FontWeight.EXTRA_LIGHT, 50));
	
	gp_Shop.add(gp_ShopTitle, 0, 1, 1, 1);
	gp_ShopTitle.add(lbl_ShopTitle, 0, 1);

// Button Layout
	gp_Button.setPadding(new Insets (30));
	gp_Button.setAlignment(Pos.CENTER);
	
	gp_Button.add(btn_Rolls, 0, 0);
		btn_Rolls.setPrefSize(150, 30);
}	
		
		private int getDiamondData () {
			String username = "User";
			
			String diamondQuery = "SELECT DiamondValue FROM Visitor WHERE Username = '" + username + "'";
		    ResultSet diamond_rs = connect.execQuery(diamondQuery);
			try {
			
				int diamondCount = 0; 
				while (diamond_rs.next()) {
					diamondCount += diamond_rs.getInt("DiamondValue");
			}
			lbl_OwnedDiamond.setText("💎 "+diamondCount+" Diamonds");	
			return diamondCount;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return 0;
		}
			
		private void increaseGachaRolls(Models_User user) {	
			String username = "User";
			int maxPurchase = 14;
			
			String query = "SELECT PurchasedGachaCount FROM visitor WHERE Username = '" + username + "'";
		    ResultSet rs = connect.execQuery(query);
			try {
				if (rs.next()) {
					int currentPurchase = rs.getInt("PurchasedGachaCount");
						if (currentPurchase < maxPurchase) {
							String updateQuery = "UPDATE visitor SET PurchasedGachaCount = PurchasedGachaCount + 1 WHERE Username = '" + username + "'";
							connect.execUpdate(updateQuery);
					} else {
						Alert alert = new Alert(Alert.AlertType.WARNING);
		                alert.setTitle("Maximum Purchases Reached");
		                alert.setHeaderText("You've reached the maximum number of purchases for gacha rolls.");
		                alert.setContentText("You cannot purchase more rolls at this time.");
		                alert.showAndWait();
					}
				}
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		
private void eventHandler () {
	btn_Rolls.setOnAction(event -> {
		int diamondCost = 1500;
        int diamondOwned = getDiamondData();


		if (diamondOwned >= diamondCost) {	
			int diamondCount = diamondOwned - diamondCost;
			String username = "User"; 
			
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmation");
				alert.setHeaderText("Confirm Purchase");
				alert.setContentText("Are you sure you want to use 💎" + diamondCost + " Diamonds for +1 gacha roll?");

					ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
					ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
					
					alert.getButtonTypes().setAll(yesButton, noButton);
						alert.showAndWait().ifPresent(buttonType -> {

				if (buttonType == yesButton) {
					String query = "UPDATE Visitor SET DiamondValue = " + diamondCount + " WHERE Username = '" + username + "'";
					connect.execUpdate(query);
					
					increaseGachaRolls(currentUser);
					gachaPage.updateDiamondValue(diamondCount);
					getDiamondData();
					}
				});
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Insufficient Diamonds");
			alert.setHeaderText("You don't have enough Diamonds to make this purchase.");
			alert.setContentText("Please acquire more Diamonds.");
			alert.showAndWait();
        }
    });
}

private EnkaNetwork_GachaPage gachaPage;

	public EnkaNetwork_ShopPage (Models_User user, EnkaNetwork_GachaPage gachaPage) {
	initialize_Shop();
	setLayout();
	eventHandler ();
	getDiamondData ();
	
	this.currentUser = user;
	this.gachaPage = gachaPage;
	
	bp_Shop.setTop(gp_Shop);
	bp_Shop.setBottom(gp_Button);
		
	shop_Scene = new Scene (bp_Shop, 260, 350);
	setScene (shop_Scene);
	}

}
