package hotel;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class hotel {
	
	public int floor = 5; //�ùݹ�5��
	public int [] total_room = {20,20,20,20,20}; //ÿ��20������
	public int [] normal_single_room = {5,5,5,5,5}; //ÿ����ͨ����5��
	public int normal_single_price = 100; 
	public int [] normal_double_room = {5,5,5,5,5}; //ÿ����ͨ���5��
	public int normal_double_price = 180;
	public int [] good_single_room = {4,4,4,4,4}; //ÿ���������4��
	public int good_single_price = 120; 
	public int [] good_double_room = {5,5,5,5,5}; //ÿ��������5��
	public int good_double_price = 220; 
	public int [] triple_room = {1,1,1,1,1}; //ÿ�����˼�1��
	public int triple_room_price = 240; 
    public static boolean changeable = false;//�ж��Ƿ�Ϊ����
    public static String originLevelName = null;
    public static int originLevel ;
    public static int [] tognum = {0,0,0,0,0}; 
	/*�շ�0���෿1��Ԥ��2��ס��3������4���ӵ㷿5 
	 *0-4�յ� 5-9�ձ� 10-13���� 14-18���� 19���� 
	 */
	public int [][] state = new int [5][20]; 
	
	static void initialization(List roomQueue,int roomNumber,int days){
	  
	    for (int i=0;i<roomNumber;i++){
	        roomQueue.add(new ArrayDeque<Customer>(days));
	    }
	}
	
	static void daliyUpdate(List<ArrayDeque> roomQueue, int roomNumber) {
	    //����Queue��ձ�ͷ
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
	    //   �ж��Ƿ���ס�ĵط�,���rate[level-1]û�еĻ�����ס����
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
	        //������������count�䷿��ס
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
            //�ҵ��˷���
            //�����,Ĭ��ȡ��һ��
            tempRoomNumber = avilableRoom.poll();
	    }

        String floorName = null;
	    if (floor == 1) {
	        floorName = "1��";
	    } else if (floor == 2) {
	        floorName = "2��";
	    } else if(floor == 3) {
	      	floorName = "3��";
	    }else if (floor == 4){
	      	floorName = "4��";
	    }else if (floor == 5){
	    	    floorName = "5��";
	    }else{
	        floorName = "û��¥��";
	    }

	    String levelName = null;
	    if (level == 1) {
	        levelName = "��ͨ����";
	    } else if (level == 2) {
	        levelName = "��ͨ���";
	    } else if(level == 3) {
	        levelName = "��������";
	    }else if(level == 4) {
	        levelName = "�������";
	    }else if(level == 5) {
	        levelName = "���˼�";
	    }
	    //�����
	    
	    if (originLevel == 1) {
	    	originLevelName = "��ͨ����";
	    } else if (originLevel == 2) {
	    	originLevelName = "��ͨ���";
	    } else if(originLevel == 3) {
	    	originLevelName = "��������";
	    }else if(originLevel == 4) {
	    	originLevelName = "�������";
	    }else if(originLevel == 5) {
	    	originLevelName = "���˼�";
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
		    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"       " + genders +"     " + change + "        " + vip + "        "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
			    		    return price[level-1]*stayTime*0.8;
			    	    } else{
			    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"        "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
			    		    return price[level-1]*stayTime*0.8;
		    	          	}
	    	    		
	    	    	}else {
	    	    		if (roomNumber <=9) {
		    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"       " + genders + "     " + change + "        "  + vip +"      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
			    		    return price[level-1]*stayTime;
			    	    } else{
			    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName +"       " + genders +"     " + change + "        "  + vip + "      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
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
	    	    	
	    	    		 txt.append("       "+ stayTime + " ��                                         " +genders +"     " + change + "         "+vip +"               �ܱ�Ǹ�����޿��෿��    " +"\r\n");
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
    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"       " + genders +"     " + change + "        " + vip + "       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
	    		    return price[level-1]*stayTime*0.8;
	    	    } else{
	    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
	    		    return price[level-1]*stayTime*0.8;
    	          	}
	    		
	    	}else {
	    		if (roomNumber <=9) {
    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"       " + genders + "     " + change + "        "  + vip +"      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
	    		    return price[level-1]*stayTime;
	    	    } else{
	    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName +"       " + genders +"     " + change + "        " + vip + "      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
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
	    	 
	    		 txt.append("       "+ stayTime + " ��                                         " +genders +"     " + change + "         "+vip +"               �ܱ�Ǹ�����޿��෿��    " +"\r\n");
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
	    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"       " + genders +"     " + change + "        " + vip + "       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
		    		    return price[level-1]*stayTime*0.8;
		    	    } else{
		    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
		    		    return price[level-1]*stayTime*0.8;
	    	          	}
    	    		
    	    	}else {
    	    		if (roomNumber <=9) {
	    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"     " + genders + "     " + change + "        "  + vip +"      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
		    		    return price[level-1]*stayTime;
		    	    } else{
		    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName +"       " + genders +"     " + change + "        "  + vip + "      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
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
   	    	
   	    		txt.append("       "+ stayTime + " ��                                         " +genders +"     " + change + "         "+vip +"               �ܱ�Ǹ�����޿��෿��    " +"\r\n");
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
	    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"       " + genders +"     " + change + "        " + vip + "       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
		    		    return price[level-1]*stayTime*0.8;
		    	    } else{
		    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"       "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
		    		    return price[level-1]*stayTime*0.8;
	    	          	}
    	    		
    	     	}else {
    	    		if (roomNumber <=9) {
	    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"      " + genders + "     " + change + "        "  + vip +"      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
		    		    return price[level-1]*stayTime;
		    	    } else{
		    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName +"       " + genders +"     " + change + "        "  + vip + "      "+levelName +"      "+levelName +"      "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
		    		    return price[level-1]*stayTime;
	    	          	}
    	    	}
    	   
    	    }else {
    	    	
    	    	if (change){
    	    		changeable = true;
    	    		originLevel =customer.level;
   	    		 reserve(roomQueue,customer,5,rateNumber,price,txt);
   	    	 }else {
   	    	
   	    		txt.append("       "+ stayTime + " ��                                         " +genders +"     " + change + "         "+vip +"              �ܱ�Ǹ�����޿��෿�䣡    " +"\r\n");
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
					    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"       " + genders +"     " + change + "        " + vip + "        "+originLevelName +"        "+levelName +"         "+price[level-1]/3+"        "+price[level-1]*stayTime/3*0.8+"\r\n");
						    		    return price[level-1]*stayTime*0.8;
						    	    } else{
						    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"        "+originLevelName +"        "+levelName +"         "+price[level-1]/3+"        "+price[level-1]*stayTime/3*0.8+"\r\n");
						    		    return price[level-1]*stayTime*0.8;
					    	          	}
				    	    		
				    	    	}else {
				    	    		if (roomNumber <=9) {
					    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"      " + genders + "     " + change +"        "  + vip +"       "+originLevelName +"        "+levelName +"         "+price[level-1]/3+"        "+price[level-1]*stayTime/3+"\r\n");
						    		    return price[level-1]*stayTime;
						    	    } else{
						    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName +"       " + genders +"     " + change + "        "  + vip + "       "+originLevelName +"        "+levelName +"         "+price[level-1]/3+"        "+price[level-1]*stayTime/3+"\r\n");
						    		    return price[level-1]*stayTime;
					    	          	}
				    	    	}
			    	            }else {
			    	            	if (vip) {
				    	    	     	if (roomNumber <=9) {
					    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"       " + genders +"     " + change + "        " + vip + "         "+levelName +"        "+levelName +"         "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
						    		    return price[level-1]*stayTime*0.8;
						    	    } else{
						    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName + "       " + genders + "     " + change + "        "+ vip +"         "+levelName +"        "+levelName +"         "+price[level-1]+"        "+price[level-1]*stayTime*0.8+"\r\n");
						    		    return price[level-1]*stayTime*0.8;
					    	          	}
				    	    		
				    	    	}else {
				    	    		if (roomNumber <=9) {
					    	    		txt.append("       "+ stayTime + " ��         " + roomNumber +" ��             "+ floorName +"      " + genders + "     " + change + "        "  + vip +"       "+levelName +"        "+levelName +"         "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
						    		    return price[level-1]*stayTime;
						    	    } else{
						    	    	txt.append("       "+ stayTime + " ��         " + roomNumber +" ��           "+ floorName +"       " + genders +"     " + change +"        "  + vip + "       "+levelName +"        "+levelName +"         "+price[level-1]+"        "+price[level-1]*stayTime+"\r\n");
						    		    return price[level-1]*stayTime;
					    	          	}
				    	    	}
			    	            	
				    	   
				    	    }
			     	}else {
				    	    	
				    	     	txt.append("       "+ stayTime + " ��                                         " +genders +"     " + change + "         "+vip +"               �ܱ�Ǹ�����޿��෿��    " +"\r\n");
				    	        return 0;
				    	    }
			    	            	
			    	
	     	    
	        }
		return 0;
	}
	    

	
	
}