package lab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class control {
	public static int match(String str,String str1){
		String pattern = "!simplify( [a-z]=[0-9]+)*";// ����ƥ��ģʽ������������������Ƿ���ȷ
	    String pattern1 = "!d/d [a-z]";
	    Pattern r0 = Pattern.compile(pattern);
	    Pattern r1 = Pattern.compile(pattern1);
	    Matcher m0 = r0.matcher(str1);
	    Matcher m1 = r1.matcher(str1);
	    if(m0.find()){
	    	return 1;
	    }
	    else if(m1.find()){
	    	return 2;
	    }
	    else{return 3;}
		
	}
	public static String getRegex(String str1,String regex){
		int lenstr1;
		lenstr1 = str1.length();
		for (int l = 0; l < lenstr1; l++) {
		        if (str1.charAt(l) == '=') {
		          // �ҵ��ĵȺ��ַ���ǰ��һλ��ΪҪ��ֵ����ĸ����������λ��Ϊ��ֵ
		          regex = String.valueOf(str1.charAt(l - 1));
		        }
		}
		return regex;
	}
	public static String getReplace(String str1,String replace){
		int lenstr1;
		lenstr1 = str1.length();
		for (int l = 0; l < lenstr1; l++) {
		        if (str1.charAt(l) == '=') {
		          int k0;
		          for (k0 = l + 1; k0 < lenstr1; k0++) {
		            if (str1.charAt(k0) == ' ') {
		              // ��ͬ������ֵ֮���пո�ָ������ԴӵȺŵ���һλֱ���ո�ΪҪ��ֵ����ֵ            
		              break;
		            }
		          }
		          replace = str1.substring(l + 1, k0);// ��ȡ֮����ַ��������滻
		        }
		}
		return replace;
		
	}
}
