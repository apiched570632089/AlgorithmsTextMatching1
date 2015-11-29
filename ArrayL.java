////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////ReadText And Spilt///////////////////////////
package AlgorithmsTextMatching;
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileReader;
    import java.util.ArrayList;
    import java.util.List;
    import javax.swing.JOptionPane;

public class ArrayL {
    private char[][] map;
    private ArrayList<String> order = new ArrayList<>();
    private int max = 0;
    public void setArrayL(String x) {
        File file = new File(x);
        if (!file.exists()) {
            System.out.println("Not Found");
            return;
        }
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String readline = br.readLine();

            while (readline != null) {
                order.add(readline);
                readline = br.readLine();
            }
//            System.out.println("แสดงผลarraylist");
            for (int r = 0; r < order.size(); r++) {
//              System.out.println(order.get(r) + "");
            }
            System.out.println("");
            split(order);
            br.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
              BoyerMo m = new BoyerMo();
        }
    }

    void split(ArrayList<String> x) {
//        System.out.println("method split");
        map = new char[x.size()][];
        int b = 0, t = 0;

        for (int z = 0; z < x.size(); z++) {
            String row = x.get(z).toUpperCase();
            if (max < row.length()) {
                max = row.length();
            }
            map[z] = new char[row.length()];
            for (int a = 0; a < row.length(); a++) {
                map[z][a] = row.charAt(a);
//                System.out.print(a + " : " + map[z][a] + " ");
                t++;
            }
//            System.out.println("");
//            System.out.println(map[z].length);
        }
//        System.out.println(x.size());
//        System.out.println(max);
    }
}

 