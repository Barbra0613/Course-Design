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
        textArea.append(map.get(i+1)+"\r\n"+"���·���ܳ�Ϊ��"+shortest[i][j]+"\r\n"+"�������������"+"\r\n");
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
        textArea.append(map.get(i+1)+"\r\n"+"���·���ܳ�Ϊ��"+shortest[i][j]+"\r\n"+"���г�/���˵������"+"\r\n");
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
         	textArea.append(map.get(i) + "  �������� " + map.get(j) + " �������� ");
            return;
        }
        if (path[i][k] == 0 && path[k][j] == 0) {
         	textArea.append(map.get(i) + " �������� " + map.get(k) + " �������� " + map.get(j) + " �������� ");
            return;
        }
        if (path[i][k] == 0 && path[k][j] != 0) {
         	textArea.append(map.get(i) + " �������� ");
            show(k, j, path[k][j],textArea);
            return;
        }
        if (path[i][k] != 0 && path[k][j] == 0) {
            show(i, k, path[i][k],textArea);
            textArea.append(map.get(j) + " �������� ");
            return;

        }
        if (path[i][k] != 0 && path[k][j] != 0) {
            show(i, k, path[i][k],textArea);
            show(k, j, path[k][j],textArea);
        }

    }


    public static void start() {
       

    	     map.put(1, "УҽԺ");
         map.put(2, "��԰����");
         map.put(3, "��50��ѧ¥������");
         map.put(4, "�ۺ�������");
         map.put(5, "������");
         map.put(6, "��԰����");
         map.put(7, "�������Ͻ�ѧ����");
         map.put(8, "÷԰����");
         map.put(9, "��55��ѧ¥������");
         map.put(10, "��31��ѧ¥������");
         map.put(11, "��԰����");
         map.put(12, "��԰����");
         map.put(13, "֣��ͼ���");
         map.put(14, "��44��ѧ¥������");
         map.put(15, "��45��ѧ¥������");
         map.put(16, "��47��ѧ¥��ʵ��");
         map.put(17, "����ʵ������");
         map.put(18, "��32��ѧ¥����");
         map.put(19, "��46��ѧ¥������");
         map.put(20, "��33��ѧ¥�����˼");
         map.put(21, "����㳡");
         map.put(22, "��43��ѧ¥��ˮ��");
         map.put(23, "��39��ѧ¥��ˮ��");
         map.put(24, "��37��ѧ¥����е");
         map.put(25, "������԰");
         map.put(26, "��36��ѧ¥����ѧ");
         map.put(27, "��԰");
         map.put(28, "֪԰");
         map.put(29, "ƽ԰");
         map.put(30, "��԰");
         map.put(31, "��԰");
         map.put(32, "��԰");
         map.put(33, "��԰");
         map.put(34, "��԰");
            

        roadMap.put("���Ʊ���", "ͨ��");
        roadMap.put("�����ϵ�", "ͨ��");
        roadMap.put("��°�·", "ͨ��");
        roadMap.put("���ı�·", "ͨ��");
        roadMap.put("������·", "ͨ��");
        roadMap.put("���Ǳ�·", "ͨ��");
        roadMap.put("˫̨��·", "ͨ��");
        roadMap.put("��������", "ͨ��");
        roadMap.put("��������", "ͨ��");
        roadMap.put("���±���", "ͨ��");
        roadMap.put("��Ԫ��·", "ͨ��");
        roadMap.put("���񱱵�", "ͨ��");
        roadMap.put("��ҵ·  ", "ͨ��");
        roadMap.put("������·", "ͨ��");
        roadMap.put("��ѧ·  ", "ͨ��");
        roadMap.put("�����ϵ�", "ͨ��");
        roadMap.put("�����ϵ�", "ͨ��");
        roadMap.put("���ƶ���", "����ͨ��");
        roadMap.put("����͢��", "ͨ��");
        roadMap.put("������·", "ͨ��");
        roadMap.put("������·", "ͨ��");
        roadMap.put("˫̨��·", "ͨ��");
        roadMap.put("��Ԫ��·", "ͨ��");
        roadMap.put("��Ԫ��·", "ͨ��");
        roadMap.put("Ӣ����  ", "ͨ��");
        roadMap.put("˫̨��·", "ͨ��");
        roadMap.put("���ﱱ��", "ͨ��");
        roadMap.put("�����ϵ�", "ͨ��");
        roadMap.put("������·", "���г�ͨ��");
        roadMap.put("������·", "���г�ͨ��");
        roadMap.put("���̵�  ", "ͨ��");
        roadMap.put("���Ǳ���", "ͨ��");


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