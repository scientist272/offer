package com.charlie.offer;

public class ReplaceBlank {

    /**
     * ��ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"�����硰We are happy.�����������We%20are%20happy.����
     * ˼·:�ȼ���ת������ַ����ܳ��ȣ�Ȼ����һ��ָ��bָ��ת�����ַ�����ĩβ��ָ��aָ��ת��ǰ���ַ���ĩβ��
     * Ȼ����a��b�ɺ���ǰ�ƶ��������ո��ת����
     *
     * @param string     Ҫת�����ַ�����
     * @param usedLength �Ѿ��ַ��������Ѿ�ʹ�õĳ���
     * @return ת����ʹ�õ��ַ����ȣ�-1��ʾ����ʧ��
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
		   // �ж������Ƿ�Ϸ�
        if (string == null || string.length < usedlength) {
            return -1;
        }

		int whiteCount = 0;
		
		//��ͳ�Ƴ��ַ����пո�ĸ���		
		for(int i=0;i<usedlength;i++){
			if(string[i]==' '){
				whiteCount++;
			}
		}
		
		
		//������滻����ַ�������
		int targetLength = whiteCount*2+usedlength;
		int temp = targetLength;
		
		//�������ַ����������ɵ��ܳ���
		if(targetLength>string.length)
			return -1;
		
		//û�пո�
		if(whiteCount==0)
			return 0;
		
		usedlength--;
		targetLength--;
		
		 // �ַ����пհ��ַ���һֱ�������еĿհ��ַ�������
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
