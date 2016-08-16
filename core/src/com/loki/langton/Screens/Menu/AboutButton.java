package com.loki.langton.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.loki.langton.Screens.AboutMenu;
import com.loki.langton.Screens.ScreenManager;

/**
 * Created by Loki on 8/11/2016.
 */
public class AboutButton extends MenuButton {

    AboutButton(int x, int y, Texture tex)
    {
        super(x, y, tex);
    }

    @Override
    public void update() {
        if(hoveringOver() && Gdx.input.isButtonPressed(Input.Buttons.LEFT))
        {
            ScreenManager.setScreen(new AboutMenu());
        }
    }
}
