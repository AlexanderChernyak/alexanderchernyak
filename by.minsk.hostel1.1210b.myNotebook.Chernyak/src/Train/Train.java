package Train;

import java.io.Serializable;

public class Train implements Serializable, interfaceTrain{
	protected int numberOfTrain;
	protected int numberOfWagons;
	protected String typeOfTrain;
	protected int numberOfPassengers;
	protected String fromTheTrain;
	protected String whereTheTrain;
	
	public Train() {
		this.numberOfTrain = -1;
		this.numberOfWagons = -1;
		this.typeOfTrain = new String();
		this.numberOfPassengers = -1;
		this.fromTheTrain = new String();
		this.whereTheTrain = new String();
	}
	
	public Train(int num, int kol, String type, int pass, String otkuda, String kuda) {
		this.numberOfTrain = num;
		this.numberOfWagons = kol;
		this.typeOfTrain = type;
		this.numberOfPassengers = pass;
		this.fromTheTrain = otkuda;
		this.whereTheTrain = kuda;
	}
	
	@Override
	public void setTrain() {
		System.out.println("Информация о поезеде: Номер - " + this.numberOfTrain + 
				"Кол-во вагонов - " + this.numberOfWagons + "Тип -" + this.typeOfTrain +
				"Кол-во пассажиров - " + this.numberOfPassengers);
		System.out.println("Маршрут: " + this.fromTheTrain + " - " + this.whereTheTrain); 
	}
	
	@Override
	public void getNumberOfTrain(int numberOfTrain)
	{
		this.numberOfTrain = numberOfTrain;
	}
	
	@Override
	public void getNumberWagons(int numberOfWagons)
	{
		this.numberOfWagons = numberOfWagons;
	}
	
	@Override
	public void getTypeOfTrain(String typeOfTrain)
	{
		this.typeOfTrain = typeOfTrain;
	}
	
	@Override
	public void getNumberPassengers(int numberOfPassengers)
	{
		this.numberOfPassengers = numberOfPassengers;
	}
	
	@Override
	public void getFromTheTrain(String outTrain)
	{
		this.fromTheTrain = outTrain;
	}
	
	@Override
	public void getWhereTheTrain(String inTrain)
	{
		this.whereTheTrain = inTrain;
	}

}
