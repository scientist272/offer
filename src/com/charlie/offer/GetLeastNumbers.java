package com.charlie.offer;
/*
面试题30：最小的K个数(涉及快排与堆)
输入n个整数，找出其中最小的k个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。最简单的方法是先排序再输出，复杂度为O(nlogn)，但还有更快的方法。

思路1：类似面试题29，也用快排的思想。快排一轮后检查我们选择的快排的key所在的下标是不是k-1就行了（不一定是排序的）。复杂度为O(n)，但是要修改数组。

思路2：如果不允许修改数组，还有一种O(nlogK)的方法，很适合处理海量数据，即利用大根堆保存K个最小的数。
关于堆：堆是一个完全二叉树，如果按照层序遍历结果存储为数组，下标为i且根节点i=0，则满足Key[i]>=Key[2i+1]&&Key[i]>=key[2i+2]的称为大根堆，即根结点大于子结点，
堆顶为最大值。
关于堆排序：第一步建堆，即将输入序列看作是层序遍历结果，然后按顺序写成完全二叉树的形式。第二步调整堆，即从最后一个非叶结点开始调整，
它的数组下标为最后一个数的下标-1之后除以2，保证这个结点比子结点大。然后下标减一继续调整，交换结点之后的孩子结点有可能不满足堆的性质，继续调整直到下标为0，
这里有递归和非递归两种方法。

堆排序就是根据前边建好的堆先取出根结点和最后一个结点交换，然后对前边len-1个结点进行堆调整，再取出根结点和倒数第二个结点交换，对前边len-2个结点堆调整，
以此类推直到所有结点都取出。heapAdjust函数可看做每次都从当前结点走到叶子节点，数高度为log(n+1)向上取整，所以复杂度可视为O(logn)，
简单起见，不必考虑到底是从根节点到达叶结点还是从中间某节点到达叶结点。建堆时调用heapAdjust函数n/2次，排序时调用heapAdjust函数n-1次，
得到三种情况下的复杂度都是O(logn)*(n/2)+O(logn)*(n-1)，化简为O(nlogn)。空间复杂度O(1)。是不稳定的排序。
两种思路的比较：第一种复杂度O(n)，比第二种快，但是缺点是修改了数组。第二种适合处理大数据，可以一次读一些数据和容器中的k个数比较，不用一次性全部读入数据。


 */
import java.util.Arrays;

public class GetLeastNumbers {

    public static void main(String[] args) {
//        getLeastNumbers1(new int[]{4,5,1,6,2,7,3,8}, 4);
//        System.out.println();
//        getLeastNumbers2(new int[]{4,5,1,6,2,7,3,8}, 4);
      int[] test =new int[]{4,5,1,6,2,7,3,8};
//
      heapSort(test);

//                for(int i:test){
//            System.out.print(i);
//        }
    }


    public static void getLeastNumbers1(int[] array,int k){
        if(array==null||k==0||k>array.length)
            return;

        int start = 0;
        int end = array.length-1;
        int keyIndex = partition(array,start,end);

        while(keyIndex!=k-1){
            if(keyIndex>k-1){
                end = keyIndex-1;
                keyIndex = partition(array,start,end);
            }
            else{
                start = keyIndex+1;
                keyIndex = partition(array,start,end);
            }
        }

        for(int i=0;i<=keyIndex;i++){
            System.out.print(array[i]+" ");
        }

    }

    public static int partition(int[] array,int start,int end){
        if(array==null)
            return -1;
        int i = start;
        int j = end;
        int key = array[start];

        while(i<j){
            while(i<j && key<=array[j]){
                j--;
            }
            array[i] = array[j];
            while(i<j && key>=array[i]){
                i++;
            }
            array[j] = array[i];

        }
        array[i] = key;
        return i;
    }


    public static void getLeastNumbers2(int[] array,int k){
        int[] kArray = Arrays.copyOfRange(array,0,k);
        buildHeap(kArray);
        for(int i=k;i<array.length;i++){
            if(array[i] < kArray[0]){
                kArray[0]=array[i];
                maxHeapify(kArray,k,0);
            }
        }

        for(int i : kArray){
            System.out.print(i+" ");
        }

    }



 //以下为堆排序算法
    //建堆
    public static void buildHeap(int[] array){
        //起始的i为最后一个非叶子结点的下标
        for(int i = (array.length-2)/2;i>=0;i--){
            maxHeapify(array,array.length,i);
        }
    }

    //调整当前堆，使最大的数位于根节点
    public static void maxHeapify(int[] array,int heapSize,int parent){
        int left = 2*parent+1;
        int right = left + 1;
        int largest = parent;
        if(left<heapSize && array[left]>array[largest]){
            largest = left;
        }
        if(right<heapSize && array[right]>array[largest]){
            largest = right;
        }

        if(largest!=parent){
            int temp = array[parent];
            array[parent] = array[largest];
            array[largest] = temp;
            maxHeapify(array,heapSize,largest);
        }
    }

    //堆排序，每次把堆的根节点换到数组最后一个，然后再次调整堆，使最后一个元素之前的数组生成新的堆
    public static void heapSort(int array[]){
        buildHeap(array);
        for(int i=array.length-1;i>0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapify(array,i,0);
        }
    }

}
