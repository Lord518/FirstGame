package org.geekbrains.ru.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


import org.geekbrains.ru.base.*;
import org.geekbrains.ru.math.*;
import org.geekbrains.ru.sprite.Background;
import org.geekbrains.ru.sprite.Ship;

import static javax.swing.text.StyleConstants.Background;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture sh;
    private Background background;
    private Ship ship;
    private Vector2 v;
    private Vector2 posShip;


    @Override
    public void show() {
        super.show();
        bg = new Texture("space.jpg");
        sh = new Texture("ship.png");
        background = new Background(bg);
        ship = new Ship(sh);
        v = new Vector2();
        posShip = new Vector2();


    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0.3f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        ship.draw(batch);
       // ship.update(delta);
        batch.end();
    }

    @Override
    public void dispose()
    {
        sh.dispose();
        bg.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds)
    {
       // ship.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button)
    {
        //ship.touchDown(touch, pointer, button);
        System.out.println(touch.x + " " + touch.y);
        return super.touchDown(touch, pointer, button);
    }
}
