package dev.hust.funnyfarm.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


//import dev.hust.funnyfarm.states.State;

public class SelectableButton extends UIImageButton {
	
	private boolean isSelected;

	public SelectableButton(String name, float x, float y, int width, int height, BufferedImage[] images) {
		super(name, x, y, width, height, images);
	}
	
	public SelectableButton(String name, float x, float y, int width, int height, BufferedImage[] images,
			ClickListener clicker) {
		super(name, x, y, width, height, images, clicker);
	}
	
	@Override
	public void render(Graphics g) {
		if (isSelected())
			g.drawImage(getImages()[2], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
		else if(isHovering())
			g.drawImage(getImages()[1], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
		else
			g.drawImage(getImages()[0], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

}
