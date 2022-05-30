package com.test.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.test.game.MyGdxGame;


//WHITE BAG CATCHER
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "sex 2!";
		config.width = 800;
		config.height =480;
		new LwjglApplication(new MyGdxGame(), config);

		Object yourMom = new Object();
	}
}
