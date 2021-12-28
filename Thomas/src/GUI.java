
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class GUI extends JFrame {
	public GUI() {


	}

	public Search_Panel search_panel = null;
	public Current_info current_info = null;
	public Train_list train_list = null;
	public Seat_list seat_list = null;
	private base_Panel panelName = null;
	public int get_class = 0;

	void change(GUI win, base_Panel panelName) {

		getContentPane().removeAll();
		if (get_class == 1) {
			win.panelName = new Current_info(win);
		} else if (get_class == 2) {
			win.panelName = new Train_list(win);
		} else if (get_class == 3) {
			win.panelName = new Seat_list(win);
		} else if (get_class == 4) {
			win.panelName = new Search_Panel(win);
		}

		win.getContentPane().add(win.panelName);
		revalidate();
		repaint();
	}

	void set_content() {
		GUI gui_frame = new GUI();
		gui_frame.setTitle("철도 예약 시스템");
		gui_frame.search_panel = new Search_Panel(gui_frame);

		gui_frame.getContentPane().add(gui_frame.search_panel);
		gui_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gui_frame.setSize(350, 450);
		gui_frame.setVisible(true);
	}
}

class base_Panel extends JPanel {
	private GUI win;
	protected JButton before_btn = new JButton("◀");
	private JButton current_info_btn = new JButton("예매 내역보기");
	protected JLabel chulbal = new JLabel("출발");
	protected JLabel dochak = new JLabel("도착");
	protected JLabel right_arrow = new JLabel("▶");

	protected JPanel[] panels = new JPanel[10];
	protected JPanel mainMenu = new JPanel();
	protected JPanel bottomMenu = new JPanel();
	protected JPanel border_panel = new JPanel();

	protected GridBagConstraints gbc = new GridBagConstraints();
	protected GridBagConstraints bottom_gbc = new GridBagConstraints();
	protected GridBagConstraints notfill_gbc = new GridBagConstraints();

	static String contry_list[] = { "대구", "부산", "영천", "구미", "경산" };
	static String month_list[] = { "11월" };
	static String day_list[] = { "13일" };
	String time_list[] = { "12시" };

	void CommonStyle(GUI win) {

		this.win = win;
		win.setLayout(null);
		win.setLayout(new GridBagLayout());
		border_panel.setBorder(new TitledBorder(new LineBorder(Color.black), "info"));

		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel(new GridBagLayout());
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weightx = 1;
			gbc.weighty = 1;
			gbc.gridy = i;
			gbc.insets = new Insets(5, 15, 5, 15);
			win.add(panels[i], gbc);
		}
		bottom_gbc.insets = new Insets(0, 15, 0, 0);
		bottom_gbc.fill = GridBagConstraints.HORIZONTAL;
		bottom_gbc.weightx = 1;
		bottom_gbc.weighty = 1;
		panels[9].add(before_btn, bottom_gbc);
		bottom_gbc.weightx = 3;
		panels[9].add(current_info_btn, bottom_gbc);
		current_info_btn.addActionListener(new current_info_ActionLister());
	}

	class current_info_ActionLister implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			win.get_class = 1;
			win.change(win, win.current_info);
		}
	}

}

class Search_Panel extends base_Panel {

	private GUI win;
	private JButton Lookup_btn = new JButton("조회하기");
	private static JComboBox start_CB = new JComboBox(contry_list);
	private static JComboBox end_CB = new JComboBox(contry_list);

	private static JComboBox month_CB = new JComboBox(month_list);
	private static JComboBox day_CB = new JComboBox(day_list);
	private JComboBox time_CB = new JComboBox(time_list);
	private JTextField poeple = new JTextField(10);

	Search_Panel() {}

	public static String getStart() {
		Object s = start_CB.getSelectedItem();
		return (String) s;
	}
	public static String getEnd() {
		Object e = end_CB.getSelectedItem();
		return (String) e;
	}
	public static String getMonth() {
		Object m = month_CB.getSelectedItem();
		return (String) m;
	}
	public static String getDay() {
		Object d = day_CB.getSelectedItem();
		return (String) d;
	}

	public Search_Panel(GUI win) {
		this.win = win;
		CommonStyle(win);
		chulbal.setHorizontalAlignment(JLabel.CENTER);
		dochak.setHorizontalAlignment(JLabel.CENTER);
		notfill_gbc.weightx = 1;
		panels[0].add(chulbal, notfill_gbc);
		panels[0].add(dochak, notfill_gbc);
		panels[1].add(start_CB, notfill_gbc);
		notfill_gbc.weightx = 0.1;

		panels[1].add(right_arrow, notfill_gbc);
		notfill_gbc.weightx = 1;
		panels[1].add(end_CB, notfill_gbc);

		panels[2].add(new JLabel("출발시간"), notfill_gbc);
		panels[2].add(month_CB, notfill_gbc);
		panels[2].add(day_CB, notfill_gbc);
		panels[2].add(time_CB, notfill_gbc);
		panels[3].setLayout(new FlowLayout(FlowLayout.LEFT, 17, 0));

		panels[3].add(new JLabel("승객수"));
		panels[3].add(poeple);
		panels[3].add(new JLabel("명"));
		Lookup_btn.addActionListener(new go_listpanel());
		panels[8].add(Lookup_btn, bottom_gbc);

	}

	class go_listpanel implements ActionListener {

		@Override

		public void actionPerformed(ActionEvent e) {

			if (poeple.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
			}
			int num = Integer.parseInt(poeple.getText());
			if (num >= 10) {
				JOptionPane.showMessageDialog(null, "10장 이상의 표는 예약하실 수 없습니다.");
			} else {
				win.get_class = 2;
				win.change(win, win.train_list);
			}
		}
	}
}

