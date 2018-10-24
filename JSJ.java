import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JOptionPane;

class JSJ extends JFrame implements ActionListener{
    private Timer timer;
    JLabel A,B,C,D,E,F;
    JButton button1, button2, button3, button4;
    public static JPanel G1;
    public JPanel G2,G3,G4;
    JMenuBar menubar = new JMenuBar();
    JTextField number,n,useranswer,flase,ShowTime,settingtime;
    String parten="0.00";
    DecimalFormat decimal=new DecimalFormat(parten);
    String s;
    double seconds;
    char[]ch={'+','-','*','÷'};
    float sum =0;
    int c=0;
    int right=0;
    int wrong=0;

    JSJ()
    {
        super("简易计算器升级版");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,500);
        A =new JLabel("输入题目数目：");
        B=new JLabel("时间：");
        C =new JLabel("设置时间(小于120秒)：");
        D =new JLabel("题目：");
        E =new JLabel("答案：");
        F =new JLabel("判断：");
        number =new JTextField(10);
        button1 =new JButton("产生题目");
        button4 =new JButton("改背景");
        button4.addActionListener(this);
        n =new JTextField(10);
        useranswer =new JTextField(10);
        useranswer.addActionListener(this);
        flase =new JTextField(15);
        ShowTime =new JTextField(10);
        ShowTime.addActionListener(this);
        settingtime =new JTextField(10);
        settingtime.addActionListener(this);
        Timer timertask = new Timer(1000, this);
        this.timer = timertask;
        button3 =new JButton("提交");
        button3.addActionListener(this);
        button2 =new JButton("下一题");
        button2.addActionListener(this);
        number.addActionListener(this);
        button1.addActionListener(this);
        G1 =new JPanel();
        G2 =new JPanel();
        G3 =new JPanel();
        getContentPane().add(G1,"North");
        getContentPane().add(G2,"Center");
        getContentPane().add(G3,"South");
        G3.add(button4);
        G3.add(menubar);
        G1.add(C);
        G1.add(settingtime);
        G1.add(A);
        G1.add(number);
        G2.add(button1);
        G2.add(D);
        G2.add(n);
        G2.add(E);
        G2.add(useranswer);
        G2.add(F);
        G2.add(flase);
        G3.add(B);
        G3.add(ShowTime);
        G3.add(button3);
        G3.add(button2);
        this.setResizable(false);
        this.setVisible(true);
    }
    boolean colorchange=true;
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()== button4)
        {
            if (colorchange==true) {
                G1.setBackground(Color.BLACK);
                G2.setBackground(Color.BLACK);
                colorchange=false;
            }
            else
            {
                G1.setBackground(Color.white);
                G2.setBackground(Color.white);
                colorchange=true;
            }
        }

        if(e.getSource()== button1)
        {
            try
            {
                ShowTime.setText(String.valueOf(settingtime.getText()));

                int n1=120,n2=5;
                if(n1<(Integer.parseInt(ShowTime.getText())))
                {
                    JOptionPane.showMessageDialog(null, "时间不能超过120秒！");
                    this.setVisible(false);
                }
                if(n2<(Integer.parseInt(number.getText())))
                {
                    JOptionPane.showMessageDialog(null, "选择题数不能超过5个！");
                    this.setVisible(false);

                }
                timer.start();

            }
            catch(NullPointerException o)
            {
                System.out.print("输入有误");
            }
            yunsuan();
            ShowTime.setText(String.valueOf(settingtime.getText()));
        }
        else{
            int t = Integer.parseInt(ShowTime.getText());
            t--;
            ShowTime.setText("" + t);
            if (t <= 0)
            {
                timer.stop();
                JOptionPane.showMessageDialog(null, "超出时间！停止答题");
                this.setVisible(false);
            }

            if(e.getSource()==menubar.getMenu(1))
            {
            }
            else if(e.getSource()== button3)
            {
                s =decimal.format(sum);
                if(Float.parseFloat(s)==Float.parseFloat(useranswer.getText()))
                {
                    right++;
                    flase.setText("输入的答案正确!");
                    flase.setForeground(Color.red);
                }
                else
                {
                    wrong++;
                    flase.setText("错误!正确答案为"+Float.parseFloat(s));
                    flase.setForeground(Color.BLUE);
                }
            }
            else if(e.getSource()== button2)
            {
                s =decimal.format(sum);

                c++;
                if(c !=Integer.parseInt(number.getText()))
                {
                    n.setText(null);
                    useranswer.setText(null);
                    flase.setText(null);
                    yunsuan();
                }

                else
                {
                    timer.stop();
                    seconds=Double.parseDouble(settingtime.getText())-Double.parseDouble(ShowTime.getText());
                    JOptionPane.showMessageDialog(null, "你答对"+right+"道题目,答错"+wrong+"道题目!"+"答题时间为："+seconds+"秒");
                    this.setVisible(false);
                }
            }

        }
    }
    private void yunsuan()
    {
        int x=(int)(Math.random()*2);
        switch(x)
        {
            case 0:
                yunsuan1();
                break;
            case 1:
                jiecheng();
                break;
            case 2:
                yunsuan1();
                break;
            case 3:
                jiecheng();
                break;
        }
    }
    private void yunsuan1()
    {
        int x1=(int)(Math.random()*3);
        switch(x1)
        {
            case 0:
                f1();
                break;
            case 1:
                fuhao();
                break;
            case 2:
                f2();
                break;

        }
    }
    private void f1()
    {
        int a=(int)(Math.random()*10);
        int b=(int)(Math.random()*10);
        int c=(int)(Math.random()*10);
        int x1=(int)(Math.random()*11);
        switch(x1)
        {
            case 0:
            {
                n.setText(a+" "+String.valueOf(ch[0])+" "+b+" "+String.valueOf(ch[0])+" "+c);
                sum =a+b+c;
            }break;
            case 1:
            {
                n.setText(a+" "+String.valueOf(ch[0])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                sum =a+b-c;
            }break;
            case 2:
            {
                n.setText(a+" "+String.valueOf(ch[1])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                sum =a-b-c;
            }break;
            case 3:
            {
                n.setText(a+" "+String.valueOf(ch[2])+" "+b+" "+String.valueOf(ch[0])+" "+c);
                sum =a*b+c;
            }break;
            case 4:
            {
                n.setText(a+" "+String.valueOf(ch[2])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                sum =a*b-c;
            }break;
            case 5:
            {
                n.setText(a+" "+String.valueOf(ch[2])+" "+b+" "+String.valueOf(ch[2])+" "+c);
                sum =a*b*c;
            }break;
            case 6:
            {
                n.setText(a+" "+String.valueOf(ch[0])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                sum =a+b-c;
            }break;
            case 7:
            {
                n.setText(a+" "+String.valueOf(ch[3])+" "+b+" "+String.valueOf(ch[0])+" "+c);
                sum =((float)a/(float)b)+c;
            }break;
            case 8:
            {
                n.setText(a+" "+String.valueOf(ch[3])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                sum =((float)a/(float)b)-c;
            }break;
            case 9:
            {
                n.setText(a+" "+String.valueOf(ch[3])+" "+b+" "+String.valueOf(ch[3])+" "+c);
                sum =((float)a/(float)b)/(float)c;
            }break;
        }
    }
    private void fuhao()
    {
        int a=(int)(Math.random()*10);
        int b=(int)(Math.random()*10);
        int c=(int)(Math.random()*10);
        int d=(int)(Math.random()*10);
        int x1=(int)(Math.random()*4);
        switch(x1)
        {
            case 0:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[0])+b+" "+String.valueOf(ch[0])+" "+c);
                sum =((float)a/(float)d)+b+c;
            }break;
            case 1:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[0])+b+" "+String.valueOf(ch[1])+" "+c);
                sum =((float)a/(float)d)+b-c;
            }break;
            case 2:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[1])+b+" "+String.valueOf(ch[1])+" "+c);
                sum =((float)a/(float)d)-b-c;
            }break;
            case 3:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[2])+b+" "+String.valueOf(ch[0])+" "+c);
                sum =((float)a/(float)d)*b+c;
            }break;
            case 4:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[2])+b+" "+String.valueOf(ch[1])+" "+c);
                sum =((float)a/(float)d)*b-c;
            }break;
            case 5:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[2])+b+" "+String.valueOf(ch[2])+" "+c);
                sum =((float)a/(float)d)*b*c;
            }break;
            case 6:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[2])+b+" "+String.valueOf(ch[3])+" "+c);
                sum =((float)a/(float)d)*b/(float)c;
            }
            case 7:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[3])+b+" "+String.valueOf(ch[0])+" "+c);
                sum =((float)a/(float)d)/(float)b+c;
            }break;
            case 8:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[3])+b+" "+String.valueOf(ch[1])+" "+c);
                sum =((float)a/(float)d)/(float)b-c;
            }break;
            case 9:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[3])+b+" "+String.valueOf(ch[3])+" "+c);
                sum =((float)a/(float)d)/(float)b/(float)c;
            }break;
        }
    }
    private void f2()
    {
        int a=(int)(Math.random()*10);
        int b=(int)(Math.random()*10);
        int c=(int)(Math.random()*10);
        int d=(int)(Math.random()*10);
        int e=(int)(Math.random()*10);
        int x1=(int)(Math.random()*4);
        switch(x1)
        {
            case 0:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[0])+" "+b+"/"+c+" "+String.valueOf(ch[0])+" "+e);
                sum =((float)a/(float)d)+((float)b/(float)c)+e;
            }break;
            case 1:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[0])+" "+b+"/"+c+" "+String.valueOf(ch[1])+" "+e);
                sum =((float)a/(float)d)+((float)b/(float)c)-e;
            }break;
            case 2:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[1])+" "+b+"/"+c+" "+String.valueOf(ch[1])+" "+e);
                sum =((float)a/(float)d)-((float)b/(float)c)-e;
            }break;
            case 3:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[2])+" "+b+"/"+c+" "+String.valueOf(ch[0])+" "+e);
                sum =((float)a/(float)d)*((float)b/(float)c)+e;
            }break;
            case 4:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[2])+" "+b+"/"+c+" "+String.valueOf(ch[1])+" "+e);
                sum =((float)a/(float)d)*((float)b/(float)c)-e;
            }break;
            case 5:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[2])+" "+b+"/"+c+" "+String.valueOf(ch[2])+" "+e);
                sum =((float)a/(float)d)*((float)b/(float)c)*e;
            }break;
            case 6:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[2])+" "+b+"/"+c+" "+String.valueOf(ch[3])+" "+e);
                sum =((float)a/(float)d)*((float)b/(float)c)/(float)e;
            }
            case 7:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[3])+" "+b+"/"+c+" "+String.valueOf(ch[0])+" "+e);
                sum =((float)a/(float)d)/((float)b/(float)c)+e;
            }break;
            case 8:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[3])+" "+b+"/"+c+" "+String.valueOf(ch[1])+" "+e);
                sum =((float)a/(float)d)/((float)b/(float)c)-e;
            }break;
            case 9:
            {
                n.setText(a+"/"+d+" "+String.valueOf(ch[3])+" "+b+"/"+c+" "+String.valueOf(ch[3])+" "+e);
                sum =((float)a/(float)d)/((float)b/(float)c)/(float)e;
            }break;
        }
    }


    private void jiecheng()
    {
        Random random = new Random();

        int a=random.nextInt(10);
        n.setText(a+"!");
        sum =1;
        for(int i=1;i<=a;i++)
        {
            sum = sum *i;
        }
    }
}
class myjsj {
    public static void main(String[] args) {
        new JSJ();
    }
}