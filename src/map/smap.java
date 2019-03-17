package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JTextArea;


public class smap {
    private static final int Infinite = 50000;
    private static final int N = 35;
    private static Map<Integer, String> map = new HashMap<>();
    private static Map<String, String> roadMap = new HashMap<>();
    private static Scanner cin = new Scanner(System.in);
    private static int[][] cost = new int[N][N];
    private static int[][] shortest = new int[N][N];
    private static int[][] path = new int[N][N];
    private static String[][] roads=new String[N][N];

    public static void Motor(int i,int j,JTextArea textArea) {
        start();
        cost[9][13] = cost[13][9] = cost[9][15] = cost[15][9] = cost[3][15] = cost[15][3] = cost[3][16] = cost[16][3] = cost[3][17] = cost[17][3] = cost[14][22] = cost[22][14] = cost[16][22] = cost[22][16] = cost[15][24] = cost[24][15] = cost[16][24] = cost[24][16] = Infinite;
        Floyed();
        show(i, j, path[i][j],textArea);
        textArea.append(map.get(i+1)+"\r\n"+"最短路径总长为："+shortest[i][j]+"\r\n"+"机动车导航完成"+"\r\n");
    }

    public static void Bicycle(int i ,int j,JTextArea textArea) {
        
    	    start();
        cost[9][13] = cost[13][9] = 294;
        cost[9][15] = cost[15][9] = 358;
        cost[3][15] = cost[15][3] = 417;
        cost[3][16] = cost[16][3] = 442;
        cost[3][17] = cost[17][3] = 306;
        cost[14][22] = cost[22][14] = 179;
        cost[16][22] = cost[22][16] = 364;
        cost[15][24] = cost[24][15] = 345;
        cost[16][24] = cost[24][16] = 182;
        Floyed();

        show(i, j, path[i][j],textArea);
        textArea.append(map.get(i+1)+"\r\n"+"最短路径总长为："+shortest[i][j]+"\r\n"+"自行车/行人导航完成"+"\r\n");
    }

