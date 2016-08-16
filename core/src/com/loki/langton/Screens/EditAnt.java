package com.loki.langton.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.loki.langton.Ant;
import com.loki.langton.Grid;

/**
 * Created by Loki on 8/9/2016.
 */
public class EditAnt extends Screen {

    private Grid grid;
    private Ant ant;

    private boolean movingAnt = false;
    private boolean allowSwitch = true;

    public EditAnt(Grid grid, Ant ant)
    {
        this.grid = grid;
        this.ant = ant;
    }

    @Override
    public void create() { resize(768, 768); }

    @Override
    public void update() {
        if(allowSwitch) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && ant.getBounds().contains(pos().x, pos().y) && !movingAnt) {
                movingAnt = true;
                allowSwitch = false;
            } else if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && ant.getBounds().contains(pos().x, pos().y) && movingAnt) {
                movingAnt = false;
                allowSwitch = false;
            }
        }
        else if(!Gdx.input.isButtonPressed(Input.Buttons.LEFT))
        {
            allowSwitch = true;
        }

        if(movingAnt)
        {
            ant.updatePos((int) (pos().x - (pos().x % grid.getSquareWidth())), (int) (pos().y - (pos().y % grid.getSquareHeight())));
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
            ant.render(sb);
        sb.end();
        update();
    }

    @Override
    public void resize(int width, int height) { Gdx.graphics.setDisplayMode(width, height, false); }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    private Vector2 pos()
    {
        return new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }
}
