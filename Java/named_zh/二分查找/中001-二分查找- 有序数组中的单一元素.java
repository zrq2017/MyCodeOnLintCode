/*****
 有序数组中的单一元素

给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

示例 1:

输入: [1,1,2,3,3,4,4,8,8]
输出: 2
示例 2:

输入: [3,3,7,7,10,11,11]
输出: 10

**/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            int m=(r-l)/2+l;
            if(m%2==1){
                m--;//出现两次的都会是偶数位开始，所以保证m是偶数
            }
            if(nums[m]==nums[m+1]){
                l=m+2;//左边是正常的偶数区间
            }else{
                r=m;//说明左边存在出现一次的数
            }
        }
        return nums[r];
    }
}