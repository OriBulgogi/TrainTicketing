import javax.swing.JFrame;

public class main extends JFrame {
	public static void main(String[] args) {
		String sample[]= {"대구,부산,1800,1830,9009,7,A12"};
	
		
		File_IO file_object = new File_IO();
		file_object.file_read("train.csv");
		file_object.file_write(sample,"reservation.csv");
		GUI display = new GUI();
		display.set_content();
		
	}
}
