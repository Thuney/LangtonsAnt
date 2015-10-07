package com.loki.langton;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class LangtonsAnt extends ApplicationAdapter {
	
	SpriteBatch sb;
	
	TextureManager texMan;
	Grid grid;
	Ant ant;
	
	long processTime = System.nanoTime();
	
	double nanosecondsBetweenUpdates = 20000000;
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		texMan = new TextureManager();
		grid = new Grid(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), texMan.blackSquare_16, texMan.whiteSquare_16);
		ant = new Ant(texMan.ant_16, new Vector2((Gdx.graphics.getWidth()/2) - texMan.ant_16.getWidth(),(Gdx.graphics.getHeight()/2) - texMan.ant_16.getHeight()), 0);
	}

	@Override
	public void render () {	
			//SpriteBatch
			sb.begin();
				grid.render(sb);
				ant.render(sb);
			sb.end();
		if(((System.nanoTime() - processTime)) > nanosecondsBetweenUpdates)
		{
			ant.update(grid.getSquares());
			processTime = System.nanoTime();
		}
	}
}
