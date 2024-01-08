package com.gamesense.client.api.event.events;

import com.gamesense.client.api.event.GameSenseEvent;

public class ReachDistanceEvent extends GameSenseEvent {

    private float distance;

    public ReachDistanceEvent(float distance) {
        this.distance = distance;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}