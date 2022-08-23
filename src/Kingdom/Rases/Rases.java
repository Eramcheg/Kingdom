package Kingdom.Rases;

public enum Rases {
    Monster("Monster"),
    Human("Human"),
    Goblin("Goblin"),
    Pig("Pig");


    private String raseName;
    private Rases(final String raseName)
    {
        this.raseName=raseName;
    }

}
