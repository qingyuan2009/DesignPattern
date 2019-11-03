package pattern07.adaptor;

//Ŀ��ӿ�
interface Target2 {
	public void request();
}

//�����߽ӿ�
class Adaptee2 {
	public void specificRequest() {
		System.out.println("�������е�ҵ����뱻���ã�");
	}
}

//������������
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
//�ͻ��˴���
public class ObjectAdapterTest
{
  public static void main(String[] args)
  {
      System.out.println("����������ģʽ���ԣ�");
      Adaptee2 adaptee = new Adaptee2();
      Target2 target = new ObjectAdapter(adaptee);
      target.request();
  }
}