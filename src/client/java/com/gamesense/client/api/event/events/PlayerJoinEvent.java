package com.gamesense.client.api.event.events;

import com.gamesense.client.api.event.GameSenseEvent;

public class PlayerJoinEvent extends GameSenseEvent {

    private final String name;

    public PlayerJoinEvent(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}