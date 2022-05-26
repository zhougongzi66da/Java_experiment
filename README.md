## 简介

吉林大学软件学院Java选修课上机实验题目，比较简单，共有七个实验，实验题目和题解如下


# 实验一

#### 问题一

***题目：*** 请你编写一个java程序输出自己的姓名、年龄、身高和体重，分别通过控制台和Eclipse环境运行。

***题解：*** [Java_experiment/src/Experiment_1/problem_1 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_1/problem_1)

---

#### 问题二

***题目：*** 打印出100到1000之间所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。

***题解：*** [Java_experiment/src/Experiment_1/problem_2 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_1/problem_2)

---

####  问题三

***题目：*** 创建一个类，此类中包含多个静态成员变量和普通成员变量（变量的类型可以自定义），使用不同的方法进行初始化，同时需要展示出变量初始化的顺序。

***题解：*** [Java_experiment/src/Experiment_1/problem_3 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_1/problem_3)

---

#### 问题四

***题目：*** 创建一个包含多个类的继承结构，编写一个使用这些类的方法，展示动态绑定和静态绑定的区别。

***题解：*** [Java_experiment/src/Experiment_1/problem_4 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_1/problem_4)

---



# 实验二

#### 问题一

***题目：*** 从控制台输入若干个整数，并求和，直到结束标志999为止。如果输入的数据不是整数，自动忽略。提示：可以使用Scanner类来进行输入。

***题解：*** [Java_experiment/src/Experiment_2/problem_1 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_2/problem_1)

---

#### 问题二

***题目：*** 在上个实验的基础上，输入支持 + - * /的表达式，并计算结果，放入到累加和中。例如：输入  10 * 3 – 2，那么程序应该计算出28，并放入累计和中。（此题解包含对括号的支持）

***题解：*** [Java_experiment/src/Experiment_2/problem_2 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_2/problem_2)

---



# 实验三

***题目：*** 编写一个英文词频统计的程序。统计时不区分大小写，忽略所有的数字和标点符号。要求能处理普通的txt文本和html文本。在处理html文本时，要求过滤掉所有的html标签。  （10分）

***题解：*** [Java_experiment/src/Experiment_3 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_3)

---



# 实验四

***问题：*** 设计一个火车售票模拟程序Ticket.java。假设火车站有100张火车票要卖出，现在又5个售票点同时售票，用5个线程模拟这5个售票点的售票情况。要求如下：
	1）各个售票线程打印出自己所卖火车票的票号。
	2）同一张票不能被卖两次。

***题解：*** [Java_experiment/src/Experiment_4 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_4)

---



# 实验五

***问题：*** 写一个多线程稀疏矩阵乘法运算函数。此运算函数使用P（常量）个线程同时计算。稀疏矩阵中很多位置的值为零，在进行浮点数运算时，如有操作数为零，运算速度更快。为了尽可能的均匀分配计算任务，不能固定分配计算任务。
输入参数：float[][]A, float[][]B，float[][]C  A的大小为 Ra×Ca，B的大小为Rb×Cb , 其中Ca=Rb。 C的大小为Ra×Cb，结果放在C中
 假设Ra，Ca，Rb，Cb都是预先定义好的常量。
要求：动态调整每个线程处理的数据量，使得每个线程基本同时结束。请说明算法的调度策略。进行调度时，如果涉及到数据访问冲突，请正确的加锁。
提示：每个线程可以在计算前申请需要计算的目标矩阵中的位置。计算完毕后写入目标向量。


***题解：*** [Java_experiment/src/Experiment_5 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_5)

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

***题解：*** [Java_experiment/src/Experiment_7 at master · zhougongzi66da/Java_experiment (github.com)](https://github.com/zhougongzi66da/Java_experiment/tree/master/src/Experiment_7)

# 未完待续...







