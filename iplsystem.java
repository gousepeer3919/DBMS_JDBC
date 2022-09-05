import java.util.* ;

public class iplsystem{

    public static void instructions(){
        System.out.println("Please select one of the following options:");
        System.out.println("1, to add a new team to the teams.");
        System.out.println("2, to remove a team from the teams.");
        System.out.println("3, to sell a team.");
        System.out.println("4, to buy a team");
        System.out.println("5, to update a team ");
        System.out.println("6, exit.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        ipl_JDBC db = new ipl_JDBC();

        db.Initialize();

        instructions();

        int option = sc.nextInt();
        while(option != 6){
            switch(option){
                case 1: 
                    db.addteam();
                    break ;
                case 2: 
                    db.deleteteam();
                    break ;
                case 3: 
                    db.sellteam();
                    break;    
                case 4:
                    db.buyteam();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
                    break;
            }
            instructions();
            option = sc.nextInt();
        }
        db.uninitialize();

    }


}    
    

