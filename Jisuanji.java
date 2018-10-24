import java.util.*;

public class Jisuanji {
    public static void main(String[] args) {
        long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        System.out.println("开始计时"+startMili);
        // 执行一段代码,求一百万次随机值
        for(int i=0;i<1000000;i++){
            Math.random();
        }

        int x, y1, i, a1,y3;
        String y2 ="";
        int e1 = 0;//运算结果
        String e = null;
        System.out.println("1、整数计算式 2、真分数计算式 3、阶乘");
        Scanner scan1 = new Scanner(System.in);
        a1 = scan1.nextInt();
        int p = 0;//计正确数目
        int p2=0;//计错误数目
        if (a1 == 1) {
            System.out.println("请输入题目的数量");
            Scanner scan2 = new Scanner(System.in);
            do {
                x = scan2.nextInt();
                if(x<0||x>5)
                {
                    System.out.println("输入题目的数量超过5");
                    System.out.println("请重新输入题目的数量");
                }
            }while(x>5);
            for (i = 0; i < x; i++) {
                int a = (int) (Math.random() * 200);//随机生成一个1-100的整数
                int b = (int) (Math.random() * 200);//随机生成一个1-100的整数
                int c = (int) (Math.random() * 200);//随机生成一个1-100的整数
                int d1 = (int) (Math.random() * 3);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
                int d2 = (int) (Math.random() * 3);//随机生成一个0-3的整数，0表示加法，1表示减法，2表示乘法，3表示除法
                switch (d1) {
                    case 0:
                        switch (d2) {
                            case 0:
                                e1 = a + b + c;
                                System.out.print(a + "+" + b + "+" + c + "=");
                                break;
                            case 1:
                                e1 = (a + b) - c;
                                if (e1 < 0) {
                                    e1 = c - a + b;
                                    System.out.print(c + "-" + a + "+" + b + "=");
                                } else {
                                    System.out.print(a + "+" + b + "-" + c + "=");
                                }
                                break;
                            case 2:
                                e1 = a + (b * c);
                                System.out.print(a + "+" + b + "*" + c + "=");
                                if(a<0){
                                    if(b<0){
                                        if(c<0){
                                            System.out.print("("+a+")"+ "+" +"("+b+")"+ "*" + "("+c+")" + "=");
                                        }
                                    }
                                }
                                break;
                            case 3:
                                e1 = a + (b / c);
                                System.out.print(a + "+" + b + "/" + c + "=");
                                break;
                        }
                        break;
                    case 1:
                        switch (d2) {
                            case 0:
                                e1 = a - b + c;
                                if (e1 < 0) {
                                    e1 = a - c + b;
                                    System.out.print(a + "-" + c + "+" + b + "=");
                                } else {
                                    System.out.print(a + "-" + b + "+" + c + "=");
                                }
                                break;
                            case 1:
                                e1 = a - b - c;
                                if (e1 < 0) {
                                    e1 = a + c + b;
                                    System.out.print(a + "+" + c + "+" + b + "=");
                                } else {
                                    System.out.print(a + "-" + b + "-" + c + "=");
                                }
                                break;
                            case 2:
                                e1 = a - (b * c);
                                if (e1 < 0) {
                                    e1 = (b * c) - a;
                                    System.out.print(b + "*" + c + "-" + a + "=");
                                } else {
                                    System.out.print(a + "-" + b + "*" + c + "=");
                                }
                                break;
                            case 3:
                                e1 = a - (b / c);
                                if (e1 < 0) {
                                    e1 = (b / c) - a;
                                    System.out.print(b + "/" + c + "-" + a + "=");
                                } else {
                                    System.out.print(a + "-" + b + "/" + c + "=");
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (d2) {
                            case 0:
                                e1 = (a * b) + c;
                                System.out.print(a + "*" + b + "+" + c + "=");
                                break;
                            case 1:
                                e1 = (a * b) - c;
                                if (e1 < 0) {
                                    e1 = c - (a * b);
                                    System.out.print(c + "-" + a + "*" + b + "=");
                                } else {
                                    System.out.print(a + "*" + b + "-" + c + "=");
                                }
                                break;
                            case 2:
                                e1 = (a * b) * c;
                                System.out.print(a + "*" + b + "*" + c + "=");
                                break;
                            case 3:
                                e1 = (a * b) / c;
                                System.out.print(a + "*" + b + "/" + c + "=");
                                break;
                        }
                        break;
                    case 3:
                        switch (d2) {
                            case 0:
                                e1 = (a / b) + c;
                                System.out.print(a + "/" + b + "+" + c + "=");
                                break;
                            case 1:
                                e1 = (a / b) - c;
                                if (e1 < 0) {
                                    e1 = c - (a / b);
                                    System.out.print(c + "-" + a + "/" + b + "=");
                                } else {
                                    System.out.print(a + "/" + b + "-" + c + "=");
                                }
                                break;
                            case 2:
                                e1 = (a / b) * c;
                                System.out.print(a + "/" + b + "*" + c + "=");
                                break;
                            case 3:
                                e1 = (a / b) / c;
                                System.out.print(a + "/" + b + "/" + c + "=");
                                break;
                        }
                        break;
                }
                y1 = scan2.nextInt();
                if (e1 == y1) {
                    System.out.println("恭喜你答对了！");
                    p = p + 1;
                } else {
                    System.out.println("很抱歉，答错了！");
                    p2=p2+1;
                }
            }
            System.out.println("总共" + x + "题，" + "你答对了" + p + "题,"+"你答错了"+p2+"题");
            long endMili=System.currentTimeMillis();
            System.out.println("结束 s"+endMili);
            System.out.println("总耗时为："+(endMili-startMili)/1000+"秒");
        }
        if (a1 == 2) {
            int M, Z;
            System.out.println("请输入题目的数量");
            Scanner scan2 = new Scanner(System.in);
            do {
                x = scan2.nextInt();
                if(x<0||x>5)
                {
                    System.out.println("输入题目的数量超过5");
                    System.out.println("请重新输入题目的数量");
                }
            }while(x>5);
            int x1, x2, m1, m2;
            for (i = 0; i < x; i++) {
                m1 = 1 + (int) (Math.random() * 100);//随机生成一个小于B的分母
                x1 = 1 + (int) (Math.random() * m1);//生成一个比分母小的分子，实现真分数
                m2 = 1 + (int) (Math.random() * 100);//随机生成一个小于B的分母
                x2 = 1 + (int) (Math.random() * m2);//生成一个比分母小的分子，实现真分数
                int c = (int) (Math.random() * 3);//生成运算符
                if (c == 0) {
                    Z = x1 * m2 + x2 * m1;
                    M = m1 * m2;
                    e = yuefen(Z, M);
                    System.out.print(x1 + "/" + m1 + "+" + x2 + "/" + m2 + "=");
                }
                if (c == 1) {
                    Z = x1 * m2 - x2 * m1;
                    M = m1 * m2;
                    e = yuefen(Z, M);
                    System.out.print(x1 + "/" + m1 + "-" + x2 + "/" + m2 + "=");
                }
                if (c == 2) {
                    Z = x1 * x2;
                    M = m1 * m2;
                    e = yuefen(Z, M);
                    System.out.print(x1 + "/" + m1 + "*" + x2 + "/" + m2 + "=");
                }
                if (c == 3) {
                    Z = m1 * x2;
                    M = m2 * x1;
                    e = yuefen(Z, M);
                    System.out.print(x1 + "/" + m1 + "/" + x2 + "/" + m2 + "=");
                }
                y2 = scan2.next();
                if (e.equals(y2)) {
                    System.out.println("恭喜你答对了！");
                    p = p + 1;
                } else {
                    System.out.println("很抱歉，答错了！");
                    p2=p2+1;
                }
            }
            System.out.println("总共" + x + "题，" + "你答对了" + p + "题,"+"你答错了"+p2+"题");
            long endMili=System.currentTimeMillis();
            System.out.println("结束 s"+endMili);
            System.out.println("总耗时为："+(endMili-startMili)/1000+"秒");
        }
        if(a1==3){
            System.out.println("请输入题目的数量");
            Scanner scan3 = new Scanner(System.in);
            do {
                x = scan3.nextInt();
                if(x<0||x>5)
                {
                    System.out.println("输入题目的数量超过5");
                    System.out.println("请重新输入题目的数量");
                }
            }while(x>5);
            int sum = 1;
            for (i = 0; i < x; i++) {
               int a = (int) (Math.random() * 10);//随机生成一个1-100的整数
                System.out.print(a + "!"+ "=");
                for(int n = 1;n <= a;++n){
                    sum *= n;
                }
                y3 = scan3.nextInt();
                if (sum==y3) {
                    System.out.println("恭喜你答对了！");
                    p = p + 1;
                } else {
                    System.out.println("很抱歉，答错了！");
                    p2=p2+1;
                }
            }
            System.out.println("总共" + x + "题，" + "你答对了" + p + "题,"+"你答错了"+p2+"题");
            long endMili=System.currentTimeMillis();
            System.out.println("结束 s"+endMili);
            System.out.println("总耗时为："+(endMili-startMili)/1000+"秒");
        }
    }



    public static String yuefen(int a,int b){
        int y = 1;
        for(int i=a;i>=1;i--){
            if(a%i==0&&b%i==0){
                y = i;
                break;
            }
        }
        int z = a/y;
        int m = b/y;
        if(z==0) {
            return "0";
        }
        return ""+z+"/"+m;
    }
    public static int f(int n){
        int sum = 1;
        for(int i = 1;i <= n;++i){
            sum *= i;
        }
        return sum;
    }
}
