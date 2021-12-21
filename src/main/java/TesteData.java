import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteData {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss z");
		Date hj=new Date();
		String dataH = sdf.format(hj);
		System.out.println(sdf.format(hj));
		System.out.println(dataH);
		
	}

}
