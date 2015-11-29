////////////////////////////////////////////////////////////////////////////////
///////////////////////////product/////////////////////////////////////////////
package AlgorithmsTextMatching;

public class Product {
	private long id;
	private String Nameproduct;
	private int Key;
	private int fisrtKeyPos;
	private int minKwSpace;
        
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameProduct() {
		return Nameproduct;
	}
	public void setNameProduct(String Nameproduct) {
		this.Nameproduct = Nameproduct;
	}
	public int getKey() {
		return Key;
	}
	public void setKey(int Key) {
		this.Key = Key;
	}
	public int getFisrtKeyPos() {
		return fisrtKeyPos;
	}
	public void setFisrtKeyPos(int fisrtKeyPos) {
		this.fisrtKeyPos = fisrtKeyPos;
	}
	public int getMin() {
		return minKwSpace;
	}
	public void setMinKwSpace(int minKwSpace) {
		this.minKwSpace = minKwSpace;
	}
}

