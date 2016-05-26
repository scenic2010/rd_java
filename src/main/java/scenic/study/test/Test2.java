package scenic.study.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class Test2 {

	public static void main(String args[]) {

		// System.out.println(doFeiBoNaQi(5));

		// // ����2�� ��Ŀ���ж�101-200֮���ж��ٸ����������������������
		// // 1.����������ж������ķ�������һ�����ֱ�ȥ��2��sqrt(�����)������ܱ�������
		// for (int i = 101; i <= 200; i++) {
		// if (MathUtil.isSuShuo(i)) {
		// System.out.println(i);
		// }
		// }

		// fenJie(90,new ArrayList<Integer>());

		// System.out.println(getYueShu(18, new ArrayList<Integer>()));

		// Math1(24,32);
//		math8();
//		math9();
//		System.out.println( getYueShu(28, new ArrayList<>()));
//		math10();
		
//		math11();
//		math12();
//		new Test2().new Math13();
//		new Math14().f();
		
//		new Math15().f(1234567);
		
//		new Math16().f();
		
		
		System.out.println(Collections.emptyMap());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	Executor executor = new Executor() {
		
		@Override
		public void execute(Runnable command) {
			// TODO Auto-generated method stub
			
		}
	};
	

	static class Math16{
		//�������
		public void f(){
			int l = 19;
			int a[][] = new int[l][l];
			
			for(int i = 0;i < a.length; i++){
				//�������϶���ֵ 1
				a[i][i] = 1;
				a[i][0] = 1;
			}
			
			for(int j = 0; j < a.length; j++){
				for (int i = 1; i < j; i++){
					a[j][i] = a[j-1][i-1] + a[j-1][i];
				}
			}
			
			
			
			for (int[] is : a) {
				for (int i : is) {
					if(i == 0){
						System.out.print("\t");
					}else {
						System.out.print(i + "\t");
					}
					
				}
				System.out.println();
			}
		}
	}
	
	static class Math15{
		//ȡһ������a���Ҷ˿�ʼ��4��7λ��
		public void f(int a){
			System.out.println((a % 100000) / 100 );
		}
	}
	
	
	static class Math14{
	
		
		public void f(){
			//����ƹ����ӽ��б������������ˡ�
			//�׶�Ϊa,b,c���ˣ��Ҷ�Ϊx,y,z���ˡ�
			//�ѳ�ǩ���������������������Ա����������������a˵������x�ȣ�c˵������x,z�ȣ��������ҳ��������ֵ�������
			
			int a = 1; 
			int b = 2;
			int c = 3;
			
			int x = 4; 
			int y = 5;
			int z = 6;
			
			for(int i = 1; i <= 3; i++){
				for (int j = 4; j <= 6; j++){
					if(i == 1 && j == 4
							||
							i ==3 && j == 4
							||
							i ==3 && j == 6
							){
						continue;
					}
					System.out.println(i  + "  " + j);
				}
			}
		}
		
	}
	
	

	
	private class Math13 {
		/*
		  ���ӵ�һ��ժ�����ɸ����ӣ���������һ�룬
		  ����񫣬�ֶ����һ�� 
		    �ڶ��������ֽ�ʣ�µ����ӳԵ�һ�룬
		    �ֶ����һ����
		    �Ժ�ÿ�����϶�����ǰһ��ʣ��   ��һ����һ����
		    ����10���������ٳ�ʱ����ֻʣ��һ�������ˡ�
		    ���һ�칲ժ�˶��١� 
		 */

		//���Ͽ���֪�����±��ʽ����
		//f(n) / 2 -1 = f(n+1)
		
		public Math13() {
			System.out.println(f(1)); 
		}
		
		
		private int f(int n){
			if(n >= 10){
				return 1;
			}else {
				return (f(n + 1) + 1) * 2;
			}
		}
		
	}


	
	
	
	private static void math12() {

		/*
		��Ŀ������ĳ��ĳ��ĳ�գ��ж���һ������һ��ĵڼ��죿 
		 */
		
		//1988-06-03
		
	}

	
	
	
	
	
	
	
	
	
	
	
	/*
	 
	 �١����������ܱ�4������Ϊ���ꡣ����2004���������,2010�겻�����꣩
	�ڡ��������ܱ�400�����������ꡣ(��2000�������꣬1900�겻������)
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void math11() {

//		��Ŀ����1��2��3��4�����֣�����ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣� 
//		1.��������������ڰ�λ��ʮλ����λ�����ֶ���1��2��3��4��������е����к���ȥ   �����������������С� 
		
		
		
		
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int t = 0;
		for(a = 1; a <=4; a++){
			for(b = 1; b <=4 ; b++){
				for(c =1; c <=4; c++){
					for(d =1; d <=4; d++){
						
						if(a != b && a != c && a != d && b != c && b != d && c !=d){
							System.out.println(a*1000 + b*100 + c * 10 + d);
							t++;
						}
						
					}
				}
			}
		}
		
		System.out.println(t);
		
		
		
		
		
		
		
		
		
		
		
	}

	private static void math10() {
		// TODO Auto-generated method stub
		//һ���100�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�룻�����£�������   ��10�����ʱ�������������ף���10�η�����ߣ�
	
		float m = 100;
		float h = m;
		for(int i = 0; i < 10; i++){
			m=m/2;
			h+=m;
			System.out.println(h +" + " + m);
		}
		
		
		System.out.println(h);
		
		
	}
	
	
	
	
	
	
	public static int doFeiBoNaQi(int n) {
		// �ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ������ĸ��º�ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ���������Ϊ���٣�
		// 1.��������� ���ӵĹ���Ϊ����1,1,2,3,5,8,13,21��.

		if (n >= 2) {
			return doFeiBoNaQi(n - 1) + doFeiBoNaQi(n - 2);
		} else {
			return 1;
		}
	}

	/**
	 * �ֽ�������
	 * 
	 * @param value
	 */
	public static void fenJie(int value, List<Integer> list) {
		// ������4�� ��Ŀ����һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��

		if (isSuShuo(value)) {
			System.out.println(value);
			list.add(value);
		} else {
			for (int i = 2; i < value / 2; i++) {
				if (value % i == 0) {
					System.out.println(i);
					list.add(i);
					fenJie(value / i, list);
					break;
				}
			}
		}
	}

	public static void d() {
		// ������5�� ��Ŀ�����������������Ƕ������ɴ��⣺ѧϰ�ɼ�> =90�ֵ�ͬѧ��A��ʾ��60-89��֮�����B��ʾ��60�����µ���C��ʾ��
		// 1.���������(a> b)?a:b��������������Ļ������ӡ�
		int n = 90;
		String value = (n >= 90) ? "A" : (n >= 60 ? "B" : "C");
	}

	public static void Math1(int m, int n) {
		// ������6�� ��Ŀ����������������m��n���������Լ������С��������

		System.out.println(commonDivisor(m, n));

		System.out.println(m * n / commonDivisor(m, n));

	}

	public static void math7(String str) {
		// ������7�� ��Ŀ������һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����

	}

	public static void math8() {
		// ��Ŀ����s=a+aa+aaa+aaaa+aa��a��ֵ������a��һ�����֡�����2+22+222+2222+22222(��ʱ����5�������)������������м��̿��ơ�

		// f(n) = f(n-1) * 10 +a

		int a = 2;
		int n = 5;

		System.out.println(getAAA(a, n));

		int h = 0;
		int tmp = a;
		for (int i = 0; i < n; i++) {
			tmp = tmp * 10 + a;
			System.out.println(tmp);
			h += tmp;
		}
		System.out.println(h);
	}

	private static int getAAA(int a, int n) {
		if (n == 1) {
			return a;
		} else {
			return getAAA(a, n - 1) * 10 + a;
		}
	}

	public static void math9() {
//		 һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ ������ ��������6=1��2��3.���   �ҳ�1000���ڵ�����������
		int s;
		for (int i = 1; i <= 1000; i++) {
			s = 0;
			for (int j = 1; j < i; j++)
				if (i % j == 0)
					s = s + j;
			if (s == i)
				System.out.print(i + " ");
		}
		System.out.println();
	}

	static int commonDivisor(int M, int N) {
		if (N < 0 || M < 0) {
			System.out.println("ERROR!");
			return -1;
		}
		if (N == 0) {
			System.out.println("the biggest common divisor is :" + M);
			return M;
		}
		return commonDivisor(N, M % N);
	}

	private static List<Integer> getYueShu(int value, List<Integer> list) {
		list.add(1);
		for (int i = 2; i <= value / 2; i++) {
			if (value % i == 0) {
				list.add(i);
			}
		}

		list.add(value);

		return list;
	}

	/**
	 * �ж�һ�����Ƿ�Ϊ����
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isSuShuo(int value) {
		boolean result = true;

		for (int i = 2; i < value / 2; i++) {
			if (value % i == 0) {
				result = false;
				break;
			}
		}

		return result;
	}
}

class MathUtil {
	public int f(int x) {
		if (x == 1 || x == 2)
			return 1;
		else
			return f(x - 1) + f(x - 2);
	}

}
