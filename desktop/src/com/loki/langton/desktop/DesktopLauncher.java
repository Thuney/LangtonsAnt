package com.loki.langton.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.loki.langton.LangtonsAnt;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new LangtonsAnt(), config);

		config.resizable = true;
		config.width = 768;
		config.height = 768;
		config.title = "Langton's Ant";
	}
}
