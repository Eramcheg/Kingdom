package Kingdom;

import Kingdom.Rases.Human;
import Kingdom.Rases.Monster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

public class Kingdom implements ActionListener {
   public static JLabel[][] jlab = {{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")},{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")},{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")},{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")},{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")}};

    static int Xid=0,Yid=0;
    static int Xmonster=4,Ymonster=4;
    Kingdom()
    {
        JFrame jfrm = new JFrame("A Simple Swing Application");
        jfrm.setLayout(new GridLayout(6,5));
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++)
            {
                jfrm.add(jlab[i][j]);
            }
        }
        JButton Left=new JButton("<--");
        JButton Up=new JButton("|/");
        JButton Down=new JButton("/|");
        JButton Right=new JButton("-->");
        Left.addActionListener( this);
        Up.addActionListener(this);
        Down.addActionListener(this);
        Right.addActionListener(this);
        jfrm.add(Left);
        jfrm.add(Up);
        jfrm.add(Down);
        jfrm.add(Right);
        jfrm.setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){   //Вызов окна приложения
                public void run() {
            new Kingdom();
        }});


        findCoords();                               //Код ниже
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                jlab[Xmonster][Ymonster].setText("X");
                jlab[Xmonster][Ymonster].setForeground(Color.BLACK);
                int X=Xmonster-Xid;
                int Y=Ymonster-Yid;
                if(X>0)
                {//if(Xmonster!=0)
                    Xmonster--;}
                else if(X<0)
                {//if(Xmonster!=4)
                        Xmonster++;}
                else if (X==0) {
                    if(Y>0)
                    {
                        Ymonster--;
                    } else if (Y<0) {
                        Ymonster++;
                    } else if (Y==0) {
                        System.out.println("GOT YOU");
                    }
                }



                jlab[Xmonster][Ymonster].setText("M");
                jlab[Xmonster][Ymonster].setForeground(Color.RED);

            }
        };
        Timer timer=new Timer();
        timer.schedule(timerTask,1000,750);
        Monster m1=new Monster("It",4,4,jlab);
        Human h1=new Human("Adam",0,0,jlab);

        System.out.println("Kingdom was succesfully founded");


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) { // УПРАВЛЕНИЕ ПЕРСОНАЖЕМ
        findCoords();

        if(actionEvent.getActionCommand().equals("|/") )
        {   if(Xid!=4) {
                jlab[Xid][Yid].setText("X");
                jlab[Xid + 1][Yid].setText("H");
            jlab[Xid+1][Yid ].setForeground(Color.BLUE);
                        }

        }
        else if(actionEvent.getActionCommand().equals("/|")) {
            if (Xid != 0) {
                jlab[Xid][Yid].setText("X");
                jlab[Xid - 1][Yid].setText("H");
                jlab[Xid-1][Yid ].setForeground(Color.BLUE);
            }
        }
        else if(actionEvent.getActionCommand().equals("-->")) {
            if (Yid != 4) {
                jlab[Xid][Yid].setText("X");
                jlab[Xid][Yid + 1].setText("H");
                jlab[Xid][Yid + 1].setForeground(Color.BLUE);
            }
        }
        else
        {   if(Yid!=0) {
            jlab[Xid][Yid].setText("X");
            jlab[Xid][Yid-1].setText("H");
            jlab[Xid][Yid - 1].setForeground(Color.BLUE);
                        }
        }
        jlab[Xid][Yid].setForeground(Color.BLACK);

        }
        public static void findCoords()  // Метод нахождения позиции Монстра и Игрока
        {

            for(int i=0;i<5;i++)
            {
                for(int j=0;j<5;j++)
                {
                    if(jlab[i][j].getText()=="H")
                    {Xid=i;
                        Yid=j;
                    }
                    if(jlab[i][j].getText()=="M")
                    {
                        Xmonster=i;
                        Ymonster=j;
                    }
                }
            }
        }
    }


