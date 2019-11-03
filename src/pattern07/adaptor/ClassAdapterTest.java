package pattern07.adaptor;

//Ŀ��ӿ�
interface Target1 {
	public void request();
}

//�����߽ӿ�
class Adaptee1 {
	public void specificRequest() {
		System.out.println("�������е�ҵ����뱻���ã�");
	}
}

//����������
class ClassAdapter extends Adaptee1 implements Target1 {
	public void request() {
		specificRequest();
	}
}

//�ͻ��˴���
public class ClassAdapterTest {
	public static void main(String[] args) {
		System.out.println("��������ģʽ���ԣ�");
		Target1 target = new ClassAdapter();
		target.request();
	}
}