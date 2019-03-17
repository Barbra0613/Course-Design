package automaticCourse;

import javax.swing.*;

import java.awt.Color;
import java.io.*;
import java.util.*;


public class auto {
    private static LinkedList<Class> classList = new LinkedList<>();
    private static LinkedList<ClassRoom> classroomList = new LinkedList<>();
    private static LinkedList<Course> courseList = new LinkedList<>();
    private static LinkedList<Teacher> teacherList = new LinkedList<>();
    private static Set<String> preCouse = new HashSet<>();
    private static Set<String> having_preCourse = new HashSet<>();
    private static LinkedList<String> temList1;
    private static LinkedList<String> temList2;
    public static String pathTeacher;
    public static String pathClass;
    public static String pathClassroom;
    public static String pathCourse;

    private static LinkedList<String> randList(LinkedList<String> list, int timesWeek) {
        LinkedList<String> subList = new LinkedList<String>();
        Random rand = new Random();

        int j = 0;
        //System.out.println(list.size());
        while (true) {
            String m = list.get(rand.nextInt(list.size()));

            if (!subList.contains(m)) {
                subList.add(m);
                j++;
            }
            if (j == timesWeek) {
                break;
            }
        }
        return subList;
    }

    private static void order(Teacher te, Class cl, Course co) {
        temList1 = (LinkedList<String>) (te.getSq().getList().clone());
        te.getSq().getList().retainAll(cl.getSq().getList());
        if (te.getSq().getList().size() < co.getTimesWeek()) {
            frameFail.text ="在安排" + co.getName() + "课程时失败，请更改信息后重新排课。";
            frameFail window = new frameFail();
            window.frame.setVisible(true);
            return;
        }
        temList2 = randList(te.getSq().getList(), co.getTimesWeek());
        cl.getSq().getList().removeAll(temList2);
        te.getSq().setList(temList1);
        te.getSq().getList().removeAll(temList2);
        //System.out.println(cl.getSq().getList().size());
        for (String x : temList2) {
            int max=1000;
            ClassRoom selectRoom=null;
            for (ClassRoom y: classroomList) {
                if(y.getSq().getList().contains(x)&&y.getCapacity()-cl.getSum()<max&&y.getCapacity()-cl.getSum()>=0) {
                    max = y.getCapacity() - cl.getSum();
                    selectRoom=y;
                }
            }
            if(selectRoom!=null){
                selectRoom.getSq().getList().remove(x);
            }
            else{
                
                frameFail.text ="教室资源不足，请更改信息后重新排课。";
                frameFail window = new frameFail();
                window.frame.setVisible(true);
                return;
            }
            te.observed[x.charAt(0) - 'a'] = co.getName()+" "+cl.getName()+" "+selectRoom.getName();
            cl.observed[x.charAt(0) - 'a'] = co.getName()+" "+te.getName()+" "+selectRoom.getName();
        }
    }

    private static void Arranging() {
        for (Course cou : courseList) {
            
            Teacher tea = null;
            Class cla = null;
            if (preCouse.contains(cou.getName())) {
                for (Class x : classList) {
                    if (x.getGrade() == 1) {
                        cla = x;
                        break;
                    }
                }
                for (Teacher x : teacherList) {
                    if (x.teachCourse.contains(cou.getName())) {
                        tea = x;
                        break;
                    }
                }

                order(tea, cla, cou);

            } else if (having_preCourse.contains(cou.getName())) {
                int max = 0;
                for (Class x : classList) {
                    if (x.getSq().getList().size() > max && x.getGrade() != 1) {
                        cla = x;
                        max = x.getSq().getList().size();
     
                    }
                }
                for (Teacher x : teacherList) {
                    if (x.teachCourse.contains(cou.getName())) {
                        tea = x;
                        break;
                    }
                }
                //System.out.println("**"+tea.getName()+" "+cla.getName()+" "+cou.getName());
                order(tea, cla, cou);
                //System.out.println(course.getName());
            } else {
                int max = 0;
                for (Class x : classList) {
                    //System.out.println(x.getSq().getList().size() +"  "+ max);
                    if (x.getSq().getList().size() > max) {
                        cla = x;
                        max = x.getSq().getList().size();
                    }
                }
                for (Teacher x : teacherList) {
                    if (x.teachCourse.contains(cou.getName())) {
                        tea = x;
                        break;
                    }
                }
               // System.out.println("***"+tea.getName()+" "+cla.getName()+" "+cou.getName());
                order(tea, cla, cou);
            }
        }
    }

