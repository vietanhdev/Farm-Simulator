package dev.hust.funnyfarm.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.hust.funnyfarm.gfx.Assets;

public class AddCreatureButton extends SelectableButton {

	private BufferedImage animalImg;
	
	public AddCreatureButton(String name, float x, float y, int width, int height, BufferedImage animalImg) {
		super(name, x, y, width, height, Assets.btn_empty);
		setAnimalImg(animalImg);
	}

	public AddCreatureButton(String name, float x, float y, int width, int height, BufferedImage animalImg,
		ClickListener clicker) {
		super(name, x, y, width, height, Assets.btn_empty, clicker);
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