class Current_info extends base_Panel {
	private GUI win;
	private int i = 0;

	public Current_info(GUI win) {
		this.win = win;
		CommonStyle(win);

		notfill_gbc.weightx = 1;
		panels[0].add(new JLabel("2020 - 11 - 09 "), notfill_gbc);
		panels[0].add(new JLabel("2 매"), notfill_gbc);

		panels[1].add(new JLabel("대구"), notfill_gbc);
		panels[1].add(right_arrow, notfill_gbc);
		panels[1].add(new JLabel("구미"), notfill_gbc);

		panels[2].add(new JLabel("18:25"), notfill_gbc);
		panels[2].add(new JLabel(" "), notfill_gbc);
		panels[2].add(new JLabel("19:10"), notfill_gbc);

		panels[3].add(new JLabel("열차번호  1005"), notfill_gbc);
		panels[3].add(new JLabel(" "), notfill_gbc);
		panels[3].add(new JLabel(" "), notfill_gbc);

		panels[4].add(new JLabel("3 호차 / 23 좌석"), notfill_gbc);
		panels[4].add(new JLabel(" "), notfill_gbc);
		panels[4].add(new JLabel(" "), notfill_gbc);
		panels[7].add(new JButton("반환"));
		before_btn.addActionListener(new before_btn_ActionListener());
	}

	public class before_btn_ActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			win.get_class = 4;
			win.change(win, win.search_panel);
		}
	}

}

class Train_list extends base_Panel {
	private GUI win;

	Search_Panel sp = new Search_Panel();

	public Train_list(GUI win) {
		this.win = win;
		File_IO file_object = new File_IO();
		CommonStyle(win);
		notfill_gbc.weightx = 1;
		panels[0].add(new JLabel(sp.getStart()), notfill_gbc);
		panels[0].add(right_arrow, notfill_gbc);
		panels[0].add(new JLabel(sp.getEnd()), notfill_gbc);
		win.remove(panels[1]);
		gbc.weighty =1.0;
		gbc.gridx = 0;
        gbc.gridy = 1;
		win.add(panels[1], gbc);
		
		panels[1].add(new JButton("◀전일"), notfill_gbc);
		panels[1].add(new JLabel(sp.getMonth()+" "+sp.getDay()), notfill_gbc);
		panels[1].add(new JButton("후일▶"), notfill_gbc);
		
		JButton[] seatSelect = new JButton[4];
		before_btn.addActionListener(new before_btn_ActionListener());

		ArrayList<String[]> tlist= new ArrayList<String[]>();
		tlist=file_object.file_read("train.csv");

		int j=1,i;
		
		for (i = 0; i < tlist.size(); i++) {
			if (tlist.get(i)[0].contentEquals(sp.getStart()) && tlist.get(i)[1].contentEquals(sp.getEnd())&&tlist.get(i)[2].contentEquals(sp.getMonth())&&tlist.get(i)[3].contentEquals(sp.getDay())) {
				panels[j + 1].add(new JLabel("열차번호 " + tlist.get(i)[5]), notfill_gbc);
				panels[j + 1].add(new JLabel("출발시간 " + tlist.get(i)[4]), notfill_gbc);
				if(tlist.get(i)[6].contentEquals("0"))
					panels[j + 1].add(seatSelect[j] = new JButton("매진"), notfill_gbc);
				else
					panels[j + 1].add(seatSelect[j] = new JButton("선택"), notfill_gbc);

				if(seatSelect[j].getText()=="매진")
					seatSelect[j].addActionListener(new sold_out());            				
				else
					seatSelect[j].addActionListener(new go_seatlist());
				j++;
			}//리턴값으로 2layer array 
		}
		
	}
	class go_seatlist implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			win.get_class = 3;
			win.change(win, win.seat_list);
		}
	}

	class sold_out implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JD soldout=new JD();
			soldout.setVisible(true);
		}
	}

	public class before_btn_ActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			win.get_class = 4;
			win.change(win, win.search_panel);
		}
	}
}


class Seat_list extends base_Panel {
	private GUI win;
	String[] traing_comp_number = { "1호차", "2호차", "3호차" };

	public Seat_list(GUI win) {
		this.win = win;
		CommonStyle(win);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JComboBox train_comp_number = new JComboBox(traing_comp_number);
		panels[0].add(train_comp_number, gbc);

		panels[1].add(new JLabel("△:순방향   ▽:역방향   ▲▼:매진  "), notfill_gbc);
		panels[1].add(new JLabel(" "), notfill_gbc);
		panels[1].add(new JLabel(" "), notfill_gbc);
		JPanel[] seat_panel= new JPanel[3];
		for(int i=2;i<8;i++) {
			win.remove(panels[i]);
			
		}
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.weighty= 10000;
		gbc.fill = GridBagConstraints.BOTH;
		panels[2].setBorder(new TitledBorder(new LineBorder(Color.black), "info"));
		panels[2].setLayout(new FlowLayout(FlowLayout.LEFT, 17, 0));
		win.add(panels[2], gbc);
		
		GridBagConstraints seat_gbc = new GridBagConstraints();

		for(int i=0; i<seat_panel.length;i++) {
			seat_panel[i]= new JPanel(new FlowLayout());
			seat_gbc.fill = GridBagConstraints.BOTH;
			seat_panel[i].setBackground(Color.BLACK);
			panels[2].add(seat_panel[i],notfill_gbc);
			
		}

		
		before_btn.addActionListener(new before_btn_ActionListener());

	}

	public class before_btn_ActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			win.get_class = 2;
			win.change(win, win.train_list);
		}
	}
}