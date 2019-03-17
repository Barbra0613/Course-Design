package hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class list {

	public JFrame frame;
	public JTextArea txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list window = new list();
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
	public list() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 6, 810, 509);
		frame.getContentPane().add(scrollPane);
		
		txt = new JTextArea();
		scrollPane.setViewportView(txt);
		frame.setTitle("\u6A21\u62DF\u5217\u8868");
		frame.setBounds(100, 100, 816, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
