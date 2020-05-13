package com.example.shop.utils;

import com.example.shop.utils.AbstractStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AbstractFactory<K,V extends AbstractStrategy<K>>{

    private final List<V> beans;

    private Map<K,V> beansMap;

    @PostConstruct
    public void init() {
        beansMap = beans.stream().collect(Collectors.toMap(AbstractStrategy::getT, Function.identity()));
    }

    public V getByKey (K k) {
        return beansMap.get(k);
    }
}
