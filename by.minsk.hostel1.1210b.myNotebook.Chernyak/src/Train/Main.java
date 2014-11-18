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
		System.out.print("Номер поезда:");
		int num = scan.nextInt();
		System.out.print("Количество вагонов:");
		int kol = scan.nextInt();
		System.out.print("Тип поезда:");
		String type = scan.next();
		System.out.print("Количество пассажиров:");
		int pass = scan.nextInt();
		System.out.print("Откуда:");
		String otkuda = scan.next();
		System.out.print("Куда:");
		String kuda = scan.next();
		System.out.print("Город стоянки:");
		String gor = scan.next();
		System.out.print("Номер депо:");
		int numdepo = scan.nextInt();
		Depot depo = new Depot(num, kol, type, pass, otkuda, kuda, gor, numdepo);
		return depo;
	}
	
	public static int menu(){
		int ch;
		Scanner scan = new Scanner(System.in);
		System.out.println("Программа учета поездов в депо! Добро пожаловать! =)");
		System.out.println("Что будем делать?:");
		System.out.println("1. Добавить поезд.");
		System.out.println("2. Вывести на экран все поезда.");
		System.out.println("3. Редактировать запись о поезде.");
		System.out.println("4. Удалить запись о поезде.");
		System.out.println("5. Записать данные в файл.");
		System.out.println("6. Открыть файл.");
		System.out.println("7. Выход из программы.");
		System.out.print("Ваш выбор -> ");
		ch = scan.nextInt();
		return ch;
	}
	
	public static int editMenu()
	{
		int ch;
		Scanner scan = new Scanner(System.in);
		System.out.println("Меню редактирования:");
		System.out.println("Что будем редактировать?:");
		System.out.println("1. Номер поезда.");
		System.out.println("2. Количество вагонов.");
		System.out.println("3. Тип поезда.");
		System.out.println("4. Количество пассажиров.");
		System.out.println("5. Станцию отправления.");
		System.out.println("6. Станцию прибытия.");
		System.out.println("7. Город стоянки.");
		System.out.println("8. Номер депо.");
		System.out.println("9. Назад.");
		System.out.print("Ваш выбор -> ");
		ch = scan.nextInt();
		return ch;
	}
	
	public static void edit(List<Depot> dp)
	{
		Depot d = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Выберите номер редактируемой записи из предложенных выше:");
		int ch;
		ch = scan.nextInt();
		if(ch > dp.size())
			System.out.println("Такой записи нет!(");
		else
			d = (Depot) dp.get(ch - 1);
		
		d.setDepot();
		switch (editMenu()) {
		case 1:
			System.out.println("Номер поезда:");
			d.getNumberOfTrain(scan.nextInt());
			break;
		case 2:
			System.out.println("Количество вагонов:");
			d.getNumberWagons(scan.nextInt());
			break;
		case 3:
			System.out.println("Тип поезда:");
			d.getTypeOfTrain(scan.next());
			break;
		case 4:
			System.out.println("Количество пассажиров:");
			d.getNumberPassengers(scan.nextInt());
			break;
		case 5:
			System.out.println("Станция отправления:");
			d.getFromTheTrain(scan.next());
			break;
		case 6:
			System.out.println("Станция прибытия:");
			d.getWhereTheTrain(scan.next());
			break;
		case 7:
			System.out.println("Город стоянки:");
			d.getCity(scan.next());
			break;
		case 8:
			System.out.println("Номер депо:");
			d.getNumberOfDepot(scan.nextInt());
			break;
		case 9:
			//System.exit(0);
			break;
		}
		System.out.println("Запись отредактированна!");
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
					System.out.println("Запись о поезде была добавлена!");
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
		
					System.out.println("Выберите номер удаляемой записи:");
					int num = scan.nextInt();
					if (num > dp.size())
						System.out.println("Такой записи нет!(");
					else {
						dp.remove(num);
						System.out.println("Запись успешно удалена!");
					}
					break;
			case 5: file.write(dp);
					System.out.println("Записано");
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
