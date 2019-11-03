package pattern02.prototype;

public class ProtoTypeSample1 {

	public static void main(String[] args) {
		SunWukong obj1 = new SunWukong();
		SunWukong obj2 = (SunWukong) obj1.clone();
		System.out.println("是否是同一个悟空?" + (obj1 == obj2));
	}

}

class SunWukong implements Cloneable {

	public SunWukong() {
		System.out.println("悟空出世!");
	}

	public Object clone() {
		SunWukong w = null;
		try {
			w = (SunWukong) super.clone();
			System.out.println("拷贝悟空成功!");
		} catch (CloneNotSupportedException e) {
			System.out.println("拷贝悟空失败!");
		}
		return w;
	}
}