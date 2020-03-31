package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemIcon extends ImageView {
	
	private static final int MAX_FIT_HEIGHT = 15;
	private static final int MAX_FIT_WIDTH = 15;
	
	public ItemIcon(String imagePath) {
		super();
		Image buildingImage = new Image(imagePath);
		this.setImage(buildingImage);
		this.setFitHeight(MAX_FIT_HEIGHT);
		this.setFitWidth(MAX_FIT_WIDTH);

		this.setPreserveRatio(true);
	}
}
