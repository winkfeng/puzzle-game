package com.itheima.ui;

import com.itheima.domain.user;
import com.itheima.util.CodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFram extends JFrame implements MouseListener {
    static ArrayList<user> allUsers=new ArrayList<>();
//    静态代码块 设置初始账号
    static {
        allUsers.add(new user("admin","12345"));
        allUsers.add(new user("zhangsan","12345"));
}

    public LoginJFram() {
//        界面初始化
        initJFram();

//        初始化图片
        initImage();

        setVisible(true);
    }

    JButton logBtn = new JButton(); // 登录按钮对象
    JButton regBtn = new JButton();  // 注册按钮对象
    JLabel jLabelYzm =new JLabel(); // 验证码字段对象
    JTextField username = new JTextField();// 用户名输入框对象
    JPasswordField password = new JPasswordField();//密码输入框对象
     JTextField yzm = new JTextField();//验证码输入框对象
    private void initImage() {
//        getContentPane().removeAll();
//        表单 设置样式

        username.setBounds(175,145,200,30);

        password.setBounds(175,195,200,30);

        yzm.setBounds(175,245,100,30);
        // 添加控件
        getContentPane().add(username);
        getContentPane().add(password);
        getContentPane().add(yzm);

//        表单文字
        JLabel usernameStr = new JLabel(new ImageIcon("image\\login\\用户名.png"));
        usernameStr.setBounds(115,150,47,17);
        JLabel passwordStr = new JLabel(new ImageIcon("image\\login\\密码.png"));
        passwordStr.setBounds(115,200,32,16);
        JLabel yzmStr = new JLabel(new ImageIcon("image\\login\\验证码.png"));
        yzmStr.setBounds(115,250,56,21);
        getContentPane().add(usernameStr);
        getContentPane().add(passwordStr);
        getContentPane().add(yzmStr);
//        验证码字段
        String code=CodeUtil.getCode();
        jLabelYzm.setText(code);
        jLabelYzm.setBounds(280,250,100,20);
        getContentPane().add(jLabelYzm);
//         给验证码绑定点击事件
        jLabelYzm.addMouseListener(this);


//        登录按钮
        logBtn.setBounds(245, 305, 128,47);
        logBtn.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        //        去除按钮边框
        logBtn.setBorderPainted(false);
        //        去除按钮背景
        logBtn.setContentAreaFilled(false);
        getContentPane().add(logBtn);

//        注册按钮
        regBtn.setBounds(115, 305, 128,47);
        regBtn.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
         //        去除按钮边框
        regBtn.setBorderPainted(false);
        //        去除按钮背景
        regBtn.setContentAreaFilled(false);
        getContentPane().add(regBtn);

//        给注册登录绑定事件
        logBtn.addMouseListener(this);
        regBtn.addMouseListener(this);



//     背景图
        JLabel jlabel = new JLabel(new ImageIcon("image\\login\\background.png"));
        jlabel.setBounds(0, 0, 470,390);
        getContentPane().add(jlabel);
//        刷新
         getContentPane().repaint();
    }

    private void initJFram() {
        setTitle("登录页");
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
//  完整的点击
    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj=e.getSource();
        if(obj==logBtn){
//            获取输入框内容 用户名 密码 验证码
            String userName=this.username.getText();
            String passWord=this.password.getText();
            String code=this.yzm.getText();
//            创建一个user对象用于校验
            user userInfo=new user(userName,passWord);
//            System.out.println(userInfo);
            if (userName.length()==0||passWord.length()==0) {
                showJDialog("用户名或密码不能为空!");
            }else if(code.length()==0){
                showJDialog("验证码不能为空!");
            }
            else if (!(code.equalsIgnoreCase(this.jLabelYzm.getText()))) {
                showJDialog("验证码错误!");
            } else if(contain(userInfo)){
//                关闭登录弹窗
                setVisible(false);
//                进入游戏页面
                new GameJFram();
            }else {
                showJDialog("用户名或密码不正确!");
            }

        } else if (obj==regBtn) {

        }
    }

//    用于校验用户名密码
    private boolean contain(user userInfo) {
        for (int i = 0; i < allUsers.size(); i++) {
            user user=allUsers.get(i);
            if(user.getUserName().equals(userInfo.getUserName())&&user.getPassword().equals(userInfo.getPassword())){
                return true;
            }
        }
        return false;
    }

    //    弹框对象
        public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);
//        让子元素垂直居中对齐
        jDialog.setLayout(new GridBagLayout());

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }
//  点击按钮不松触发
     @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if(obj==logBtn){
            logBtn.setIcon(new ImageIcon("image\\login\\登录按下.png"));

        } else if (obj==regBtn) {
            regBtn.setIcon(new ImageIcon("image\\login\\注册按下.png"));
        }
     }

//    放下按钮触发
    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
          if(obj==logBtn){
           logBtn.setIcon(new ImageIcon("image\\login\\登录按钮.png"));

        } else if (obj==regBtn) {
            regBtn.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
            setVisible(false);
            new RegisterJFram();
        } else if (obj==jLabelYzm) {
//              获取新的验证码
//                把获取的验证码替换过去
                jLabelYzm.setText(CodeUtil.getCode());
          }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
