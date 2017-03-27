package com.loki.langton.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.loki.langton.Ant;
import com.loki.langton.Grid;

/**
 * Created by Loki on 7/27/2016.
 */
public class ActiveAnt extends Screen {

    private Grid grid;
    private Ant ant;

    private long lastRenderTime = System.currentTimeMillis();
    private float[] times = {1000f, 500f, 250f, 100f, 0};
    private int timesArrayPos = 0;

    private int step = 0;

    public ActiveAnt(Grid grid, Ant ant)
    {
        this.grid = grid;
        this.ant = ant;
    }

    @Override
    public void create() {
        resize(768,768);
    }

    @Override
    public void update() {

        //This update loop just updates the position according the what time delay is selected
        //Pressing the right or left arrow keys increases or lowers the time delay

        float elapsedTime = (System.currentTimeMillis() - lastRenderTime);

        if(elapsedTime > times[timesArrayPos])
		{
			ant.update(grid.getSquares());
			step++;
			System.out.println(step);
			lastRenderTime = System.currentTimeMillis();
		}

		if(timesArrayPos < 4 && Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
            timesArrayPos++;
        else if(timesArrayPos > 0 && Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
            timesArrayPos--;

		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) ScreenManager.setScreen(ScreenManager.getLastScreen());

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
            grid.render(sb);
            ant.render(sb);
        sb.end();
        update();

    }

    @Override
    public void resize(int width, int height) {
        Gdx.graphics.setDisplayMode(width, height, false);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
