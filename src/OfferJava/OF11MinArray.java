package OfferJava;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 11568
 * @date: 2020/05/20
 * Time: 18:19
 * Description:11 旋转数组的最小数字 easy
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 思路：看了一下题意其实解决方法就是找到数组中最小的数字，因为本身原数组是一个递增的数组。最简单的就是排序一下找到最小的数字，但是本题考查的应该是二分法。
 * 时间复杂度为O(logN)，空间复杂度为O(1)
 */
public class OF11MinArray {

    /**
     * 错误解答  错误的原因是用numbers[mid]与numbers[low]进行对比的话，无法确认旋转点是在右半部分还是左半部分
     * 一个递增数组旋转，那么以旋转点分割形成的前半部分与后半部分也分别是递增序列
     * 无法判定 m在左（右）排序数组： 设以下两个旋转点值为 0的示例数组，则当 low = 0, high = 4 时 mid = 2 ，两示例结果不同。
     *
     * 例 [1, 0, 1, 1, 1]：旋转点 x = 1，因此 mid = 2 在 右排序数组 中。
     * 例 [1, 1, 1, 0, 1]：旋转点 x = 3 ，因此 mid = 2在 左排序数组 中。
     * high = high - 1 操作的正确性证明： 只需证明每次执行此操作后，旋转点 x仍在 [low, high] 区间内即可。
     *
     * 若 mid 在右排序数组中： numbers[mid] == numbers[high] ，因此数组 [mid, high]（恒有 mid < high）区间内所有元素值相等，执行 high = high - 1只会抛弃一个重复值，
     * 因此旋转点 x仍在 [low, high]区间内。
     * 若 mid 在左排序数组中： 由于 左排序数组 任一元素 >= 右排序数组 任一元素 ，因此可推出旋转点元素值 numbers[x] <= numbers[high] == numbers[mid]，则有：
     * 若 numbers[x] < numbers[high] ： 即 jj 左方仍有值更小的元素，执行 high = high - 1 后旋转点 x仍在 [low, high]区间内。
     * 若 numbers[x] == numbers[high] ： 分为以下两种情况。
     * 当 high>x ： 易得执行 high = high - 1后旋转点 x仍在 [low, high]区间内。
     * 当 high=x： 特殊情况，即执行 high = high - 1 后旋转点 x可能不在 [low, high] 区间内。例如 [1, 1, 1, 2, 3, 1]，当 low = 0 , mid = 2 , high = 5时
     * 执行 high = high - 1后虽然 丢失了旋转点索引 x = 5，
     * 但最终返回值仍正确(最终返回的 numbers[0] 等于旋转点值 numbers[5] ),这是因为：之后的二分循环一直在执行 high = mid，而区间 [low, mid]内的元素值一定都等于旋转点值 numbers[x]
     * （ ∵ 区间内元素值既要满足 ≥ 也要满足 ≤ numbers[x]） ，因此 仍可保证正确的返回值 。
     */
//    public static int minArray(int[] numbers){
//        int low = 0;
//        int high = numbers.length - 1;
//        while (low < high){
//            int mid = (low + high) / 2;
//            if(numbers[low] < numbers[mid]){
//                low = mid + 1;
//            }else if(numbers[low] > numbers[mid]) {
//                high = mid;
//            }else {
//                high --;
//            }
//        }
//        return numbers[low];
//    }

    /**
     *
     * @param numbers
     * @return
     */
    public static int minArray_1(int[] numbers){
        int low = 0;
        int high = numbers.length - 1;
        while (low < high){
            int mid = (low + high) / 2;
            if(numbers[high] < numbers[mid]){
                low = mid + 1;
            }else if(numbers[high] > numbers[mid]) {
                high = mid;
            }else {
                high --;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3,4,5,1,2};
        System.out.println(minArray_1(numbers));
    }
}
