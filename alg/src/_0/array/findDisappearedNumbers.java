package _0.array;

//448. 找到所有数组中消失的数字 - 简单
//给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//要求O(N) O(1)
import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {
    //将每个数放在它应该出现的位置，重复置位-1
    //普通替换法，置对应数组值为负值
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0) res.add(i+1);
        }
        return res;
    }


    //442. 数组中重复的数据 中等
    //找出数组中重复的数据；找到所有出现两次的元素
    //思路：输入数组中用数字的正负来表示该位置所对应数字是否已经出现过。
    // 遍历输入数组，给对应位置的数字取相反数，如果已经是负数，说明前面已经出现过，直接放入输出数组。
    //第一个为负数的
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i]) - 1] < 0) res.add(Math.abs(nums[i]));
            nums[Math.abs(nums[i]) - 1] = - Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        return res;
    }

    //41. 缺失的第一个正数 - hard
    //给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
    // [1,2,0] 3   [3,4,-1,1]  2  [7,8,9,11,12]  1
    //是否数组替换法：将数字对应的位置的数置为负数，第一个不为负数
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int num:nums){//先判断是否有1
            if(num == 1) {
                cnt++;
                break;
            }
        }
        if(cnt == 0) return 1;//没有1的情况
        if(n == 1 && cnt == 1) return 2;//只有1的情况[1]
        for(int i=0;i<n;i++)//将所有的0和负数转换为1
            if(nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        for(int i=0;i<n;i++){//将数字对应的位置转换为负数
            nums[Math.abs(nums[i]) - 1] = - Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for(int i=0;i<n;i++){//第一个不是负数的为缺失数
            if(nums[i] > 0) return i+1;
        }
        return n+1;//当没有缺失数时A[2,1]
    }

    //765. 情侣牵手 - hard
    // 计算最少交换座位的次数,保证(2N-2, 2N-1)连续排列
    public int minSwapsCouples(int[] row) {
        //遍历所有座位对的第一个人
        //它的另一半为当前值异或，即最后一位取反
        //如果此时右手边坐的不他的另一半
        //遍历去找到他的另一半，然后交换
        int res = 0;
        int n = row.length;
        for(int i=0;i<n;i+=2){
            int mate = row[i] ^ 1;
            if(row[i+1] != mate){
                for(int j=i+2;j<n;j++){
                    if(row[j] == mate){
                        int tmp = row[j];
                        row[j] = row[i+1];
                        row[i+1] = row[j];
                        res ++;
                    }
                }
            }
        }
        return res;
    }
}
