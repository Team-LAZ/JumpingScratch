package com.laz.jump;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Knight extends Image {

    float fX, fY, fWidth, fHeight, fVelY;
    public boolean isJumping, isFalling;
    TextureRegion trKnight;

    public Knight(float fX, float fY, float fWidth, float fHeight) {
        this.fX = fX;
        this.fY = fY;
        this.fWidth = fWidth;
        this.fHeight = fHeight;

        fVelY = 5;

        trKnight = new TextureRegion(new Texture("knight.png"));
    }

    @Override
    public void act(float fDelta) {
        if (isJumping) {
            if (fVelY >= 0) {
                fY += fVelY * 2;
                fVelY -= 0.2;
            } else {
                isJumping = false;
                isFalling = true;
                fVelY = 0;
            }
        }

        if (isFalling) {
            if (fVelY >= 5) {
                isFalling = false;
                fVelY = 5;
            } else {
                fY -= fVelY * 2;
                fVelY += 0.2;
            }
        }
    }

    @Override
    public void draw(Batch batch, float fAlpha) {
        batch.draw(trKnight, fX, fY, fWidth, fHeight);
    }
}
