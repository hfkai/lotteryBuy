package com.example.administrator.lotterybuy.model;

import com.example.administrator.lotterybuy.Interface.Strategy;

/**
 * 搅拌类
 */
public class Operation {

    private Strategy strategy;

    public Operation(Strategy strategy){
        this.strategy = strategy;
    }

    public String play(int number){
        return strategy == null ? "":strategy.strategyInterface(number);
    }
}
