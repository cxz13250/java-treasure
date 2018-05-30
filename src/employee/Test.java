package employee;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午5:00 2018/5/18
 * @Modified By:
 */
public class Test {
    static{
        int x=5;
    }
    static int x,y;
    public static void main(String args[]){
        x--;
        myMethod( );
        System.out.println(x+y+ ++x);
    }
    public static void myMethod( ){
        y=x++ + ++x;
    }
}
