package dev.hust.funnyfarm.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

	private String name;
	private BufferedImage[] images;
	private ClickListener clicker;
	
	public UIImageButton(String name, float x, float y, int width, int height,  BufferedImage[] images) {
		super(x, y, width, height);
		this.setName(name);
		this.images = images;
	}
	public UIImageButton(String name, float x, float y, int width, int height,  BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.setName(name);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		if(isHovering())
			g.drawImage(getImages()[1], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
		else
			g.drawImage(getImages()[0], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public BufferedImage[] getImages() {
		return images;
	}

	public ClickListener getClicker() {
		return clicker;
	}

	public void setClicker(ClickListener clicker) {
		this.clicker = clicker;
	}

}
