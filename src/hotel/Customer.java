package hotel;

import java.util.Random;

public class Customer {
	
    public int level = 1; 
    public boolean changable = false; 
    public int stayTime ; 
    public int intertime ;
    public int floor ;
    public boolean vip;
    public int gender;
    
    public Customer(){
        Random rand = new Random();
      	this.level = rand.nextInt(5)+1;
      	this.stayTime =  rand.nextInt(8)+1;
      	this.intertime = rand.nextInt(5)+1;
      	this.floor = rand.nextInt(5)+1;
      	int index = rand.nextInt(9);
      	this.gender = rand.nextInt(1);
      	if ( index%2 == 0 ) {
      		vip =true;
      	}else {
      		vip =false;
      	}
      	int index2 = rand.nextInt(9);
      	if ( index2%2 == 0 ) {
      		changable =true;
      	}else {
      		changable =false;
      	}
      	
      	
      	
    }
    
    

}
