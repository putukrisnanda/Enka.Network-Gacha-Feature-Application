package MainClass_GenshinGacha;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.EnkaNetwork_DatabaseManager;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import MainClass_GenshinGacha.Models_Character;

public class EnkaNetwork_CharacterLorePage implements EventHandler<MouseEvent>{
	private Scene lore_Scene;
	private BorderPane bp_CharacterLore;
	private GridPane gp_CharacterLore, gp_CharacterName, gp_LoreTitle, gp_CharacterValue, gp_TableView, gp_ButtonBack;
	
	private Button btn_Back;
	
	private Label lbl_LoreTitle, lbl_CharacterName, lbl_CharacterVision, lbl_CharacterConstelation, 
		lbl_CharacterDescription, lbl_CharacterValue;
	
	TableView <Models_Character> tv_Character;
	
	private Image img_Background;
	private BackgroundImage bg_CharacterLore;
	
	EnkaNetwork_DatabaseManager connect = EnkaNetwork_DatabaseManager.getInstance();
	EnkaNetwork_MenuPage menuPages = new EnkaNetwork_MenuPage();
	
	private void initialize () {
	bp_CharacterLore = new BorderPane ();
	
	gp_TableView = new GridPane ();
	gp_LoreTitle = new GridPane ();
	gp_CharacterLore = new GridPane ();
	gp_CharacterName = new GridPane ();
	gp_CharacterValue = new GridPane ();
	gp_LoreTitle = new GridPane ();
	gp_ButtonBack = new GridPane();
	
	lbl_LoreTitle = new Label ("Character Lore 🎭");
	lbl_CharacterName = new Label ();
	lbl_CharacterVision = new Label ();
	lbl_CharacterConstelation = new Label ();
	lbl_CharacterDescription = new Label ();
	lbl_CharacterValue = new Label ();
	
	tv_Character = new TableView<>();
	
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
	
	img_Background = new Image ("file:test.gif");
// character-lore
	}
	
	private void setTable() {
	TableColumn <Models_Character, String> col_CharacterName = new TableColumn<>("Character Name");
	col_CharacterName.setCellValueFactory(new PropertyValueFactory<>("name"));
	col_CharacterName.setPrefWidth(330);
	
	tv_Character.getColumns().addAll(col_CharacterName);
	tv_Character.setPrefWidth(350);
	tv_Character.setPrefHeight(250);
	
	tv_Character.getColumns().forEach(column -> {
        column.setResizable(false);
    });
	
	  tv_Character.setOnMouseClicked(event -> {
	        Models_Character selectedCharacter = tv_Character.getSelectionModel().getSelectedItem();
	        if (selectedCharacter != null) {
	            displayCharacterData(selectedCharacter);
	        }
	    });
	}
	
