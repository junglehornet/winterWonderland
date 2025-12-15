import java.awt.*;
import java.util.Vector;

public class Snow {
    private int x;
    private int y;
    private final int windowHeight;
    private final int windowWidth;
    private final int flakeDiameter;
    private final Vector<Double> velocity;

    public Snow(int width, int height) {
        windowHeight = height;
        windowWidth = width;
        x = (int) (Math.random() * (width + 1) - 1);
        y = 0;
        //x = 400;
        //y = 300;
        velocity = new Vector<>(2, 0);
        velocity.add((Math.random() * 2.5) + 0.5); // y (downward) velocity
        //velocity.add((Math.random() * 6) - 3); // x (side-to-side) velocity
        velocity.add((Math.random() * 6) - 3); // x (side-to-side) velocity
        flakeDiameter = (int) (Math.random() * 2) + 4;
    }

    private void draw(Graphics window) {
        Color preColor = window.getColor();
        window.setColor(Color.white);
        window.fillOval(x, y, flakeDiameter, flakeDiameter);
        window.setColor(preColor);
    }

    public void update(Graphics window) {
        if (y > windowHeight) {
            return;
        }
        Vector<Double> accelerationVector = new Vector<>(2, 0);
        accelerationVector.add(Math.random() - 0.5); // downward velocity
        accelerationVector.add(Math.random() - 0.5); // lateral velocity
        velocity.set(0, Utils.clamp(velocity.get(0) + accelerationVector.get(0), 0.5, 3));
        //velocity.set(0, Math.clamp(velocity.get(0) + accelerationVector.get(0), -3, 3));
        velocity.set(1, Utils.clamp(velocity.get(1) + accelerationVector.get(1), -3, 3));
        y += velocity.get(0);
        //y = (int) Math.clamp(y + velocity.get(0), -5, windowWidth);
        x += velocity.get(1);
        if (y > windowHeight) {
            //y = 0;
        }
        if (x > windowWidth) {
            x = 0;
        }
        if (x < 0) {
            x = windowWidth;
        }
        draw(window);
    }
}
