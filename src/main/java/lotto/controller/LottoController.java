package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResults;
import lotto.util.LottoGameMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Scanner;

public class LottoController {
    public static void runLotto(){
        OutputView.printLottoGameMessage(LottoGameMessage.INPUT_PURCHASE_PRICE);
        int purchasePrice = InputView.inputInteger();
        OutputView.printLottoGameMessage(LottoGameMessage.INPUT_MANUAL_LOTTO_COUNT);
        int manualLottoCount = InputView.inputInteger();
        int lottoCount = Lotto.getLottoCount(purchasePrice);
        makeLottos(lottoCount, manualLottoCount);
    }

    private static void makeLottos(int lottoCount, int manualLottoCount) {
        Lottos lottos = new Lottos();
        inputManualLottoNumber(lottos, manualLottoCount);
        OutputView.printLottoGameMessage(String.format(LottoGameMessage.PURCHASE_RESULT,manualLottoCount,lottoCount-manualLottoCount));
        lottos.makeAutoLottos(lottoCount - manualLottoCount);
        OutputView.printLottoNumber(lottos);
        OutputView.printLottoGameMessage(LottoGameMessage.INPUT_WINNING_NUBMER);
        Lotto winningNumber = new Lotto(InputView.inputLottoNumber());
        OutputView.printLottoGameMessage(LottoGameMessage.INPUT_BONUS_NUBMER);
        int bonusNumber = InputView.inputInteger();
        WinningResults winningResults = lottos.makeResult(winningNumber, bonusNumber);
        OutputView.printLottoResults(winningResults);
    }

    private static void inputManualLottoNumber(Lottos lottos, int manualLottoCount) {
        OutputView.printLottoGameMessage(LottoGameMessage.INPUT_MANUAL_LOTTO_NUBMER);
        for(int i =0; i< manualLottoCount; ++i){
            lottos.addLotto(new Lotto(InputView.inputLottoNumber()));
            if(i != manualLottoCount - 1)
                InputView.clearInputBuffer();
        }

    }

}
