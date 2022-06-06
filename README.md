## 简介

吉林大学软件学院Java选修课上机实验题目，共有七个实验，实验题目和题解如下


# 实验一

#### 问题一

***题目：*** 请你编写一个java程序输出自己的姓名、年龄、身高和体重，分别通过控制台和Eclipse环境运行。

***思路：*** 略

***完整代码：*** [Java_experiment/src/Experiment_1/problem_1 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_1/problem_1)

***运行结果:*** 

<img src="img\image-20220603085205017.png" style="zoom: 80%;" />

<img src="img\image-20220603085152862.png" alt="image-20220603085152862" style="zoom:67%;" />

---

#### 问题二

***题目：*** 打印出100到1000之间所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。

***思路：*** 通过取模和取商的操作来获取三位数的每一位数字然后平方相加，通过循环找对应的结果

***关键代码：***

```java
        int a, b, c;
        for (int i = 100; i < 1000; i++) {
            a = i % 10;
            b = i % 100 / 10;
            c = i / 100;
            if ((a * a * a) + (b * b * b) + (c * c * c) == i) {
                System.out.println(i);
            }
        }
```

***完整代码：*** [Java_experiment/src/Experiment_1/problem_2 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_1/problem_2)

*** 运行结果：***

<img src="img\image-20220603090210328.png" alt="image-20220603090210328" style="zoom:67%;" />

---

####  问题三

***题目：*** 创建一个类，此类中包含多个静态成员变量和普通成员变量（变量的类型可以自定义），使用不同的方法进行初始化，同时需要展示出变量初始化的顺序。

***完整代码：*** [Java_experiment/src/Experiment_1/problem_3 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_1/problem_3)

***运行结果：***

<img src="img\image-20220603090036623.png" alt="image-20220603090036623" style="zoom:50%;" />

---

#### 问题四

***题目：*** 创建一个包含多个类的继承结构，编写一个使用这些类的方法，展示动态绑定和静态绑定的区别。

***完整代码：*** [Java_experiment/src/Experiment_1/problem_4 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_1/problem_4)

***运行结果:***

<img src="img\image-20220603090416225.png" alt="image-20220603090416225" style="zoom:50%;" />

---



# 实验二

#### 问题一

***题目：*** 从控制台输入若干个整数，并求和，直到结束标志999为止。如果输入的数据不是整数，自动忽略。提示：可以使用Scanner类来进行输入。

***思路：*** 使用Scanner类的nextInt()方法来输入整数，通过try...catch异常处理来忽略不是整数的情况

***关键代码：***

```java
		int sum = 0;
        int i;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                i = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                continue;
            }
            if (i == 999)
                break;
            else sum += i;
        }
```



***完整代码：*** [Java_experiment/src/Experiment_2/problem_1 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_2/problem_1)

***运行结果：*** 

<img src="img\image-20220604154028771.png" alt="image-20220604154028771" style="zoom: 50%;" />

---

#### 问题二

***题目：*** 在上个实验的基础上，输入支持 + - * /的表达式，并计算结果，放入到累加和中。例如：输入  10 * 3 – 2，那么程序应该计算出28，并放入累计和中。（此题解包含对括号的支持）

***思路：***将输入的字符串由中缀表达式转为后缀表达式后求值

***关键代码：***

```java
//将符号对应的优先级存入哈希表，方便后续判断优先级
        HashMap<Character, Integer> grade = new HashMap<>();
        grade.put('(', 4);
        grade.put('*', 3);
        grade.put('/', 3);
        grade.put('+', 2);
        grade.put('-', 2);
        grade.put(')', 1);
        //把Deque当作栈来用 data存储数，sign存储符号
        Deque<Integer> data = new LinkedList<>();
        Deque<Character> sign = new LinkedList<>();

```

