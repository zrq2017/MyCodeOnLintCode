/*****
最小路径和

给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
**/
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = m - 1; i >= 0; --i){//从右下角开始找两边最小的直到左上角
            for(int j = n - 1; j >= 0; --j){
                if(i == m - 1 && j == n - 1){}//最右下角那个元素啥也不做
                else if(i == m - 1){//最后一行，那就是说明最右下角开始其同行左边元素比上一行同列小，这个时候肯定不是最右下角元素
                    grid[i][j] += grid[i][j + 1];//路径结果累加保存
                }else if(j == n - 1){//最后一列那就是该元素上边的比左边的小
                    grid[i][j] += grid[i + 1][j];
                }else{//剩下的判断同行左边的还是同列上边的大，求累加和
                    //全部遍历会保证从右下角到左上角的值一直都保存，不管后面计算的是不是最小的，至少保证一直从右下角到当前都是最小的，
                    //尽管有几个可能，但是下一次选择最小就排除了其他的部分，直到gird[0][0]
                    grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]);
                }
            }
        }
        return grid[0][0];
    }
}