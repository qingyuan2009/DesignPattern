package pattern07.adaptor;

//Ŀ�꣺������
interface Motor {
	public void drive();
}

//������1�����ܷ�����
class ElectricMotor {
	public void electricDrive() {
		System.out.println("���ܷ���������������");
	}
}

//������2�����ܷ�����
class OpticalMotor {
	public void opticalDrive() {
		System.out.println("���ܷ���������������");
	}
}

//����������
class ElectricAdapter implements Motor {
	private ElectricMotor emotor;

	public ElectricAdapter() {
		emotor = new ElectricMotor();
	}

	public void drive() {
		emotor.electricDrive();
	}
}

//����������
class OpticalAdapter implements Motor {
	private OpticalMotor omotor;

	public OpticalAdapter() {
		omotor = new OpticalMotor();
	}

	public void drive() {
		omotor.opticalDrive();
	}
}

//�ͻ��˴���
public class AdaptorTest {
	public static void main(String[] args) {
		System.out.println("������ģʽ���ԣ�");
		Motor motor1 = (Motor) new OpticalAdapter() ;
		motor1.drive();
		Motor motor2 = (Motor) new ElectricAdapter() ;
		motor2.drive();
	}
}