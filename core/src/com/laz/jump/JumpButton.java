package com.laz.jump;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class JumpButton extends Button {

    Skin skJump;
    ButtonStyle bsJump;

    public JumpButton(float fX, float fY, final Knight knight) {
        setBounds(fX, fY, 80, 80);

        skJump = new Skin();
        skJump.add("jump_button", new Texture("jump_button.png"));

        bsJump = new ButtonStyle();
        bsJump.up = skJump.getDrawable("jump_button");
        setStyle(bsJump);

        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float fX, float fY) {
                if (!knight.isJumping && !knight.isFalling) {
                    knight.isJumping = true;
                }
            }
        });
    }
}
