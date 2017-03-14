package com.example.administrator.lotterybuy;

import com.example.administrator.lotterybuy.Interface.Strategy;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * 算法C
 */
public class ConcreteStrategyC implements Strategy {
    @Override
    public String strategyInterface(int number) {
        StringBuilder stringbuilder = new StringBuilder();

        for (int i = 0; i < number; i++) {
            stringbuilder.append("红色： ");
            stringbuilder.append(getStringBuilder());
        }
        return stringbuilder.toString();
    }

    private String getStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        Random ran = new Random();
        Set<Integer> set = new TreeSet<>();
        while (true) {
            int a = ran.nextInt(33) + 1;
            set.add(a);
            if (set.size() > 5) {
//                System.out.print(set);
                stringBuilder.append(set);
                break;
            }
        }
//        System.out.println("  "+(ran.nextInt(16)+1));
        stringBuilder.append("  "+(ran.nextInt(16)+1)+"\n");
        return stringBuilder.toString();
    }
}