package lab;
public class der {
	public static String derivative(String exp, char var, String str1){
		String result="";
		if (str1.length() > 6) {
            System.out.println("Your order is wrong! Too more vars!");
            System.exit(0);
          }
	      
	      if (exp.indexOf(String.valueOf(var)) >= 0) {
	        // �жϱ����Ƿ��ڶ���ʽ���֣��������������������ֱ�Ӳ���������ƥ������ֱ�ӱ����������
	    	 //con1 c=new con1();
	    	 //c.derivative(str, var);// �����󵼺���
	    	  String[] exparray0 = exp.split("\\+");// �Ե�ʽ��"+"���зָ�������exp_array�ַ���������
	  	    int explength0 = exparray0.length;// ����������Ŀ��
	  	    for (int i = 0; i < explength0; i++) {

	  	      int num = 0;// Ҫ�󵼵ı������ֵĴ���
	  	      char[] charcount0 = exparray0[i].toCharArray();
	  	      //����
	  	      for (int j = 0; j < charcount0.length; j++) {
	  	        if (charcount0[j] == var) {
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
	  	          if (temparray0[k].equals(String.valueOf(var))) {
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
