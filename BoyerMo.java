////////////////////////////////////////////////////////////////////////////////
////////////////////////////// Algorithms boyer////////////////////////////////
package AlgorithmsTextMatching;
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.StringTokenizer;

public class BoyerMo {
    private List<Product> matchedList = new ArrayList<>();
    private String input;
    private int maxMinKwSpace = 0;
    private int maxFirstKeyPos = 0;
    private int maxKeyword = 0;
    private String keywords;
    private int firstPos;
    private int lastPos;
    //////////////////////////////////////////////////////////////////////////    
    public BoyerMo(String input) {
        this.matchedList.clear();
        this.input = input;
        try {
            this.matchedList = this.getProduct(this.input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    BoyerMo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    private List<Product> getProduct(String input) throws FileNotFoundException {
        String NameProduct;
        int i = 1;
        try {
            File f = new File("E:\\อังกอลิทึม\\product.txt");//ใส่ที่อยู่ file product.txt
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            while ((NameProduct = bf.readLine()) != null) {
                Product product = new Product();
                product = getMatched(input, NameProduct);
                if (product != null) {
                    product.setId(i);
                    matchedList.add(product);
                }
                i++;
            }

        } catch (Exception e) {

        }     
        return matchedList;
    }

    private Product getMatched(String input, String Nameproduct) {
        ArrayL n = new ArrayL();
        int pIndex = 0;
        int cIndex = 0;
        int keyIndex = 0;
        int startIndex = 0;
        int i = 0;
        int jump = 0;
        int Key = 0;
        int firstKeyPos = -1;
        int minKwSpace = -1;
        StringTokenizer str = new StringTokenizer(input);
        String word = "";

        Product productMatched = new Product();
        maxKeyword = str.countTokens();

        while (str.hasMoreTokens()) {
            word = str.nextToken();
            if (word.length() <= Nameproduct.length()) {
                cIndex = word.length() - 1;
                pIndex = cIndex;
                startIndex = cIndex;
                while (startIndex < Nameproduct.length()) {
                    pIndex = startIndex;
                    cIndex = word.length() - 1;
                    i = cIndex;
                    jump = 0;
                    boolean isMatch = true;

                    while (i > -1) {
                        if (word.toLowerCase().charAt(cIndex) == Nameproduct.toLowerCase().charAt(pIndex)) {
                            cIndex--;
                            pIndex--;
                            if (isMatch == false) {
                                break;
                            }
                        } else {
                            isMatch = false;
                            cIndex--;
                            jump++;
                        }

                        i--;
                    }
                    if (isMatch) {
                        Key += 1;
                        ArrayL x = new ArrayL();
                        setFirstPos(pIndex + 1);
                        setLastPos(startIndex);
                        setKeyword(word);
                        if (Key > 1) {
                            minKwSpace = getMinSpace((List<ArrayL>) x);
                        }
                        if (minKwSpace > maxMinKwSpace) {
                            maxMinKwSpace = minKwSpace;
                        }

                        if (keyIndex == 0) {
                            firstKeyPos = pIndex + 1;
                        } else if (firstKeyPos == -1) {
                            firstKeyPos = pIndex + 1;
                        }
                        if (firstKeyPos > maxFirstKeyPos) {
                            maxFirstKeyPos = firstKeyPos;
                        }

                        break;

                    } else {
                        startIndex += jump;
                    }
                    keyIndex += 1;
                }
            }
        }
        if (Key == 0) {
            return null;
        } else {
            productMatched = new Product();
            productMatched.setKey(Key);
            productMatched.setNameProduct(Nameproduct);
            productMatched.setMinKwSpace(minKwSpace);
            productMatched.setFisrtKeyPos(firstKeyPos);
        }

        return productMatched;
    }

    private int getMinSpace(List<ArrayL> list) {
        int minSpace = 10000;
        int space = 0;
        int i, j;
        for (i = 0; i < list.size(); i++) {
            for (j = i + 1; j < list.size(); j++) {
                ArrayL obj1 = new ArrayL();
                ArrayL obj2 = new ArrayL();
                obj1 = list.get(i);
                obj2 = list.get(j);

                if (getFirstPos() < getFirstPos()) {
                    space = getFirstPos() - getFirstPos();
                } else {
                    space = getFirstPos() - getFirstPos();
                }

                if (space < minSpace) {
                    minSpace = space;
                }
            }
        }

        return minSpace;
    }

    public void PrintOutput() {

        for (int i = 0; i < this.matchedList.size(); i++) {

            Product matched = new Product();
            matched = matchedList.get(i);
            System.out.print(matched.getId());
            System.out.print(" " + matched.getNameProduct());

            System.out.println();

        }

    }
    	public String getKeyword() {
		return keywords;
	}
	public void setKeyword(String input) {
		this.keywords = input;
	}
	public int getFirstPos() {
		return firstPos;
	}
	public void setFirstPos(int firstPos) {
		this.firstPos = firstPos;
	}
	public int getLastPos() {
		return lastPos;
	}
	public void setLastPos(int lastPos) {
		this.lastPos = lastPos;
	}
}
