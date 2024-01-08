package com.gamesense.client.api.event;

public interface MultiPhase<T extends GameSenseEvent> {

    Phase getPhase();

    T nextPhase();
}