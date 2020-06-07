package com.fsabino.javacodingtips.important_tips.comparable_vs_comparator;

import java.util.Comparator;

public class PlayerRankingComparator implements Comparator<Player> {
    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
        return (firstPlayer.getRanking() - secondPlayer.getRanking());
    }
}
