package com.hkr;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by v-vetula on 5/11/2016.
 */
public class FibonachiReload {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String array[] = scanner.nextLine().split(" ");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        int input = Integer.parseInt(array[2]);
        Map<Integer, BigInteger> fibMap = new HashMap<Integer, BigInteger>();
        fibMap.put(1, BigInteger.valueOf(a));
        fibMap.put(2, BigInteger.valueOf(b));
        //n+2 = n+1 @ + Tn.
        BigInteger result = getFib(input, fibMap);
        System.out.print(result);
    }

    public static BigInteger getFib(int input, Map map){
        if(map.containsKey(input)) return (BigInteger)map.get(input);
        else{
            BigInteger prev = getFib(input - 1, map);
            BigInteger prev2 = getFib(input -2, map);
            map.put(input, (prev.multiply(prev)).add(prev2));
            return (BigInteger)map.get(input);
        }
    }
}
