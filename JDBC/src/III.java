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
		
//			10����s=a+aa+aaa+aaaa+aa...a��ֵ������a��һ�����֡�
//			����2+22+222+2222+22222
//			(��ʱ ����5�������)������������м��̿��ơ�
			Scanner reader=new Scanner(System.in);
			int a=0,n=0,b=0;
			System.out.println("����a��");
			a=reader.nextInt();
			b=a;//����β��
			System.out.println("�������n:");
			n=reader.nextInt();
			int sum=0;//�ۼ���
			for(int i=0;i<n;i++)//�õ������Ǹ���
			{	
//				System.out.println("a="+a);
				sum+=a;//�ۼ����
				a=a*10;//ǰ��һλ
				a+=b;//��β��
				//
			}	
			System.out.println("sum="+sum);

	}
}
