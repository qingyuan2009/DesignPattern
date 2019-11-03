package pattern02.prototype;

public class ProtoTypeSample1 {

	public static void main(String[] args) {
		SunWukong obj1 = new SunWukong();
		SunWukong obj2 = (SunWukong) obj1.clone();
		System.out.println("�Ƿ���ͬһ�����?" + (obj1 == obj2));
	}

}

class SunWukong implements Cloneable {

	public SunWukong() {
		System.out.println("��ճ���!");
	}

	public Object clone() {
		SunWukong w = null;
		try {
			w = (SunWukong) super.clone();
			System.out.println("������ճɹ�!");
		} catch (CloneNotSupportedException e) {
			System.out.println("�������ʧ��!");
		}
		return w;
	}
}