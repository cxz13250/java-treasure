package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
 * @Date: Created in 下午2:30 2018/9/16
 * @Modified By:
 */
public class LeetCode721 {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountsLen = accounts.size();
        //不再检查已经加到 res中的ArrayList元素
        boolean [] checked = new boolean[accountsLen];
        //判断是否是有相同名字的 ArrayList元素，没有的话直接输出
        HashMap<String, Integer>  nameTimes = new HashMap<>();
        //结果
        List<List<String>> res = new ArrayList<>();
        //首先判断名字是否重复
        for(List<String> tempList : accounts){
            nameTimes.put(tempList.get(0), nameTimes.getOrDefault(tempList.get(0), 0)+1);
        }
        for(int i = 0; i < accountsLen; i++){
            if(!checked[i]){
                checked[i] = true;
                String name = accounts.get(i).get(0);
                List<String> accountsTemp = accounts.get(i);
                HashSet<String> accountsSet = new HashSet<>();
                for(int j = 1; j < accountsTemp.size(); j++){
                    accountsSet.add(accountsTemp.get(j));
                }
                //名字出现一次的直接输出
                if(nameTimes.get(name) == 1){
                    List<String> tempList = new ArrayList<>(accountsSet);
                    //字典排序又想账户
                    Collections.sort(tempList);
                    List<String> subAccounts = new ArrayList<>();
                    subAccounts.add(name);
                    subAccounts.addAll(tempList);
                    res.add(subAccounts);
                }else{
                    //遍历剩下的 ArrayList，找同名的。
                    for(int j = i+1; j < accountsLen; j++){
                        if(!checked[j]){
                            if(name.equals(accounts.get(j).get(0))){
                                for(String ss : accounts.get(j)){
                                    if(accountsSet.contains(ss)){
                                        checked[j] = true;
                                        for(int k = 1; k < accounts.get(j).size(); k++)
                                            accountsSet.add(accounts.get(j).get(k));
                                        //如果找到从头遍历。从而便利出所有两两相重的情况。
                                        j = i;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    List<String> tempList = new ArrayList<>(accountsSet);
                    Collections.sort(tempList);
                    List<String> subAccounts = new ArrayList<>();
                    subAccounts.add(name);
                    subAccounts.addAll(tempList);
                    res.add(subAccounts);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<String>> accounts=new ArrayList<List<String>>(){
            {
                add(new ArrayList<String>(){
                    {
                        add("John");
                        add("johnsmith@mail.com");
                        add("john00@mail.com");
                    }
                });
                add(new ArrayList<String>(){
                    {
                        add("John");
                        add("johnnybravo@mail.com");
                    }
                });
                add(new ArrayList<String>(){
                    {
                        add("John");
                        add("johnsmith@mail.com");
                        add("john_newyork@mail.com");
                    }
                });
                add(new ArrayList<String>(){
                    {
                        add("Mary");
                        add("mary@mail.com");
                    }
                });
            }
        };
        System.out.println(accountsMerge(accounts));
    }
}
