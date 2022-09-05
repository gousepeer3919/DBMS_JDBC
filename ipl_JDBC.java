//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ipl_JDBC {
//STEP 2a: Set JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/ipldb";

   //  Database credentials
   static final String USER = "gouse";
   static final String PASS = "adminadmin";
   
   Connection conn = null;
   Statement stmt = null;
   Statement updt = null;
   static Scanner sc = new Scanner(System.in); 

    public void Initialize(){
        try{
            //STEP 2b: Register JDBC driver
            Class.forName(JDBC_DRIVER);            
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);            
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement(); 
            updt = conn.createStatement(); 
            System.out.println("#######DONE####"); 
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void uninitialize(){
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se2){
        }// nothing we can do
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

    public void addteam(){
        System.out.println("team_name ");
        String teamname = sc.nextLine();

        System.out.println("jersey_colour ");
        String jerseycolour = sc.nextLine();

        System.out.println("no_of_indianplayers ");
        int noofindplayers = sc.nextInt();

        System.out.println("no_of_foriegnplayers ");
        int noofforiegnplayers = sc.nextInt();        

        System.out.println("no_of_cups");
        int noofcups = sc.nextInt();

        System.out.println("Please enter you owner id to authenticate.");
        int o_id = sc.nextInt();

        try{
            String sql, auth_sql;
            sql = "insert into team values (\""+ teamname + "\""+",\"" + jerseycolour +"\""+"," + noofindplayers +","+ noofforiegnplayers+","+ noofcups+")"+";";
            System.out.println(sql);
            auth_sql = "select owner_ID from owner"+";";
            ResultSet rs = stmt.executeQuery(auth_sql);
            while(rs.next()){
                //Retrieve by column name
                int owner_id  = rs.getInt("owner_ID");
                if(owner_id == o_id){
                    System.out.println(auth_sql);
                    updt.executeUpdate(sql);
                }

                else{
                    System.out.println("Authentication failed");
                }
            }
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            System.out.println("de");
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    
    public void deleteteam(){
        System.out.println("team_name ");
        String teamname = sc.nextLine();

        System.out.println("Please enter your owner id to authenticate.");
        int o_id = sc.nextInt();


        try{
            String sql,auth_sql;
            sql = "delete from team where team_name = \"" + teamname + "\";";
            auth_sql = "select owner_ID from owner"+";";
            System.out.println(auth_sql);
            ResultSet rs = stmt.executeQuery(auth_sql);
            while(rs.next()){
                //Retrieve by column name
                int owner_id  = rs.getInt("owner_ID");
                if(owner_id == o_id){
                    System.out.println(auth_sql);
                    updt.executeUpdate(sql);
                }

                else{
                    System.out.println("Authentication failed");
                }
            }
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void sellteam(){
        System.out.println("team_name ");
        String teamname = sc.nextLine();

        System.out.println("jersey_colour ");
        String jerseycolour = sc.nextLine();

        System.out.println("no_of_indianplayers ");
        int noofindplayers = sc.nextInt();

        System.out.println("no_of_foriegnplayers ");
        int noofforiegnplayers = sc.nextInt();        

        System.out.println("no_of_cups");
        int noofcups = sc.nextInt();

        System.out.println("Please enter you sponsor id to authenticate.");
        int s_id = sc.nextInt();

        try{
            String sql, auth_sql;
            sql = "insert into team values (\""+ teamname + "\""+",\"" + jerseycolour +"\""+"," + noofindplayers +","+ noofforiegnplayers+","+ noofcups+")"+";";
            System.out.println(sql);
            auth_sql = "select sponsor_ID from sponsor"+";";
            ResultSet rs = stmt.executeQuery(auth_sql);
            while(rs.next()){
                //Retrieve by column name
                int owner_id  = rs.getInt("sponsor_ID");
                if(owner_id == s_id){
                    System.out.println(auth_sql);
                    updt.executeUpdate(sql);
                }

                else{
                    System.out.println("Authentication failed");
                }
            }
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            System.out.println("de");
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }


    }


    public void buyteam(){
        System.out.println("team name ");
        String name = sc.nextLine();

        System.out.println("Please enter your sponsor id.");
        int s_id = sc.nextInt();

        try{
            String sql, auth_sql;
            sql = "update team set sponsor_id = "+s_id+" where team_name = "+name +";";
            auth_sql = "select sponsor_ID from sponsor where sponsor_ID = "+s_id+";";
            System.out.println(auth_sql);
            ResultSet rs = stmt.executeQuery(auth_sql);
            
            while(rs.next()){
                int sponsor_id  = rs.getInt("sponsor_ID");
                if(sponsor_id == s_id){
                    System.out.println(auth_sql);
                    updt.executeUpdate(sql);
                }

                else{
                    System.out.println("Authentication failed");
                }
            }
        }
        catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }


    
}