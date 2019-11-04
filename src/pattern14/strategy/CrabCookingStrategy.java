package pattern14.strategy;

public class CrabCookingStrategy {

	private Kitchen cf; // 厨房
	private CrabCooking qzx, hsx; // 大闸蟹加工者

	CrabCookingStrategy() {
		// ---------------------------------
		cf = new Kitchen(); // 厨房
		qzx = new SteamedCrabs(); // 清蒸大闸蟹类
		hsx = new BraisedCrabs(); // 红烧大闸蟹类
		cf.setStrategy(qzx);
		cf.CookingMethod(); // 清蒸
		cf.setStrategy(hsx);
		cf.CookingMethod(); // 红烧
	}

	public static void main(String[] args) {
		new CrabCookingStrategy();
	}
}

//抽象策略类：大闸蟹加工类
interface CrabCooking {
	public void CookingMethod(); // 做菜方法
}

//具体策略类：清蒸大闸蟹
class SteamedCrabs implements CrabCooking {	

	public void CookingMethod() {
		System.out.println("清蒸大闸蟹");
	}
}

//具体策略类：红烧大闸蟹
class BraisedCrabs implements CrabCooking {	

	public void CookingMethod() {
		System.out.println("红烧大闸蟹");
	}
}

//环境类：厨房
class Kitchen {
	private CrabCooking strategy; // 抽象策略

	public void setStrategy(CrabCooking strategy) {
		this.strategy = strategy;
	}

	public CrabCooking getStrategy() {
		return strategy;
	}

	public void CookingMethod() {
		strategy.CookingMethod(); // 做菜
	}
}