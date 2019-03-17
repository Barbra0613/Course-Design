package automaticCourse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame1 {

	public JFrame frame;
	private JTextField txtnianji;
	private JTextField txtid;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u67E5\u8BE2\u6392\u8BFE\u7ED3\u679C");
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.getContentPane().setLayout(null);
		
		txtnianji = new JTextField();
		txtnianji.setHorizontalAlignment(SwingConstants.CENTER);
		txtnianji.setText("\u5F85\u67E5\u8BE2\u8BFE\u8868\u5E74\u7EA7id");
		txtnianji.setBorder(null);
		txtnianji.setBackground(new Color(240, 255, 255));
		txtnianji.setBounds(23, 63, 130, 26);
		frame.getContentPane().add(txtnianji);
		txtnianji.setColumns(10);
		
		txtid = new JTextField();
		txtid.setText("\u5F85\u67E5\u8BE2\u8BFE\u8868\u6559\u5E08id");
		txtid.setHorizontalAlignment(SwingConstants.CENTER);
		txtid.setColumns(10);
		txtid.setBorder(null);
		txtid.setBackground(new Color(240, 255, 255));
		txtid.setBounds(23, 136, 130, 26);
		frame.getContentPane().add(txtid);
		
		textField = new JTextField();
		textField.setBounds(179, 63, 122, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 136, 122, 26);
		frame.getContentPane().add(textField_1);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auto.showClass(Integer.parseInt(textField.getText()));
			}
		});
		button.setBounds(341, 63, 75, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auto.showTeacher(Integer.parseInt(textField_1.getText()));
			}
		});
		button_1.setBounds(341, 136, 75, 29);
		frame.getContentPane().add(button_1);
		frame.setBounds(100, 100, 450, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
