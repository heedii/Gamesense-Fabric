package com.gamesense.client.api.event.events;

import com.gamesense.client.api.event.MultiPhase;
import com.gamesense.client.api.event.Phase;
import com.gamesense.client.api.util.misc.EnumUtils;
import com.gamesense.client.api.util.player.PlayerPacket;
import com.gamesense.client.api.event.GameSenseEvent;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;

public class OnUpdateWalkingPlayerEvent extends GameSenseEvent implements MultiPhase<OnUpdateWalkingPlayerEvent> {

    private final Phase phase;

    private boolean moving = false;
    private boolean rotating = false;
    private Vec3d position;
    private Vec2f rotation;

    public OnUpdateWalkingPlayerEvent(Vec3d position, Vec2f rotation) {
        this(position, rotation, Phase.PRE);
    }

    private OnUpdateWalkingPlayerEvent(Vec3d position, Vec2f rotation, Phase phase) {
        this.position = position;
        this.rotation = rotation;
        this.phase = phase;
    }

    @Override
    public OnUpdateWalkingPlayerEvent nextPhase() {
        return new OnUpdateWalkingPlayerEvent(position, rotation, EnumUtils.next(phase));
    }

    public void apply(PlayerPacket packet) {
        Vec3d position = packet.getPosition();
        Vec2f rotation = packet.getRotation();

        if (position != null) {
            this.moving = true;
            this.position = position;
        }

        if (rotation != null) {
            this.rotating = true;
            this.rotation = rotation;
        }
    }

    public boolean isMoving() {
        return moving;
    }

    public boolean isRotating() {
        return rotating;
    }

    public Vec3d getPosition() {
        return position;
    }

    public Vec2f getRotation() {
        return rotation;
    }

    @Override
    public Phase getPhase() {
        return phase;
    }

}
