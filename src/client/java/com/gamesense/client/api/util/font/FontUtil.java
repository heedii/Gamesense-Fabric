package com.gamesense.client.api.util.font;

import com.gamesense.client.GameSense;
import com.gamesense.client.api.util.render.GSColor;
import net.minecraft.client.Minecraft;

public class FontUtil {

    private static final Minecraft mc = Minecraft.getMinecraft();

    public static float drawStringWithShadow(boolean customFont, String text, int x, int y, GSColor color) {
        if (customFont) {
            return GameSense.INSTANCE.cFontRenderer.drawStringWithShadow(text, x, y, color);
        } else {
            return mc.fontRenderer.drawStringWithShadow(text, x, y, color.getRGB());
        }
    }

    public static int getStringWidth(boolean customFont, String string) {
        if (customFont) {
            return GameSense.INSTANCE.cFontRenderer.getStringWidth(string);
        } else {
            return mc.fontRenderer.getStringWidth(string);
        }
    }

    public static int getFontHeight(boolean customFont) {
        if (customFont) {
            return GameSense.INSTANCE.cFontRenderer.getHeight();
        } else {
            return mc.fontRenderer.FONT_HEIGHT;
        }
    }
}