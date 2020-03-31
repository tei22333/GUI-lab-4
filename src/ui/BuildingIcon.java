package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BuildingIcon extends ImageView {
	
	private static final int MAX_FIT_HEIGHT = 20;
	private static final int MAX_FIT_WIDTH = 20;
	
	public BuildingIcon(String imagePath) {
		super();
		Image buildingImage = new Image(imagePath);
		this.setImage(buildingImage);
		this.setFitHeight(MAX_FIT_HEIGHT);
		this.setFitWidth(MAX_FIT_WIDTH);

		this.setPreserveRatio(true);
	}
}
