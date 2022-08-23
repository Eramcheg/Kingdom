package Kingdom.Rases;

import javax.swing.*;

public class Human extends Unit {

    final private String Name;
    public Human(String Name)
    {
        super( Rases.Human);
        this.Name=Name;
Hello();
    }
    public Human(String Name, int Xindex,int Yindex, JLabel[][] jlab)
    {
        super( Rases.Human);
        this.Name=Name;
        jlab[Xindex][Yindex].setText("H");
        Hello();
    }
   private void Hello()
    {
        System.out.println("Hi, I'm a Human and my name is "+Name);
    }
    public void kill(Human h){
        System.out.println(h.Name+" have been killed");
        h=null;
        System.gc();

    }


}
