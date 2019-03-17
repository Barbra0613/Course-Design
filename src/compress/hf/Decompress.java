package compress.hf;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
public class Decompress {
	
	public boolean judge = false;
	//ÿ������ĳ���
	public int [] codelengths = new int [256];
	//��Ӧ�Ĺ���������ֵ
	public String [] codeMap=new String[256];
	
	public static void main(String[] args) {
		
		Decompress d = new Decompress();
		d.decompress("/Users/a/Desktop/plz.zip","/Users/a/Desktop/1lz.txt");
	
	}
	
	
	public void decompress(String srcpath,String destpath) {
		
		try {
			FileInputStream fis = new FileInputStream(srcpath);
			FileOutputStream fos = new FileOutputStream(destpath);
			int value;
			int codeLength=0;
			String code="";
			//��ԭ���
			for (int i = 0; i < codelengths.length; i++) {
				value=fis.read();
				codelengths[i]=value;
//				System.out.println(times[i]);
				codeLength+=codelengths[i];
			}
			
			//�õ��ܳ���
			//���ܳ��ȳ���8�ĵ��ֽڸ���
			int len=codeLength/8;
			//�������8�ı��������ֽڸ�����1����Ӧѹ����0�������
			if((codeLength)%8!=0){
				len++;
			}

			for (int i = 0; i < len; i++) {
				//�Ѷ���������ת���ɶ�����
				code+=changeIntToString(fis.read());
				
			}
			
			for (int i = 0; i < codeMap.length; i++) {
				//�����i��λ�ò�Ϊ0 ����˵����i��λ�ô洢�й���������
				if(codelengths[i]!=0){
					//���õ���һ�����������밴�ճ��ȷָ�ָ�
					String ss=code.substring(0, codelengths[i]);
					codeMap[i]=ss;
					code=code.substring(codelengths[i]);
				}else{
					//Ϊ0��û�ж�Ӧ�Ĺ���������
					codeMap[i]="";
				}
			}
			
			//��ȡѹ�����ļ�����
			String codeContent="";
			while(fis.available()>1){
				codeContent+=changeIntToString(fis.read());
			}
			//��ȡ���һ��
			value = fis.read();
			//����󲹵�0��ȥ��
			codeContent=codeContent.substring(0, codeContent.length()-value);
			judge = true;	
			for (int i = 0; i < codeContent.length(); i++) {
				
				String codecontent=codeContent.substring(0, i+1);
				
				for (int j = 0; j < codeMap.length; j++) {
					if(codeMap[j].equals(codecontent)){
//						System.out.println("��ȡ���ַ�����"+codecontent);
						fos.write(j);
						fos.flush(); 
						codeContent=codeContent.substring(i+1);
//						System.out.println("��ȡ��ʣ����볤�ȣ�"+codeContent.length());
//						count=1;
						i=-1;
						break;
					}
			}
			}
//			}
			
			fos.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
 
	}
	
	//ʮ����ת�������ַ���
	public String changeIntToString(int value) {
		String s="";
		for (int i = 0; i < 8; i++) {
			s=value%2+s;
			value=value/2;
		}
		return s;
	}
 
}

