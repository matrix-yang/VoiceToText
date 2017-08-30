import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/8/30.
 */
public class runTest extends JFrame{

    public void init( ToText toText){
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        JButton buttonSimple = new JButton("start");
        JButton buttonSimple1 = new JButton("stop");
        MetalButtonUI ui = new MetalButtonUI() {
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                if ( b.isContentAreaFilled() ) {
//                  Dimension size = b.getSize();
                    g.setColor(getSelectColor());
//                  g.fillRect(0, 0, size.width, size.height);
                }
            }
        };
        buttonSimple.setUI(ui);
        buttonSimple1.setUI(ui);

        buttonSimple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               toText.startListening();
                System.out.println("startListening-----------------------------------------");
            }
        });
        buttonSimple1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toText.stopListening();
                System.out.println("stopListening-----------------------------------------");
            }
        });

        container.add(buttonSimple);
        container.add(buttonSimple1);
    }
    public static void main(String[] args) {
        ToText toText=new ToText();


        runTest frame = new runTest();
        frame.init(toText);
        frame.setTitle("Test");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 300, 100);
    }
}