```java
        //当符号栈为空或者栈顶符号小于当前符号，直接入栈
        if (sign.isEmpty() || grade.get(s.charAt(i)) > grade.get(sign.peek()))
            sign.push(s.charAt(i));
        else {
            //当符号栈不为空并且栈顶符号大于当前符号，依次弹出栈中优先级高于或等于当前运算符的所有运算符
            while (!sign.isEmpty() && grade.get(s.charAt(i)) <= grade.get(sign.peek())) {
                //遇到左括号停止
                if (sign.peek().equals('('))
                    break;
                Character sin = sign.pop();
                Integer opt1 = data.pop();
                Integer opt2 = data.pop();
                int result = result(opt2, opt1, sin);
                data.push(result);
            }
            //如果当前运算符不是右括号，直接入栈
            if (!(s.charAt(i) == ')'))
                sign.push(s.charAt(i));
            //当前运算符是右括号，不需要入栈，且需要把栈中剩余的左括号弹出
            else sign.pop();
        }
```

***完整代码：*** [Java_experiment/src/Experiment_2/problem_2 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_2/problem_2)

***运行结果：***

<img src="img\image-20220604160546408.png" alt="image-20220604160546408" style="zoom:50%;" />

---



# 实验三

***题目：*** 编写一个英文词频统计的程序。统计时不区分大小写，忽略所有的数字和标点符号。要求能处理普通的txt文本和html文本。在处理html文本时，要求过滤掉所有的html标签。  （10分）

***思路：*** 先利用正则表达式将文本调整为自己想要的格式，通过String的split()方法来获得字符串数组，最后用哈希表来遍历数组计算词频

***关键代码：***

```java
/*
        1.用单个空格替换HTML标签和非英文的字符
        2.将连续的空格替换为单个空格
        3.去除首尾空格
        4.将所有字符转为大写
        如：        <span>  hello    world  -hi111-    </span> 会被转化成 HELLO WORLD HI
*/
        String ctx = context.toString().
                replaceAll("<.+?>|[^a-zA-Z]", " ").
                replaceAll(" {2,}", " ").
                trim().toUpperCase();
        HashMap<String, Integer> map = new HashMap<>();
        String[] sArray = ctx.split(" ");
        for (String s : sArray) {
            Integer num = map.get(s);
            if (num == null) { //哈希表中此单词不存在，添加
                map.put(s, 1);
            } else {
                map.replace(s, ++num); //哈希表中此单词存在，数量+1
            }
        }
```

***完整代码：*** [Java_experiment/src/Experiment_3 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_3)

***运行结果：***

<img src="img\image-20220604162624059.png" alt="image-20220604162624059" style="zoom:50%;" />

---



# 实验四

***问题：*** 设计一个火车售票模拟程序Ticket.java。假设火车站有100张火车票要卖出，现在又5个售票点同时售票，用5个线程模拟这5个售票点的售票情况。要求如下：
	1）各个售票线程打印出自己所卖火车票的票号。
	2）同一张票不能被卖两次。

***思路：*** 开辟五个线程一同售票，每个线程售票时要对票数进行加锁，售票结束进行解锁。（下面给出两种实现方式）

***关键代码：***

```java
    //方法一：使用synchronized实现多线程
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);//让每个线程均有机会被执行，模拟真实卖票场景
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);//模拟出票时系统反应时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                    tickets--;
                }
            }
        }
    }
```

```java
    //方法二：使用lock锁实现多线程
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);//让每个线程均有机会被执行，模拟真实卖票场景
                lock.lock();
                if(tickets>0){
                    Thread.sleep(100);//模拟出票时系统反应时间
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"张票");
                    tickets--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
```

***完整代码：*** [Java_experiment/src/Experiment_4 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_4)

***运行结果：***

<img src="img\image-20220604165147449.png" alt="image-20220604165147449" style="zoom:50%;" />

---



# 实验五

