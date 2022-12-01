public class SalesTeam {
    String[] salesMembers = { "Anthony", "Nick", "John", "Michael", "James", "David", "Samantha", "Matthew", "Nicole",
            "Sebastian", "Hanson",
    };

    /**
     * Returns a random sales member from the salesMembers linked list.
     * 
     * @return salesMember at index r where r is a random integer between 0 and 5
     */
    public String randomMember() {
        int index = (int) (Math.random() * salesMembers.length);
        return salesMembers[index];
    }

    /**
     * Displays the sales team object in string format.
     * 
     * @return memberString which is a string that holds all the names in the
     *         salesMembers linked list
     */
    public String display() {
        String memberString = "\nTeam:\n";
        int i = 1;

        for (String member : salesMembers) {
            memberString += i + ".\t" + member + "\n";
            i += 1;
        }

        return memberString;
    }
}