	private void setLayout () {
// Background Layout
	bg_CharacterLore = new BackgroundImage (
		img_Background,
		BackgroundRepeat.NO_REPEAT,
		BackgroundRepeat.NO_REPEAT,
		BackgroundPosition.DEFAULT,
	new BackgroundSize(1.0, 1.0, true, true, false, false)
	);
	bp_CharacterLore.setBackground(new Background(bg_CharacterLore));
	
// GridPane Layout
	gp_CharacterLore.setPadding(new Insets(10));
	gp_CharacterLore.setHgap(10);
	gp_CharacterLore.setVgap(10);
	gp_CharacterLore.setAlignment(Pos.CENTER);

// Title Label Layout
	gp_LoreTitle.setPadding(new Insets(10));
	gp_LoreTitle.setHgap(10);
	gp_LoreTitle.setVgap(10);
	gp_LoreTitle.setAlignment(Pos.CENTER);
	
	lbl_LoreTitle.setFont(new Font("Arial", 31));
	// Character Name
		gp_LoreTitle.add(lbl_LoreTitle, 0, 1);
		lbl_LoreTitle.setPrefSize(300, 30);
		lbl_LoreTitle.setMaxWidth(300);
			lbl_LoreTitle.setAlignment(Pos.CENTER);

// Table View Layout
	tv_Character.setPadding(new Insets(10));
	
	gp_LoreTitle.add(gp_TableView, 0, 2, 1, 1); 
	gp_TableView.add(tv_Character, 0, 0);
		gp_TableView.setAlignment(Pos.CENTER);
	
//Table view Layout
	gp_CharacterLore.add(lbl_CharacterName, 0, 0);
	gp_CharacterLore.add(lbl_CharacterVision, 0, 1);
	gp_CharacterLore.add(lbl_CharacterConstelation, 0, 2);
	gp_CharacterLore.add(lbl_CharacterDescription, 0, 3);
	gp_CharacterLore.add(lbl_CharacterValue, 0, 4);

// Label Design
	lbl_CharacterDescription.setWrapText(true);
	// Character Name
	lbl_CharacterName.setFont(new Font("Arial", 30));
		lbl_CharacterName.setPrefSize(600, 30);
		lbl_CharacterName.setMaxWidth(600);
		
	// Character Vision
	lbl_CharacterVision.setFont(new Font("Arial", 18));
		lbl_CharacterVision.setPrefSize(600, 30);
		lbl_CharacterVision.setMaxWidth(600);
		
	// Character Constellation
	lbl_CharacterConstelation.setFont(Font.font("Lato", 
				FontWeight.SEMI_BOLD, 18));
		lbl_CharacterConstelation.setPrefSize(600, 30);
		lbl_CharacterConstelation.setMaxWidth(600);
		
	// Character Description
	lbl_CharacterDescription.setFont(Font.font("Arial", 
				FontWeight.MEDIUM, 15));
		lbl_CharacterDescription.setPrefSize(600, 600);
		lbl_CharacterDescription.setMaxWidth(600);
		
	// Character Value
	lbl_CharacterValue.setFont(new Font("Arial", 18));
		lbl_CharacterValue.setPrefSize(600, 30);
		lbl_CharacterValue.setMaxWidth(600);
			lbl_Color(lbl_CharacterValue, "white");

// Button	
	gp_LoreTitle.add(gp_ButtonBack, 0, 0, 1, 1);	
		
	gp_ButtonBack.setPadding(new Insets(10));
	gp_ButtonBack.setHgap(10);
	gp_ButtonBack.setVgap(10);
	gp_ButtonBack.setAlignment(Pos.CENTER);
	
	gp_ButtonBack.add(btn_Back, 0, 0);
		btn_Back.setPrefSize(80, 30);
		btn_Back.setMaxWidth(600);
	}
	
	private void getData () {
		String query = "SELECT * FROM Characterlore";
		ResultSet rs = connect.execQuery(query);
		
			try {
				while(rs.next()) {
					
					String name = rs.getString("CharacterName");
					String vision = rs.getString("CharacterVision");
					String constelation = rs.getString("CharacterConstelation");
					String description = rs.getString("CharacterDescription");
					int value = rs.getInt("CharacterValue");
					String imagec = rs.getString("characterImage");
					
					tv_Character.getItems().add
					(new Models_Character(name, vision, constelation, description, value, imagec));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}

private void displayCharacterData (Models_Character character) {
	String name = character.getName();
	String vision = character.getVision();
	String constelation = character.getConstelation();
	String description = character.getDescription();
	int value = character.getValue();
	
	lbl_CharacterName.setText(name);
    lbl_CharacterVision.setText("Vision : "+vision);
	lbl_CharacterConstelation.setText("Constellation : "+constelation);
	lbl_CharacterDescription.setText(description);
	lbl_CharacterValue.setText("Value : "+String.valueOf(value)+" Diamonds");
}

private void lbl_Color (Label lbl, String text_Color) {
	lbl.setStyle(
    	"-fx-text-fill: " + text_Color + "; " +
    	"-fx-font-weight: bold;;"
    );
}
	
public EnkaNetwork_CharacterLorePage (Stage MenuStage) {
	initialize ();
	setTable ();
	setLayout ();
	getData ();
	
	bp_CharacterLore.setTop(gp_LoreTitle);
	bp_CharacterLore.setCenter(gp_CharacterLore);
	bp_CharacterLore.setBottom(gp_ButtonBack);
	
lore_Scene = new Scene (bp_CharacterLore, 1360, 768);

MenuStage.setTitle("EnkaNetwork.exe");
MenuStage.setScene(lore_Scene);
MenuStage.setResizable(false);
MenuStage.show();
}

	@Override
	public void handle(MouseEvent arg0) {
	}

}
