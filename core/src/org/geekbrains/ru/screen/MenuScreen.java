package org.geekbrains.ru.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import org.geekbrains.ru.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture ship;
    private Texture space;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 buf;
    private Vector2 location;

    @Override
    public void show() {
        super.show();
        ship = new Texture("ship.png");
        space = new Texture("space.jpg");
        touch = new Vector2();
        v = new Vector2(1, 1);
        location = new Vector2(0, 0);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(space, 0, 0, 800, 480);
        batch.draw(ship, location.x, location.y);
        wing();


        batch.end();

    }

    @Override
    public void dispose() {
        ship.dispose();
        space.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("Location ship x = " + location.x + " y=" + location.y);
        return false;
    }

    private void wing() {
        if (touch.x < location.x) {
            location.add(-v.x, 0);
        }

        if (touch.y < location.y) {
            location.add(0, -v.y);
        }
        if (touch.x > location.x) {
            location.add(v.x, 0);
        }
        if (touch.y > location.y) {
            location.add(0, v.y);
        }

    }
    


    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                touch.y += 10;
                break;
            case Input.Keys.DOWN:
                touch.y -= 10;
                break;
            case Input.Keys.RIGHT:
                touch.x += 10;
                break;
            case Input.Keys.LEFT:
                touch.x -= 10;
                break;
        }
        return false;
    }
}

