package dev.hust.funnyfarm.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import sun.applet.Main;

public class FontLoader {
	
	public static Font loadFont(String path, float size){
		try {
			return Font.createFont(Font.TRUETYPE_FONT,  Main.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
