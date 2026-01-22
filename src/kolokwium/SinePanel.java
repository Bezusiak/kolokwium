package kolokwium;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class SinePanel extends JPanel {

    private final LinkedList<Integer> points = new LinkedList<>();
    private final int maxPoints = 800;

    public SinePanel() {
        setBackground(Color.BLACK);
    }
    public void updateWave(SineParameters params){
        double t = System.currentTimeMillis()/2000.0;
        double y = params.amplitude * Math.sin(2 * Math.PI * params.frequency * t + params.phase);
        int center = getHeight()/2;
        int pixely = center - (int)y;

        points.addFirst(pixely);
        if(points.size() > maxPoints){
            points.removeLast();
        }
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);

        int x = getWidth();
        for (int y : points) {
            g.drawLine(x, y, x, y);
            x--;
            if (x < 0) break;
        }
    }
}