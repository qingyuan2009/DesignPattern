package pattern07.adaptor;

//目标接口
interface Target2 {
	public void request();
}

//适配者接口
class Adaptee2 {
	public void specificRequest() {
		System.out.println("适配者中的业务代码被调用！");
	}
}

//对象适配器类
class ObjectAdapter implements Target2
{
  private Adaptee2 adaptee;
  public ObjectAdapter(Adaptee2 adaptee)
  {
      this.adaptee=adaptee;
  }
  public void request()
  {
      adaptee.specificRequest();
  }
}
//客户端代码
public class ObjectAdapterTest
{
  public static void main(String[] args)
  {
      System.out.println("对象适配器模式测试：");
      Adaptee2 adaptee = new Adaptee2();
      Target2 target = new ObjectAdapter(adaptee);
      target.request();
  }
}