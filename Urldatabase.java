import java.util.*;

class URLDB{
    int key;
    String url;
    int count;
    
    URLDB(String url,int key,int count){
        this.key=key;
        this.url=url;
        this.count=count;
    }
}

public class Urldatabase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        String url;
        String key;
        
        int uid=1;
        
        ArrayList<URLDB> table = new ArrayList<>();
        
        do {
            System.out.println("Commands:");
            System.out.println("1. Store URL");
            System.out.println("2. Get");
            System.out.println("3. Count");
            System.out.println("4. List");
            System.out.println("5. Exit");
            
            choice = in.nextInt();
            
            switch(choice) {
                case 1: 
                    System.out.println("Enter the URL to be stored:");
                    url = in.next();
                    URLDB obj = new URLDB(url,uid++,0);
                    table.add(obj);
                    break;
                case 2: 
                    System.out.println("Enter the URL to get:");
                    url = in.next();
                    for(int i=0;i<table.size();i++) {
                        if(table.get(i).url.equals(url)) {
                            URLDB objUpdate = new URLDB(url,table.get(i).key,table.get(i).count+1);
                            System.out.println("Short Key:"+table.get(i).key);
                            table.remove(i);
                            table.add(objUpdate);   
                            break;
                        }
                    }
                    System.out.println("URL not found");
                    break;
                case 3: 
                    System.out.println("Enter the URL to count:");
                    url = in.next();
                    for(int i=0;i<table.size();i++) {
                        if(table.get(i).url.equals(url)) {
                            System.out.println("Usage Count:"+table.get(i).count);
                            break;      
                        }
                    }
                    System.out.println("URL not found");
                    break;
                case 4: 
                    if(table.size() < 0)
                        {
                            System.out.println("No existing Data");
                            break;
                        }
                    System.out.println("[");
                    for(int i=0;i<table.size();i++) {
                        System.out.println("  {");
                        System.out.println("    url:"+table.get(i).url+","); 
                        System.out.println("    count:"+table.get(i).count+",");
                        System.out.println("  },");
                    }
                    System.out.println("]");
                    break;
                case 5:
                    System.out.println("Terminating Application.......");
                    break;
                default : 
                    System.out.println("Wrong choice entered");
            }
            
        }while(choice!=5);
        
        System.out.println("App terminated!!!!!");
    }

}
