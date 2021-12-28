import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JD extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JD dialog = new JD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JD() {
		setBounds(100, 100, 334, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uC785\uC11D \uC608\uC57D");
		btnNewButton.setBounds(115, 97, 91, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uC804 \uC88C\uC11D\uC774 \uB9E4\uC9C4\uB41C \uC5F4\uCC28\uC785\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel.setBounds(39, 45, 228, 23);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\uC790\uB3D9 \uC608\uC57D");
		btnNewButton_1.setBounds(12, 97, 91, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uCDE8\uC18C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(218, 97, 91, 23);
		contentPanel.add(btnNewButton_2);
	}
}
