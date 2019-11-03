package pattern05.builder;

public class BuilderTest {

	public static void main(String[] args) {
		Builder builder=new ConcreteBuilder();
        Director director=new Director(builder);
        Product product=director.construct();
        product.show();
	}
}

//��Ʒ��ɫ�����������ɲ����ĸ��Ӷ���
class Product
{
    private String partA;
    private String partB;
    private String partC;
    public void setPartA(String partA)
    {
        this.partA=partA;
    }
    public void setPartB(String partB)
    {
        this.partB=partB;
    }
    public void setPartC(String partC)
    {
        this.partC=partC;
    }
    public void show()
    {
        //��ʾ��Ʒ������
    	System.out.println("Part A:" + this.partA);
    	System.out.println("Part B:" + this.partB);
    	System.out.println("Part C:" + this.partC);
    }
}

//�������ߣ�����������Ʒ�����Ӳ����ĳ��󷽷�
abstract class Builder
{
    //������Ʒ����
    protected Product product=new Product();
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    //���ز�Ʒ����
    public Product getResult()
    {
        return product;
    }
}

//���彨���ߣ�ʵ���˳������߽ӿ�
class ConcreteBuilder extends Builder
{
    public void buildPartA()
    {
        product.setPartA("���� PartA");
    }
    public void buildPartB()
    {
        product.setPartB("���� PartB");
    }
    public void buildPartC()
    {
        product.setPartC("���� PartC");
    }
}

//ָ���ߣ����ý������еķ�����ɸ��Ӷ���Ĵ�����
class Director
{
    private Builder builder;
    public Director(Builder builder)
    {
        this.builder=builder;
    }
    //��Ʒ��������װ����
    public Product construct()
    {
        builder.buildPartA();
        builder.buildPartB();
        //builder.buildPartC();
        return builder.getResult();
    }
}
