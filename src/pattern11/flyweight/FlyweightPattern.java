package pattern11.flyweight;

import java.util.HashMap;

public class FlyweightPattern {
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight f01 = factory.getFlyweight("a");
		Flyweight f02 = factory.getFlyweight("a");
		Flyweight f03 = factory.getFlyweight("a");
		Flyweight f11 = factory.getFlyweight("b");
		Flyweight f12 = factory.getFlyweight("b");
		f01.operation(new UnsharedConcreteFlyweight("��1�ε���a��"));
		f02.operation(new UnsharedConcreteFlyweight("��2�ε���a��"));
		f03.operation(new UnsharedConcreteFlyweight("��3�ε���a��"));
		f11.operation(new UnsharedConcreteFlyweight("��1�ε���b��"));
		f12.operation(new UnsharedConcreteFlyweight("��2�ε���b��"));
	}
}

//����Ԫ��ɫ
class UnsharedConcreteFlyweight {
	private String info;

	UnsharedConcreteFlyweight(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}

//������Ԫ��ɫ
interface Flyweight {
	public void operation(UnsharedConcreteFlyweight state);
}

//������Ԫ��ɫ
class ConcreteFlyweight implements Flyweight {
	private String key;

	ConcreteFlyweight(String key) {
		this.key = key;
		System.out.println("������Ԫ" + key + "��������");
	}

	public void operation(UnsharedConcreteFlyweight outState) {
		System.out.print("������Ԫ" + key + "�����ã�");
		System.out.println("����Ԫ��Ϣ��:" + outState.getInfo());
	}
}

//��Ԫ������ɫ
class FlyweightFactory {
	private HashMap<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

	public Flyweight getFlyweight(String key) {
		Flyweight flyweight = (Flyweight) flyweights.get(key);
		if (flyweight != null) {
			System.out.println("������Ԫ" + key + "�Ѿ����ڣ����ɹ���ȡ��");
		} else {
			flyweight = new ConcreteFlyweight(key);
			flyweights.put(key, flyweight);
		}
		return flyweight;
	}
}