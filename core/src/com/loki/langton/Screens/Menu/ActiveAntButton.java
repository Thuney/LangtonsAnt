package com.loki.langton.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.loki.langton.Ant;
import com.loki.langton.Grid;
import com.loki.langton.Screens.ActiveAnt;
import com.loki.langton.Screens.ScreenManager;

/**
 * Created by Loki on 8/8/2016.
 */
class ActiveAntButton extends MenuButton {

    private Grid grid;
    private Ant ant;

    ActiveAntButton(int x, int y, Texture tex, Grid grid, Ant ant)
    {
        super(x, y, tex);
        this.grid = grid;
        this.ant = ant;
    }

    @Override
    public void update() {
        if(hoveringOver() && Gdx.input.isButtonPressed(Input.Buttons.LEFT))
        {
            ScreenManager.setScreen(new ActiveAnt(grid, ant));
        }
    }
}
