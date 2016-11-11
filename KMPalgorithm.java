
/**
 * Java实现KMP算法
 * <p/>
 * 思想：每当一趟匹配过程中出现字符比较不等，不需要回溯i指针，
 * 而是利用已经得到的“部分匹配”的结果将模式向右“滑动”尽可能远
 * 的一段距离后，继续进行比较。
 * <p/>
 * 时间复杂度O(n+m)
 *
 * @author wcj
 */






public class KMPalgorithm {


    /**
     * 获得字符串的next函数值
     *
     * @param p 模板字符串
     *
     * @param nextval 存放next值的数组
     * @param plen  字符串p的长度
     * @author wcj
     */


    public static void getNextval(char p[], int nextval[], int plen) {
        nextval[0] = -1;
        int k = -1, j = 0;
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                nextval[++j] = ++k;
            } else {
                k = nextval[k];
            }
        }

    }


    /**
     * 获得字符串的next函数值
     *
     * @param p 模板字符串
     *
     * @param nextval 存放next值的数组
     * @param t  目标字符串
     * @return 找到的字符串数
     *
     * @author wcj
     */


    public static int KMPSort(char p[], int nextval[], char t[]) {
        int end = t.length;
        int i = 0, j = 0;
        int count = 0;
        boolean isSuccess = false;
        while (i < end) {
            j = 0;
            while (p[j] == t[i]) {
                j++;
                i++;
                if (j == (p.length)) {
                    count++;
                    isSuccess = true;
                    break;
                }
                }
            if (isSuccess == true) {

            } else {
                if (j > 0) {
                    int runNum = j - nextval[j - 1];
                    i += runNum;
                } else if(j==0) {
                    i++;
                }
            }
            isSuccess = false;
            if (i > t.length - 1) {
                break;
            }
        }
        return count;

    }

    public static void main(String[] args) {

        String p = "ABC";//模板字符串
        String t = "ABCDABDaaABCavcccccccccavcsssssavcDABDddABCDABDABCDAddBD";//目标字符串
        int[] next = new int[p.length()];
        getNextval(p.toCharArray(), next, t.length());
        System.out.print("Next数组为：");
        for (int i = 0; i < next.length; i++)
            System.out.print(next[i]);
        System.out.println();

        System.out.println("find" + KMPSort(p.toCharArray(), next, t.toCharArray()));


    }


}
