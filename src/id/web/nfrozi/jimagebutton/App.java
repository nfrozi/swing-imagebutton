package id.web.nfrozi.jimagebutton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author nfrozi
 */
public class App extends JFrame {
    
    private JButton clockButton;
    private JLabel statusLabel;
    private int counter = 0;

    public App() {
        super("ImgBtnEx v1.0");
        init();
    }
    
    private void init() {
        // Init frame
        Dimension windowSize = new Dimension(200, 200);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setResizable(false);
        setSize(windowSize);
        setMinimumSize(windowSize);
        setLocationRelativeTo(null);  // position the frame to center
        
        // Init buttons
        ImageIcon clockImage = new ImageIcon(
            getClass().getResource(
                "/id/web/nfrozi/jimagebutton/resource/images/clock-128.png")
        );
        ImageIcon clockImageY = new ImageIcon(
            getClass().getResource(
                "/id/web/nfrozi/jimagebutton/resource/images/clock-128-y.png")
        );
        
        clockButton = new JButton(clockImage);
        clockButton.setBorderPainted(false);      // remove border
        clockButton.setFocusPainted(false);       // remove focus painting
        clockButton.setContentAreaFilled(false);  // remove border
        
        clockButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                clockButton.setIcon(clockImageY);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                clockButton.setIcon(clockImage);
            }
        });
        
        clockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Button clicked " + ++counter + " times.");
            }
        });
        
        // Init Status
        statusLabel = new JLabel("Ready.");
        
        add(clockButton);
        add(statusLabel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        App app = new App();
    }
}
