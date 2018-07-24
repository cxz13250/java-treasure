package multiThreading;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Hashtable;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:15 2018/5/8
 * @Modified By:
 */
public class MyHashTable {

    public static void main(String[] args) {
        Hashtable<Integer,Integer> table=new Hashtable<>();
        ThreadMXBean t=ManagementFactory.getThreadMXBean();
        ThreadInfo[] ts=t.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo:ts){
            System.out.println(threadInfo.getThreadId()+" "+threadInfo.getThreadName()+" "+threadInfo.getThreadState());
        }
    }
}
