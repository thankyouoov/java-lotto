package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResults;
import lotto.util.LottoGameMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public static void runLotto(){
        OutputView.printLottoGameMessage(LottoGameMessage.INPUT_PURCHASE_PRICE);
        int purchasePrice = InputView.inputPurchasePrice();
        int lottoCount = Lotto.getLottoCount(purchasePrice);
        OutputView.printLottoGameMessage(lottoCount + LottoGameMessage.PURCHASE_RESULT);
        makeLottos(lottoCount);
    }

    private static void makeLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        lottos.makeLottos(lottoCount);
        OutputView.printLottoNumber(lottos);
        OutputView.printLottoGameMessage(LottoGameMessage.INPUT_WINNING_NUBMER);
        Lotto winningNumber = new Lotto(InputView.inputLottoNumber());
        OutputView.printLottoGameMessage(LottoGameMessage.INPUT_BONUS_NUBMER);
        int bonusNumber = InputView.inputBonusNumber();
        WinningResults winningResults = lottos.makeResult(winningNumber, bonusNumber);
        OutputView.printLottoResults(winningResults);
    }

}
