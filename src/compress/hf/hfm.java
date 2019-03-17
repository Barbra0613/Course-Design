package compress.hf;
 
 
/*
 * 哈夫曼节点类
 */
public class hfm {
	//数据域
	private int data;
	//索引
	private int index;
	//左子节点
	private hfm left;
	//右子节点
	private hfm right;
	
	//哈夫曼节点的构造函数
	public hfm(int data,int index){
		this.data=data;
		this.index=index;
	}
	
	//私有属性的封装
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

