/*****
下降路径最小和

给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。

下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。

 

示例：

输入：[[1,2,3],[4,5,6],[7,8,9]]
输出：12
解释：
可能的下降路径有：
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
和最小的下降路径是 [1,4,7]，所以答案是 12。

 

提示：

1 <= A.length == A[0].length <= 100
-100 <= A[i][j] <= 100

**/
class Solution {//不需要考虑一行一列的情况，最后会做大小比较
	//直接在遍历的过程计算最小值
    public int minFallingPathSum(int[][] A) {
        int min=Integer.MAX_VALUE;
        int row=A.length,col=A[0].length;
        for(int i=1;i<row;i++){//从第二行开始，记录每一个到a[i][j]位置的最小值，最后即可获得最后一行的最小值
            for(int j=0;j<col;j++){
                if(j==0){//最左边的处理
                    A[i][j]+=Math.min(A[i-1][j],A[i-1][j+1]);
                }else if(j==col-1){//最右边的处理
                    A[i][j]+=Math.min(A[i-1][j-1],A[i-1][j]);
                }else{//中间处理
                    A[i][j]+=Math.min(Math.min(A[i-1][j-1],A[i-1][j]),A[i-1][j+1]);
                }
            }
        }
        for(int i=0;i<col;i++){
            min=Math.min(A[row-1][i],min);
        }
        return min;
    }
}