package com.example.administrator.lotterybuy;

import com.example.administrator.lotterybuy.Interface.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法A
 */
public class ConcreteStrategyA implements Strategy {

    @Override
    public String strategyInterface(int number) {
        int x = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int d = 0; d < number; d++) {
            stringBuilder.append("红： ");
            List<String> set = new ArrayList<>();   //剔除重复数字
            for (int j = 0; j < 7; j++) {
                for (int i = 0; i < 1000; i++) {
                    if (j == 6) {
                        x = 1+(int)(Math.random()*16);
                    }else{
                        x = 1+(int)(Math.random()*33);
                    }
                    if (i == 499) {
                        if (j == 6) {
                            if (set.contains(x+"")) {
                                j--;
                            }else{
                                stringBuilder.append(" 篮："+x);
                            }
                        }else{
                            if (set.contains(x+"")) {
                                j--;
                            }else{
                                stringBuilder.append(x+" ");
                            }
                        }
                        set.add(x+"");
                    }
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}