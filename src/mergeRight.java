/**
 * Created by LiJie on 2017/2/21.
 */
public class mergeRight {
	public static void main(String[] args) {
		String[]  rightValues={"1000","11111100","1001010100"};
		System.out.println(mergeRightValue(rightValues));
	}
	/**
	 * 合并权限
	 * @param rightValues 权限的二进制字符串 例如 1000、11111100、1001010100
	 * @return 合并后的权限 1111110100
	 * 1代表有权限 0代表没权限
	 * 二进制  相或的结果
	 */
	public static String mergeRightValue(String[] rightValues){
		//传入的数组长度length
		int length=rightValues.length;
		//判断权限的最大长度maxLength
		int maxLength=0;
		for(int i=0;i<length;i++){
			if(rightValues[i].length()>maxLength){
				maxLength=rightValues[i].length();
			}
		}
		//给小于最大长度的权限后面加零
		for(int i=0;i<length;i++){
			int cha=maxLength-rightValues[i].length();
			if(cha>0){
				for(int k=0;k<cha;k++){
					rightValues[i]=rightValues[i]+"0";
				}
			}
		}
		//r数组存放二进制转成十进制的数
		int[] r=new int[length];
		//for循环将二进制转换成十进制
		for(int i=0;i<length;i++) {
			String rights=rightValues[i];
			int x=0;
			for (char c : rights.toCharArray()) {
				x = x * 2 + (c == '1' ? 1 : 0);
			}
			r[i]=x;
		}
		int right = r[0];
		//for循环执行或运算
		for(int i=1;i<length;i++){
			right=right|r[i];
		}
		//十进制转成二进制
		return Integer.toBinaryString(right);
	}

}
