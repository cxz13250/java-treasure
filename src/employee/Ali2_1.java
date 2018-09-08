package employee;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午7:26 2018/9/4
 * @Modified By:
 */
public class Ali2_1 {

    public enum Direction {

        EAST(0),
        WEST(1),
        SOUTH(2),
        NORTH(3),
        UNKNOWN(4);

        int index;

        public int getIndex() {
            return index;
        }

        Direction(int index) {
            this.index = index;
        }

        static Direction getDirectionByIndex(int index){
            for (Direction direction : Direction.values()) {
                if(direction.index == index){
                    return direction;
                }
            }
            return UNKNOWN;
        }

    }

    static int res=Integer.MAX_VALUE;

    static int[] posx=new int[]{1,-1,0,0};  //0East,1WEST,2SOUTH,3NORTH

    static int[] posy=new int[]{0,0,1,-1};

    private static int cal(int[][] map, Direction startDirection, int startX, int startY, Direction endDirection, int endX, int endY, int column) {
        boolean[][] visited=new boolean[map.length][map[0].length];
        check(visited,map,startX,startY,startDirection,endX,endY,endDirection,0);
        return res;
    }

    private static void check(boolean[][] visited,int[][] map,int curX,int curY,Direction curDirection, int endX, int endY,Direction endDirection,int step){
        if (visited[curX][curY]){
            return;
        }
        if (curX==endX&&curY==endY){
            res=Math.min(res,step+Math.abs(curDirection.getIndex()-endDirection.getIndex())>2?1:Math.abs(curDirection.getIndex()-endDirection.getIndex()));
            return;
        }
        visited[curX][curY]=true;
        for (int i=0;i<4;i++){
            int nx=curX+posx[i];
            int ny=curY+posy[i];
            int newStep=step+Math.abs(i-curDirection.getIndex())>2?1:Math.abs(i-curDirection.getIndex());
            Direction newDirection= Direction.getDirectionByIndex(i);
            if (nx>=0&&nx<map.length&&ny>=0&&ny<=map[0].length&&map[nx][ny]==0){
                check(visited,map,nx,ny,newDirection,endX,endY,endDirection,newStep);
            }
        }
    }
}
