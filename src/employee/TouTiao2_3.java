package employee;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 上午9:49 2018/5/12
 * @Modified By:
 */
public class TouTiao2_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lineNum = in.nextInt();

        StringBuilder builder = new StringBuilder();
        for (int i=0;i<lineNum;i++) {
            int numOfPeople = in.nextInt();
            int numOfQuit = in.nextInt();
            long[] people = LongStream.range(0, numOfPeople).toArray();
            int[] quit = new int[numOfQuit];
            for (int j=0;j<numOfQuit;j++) {
                quit[j] = in.nextInt();
            }
            int idxOfPeople = 0, idxOfQuit = 0;
            while (people.length > 1) {
                int q = quit[idxOfQuit];
                if (q > people.length) q = q % people.length;
                idxOfPeople = (q - 1 + idxOfPeople) % people.length;
                people[idxOfPeople] = -1;

                people = Arrays.stream(people).parallel().filter(val -> val >= 0).toArray();
                idxOfPeople = idxOfPeople % people.length;

                idxOfQuit++;
                idxOfQuit = idxOfQuit % numOfQuit;
            }

            builder.append(people[0]).append("\n");
        }
        System.out.println(builder.toString());
    }
}
