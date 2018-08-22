package com.charlie.offer;

import java.util.Stack;
/*
问题：栈的压入弹出序列，输入两个整数序列，第一个序列表示压入顺序，判断第二个序列是否为弹出顺序.假设入栈所有数字均不相等。
思路：构建辅助栈，以压入序列1、2、3、4、5，弹出序列4、5、3、2、1为例，第一个弹出的是4，所以要先把4压入栈，此时栈里有1234，
弹出栈顶即可，下一个弹出5，就依次压入直到5,弹出。
 */
public class IsPopOrder {
    public static boolean isPopOrder(int[] push,int[] pop){
        boolean result = false;
        //两个序列的长度要相等
        if(push!=null&&pop!=null&&push.length>0&&push.length==pop.length){
            int pushIndex = 0;
            int popIndex = 0 ;
            Stack<Integer> stack = new Stack<>();
            while(popIndex<pop.length){
                //在压入序列中寻找要弹出的数，并把它之前的数全部压入栈
                while(stack.isEmpty()||stack.peek()!=pop[popIndex]){
                    if(pushIndex>=push.length){
                        break;
                    }
                    stack.push(push[pushIndex]);
                    pushIndex++;
                }

                //当压入序列中的数全部压入了栈中但还未找到要弹出的数时，即未找到
                if(stack.peek()!= pop[popIndex]){
                    break;
                }

                //如果弹出序列正确，最后的栈肯定为空
                stack.pop();
                popIndex++;


            }

            if(stack.isEmpty()){
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(isPopOrder(push,pop));
        int[] push2 = {1,2,3,4,5};
        int[] pop2 = {4,5,2,3,1};
        System.out.println(isPopOrder(push2,pop2));
    }
}
