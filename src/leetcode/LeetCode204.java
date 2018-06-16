package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 统计所有小于非负数整数 n 的质数的数量。
 * @Date: Created in 下午10:56 2018/5/12
 * @Modified By:
 */
public class LeetCode204 {

    public int countPrimes(int n) {
        int[] primes=new int[n+1];
        for (int i=2;i<n;i++){
            primes[i]=1;
        }
        for (int i=2;i*i<=n;i++){
            if (primes[i]==0){
                continue;
            }
            for (int j=i*i;j<n;j+=i){
                primes[j]=0;
            }
        }
        int count=0;
        for (int i=2;i<n;i++){
            if (primes[i]==1){
                count++;
            }
        }
        return count;
    }


    public int countPrimes1(int n) {
        if (n<=2){
            return 0;
        }
        List<Integer> list=new ArrayList<>();
        list.add(2);
        for (int i=3;i<n;i++){
            if (check(i,list)){
                list.add(i);
            }
        }
        return list.size();
    }

    //true 质数
    public boolean check(int n,List<Integer> list){
        for (Integer i:list){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public int countPrimes2(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode204 l=new LeetCode204();
        System.out.println(l.countPrimes(10));
    }
}
