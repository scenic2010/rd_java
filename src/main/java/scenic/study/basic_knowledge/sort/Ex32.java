package scenic.study.basic_knowledge.sort;

public class Ex32 {
	public static void main(String[] args) {
		int a = 0;
		long b = 875678;
		a = (int) Math.floor(b % Math.pow(10, 7) / Math.pow(10, 3));
		System.out.println(a);
	}
}