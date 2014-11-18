package Train;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class File {
	private String name;
	
	public File(String name) {
		this.name = name;
	}
	
	public void write(List<Depot> dp) throws FileNotFoundException, IOException
	{ 
		ObjectOutputStream wr = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(name)));
		wr.writeObject(dp);
		wr.close();
	}
	
	public List<Depot> read() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream rd = new ObjectInputStream(new BufferedInputStream(new FileInputStream(name)));
		List<Depot> readObject = (List<Depot>) rd.readObject();
		rd.close();
		return readObject;
	}
	
}