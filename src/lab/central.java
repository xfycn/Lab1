package lab;

import java.util.Scanner;

public class central {
	static Scanner s = new Scanner(System.in);
	static String str = null;
	static String str1 = null;
	static String regex;
	static String replace;
	public static char var;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex.Info1();
		str = s.next();
		ex.Info2();
		Scanner s1 = new Scanner(System.in);// 从屏幕读入命令到s1中
		str1 = s1.nextLine();
	    s1.close();
	    var = str1.charAt(str1.length() - 1);// 获取要求导的变量
	    if (str1.equals("!simplify")) {
		      System.out.println(str);
		      System.exit(0);
		    }
	    else if(control.match(str, str1)==1){
	    	control.getRegex(str1, regex);
	    	control.getReplace(str1, replace);
	    	sim.simplify(str, str1, regex, replace);
	    }
	    else if(control.match(str, str1)==2){
	    	System.out.println(der.derivative(str, var, str1));
	    	
	    }
	    else{
	    	ex.errorIII();
	    }

	}

}
