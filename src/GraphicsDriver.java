import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Objects;
import java.util.Scanner;

public class GraphicsDriver extends JFrame implements Runnable
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final Canvas wonderland;

    public GraphicsDriver()
    {
        super("witner wundorlend");

        setSize(WIDTH,HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wonderland = new WinterWonderland();
        wonderland.setIgnoreRepaint(true);
        getContentPane().add(wonderland);
        pack();

        setVisible(true);

        wonderland.createBufferStrategy(2);

        Thread animator = new Thread(this);
        animator.start();
    }

    public static void main(String[] args)
    {
        GraphicsDriver run = new GraphicsDriver();
    }

    private void render(BufferStrategy bs) {
        Graphics g = bs.getDrawGraphics(); // Get the off-screen buffer's graphics context
        try {
            // Clear the background
            Color lightBlue = new Color(173, 216, 230);
            g.setColor(lightBlue);
            g.fillRect(0, 0, wonderland.getWidth(), wonderland.getHeight());

            // Draw all game objects or complex graphics
            wonderland.paint(g);

        } finally {
            g.dispose(); // Release the graphics context
        }
        bs.show(); // Swap the off-screen buffer with the visible one
    }


    @Override
    public void run() {
        BufferStrategy bufferStrategy = wonderland.getBufferStrategy();
        render(bufferStrategy);

        //Scanner waiter = new Scanner(System.in);
        //waiter.nextLine();

        Timer frameTimer = new Timer(20, e -> {
            render(bufferStrategy);
            //Point mousePos = getMousePosition();
            //if (!Objects.isNull(mousePos)) System.out.printf("(%d, %d)\n", mousePos.x, mousePos.y);
        });
        frameTimer.start();
    }
}