package org.geekbrains.ru.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import org.geekbrains.ru.base.Sprite;
import org.geekbrains.ru.math.Rect;

public class Ship extends Sprite {

    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;


    public Ship(Texture texture) {
        super(new TextureRegion(texture));
        touch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }


    @Override
    public void update(float delta) {
        tmp.set(touch);
        if (tmp.sub(pos).len() > 0.01f) {
            pos.add(v);
        } else {
            pos.set(touch);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(this.touch.cpy().sub(pos).setLength(0.01f));
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {

        return super.touchUp(touch, pointer, button);
    }

    @Override
    public void resize(Rect worldBounds) {

        setHeightProportion(0.1f);
    }


}
