package com.charlie.offer;
/*
������30����С��K����(�漰�������)
����n���������ҳ�������С��k��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4����򵥵ķ���������������������Ӷ�ΪO(nlogn)�������и���ķ�����

˼·1������������29��Ҳ�ÿ��ŵ�˼�롣����һ�ֺ�������ѡ��Ŀ��ŵ�key���ڵ��±��ǲ���k-1�����ˣ���һ��������ģ������Ӷ�ΪO(n)������Ҫ�޸����顣

˼·2������������޸����飬����һ��O(nlogK)�ķ��������ʺϴ��������ݣ������ô���ѱ���K����С������
���ڶѣ�����һ����ȫ��������������ղ����������洢Ϊ���飬�±�Ϊi�Ҹ��ڵ�i=0��������Key[i]>=Key[2i+1]&&Key[i]>=key[2i+2]�ĳ�Ϊ����ѣ������������ӽ�㣬
�Ѷ�Ϊ���ֵ��
���ڶ����򣺵�һ�����ѣ������������п����ǲ�����������Ȼ��˳��д����ȫ����������ʽ���ڶ��������ѣ��������һ����Ҷ��㿪ʼ������
���������±�Ϊ���һ�������±�-1֮�����2����֤��������ӽ���Ȼ���±��һ�����������������֮��ĺ��ӽ���п��ܲ�����ѵ����ʣ���������ֱ���±�Ϊ0��
�����еݹ�ͷǵݹ����ַ�����

��������Ǹ���ǰ�߽��õĶ���ȡ�����������һ����㽻����Ȼ���ǰ��len-1�������жѵ�������ȡ�������͵����ڶ�����㽻������ǰ��len-2�����ѵ�����
�Դ�����ֱ�����н�㶼ȡ����heapAdjust�����ɿ���ÿ�ζ��ӵ�ǰ����ߵ�Ҷ�ӽڵ㣬���߶�Ϊlog(n+1)����ȡ�������Ը��Ӷȿ���ΪO(logn)��
����������ؿ��ǵ����ǴӸ��ڵ㵽��Ҷ��㻹�Ǵ��м�ĳ�ڵ㵽��Ҷ��㡣����ʱ����heapAdjust����n/2�Σ�����ʱ����heapAdjust����n-1�Σ�
�õ���������µĸ��Ӷȶ���O(logn)*(n/2)+O(logn)*(n-1)������ΪO(nlogn)���ռ临�Ӷ�O(1)���ǲ��ȶ�������
����˼·�ıȽϣ���һ�ָ��Ӷ�O(n)���ȵڶ��ֿ죬����ȱ�����޸������顣�ڶ����ʺϴ�������ݣ�����һ�ζ�һЩ���ݺ������е�k�����Ƚϣ�����һ����ȫ���������ݡ�


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



 //����Ϊ�������㷨
    //����
    public static void buildHeap(int[] array){
        //��ʼ��iΪ���һ����Ҷ�ӽ����±�
        for(int i = (array.length-2)/2;i>=0;i--){
            maxHeapify(array,array.length,i);
        }
    }

    //������ǰ�ѣ�ʹ������λ�ڸ��ڵ�
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

    //������ÿ�ΰѶѵĸ��ڵ㻻���������һ����Ȼ���ٴε����ѣ�ʹ���һ��Ԫ��֮ǰ�����������µĶ�
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
