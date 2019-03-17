package automaticCourse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.awt.event.ActionEvent;

public class frame {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton button_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton button_3;
	private JButton button_4;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame window = new frame();
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
	public frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBackground(new Color(240, 255, 255));
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u8BFB\u5165\u6559\u5BA4\u4FE1\u606F");
		textField.setBounds(31, 33, 90, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u9009\u62E9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fd = new JFileChooser();
				fd.showOpenDialog(null);
				File f = fd.getSelectedFile();
				textField_3.setText(f.getName());
				auto.pathClassroom = f.getPath();
				
				
			}
		});
		button.setBounds(347, 33, 65, 29);
		frame.getContentPane().add(button);
		
		textField_1 = new JTextField();
		textField_1.setText("\u8BFB\u5165\u8BFE\u7A0B\u4FE1\u606F");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(240, 255, 255));
		textField_1.setBounds(31, 71, 90, 26);
		frame.getContentPane().add(textField_1);
		
		button_1 = new JButton("\u9009\u62E9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fd = new JFileChooser();
				fd.showOpenDialog(null);
				File f = fd.getSelectedFile();
				textField_4.setText(f.getName());
				auto.pathCourse = f.getPath();
			}
		});
		button_1.setBounds(347, 71, 65, 29);
		frame.getContentPane().add(button_1);
		
		textField_2 = new JTextField();
		textField_2.setText("\u8BFB\u5165\u5B66\u751F\u4FE1\u606F");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(240, 255, 255));
		textField_2.setBounds(31, 109, 90, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 33, 177, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(146, 71, 177, 26);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(146, 109, 177, 26);
		frame.getContentPane().add(textField_5);
		
		button_2 = new JButton("\u9009\u62E9");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fd = new JFileChooser();
				fd.showOpenDialog(null);
				File f = fd.getSelectedFile();
				textField_5.setText(f.getName());
				auto.pathClass = f.getPath();
			}
		});
		button_2.setBounds(347, 109, 65, 29);
		frame.getContentPane().add(button_2);
		
		textField_6 = new JTextField();
		textField_6.setText("\u8BFB\u5165\u6559\u5E08\u4FE1\u606F");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(new Color(240, 255, 255));
		textField_6.setBounds(31, 147, 90, 26);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(146, 147, 177, 26);
		frame.getContentPane().add(textField_7);
		
		button_3 = new JButton("\u9009\u62E9");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fd = new JFileChooser();
				fd.showOpenDialog(null);
				File f = fd.getSelectedFile();
				textField_7.setText(f.getName());
				auto.pathTeacher = f.getPath();
				
			}
		});
		button_3.setBounds(347, 147, 65, 29);
		frame.getContentPane().add(button_3);
		
		button_4 = new JButton("\u67E5\u8BE2\u6392\u79D1\u7ED3\u679C");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				auto.autoclass();
				frame.dispose();
				
			}
		});
		button_4.setBounds(303, 202, 109, 29);
		frame.getContentPane().add(button_4);
		frame.setBackground(new Color(240, 255, 255));
		frame.setTitle("\u81EA\u52A8\u6392\u8BFE\u7CFB\u7EDF");
		frame.setBounds(100, 100, 450, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
