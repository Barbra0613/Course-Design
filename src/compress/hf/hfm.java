package compress.hf;
 
 
/*
 * �������ڵ���
 */
public class hfm {
	//������
	private int data;
	//����
	private int index;
	//���ӽڵ�
	private hfm left;
	//���ӽڵ�
	private hfm right;
	
	//�������ڵ�Ĺ��캯��
	public hfm(int data,int index){
		this.data=data;
		this.index=index;
	}
	
	//˽�����Եķ�װ
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public hfm getLeft() {
		return left;
	}
	public void setLeft(hfm left) {
		this.left = left;
	}
	public hfm getRight() {
		return right;
	}
	public void setRight(hfm right) {
		this.right = right;
	}
 
}

