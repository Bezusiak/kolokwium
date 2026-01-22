package kolokwium;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinedPanel extends JPanel{
    private final LinkedList<Integer> points = new LinkedList<>();
    private final int maxPoints = 800;

    private final SineParameters parameters1;
    private final SineParameters parameters2;

    public CombinedPanel(SineParameters parameters1, SineParameters parameters2) {
        this.parameters1 = parameters1;
        this.parameters2 = parameters2;
        setBackground(Color.BLACK);

        new Thread(() -> {
            while (true) {
                updateCombined();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {}
            }
        }).start();
    }

    private void updateCombined() {
        double t = System.currentTimeMillis() / 1000.0;

        double y1 = parameters1.amplitude * Math.sin(2 * Math.PI * parameters1.frequency * t + parameters1.phase);
        double y2 = parameters2.amplitude * Math.sin(2 * Math.PI * parameters2.frequency * t + parameters2.phase);

        double y = y1 + y2;

        int center = getHeight() / 2;
        int pixelY = center - (int) y;

        points.addFirst(pixelY);
        if (points.size() > maxPoints) points.removeLast();

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.CYAN);

        int x = getWidth();
        for (int y : points) {
            g.drawLine(x, y, x, y);
            x--;
            if (x < 0) break;
        }
    }

}


