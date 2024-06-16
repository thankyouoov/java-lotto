package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(1, 6,false),
    SECOND(2, 5,true),
    THIRD(3, 5,false),
    FOURTH(4, 4,false),
    FIFTH(5, 3,false),
    MISS(6, 0,false);
    private final int rank;
    private final int matchCount;
    private final boolean bonusMatch;

    public int getMatchCount() {
        return matchCount;
    }

    public int getRank() {
        return rank;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
    Rank(int rank, int matchCount, boolean bonusMatch) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }
    public static Rank getRank(int matchCount, boolean bonusMatch){
        return Arrays.stream(values())
                .filter(i -> i.getMatchCount() == matchCount && i.isBonusMatch() == bonusMatch)
                .findFirst()
                .orElse(MISS);
    }

}
