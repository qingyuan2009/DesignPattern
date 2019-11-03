package pattern03.factorymethod;

public class FactoryMethod {

	public static void main(String[] args) {
		try {
			Product a, b;
			AbstractFactory af = new ConcreteFactory1();
			AbstractFactory bf = new ConcreteFactory2();
			a = af.newProduct();
			a.show();
			b = bf.newProduct();
			b.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

//�����Ʒ���ṩ�˲�Ʒ�Ľӿ�
interface Product {
	public void show();
}

//�����Ʒ1��ʵ�ֳ����Ʒ�еĳ��󷽷�
class ConcreteProduct1 implements Product {
	public void show() {
		System.out.println("�����Ʒ1��ʾ...");
	}
}

//�����Ʒ2��ʵ�ֳ����Ʒ�еĳ��󷽷�
class ConcreteProduct2 implements Product {
	public void show() {
		System.out.println("�����Ʒ2��ʾ...");
	}
}

//���󹤳����ṩ�˳�Ʒ�����ɷ���
interface AbstractFactory {
	public Product newProduct();
}

//���幤��1��ʵ���˳�Ʒ�����ɷ���
class ConcreteFactory1 implements AbstractFactory {
	public Product newProduct() {
		System.out.println("���幤��1����-->�����Ʒ1...");
		return new ConcreteProduct1();
	}
}

//���幤��2��ʵ���˳�Ʒ�����ɷ���
class ConcreteFactory2 implements AbstractFactory {
	public Product newProduct() {
		System.out.println("���幤��2����-->�����Ʒ2...");
		return new ConcreteProduct2();
	}
}
