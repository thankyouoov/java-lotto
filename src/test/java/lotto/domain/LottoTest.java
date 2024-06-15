package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Set;

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

    @DisplayName("발급된 로또의 숫자가 6개인지 확인한다.")
    @Test
    void checkLottoNumberCount(){
        Lotto lotto = new Lotto();
        int lottoSize = lotto.createLottoNumber().size();
        assertThat(lottoSize).isEqualTo(6);
    }

    @DisplayName("발급된 로또의 숫자가 1~45 사이의 숫자인지 확인한다.")
    @Test
    void validateLottoNumber(){
      Lotto lotto = new Lotto();
      Set<Integer> lottoNumber = lotto.createLottoNumber();
      assertThat(lottoNumber).allSatisfy(number -> assertThat(number).isBetween(1,45));
    }

    @DisplayName("발급된 로또의 숫자가 중복되지 않는지 확인한다.")
    @Test
    void isContainDuplicatesLottoNumber(){
        Lotto lotto = new Lotto();
        Set<Integer> lottoNumber = lotto.createLottoNumber();
        System.out.println(lottoNumber);
        assertThat(lottoNumber).doesNotHaveDuplicates();
    }



}