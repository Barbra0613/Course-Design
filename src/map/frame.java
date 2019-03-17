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
		
		ls[0] = "校医院";
        ls[1] = "青园餐厅";
        ls[2] = "第50教学楼—化工";
        ls[3] = "综合体育馆";
        ls[4] = "体育场";
        ls[5] = "留园餐厅";
        ls[6] = "化工材料教学组团";
        ls[7] = "梅园餐厅";
        ls[8] = "第55教学楼—计软";
        ls[9] = "第31教学楼—材料";
        ls[10] = "棠园餐厅";
        ls[11] = "桃园餐厅";
        ls[12] = "郑东图书馆";
        ls[13] = "第44教学楼—公共";
        ls[14] = "第45教学楼—公共";
        ls[15] = "第47教学楼—实验";
        ls[16] = "物理实验中心";
        ls[17] = "第32教学楼—理";
        ls[18] = "第46教学楼—公共";
        ls[19] = "第33教学楼—马克思";
        ls[20] = "北洋广场";
        ls[21] = "第43教学楼—水土";
        ls[22] = "第39教学楼—水土";
        ls[23] = "第37教学楼—机械";
        ls[24] = "体育公园";
        ls[25] = "第36教学楼—力学";
        ls[26] = "格园";
        ls[27] = "知园";
        ls[28] = "平园";
        ls[29] = "诚园";
        ls[30] = "正园";
        ls[31] = "修园";
        ls[32] = "治园";
        ls[33] = "齐园";
        
		
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
				textArea.append("请选择所需导航模式");
			}
		}
				
		}
}
