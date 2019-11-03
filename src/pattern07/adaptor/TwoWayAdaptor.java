package pattern07.adaptor;
/*
 * ������ģʽ��Adapter������չΪ˫��������ģʽ��˫����������ȿ��԰������߽ӿ�ת����Ŀ��ӿڣ�Ҳ���԰�Ŀ��ӿ�ת���������߽ӿ�
 */

//Ŀ��ӿ�
interface TwoWayTarget {
	public void request();
}

//�����߽ӿ�
interface TwoWayAdaptee {
	public void specificRequest();
}

//Ŀ��ʵ��
class TargetRealize implements TwoWayTarget {
	public void request() {
		System.out.println("Ŀ����뱻���ã�");
	}
}

//������ʵ��
class AdapteeRealize implements TwoWayAdaptee {
	public void specificRequest() {
		System.out.println("�����ߴ��뱻���ã�");
	}
}

//˫��������
class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee {
	private TwoWayTarget target;
	private TwoWayAdaptee adaptee;

	public TwoWayAdapter(TwoWayTarget target) {
		this.target = target;
	}

	public TwoWayAdapter(TwoWayAdaptee adaptee) {
		this.adaptee = adaptee;
	}

	public void request() {
		adaptee.specificRequest();
	}

	public void specificRequest() {
		target.request();
	}
}

//�ͻ��˴���
public class TwoWayAdaptor {
	public static void main(String[] args) {
		System.out.println("Ŀ��ͨ��˫�����������������ߣ�");
		TwoWayAdaptee adaptee = new AdapteeRealize();
		TwoWayTarget target = new TwoWayAdapter(adaptee);
		target.request();
		System.out.println("-------------------");
		System.out.println("������ͨ��˫������������Ŀ�꣺");
		target = new TargetRealize();
		adaptee = new TwoWayAdapter(target);
		adaptee.specificRequest();
	}
}