***问题：*** 写一个多线程稀疏矩阵乘法运算函数。此运算函数使用P（常量）个线程同时计算。稀疏矩阵中很多位置的值为零，在进行浮点数运算时，如有操作数为零，运算速度更快。为了尽可能的均匀分配计算任务，不能固定分配计算任务。
输入参数：float[][]A, float[][]B，float[][]C  A的大小为 Ra×Ca，B的大小为Rb×Cb , 其中Ca=Rb。 C的大小为Ra×Cb，结果放在C中
 假设Ra，Ca，Rb，Cb都是预先定义好的常量。
要求：动态调整每个线程处理的数据量，使得每个线程基本同时结束。请说明算法的调度策略。进行调度时，如果涉及到数据访问冲突，请正确的加锁。
提示：每个线程可以在计算前申请需要计算的目标矩阵中的位置。计算完毕后写入目标向量。

***思路：*** 开辟多个线程，每个线程计算矩阵的一个位置，分配位置时需要加锁，防止数据冲突。使用CountDownLatch类可以对子线程计数，当子线程都结束后输出最终结果。

***关键代码：***

```java
//1、 创建CountDownLatch 对象，设定需要计数的子线程数目
        int P = 5;
        CountDownLatch latch = new CountDownLatch(P);
        System.out.println(P + "个子线程开始执行");
        for (int i = 0; i < P; i++) {
            new Thread(() -> {
                while (sum > 0) {
                    int index = -1;
                    try {
                        lock.lock();
                        //分配位置
                        if (sum > 0) {
                            index = sum;
                            sum--;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                    if (index != -1) {
                        //计算所分配位置对应的横纵坐标
                        int x = (index - 1) / B_c;
                        int y = (index - 1) % B_c;
                        float res = 0;
                        for (int k = 0; k < A_c; k++) {
                            res += A[x][k] * B[k][y];
                        }
                        C[x][y] = res;
                    }
                }
                //2、子线程执行完毕，计数减1
                latch.countDown();
            }).start();
        }
```

***完整代码：*** [Java_experiment/src/Experiment_5 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_5)

***运行结果：***

<img src="img\image-20220604180512473.png" alt="image-20220604180512473" style="zoom:50%;" />

---



# 实验六

***问题：*** 有一包含100亿条IP访问信息的文本文件，每一行是一个IPv4地址（如：192.168.1.1），要求对文件进行一遍扫描后输出所有出现过的IP地址（不能重复）。按下面三个不同的要求分别给出三个不同的实现类IPProcess1，IPProcess2，IPProcess3。需要实现的接口如下：
interface IPProcess{
     void process(File in, File out) throws IOException;
}
可以添加辅助类，请添加详细的设计说明和注释来解释程序。
IPProcess1: 内存足够大，直接使用HashMap进行数据处理
IPProcess2: 假设可用内存为1G，在内存中实现处理过程。（提示：创建 byte数组，每一位表示一个IP地址，IPV4每位取值范围0-255，可采用位操作）
IPProcess3: 假设内存非常少，必须在文件进行操作。（提示：使用RandomAccessFile, 可以使用read()， write()，read(byte[] b) ，write(byte[] b)，seek(long pos)，getFilePointer()方法 ）

***思路：***

IPProcess1: 使用HashSet类来直接对数据进行去重处理。

IPProcess2: 创建1G大小的byte数组"memory"模拟可用内存，读取文件时先将读取到的字符串转化成byte数组"temp"，按照每四位一组遍历数组"memory"，与数组"temp"按位比较来判断内存中是否有这个字符串，实现去重。

IPProcess3: 通过RandomAccessFile对文件进行操作，每读取一个字符串就遍历文件中已写入的字符串判断是否重复，若不重复直接写入文件。

```java	
    @Override
    public void process(File in, File out) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader(in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));

        HashSet<String> hs = new HashSet<>();

        String s;
        while ((s = br.readLine()) != null) hs.add(s);//读文件

        for (String str : hs) {
            bw.write(str);
            bw.newLine();
        }
        br.close();
        bw.close();
        long end = System.currentTimeMillis();
        System.out.println("方式一处理数据数据耗费了:" + (end - start) + "毫秒");
    }
```

