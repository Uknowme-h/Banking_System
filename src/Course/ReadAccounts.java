package Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAccounts {
	List<String> firstNames = new ArrayList<>();
    List<String> lastNames = new ArrayList<>();
    List<Integer> accountList = new ArrayList<>();
    List<Integer> balanceList = new ArrayList<>();

    ReadAccounts(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                firstNames.add(values[0]);
                lastNames.add(values[1]);
                accountList.add(Integer.parseInt(values[2]));
                balanceList.add((int)Double.parseDouble(values[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    List<String> getFirstNames(){
		return firstNames;
    }
    
    List<String> getLastNames(){
		return lastNames;
    }
    List<Integer> getAccounts(){
		return accountList;
    }
    List<Integer> getBalance(){
		return balanceList;
    }
}
