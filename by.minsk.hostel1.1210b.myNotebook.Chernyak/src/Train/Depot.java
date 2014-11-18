package Train;

public class Depot extends Train implements interfaceDepot{
	private String city;
	private int numberOfDepot;
	
	public Depot() {
		this.city = new String();
		this.numberOfDepot = -1;
		this.numberOfTrain = -1;
		this.numberOfWagons = -1;
		this.typeOfTrain = new String();
		this.numberOfPassengers = -1;
		this.fromTheTrain = new String();
		this.whereTheTrain = new String();
	}
	
	public Depot(int num, int kol, String type, int pass, String otkuda, String kuda, String gor,
			int numdepo) {
		this.numberOfTrain = num;
		this.numberOfWagons = kol;
		this.typeOfTrain = type;
		this.numberOfPassengers = pass;
		this.fromTheTrain = otkuda;
		this.whereTheTrain = kuda;
		this.city = gor;
		this.numberOfDepot = numdepo;
	}
	
	@Override
	public void setDepot() {
		System.out.println("Информация о поезеде: Номер - " + this.numberOfTrain + 
				"Кол-во вагонов - " + this.numberOfWagons + "Тип -" + this.typeOfTrain +
				"Кол-во пассажиров - " + this.numberOfPassengers);
		System.out.println("Маршрут: " + this.fromTheTrain + " - " + this.whereTheTrain);
		System.out.println("Стоит в депо города: " + this.city + " номер - " + this.numberOfDepot);
	}
	
	@Override
	public void getCity(String city)
	{
		this.city = city;
	}
	
	@Override
	public void getNumberOfDepot(int numOfDepot)
	{
		this.numberOfDepot = numOfDepot;
	}
}
