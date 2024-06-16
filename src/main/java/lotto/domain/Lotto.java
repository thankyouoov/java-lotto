package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int price = 1000;

    private Set<Integer> lottoNumber;

    public Lotto(){
        this.lottoNumber = new HashSet<>();
    }

    public Lotto(List<Integer> inputLottoNumber){
        this.lottoNumber = new HashSet<>(inputLottoNumber) ;
    }
    public Set<Integer> getLottoNumber() {
        return lottoNumber;
    }
    public int getLottoCount(int purchasePrice){
        if(purchasePrice < price)
            throw new IllegalArgumentException("[ERROR]: 구매금액이 부족합니다.");
        return purchasePrice / price;
    }
    public Set<Integer> createLottoNumber(){
        List<Integer> shuffledNumbers = new ArrayList<>();
        for(int i = 1; i<=45 ; ++i)
            shuffledNumbers.add(i);
        Collections.shuffle(shuffledNumbers);
        lottoNumber = new TreeSet<>(shuffledNumbers.stream()
                                                   .limit(6)
                                                   .collect(Collectors.toSet()));
        return lottoNumber;
    }





}
