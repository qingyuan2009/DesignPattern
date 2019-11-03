package pattern18.observation;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattenSample1 {

	public static void main(String[] args) {
		Rate rate = new RMBrate();
		Company watcher1 = new ImportCompany();
		Company watcher2 = new ExportCompany();
		rate.add(watcher1);
		rate.add(watcher2);
		rate.change(10);
		rate.change(-9);
	}

}

//����Ŀ�꣺����
abstract class Rate {
	protected List<Company> companys = new ArrayList<Company>();

	// ���ӹ۲��߷���
	public void add(Company company) {
		companys.add(company);
	}

	// ɾ���۲��߷���
	public void remove(Company company) {
		companys.remove(company);
	}

	public abstract void change(int number);
}

//����Ŀ�꣺����һ���
class RMBrate extends Rate {
	public void change(int number) {
		for (Company obs : companys) {
			((Company) obs).response(number);
		}
	}
}

//����۲��ߣ���˾
interface Company {
	void response(int number);
}

//����۲���1�����ڹ�˾ 
class ImportCompany implements Company {
	public void response(int number) {
		if (number > 0) {
			System.out.println("����һ�����ֵ" + number + "�����㣬�����˽��ڲ�Ʒ�ɱ��������˽��ڹ�˾�����ʡ�");
		} else if (number < 0) {
			System.out.println("����һ��ʱ�ֵ" + (-number) + "�����㣬�����˽��ڲ�Ʒ�ɱ��������˽��ڹ�˾�����ʡ�");
		}
	}
}

//����۲���2�����ڹ�˾
class ExportCompany implements Company {
	public void response(int number) {
		if (number > 0) {
			System.out.println("����һ�����ֵ" + number + "�����㣬�����˳��ڲ�Ʒ���룬�����˳��ڹ�˾�����������ʡ�");
		} else if (number < 0) {
			System.out.println("����һ��ʱ�ֵ" + (-number) + "�����㣬�����˳��ڲ�Ʒ���룬�����˳��ڹ�˾�����������ʡ�");
		}
	}
}