```java
@Override
    public void process(File in, File out) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader(in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));
        byte[] memory = new byte[Max_1G];//模拟1G内存
        int sum = 0;//记录不重复的ipv4地址个数;
        String s;
        while ((s = br.readLine()) != null) {
            String[] split = s.split("\\.");// “.”等特殊字符需要进行转义
            byte[] temp = new byte[4];
            for (int i = 0; i < 4; i++) { //将读入的字符串转化成四位的byte数组
                temp[i] = (byte) Integer.parseInt(split[i]);
            }

            //遍历memory,四位一组做比较
            boolean repeat = false;
            for (int i = 0; i < 4 * sum; i += 4) {
                int index = i;
                int repeat_num = 0;
                for (int j = 0; j < 4; j++) { //将读入的字符串转化成四位的byte数组
                    if (temp[j] == memory[index])
                        repeat_num++;
                    index++;
                }
                //如果一组四个都重复，说明字符串重复
                if (repeat_num == 4) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                int index = sum * 4;
                for (int i = 0; i < 4; i++) { //将读入的字符串转化成四位的byte数组
                    memory[index++] = temp[i];
                }
                sum++;//个数加一
            }
        }

        //将充当内存的数组memory内的信息写入文件
        for (int i = 0; i < sum * 4; i += 4) {
            byte[] temp = {memory[i], memory[i + 1], memory[i + 2], memory[i + 3]};
            //InetAddress.getByAddress 可以将四位的byte数组转化为字符串
            //比如数组[1,2,3,4]可以转化为字符串/1.2.3.4
            InetAddress byAddress = InetAddress.getByAddress(temp);
            bw.write(byAddress.toString());
            bw.newLine();
        }

        br.close();
        bw.close();
        long end = System.currentTimeMillis();
        System.out.println("方式二处理数据数据耗费了:" + (end - start) + "毫秒");
    }
```

```java
 @Override
    public void process(File in, File out) throws IOException {
        long start = System.currentTimeMillis();
        RandomAccessFile readIn = new RandomAccessFile(in, "r");
        RandomAccessFile outPut = new RandomAccessFile(out, "rw");
        String s;//记录从readIn读取的字符串
        String temp;//记录outPut从输入文件中读取的字符串
        boolean repeat;//判断是否重复
        readIn.seek(0);   //readIn文件指针开始位置
        while ((s = readIn.readLine()) != null) {
            repeat = false;
            outPut.seek(0);//重置outPut文件指针开始位置
            //遍历outPut文件，在readIn文件中看是否有重复的字符串
            while ((temp = outPut.readLine()) != null) {
                if (s.equals(temp)) {
                    repeat = true;
                    break;
                }
            }
            //如果没有重复，将outPut文件指针置于文件末尾，写入字符串
            if (!repeat) {
                outPut.seek(outPut.length());
                outPut.writeBytes(s + "\n");
            }
        }
        readIn.close();
        outPut.close();
        long end = System.currentTimeMillis();
        System.out.println("方式三处理数据数据耗费了:" + (end - start) + "毫秒");
    }
```



***完整代码：*** [Java_experiment/src/Experiment_6 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_6)

***运行结果：***

<img src="img\image-20220604183041208.png" alt="image-20220604183041208" style="zoom:50%;" />



<img src="img\image-20220604183630288.png" alt="image-20220604183630288" style="zoom:50%;" />

<img src="img\image-20220604183734012.png" alt="image-20220604183734012" style="zoom:50%;" />

---



# 实验七

***问题：*** 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。
说明: s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
方法接口如下：
public static boolean isMatch(String s, String p) {
}

***思路：*** 使用动态规划的算法来实现通配符匹配

***关键代码：***

```java
        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lenp; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }
```

***完整代码：*** [Java_experiment/src/Experiment_7 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_7)

***运行结果：***

<img src="img\image-20220604185012320.png" alt="image-20220604185012320" style="zoom:50%;" />







