package com.example.administrator.lotterybuy;

import com.example.administrator.lotterybuy.Interface.Strategy;

/**
 * 工厂类
 * @author Huang
 * @time 2017/3/14 0014 14:00
 */
public class OperationFactory {

    public static Strategy createOperate(int oper){
        Strategy strategy = null;
        switch (oper){
            case Constants.CONCRETE_A:
                strategy = new ConcreteStrategyA();
                break;
            case Constants.CONCRETE_B:
                strategy = new ConcreteStrategyB();
                break;
            case Constants.CONCRETE_C:
                strategy = new ConcreteStrategyC();
                break;
        }
        return strategy;
    }
}