    public static void showClass(int grade) {
        for (Class x : classList) {
            if (x.getGrade() == grade) {
                Show(x.observed, x.getName() + "的课表");
                return;
            }
        }

    }

    public static void showTeacher(int teacherId) {
        for (Teacher x : teacherList) {
            if (x.getId() == teacherId) {
                Show(x.observed, x.getName() + "的课表");
                return;
            }
        }
    }

    private static void Show(String[] list, String string) {
        JFrame frame = new JFrame(string);
        JTable table = new JTable(new courseForm(list));
        table.setRowHeight(120);
        table.setBackground(new Color(240, 255, 255));

        JScrollPane pane = new JScrollPane(table);
        pane.setBackground(new Color(240, 255, 255));
        frame.getContentPane().add(pane);
        frame.setBackground(new Color(240, 255, 255));
        frame.setSize(1200,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void autoclass() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathClass)), "GBK"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] result = line.split(" ");
                classList.add(new Class(Integer.parseInt(result[0]), result[1], Integer.parseInt(result[2])));
            }
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathClassroom)), "GBK"));
            while ((line = br.readLine()) != null) {
                String[] result = line.split(" ");
                classroomList.add(new ClassRoom(Integer.parseInt(result[0]), result[1], Integer.parseInt(result[2]), false));
                if (result.length > 3 ) {
                	classroomList.removeLast();
                	classroomList.add(new ClassRoom(Integer.parseInt(result[0]), result[1], Integer.parseInt(result[2]), true));
                }
            }
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathCourse)), "GBK"));
            while ((line = br.readLine()) != null) {
                String[] result = line.split(" ");
                courseList.add(new Course(Integer.parseInt(result[0]), result[1], Integer.parseInt(result[2]),true,true));
                for (int i = 3; i < result.length; i++) {
                	   if ( result[i].charAt(0) != '#' ) {
                        courseList.getLast().precourse.add(result[i]);
                        preCouse.add(result[i]);
                        having_preCourse.add(result[1]);
                	   }else {
                		   if( result[i].charAt(1) == '1' ) {
                			   courseList.removeLast();
                			   courseList.add(new Course(Integer.parseInt(result[0]), result[1], Integer.parseInt(result[2]),true,false));   
                		   }else if( result[i].charAt(1) == '2' ) {
                			   courseList.removeLast();
                			   courseList.add(new Course(Integer.parseInt(result[0]), result[1], Integer.parseInt(result[2]),false,true));   
                		   }
                			   
                	   }
                }
            }
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathTeacher)), "GBK"));
            while ((line = br.readLine()) != null) {
                String[] result = line.split(" ");
                teacherList.add(new Teacher(Integer.parseInt(result[0]), result[1]));
                for (int i = 2; i < result.length; i++) {
                    if (result[i].length() == 1 && result[i].charAt(0) <= 'z' && result[i].charAt(0) >= 'a') {
                        teacherList.getLast().getSq().getList().remove(result[i].charAt(0) - 'a');
                    } else
                        teacherList.getLast().teachCourse.add(result[i]);
                }
            }

  
        } catch (IOException e) {
            e.printStackTrace();
        }

                
                    Arranging();
                    frame1 window = new frame1();
                    window.frame.setVisible(true);
                    

            }
        

    
}
