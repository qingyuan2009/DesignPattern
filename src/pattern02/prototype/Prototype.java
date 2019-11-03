package pattern02.prototype;

public class Prototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		Realizetype obj1 = new Realizetype();
		Realizetype obj2 = (Realizetype) obj1.clone();
		System.out.println("obj1==obj2?" + (obj1 == obj2));
	}

}

//����ԭ����
class Realizetype implements Cloneable {
	Realizetype() {
		System.out.println("����ԭ�ʹ����ɹ���");
	}

	public Object clone() throws CloneNotSupportedException {
		System.out.println("����ԭ�͸��Ƴɹ���");
		return (Realizetype) super.clone();
	}
}