package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ROKG
 * @Description 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 * @Date: Created in 下午10:16 2018/7/31
 * @Modified By:
 */
public class LeetCode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length()<10){
            return new ArrayList<>();
        }
        List<String> res=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<Character,Integer>(){
            {
                put('A',0);
                put('C',1);
                put('G',2);
                put('T',3);
            }
        };
        Map<Integer,Integer> countMap=new HashMap<>();
        int curlen=0;
        int hash=0;
        for (int i=0;i<s.length();i++){
            curlen++;
            hash=(hash<<2)+map.get(s.charAt(i));
            if (curlen>9){
                hash=(hash&((1<<20) - 1));
                if (countMap.containsKey(hash)&& countMap.get(hash) == 1){
                    countMap.put(hash,countMap.get(hash)+1);
                    String temp=s.substring(i-9,i+1);
                    res.add(temp);
                }else if (!countMap.containsKey(hash)){
                    countMap.put(hash, 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
