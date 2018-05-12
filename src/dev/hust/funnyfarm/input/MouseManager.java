package dev.hust.funnyfarm.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.hust.funnyfarm.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener {

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	private boolean mouseClicked;
	private int mouseClickedX;
	private int mouseClickedY;
	
	public MouseManager(){
		
	}

	public void setUIManager(UIManager uiManager){
		this.uiManager = uiManager;
	}
	
	// Getters
	
	public boolean isLeftPressed(){
		return leftPressed;
	}
	
	public boolean isRightPressed(){
		return rightPressed;
	}
	
	public int getMouseX(){
		return mouseX;
	}
	
	public int getMouseY(){
		return mouseY;
	}
	
	// Implemented methods
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
		if(uiManager != null)
			uiManager.onMouseRelease(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if(uiManager != null)
			uiManager.onMouseMove(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public int getMouseClickedX() {
		return mouseClickedX;
	}
	
	public int getMouseClickedY() {
		return mouseClickedY;
	}
	
	public boolean isMouseClicked() {
		if (mouseClicked) {
			mouseClicked = false;
			return true;
		} else 
			return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (mouseClicked) return;
		mouseClickedX = e.getX();
		mouseClickedY = e.getY();
		mouseClicked = true;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
