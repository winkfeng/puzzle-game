package com.itheima.ui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegisterJFram extends JFrame implements MouseListener {
    public RegisterJFram() {
//        界面初始化
       initJFram();
//       初始图片表单控件文字
       initImage();


        setVisible(true);
    }

    JButton regBtn = new JButton();
    JButton setBtn = new JButton();
    private void initImage() {
//        添加注册用户名文字
        JLabel userStr=new JLabel(new ImageIcon("image/register/注册用户名.png"));
        userStr.setBounds(90,150,79,17 );
        getContentPane().add(userStr);
//        添加注册密码文字
        JLabel psdStr=new JLabel(new ImageIcon("image/register/注册密码.png"));
        psdStr.setBounds(90,200,64,16 );
        getContentPane().add(psdStr);
//        添加再次输入密码文字
        JLabel psdTwo=new JLabel(new ImageIcon("image/register/再次输入密码.png"));
        psdTwo.setBounds(90,250,96,17 );
        getContentPane().add(psdTwo);

//        表单输入框
//        添加注册用户名输入框
        JTextField userName=new JTextField();
        userName.setBounds(195,145,200,30 );
        getContentPane().add(userName);
//        添加注册密码输入框
        JTextField password=new JTextField();
        password.setBounds(195,195,200,30 );
        getContentPane().add(password);
//        添加再次输入密码输入框
        JTextField psd=new JTextField();
        psd.setBounds(195,245,200,30 );
        getContentPane().add(psd);


//        注册按钮
        regBtn.setBounds(115, 305, 128,47);
        regBtn.setIcon(new ImageIcon("image\\register\\注册按钮.png"));
         //        去除按钮边框
        regBtn.setBorderPainted(false);
        //        去除按钮背景
        regBtn.setContentAreaFilled(false);
        getContentPane().add(regBtn);

         //       重置按钮
        setBtn.setBounds(245, 305, 128,47);
        setBtn.setIcon(new ImageIcon("image\\register\\重置按钮.png"));
        //        去除按钮边框
        setBtn.setBorderPainted(false);
        //        去除按钮背景
        setBtn.setContentAreaFilled(false);
        getContentPane().add(setBtn);

//        给注册登录绑定事件
        setBtn.addMouseListener(this);
        regBtn.addMouseListener(this);





//        添加背景
        JLabel bgc=new JLabel(new ImageIcon("image/register/background.png"));
        bgc.setBounds(0,0,470,390);
        getContentPane().add(bgc);
    }

    private void initJFram() {
        setTitle("注册页");
        setSize(488, 430);
//        设置界面置顶
        setAlwaysOnTop(true);
//        设置界面居中
        setLocationRelativeTo(null);
//        设置关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        取消默认的居中放置 只有取消了才会按照XY轴的形式添加组件
        setLayout(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if(obj==regBtn){
            regBtn.setIcon(new ImageIcon("image\\register\\注册按下.png"));

        } else if (obj==setBtn) {
            setBtn.setIcon(new ImageIcon("image\\register\\重置按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
        if(obj==regBtn){
            regBtn.setIcon(new ImageIcon("image\\register\\注册按钮.png"));
        } else if (obj==setBtn) {
            setBtn.setIcon(new ImageIcon("image\\register\\重置按钮.png"));
            setVisible(false);
            new LoginJFram();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
