package Kingdom.Rases;

import javax.swing.*;

public class Monster extends Unit{
    final private String Name;
    public Monster(String Name, int Xindex,int Yindex, JLabel[][] jlab)
    {
        super( Rases.Human);
        this.Name=Name;
        jlab[Xindex][Yindex].setText("M");

    }
    public Monster(String Name)
    {
        super(100,100,Rases.Monster);
        this.Name=Name;

    }

}
