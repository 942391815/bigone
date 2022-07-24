package video10;

/**
 * 给定一个整形数组arr 代表数值不同的纸牌排成一条直线，玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿
 * 但是每个玩家，每次只能拿走最左或最有的纸牌，玩家A和玩家B都是绝顶聪明，请返回最后获胜者的分数
 * <p>
 * 举例：array=[1,2,100,4]
 * 开始时，玩家A只能从1或者4，如果开始是玩家A拿走1，则排列变为[2,100,4],接下来玩家B可以拿走2或者4，然后继续轮到玩家A
 * 如果玩家A拿走4则序列变为【1，2，100】，接下来玩家B可以拿走1或者100，然后继续轮到玩家A
 * 玩家A作为绝顶聪明的人不会先拿4，因为先拿4，玩家B将拿走100，所以玩家A会先拿1然排列变为【12，100，4】接下来玩家B不管怎么选
 * 100都会被玩家A拿走，玩家A会获胜，分数为101，所以返回101
 * array=[1,100,2] 开始时玩家A不管拿1还是2，玩家B作为决定聪明的人，100都会被拿走，玩家B会获胜，分数为100，所以返回100
 */
public class CardGame {
    public static void main(String[] args) {
        int array[] = {1, 2, 100, 4};
        System.out.println(win1(array));
    }

    public static int win1(int array[]) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return Math.max(f(array, 0, array.length - 1), s(array, 0, array.length - 1));
    }

    public static int f(int array[], int i, int j) {
        if (i == j) {
            return array[i];
        }
        return Math.max(array[i] + s(array, i + 1, j), array[j] + s(array, i, j - 1));
    }

    public static int s(int array[], int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(array, i + 1, j), f(array, i, j - 1));
    }
}
