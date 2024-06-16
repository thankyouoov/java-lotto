package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(1, 6,false, 2_000_000_000),
    SECOND(2, 5,true, 30_000_000),
    THIRD(3, 5,false, 1_500_000),
    FOURTH(4, 4,false, 50_000),
    FIFTH(5, 3,false,5_000),
    MISS(6, 0,false, 0);
    private final int rank;
    private final int matchCount;
    private final boolean bonusMatch;

    private final int winningMoney;

    public int getMatchCount() {
        return matchCount;
    }

    public int getRank() {
        return rank;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
    Rank(int rank, int matchCount, boolean bonusMatch, int winningMoney) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.winningMoney = winningMoney;
    }
    public static Rank getRank(int matchCount, boolean bonusMatch){
        return Arrays.stream(values())
                .filter(i -> i.getMatchCount() == matchCount && i.isBonusMatch() == bonusMatch)
                .findFirst()
                .orElse(MISS);
    }

}
