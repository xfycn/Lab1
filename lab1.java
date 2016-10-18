package lab1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//git test line
public class lab1 {
	public static Scanner s = new Scanner(System.in);// 全局变量
	public static String str = null;
	public static char var;

	public static void main(String[] args) {
		lab1 a = new lab1();
		a.expression();
		a.simplify();
	}

	public static void expression()// 从屏幕读入到str
	{
		System.out.println("Please input polynomial：");
		str = s.next();
	}

	public static void simplify()// 简化
	{
		System.out.println("Please input your order：");
		Scanner s1 = new Scanner(System.in);// 从屏幕读入命令到s1中
		String str1 = null;
		String regex = null;
		String replace = null;
		int lenstr1;
		str1 = s1.nextLine();
		String pattern = "!simplify( [a-z]=[0-9]+)*";// 两种匹配模式，用来检测输入命令是否正确
		String pattern1 = "!d/d [a-z]";
		Pattern r = Pattern.compile(pattern);
		Pattern r1 = Pattern.compile(pattern1);
		Matcher m = r.matcher(str1);
		Matcher m1 = r1.matcher(str1);
		if (str1.equals("!simplify")) {
			System.out.println(str);
			System.exit(0);
		} else if (m.find())// 检测到简化命令
		{
			lenstr1 = str1.length();
			for (int l = 0; l < lenstr1; l++) {
				if (str1.charAt(l) == '=')// 找到的等号字符，前面一位即为要赋值的字母，后面若干位即为数值
				{
					regex = String.valueOf(str1.charAt(l - 1));
					int k;
					for (k = l + 1; k < lenstr1; k++) {
						if (str1.charAt(k) == ' ')// 不同变量赋值之间有空格分隔，所以从等号的下一位直到空格即为要赋值的数值
						{
							break;
						}
					}
					replace = str1.substring(l + 1, k);// 截取之间的字符串进行替换
					Pattern p = Pattern.compile(regex);
					Matcher m2 = p.matcher(str);
					str = m2.replaceAll(replace);
				}

			}
			System.out.println(str);
		} else if (m1.find())// 检测到求导命令
		{
			if(str1.length()>6)
			{
				System.out.println("Your order is wrong! Too more vars!");
				System.exit(0);
			}
			var = str1.charAt(str1.length() - 1);// 获取要求导的变量
			if (str.indexOf(String.valueOf(var)) >= 0)// 判断变量是否在多项式出现，多个变量输入的那种情况直接不满足正则匹配条件直接报错掉在上面
			{
				derivative(str, var);// 调用求导函数
			} else {
				System.out.println("Error, no variable");
			}
		} else {
			System.out.println("Your order is wrong!");
			System.exit(0);
		}

	}

	public static void derivative(String exp, char dx)
	
	// 函数参数：exp为要处理的表达式，dx为要求导的变量； 返回值： 无
	  {

		String[] exp_array = exp.split("\\+");// 对等式已"+"进行分割，各项储存在exp_array字符串数组中
		int exp_length = exp_array.length;// 计算数组项目数
		for (int i = 0; i < exp_length; i++) {

			int num = 0;// 要求导的变量出现的次数
			char[] char_count = exp_array[i].toCharArray();
			for (int j = 0; j < char_count.length; j++) // 计数
			{
				if (char_count[j] == dx) {
					num++;
				}
			}

			if (num == 0) // 在变量出现为0次的式子里，导数值为0
			{
				exp_array[i] = "0";// 将导数值替换掉原值
			} else // 在变量出现不为0次的式子里，将第一个出现的变量替换为变量出现次数，即为导数值
			{
				String[] temp_array = exp_array[i].split("");// 分割
				String temp_string = "";
				for (int k = 0; k < temp_array.length; k++) // 遍历，替换第一个
				{
					if (temp_array[k].equals(String.valueOf(dx))) {
						temp_array[k] = String.valueOf(num);
						break;
					}

				}
				for (int o = 0; o < temp_array.length; o++) {
					temp_string += temp_array[o];
				}
				exp_array[i] = temp_string;// 将导数值替换掉原值
			}
		}

		for (int z = 0; z < exp_array.length - 1; z++)// 输出结果
		{
			System.out.print(exp_array[z]);
			System.out.print("+");
		}
		System.out.print(exp_array[exp_array.length - 1]);
	}

}
