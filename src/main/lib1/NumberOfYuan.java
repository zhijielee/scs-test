package main.lib1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberOfYuan {

    Map<Integer, Integer> coins_map = new LinkedHashMap<Integer, Integer>() {{
        put(50, 1);
        put(20, 1);
        put(5, 2);
        put(1, 3);
    }};

    /**
     *硬币数量处理函数
     * @param value
     */
    public boolean giveMoney(int value) {
        for(Map.Entry<Integer, Integer> entry : coins_map.entrySet()) {
            int num = 0;
            while(value >= entry.getKey() && entry.getValue() > 0) {
                value = value - entry.getKey();
                coins_map.put(entry.getKey(), entry.getValue() - 1);
                num = num + 1;
            }
        }

        if(value == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * main函数，用于值的输入，以及输入值的判断
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("输入要取出的金钱数目：");
//        if(scan.hasNextInt()) {
//            int number = scan.nextInt();
//            if(number > 0) {
//                givenNumber(number);
//            }else {
//                System.out.println("请输入一个大于0的整数");
//            }
//        } else {
//            System.out.println("请输入一个整数");
//        }
//
//    }

}
