package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 在LeetCode商店中， 有许多在售的物品。
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 * 任意大礼包可无限次购买。
 * @Date: Created in 下午12:42 2018/8/14
 * @Modified By: *
 */
public class LeetCode638 {

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n=price.size();
        int res=Integer.MAX_VALUE;
        for (List<Integer> list:special){
            boolean canUse=true;
            for (int i=0;i<n;i++){
                int remain=needs.get(i)-list.get(i);
                if (remain<0){
                    canUse=false;
                }
                needs.set(i,remain);
            }
            if (canUse){
                res=Math.min(res,shoppingOffers(price,special,needs)+list.get(list.size()-1));
            }
            for (int i=0;i<n;i++){
                needs.set(i,needs.get(i)+list.get(i));
            }
        }
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=needs.get(i)*price.get(i);
        }
        return Math.min(res,sum);
    }

    public static boolean check(List<Integer> price,List<Integer> peck){
        int sum=0;
        for (int i=0;i<price.size();i++){
            sum+=price.get(i)*peck.get(i);
        }
        return sum<peck.get(peck.size()-1);
    }

    public static void main(String[] args) {
        List<Integer> price=new ArrayList<Integer>(){
            {
                add(1);
                add(1);
                add(1);
            }
        };
        List<Integer> needs=new ArrayList<Integer>(){
            {
                add(1);
                add(1);
                add(0);
            }
        };
        List<List<Integer>> special=new ArrayList<List<Integer>>(){
            {
                add(new ArrayList<Integer>(){
                    {
                        add(1);
                        add(1);
                        add(0);
                        add(0);
                    }
                });
                add(new ArrayList<Integer>(){
                    {
                        add(2);
                        add(2);
                        add(1);
                        add(9);
                    }
                });
            }
        };
        System.out.println(shoppingOffers(price,special,needs));
    }
}
