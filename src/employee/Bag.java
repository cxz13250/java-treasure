package employee;

import dataStructure.array.Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ROKG
 * @Description 01背包问题 动态规划
 * @Date: Created in 下午7:35 2018/4/3
 * @Modified By:
 */
public class Bag {

    /**
     *
     * @param c 总重量限制
     * @param weight 各物品重量
     * @param value 各物品价值
     */
    public void knapsackOptimal(int c, int[] weight, int[] value) {
        int n = weight.length;
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] G = new int[n + 1][c + 1];
        for (int i = 1; i < n + 1; i++) {
            w[i] = weight[i - 1];
            v[i] = value[i - 1];
        }
        // values[i]表示总重量不超过i的所有组合中最高的价值
        int[] values = new int[c + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int t = c; t >= w[i]; t--) {
                if (values[t] < values[t - w[i]] + v[i]) {
                    values[t] = values[t - w[i]] + v[i];
                    G[i][t] = 1;
                }
            }
        }
        Base.print(values);
        Base.print(G);
        System.out.println("最大价值为： " + values[c]);
        System.out.print("装入背包的物品编号为： ");
        int i = n;
        int j = c;
        List<Integer> list=new ArrayList<>();
        while (i > 0) {
            if (G[i][j] == 1) {
                list.add(i);
                j -= w[i];
            }
            i--;
        }
        Collections.sort(list);
        for(Integer integer:list){
            System.out.print(integer+ " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] s1=sc.nextLine().split(" ");
        String[] s2=sc.nextLine().split(" ");
        int[] arr=new int[s1.length];
        int[] mb=new int[s1.length];
        for(int i=0;i<s1.length;i++){
            arr[i]=Integer.parseInt(s1[i]);
            mb[i]=Integer.parseInt(s2[i]);
        }
        Bag t=new Bag();
        t.knapsackOptimal(n,arr,mb);
    }
}
