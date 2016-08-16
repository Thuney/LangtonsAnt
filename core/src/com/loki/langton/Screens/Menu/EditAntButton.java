package com.loki.langton.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.loki.langton.Ant;
import com.loki.langton.Grid;
import com.loki.langton.Screens.EditAnt;
import com.loki.langton.Screens.ScreenManager;

/**
 * Created by Loki on 8/9/2016.
 */
class EditAntButton extends MenuButton {

    private Grid grid;
    private Ant ant;

    EditAntButton(int x, int y, Texture tex, Grid grid, Ant ant)
    {
        super(x, y, tex);
        this.ant = ant;
        this.grid = grid;
    }

    @Override
    public void update() {
        if(hoveringOver() && Gdx.input.isButtonPressed(Input.Buttons.LEFT))
        {
            ScreenManager.setScreen(new EditAnt(grid, ant));
        }
    }
}
