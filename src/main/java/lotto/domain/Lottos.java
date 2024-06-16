package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    public Lottos(Lotto... lotto) {
        this(Arrays.stream(lotto).collect(Collectors.toList()));
    }
    public List<Lotto> getLottos() {
        return lottos;
    }
    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
    }

    public WinningResults makeResult(Lotto winningNumber, int bonusNumber) {
        WinningResults winningResults = new WinningResults();
        for(Lotto lotto: lottos){
            LottoGame lottoGame = new LottoGame(lotto);
            int matchCount = lottoGame.getMatchCount(new ArrayList<>(winningNumber.getLottoNumber()));
            boolean matchBonus = lottoGame.isBonusNumberMatch(bonusNumber);
            WinningResult winningResult = new WinningResult(Rank.getRank(matchCount, matchBonus));
            winningResults.addWinningResult(winningResult);
        }
        return winningResults;
    }

    public void makeLottos(int lottoCount) {
        for(int i = 0; i< lottoCount; ++i) {
            Lotto lotto = new Lotto();
            lotto.createLottoNumber();
            this.addLotto(lotto);
        }

    }
}
