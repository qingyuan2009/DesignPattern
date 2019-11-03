package pattern07.adaptor;

//目标接口
interface Target1 {
	public void request();
}

//适配者接口
class Adaptee1 {
	public void specificRequest() {
		System.out.println("适配者中的业务代码被调用！");
	}
}

//类适配器类
class ClassAdapter extends Adaptee1 implements Target1 {
	public void request() {
		specificRequest();
	}
}

//客户端代码
public class ClassAdapterTest {
	public static void main(String[] args) {
		System.out.println("类适配器模式测试：");
		Target1 target = new ClassAdapter();
		target.request();
	}
}