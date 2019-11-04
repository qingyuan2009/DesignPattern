package pattern21.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitorPatternSample {

	public static void main(String[] args) {
		SetMaterial sm = new SetMaterial();
		// ������Ԫ��
		sm.add(new Paper());
		sm.add(new Cuprum());
		// ������������, ÿ�������߶���ÿ��Ԫ���ɲ�ͬ�Ĳ���
		Company artcompany = new ArtCompany();
		sm.accept(artcompany);
		System.out.println("------------------------");
		Company mintcompany = new Mint();
		sm.accept(mintcompany);
	}

}

//���������:��˾
interface Company {
	String create(Paper element);

	String create(Cuprum element);
}

//��������ߣ�������˾
class ArtCompany implements Company {
	public String create(Paper element) {
		System.out.println("ArtCompany ������ѧͼ");
		return "��ѧͼ";
	}

	public String create(Cuprum element) {
		System.out.println("ArtCompany ��������ͭ��");
		return "����ͭ��";
	}
}

//��������ߣ���ҹ�˾
class Mint implements Company {
	public String create(Paper element) {
		System.out.println("MintCompany ����ֽ��");
		return "ֽ��";
	}

	public String create(Cuprum element) {
		System.out.println("MintCompany ����ͭ��");
		return "ͭ��";
	}
}

//����Ԫ�أ�����
interface Material {
	String accept(Company visitor);
}

//����Ԫ�أ�ֽ
class Paper implements Material {
	public String accept(Company visitor) {
		return (visitor.create(this));
	}
}

//����Ԫ�أ�ͭ
class Cuprum implements Material {
	public String accept(Company visitor) {
		return (visitor.create(this));
	}
}

//����ṹ��ɫ:���ϼ�
class SetMaterial {
	private List<Material> list = new ArrayList<Material>();

	public String accept(Company visitor) {
		Iterator<Material> i = list.iterator();
		String tmp = "";
		while (i.hasNext()) {
			tmp += ((Material) i.next()).accept(visitor) + " ";
		}
		return tmp; // ����ĳ��˾����Ʒ��
	}

	public void add(Material element) {
		list.add(element);
	}

	public void remove(Material element) {
		list.remove(element);
	}
}