package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在
 * @Date: Created in 下午9:05 2018/6/17
 * @Modified By:
 */
public class LeetCode599 {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for (int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int index=Integer.MAX_VALUE;
        for (int i=0;i<list2.length;i++){
            if (map.containsKey(list2[i])){
                if (index>map.get(list2[i])+i){
                    result.clear();
                    result.add(list2[i]);
                    index=i+map.get(list2[i]);
                }else if (index==i+map.get(list2[i])){
                    result.add(list2[i]);
                }
            }
        }
        String[] res=new String[result.size()];
        for (int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s1={"Shogun","Tapioca Express","Burger King","KFC"};
        String[] s2={"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] res=findRestaurant(s1,s2);
        for (String s:res){
            System.out.println(s);
        }
    }
}
