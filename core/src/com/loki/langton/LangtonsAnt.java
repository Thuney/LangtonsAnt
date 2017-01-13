package com.loki.langton;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.loki.langton.Screens.Menu.MainMenu;
import com.loki.langton.Screens.ScreenManager;

public class LangtonsAnt extends ApplicationAdapter {
	
	private SpriteBatch sb;
	private OrthographicCamera camera;

	private TextureManager texMan;

	private Grid grid;
	private Ant ant;

	@Override
	public void create () {
		sb = new SpriteBatch();
		//Orthographic camera is used so that we can scale our window without messing up the size of our elements
		camera = new OrthographicCamera();

		//Object that stores strictly our texture files
		texMan = new TextureManager();

		grid = new Grid(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), texMan.blackSquare_8, texMan.whiteSquare_8);
		ant = new Ant(texMan.ant_8, new Vector2((Gdx.graphics.getWidth()/2) - texMan.ant_8.getWidth(),(Gdx.graphics.getHeight()/2) - texMan.ant_8.getHeight()), 3);

		ScreenManager.setScreen(new MainMenu(grid, ant, texMan));
	}

	@Override
	public void render () {
		//SpriteBatch
		ScreenManager.getCurrentScreen().render(sb);
	}

	public void resize(int width, int height)
	{
		camera.setToOrtho(false);
		sb.setProjectionMatrix(camera.combined);
	}

	public void dispose()
	{
		sb.dispose();
	}
}
