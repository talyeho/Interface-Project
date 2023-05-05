package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.Item;

public class dishesFrameController implements Initializable {
	String projectPath = System.getProperty("user.dir") + "\\images\\";
	Item[] items;
	public HashMap<Integer, Item> allItems = new HashMap<Integer, Item>();
	private mainFrameController home;
	@FXML
	private BorderPane paneForSelections;

	@FXML
	private VBox itemVbox;

	@FXML
	private ScrollPane scrolPane;

	@FXML
	private Text dateAndTime;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		dateAndTime.setText(now.format(formatter));
	}

	public void setItemContainer() throws FileNotFoundException {
		ArrayList<VBox> itemList = new ArrayList<>();

		for (Item item : items) {
			allItems.put(item.getItemID(), item);
			// ---get the img of the dish---//
			InputStream stream;
			stream = new FileInputStream("C:\\images\\" + item.getPhoto());

			Image logo = new Image(stream);
			ImageView logoImage = new ImageView();
			logoImage.setImage(logo);
			logoImage.setFitWidth(90);
			logoImage.setFitHeight(90);

			// ---get the name of the dish---//
			Label name = new Label(item.getName() + " " + item.getSubcategory());
			Font font = Font.font("Berlin Sans FB Demi", FontWeight.BOLD, 20);
			name.setFont(font);

			// ---get the name of the dish---//
			String price = new DecimalFormat("##.##").format(item.getPrice()) + "$";
			Label priceLabel = new Label(price);
			priceLabel.setFont(font);

			// ---get the description of the dish---//
//			JFXTextArea description = new JFXTextArea(item.getDescription());
//			description.setEditable(false);
//			description.setPrefHeight(50);
//			description.setPrefWidth(300);

			VBox name_description = new VBox(5);
			// name_description.getChildren().addAll(name, description);
			name_description.getChildren().addAll(name);

			HBox itemInLine = new HBox(5);
			itemInLine.getChildren().addAll(logoImage, name_description, priceLabel);
			itemInLine.setSpacing(100);
			// itemInLine.setAlignment(Pos.CENTER);

			VBox dishes = new VBox(20);
			dishes.getChildren().add(itemInLine);
			dishes.setPadding(new Insets(10, 10, 10, 10));
			dishes.setCursor(Cursor.HAND);
			// dishes.setAlignment(Pos.CENTER_LEFT);

			dishes.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> handeleClickDish(e, item.getItemID(), dishes));
			itemList.add(dishes);
		}
		itemVbox.getChildren().clear();
		itemVbox.getChildren().addAll(itemList);
		itemVbox.setBackground(
				new Background(new BackgroundFill(Color.valueOf("#98add6"), CornerRadii.EMPTY, Insets.EMPTY)));

	}

	private void handeleClickDish(MouseEvent e, int itemID, VBox dishes) {
		try {
			home.setDetailPane(itemID, dishes);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public void setHome(mainFrameController home) {
		this.home = home;

	}

}