    private static void Floyed() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                shortest[i][j] = cost[i][j];
                path[i][j] = 0;
            }
        }
        for (int k = 1; k < N; k++) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (shortest[i][j] > (shortest[i][k] + shortest[k][j])) {
                        shortest[j][i] = shortest[i][j] = shortest[i][k] + shortest[k][j];
                        path[i][j] = k;
                        path[j][i] = k;
                    }
                }
            }
        }
    }

    private static void show(int i, int j, int k,JTextArea textArea) {
        if (k == 0) {
         	textArea.append(map.get(i) + "  —行至— " + map.get(j) + " —行至— ");
            return;
        }
        if (path[i][k] == 0 && path[k][j] == 0) {
         	textArea.append(map.get(i) + " —行至— " + map.get(k) + " —行至— " + map.get(j) + " —行至— ");
            return;
        }
        if (path[i][k] == 0 && path[k][j] != 0) {
         	textArea.append(map.get(i) + " —行至— ");
            show(k, j, path[k][j],textArea);
            return;
        }
        if (path[i][k] != 0 && path[k][j] == 0) {
            show(i, k, path[i][k],textArea);
            textArea.append(map.get(j) + " —行至— ");
            return;

        }
        if (path[i][k] != 0 && path[k][j] != 0) {
            show(i, k, path[i][k],textArea);
            show(k, j, path[k][j],textArea);
        }

    }


    public static void start() {
       

    	     map.put(1, "校医院");
         map.put(2, "青园餐厅");
         map.put(3, "第50教学楼—化工");
         map.put(4, "综合体育馆");
         map.put(5, "体育场");
         map.put(6, "留园餐厅");
         map.put(7, "化工材料教学组团");
         map.put(8, "梅园餐厅");
         map.put(9, "第55教学楼—计软");
         map.put(10, "第31教学楼—材料");
         map.put(11, "棠园餐厅");
         map.put(12, "桃园餐厅");
         map.put(13, "郑东图书馆");
         map.put(14, "第44教学楼—公共");
         map.put(15, "第45教学楼—公共");
         map.put(16, "第47教学楼—实验");
         map.put(17, "物理实验中心");
         map.put(18, "第32教学楼—理");
         map.put(19, "第46教学楼—公共");
         map.put(20, "第33教学楼—马克思");
         map.put(21, "北洋广场");
         map.put(22, "第43教学楼—水土");
         map.put(23, "第39教学楼—水土");
         map.put(24, "第37教学楼—机械");
         map.put(25, "体育公园");
         map.put(26, "第36教学楼—力学");
         map.put(27, "格园");
         map.put(28, "知园");
         map.put(29, "平园");
         map.put(30, "诚园");
         map.put(31, "正园");
         map.put(32, "修园");
         map.put(33, "治园");
         map.put(34, "齐园");
            

        roadMap.put("自善北道", "通行");
        roadMap.put("自善南道", "通行");
        roadMap.put("侯德榜路", "通行");
        roadMap.put("博文北路", "通行");
        roadMap.put("西沽北路", "通行");
        roadMap.put("七星北路", "通行");
        roadMap.put("双台北路", "通行");
        roadMap.put("亲民西道", "通行");
        roadMap.put("明德西道", "通行");
        roadMap.put("明德北道", "通行");
        roadMap.put("新元北路", "通行");
        roadMap.put("亲民北道", "通行");
        roadMap.put("敬业路  ", "通行");
        roadMap.put("博文南路", "通行");
        roadMap.put("兴学路  ", "通行");
        roadMap.put("明德南道", "通行");
        roadMap.put("亲民南道", "通行");
        roadMap.put("自善东道", "不可通行");
        roadMap.put("王正廷道", "通行");
        roadMap.put("西沽南路", "通行");
        roadMap.put("七星南路", "通行");
        roadMap.put("双台南路", "通行");
        roadMap.put("新元南路", "通行");
        roadMap.put("新元中路", "通行");
        roadMap.put("英华道  ", "通行");
        roadMap.put("双台中路", "通行");
        roadMap.put("书田北道", "通行");
        roadMap.put("书田南道", "通行");
        roadMap.put("七星中路", "自行车通行");
        roadMap.put("西沽中路", "自行车通行");
        roadMap.put("花堤道  ", "通行");
        roadMap.put("求是北道", "通行");


        for (int i = 1; i < N; i++)
            for (int j = 1; j < N; j++)
                cost[i][j] = Infinite;
        for (int i = 1; i < N; i++) {
            cost[i][i] = 0;

        }
        cost[1][2] = 135;
        cost[1][3] = 426;
        cost[1][4] = 221;
        cost[1][5] = 278;
        cost[2][6] = 344;
        cost[2][7] = 220;
        cost[2][8] = 376;
        cost[3][4] = 212;
        cost[3][5] = 289;
        cost[3][6] = 311;
        cost[3][7] = 198;
        cost[3][8] = 231;
        cost[3][9] = 301;
        cost[3][10] = 379;
        cost[3][15] = 417;
        cost[3][16] = 442;
        cost[3][17] = 306;
        cost[4][5] = 192;
        cost[4][9] = 483;
        cost[5][9] = 1100;
        cost[5][10] = 244;
        cost[6][8] = 103;
        cost[6][9] = 285;
        cost[7][8] = 163;
        cost[8][9] = 208;
        cost[9][11] = 280;
        cost[9][13] = 294;
        cost[9][15] = 358;
        cost[10][17] = 382;
        cost[10][18] = 198;
        cost[10][19] = 397;
        cost[10][21] = 233;
        cost[11][12] = 249;
        cost[11][13] = 202;
        cost[12][13] = 202;
        cost[12][14] = 143;
        cost[12][22] = 246;
        cost[13][14] = 136;
        cost[13][15] = 136;
        cost[14][15] = 213;
        cost[14][16] = 325;
        cost[14][22] = 179;
        cost[15][16] = 171;
        cost[15][17] = 233;
        cost[15][24] = 345;
        cost[16][17] = 161;
        cost[16][22] = 364;
        cost[16][23] = 418;
        cost[16][24] = 182;
        cost[17][18] = 271;
        cost[18][19] = 209;
        cost[18][20] = 235;
        cost[18][21] = 182;
        cost[19][20] = 134;
        cost[19][21] = 332;
        cost[19][24] = 210;
        cost[20][21] = 237;
        cost[20][24] = 334;
        cost[22][23] = 249;
        cost[22][24] = 387;
        cost[23][24] = 298;
        cost[23][25] = 373;
        cost[23][26] = 395;
        cost[24][25] = 225;
        cost[24][26] = 438;
        cost[25][26] = 269;
        cost[6][27] = 91;
        cost[7][27] = 161;
        cost[8][28] = 90;
        cost[6][28] = 92;
        cost[7][28] = 83;
        cost[9][29] = 221;
        cost[11][29] = 195;
        cost[9][30] = 141;
        cost[9][30] = 141;
        cost[3][30] = 181;
        cost[15][31] = 147;
        cost[13][31] = 211;
        cost[15][32] = 81;
        cost[13][32] = 182;
        cost[16][32] = 133;
        cost[12][33] = 170;
        cost[22][33] = 181;
        cost[22][34] = 172;
        cost[24][34] = 209;
        cost[23][34] = 201;


        for (int i = 1; i < N; i++)
            for (int j = 1; j < i; j++)
                cost[i][j] = cost[j][i];
        
       
        


    }
}