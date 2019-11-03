import java.util.Scanner;

public class III {
	public static void main(String[] args) {
		
//		Scanner scanner = new Scanner(System.in); 
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		scanner.close();
//		int res = 0;
//		int temp = a*b;
//		for(int i=1;i<b;i++) {
//			int num = (int) (temp%10*Math.pow(10, i-1));
//			temp = temp/10+a*(b-i);
//			res = res+num;
//		}		
//		int num = (int) (temp*Math.pow(10, b-1));
//		res = res+num;
//		System.out.println(res);
		
//			10、求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
//			例如2+22+222+2222+22222
//			(此时 共有5个数相加)，几个数相加有键盘控制。
			Scanner reader=new Scanner(System.in);
			int a=0,n=0,b=0;
			System.out.println("输入a：");
			a=reader.nextInt();
			b=a;//缓存尾数
			System.out.println("输入次数n:");
			n=reader.nextInt();
			int sum=0;//累加器
			for(int i=0;i<n;i++)//得到最大的那个数
			{	
//				System.out.println("a="+a);
				sum+=a;//累加求和
				a=a*10;//前移一位
				a+=b;//加尾数
				//
			}	
			System.out.println("sum="+sum);

	}
}
