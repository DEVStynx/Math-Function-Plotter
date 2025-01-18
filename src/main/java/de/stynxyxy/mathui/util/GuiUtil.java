package de.stynxyxy.mathui.util;
import de.stynxyxy.mathui.objects.Vector2;

import java.awt.*;


public class GuiUtil {
    public static Vector2 translateCoords(double x, double y) {
        return translateCoords(new Vector2(x,y));
    }
    public static Vector2 translateCoords(Vector2 vector) {
        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
        Vector2 screenMiddle = new Vector2(screen_size.width / 2.0, screen_size.height / 2.0);


        double translatedX = screenMiddle.x() + vector.x();
        double translatedY = screenMiddle.y() - vector.y();

        return new Vector2(translatedX, translatedY);
    }

    public static Vector2 translateCoordsToCoordinate(Vector2 vec) {
        Vector2 translated = translateCoords(vec);
        double x = translated.x() * 5;
        double y = translated.y() * 5;
        return new Vector2(x,y);
    }
    public static Vector2 translateCoordsToGraphicsUsable(Vector2 vec) {
        Vector2 translated = translateCoords(vec);
        double x = translated.x() / 5;
        double y = translated.y() / 5;
        return new Vector2(x,y);
    }

    public static Vector2 getScreenMiddle() {
        return new Vector2(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
    }
    public static Vector2 translateCoordsForFunction(double x, double y) {
        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
        Vector2 screenMiddle = new Vector2(screen_size.width / 2.0, screen_size.height / 2.0);

        // Skalierungsfaktor, z. B. 25 Pixel pro mathematische Einheit
        double scale = 25.0;

        double translatedX = screenMiddle.x() + x * scale;
        double translatedY = screenMiddle.y() - y * scale; // Y-Achse invertieren

        return new Vector2(translatedX, translatedY);
    }

}
