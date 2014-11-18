package Train;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	//private static Scanner scan;

	public static Depot addTrain() {
		Scanner scan = new Scanner(System.in);
		System.out.print("����� ������:");
		int num = scan.nextInt();
		System.out.print("���������� �������:");
		int kol = scan.nextInt();
		System.out.print("��� ������:");
		String type = scan.next();
		System.out.print("���������� ����������:");
		int pass = scan.nextInt();
		System.out.print("������:");
		String otkuda = scan.next();
		System.out.print("����:");
		String kuda = scan.next();
		System.out.print("����� �������:");
		String gor = scan.next();
		System.out.print("����� ����:");
		int numdepo = scan.nextInt();
		Depot depo = new Depot(num, kol, type, pass, otkuda, kuda, gor, numdepo);
		return depo;
	}
	
	public static int menu(){
		int ch;
		Scanner scan = new Scanner(System.in);
		System.out.println("��������� ����� ������� � ����! ����� ����������! =)");
		System.out.println("��� ����� ������?:");
		System.out.println("1. �������� �����.");
		System.out.println("2. ������� �� ����� ��� ������.");
		System.out.println("3. ������������� ������ � ������.");
		System.out.println("4. ������� ������ � ������.");
		System.out.println("5. �������� ������ � ����.");
		System.out.println("6. ������� ����.");
		System.out.println("7. ����� �� ���������.");
		System.out.print("��� ����� -> ");
		ch = scan.nextInt();
		return ch;
	}
	
	public static int editMenu()
	{
		int ch;
		Scanner scan = new Scanner(System.in);
		System.out.println("���� ��������������:");
		System.out.println("��� ����� �������������?:");
		System.out.println("1. ����� ������.");
		System.out.println("2. ���������� �������.");
		System.out.println("3. ��� ������.");
		System.out.println("4. ���������� ����������.");
		System.out.println("5. ������� �����������.");
		System.out.println("6. ������� ��������.");
		System.out.println("7. ����� �������.");
		System.out.println("8. ����� ����.");
		System.out.println("9. �����.");
		System.out.print("��� ����� -> ");
		ch = scan.nextInt();
		return ch;
	}
	
	public static void edit(List<Depot> dp)
	{
		Depot d = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("�������� ����� ������������� ������ �� ������������ ����:");
		int ch;
		ch = scan.nextInt();
		if(ch > dp.size())
			System.out.println("����� ������ ���!(");
		else
			d = (Depot) dp.get(ch - 1);
		
		d.setDepot();
		switch (editMenu()) {
		case 1:
			System.out.println("����� ������:");
			d.getNumberOfTrain(scan.nextInt());
			break;
		case 2:
			System.out.println("���������� �������:");
			d.getNumberWagons(scan.nextInt());
			break;
		case 3:
			System.out.println("��� ������:");
			d.getTypeOfTrain(scan.next());
			break;
		case 4:
			System.out.println("���������� ����������:");
			d.getNumberPassengers(scan.nextInt());
			break;
		case 5:
			System.out.println("������� �����������:");
			d.getFromTheTrain(scan.next());
			break;
		case 6:
			System.out.println("������� ��������:");
			d.getWhereTheTrain(scan.next());
			break;
		case 7:
			System.out.println("����� �������:");
			d.getCity(scan.next());
			break;
		case 8:
			System.out.println("����� ����:");
			d.getNumberOfDepot(scan.nextInt());
			break;
		case 9:
			//System.exit(0);
			break;
		}
		System.out.println("������ ����������������!");
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Scanner scan = new Scanner(System.in);
		Depot depo = new Depot();
		List<Depot> dp = new ArrayList<Depot>();
		Depot d = null;
		File file = new File( "laba1.txt");
		
		//int num = 0;
		do {
			switch (menu()){
			case 1: depo = addTrain();
					dp.add(depo);
					System.out.println("������ � ������ ���� ���������!");
					break;
			case 2: int i = 0;
					Iterator<Depot> it = dp.iterator();
					while(it.hasNext()) {
						i++;
						d = it.next();
						System.out.print(i+")");
						d.setDepot();
					}
					break;
			case 3: int a = 0;
					Iterator<Depot> it1 = dp.iterator();
					while(it1.hasNext()) {
						a++;
						d = it1.next();
						System.out.print(a+")");
						d.setDepot();
					}
				edit(dp); 
					break;
			case 4: int b = 0;
					Iterator<Depot> it2 = dp.iterator();
					while(it2.hasNext()) {
						b++;
						d = it2.next();
						System.out.print(b+")");
						d.setDepot();
					}
		
					System.out.println("�������� ����� ��������� ������:");
					int num = scan.nextInt();
					if (num > dp.size())
						System.out.println("����� ������ ���!(");
					else {
						dp.remove(num);
						System.out.println("������ ������� �������!");
					}
					break;
			case 5: file.write(dp);
					System.out.println("��������");
					break;
			case 6: dp.removeAll(dp);
					dp = file.read();
					break;
			case 7: System.exit(0);
				break;
			default: break;
			}
		} while(true);
	}
}
