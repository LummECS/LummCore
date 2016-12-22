package com.sidereal.lumm.components.renderer.tilemap;

import com.sidereal.lumm.components.renderer.Drawer;
import com.sidereal.lumm.components.renderer.Renderer;

public class TileMapDrawer extends Drawer {

    public TileMapDrawer(Renderer renderer, String name, boolean useRawDelta) {

        super(renderer, name, useRawDelta);
    }

    @Override
    protected void dispose() {

    }

    @Override
    protected void draw(float delta) {

    }

    @Override
    protected boolean isOutOfBounds() {

        return false;
    }

}
