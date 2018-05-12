package dev.hust.funnyfarm.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.hust.funnyfarm.gfx.Assets;

public class FoodSelectButton extends SelectableButton {

	private BufferedImage animalImg;
	
	public FoodSelectButton(String name, float x, float y, int width, int height, BufferedImage animalImg) {
		super(name, x, y, width, height, Assets.btn_foodbag);
		setAnimalImg(animalImg);
	}

	public FoodSelectButton(String name, float x, float y, int width, int height, BufferedImage animalImg,
		ClickListener clicker) {
		super(name, x, y, width, height, Assets.btn_foodbag, clicker);
		setAnimalImg(animalImg);
	}
	
	@Override
	public void render(Graphics g) {
		if (isSelected())
			g.drawImage(getImages()[2], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
		else if(isHovering())
			g.drawImage(getImages()[1], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
		else
			g.drawImage(getImages()[0], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
	
		g.drawImage(getAnimalImg(), (int) getX() + 10, (int) getY() + 10, getWidth() - 20, getHeight() - 20, null);
	}

	public BufferedImage getAnimalImg() {
		return animalImg;
	}

	public void setAnimalImg(BufferedImage animalImg) {
		this.animalImg = animalImg;
	}

}
