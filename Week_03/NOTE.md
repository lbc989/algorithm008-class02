学习笔记

分治算法 :
将一个规模为N的问题 分解 为K个规模较小的子问题，这些子问题相互独立且与原问题性质相同 。求出子问题的解后进行合并，就可得到原问题的解。
一般步骤 ：

分解 ，将要解决的问题划分成 若干规模较小 的同类问题；
求解 ，当子问题划分得 足够小 时，用较简单的方法解决；
合并 ，按原问题的要求，将子问题的解 逐层合并 构成原问题的解。

回溯算法：
回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。

递归算法：

1、递归终止的条件(recursion terminator)

2、本层业务逻辑(process logic in current level)

3、进入下一层(drill down)

4、(reverse the current level status if needed)