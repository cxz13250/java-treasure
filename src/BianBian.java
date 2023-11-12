import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午11:06 2021/5/24
 * @Modified By:
 */
public class BianBian {

    double Sum(double[] data) {
        double sum = 0;
        for (int i = 0; i < data.length; i++)
            sum = sum + data[i];
        return sum;
    }

    double Mean(double[] data) {
        double mean = 0;
        mean = Sum(data) / data.length;
        return mean;
    }


    double POP_Variance(double[] data) {
        double variance = 0;
        for (int i = 0; i < data.length; i++) {
            variance = variance + (Math.pow((data[i] - Mean(data)), 2));
        }
        variance = variance / data.length;
        return variance;
    }

    double match(List<Double> a, List<Double> b) {
        Integer i = new Random().nextInt(3);
        Integer j = new Random().nextInt(3);
        return a.get(i) / b.get(j);
    }

    public static void main(String[] args) {
        List<Double> data1 = new ArrayList<>();
        System.out.println();
    }
}
