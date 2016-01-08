package com.laz.jump;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class GameStage extends Stage {

    OrthographicCamera camera;
    JumpButton btnJump;
    Knight knight;

    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, 800, 480, new OrthographicCamera(800, 480)));

        initCamera();
        initKnight();
        initControls();

        Gdx.input.setInputProcessor(this);
    }

    public void initCamera() {
        camera = new OrthographicCamera(800, 480);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    public void initKnight() {
        knight = new Knight(400, 200, 90, 90);
        addActor(knight);
    }

    public void initControls() {
        btnJump = new JumpButton(55, 100, knight);
        addActor(btnJump);
    }
}
