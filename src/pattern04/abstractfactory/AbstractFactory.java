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

//抽象产品：动物类
interface Animal {
	public void show();
}

//具体产品：马类
class Horse implements Animal {

	public Horse() {
	}

	public void show() {
		System.out.println("显示：马");
	}
}

//具体产品：牛类
class Cattle implements Animal {
	public Cattle() {
	}

	public void show() {
		System.out.println("显示：牛");
	}
}

//抽象产品：植物类
interface Plant {
	public void show();
}

//具体产品：水果类
class Fruitage implements Plant {
	public Fruitage() {
	}

	public void show() {
		System.out.println("显示：水果");
	}
}

//具体产品：蔬菜类
class Vegetables implements Plant {
	public Vegetables() {
	}

	public void show() {
		System.out.println("显示：蔬菜");
	}
}

//抽象工厂：农场类
interface Farm {
	public Animal newAnimal();

	public Plant newPlant();
}

//具体工厂：韶关农场类
class SGfarm implements Farm {

	public SGfarm() {
		System.out.println("韶关农场");
	}

	public Animal newAnimal() {
		System.out.println("新牛出生！");
		return new Cattle();
	}

	public Plant newPlant() {
		System.out.println("蔬菜长成！");
		return new Vegetables();
	}
}

//具体工厂：上饶农场类
class SRfarm implements Farm {

	public SRfarm() {
		System.out.println("上饶农场");
	}

	public Animal newAnimal() {
		System.out.println("新马出生！");
		return new Horse();
	}

	public Plant newPlant() {
		System.out.println("水果长成！");
		return new Fruitage();
	}
}