package com.loki.langton.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.loki.langton.LangtonsAnt;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new LangtonsAnt(), config);
		
		config.width = 1920;
		config.height = 1080;
		config.title = "Langton's Ant";
	}
}
