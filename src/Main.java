import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Main extends JFrame {
    JFrame f = new JFrame("Timer");
    static Timer timer;
    static LocalTime counter = LocalTime.now();
    JButton start = new JButton("Start");
    JButton colorB = new JButton("Choose color:");
    JButton stop = new JButton("Stop");
    JButton res = new JButton("Restart");
    JLabel l1 = new JLabel("Local time: ");


    Main(){

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        l1.setText("Local time: " + LocalTime.now());
                    }
                });
                timer.start();
            }
        });

        colorB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color backC = JColorChooser.showDialog(null, "Choose color:", Color.red);
                if(backC != null){
                    l1.setForeground(backC);
                }
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });


        res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timer.isRunning()){
                    timer.stop();
                }
                l1.setText("Local time: " + LocalTime.now());
            }
        });

        start.setBounds(20, 100, 130, 40);
        stop.setBounds(230, 100, 130, 40);
        l1.setBounds(120, 30, 150, 100);
        colorB.setBounds(230, 150, 130, 40);
        res.setBounds(20, 150, 130, 40);

        f.add(start);
        f.add(stop);
        f.add(res);
        f.add(colorB);
        f.add(l1);

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(400, 250);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Welcome to timer app");
        Object[] o = {"Settings", "Close"};
        int p = JOptionPane.showOptionDialog(frame, "Choose option:", "Welcome!", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, o, o[0]);
        if(p == JOptionPane.YES_OPTION){
            new Main();
        }

        if(p == JOptionPane.NO_OPTION){
            System.exit(0);
        }
    }
}
