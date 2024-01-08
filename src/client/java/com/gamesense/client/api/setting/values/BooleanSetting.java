package com.gamesense.client.api.setting.values;

import com.gamesense.client.api.setting.Setting;
import com.gamesense.client.module.Module;
import com.lukflug.panelstudio.settings.Toggleable;

public class BooleanSetting extends Setting<Boolean> implements Toggleable {

    public BooleanSetting(String name, Module module, boolean value) {
        super(value, name, module);
    }

    @Override
    public void toggle() {
        setValue(!getValue());
    }

    @Override
    public boolean isOn() {
        return getValue();
    }
}