package id.web.nfrozi.jimagebutton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author nfrozi
 */
public class App extends JFrame {
    
    private JButton clockButton;

    public App() {
        super("Image Button Example v1.0");
        init();
    }
    
    private void init() {
        Dimension windowSize = new Dimension(320, 240);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(windowSize);
        setMinimumSize(windowSize);
        setLocationRelativeTo(null);  // position the frame to center
        
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
        
        add(clockButton);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        App app = new App();
    }
}
