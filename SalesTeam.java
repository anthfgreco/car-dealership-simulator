/*
Anthony Greco
500903364
*/
import java.util.*;

public class SalesTeam{
    LinkedList<String> salesMembers;

    /**
     * Constructs a default sales team object.
     * Initializes salesMembers linked list and adds six names to it.
     */
    public SalesTeam(){
        this.salesMembers = new LinkedList<String>();
        salesMembers.add("Anthony");
        salesMembers.add("Luisa");
        salesMembers.add("Matthew");
        salesMembers.add("Nicole");
        salesMembers.add("Sebastian");
        salesMembers.add("Hanson");
    }
    /**
     * Returns a random sales member from the salesMembers linked list.
     * @return salesMember at index r where r is a random integer between 0 and 5
     */
    public String randomMember(){
        Random r = new Random();
        int randomIndex = r.nextInt(6);
        return salesMembers.get(randomIndex);
    }
    /**
     * Displays the sales team object in string format.
     * @return memberString which is a string that holds all the names in the salesMembers linked list
     */
    public String display(){
        String memberString = "Team:";
        ListIterator<String> iterator = salesMembers.listIterator();
        while (iterator.hasNext()){
            memberString += " " + iterator.next();
        }
        return "\n" + memberString + "\n";
    }
}