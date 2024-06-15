package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int price = 1000;
    private List<Integer> lotto;
    public int getLottoCount(int purchasePrice){
        if(purchasePrice < price)
            throw new IllegalArgumentException("[ERROR]: 구매금액이 부족합니다.");
        return purchasePrice / price;
    }




}
