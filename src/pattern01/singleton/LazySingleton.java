package pattern01.singleton;

/*
ע�⣺�����д���Ƕ��̳߳�����Ҫɾ�������еĹؼ��� volatile �� synchronized��
���򽫴����̷߳ǰ�ȫ�����⡣�����ɾ���������ؼ��־��ܱ�֤�̰߳�ȫ��
����ÿ�η���ʱ��Ҫͬ������Ӱ�����ܣ������ĸ������Դ����������ʽ������ȱ��
*/

public class LazySingleton {
	public static void main(String[] args) {
		President1 zt1 = President1.getInstance();
		zt1.getName(); // �����ͳ������
		President1 zt2 = President1.getInstance();
		zt2.getName(); // �����ͳ������
		if (zt1 == zt2) {
			System.out.println("������ͬһ�ˣ�");
		} else {
			System.out.println("���ǲ���ͬһ�ˣ�");
		}
	}
}

class President1 {
	private static volatile President1 instance = null; // ��֤instance�������߳���ͬ��
	// private���������ⲿ��ʵ����

	private President1() {
		System.out.println("����һ����ͳ��");
	}

	public static synchronized President1 getInstance() {
		// ��getInstance�����ϼ�ͬ��
		if (instance == null) {
			instance = new President1();
		} else {
			System.out.println("�Ѿ���һ����ͳ�����ܲ�������ͳ��");
		}
		return instance;
	}

	public void getName() {
		System.out.println("����������ͳ�������ա�");
	}
}