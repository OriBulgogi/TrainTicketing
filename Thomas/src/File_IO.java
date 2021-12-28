import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class File_IO {

	ArrayList<String[]> file_read(String file_name) {

		String ret=null;
		ArrayList<String[]> tlist= new ArrayList<String[]>();
		try {
			File where = new File(file_name);
			BufferedReader br = new BufferedReader(new FileReader(where));
			String line = "";
			int i=0;
			while ((line = br.readLine()) != null) {
				String[] token = line.split(",");
				tlist.add(token);
				System.out.println(tlist.get(i)[0]);
				i++;
			}
			br.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		return tlist;
	}


	void file_write(String[] sample, String file_name) {
		ArrayList<String[]> originData=null;
		try {
			originData= file_read(file_name);
			File file = new File(file_name);
			//BufferedWriter bufferW = new BufferedWriter(new FileWriter(file));
			FileWriter fw=new FileWriter(file,true);
			
			int position=0;
			for(int i=0;i<sample.length;i++) {
				fw.append(sample[i]);
				fw.append("\n");
			}
			fw.close();
			//�ڿ� �̾��
			//if(file.isFile() && file.canWrite()) {
			//	for(String[] i : originData) {
			//		bufferW.write(i[position]);
			//		bufferW.newLine();
			//		position++;
			//	}
				
			//	for(int i =0; i<sample.length; i++) {
			//		bufferW.write(sample[i]);
			//		bufferW.newLine();
			//	}
			//	bufferW.close();
			//}
		}catch(Exception e){
			e.getStackTrace();
		}
		
	}
	void file_sort(String[] value) {
		//1.��-������ 2.���� �ð� 3.������ȣ�� ����x 4.ȣ�� �������� 5.�¼� �������� ���ĺ�-���� (�뱸,�λ�,1800,1830,9009,7,A12)
		//��
		//���ѿ��: �����ð��� ������ ��ġ�� �ʵ����Ѵ� -> �뼱�� ���÷��� �ð��� ����ó�� ����߰ڴ�.
		//�⵵��������

	}
}