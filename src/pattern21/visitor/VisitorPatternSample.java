package pattern21.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitorPatternSample {

	public static void main(String[] args) {
		SetMaterial sm = new SetMaterial();
		// 加入多个元素
		sm.add(new Paper());
		sm.add(new Cuprum());
		// 加入多个访问者, 每个访问者对于每个元素由不同的操作
		Company artcompany = new ArtCompany();
		sm.accept(artcompany);
		System.out.println("------------------------");
		Company mintcompany = new Mint();
		sm.accept(mintcompany);
	}

}

//抽象访问者:公司
interface Company {
	String create(Paper element);

	String create(Cuprum element);
}

//具体访问者：艺术公司
class ArtCompany implements Company {
	public String create(Paper element) {
		System.out.println("ArtCompany 创建讲学图");
		return "讲学图";
	}

	public String create(Cuprum element) {
		System.out.println("ArtCompany 创建朱熹铜像");
		return "朱熹铜像";
	}
}

//具体访问者：造币公司
class Mint implements Company {
	public String create(Paper element) {
		System.out.println("MintCompany 创建纸币");
		return "纸币";
	}

	public String create(Cuprum element) {
		System.out.println("MintCompany 创建铜币");
		return "铜币";
	}
}

//抽象元素：材料
interface Material {
	String accept(Company visitor);
}

//具体元素：纸
class Paper implements Material {
	public String accept(Company visitor) {
		return (visitor.create(this));
	}
}

//具体元素：铜
class Cuprum implements Material {
	public String accept(Company visitor) {
		return (visitor.create(this));
	}
}

//对象结构角色:材料集
class SetMaterial {
	private List<Material> list = new ArrayList<Material>();

	public String accept(Company visitor) {
		Iterator<Material> i = list.iterator();
		String tmp = "";
		while (i.hasNext()) {
			tmp += ((Material) i.next()).accept(visitor) + " ";
		}
		return tmp; // 返回某公司的作品集
	}

	public void add(Material element) {
		list.add(element);
	}

	public void remove(Material element) {
		list.remove(element);
	}
}