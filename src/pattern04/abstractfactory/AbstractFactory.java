package pattern04.abstractfactory;

public class AbstractFactory {

	public static void main(String[] args) {
		try {
			Farm f1, f2;
			Animal a1, a2;
			Plant p1, p2;

			f1 = new SRfarm();
			a1 = f1.newAnimal();
			p1 = f1.newPlant();
			a1.show();
			p1.show();

			f2 = new SGfarm();
			a2 = f2.newAnimal();
			p2 = f2.newPlant();
			a2.show();
			p2.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

//�����Ʒ��������
interface Animal {
	public void show();
}

//�����Ʒ������
class Horse implements Animal {

	public Horse() {
	}

	public void show() {
		System.out.println("��ʾ����");
	}
}

//�����Ʒ��ţ��
class Cattle implements Animal {
	public Cattle() {
	}

	public void show() {
		System.out.println("��ʾ��ţ");
	}
}

//�����Ʒ��ֲ����
interface Plant {
	public void show();
}

//�����Ʒ��ˮ����
class Fruitage implements Plant {
	public Fruitage() {
	}

	public void show() {
		System.out.println("��ʾ��ˮ��");
	}
}

//�����Ʒ���߲���
class Vegetables implements Plant {
	public Vegetables() {
	}

	public void show() {
		System.out.println("��ʾ���߲�");
	}
}

//���󹤳���ũ����
interface Farm {
	public Animal newAnimal();

	public Plant newPlant();
}

//���幤�����ع�ũ����
class SGfarm implements Farm {

	public SGfarm() {
		System.out.println("�ع�ũ��");
	}

	public Animal newAnimal() {
		System.out.println("��ţ������");
		return new Cattle();
	}

	public Plant newPlant() {
		System.out.println("�߲˳��ɣ�");
		return new Vegetables();
	}
}

//���幤��������ũ����
class SRfarm implements Farm {

	public SRfarm() {
		System.out.println("����ũ��");
	}

	public Animal newAnimal() {
		System.out.println("���������");
		return new Horse();
	}

	public Plant newPlant() {
		System.out.println("ˮ�����ɣ�");
		return new Fruitage();
	}
}