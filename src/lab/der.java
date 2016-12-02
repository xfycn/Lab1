package lab;
public class der {
	public static String derivative(String exp, char var, String str1){
		String result="";
		if (str1.length() > 6) {
            System.out.println("Your order is wrong! Too more vars!");
            System.exit(0);
          }
	      
	      if (exp.indexOf(String.valueOf(var)) >= 0) {
	        // 判断变量是否在多项式出现，多个变量输入的那种情况直接不满足正则匹配条件直接报错掉在上面
	    	 //con1 c=new con1();
	    	 //c.derivative(str, var);// 调用求导函数
	    	  String[] exparray0 = exp.split("\\+");// 对等式已"+"进行分割，各项储存在exp_array字符串数组中
	  	    int explength0 = exparray0.length;// 计算数组项目数
	  	    for (int i = 0; i < explength0; i++) {

	  	      int num = 0;// 要求导的变量出现的次数
	  	      char[] charcount0 = exparray0[i].toCharArray();
	  	      //计数
	  	      for (int j = 0; j < charcount0.length; j++) {
	  	        if (charcount0[j] == var) {
	  	          num++;
	  	        }
	  	      }
	  	      // 在变量出现为0次的式子里，导数值为0
	  	      if (num == 0) {
	  	        exparray0[i] = "0";// 将导数值替换掉原值
	  	      } else {
	  	        String[] temparray0 = exparray0[i].split("");// 分割
	  	        String tempstring = "";
	  	        // 遍历，替换第一个
	  	        for (int k = 0; k < temparray0.length; k++) {
	  	          if (temparray0[k].equals(String.valueOf(var))) {
	  	            temparray0[k] = String.valueOf(num);
	  	            break;
	  	          }

	  	        }
	  	        for (int o = 0; o < temparray0.length; o++) {
	  	          tempstring += temparray0[o];
	  	        }
	  	        exparray0[i] = tempstring;// 将导数值替换掉原值
	  	      }
	  	    }
	  	    // 输出结果
	  	    for (int z = 0; z < exparray0.length - 1; z++) {
	  	      result+=exparray0[z];
	  	      result=result+"+";
	  	    }
	  	    result+=(exparray0[exparray0.length - 1]);
	  	    //System.out.println(result);
	  	    //return result;
	      } else {
	        ex.errorII();
	      }
		return result;
	    
	}
}
