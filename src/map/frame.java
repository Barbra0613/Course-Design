package map;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Map;

import javax.swing.SwingConstants;


import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class frame {

	private JFrame frame;
	private JTextField textField;
	public String [] ls = new String[34];
    public JTextArea textArea;
    public static JComboBox<String> comboBox;
    public static JComboBox<String> comboBox_1;
    public static JRadioButton radioButton; 
    public static JRadioButton radioButton_1;
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
		frame.setTitle("\u5929\u5927\u65B0\u6821\u533A\u5BFC\u822A");
		frame.setBounds(100, 100, 538, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(240, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(null);
		textField.setEditable(false);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField.setText("\u8BF7\u9009\u62E9\u6240\u9700\u5BFC\u822A\u6A21\u5F0F");
		textField.setBounds(184, 29, 167, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		radioButton = new JRadioButton("\u673A\u52A8\u8F66\u5BFC\u822A");
		radioButton.setBounds(127, 79, 108, 23);
		radioButton.setSelected(true);
		frame.getContentPane().add(radioButton);
		
		radioButton_1 = new JRadioButton("\u81EA\u884C\u8F66/\u884C\u4EBA\u5BFC\u822A");
		radioButton_1.setBounds(292, 79, 141, 23);
		frame.getContentPane().add(radioButton_1);
		
		ls[0] = "УҽԺ";
        ls[1] = "��԰����";
        ls[2] = "��50��ѧ¥������";
        ls[3] = "�ۺ�������";
        ls[4] = "������";
        ls[5] = "��԰����";
        ls[6] = "�������Ͻ�ѧ����";
        ls[7] = "÷԰����";
        ls[8] = "��55��ѧ¥������";
        ls[9] = "��31��ѧ¥������";
        ls[10] = "��԰����";
        ls[11] = "��԰����";
        ls[12] = "֣��ͼ���";
        ls[13] = "��44��ѧ¥������";
        ls[14] = "��45��ѧ¥������";
        ls[15] = "��47��ѧ¥��ʵ��";
        ls[16] = "����ʵ������";
        ls[17] = "��32��ѧ¥����";
        ls[18] = "��46��ѧ¥������";
        ls[19] = "��33��ѧ¥�����˼";
        ls[20] = "����㳡";
        ls[21] = "��43��ѧ¥��ˮ��";
        ls[22] = "��39��ѧ¥��ˮ��";
        ls[23] = "��37��ѧ¥����е";
        ls[24] = "������԰";
        ls[25] = "��36��ѧ¥����ѧ";
        ls[26] = "��԰";
        ls[27] = "֪԰";
        ls[28] = "ƽ԰";
        ls[29] = "��԰";
        ls[30] = "��԰";
        ls[31] = "��԰";
        ls[32] = "��԰";
        ls[33] = "��԰";
        
		
		comboBox = new JComboBox();
		comboBox.setBounds(167, 120, 196, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel label = new JLabel("\u8D77\u70B9");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(103, 124, 52, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u7EC8\u70B9");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(103, 163, 52, 16);
		frame.getContentPane().add(label_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(167, 159, 196, 27);
		frame.getContentPane().add(comboBox_1);
		
		for ( int i=0;i<34;i++ ) {
			comboBox.addItem(ls[i]);
			comboBox_1.addItem(ls[i]);
		}
		

		JButton button = new JButton("\u786E\u5B9A\u67E5\u8BE2");
		button.addActionListener(new ButtonMonitor());
		button.setBounds(226, 185, 96, 29);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 226, 431, 183);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		
	}
	
	private class ButtonMonitor implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			int i = comboBox.getSelectedIndex()+1;
			int j = comboBox_1.getSelectedIndex()+1;
			if (radioButton.isSelected()) {
				smap.Motor(i, j,textArea);
			}else if(radioButton_1.isSelected()) {
				smap.Bicycle(i, j,textArea);
			}else {
				textArea.append("��ѡ�����赼��ģʽ");
			}
		}
				
		}
}
