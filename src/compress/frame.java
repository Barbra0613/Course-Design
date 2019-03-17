package compress;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;

import compress.hf.Compress;
import compress.hf.Decompress;
import compress.hf.hfm;
import compress.lz77.LZ77;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ShortBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class frame {

	private JFrame frame;
	private JTextField textField_1;
	private JButton button_1;
	public StringBuffer from_path = new StringBuffer();
	public StringBuffer to_path = new StringBuffer();
	private JTextField textField;
	private JTextField textField_2;
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
		frame.setTitle("\u538B\u7F29/\u89E3\u538B_\u8521\u6674_3016218108");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(56, 45, 330, 59);
		textField_1.setBorder(null);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(56, 94, 330, 59);
		frame.getContentPane().add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(56, 143, 330, 59);
		frame.getContentPane().add(textField_2);
		
		button_1 = new JButton(" \u9009\u62E9\u5F85\u64CD\u4F5C\u6587\u4EF6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				JFileChooser fd = new JFileChooser();
				//fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fd.showOpenDialog(null);
				File f = fd.getSelectedFile();
				String format = (f.getPath().substring(f.getPath().length()-3, f.getPath().length()));
				//System.out.println(format);
				if(f != null && !(format.equals("zip")))
				{
					String path1 = "";
					String path2 = "";
					String spath = "";
					from_path.append(f.getPath());
					//System.out.println(from_path.toString());
					StringBuffer temp1 = new StringBuffer (from_path);
					StringBuffer temp2 = new StringBuffer (from_path);
					spath = temp1.delete(temp1.length()-4, temp1.length()).append(".zip").toString();
					to_path = temp2.delete(temp2.length()-4, temp2.length()).append("hf.zip");
						try {
							//霍夫曼树压缩
							Compress compress = new Compress();
							//统计文件中0-255出现的次数
							compress.countTimes(from_path.toString());
							//构造哈夫曼树，并得到根节点
							hfm root=compress.createTree();
							//得到哈夫曼编码
							compress.getHuffmCode(root, "");
							//压缩文件
							compress.compress(from_path.toString(),to_path.toString());
							path1 = to_path.toString();
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						
					File fy = new File(to_path.toString());
					double index1 = 1-(double)fy.length()/(double)f.length();
					NumberFormat nf1 = NumberFormat.getPercentInstance();
					nf1.setMaximumFractionDigits(2);
					textField_1.setText( "霍夫曼树压缩率为:"+ nf1.format(index1) );
					
					int windowSize = 100;
				
					String inputFileName = from_path.toString();
					//System.out.println(to_path.toString());
					StringBuilder compressedFileNameBuilder = new StringBuilder();
					//System.out.println(to_path.delete(from_path.length()-4, from_path.length()).toString());
					String compressedFileName = new String(to_path.delete(from_path.length()-4, from_path.length()).append("lz.zip").toString());
					int extension = inputFileName.lastIndexOf(".");
					
					compressedFileName = to_path.toString();
					
					LZ77 lz77 = new LZ77(windowSize);
					try {
						lz77.compress(inputFileName, compressedFileName);
						path2 =  compressedFileName;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					fy = new File(to_path.toString());
					double index2 = 1-(double)fy.length()/(double)f.length();
					NumberFormat nf2 = NumberFormat.getPercentInstance();
					nf2.setMaximumFractionDigits(2);
					textField.setText( "LZ77压缩率为:"+ nf2.format(index2) );
					
					File dfile = null;
					File sfile = null;
					File tempf = null;
					if ( index1>=index2 ){
						
						dfile = new File(path2);
						dfile.delete();
						sfile = new File(path1);
						tempf = new File (spath);
						sfile.renameTo(tempf);	
						textField_2.setText("选择霍夫曼树压缩算法");
						
					}else{
					
						dfile = new File(path1);
						dfile.delete();
						sfile = new File(path2);
						tempf = new File (spath);
						sfile.renameTo(tempf);	
						textField_2.setText("选择LZ77压缩算法");
						
					}
					
				}
				else if ( f!=null ){
					from_path.append(f.getPath());
					//System.out.println(from_path.toString());
					StringBuffer temp = new StringBuffer (from_path);
					to_path = temp.delete(from_path.length()-4, from_path.length()).append("jy.txt");
					Decompress d = new Decompress();
					try {
						d.decompress(from_path.toString(),to_path.toString());
						textField.setText("选择霍夫曼树解压算法");
					}catch  (Exception e1){
//						try {
//							LZ77 lz77 = new LZ77(100);
//							System.out.println(from_path.toString()) ;
//							lz77.decompress(from_path.toString(), to_path.toString());
//						} catch (IOException e2) {
//							// TODO Auto-generated catch block
//							e2.printStackTrace();
//						}
						
					}finally {
						if( d.judge == false )
						{
							try {
 								LZ77 lz77 = new LZ77(100);
 								//System.out.println(from_path.toString()) ;
 								lz77.decompress(from_path.toString(), to_path.toString());
 								textField.setText("选择LZ77解压算法");
 							} catch (IOException e2) {
 								// TODO Auto-generated catch block
 								e2.printStackTrace();
 							}
						}
						
					}
					
				}
			}
		});
		button_1.setBounds(296, 231, 129, 29);
		frame.getContentPane().add(button_1);
		
		
	}
}
