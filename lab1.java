package lab1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//git test line
public class lab1 {
	public static Scanner s = new Scanner(System.in);// ȫ�ֱ���
	public static String str = null;
	public static char var;

	public static void main(String[] args) {
		// Scanner s=new Scanner(System.in);
		// String str=null;
		lab1 a = new lab1();
		a.expression();
		a.simplify();
	}

	public static void expression()// ����Ļ���뵽str
	{
		System.out.println("Please input polynomial��");
		str = s.next();
	}

	public static void simplify()// ��
	{
		System.out.println("Please input your order��");
		Scanner s1 = new Scanner(System.in);// ����Ļ�������s1��
		String str1 = null;
		String regex = null;
		String replace = null;
		int lenstr1;
		str1 = s1.nextLine();
		String pattern = "!simplify( [a-z]=[0-9]+)*";// ����ƥ��ģʽ������������������Ƿ���ȷ
		String pattern1 = "!d/d [a-z]";
		Pattern r = Pattern.compile(pattern);
		Pattern r1 = Pattern.compile(pattern1);
		Matcher m = r.matcher(str1);
		Matcher m1 = r1.matcher(str1);
		if (str1.equals("!simplify")) {
			System.out.println(str);
			System.exit(0);
		} else if (m.find())// ��⵽������
		{
			lenstr1 = str1.length();
			for (int l = 0; l < lenstr1; l++) {
				if (str1.charAt(l) == '=')// �ҵ��ĵȺ��ַ���ǰ��һλ��ΪҪ��ֵ����ĸ����������λ��Ϊ��ֵ
				{
					regex = String.valueOf(str1.charAt(l - 1));
					int k;
					for (k = l + 1; k < lenstr1; k++) {
						if (str1.charAt(k) == ' ')// ��ͬ������ֵ֮���пո�ָ������ԴӵȺŵ���һλֱ���ո�ΪҪ��ֵ����ֵ
						{
							break;
						}
					}
					replace = str1.substring(l + 1, k);// ��ȡ֮����ַ��������滻
					Pattern p = Pattern.compile(regex);
					Matcher m2 = p.matcher(str);
					str = m2.replaceAll(replace);
				}

			}
			System.out.println(str);
		} else if (m1.find())// ��⵽������
		{
			if(str1.length()>6)
			{
				System.out.println("Your order is wrong! Too more vars!");
				System.exit(0);
			}
			var = str1.charAt(str1.length() - 1);// ��ȡҪ�󵼵ı���
			if (str.indexOf(String.valueOf(var)) >= 0)// �жϱ����Ƿ��ڶ���ʽ���֣��������������������ֱ�Ӳ���������ƥ������ֱ�ӱ����������
			{
				derivative(str, var);// �����󵼺���
			} else {
				System.out.println("Error, no variable");
			}
		} else {
			System.out.println("Your order is wrong!");
			System.exit(0);
		}

	}

	public static void derivative(String exp, char dx)
	
	// ����������expΪҪ����ı��ʽ��dxΪҪ�󵼵ı����� ����ֵ�� ��
	  {

		String[] exp_array = exp.split("\\+");// �Ե�ʽ��"+"���зָ�������exp_array�ַ���������
		int exp_length = exp_array.length;// ����������Ŀ��
		for (int i = 0; i < exp_length; i++) {

			int num = 0;// Ҫ�󵼵ı������ֵĴ���
			char[] char_count = exp_array[i].toCharArray();
			for (int j = 0; j < char_count.length; j++) // ����
			{
				if (char_count[j] == dx) {
					num++;
				}
			}

			if (num == 0) // �ڱ�������Ϊ0�ε�ʽ�������ֵΪ0
			{
				exp_array[i] = "0";// ������ֵ�滻��ԭֵ
			} else // �ڱ������ֲ�Ϊ0�ε�ʽ�������һ�����ֵı����滻Ϊ�������ִ�������Ϊ����ֵ
			{
				String[] temp_array = exp_array[i].split("");// �ָ�
				String temp_string = "";
				for (int k = 0; k < temp_array.length; k++) // �������滻��һ��
				{
					if (temp_array[k].equals(String.valueOf(dx))) {
						temp_array[k] = String.valueOf(num);
						break;
					}

				}
				for (int o = 0; o < temp_array.length; o++) {
					temp_string += temp_array[o];
				}
				exp_array[i] = temp_string;// ������ֵ�滻��ԭֵ
			}
		}

		for (int z = 0; z < exp_array.length - 1; z++)// ������
		{
			System.out.print(exp_array[z]);
			System.out.print("+");
		}
		System.out.print(exp_array[exp_array.length - 1]);
	}

}
