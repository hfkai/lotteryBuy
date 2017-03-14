package com.example.administrator.lotterybuy;

import com.example.administrator.lotterybuy.Interface.Strategy;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 算法B
 */
public class ConcreteStrategyB implements Strategy {
    static  Random ran = new Random();
    static SortedSet set = new TreeSet();
    StringBuilder stringbuilder = new StringBuilder();
    @Override
    public String strategyInterface(int number) {
        for (int i = 0; i < number; i++) {
            stringbuilder.append("红： ");
            set();
        }
        if (stringbuilder == null){
            return "";
        }
        return stringbuilder.toString();
    }

    private void set() {
        set.clear();
        randomSet(6, 6);
        stringbuilder.append(set);
        stringbuilder.append("  蓝色" + (ran.nextInt(16) + 1)+"\n");
    }

    public static void randomSet(int n, int m) {
        for (int i = 0; i < n; i++) {
            set.add(ran.nextInt(33) + 1);
        }
        if (set.size() < m) {
            randomSet(m - set.size(), m);
        }
    }

}