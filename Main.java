import java.util.*;
class Theatre{
   static Boolean[] totalSeats=new Boolean[50];
    
        synchronized void bookSeat(String name ,int seatNumber){
            try{
            Thread.sleep(2000);
            }
            catch(InterruptedException e)
            {
                
            }
        if(totalSeats[seatNumber]==null){
            totalSeats[seatNumber]=true;
            System.out.println("Seat Conformed for "+name+" with Seat No : "+seatNumber);
        }
        else{
            System.out.println("Booking Failed for "+name);
    System.out.println("Sorry, seat "+seatNumber+" has already booked by someone else!");
        }
    }
    static synchronized int availableSeats()
    {
        int count=0;
        for(int i=0;i<50;i++){
            if(totalSeats[i]==null){
                count++;
            }
        }
        return count;
    }
}
class UserThread extends Thread{
    Theatre theatre;
    String name;
    int seatNumber;
    UserThread(String name,int seatNumber,Theatre theatre)
    {
        this.name=name;
        this.seatNumber=seatNumber;
        this.theatre=theatre;
    }
   public void run(){
        theatre.bookSeat(name,seatNumber);
   }
}
class Main {
    public static void main(String[] args) {
        boolean b=true;
        Scanner sc=new Scanner(System.in);
        Theatre commonTheatre=new Theatre();
        System.out.println("BOOK MY SHOW - MULTIPLEX");
        while(b)
        {
            System.out.println("1.View Number of Seats Available.");
            System.out.println("2.Book a seat(Singular)");
            System.out.println("3.Simulate Concurrent Booking(Clash)");
            System.out.println("4.Exit");
            System.out.print("Enter your choice(1-4) : ");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
             case 1:
                 System.out.println("Available seats are "+Theatre.availableSeats()+".");
                    break;
             case 2:
                    System.out.print("Enter your name : ");
                    String name=sc.nextLine(); 
                    System.out.print("Enter the seat Number(1-50) : ");
                    int seatNumber=sc.nextInt();
                    sc.nextLine();
                    Theatre obj=new Theatre();
                    obj.bookSeat(name,seatNumber);
                    break;
             case 3:
                    System.out.print("Enter User 1 name : ");
                    String u1name=sc.nextLine();
                    System.out.print("Enter User 1 seat Number(1-50) : ");
                    int u1seatNumber=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User 2 name : ");
                    String u2name=sc.nextLine();
                    System.out.print("Enter User 2 seat Number(1-50) : ");
                    int u2seatNumber=sc.nextInt();
                    sc.nextLine();
                    UserThread t1=new UserThread(u1name,u1seatNumber,commonTheatre);
                    UserThread t2=new UserThread(u2name,u2seatNumber,commonTheatre);
                    try{
                    t1.start();
                    System.out.println("["+u2name+" waiting for Lock...]");
                    t2.sleep(1000);
                    t2.start();
                    t1.join();
                    t2.join();
                    }
                    catch(InterruptedException e)
                    {
                        
                    }
                    break;
             case 4:
                    System.out.println("Thank you...");
                    b=false;
                    break;
                    
            }
        }
    }
}
