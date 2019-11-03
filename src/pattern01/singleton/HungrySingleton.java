package pattern01.singleton;

/*
饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，
以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
*/

public class HungrySingleton {
	public static void main(String[] args) {
		President2 zt1 = President2.getInstance();
		zt1.getName(); // 输出总统的名字
		President2 zt2 = President2.getInstance();
		zt2.getName(); // 输出总统的名字
		if (zt1 == zt2) {
			System.out.println("他们是同一人！");
		} else {
			System.out.println("他们不是同一人！");
		}
	}
}

class President2 {

	private static final President2 instance = new President2();

	private President2() {
		System.out.println("产生一个总统！");
	}

	public static President2 getInstance() {

		if (instance != null) {			
			System.out.println("已经有一个总统，不能产生新总统！");
		}
		return instance;
	}

	public void getName() {
		System.out.println("我是美国总统：特朗普。");
	}
}
