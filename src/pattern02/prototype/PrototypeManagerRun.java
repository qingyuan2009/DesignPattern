package pattern02.prototype;

import java.util.HashMap;
import java.util.Scanner;

public class PrototypeManagerRun {

	public static void main(String[] args) {
		ProtoTypeManager pm = new ProtoTypeManager();
		Shape obj1 = (Circle) pm.getShape("Circle");
		obj1.countArea();
		Shape obj2 = (Shape) pm.getShape("Square");
		obj2.countArea();
	}
}

interface Shape extends Cloneable {
	public Object clone(); // ����
	public void countArea(); // �������
}

class Circle implements Shape {
	public Object clone() {
		Circle w = null;
		try {
			w = (Circle) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("����Բʧ��!");
		}
		return w;
	}

	public void countArea() {
		int r = 0;
		System.out.print("����һ��Բ��������Բ�İ뾶��");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		r = input.nextInt();
		System.out.println("��Բ�����=" + 3.1415 * r * r + "\n");
	}
}

class Square implements Shape {
	public Object clone() {
		Square b = null;
		try {
			b = (Square) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("����������ʧ��!");
		}
		return b;
	}

	public void countArea() {
		int a = 0;
		System.out.print("����һ�������Σ����������ı߳���");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		a = input.nextInt();
		System.out.println("�������ε����=" + a * a + "\n");
	}
}

class ProtoTypeManager {
	private HashMap<String, Shape> ht = new HashMap<String, Shape>();

	public ProtoTypeManager() {
		ht.put("Circle", new Circle());
		ht.put("Square", new Square());
	}

	public void addShape(String key, Shape obj) {
		ht.put(key, obj);
	}

	public Shape getShape(String key) {
		Shape temp = ht.get(key);
		return (Shape) temp.clone();
	}
}
