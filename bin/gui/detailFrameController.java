package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.Item;

public class detailFrameController {

	@FXML
	private Text textDishName;

	@FXML
	private Button retButton;

	@FXML
	private Text descriptionText;

	@FXML
	private VBox itemVbox = new VBox();

	private mainFrameController home;

	public void setItemDetails(Item item, VBox dishes) throws FileNotFoundException {
		itemVbox.getChildren().clear();
		dishes.setAlignment(Pos.BOTTOM_RIGHT);
		for (Node temp : dishes.getChildren())
			System.out.println(temp);
		textDishName.setText("-" + item.getCategory() + "-\n" + item.getName());
		textDishName.setFont(Font.font("Arial Rounded MT Bold", FontWeight.BOLD, 30));
		textDishName.setTextAlignment(TextAlignment.CENTER);
		Text ingridiant = new Text();
		Text description = new Text();
		ingridiant.setTextAlignment(TextAlignment.CENTER);
		ingridiant.setText((item.getIngrediants().equals("") ? "" : "• Ingrediants: ") + item.getIngrediants());
		ingridiant.setFont(Font.font("Ariel", 20));
		description.setTextAlignment(TextAlignment.CENTER);
		description.setText("• Description: " + item.getDescription());
		description.setFont(Font.font("Ariel", 20));
		itemVbox.getChildren().addAll(textDishName, getVBox(item), description, ingridiant, retButton);
		itemVbox.setAlignment(Pos.CENTER);

	}

	private VBox getVBox(Item item) throws FileNotFoundException {
		InputStream stream;
		stream = new FileInputStream("C:\\images\\" + item.getPhoto());

		Image logo = new Image(stream);
		ImageView logoImage = new ImageView();
		logoImage.setImage(logo);
		logoImage.setFitWidth(90);
		logoImage.setFitHeight(90);

		// ---get the name of the dish---//
		Label name = new Label(item.getName());
		Font font = Font.font("Berlin Sans FB Demi", FontWeight.BOLD, 20);
		name.setFont(font);

		// ---get the name of the dish---//
		String price = new DecimalFormat("##.##").format(item.getPrice()) + "$";
		Label priceLabel = new Label(price);
		priceLabel.setFont(font);

		// ---get the description of the dish---//
//		JFXTextArea description = new JFXTextArea(item.getDescription());
//		description.setEditable(false);
//		description.setPrefHeight(50);
//		description.setPrefWidth(300);

		HBox itemInLine = new HBox(5);
		itemInLine.getChildren().addAll(logoImage, name, priceLabel);
		itemInLine.setSpacing(100);
		itemInLine.setAlignment(Pos.CENTER);

		VBox dishes = new VBox(20);
		dishes.getChildren().add(itemInLine);
		dishes.setPadding(new Insets(10, 10, 10, 10));
		dishes.setCursor(Cursor.HAND);
		// dishes.setAlignment(Pos.CENTER_LEFT);
		return dishes;

	}

	public void setHome(mainFrameController home) {
		this.home = home;
		retButton();
	}

	public void retButton() {
		retButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> home.goToDishes(e));
	}

}
