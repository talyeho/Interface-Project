package gui;

import java.io.IOException;
import java.net.URL;

import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import logic.Item;

public class mainFrameController implements Initializable {
	String projectPath = System.getProperty("user.dir") + "\\images\\";
	Item[] items;
	public HashMap<Integer, Item> allItems = new HashMap<Integer, Item>();
	@FXML
	private VBox itemVbox;

	Stage primaryStage;

	@FXML
	private AnchorPane mainAnchorPaneDishes;
	
    @FXML
    private ImageView mainImage;
    
    @FXML
    private ImageView logoImage;

	@FXML
	private Button btnGoToDishes;

	private void getItems() {
		items = new Item[5];
		items[0] = new Item("Main", "Pizza", 0, 1, "Margarita", (float) 9.90, "Delicious margarita pizza with basil",
				"flour, yeast, salt, paper, olive oil, tomato, mozarella, basil", "margherita-pizza.jpg", 1);
		items[1] = new Item("Main", "Pizza", 1, 1, "Meat lover", (float) 12.90,
				"The best meat lover pizza with paparoni, sausage and special meat!",
				"flour, yeast, salt, paper, olive oil, tomato,\n mozarella, paparoni, sausage, special meat",
				"meatLover.jpg", 1);
		items[2] = new Item("Main", "Pizza", 2, 1, "Whole wheat veggie", (float) 19.90,
				"Whole wheat veggie Pizza that will make you doubt it's vegetarian!\nHighly recommended!",
				"whole wheat flour, yeast, salt, paper, olive oil, tomato,\n mozarella, mushroom, pineapple, sweet pepper, zucchini",
				"wwvp.jpg", 1);
		items[3] = new Item("Main", "Pasta", 3, 1, "Creamy mushroom pasta", (float) 11.90, "Creamy mushroom pasta",
				"flour, salt, paper, olive oil, egg, mushroom, cream", "ODED0865_c.jpg", 1);
		items[4] = new Item("Drinks", "Pop", 4, 1, "Coca Cola", (float) 1.90, "Freeze cold glass Coca Cola bottle", "",
				"coca.jpg", 1);
		for (int i = 0; i < 5; i++)
			allItems.put(items[i].getItemID(), items[i]);

	}

	public void start(Stage primaryStage) throws Exception {
		Parent root;

		root = FXMLLoader.load(getClass().getResource("mainFrame.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setTitle("Client Confirmation");
		primaryStage.setScene(scene);
		this.primaryStage = primaryStage;
		primaryStage.show();

//		mainAnchorPaneDishes.getChildren().setAll(node);
//		mainAnchorPaneDishes.setVisible(true);

	}

	@FXML
	void goToDishes(MouseEvent e) {
		try {
			setDishsPane();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public void setDishsPane() throws IOException {
		Node node = null;
		FXMLLoader loader = new FXMLLoader();
		dishesFrameController dishesframeController;
		node = (Node) loader.load(getClass().getResource("DishesFrame.fxml").openStream());
		dishesframeController = loader.getController();

		getItems();

		dishesframeController.setItems(items);
		dishesframeController.setHome(this);
		dishesframeController.setItemContainer();
		mainAnchorPaneDishes.getChildren().setAll(node);
		mainAnchorPaneDishes.setVisible(true);
	}

	public void setDetailPane(int itemID, VBox item) throws IOException {
		Node node = null;
		FXMLLoader loader = new FXMLLoader();
		detailFrameController detailframeController;
		node = (Node) loader.load(getClass().getResource("DetailFrame.fxml").openStream());
		detailframeController = loader.getController();
		detailframeController.setItemDetails(allItems.get(itemID), item);
		detailframeController.setHome(this);
		mainAnchorPaneDishes.getChildren().setAll(node);
		mainAnchorPaneDishes.setVisible(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnGoToDishes.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> goToDishes(e));

	}

}
