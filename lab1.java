package lab;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Lab1 {
	public static Scanner s = new Scanner(System.in);// ȫ�ֱ���
	public static String str = null;
	public static String str1 = null;
	public static char var;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lab1.expression();//find bugs
	    Lab1.simplify(str,str1);//find bugs
	}
	public static void expression() {
	    // ����Ļ���뵽str
	    System.out.println("Please input polynomial:");
	    str = s.next();
	    System.out.println("Please input your order:");
	    Scanner s1 = new Scanner(System.in);// ����Ļ�������s1��
	    //String str1 = null;
	    str1 = s1.nextLine();
	    s1.close();
	  }
	  
	  /**
	  * set default mock parameter.������˵����
	  * additionalParameters parameter additional(��������)
	  * data manager(����ֵ˵��)
	  * @throws Exception if has error(�쳣˵��)
	  */
	public static String derivative(String exp, char dx) {
	    // ����������expΪҪ����ı��ʽ��dxΪҪ�󵼵ı����� ����ֵ�� ��
	    String[] exparray0 = exp.split("\\+");// �Ե�ʽ��"+"���зָ�������exp_array�ַ���������
	    int explength0 = exparray0.length;// ����������Ŀ��
	    for (int i = 0; i < explength0; i++) {

	      int num = 0;// Ҫ�󵼵ı������ֵĴ���
	      char[] charcount0 = exparray0[i].toCharArray();
	      //����
	      for (int j = 0; j < charcount0.length; j++) {
	        if (charcount0[j] == dx) {
	          num++;
	        }
	      }
	      // �ڱ�������Ϊ0�ε�ʽ�������ֵΪ0
	      if (num == 0) {
	        exparray0[i] = "0";// ������ֵ�滻��ԭֵ
	      } else {
	        String[] temparray0 = exparray0[i].split("");// �ָ�
	        String tempstring = "";
	        // �������滻��һ��
	        for (int k = 0; k < temparray0.length; k++) {
	          if (temparray0[k].equals(String.valueOf(dx))) {
	            temparray0[k] = String.valueOf(num);
	            break;
	          }

	        }
	        for (int o = 0; o < temparray0.length; o++) {
	          tempstring += temparray0[o];
	        }
	        exparray0[i] = tempstring;// ������ֵ�滻��ԭֵ
	      }
	    }
	    // ������
	    String result="";
	    for (int z = 0; z < exparray0.length - 1; z++) {
	      result+=exparray0[z];
	      result+="+";
	    }
	    result+=(exparray0[exparray0.length - 1]);
	    System.out.println(result);
	    return result;
	  }
	  
	  /**
	  * set default mock parameter.������˵����
	  * additionalParameters parameter additional(��������)
	  * data manager(����ֵ˵��)
	  * @throws Exception if has error(�쳣˵��)
	  */
	  public static String simplify(String str,String str1) {
	    // ��
	    //System.out.println("Please input your order:");
	    //Scanner s1 = new Scanner(System.in);// ����Ļ�������s1��
	    //String str1 = null;
	    String regex = null;
	    String replace = null;
	    int lenstr1;
	    //str1 = s1.nextLine();
	    //s1.close();
	    String pattern = "!simplify( [a-z]=[0-9]+)*";// ����ƥ��ģʽ������������������Ƿ���ȷ
	    String pattern1 = "!d/d [a-z]";
	    Pattern r0 = Pattern.compile(pattern);
	    Pattern r1 = Pattern.compile(pattern1);
	    Matcher m0 = r0.matcher(str1);
	    Matcher m1 = r1.matcher(str1);
	    if (str1.equals("!simplify")) {
	      System.out.println(str);
	      System.exit(0);
	    } else if (m0.find()) {
	      // ��⵽������
	      lenstr1 = str1.length();
	      for (int l = 0; l < lenstr1; l++) {
	        if (str1.charAt(l) == '=') {
	          // �ҵ��ĵȺ��ַ���ǰ��һλ��ΪҪ��ֵ����ĸ����������λ��Ϊ��ֵ
	          regex = String.valueOf(str1.charAt(l - 1));
	          int k0;
	          for (k0 = l + 1; k0 < lenstr1; k0++) {
	            if (str1.charAt(k0) == ' ') {
	              // ��ͬ������ֵ֮���пո�ָ������ԴӵȺŵ���һλֱ���ո�ΪҪ��ֵ����ֵ            
	              break;
	            }
	          }
	          replace = str1.substring(l + 1, k0);// ��ȡ֮����ַ��������滻
	          Pattern p0 = Pattern.compile(regex);
	          Matcher m2 = p0.matcher(str);
	          str = m2.replaceAll(replace);
	        }

	      }
	      System.out.println(str);
	    } else if (m1.find()) {
	      // ��⵽������
	      if (str1.length() > 6) {
	        System.out.println("Your order is wrong! Too more vars!");
	        System.exit(0);
	      }
	      var = str1.charAt(str1.length() - 1);// ��ȡҪ�󵼵ı���
	      
	      if (str.indexOf(String.valueOf(var)) >= 0) {
	        // �жϱ����Ƿ��ڶ���ʽ���֣��������������������ֱ�Ӳ���������ƥ������ֱ�ӱ����������
	        derivative(str, var);// �����󵼺���
	      } else {
	        System.out.println("Error, no variable");
	      }
	    } else {
	      return "Your order is wrong!";
	      
	    }
		return str;
	  }
}
