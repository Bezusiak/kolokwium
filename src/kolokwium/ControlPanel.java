package kolokwium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

public class ControlPanel extends JPanel {

    public ControlPanel(String title, SineParameters params) {
        setLayout(new GridLayout(3, 2));
        setBorder(BorderFactory.createTitledBorder(title));

        JSlider amp = new JSlider(0, 100, (int) params.amplitude);
        JSlider freq = new JSlider(0, 100, (int) params.frequency);
        JSlider phase = new JSlider(0, 100, (int) (params.phase * 100));

        amp.addChangeListener(e -> params.amplitude = amp.getValue());
        freq.addChangeListener(e -> params.frequency = freq.getValue());
        phase.addChangeListener(e -> params.phase = phase.getValue() / 100.0);

        add(new JLabel("Ampiltude"));
        add(amp);
        add(new JLabel("Frequency"));
        add(freq);
        add(new JLabel("Pahse"));
        add(phase);


    }
}