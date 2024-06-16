package lotto.domain;

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
}
