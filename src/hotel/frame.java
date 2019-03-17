package hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

//import hotel.frame.JP1;
//import hotel.frame.JP2;
//import hotel.frame.JP3;
//import hotel.frame.JP4;
//import hotel.frame.LabelManager;
//import hotel.frame.MyLabel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import hotel.hotel;

public class frame {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	dateChoose dateChooser1 = dateChoose.getInstance("yyyy-MM-dd");
    dateChoose dateChooser2 = dateChoose.getInstance("yyyy-MM-dd");
    private JTextField textField;
    
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
	 public int differentDaysByMillisecond(Date date1,Date date2)
	    {
	        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
	        return days;
	    }
	 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6A21\u62DF\u65C5\u9986\u7BA1\u7406\u7CFB\u7EDF");
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setBackground(new Color(240, 255, 255));
		frame.setBounds(100, 100, 447, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Date date1 = new Date();
	    Date date2 = new Date();
		dateChoose dateChooser1 = dateChoose.getInstance("yyyy-MM-dd");
		dateChoose.getInstance(date1);
        dateChoose dateChooser2 = dateChoose.getInstance("yyyy-MM-dd");
        dateChoose.getInstance(date2);
		frame.getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 99, 104, 26);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText(" \u5355\u51FB\u9009\u62E9\u65E5\u671F");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(257, 99, 104, 26);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("\u5355\u51FB\u9009\u62E9\u65F6\u95F4");
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		dateChooser1.register(textField_1);
        dateChooser2.register(textField_2);
        frame.getContentPane().add(textField_1, BorderLayout.NORTH);
        frame.getContentPane().add(textField_2, BorderLayout.SOUTH);
        
		textField_3 = new JTextField();
		textField_3.setBounds(201, 99, 38, 26);
		textField_3.setBackground(new Color(240, 255, 255));
		textField_3.setBorder(null);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText("\u81F3");
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		JButton button = new JButton("\u786E\u5B9A\u751F\u6210");
		button.setBounds(175, 164, 88, 29);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setBackground(new Color(240, 255, 255));
		textField.setBorder(null);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u8BF7\u9009\u62E9\u8981\u6A21\u62DF\u7684\u65F6\u95F4\u533A\u95F4");
		textField.setBounds(116, 47, 205, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				String time1 = textField_1.getText();
				String time2 = textField_2.getText();
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
			    Date utilDate1 = null;
				try {
					utilDate1 = sdf.parse(time1);
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			    Date utilDate2 = null;
				try {
					utilDate2 = sdf.parse(time2);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    Date date1 = new java.sql.Date(utilDate1.getTime());
			    Date date2 = new java.sql.Date(utilDate2.getTime());
			    
			    list window = new list();
			    window.frame.setVisible(true);
			    
			  //定义:房间Queue
			    List<ArrayDeque> roomQueue =  new ArrayList();
			    int nowTime = 0;
			    int totalMoney = 0;
			    int dayTime = differentDaysByMillisecond(date1,date2);
			    //初始化100间房
			    int roomNumber = 100;
			    //价格
			    int[] price = {100,180,120,220,240};
			    //等级数
			    int rateNumber = 5;
			    //初始化
			    hotel.initialization(roomQueue,roomNumber,dayTime);

			    //Day 1
			    int k = 1;
			    window.txt.append("\r\n"+date1+"日订房信息"+"\r\n");
			    window.txt.append("   入住日期 "+"      住宿时间 "+" 入住房间号 "+"   入住楼层 "+" 性别 "+" 是否合住 "+" 是否为vip "+" 预计房型  "+ "   入住房型  "+"  单晚房价"+"  合计价格" +"\r\n");
			    //生成新客户的条件：nowTime < 24*dayTime
			    while( nowTime < 24* dayTime)
			    {
			        Customer customer = new Customer();
			        nowTime = nowTime+customer.intertime;
			        if ( ((nowTime-customer.intertime) < 24*k) && (nowTime >= 24*k) ){
			            k++;
			            Calendar c = Calendar.getInstance();  
			            c.setTime(date1);  
			            c.add(Calendar.DAY_OF_MONTH, 1); 
			            date1 = c.getTime();
			            
			            if (k<=dayTime)
			            {
			             	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			              	window.txt.append("\r\n"+sd.format(date1)+"日订房信息"+"\r\n");
			              	window.txt.append("   入住日期 "+"      住宿时间 "+" 入住房间号 "+"   入住楼层 "+" 性别 "+" 是否合住 "+" 是否为vip "+" 预计房型  "+ "   入住房型  "+"  单晚房价"+"  合计价格" +"\r\n");
			                //先更新到第二日订房
			                hotel.daliyUpdate(roomQueue,roomNumber);
			                //再预订
			                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			                window.txt.append(sdf1.format(date1));
			                totalMoney += hotel.reserve(roomQueue,customer,customer.level,rateNumber,price,window.txt);
			            }
			        }else{
			            //直接订房
		     	        	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			         	window.txt.append(sdf1.format(date1));
			            totalMoney += hotel.reserve(roomQueue,customer,customer.level,rateNumber,price,window.txt);
			        }
			    }
			    window.txt.append("                                                                                                                                  期间共"+dayTime+"天的营业额为："+totalMoney+"\r\n");
			}
			    
			
		});

	
	}
}
