package kolokwium;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

public class SineGenerator implements Runnable {

    private final SinePanel panel;
    private final SineParameters params;
    private volatile boolean running = true;

    public SineGenerator(SinePanel panel, SineParameters params) {
        this.panel = panel;
        this.params = params;
    }

    @Override
    public void run() {
        while (running) {
            panel.updateWave(params);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }
}
