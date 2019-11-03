package pattern01.singleton;

/*
����ʽ�������ഴ����ͬʱ���Ѿ�������һ����̬�Ķ���ϵͳʹ�ã�
�Ժ��ٸı䣬�������̰߳�ȫ�ģ�����ֱ�����ڶ��̶߳�����������⡣
*/

public class HungrySingleton {
	public static void main(String[] args) {
		President2 zt1 = President2.getInstance();
		zt1.getName(); // �����ͳ������
		President2 zt2 = President2.getInstance();
		zt2.getName(); // �����ͳ������
		if (zt1 == zt2) {
			System.out.println("������ͬһ�ˣ�");
		} else {
			System.out.println("���ǲ���ͬһ�ˣ�");
		}
	}
}

class President2 {

	private static final President2 instance = new President2();

	private President2() {
		System.out.println("����һ����ͳ��");
	}

	public static President2 getInstance() {

		if (instance != null) {			
			System.out.println("�Ѿ���һ����ͳ�����ܲ�������ͳ��");
		}
		return instance;
	}

	public void getName() {
		System.out.println("����������ͳ�������ա�");
	}
}
