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
	
	long lastRenderTime = System.currentTimeMillis();
	float elapsedTime = 0;
	float timeBetweenUpdates = 1000f;
	
	int step = 0;
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		texMan = new TextureManager();
		grid = new Grid(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), texMan.blackSquare_8, texMan.whiteSquare_8);
		ant = new Ant(texMan.ant_8, new Vector2((Gdx.graphics.getWidth()/2) - texMan.ant_8.getWidth(),(Gdx.graphics.getHeight()/2) - texMan.ant_8.getHeight()), 3);
	}

	@Override
	public void render () {	
		
		elapsedTime = (System.currentTimeMillis() - lastRenderTime);
		//SpriteBatch
		sb.begin();
			grid.render(sb);
			ant.render(sb);
		sb.end();
		
		if(elapsedTime > timeBetweenUpdates)
		{
			ant.update(grid.getSquares());
			step++;
			System.out.println(step);
			lastRenderTime = System.currentTimeMillis();
		}
	}
}
