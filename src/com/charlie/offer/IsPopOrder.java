package com.charlie.offer;

import java.util.Stack;
/*
���⣺ջ��ѹ�뵯�����У����������������У���һ�����б�ʾѹ��˳���жϵڶ��������Ƿ�Ϊ����˳��.������ջ�������־�����ȡ�
˼·����������ջ����ѹ������1��2��3��4��5����������4��5��3��2��1Ϊ������һ����������4������Ҫ�Ȱ�4ѹ��ջ����ʱջ����1234��
����ջ�����ɣ���һ������5��������ѹ��ֱ��5,������
 */
public class IsPopOrder {
    public static boolean isPopOrder(int[] push,int[] pop){
        boolean result = false;
        //�������еĳ���Ҫ���
        if(push!=null&&pop!=null&&push.length>0&&push.length==pop.length){
            int pushIndex = 0;
            int popIndex = 0 ;
            Stack<Integer> stack = new Stack<>();
            while(popIndex<pop.length){
                //��ѹ��������Ѱ��Ҫ����������������֮ǰ����ȫ��ѹ��ջ
                while(stack.isEmpty()||stack.peek()!=pop[popIndex]){
                    if(pushIndex>=push.length){
                        break;
                    }
                    stack.push(push[pushIndex]);
                    pushIndex++;
                }

                //��ѹ�������е���ȫ��ѹ����ջ�е���δ�ҵ�Ҫ��������ʱ����δ�ҵ�
                if(stack.peek()!= pop[popIndex]){
                    break;
                }

                //�������������ȷ������ջ�϶�Ϊ��
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
