package calculator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import calculator.MyQueue;
import javax.swing.SwingConstants;

public class frame{
	private Double M = 0d; 
	
	private JFrame frame;
	private JTextField text1;
	private JTextField text2;
	
	public JRadioButton radioButton;
	public JRadioButton radioButton_1;

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

	
	
	public frame() {
		initialize();
	}

	

	//主界面
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(16, 16, 438, 68);
		frame.getContentPane().add(panel);
		
		text2 = new JTextField();
		text2.setHorizontalAlignment(SwingConstants.LEFT);
		text2.setColumns(36);
		text2.setBackground(new Color(245, 245, 245));
		text2.setBorder(null);
		panel.add(text2);
		
		text1 = new JTextField();
		text1.setHorizontalAlignment(SwingConstants.RIGHT);
		text1.setBackground(new Color(245, 245, 245));
		panel.add(text1);
		text1.setBorder(null);
		text1.setColumns(36);
		
		JButton btnNewButton = new JButton("MC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				M = 0d;
			}
		});
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setBounds(216, 96, 38, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnMr = new JButton("MR");
		btnMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1.setText(M.toString());
				//System.out.println("MR"+M);
			}
		});
		btnMr.setBackground(new Color(240, 255, 255));
		btnMr.setBounds(266, 96, 38, 29);
		frame.getContentPane().add(btnMr);
		
		JButton btnMs = new JButton("MS");
		btnMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text1.getText().equals(""))
					return;
				M = Double.parseDouble(text1.getText());
				//System.out.println("MS"+M);
			}
		});
		btnMs.setBackground(new Color(240, 255, 255));
		btnMs.setBounds(316, 96, 38, 29);
		frame.getContentPane().add(btnMs);
		
		JButton btnM = new JButton("M+");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text1.getText().equals(""))
					return;
				M += Double.parseDouble(text1.getText());
				text1.setText("");
				text2.setText("");
				//System.out.println("M+"+M);
			}
		});
		btnM.setBackground(new Color(240, 255, 255));
		btnM.setBounds(366, 96, 38, 29);
		frame.getContentPane().add(btnM);
		
		JButton btnM_1 = new JButton("M-");
		btnM_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text1.getText().equals(""))
					return;
				M -= Double.parseDouble(text1.getText());
				text1.setText("");
				text2.setText("");
				//System.out.println("M-"+M);
			}
		});
		btnM_1.setBackground(new Color(240, 255, 255));
		btnM_1.setBounds(416, 96, 38, 29);
		frame.getContentPane().add(btnM_1);
		
		JButton btnMc = new JButton("\u2190");
		btnMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!text2.getText().equals("")) {
					text2.setText(text2.getText().substring(0,
							text2.getText().length() - 1));
				}
			}
		});
		btnMc.setBackground(new Color(240, 255, 255));
		btnMc.setBounds(216, 137, 38, 29);
		frame.getContentPane().add(btnMc);
		
		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!text2.getText().equals("")) {
					text2.setText(text2.getText().substring(0,
							text2.getText().length() - 1));
				}
			}
		});
		btnCe.setBackground(new Color(240, 255, 255));
		btnCe.setBounds(266, 137, 38, 29);
		frame.getContentPane().add(btnCe);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1.setText(null);
				text2.setText(null);
			}
		});
		btnC.setBackground(new Color(240, 255, 255));
		btnC.setBounds(316, 137, 38, 29);
		frame.getContentPane().add(btnC);
		
		JButton btnMc_1 = new JButton("\u00B1");
		btnMc_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				text2.setText(text2.getText() + "-");
			}
		});
		btnMc_1.setBackground(new Color(240, 255, 255));
		btnMc_1.setBounds(366, 137, 38, 29);
		frame.getContentPane().add(btnMc_1);
		
		JButton button = new JButton("\u221A");
		button.addActionListener(new ButtonAction());
		button.setBackground(new Color(240, 255, 255));
		button.setBounds(416, 137, 38, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("7");
		button_1.addActionListener(new ButtonAction());
		button_1.setBackground(new Color(240, 255, 255));
		button_1.setBounds(216, 178, 38, 29);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("8");
		button_2.addActionListener(new ButtonAction());
		button_2.setBackground(new Color(240, 255, 255));
		button_2.setBounds(266, 178, 38, 29);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("9");
		button_3.addActionListener(new ButtonAction());
		button_3.setBackground(new Color(240, 255, 255));
		button_3.setBounds(316, 178, 38, 29);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("/");
		button_4.addActionListener(new ButtonAction());
		button_4.setBackground(new Color(240, 255, 255));
		button_4.setBounds(366, 178, 38, 29);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("%");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!text1.getText().equals("")) {
					text2.setText(text1.getText() + "Mod");
					text1.setText(null);
				} else if (text1.getText().equals("")) {
					text2.setText(text2.getText() + "Mod");
				}
			}
		});
		button_5.setBackground(new Color(240, 255, 255));
		button_5.setBounds(416, 178, 38, 29);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("4");
		button_6.addActionListener(new ButtonAction());
		button_6.setBackground(new Color(240, 255, 255));
		button_6.setBounds(216, 219, 38, 29);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("5");
		button_7.addActionListener(new ButtonAction());
		button_7.setBackground(new Color(240, 255, 255));
		button_7.setBounds(266, 219, 38, 29);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("6");
		button_8.addActionListener(new ButtonAction());
		button_8.setBackground(new Color(240, 255, 255));
		button_8.setBounds(316, 219, 38, 29);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("*");
		button_9.addActionListener(new ButtonAction());
		button_9.setBackground(new Color(240, 255, 255));
		button_9.setBounds(366, 219, 38, 29);
		frame.getContentPane().add(button_9);
		
		JButton btnx = new JButton("1/x");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!text1.getText().equals("")) {
						text2.setText("1 / " + text1.getText() + " =");
						Double x = 1 / Double.parseDouble(text1.getText());
						text1.setText(x.toString());
					} else if (text1.getText().equals("")
							&& !text2.getText().equals("")) {
						Double x = 1 / Double.parseDouble(text2.getText());
						text2.setText("1/" + text2.getText() + "=");
						text1.setText(x.toString());
					}
				} catch (Exception e1) {
					text1.setText(null);
					text2.setText("Error! Please Check!");
				}
			}
		});
		btnx.setBackground(new Color(240, 255, 255));
		btnx.setBounds(416, 219, 38, 29);
		frame.getContentPane().add(btnx);
		
		JButton button_10 = new JButton("1");
		button_10.addActionListener(new ButtonAction());
		button_10.setBackground(new Color(240, 255, 255));
		button_10.setBounds(216, 260, 38, 29);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("2");
		button_11.addActionListener(new ButtonAction());
		button_11.setBackground(new Color(240, 255, 255));
		button_11.setBounds(266, 260, 38, 29);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("3");
		button_12.addActionListener(new ButtonAction());
		button_12.setBackground(new Color(240, 255, 255));
		button_12.setBounds(316, 260, 38, 29);
		frame.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("-");
		button_13.addActionListener(new ButtonAction());
		button_13.setBackground(new Color(240, 255, 255));
		button_13.setBounds(366, 260, 38, 29);
		frame.getContentPane().add(button_13);
		
		JButton button_14 = new JButton("=");
		button_14.addActionListener(new ButtonAction());
		button_14.setBackground(new Color(240, 255, 255));
		button_14.setBounds(416, 301, 38, 29);
		frame.getContentPane().add(button_14);
		
		JButton button_15 = new JButton("0");
		button_15.addActionListener(new ButtonAction());
		button_15.setBackground(new Color(240, 255, 255));
		button_15.setBounds(216, 301, 38, 29);
		frame.getContentPane().add(button_15);
		
		JButton button_16 = new JButton(".");
		button_16.addActionListener(new ButtonAction());
		button_16.setBackground(new Color(240, 255, 255));
		button_16.setBounds(316, 301, 38, 29);
		frame.getContentPane().add(button_16);
		
		JButton button_17 = new JButton("+");
		button_17.addActionListener(new ButtonAction());
		button_17.setBackground(new Color(240, 255, 255));
		button_17.setBounds(366, 301, 38, 29);
		frame.getContentPane().add(button_17);
		
		JButton button_18 = new JButton("(");
		button_18.addActionListener(new ButtonAction());
		button_18.setBackground(new Color(240, 255, 255));
		button_18.setBounds(116, 137, 38, 29);
		frame.getContentPane().add(button_18);
		
		JButton button_19 = new JButton(")");
		button_19.addActionListener(new ButtonAction());
		button_19.setBackground(new Color(240, 255, 255));
		button_19.setBounds(166, 137, 38, 29);
		frame.getContentPane().add(button_19);
		
		radioButton = new JRadioButton(" \u5EA6");
		radioButton.setBounds(39, 96, 54, 23);
		radioButton.setSelected(true);
		frame.getContentPane().add(radioButton);
		
		radioButton_1 = new JRadioButton(" \u5F27\u5EA6");
		radioButton_1.setBounds(131, 97, 62, 23);
		frame.getContentPane().add(radioButton_1);
		
		JButton btnN = new JButton("n!");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!text1.getText().equals("")) {
						int n;
						text2.setText(text1.getText() + "!=");
						int m = (int) Double.parseDouble(text2.getText()
								.substring(0, text2.getText().indexOf("!"))
								.trim());
						if (isBigDecimal(m)) {
							n = (int) m;
							if(n<0){
								text1.setText(null);
								text2.setText("Error! Please Check!");
								return;
							}
						} else {
							text1.setText(null);
							text2.setText("Error! Please Check!");
							return;
						}
						int s = fact(m);
						text1.setText(String.valueOf(s));
					} else if (text1.getText().equals("")
							&& !text2.getText().equals("")) {
						int n = 0;
						text2.setText(text2.getText() + " ! =");
						double m = Double.parseDouble(text2.getText()
								.substring(0, text2.getText().indexOf("!"))
								.trim());
						if (isBigDecimal(m)) {
							n = (int) m;
							if(n<0){
								text1.setText(null);
								text2.setText("Error! Please Check!");
								return;
							}
						} else {
							text1.setText(null);
							text2.setText("Error! Please Check!");
							return;
						}
						int s = fact(n);
						text1.setText(String.valueOf(s));
					}
				} catch (Exception e1) {
					text1.setText(null);
					text2.setText("Error! Please Check!");
				}
			
			}
		});
		btnN.setBackground(new Color(240, 255, 255));
		btnN.setBounds(166, 178, 38, 29);
		frame.getContentPane().add(btnN);
		
		JButton btnYx = new JButton("asin");
		btnYx.addActionListener(new ButtonAction());
		btnYx.setBackground(new Color(240, 255, 255));
		btnYx.setBounds(66, 301, 38, 29);
		frame.getContentPane().add(btnYx);
		
		JButton btnx_1 = new JButton("\u221Ax");
		btnx_1.addActionListener(new ButtonAction());
		btnx_1.setBackground(new Color(240, 255, 255));
		btnx_1.setBounds(166, 219, 38, 29);
		frame.getContentPane().add(btnx_1);
		
		JButton btnx_2 = new JButton("10^x");
		btnx_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!text1.getText().equals("")) {
					text2.setText("10^" + text1.getText() +" =");
					Double x = Math.pow (10,(Double.parseDouble(text1.getText())));
					text1.setText(x.toString());
				} else {
					Double x = Math.pow (10,(Double.parseDouble(text2.getText())));
					text2.setText("10^" + text2.getText() +" =");
					text1.setText(x.toString());
				}
			}
		});
		btnx_2.setBackground(new Color(240, 255, 255));
		btnx_2.setBounds(166, 260, 38, 29);
		frame.getContentPane().add(btnx_2);
		
		JButton btnX = new JButton("x^2");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (!text1.getText().equals("")) {
						text2.setText(text1.getText() + "^2 =");
						Double x = Math.pow ((Double.parseDouble(text1.getText())),2);
						text1.setText(x.toString());
					} else {
						Double x = Math.pow ((Double.parseDouble(text2.getText())),2);
						text2.setText(text2.getText() + "^2 =");
						text1.setText(x.toString());
					}
			}
		});
		btnX.setBackground(new Color(240, 255, 255));
		btnX.setBounds(116, 178, 38, 29);
		frame.getContentPane().add(btnX);
		
		JButton btnXy = new JButton("x^y");
		btnXy.addActionListener(new ButtonAction());
		btnXy.setBackground(new Color(240, 255, 255));
		btnXy.setBounds(116, 219, 38, 29);
		frame.getContentPane().add(btnXy);
		
		JButton btnX_1 =  new JButton("x^3");
		btnX_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!text1.getText().equals("")) {
					text2.setText(text1.getText() + "^3 =");
					Double x = Math.pow ((Double.parseDouble(text1.getText())),3);
					text1.setText(x.toString());
				} else {
					Double x = Math.pow ((Double.parseDouble(text2.getText())),3);
					text2.setText(text2.getText() + "^3 =");
					text1.setText(x.toString());
				}
		}
	});
		btnX_1.setBackground(new Color(240, 255, 255));
		btnX_1.setBounds(116, 260, 38, 29);
		frame.getContentPane().add(btnX_1);
		
		JButton btnLog = new JButton("log");
		btnLog.setBackground(new Color(240, 255, 255));
		btnLog.setBounds(166, 301, 38, 29);
		frame.getContentPane().add(btnLog);
		
		JButton btnSin = new JButton("sin");
		btnSin.addActionListener(new ButtonAction());
		btnSin.setBackground(new Color(240, 255, 255));
		btnSin.setBounds(66, 178, 38, 29);
		frame.getContentPane().add(btnSin);
		
		JButton btnCos = new JButton("cos");
		btnCos.addActionListener(new ButtonAction());
		btnCos.setBackground(new Color(240, 255, 255));
		btnCos.setBounds(66, 219, 38, 29);
		frame.getContentPane().add(btnCos);
		
		JButton btnTan = new JButton("tan");
		btnTan.addActionListener(new ButtonAction());
		btnTan.setBackground(new Color(240, 255, 255));
		btnTan.setBounds(66, 260, 38, 29);
		frame.getContentPane().add(btnTan);
		
		JButton btnMod = new JButton("Mod");
		btnMod.addActionListener(new ButtonAction());
		btnMod.setBackground(new Color(240, 255, 255));
		btnMod.setBounds(116, 301, 38, 29);
		frame.getContentPane().add(btnMod);
		
		JButton btnSin_1 = new JButton("sinh");
		btnSin_1.addActionListener(new ButtonAction());
		btnSin_1.setBackground(new Color(240, 255, 255));
		btnSin_1.setBounds(16, 178, 38, 29);
		frame.getContentPane().add(btnSin_1);
		
		JButton btnCosh = new JButton("cosh");
		btnCosh.addActionListener(new ButtonAction());
		btnCosh.setBackground(new Color(240, 255, 255));
		btnCosh.setBounds(16, 219, 38, 29);
		frame.getContentPane().add(btnCosh);
		
		JButton btnTanh = new JButton("tanh");
		btnTanh.addActionListener(new ButtonAction());
		btnTanh.setBackground(new Color(240, 255, 255));
		btnTanh.setBounds(16, 260, 38, 29);
		frame.getContentPane().add(btnTanh);
		
		JButton btnExp = new JButton("Exp");
		btnExp.addActionListener(new ButtonAction());
		btnExp.setBackground(new Color(240, 255, 255));
		btnExp.setBounds(16, 301, 38, 29);
		frame.getContentPane().add(btnExp);
		
		JButton button_20 = new JButton("\u03C0");
		button_20.addActionListener(new ButtonAction());
		button_20.setBackground(new Color(240, 255, 255));
		button_20.setBounds(66, 137, 38, 29);
		frame.getContentPane().add(button_20);
		
		JButton btnLn = new JButton("ln");
		btnLn.addActionListener(new ButtonAction());
		btnLn.setBackground(new Color(240, 255, 255));
		btnLn.setBounds(16, 137, 38, 29);
		frame.getContentPane().add(btnLn);
		
		JButton button_21 = new JButton("");
		button_21.setBackground(new Color(240, 255, 255));
		button_21.setBounds(266, 301, 38, 29);
		frame.getContentPane().add(button_21);
		
		JButton button_22 = new JButton("");
		button_22.setBackground(new Color(240, 255, 255));
		button_22.setBounds(416, 260, 38, 29);
		frame.getContentPane().add(button_22);
		frame.setForeground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setTitle("\u8BA1\u7B97\u5668_\u8521\u6674_3016218108");
		frame.setBounds(100, 100, 471, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnv = new JMenu(" \u67E5\u770B(V)  ");
		menuBar.add(mnv);
		
		JMenuItem mntmKexue = new JMenuItem("\u79D1\u5B66\u8BA1\u7B97\u5668");
		mnv.add(mntmKexue);
		
		JMenu mne = new JMenu(" \u7F16\u8F91(E) ");
		menuBar.add(mne);
		
		JMenu mnh = new JMenu(" \u5E2E\u52A9(H) ");
		menuBar.add(mnh);
	}
	
	// 判断是否为整数
	public static boolean isBigDecimal(double n) {
		String s = String.valueOf(n);
		String st = s.substring(s.indexOf(".") + 1);
		int i = Integer.parseInt(st);
		if (i == 0) {
			return true;
		} else
			return false;
	}

	//转换标记
	public String transform(String string) {
		StringBuffer stringbuffer = new StringBuffer(string);
		while (stringbuffer.toString().contains("asin")) {
			stringbuffer.replace(stringbuffer.indexOf("asin"),
					stringbuffer.indexOf("asin") + 3, "i");
		}
		while (stringbuffer.toString().contains("acos")) {
			stringbuffer.replace(stringbuffer.indexOf("acos"),
					stringbuffer.indexOf("acos") + 3, "o");
		}
		while (stringbuffer.toString().contains("atan")) {
			stringbuffer.replace(stringbuffer.indexOf("atan"),
					stringbuffer.indexOf("atan") + 3, "a");
		}
		while (stringbuffer.toString().contains("sinh")) {
			stringbuffer.replace(stringbuffer.indexOf("sinh"),
					stringbuffer.indexOf("sinh") + 3, "S");
		}
		while (stringbuffer.toString().contains("cosh")) {
			stringbuffer.replace(stringbuffer.indexOf("cosh"),
					stringbuffer.indexOf("cosh") + 3, "C");
		}
		while (stringbuffer.toString().contains("tanh")) {
			stringbuffer.replace(stringbuffer.indexOf("tanh"),
					stringbuffer.indexOf("tanh") + 3, "T");
		}
		while (stringbuffer.toString().contains("sin")) {
			stringbuffer.replace(stringbuffer.indexOf("sin"),
					stringbuffer.indexOf("sin") + 3, "s");
		}
		while (stringbuffer.toString().contains("cos")) {
			stringbuffer.replace(stringbuffer.indexOf("cos"),
					stringbuffer.indexOf("cos") + 3, "c");
		}
		while (stringbuffer.toString().contains("tan")) {
			stringbuffer.replace(stringbuffer.indexOf("tan"),
					stringbuffer.indexOf("tan") + 3, "t");
		}
		while (stringbuffer.toString().contains("ln")) {
			stringbuffer.replace(stringbuffer.indexOf("ln"),
					stringbuffer.indexOf("ln") + 2, "l");
		}
		while (stringbuffer.toString().contains("log")) {
			stringbuffer.replace(stringbuffer.indexOf("log"),
					stringbuffer.indexOf("log") + 3, "g");
		}	
		while (stringbuffer.toString().contains("Exp")) {
			stringbuffer.replace(stringbuffer.indexOf("Exp"),
					stringbuffer.indexOf("Exp") + 3, "e");
		}
		return stringbuffer.toString();
	}

	//阶乘
	public int fact(int n) {
		//大于6000的数据可能有栈溢出的异常。
		if(n>6000){
			try {
				throw new Exception();
			} catch (Exception e) {
				text2.setText("数据无效。");
			}
			return 0;
		}
		
		if (n == 1 || n == 0) {
			return 1;
		}
		//数据溢出
		if(n*fact(n-1)<=0){
			try {
				throw new Exception();
			} catch (Exception e) {
				text2.setText("溢出");
			}
			return 0;
		}
		
		return n * fact(n - 1);
	}
	
	class ButtonAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if ((e.getActionCommand().equals("sin")
					|| e.getActionCommand().equals("cos")
					|| e.getActionCommand().equals("tan")
					|| e.getActionCommand().equals("Exp")
					|| e.getActionCommand().equals("sinh")
					|| e.getActionCommand().equals("cosh")
					|| e.getActionCommand().equals("tanh")
					|| e.getActionCommand().equals("asin")
					|| e.getActionCommand().equals("acos")
					|| e.getActionCommand().equals("atan")
					|| e.getActionCommand().equals("log") 
					|| e.getActionCommand().equals("ln"))) {
				if (text2.getText().endsWith("*")
						|| text2.getText().endsWith("/")
						|| text2.getText().endsWith("+")
						|| text2.getText().endsWith("-")
						|| text2.getText().endsWith("^")) {
					text2.setText(text2.getText() + e.getActionCommand());
					text1.setText("");
				} else {
					text2.setText(e.getActionCommand());
					text1.setText("");
				}
			} else if ((text2.getText().endsWith("=")
					|| text2.getText().endsWith("0")
					|| text2.getText().endsWith("1")
					|| text2.getText().endsWith("2")
					|| text2.getText().endsWith("3")
					|| text2.getText().endsWith("4")
					|| text2.getText().endsWith("5")
					|| text2.getText().endsWith("6")
					|| text2.getText().endsWith("7")
					|| text2.getText().endsWith("8") || text2.getText()
					.endsWith("9")) && e.getActionCommand().equals("(")) {
				//System.out.println("3e");
				text2.setText(e.getActionCommand());
				text1.setText(null);
			} else if (!e.getActionCommand().equals("=")
					&& text1.getText().equals("")
					&& !text2.getText().equals("输入不合法！")) {
				text2.setText(text2.getText() + e.getActionCommand());
			} else if (!e.getActionCommand().equals("=")
					&& text1.getText().equals("")
					&& text2.getText().equals("输入不合法！")) {
				text2.setText(e.getActionCommand());
			} else if (!e.getActionCommand().equals("=")
					&& !text1.getText().equals("")) {
				text2.setText(text1.getText() + e.getActionCommand());
				text1.setText("");
			} else if (e.getActionCommand().equals("=")) {
				if (radioButton.isSelected()) {
					try {
						text2.setText(text2.getText() + "=");
						if (text2.getText().contains("Mod")) {
							String string = text2.getText();
							double m1 = Double.parseDouble(string.substring(0, string.indexOf("Mod")).trim());
							double m2 = Double.parseDouble(string.substring(string.indexOf("Mod") + 3,string.length() - 1).trim());
							if (isBigDecimal(m2) && isBigDecimal(m1)) {
								text1.setText(String.valueOf(m1 % m2));
							} else {
								text1.setText(null);
								text2.setText("输入不合法！");
							}
						} else {
							String s1 = transform(text2.getText());
							String s = cal.ReplaceMinusString(s1);
							MyQueue<String> PFX = cal.TransIntoSuffix(s);
							Double result = cal.RadFigure(PFX);
							text1.setText(result.toString());
						}

					} catch (Exception e1) {
						text1.setText(null);
						text2.setText("Error! Please Check!");
						e1.printStackTrace();
					}
				} else if (radioButton_1.isSelected()) {
					try {
						text2.setText(text2.getText() + "=");
						if (text2.getText().contains("Mod")) {
							String string = text2.getText();
							double m1 = Double.parseDouble(string
									.substring(0, string.indexOf("Mod"))
									.trim());
							double m2 = Double.parseDouble(string.substring(string.indexOf("Mod") + 3 , string.length() - 1).trim());
							if (isBigDecimal(m2) &&isBigDecimal(m1)) {
								text1.setText(String.valueOf(m1 % m2));
							} else {
								text1.setText(null);
								text2.setText("Error! Please Check!");
							}
						} else {
							String s1 = transform(text2.getText());
							String s = cal.ReplaceMinusString(s1);
							MyQueue<String> PFX = cal.TransIntoSuffix(s);
							Double result = cal.AngleFigure(PFX);
							text1.setText(result.toString());
						}
					} catch (Exception e1) {
						text1.setText(null);
						text2.setText("Error! Please Check!");
					}
				}
			}
		}
		}
}
