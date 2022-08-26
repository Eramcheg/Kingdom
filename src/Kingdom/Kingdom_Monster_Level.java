package Kingdom;

import Kingdom.Rases.Human;
import Kingdom.Rases.Monster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

public class Kingdom_Monster_Level implements ActionListener {
   public static JLabel[][] jlab = {{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")},{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")},{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")},{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")},{new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X"),new JLabel("X")}};


   private static int Xid=0,Yid=0;
    private static int Xmonster=4,Ymonster=4;
    private static int Xdef=4,Ydef=4;

    private static final double defaultAttack=0.0;
    private static final double defaultHp=10.0;






    static boolean isPause=false;
    static boolean isNewLevel=false;
    static JButton TryAgain =new JButton("Try Again");
    static JButton Left=new JButton("<--");
    static JButton Up=new JButton("|/");
    static JButton Down=new JButton("/|");
    static JButton Right=new JButton("-->");
    static  JFrame jfrm;



    Kingdom_Monster_Level()
    {
        jfrm = new JFrame("Monster");
        jfrm.setLayout(new GridLayout(6,5));
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++)
            {
                jfrm.add(jlab[i][j]);
            }
        }


        Left.addActionListener( this);
        Up.addActionListener(this);
        Down.addActionListener(this);
        Right.addActionListener(this);
        TryAgain.addActionListener(this);
        jfrm.add(Left);
        jfrm.add(Up);
        jfrm.add(Down);
        jfrm.add(Right);
        jfrm.add(TryAgain);
        TryAgain.setVisible(false);
        jfrm.setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){   //Вызов окна приложения
                public void run() {
            new Kingdom_Monster_Level();

        }});


        //findCoords();                               //Код ниже

        Monster m1=new Monster("It",Xmonster,Ymonster,jlab);
        Human h1=new Human("Adam",Xid,Yid,jlab);







        TimerTaskDoLogicOfMonsterWithTimer:             // метка логика монстра таймер
        {
            int Xexit=3,Yexit=4;
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    if(jlab[Xexit][Yexit].getText()=="H")
                    {

                    }
                    else
                    jlab[Xexit][Yexit].setText("Exit");
                    if(isPause)
                    {
                        Eraser();
                        BlockButtons();
                        TryAgain.setVisible(true);

                    }

                    if (isPause == false && isNewLevel==false) {
                        TryAgain.setVisible(false);
                        jlab[Xmonster][Ymonster].setText("X");
                        jlab[Xmonster][Ymonster].setForeground(Color.BLACK);
                        int X = Xmonster - Xid;
                        int Y = Ymonster - Yid;
                        if (X > 0) {
                            Xmonster--;
                        } else if (X < 0) {
                            Xmonster++;
                        }
                        if (Y > 0) {
                            Ymonster--;
                        } else if (Y < 0) {
                            Ymonster++;
                        }

                        if (X == 0 && Y == 0) {
                            Eraser();
                            System.out.println("Catched");
                            h1.kill(h1);
                            isPause=true;

                        }



                        if(Xid==Xexit && Yid==Yexit) //Персонаж нашел выход
                        {


                        }

                        jlab[Xmonster][Ymonster].setText("M");
                        jlab[Xmonster][Ymonster].setForeground(Color.RED);

                    }
                }
            };

            Timer timer=new Timer();
            timer.schedule(timerTask,1000,400);
        }









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
        else if(actionEvent.getActionCommand().equals("<--"))
        {   if(Yid!=0) {
            jlab[Xid][Yid].setText("X");
            jlab[Xid][Yid-1].setText("H");
            jlab[Xid][Yid - 1].setForeground(Color.BLUE);
                        }
        }
        else {
                //Eraser();
                UnBlockButtons();
                isPause=false;
        }
        jlab[Xid][Yid].setForeground(Color.BLACK);

        }
        public static void Eraser(){
        for(int i=0;i<5;i++)
            {
                for(int j=0;j<5;j++)
                {
                    jlab[i][j].setText("X");
                    jlab[i][j].setForeground(Color.BLACK);
                }
            }
        jlab[0][0].setText("H");
        jlab[0][0].setForeground(Color.BLUE);
        jlab[Xdef][Ydef].setText("M");
            jlab[Xdef][Ydef].setForeground(Color.RED);
        Xmonster=Xdef;
        Ymonster=Ydef;
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
        public static void BlockButtons()
        {
            Right.setVisible(false);
            Left.setVisible(false);
            Up.setVisible(false);
            Down.setVisible(false);
        }
        public static void UnBlockButtons()
    {
        Right.setVisible(true);
        Left.setVisible(true);
        Up.setVisible(true);
        Down.setVisible(true);
    }

    }


