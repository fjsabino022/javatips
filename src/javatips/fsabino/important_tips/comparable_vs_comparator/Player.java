package javatips.fsabino.important_tips.comparable_vs_comparator;

public class Player implements Comparable<Player> {

    private int ranking;
    private String name;
    private int age;

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRanking() {
        return ranking;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Player player) {
        return (this.getRanking() - player.getRanking());
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}