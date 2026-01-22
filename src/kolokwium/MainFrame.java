package kolokwium;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    MainFrame(){
        setTitle("Sinusoid Singal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        SineParameters parameters1 = new SineParameters();
        SineParameters parameters2 = new SineParameters();

        SinePanel panel1 = new SinePanel();
        SinePanel panel2 = new SinePanel();
        CombinedPanel panel3 = new CombinedPanel(parameters1, parameters2);

        new Thread(new SineGenerator(panel1, parameters1)).start();
        new Thread(new SineGenerator(panel2, parameters2)).start();

        JPanel waves = new JPanel(new GridLayout(3, 1));
        waves.add(panel1);
        waves.add(panel2);
        waves.add(panel3);

        JPanel controls = new JPanel(new GridLayout(1, 2));
        controls.add(new ControlPanel("Sinus A", parameters1));
        controls.add(new ControlPanel("Sinus B", parameters2));

        add(waves, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
