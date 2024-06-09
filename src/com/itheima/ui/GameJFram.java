package com.itheima.ui;

import com.itheima.domain.path;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFram extends JFrame implements KeyListener, ActionListener {
    public GameJFram() {
//        初始化界面
        initJFram();

//        初始化菜单
        initJMenuBar();

//        初始化图片
        System.out.println(path);
        initImage();

//       让界面显示出来
        setVisible(true);
    }

    int x=0;
    int y=0;
    path p=ArrayUtil.getPath();//随机图片路径
    String path="image\\"+p.getImg()+"\\"+p.getImgStr()+"\\";
    int[][] arr=ArrayUtil.twoArray();
    private void initImage() {
//        清空原本已经出现的所有图片
        this.getContentPane().removeAll();
        boolean flag=isFlag(arr);
        if(flag){
               //        添加背景图片
        JLabel win=new JLabel(new ImageIcon("image\\win.png"));
        win.setBounds(200,150,193,73);
        this.getContentPane().add(win);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]==0){
                    x=i;
                    y=j;
                }else {
                    arr[i][j]=arr[i][j];
                }
            }
        }
//        System.out.println("xy分别是"+x+""+y);

//        记录步数
        JLabel stepCount=new JLabel("步数:"+bu);
        stepCount.setBounds(50,30,100,20);
        getContentPane().add(stepCount);


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int count=arr[i][j];
//                System.out.println(count);
            //         创建一个图片ImageIcon 对象
        //    创建一个JLabel的对象 (管理容器)
    JLabel jLabel=new JLabel(new ImageIcon(path+count+".jpg"));
//    指定图片位置
        jLabel.setBounds(105*j+83,105*i+134,105,105);
//        添加边框
//                0表示凸出来
//                1表示凹进去
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

//    把管理容器添加界面中
    this.getContentPane().add(jLabel);
        }
        }

//        添加背景图片
        JLabel bgc=new JLabel(new ImageIcon("image\\background.png"));
        bgc.setBounds(40,40,508,560);
        this.getContentPane().add(bgc);

//        刷新界面
        this.getContentPane().repaint();
    }
//  判断数组是否复原
    int[][]win={
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
};
    private boolean isFlag(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

//        创建选项下面的条目对象
        JMenuItem replayItem=new JMenuItem("重新游戏");
        JMenuItem reLoginItem=new JMenuItem("重新登录");
        JMenuItem closeItem=new JMenuItem("关闭游戏");
        JMenuItem accountItem=new JMenuItem("公众号");
        JMenuItem girl=new JMenuItem("美女");
        JMenuItem animal=new JMenuItem("动物");
        JMenuItem sport=new JMenuItem("运动");
    private void initJMenuBar() {
        //        创建整个的菜单对象
        JMenuBar menuBar = new JMenuBar();

//        创建菜单上的两个选项的对象 (功能  关于我们)
        JMenu function=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");
        JMenu chageImg=new JMenu("更换图片");

//        将每一项的选项条目添加到选项中
         chageImg.add(girl);
         chageImg.add(animal);
         chageImg.add(sport);

         function.add(chageImg);
        function.add(replayItem);
        function.add(reLoginItem);
        function.add(closeItem);

        aboutJMenu.add(accountItem);

//        将菜单的两个选项添加到菜单当中
        menuBar.add(function);
        menuBar.add(aboutJMenu);

//        给整个界面设置菜单
        setJMenuBar(menuBar);
        //        给条目绑定点击事件
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
    }

    private void initJFram() {
//        设置界面标题
        setTitle("游戏主界面");
//        设置宽高
        setSize(603,680);
//        设置界面置顶
        setAlwaysOnTop(true);
//        设置界面居中
        setLocationRelativeTo(null);
//        设置关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        取消默认的居中放置 只有取消了才会按照XY轴的形式添加组件
        setLayout(null);
//        给整个页面添加键盘监听事件
        addKeyListener(this);


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
//按下不松调用这个方法
    @Override
    public void keyPressed(KeyEvent e) {
        if(isFlag(arr)){
            return;
        }
        int code=e.getKeyCode();
        if(code==65){
//            把界面图片全删除
            this.getContentPane().removeAll();
//            加载第一张完整的图片
            JLabel all=new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //        添加背景图片
        JLabel bgc=new JLabel(new ImageIcon("image\\background.png"));
        bgc.setBounds(40,40,508,560);
        this.getContentPane().add(bgc);
            this.getContentPane().repaint();
        }
    }
    int bu=0;  // 记录步数
    @Override
    public void keyReleased(KeyEvent e) {
        if(isFlag(arr)){
            return;
        }
        int code=e.getKeyCode();
        if(code==37){
//            向左
            if(y<3){
             int temp=arr[x][y];
            arr[x][y]=arr[x][y+1];
            arr[x][y+1]=temp;
            bu++;
            }else {
            int temp=arr[x][y];
            arr[x][y]=arr[x][3];
            arr[x][3]=temp;
            }
        }else if(code==38){
//            向上
          if(x<3){
             int temp=arr[x][y];
            arr[x][y]=arr[x+1][y];
            arr[x+1][y]=temp;
            bu++;
            }else {
            int temp=arr[x][y];
            arr[x][y]=arr[3][y];
            arr[3][y]=temp;
          }
        }else if(code==39){
//            向右
             if(y>0){
             int temp=arr[x][y];
            arr[x][y]=arr[x][y-1];
            arr[x][y-1]=temp;
            bu++;
            }else {
            int temp=arr[x][y];
            arr[x][y]=arr[x][0];
            arr[x][0]=temp;
            }
        }else if(code==40){
//            向下
             if(x>0){
             int temp=arr[x][y];
            arr[x][y]=arr[x-1][y];
            arr[x-1][y]=temp;
            bu++;
            }else {
            int temp=arr[x][y];
            arr[x][y]=arr[0][y];
            arr[0][y]=temp;
          }
        }else if(code==87){  // 设置w为作弊码直接通关
            arr=win;
        }
//        System.out.println(x+","+y);
        initImage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source==replayItem){
//            重新游戏
             initGame();
        }else if(source==reLoginItem){
//            重新登录
            this.setVisible(false);
            new LoginJFram();
        }else if(source==closeItem){
//          关闭游戏
            System.exit(0);
        }else if(source==accountItem){
//         公众号
//            创建一个弹框
            JDialog dia=new JDialog();
//            创建一个容器管理图片
            JLabel jLabel=new JLabel(new ImageIcon("image\\about.png"));
//             设置位置和宽高
            jLabel.setBounds(0,0,258,258);
//            把图片添加到弹框中
            dia.getContentPane().add(jLabel);
//           给弹框设置大小
            dia.setSize(344,344);
//            让弹框置顶
            dia.setAlwaysOnTop(true);
//            让弹框居中
            dia.setLocationRelativeTo(null);
//            弹框不关闭无法操作下面的界面
            dia.setModal(true);
//            让弹框显示出来
            dia.setVisible(true);
        }else if(source==animal){
            Random r=new Random();
            int index=r.nextInt(8)+1;
            path="image\\animal\\animal"+index+"\\";
           initGame();
        }else if(source==girl){
            Random r=new Random();
            int index=r.nextInt(13)+1;
            path="image\\girl\\girl"+index+"\\";
           initGame();
        } else if (source==sport) {
            Random r=new Random();
            int index=r.nextInt(10)+1;
            path="image\\sport\\sport"+index+"\\";
            initGame();
        }
    }

    private void initGame() {
//            1 打乱数组
            arr=ArrayUtil.twoArray();
//            2 计步器清零
            bu=0;
//            3 重新加载
            initImage();
    }
}
