package hotel;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class hotel {
	
	public int floor = 5; //旅馆共5层
	public int [] total_room = {20,20,20,20,20}; //每层20个房间
	public int [] normal_single_room = {5,5,5,5,5}; //每层普通单间5间
	public int normal_single_price = 100; 
	public int [] normal_double_room = {5,5,5,5,5}; //每层普通标间5间
	public int normal_double_price = 180;
	public int [] good_single_room = {4,4,4,4,4}; //每层豪华单间4间
	public int good_single_price = 120; 
	public int [] good_double_room = {5,5,5,5,5}; //每层豪华标间5间
	public int good_double_price = 220; 
	public int [] triple_room = {1,1,1,1,1}; //每层三人间1间
	public int triple_room_price = 240; 
    public static boolean changeable = false;//判断是否为调剂
    public static String originLevelName = null;
    public static int originLevel ;
    public static int [] tognum = {0,0,0,0,0}; 
	/*空房0、脏房1、预定2、住人3、长包4、钟点房5 
	 *0-4普单 5-9普标 10-13豪单 14-18豪标 19三人 
	 */
	public int [][] state = new int [5][20]; 
	
	static void initialization(List roomQueue,int roomNumber,int days){
	  
	    for (int i=0;i<roomNumber;i++){
	        roomQueue.add(new ArrayDeque<Customer>(days));
	    }
	}
	
	static void daliyUpdate(List<ArrayDeque> roomQueue, int roomNumber) {
	    //房间Queue清空表头
	    for (int i = 0; i < roomNumber; i++) {
	        ArrayDeque temp = roomQueue.get(i);
	        temp.poll();
	    }
	}
	
	static boolean[][] rateTest(List<ArrayDeque> roomQueue, boolean rate[][] , int floor , int level ){
	    int size = 5;
	    int k = 0;
	    while(size>0){
	    	    k = 0;
	    	    if (level==1)
	    	    {
	    	    	    while ( k<=4 ) {
	    	    	       	if (roomQueue.get(20*(size-1)+k).peek()==null) {
		    	    	       	rate[size-1][k]=true;
		    	    	    }
	    	    	       	k++;
	    	    	    }
	    	    	  
	    	    }else if (level==2)
	    	    {   
	    	    	     k = 6;
	    	     	 while ( k<=9 ) {
	    	    	       	if (roomQueue.get(20*(size-1)+k).peek()==null) {
		    	    	       	rate[size-1][k]=true;
		    	    	    }
	    	    	       	k++;
	    	    	    }
    	    	    
	    	    }else if (level==3)
	    	    {   
	    	    	     k = 10;
	    	     	 while ( k<=13 ) {
	    	    	       	if (roomQueue.get(20*(size-1)+k).peek()==null) {
		    	    	       	rate[size-1][k]=true;
		    	    	    }
	    	    	       	k++;
	    	    	    }
	    	    }else if (level==4)
		    	 {   
		    	    	 k = 14;
		    	     while ( k<=18 ) {
		    	    	      if (roomQueue.get(20*(size-1)+k).peek()==null) {
			    	    	      rate[size-1][k]=true;
			    	    	  }
		    	    	     	k++;
		    	    	  }
		    	 }else
		    	 {   
		    	    	 k = 19;
		    	     while ( k<=19 ) {
		    	    	      if (roomQueue.get(20*(size-1)+k).peek()==null) {
			    	    	      rate[size-1][k]=true;
			    	    	  }
		    	    	     	k++;
		    	    	  }
	    	     }
	        size-- ;
	    }
	    return rate;
	}
	
	static boolean findRoom(Queue<Integer> avilableRoom,boolean[][] rate,int count,int level, int[] m){
	    int tempCount =0;
	    //   判断是否有住的地方,如果rate[level-1]没有的话，就住这里
	    for (int i =0;i<=4;i++)
	    {
	          int k = 0;
	          
	     	  if (level==1) {
	     		  while( k <= 4 ) {
	     			 if(rate[i][k]) {
	 		            m[0] = i;
	 		            avilableRoom.add(20*i+k);
	 		            tempCount++;
	 		        }
	     			 k++;
	         }
    	         }else if (level==2) {   
    	    	         k = 5;
    	     	     while ( k<=9 ) {
    	     	      	if(rate[i][k]) {
    	 		            m[0] = i;
    	 		            avilableRoom.add(20*i+k);
    	 		            tempCount++;
    	 		            }
    	    	       	k++;
    	    	       }
    	       }else if (level==3){   
    	    	         k = 10;
  	     	     while ( k<=13 ) {
  	     	      	if(rate[i][k]) {
  	 		            m[0] = i;
  	 		            avilableRoom.add(20*i+k);
  	 		            tempCount++;
  	 		            }
  	    	       	k++;
  	    	       }
    	    }else if (level==4){   
    	         	 k = 14;
  	     	     while ( k<=18 ) {
  	     	      	if(rate[i][k]) {
  	 		            m[0] = i;
  	 		            avilableRoom.add(20*i+k);
  	 		            tempCount++;
  	 		            }
  	    	       	k++;
  	    	       }
	    	 }else if (level==5)
	    	 {   
	    	    	 k = 19;
	    	     while ( k<=19 ) {
	    	      	 if(rate[i][k]) {
	  	 		     m[0] = i;
	  	 		     avilableRoom.add(20*i+k);
	  	 		     tempCount++;
	  	 		     }
	    	    	     	k++;
	    	    	  }
    	     }
  
	    }
	    if (tempCount>=count){
	        //满足条件，有count间房可住
	        return true;
	    }
	    return false;
	}
	
	static double reserve(List<ArrayDeque> roomQueue,Customer customer,int level1, int rateNumber,int[] price,JTextArea txt) {
	    Queue<Integer> avilableRoom = new ArrayDeque<Integer>();
	    boolean[][] rate = new boolean[rateNumber][20];
	    for (int i = 0; i < rateNumber; i++) {
	        for (int j=0;j<20;j++){
	            rate[i][j] = false;
	        }
	    }

	    int[] m = {4};
	    int tempRoomNumber = 101;
	    int floor = customer.floor;
	    int level = level1;
	    boolean vip = customer.vip;
	    int stayTime = customer.stayTime;
	    boolean change = customer.changable;
	    StringBuffer genders = new StringBuffer();
	    if ( customer.gender == 0) {
	      	genders.append("man");
	    }else {
	     	genders.append("woman");
	    }
	    	
	    rateTest(roomQueue,rate,floor,level);
        if (findRoom(avilableRoom,rate,1,level,m)){
            //找到了房间
            //房间号,默认取第一个
            tempRoomNumber = avilableRoom.poll();
	    }

        String floorName = null;
	    if (floor == 1) {
	        floorName = "1层";
	    } else if (floor == 2) {
	        floorName = "2层";
	    } else if(floor == 3) {
	      	floorName = "3层";
	    }else if (floor == 4){
	      	floorName = "4层";
	    }else if (floor == 5){
	    	    floorName = "5层";
	    }else{
	        floorName = "没有楼层";
	    }

	    String levelName = null;
	    if (level == 1) {
	        levelName = "普通单间";
	    } else if (level == 2) {
	        levelName = "普通标间";
	    } else if(level == 3) {
	        levelName = "豪华单间";
	    }else if(level == 4) {
	        levelName = "豪华标间";
	    }else if(level == 5) {
	        levelName = "三人间";
	    }
	    //房间号
	    
	    if (originLevel == 1) {
	    	originLevelName = "普通单间";
	    } else if (originLevel == 2) {
	    	originLevelName = "普通标间";
	    } else if(originLevel == 3) {
	    	originLevelName = "豪华单间";
	    }else if(originLevel == 4) {
	    	originLevelName = "豪华标间";
	    }else if(originLevel == 5) {
	    	originLevelName = "三人间";
	    }
	    int roomNumber = 0;
	    
	    if (level==1){
	    	    if (rate[floor-1][0]||rate[floor-1][1]||rate[floor-1][2]||rate[floor-1][3]||rate[floor-1][4]) {
	    	    	if (rate[floor-1][0]){
	    	    	    	    roomNumber = (floor-1)*20+0;
	    	    	    	    for (int k =0;k<stayTime;k++){
	    	    	                roomQueue.get(roomNumber).add(customer);
	    	    	            }
	    	    	            rate[floor - 1][0] = false;
	    	    	    } else if(rate[floor-1][1]) {
	    	    	      	roomNumber = (floor-1)*20+1;
    	    	    	        for (int k =0;k<stayTime;k++){
    	    	                roomQueue.get(roomNumber).add(customer);
    	    	            }
    	    	            rate[floor - 1][1] = false;
	    	    	    	    
	    	    	    } else if(rate[floor-1][2]) {
    	    	    	      	roomNumber = (floor-1)*20+2;
        	    	    	        for (int k =0;k<stayTime;k++){
        	    	                roomQueue.get(roomNumber).add(customer);
        	    	            }
        	    	            rate[floor - 1][2] = false;
    	    	    	    } else if(rate[floor-1][3]) {
    	    	    	      	roomNumber = (floor-1)*20+3;
    	    	    	        for (int k =0;k<stayTime;k++){
    	    	                roomQueue.get(roomNumber).add(customer);
    	    	            }
    	    	            rate[floor - 1][3] = false;
	    	    	    } else if(rate[floor-1][4]) {
	    	    	      	roomNumber = (floor-1)*20+4;
	    	    	        for (int k =0;k<stayTime;k++){
	    	                roomQueue.get(roomNumber).add(customer);
	    	            }
	    	            rate[floor - 1][4] = false;
    	    	    }
	    	    	if (vip) {
	    	    	     	if (roomNumber <=9) {
		    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"       " + genders +"     " + change + "        " + vip + "        "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
			    		    return price[level-1]*stayTime*0.8;
			    	    } else{
			    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"        "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
			    		    return price[level-1]*stayTime*0.8;
		    	          	}
	    	    		
	    	    	}else {
	    	    		if (roomNumber <=9) {
		    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"       " + genders + "     " + change + "        "  + vip +"      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
			    		    return price[level-1]*stayTime;
			    	    } else{
			    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName +"       " + genders +"     " + change + "        "  + vip + "      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
			    		    return price[level-1]*stayTime;
		    	          	}
	    	    	}
	    	   
	    	    }else {
	    	    	  
	    	    	 if (change){
	    	    		 //System.out.println("1");
	    	    		 changeable = true;
	    	    		 originLevel =customer.level;
	    	    		 reserve(roomQueue,customer,5,rateNumber,price,txt);
	    	    		 
	    	    	 }else {
	    	    	
	    	    		 txt.append("       "+ stayTime + " 天                                         " +genders +"     " + change + "         "+vip +"               很抱歉，暂无空余房间    " +"\r\n");
	    	        return 0;
	    	    	 }
	    	    }
	    }else if (level==2) {
	     	if (rate[floor-1][5]||rate[floor-1][6]||rate[floor-1][7]||rate[floor-1][8]||rate[floor-1][9]){
	    	    if (rate[floor-1][5]){
	    	    	    roomNumber = (floor-1)*20+5;
	    	    	    for (int k=5;k<stayTime;k++){
	    	                roomQueue.get(roomNumber).add(customer);
	    	            }
	    	            rate[floor - 1][5] = false;
	    	    } else if(rate[floor-1][6]) {
	    	      	roomNumber = (floor-1)*20+6;
    	    	        for (int k =0;k<stayTime;k++){
    	                roomQueue.get(roomNumber).add(customer);
    	            }
    	            rate[floor - 1][6] = false;
	    	    	    
	    	    } else if(rate[floor-1][7]) {
    	    	      	roomNumber = (floor-1)*20+7;
	    	    	        for (int k =0;k<stayTime;k++){
	    	                roomQueue.get(roomNumber).add(customer);
	    	            }
	    	            rate[floor - 1][7] = false;
    	    	    } else if(rate[floor-1][8]) {
    	    	      	roomNumber = (floor-1)*20+8;
    	    	        for (int k =0;k<stayTime;k++){
    	                roomQueue.get(roomNumber).add(customer);
    	            }
    	            rate[floor - 1][8] = false;
	    	    } else if(rate[floor-1][9]) {
	    	      	roomNumber = (floor-1)*20+9;
	    	        for (int k =0;k<stayTime;k++){
	                roomQueue.get(roomNumber).add(customer);
	            }
	            rate[floor - 1][9] = false;
    	        }
	    		if (vip) {
	    	     	if (roomNumber <=9) {
    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"       " + genders +"     " + change + "        " + vip + "       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
	    		    return price[level-1]*stayTime*0.8;
	    	    } else{
	    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
	    		    return price[level-1]*stayTime*0.8;
    	          	}
	    		
	    	}else {
	    		if (roomNumber <=9) {
    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"       " + genders + "     " + change + "        "  + vip +"      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
	    		    return price[level-1]*stayTime;
	    	    } else{
	    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName +"       " + genders +"     " + change + "        " + vip + "      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
	    		    return price[level-1]*stayTime;
    	          	}
	    	}
	   
	    }else {
	    	
	    	if (change){
	    		
	    		//System.out.println("2");
	    		changeable = true;
	    		originLevel =customer.level;
	    		 reserve(roomQueue,customer,5,rateNumber,price,txt);
	    		
	    	 }else {
	    	 
	    		 txt.append("       "+ stayTime + " 天                                         " +genders +"     " + change + "         "+vip +"               很抱歉，暂无空余房间    " +"\r\n");
	        return 0;
    	        }}
	        }else if (level==3) {
		     	if (rate[floor-1][10]||rate[floor-1][11]||rate[floor-1][12]||rate[floor-1][13]){
		    	    if (rate[floor-1][10]){
		    	    	    roomNumber = (floor-1)*20+10;
		    	    	    for (int k=5;k<stayTime;k++){
		    	                roomQueue.get(roomNumber).add(customer);
		    	            }
		    	            rate[floor - 1][10] = false;
		    	    } else if(rate[floor-1][11]) {
		    	      	roomNumber = (floor-1)*20+11;
	    	    	        for (int k =0;k<stayTime;k++){
	    	                roomQueue.get(roomNumber).add(customer);
	    	            }
	    	            rate[floor - 1][11] = false;
		    	    	    
		    	    } else if(rate[floor-1][12]) {
	    	    	      	roomNumber = (floor-1)*20+12;
		    	    	        for (int k =0;k<stayTime;k++){
		    	                roomQueue.get(roomNumber).add(customer);
		    	            }
		    	            rate[floor - 1][12] = false;
	    	    	    } else if(rate[floor-1][13]) {
	    	    	      	roomNumber = (floor-1)*20+13;
	    	    	        for (int k =0;k<stayTime;k++){
	    	                roomQueue.get(roomNumber).add(customer);
	    	            }
	    	            rate[floor - 1][13] = false;
		    	    }
		    		if (vip) {
    	    	     	if (roomNumber <=9) {
	    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"       " + genders +"     " + change + "        " + vip + "       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
		    		    return price[level-1]*stayTime*0.8;
		    	    } else{
		    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
		    		    return price[level-1]*stayTime*0.8;
	    	          	}
    	    		
    	    	}else {
    	    		if (roomNumber <=9) {
	    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"     " + genders + "     " + change + "        "  + vip +"      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
		    		    return price[level-1]*stayTime;
		    	    } else{
		    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName +"       " + genders +"     " + change + "        "  + vip + "      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
		    		    return price[level-1]*stayTime;
	    	          	}
    	    	}
    	   
    	    }else {
    	    	
    	    	if (change){
    	    		//System.out.println("3");
    	    		changeable = true;
    	    		originLevel =customer.level;
   	    		 reserve(roomQueue,customer,5,rateNumber,price,txt);
   	    		
   	    	 }else {
   	    	
   	    		txt.append("       "+ stayTime + " 天                                         " +genders +"     " + change + "         "+vip +"               很抱歉，暂无空余房间    " +"\r\n");
   	        return 0;}
	    	        }
		     	
	        }else if (level==4) {
		     	if (rate[floor-1][14]||rate[floor-1][15]||rate[floor-1][16]||rate[floor-1][17]||rate[floor-1][18]){
		    	    if (rate[floor-1][14]){
		    	    	    roomNumber = (floor-1)*20+14;
		    	    	    for (int k=5;k<stayTime;k++){
		    	                roomQueue.get(roomNumber).add(customer);
		    	            }
		    	            rate[floor - 1][14] = false;
		    	    } else if(rate[floor-1][15]) {
		    	      	roomNumber = (floor-1)*20+15;
	    	    	        for (int k =0;k<stayTime;k++){
	    	                roomQueue.get(roomNumber).add(customer);
	    	            }
	    	            rate[floor - 1][15] = false;
		    	    	    
		    	    } else if(rate[floor-1][16]) {
	    	    	      	roomNumber = (floor-1)*20+16;
		    	    	        for (int k =0;k<stayTime;k++){
		    	                roomQueue.get(roomNumber).add(customer);
		    	            }
		    	            rate[floor - 1][16] = false;
	    	    	    } else if(rate[floor-1][17]) {
	    	    	      	roomNumber = (floor-1)*20+17;
	    	    	        for (int k =0;k<stayTime;k++){
	    	                roomQueue.get(roomNumber).add(customer);
	    	            }
	    	            rate[floor - 1][17] = false;
		    	    } else if(rate[floor-1][18]) {
		    	      	roomNumber = (floor-1)*20+18;
		    	        for (int k =0;k<stayTime;k++){
		                roomQueue.get(roomNumber).add(customer);
		            }
		            rate[floor - 1][18] = false;
	    	        }
		    		if (vip) {
    	    	     	if (roomNumber <=9) {
	    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"       " + genders +"     " + change + "        " + vip + "       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
		    		    return price[level-1]*stayTime*0.8;
		    	    } else{
		    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
		    		    return price[level-1]*stayTime*0.8;
	    	          	}
    	    		
    	     	}else {
    	    		if (roomNumber <=9) {
	    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"      " + genders + "     " + change + "        "  + vip +"      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
		    		    return price[level-1]*stayTime;
		    	    } else{
		    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName +"       " + genders +"     " + change + "        "  + vip + "      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
		    		    return price[level-1]*stayTime;
	    	          	}
    	    	}
    	   
    	    }else {
    	    	
    	    	if (change){
    	    		changeable = true;
    	    		originLevel =customer.level;
   	    		 reserve(roomQueue,customer,5,rateNumber,price,txt);
   	    	 }else {
   	    	
   	    		txt.append("       "+ stayTime + " 天                                         " +genders +"     " + change + "         "+vip +"              很抱歉，暂无空余房间！    " +"\r\n");
   	        return 0;}
	    	        }
		     }else {//System.out.println("5");
		     //System.out.println(changeable);
		     
		  
		    	   if (rate[floor-1][19]) {
	    	    	    roomNumber = (floor-1)*20+19;
	    	    	    for (int k=5;k<stayTime;k++){
	    	                roomQueue.get(roomNumber).add(customer);
	    	            }
	    	    	    if (changeable){
					    	   tognum[floor-1] ++;
					    	   if ( tognum[floor-1] <=2 )
					    	   {
					    		   rate[floor - 1][19] = true;
					    	   }else {
					    	 rate[floor - 1][19] = false;
					     }
		    	 
		     }else {
		      	 tognum[floor-1]= 3;
		      	 rate[floor - 1][19] = false;
		     }
			    	            
			    	            if ( changeable)
			    	            {
			    	            	//System.out.println("5");
			    	            	if (vip) {
				    	    	     	if (roomNumber <=9) {
					    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"       " + genders +"     " + change + "        " + vip + "        "+originLevelName +"        "+levelName +"         "+price[level-1]/3+"        "+price[level-1]*stayTime/3*0.8+"\r\n");
						    		    return price[level-1]*stayTime*0.8;
						    	    } else{
						    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"        "+originLevelName +"        "+levelName +"         "+price[level-1]/3+"        "+price[level-1]*stayTime/3*0.8+"\r\n");
						    		    return price[level-1]*stayTime*0.8;
					    	          	}
				    	    		
				    	    	}else {
				    	    		if (roomNumber <=9) {
					    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"      " + genders + "     " + change +"        "  + vip +"       "+originLevelName +"        "+levelName +"         "+price[level-1]/3+"        "+price[level-1]*stayTime/3+"\r\n");
						    		    return price[level-1]*stayTime;
						    	    } else{
						    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName +"       " + genders +"     " + change + "        "  + vip + "       "+originLevelName +"        "+levelName +"         "+price[level-1]/3+"        "+price[level-1]*stayTime/3+"\r\n");
						    		    return price[level-1]*stayTime;
					    	          	}
				    	    	}
			    	            }else {
			    	            	if (vip) {
				    	    	     	if (roomNumber <=9) {
					    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"       " + genders +"     " + change + "        " + vip + "         "+levelName +"        "+levelName +"         "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
						    		    return price[level-1]*stayTime*0.8;
						    	    } else{
						    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"         "+levelName +"        "+levelName +"         "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
						    		    return price[level-1]*stayTime*0.8;
					    	          	}
				    	    		
				    	    	}else {
				    	    		if (roomNumber <=9) {
					    	    		txt.append("       "+ stayTime + " 天         " + roomNumber +" 号             "+ floorName +"      " + genders + "     " + change + "        "  + vip +"       "+levelName +"        "+levelName +"         "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
						    		    return price[level-1]*stayTime;
						    	    } else{
						    	    	txt.append("       "+ stayTime + " 天         " + roomNumber +" 号           "+ floorName +"       " + genders +"     " + change +"        "  + vip + "       "+levelName +"        "+levelName +"         "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
						    		    return price[level-1]*stayTime;
					    	          	}
				    	    	}
			    	            	
				    	   
				    	    }
			     	}else {
				    	    	
				    	     	txt.append("       "+ stayTime + " 天                                         " +genders +"     " + change + "         "+vip +"               很抱歉，暂无空余房间    " +"\r\n");
				    	        return 0;
				    	    }
			    	            	
			    	
	     	    
	        }
		return 0;
	}
	    

	
	
}