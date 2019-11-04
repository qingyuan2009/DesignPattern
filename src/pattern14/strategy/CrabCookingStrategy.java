package pattern14.strategy;

public class CrabCookingStrategy {

	private Kitchen cf; // ����
	private CrabCooking qzx, hsx; // ��բз�ӹ���

	CrabCookingStrategy() {
		// ---------------------------------
		cf = new Kitchen(); // ����
		qzx = new SteamedCrabs(); // ������բз��
		hsx = new BraisedCrabs(); // ���մ�բз��
		cf.setStrategy(qzx);
		cf.CookingMethod(); // ����
		cf.setStrategy(hsx);
		cf.CookingMethod(); // ����
	}

	public static void main(String[] args) {
		new CrabCookingStrategy();
	}
}

//��������ࣺ��բз�ӹ���
interface CrabCooking {
	public void CookingMethod(); // ���˷���
}

//��������ࣺ������բз
class SteamedCrabs implements CrabCooking {	

	public void CookingMethod() {
		System.out.println("������բз");
	}
}

//��������ࣺ���մ�բз
class BraisedCrabs implements CrabCooking {	

	public void CookingMethod() {
		System.out.println("���մ�բз");
	}
}

//�����ࣺ����
class Kitchen {
	private CrabCooking strategy; // �������

	public void setStrategy(CrabCooking strategy) {
		this.strategy = strategy;
	}

	public CrabCooking getStrategy() {
		return strategy;
	}

	public void CookingMethod() {
		strategy.CookingMethod(); // ����
	}
}