package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private Lotto lotto;

    public LottoGame(Lotto inputLotto){
        this.lotto = inputLotto;
    }
    public Lotto getLotto() {
        return lotto;
    }
    public int getMatchCount(List<Integer> winningLotto){
        Set<Integer> compareLottoNumber = new HashSet<>(lotto.getLottoNumber());
        compareLottoNumber.retainAll(winningLotto);
        return compareLottoNumber.size();
    }

}
