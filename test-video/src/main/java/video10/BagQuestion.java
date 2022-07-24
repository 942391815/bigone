package video10;

/**
 * 背包问题
 * 给定两个长度都为N的数组 weights 和values weight[i]和values[i]分别代表i号的重量和价值
 * 给定一个整数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量，返回你能装下最多的价值是多少
 */
public class BagQuestion {
    public static void main(String[] args) {
        int weight[] = {1, 2, 3, 5};
        int values[] = {5, 8, 10, 15};
        int bag = 5;
        System.out.println(getMaxBag(weight, values, bag, 0, 0, 0));
    }

    public static int getMaxBag(int weight[], int values[], int bag, int curBag, int curValues, int index) {
        if (curBag > bag) {
            return 0;
        }
        //退出条件 当前背包等于bag
        if (index == weight.length) {
            return curValues;
        }
        //当前商品分为两种case，要当前商品和不要当前商品
        //case1：要当前商品
        int case1 = getMaxBag(weight, values, bag, weight[index] + curBag, values[index] + curValues, index + 1);
        //case2不要当前商品
        int case2 = getMaxBag(weight, values, bag, curBag, curValues, index + 1);

        return Math.max(case1, case2);
    }
}
