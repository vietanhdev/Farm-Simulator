package dev.hust.funnyfarm.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Text {
	
	public static void drawString(Graphics g, String text, int xPos, int yPos, boolean center, Color c, Font font){
		g.setColor(c);
		g.setFont(font);
		int x = xPos;
		int y = yPos;
		if(center){
			FontMetrics fm = g.getFontMetrics(font);
			x = xPos - fm.stringWidth(text) / 2;
			y = (yPos - fm.getHeight() / 2) + fm.getAscent();
		}
		g.drawString(text, x, y);
	}
	
	public static void drawString(Graphics g, String text, int x, int y, int style) {
		
		Color textColor = null, bgColor = null;
		
		if (style == 0) {
			textColor = Color.BLACK;
	        bgColor = Color.GREEN;
		} else if (style == 1) {
			textColor = Color.WHITE;
	        bgColor = Color.RED;
		}
		
		

        FontMetrics fm = g.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(text, g);

        g.setColor(bgColor);
        g.fillRect(x,
                   y - fm.getAscent(),
                   (int) rect.getWidth(),
                   (int) rect.getHeight());

        g.setColor(textColor);
        g.drawString(text, x, y);
	}

}
