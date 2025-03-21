package unit09_27JavaInterlude08;

public class PairDriver {

    public static void main(String[] args) {
        
        // @author Frank M. Carrano, Timothy M. Henry
        // @version 5.0
        Name joe = new Name("Joe", "Java");
        String joePhone = "(401) 555-1234";
        Pair<Name, String> joeEntry = new Pair<>(joe, joePhone);
        System.out.println(joeEntry);
    }
    
}