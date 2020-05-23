package dataMining.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws IOException {

        File file = new File("src/dataMining/task2/transactions.csv");
        Scanner sc = new Scanner(file);
        ArrayList<String> prod_code = new ArrayList<>();
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            prod_code.add(s.substring(0, s.indexOf(";")));
        }
        Collections.sort(prod_code);
        Map<String, Integer> resultData = new Map<String, Integer>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Integer get(Object key) {
                return null;
            }

            @Override
            public Integer put(String key, Integer value) {
                return null;
            }

            @Override
            public Integer remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends Integer> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<Integer> values() {
                return null;
            }

            @Override
            public Set<Entry<String, Integer>> entrySet() {
                return null;
            }
        };
        FileWriter fileWriter = new FileWriter("src/dataMining/task2/resultData.csv", false);

        int lastInd = -1;
        for (int i = 0; i <prod_code.size()-1; i++){

            if(!prod_code.get(i).equals(prod_code.get(i+1))){
                fileWriter.write(prod_code.get(i) + ";" + (i-lastInd)+"\n");
                resultData.put(prod_code.get(i), i - lastInd);
                lastInd = i;
            }
        }




    }
}
