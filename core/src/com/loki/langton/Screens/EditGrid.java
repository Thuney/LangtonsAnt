package com.loki.langton.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.loki.langton.Grid;
import com.loki.langton.Square;

/**
 * Created by Loki on 7/27/2016.
 */
public class EditGrid extends Screen {

    private Grid grid;
    private boolean switched = false;

    public EditGrid(Grid grid)
    {
        this.grid = grid;
    }

    @Override
    public void create() {
        resize(768,768);
    }

    @Override
    public void update() {
        for(Square s: grid.getSquares())
        {
            if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && s.getBounds().contains(Gdx.input.getX(), grid.getHeight() - Gdx.input.getY()) && !switched)
            {
                s.changeColor();
                switched = true;
            }

            if(!Gdx.input.isButtonPressed(Input.Buttons.LEFT))
            {
                switched = false;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
            ScreenManager.setScreen(ScreenManager.getLastScreen());
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
           grid.render(sb);
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
