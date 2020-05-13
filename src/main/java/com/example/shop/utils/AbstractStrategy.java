package com.example.shop.utils;

import lombok.Getter;

public class AbstractStrategy <T> {
    @Getter
    private T t;

    public AbstractStrategy(T t) {
        this.t = t;
    }
}
