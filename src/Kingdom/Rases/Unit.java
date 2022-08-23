package Kingdom.Rases;

public class Unit {
    private double Hp;
    private double Attack;
    private Rases Rase;

    public Unit(double Hp, double Attack, Rases Rase)
    {
        this.Hp=Hp;

        this.Attack=Attack;
        this.Rase=Rase;
    }
    public Unit(Rases Rase)
    {
        this.Hp=10;
        this.Attack=0.0;
        this.Rase=Rase;
    }
    public Unit(Unit un)
    {
        Hp=un.Hp;
        Attack=un.Attack;
        Rase=un.Rase;
    }

    public double getHp() {
        return Hp;
    }

    public double getAttack() {
        return Attack;
    }

    public Rases getRase() {
        return Rase;
    }

    public void setHp(double hp) {
        Hp = hp;
    }
}
