package Kingdom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;
public class Kingdom_Goblin_Level {

    public Kingdom_Goblin_Level()
    {

       JFrame jfr=new JFrame();

        jfr.setLayout(new GridLayout(6,5));
        jfr.setSize(500,500);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setVisible(true);

        JLabel jl=new JLabel("Fuck you bitch");


    }
    public static void main(String[] args)
    {

        TimerTask t1=new TimerTask() {
            @Override
            public void run() {
                System.out.println("fuck");
            }
        };
        Timer t=new Timer("Fick");
        t.schedule(t1,100,1000);
    }
}
