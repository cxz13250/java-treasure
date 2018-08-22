package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * @Date: Created in 2018/8/17
 * @Modified By:
 */
public class LeetCode860 {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> map =new HashMap<>();
        if (bills[0]!=5){
            return false;
        }
        map.put(5,1);
        for (int i=1;i<bills.length;i++){
            if (bills[i]==10){
                if (map.get(5)<1){
                    return false;
                }else {
                    map.put(5, map.get(5)-1);
                }
            }else if (bills[i]==20){
                if (map.get(5)>=1&&map.getOrDefault(10,0)>=1){
                    map.put(10, map.get(10)-1);
                    map.put(5, map.get(5)-1);
                }else if (map.get(5)>=3){
                    map.put(5, map.get(5)-3);
                }else {
                    return false;
                }
            }
            map.put(bills[i], map.getOrDefault(bills[i], 0)+1);
        }
        return true;
    }
}
