package com.charlie.offer;

public class ReplaceBlank {

    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
     * 思路:先计算转换后的字符串总长度，然后用一个指针b指向转换后字符串的末尾，指针a指向转换前的字符串末尾，
     * 然后由a和b由后向前移动，遇到空格就转换。
     *
     * @param string     要转换的字符数组
     * @param usedLength 已经字符数组中已经使用的长度
     * @return 转换后使用的字符长度，-1表示处理失败
     */
	public static void main(String[] args) {
	      char[] string = new char[50];
	        string[0] = ' ';
	        string[1] = 'e';
	        string[2] = ' ';
	        string[3] = ' ';
	        string[4] = 'r';
	        string[5] = 'e';
	        string[6] = ' ';
	        string[7] = ' ';
	        string[8] = 'a';
	        string[9] = ' ';
	        string[10] = 'p';
	        string[11] = ' ';
            int length = replaceBlank(string, 12);
	        System.out.println(new String(string, 0, length));
	}
	
	
	
	
	public static int replaceBlank(char[] string,int usedlength){
		   // 判断输入是否合法
        if (string == null || string.length < usedlength) {
            return -1;
        }

		int whiteCount = 0;
		
		//先统计出字符串中空格的个数		
		for(int i=0;i<usedlength;i++){
			if(string[i]==' '){
				whiteCount++;
			}
		}
		
		
		//计算出替换后的字符串长度
		int targetLength = whiteCount*2+usedlength;
		int temp = targetLength;
		
		//超出了字符数组能容纳的总长度
		if(targetLength>string.length)
			return -1;
		
		//没有空格
		if(whiteCount==0)
			return 0;
		
		usedlength--;
		targetLength--;
		
		 // 字符中有空白字符，一直处理到所有的空白字符处理完
		while(usedlength>=0&&usedlength<targetLength){
			if(string[usedlength]==' '){
				string[targetLength--]='0';
				string[targetLength--]='2';
				string[targetLength--]='%';
			}
			else{
				string[targetLength--] = string[usedlength];
			}
			usedlength--;
		}
		
			return temp;
	}
}
