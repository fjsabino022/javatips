package javatips.fsabino.important_tips.comparable_vs_comparator;

import java.util.Comparator;

public class PlayerAgeComparator implements Comparator<Player> {
    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
        return (firstPlayer.getAge() - secondPlayer.getAge());
    }
}
