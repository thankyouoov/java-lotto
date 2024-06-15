package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTest {
    @DisplayName("구매금액에 따른 로또 개수를 구한다.")
    @ValueSource(ints = {1000,4000,16000})
    @ParameterizedTest
    void getLottoCount(int purchasePrice){
        Lotto lotto = new Lotto();
        int lottoCount = lotto.getLottoCount(purchasePrice);
        assertThat(lottoCount).isEqualTo(purchasePrice / 1000);
    }





}