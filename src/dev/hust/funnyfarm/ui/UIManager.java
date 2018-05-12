package dev.hust.funnyfarm.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.hust.funnyfarm.Handler;

public class UIManager {

	private Handler handler;
	private ArrayList<UIObject> objects;
	private SelectableButton selectedBtn;
	
	public UIManager(Handler handler){
		this.handler = handler;
		objects = new ArrayList<UIObject>();
	}
	
	public void tick(){
		for(UIObject o : objects)
			o.tick();
	}
	
	public void render(Graphics g){
		
		// Draw menu bar
		g.setColor(Color.decode("#54442C"));
		g.fillRect(0, 0, 19*64, 64);
		g.setColor(Color.decode("#F5FECD"));
		g.fillRect(2, 2, 19*64-4, 64-4);
		
		g.setColor(Color.decode("#F5FECD"));
		g.fillRect(0, 64, 3*64, 40);
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 16)); 
		g.setColor(Color.decode("#54442C"));
		g.drawString("Feed", 10, 32);
		
		
		g.drawString("Add", 9*64 + 10, 32);
		g.drawString("More", 9*64 + 2, 50);
		
		for(UIObject o : objects)
			o.render(g);
	}
	
	public void onMouseMove(MouseEvent e){
		for(UIObject o : objects)
			o.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e){
		for(UIObject o : objects)
			o.onMouseRelease(e);
	}
	
	public void addObject(UIObject o){
		objects.add(o);
	}
	
	public void removeObject(UIObject o){
		objects.remove(o);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	public SelectableButton getSelectedBtn() {
		return selectedBtn;
	}

	public void setSelectedBtn(SelectableButton selectedBtn) {
		if (getSelectedBtn() != null) {
			getSelectedBtn().setSelected(false);
		}
		selectedBtn.setSelected(true);
		this.selectedBtn = selectedBtn;
	}
	
}
