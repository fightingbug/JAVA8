package Test;

import java.util.HashMap;

/*1 Lambda表达式  是一个匿名函数  理解为一段可以传递的代码
    Runnable r = () -> sout("")；
    形参列是接口中抽象方法的形参列表，方法体就是重写的方法
 六种情况：
    1 无参无返回值   2 有参无返回值   3数据类型可以省略：类型推断
    4 一个参数时 括号可以省
    5 一个语句时 大括号可以省
    6 两个或以上参数，多条语句，可以有返回值
    本质是函数式接口接口的实例

*    函数式接口 只包含一个抽象方法
    使用@FunctionalInterface 注解函数式及接口
     四大内置核心函数式接口：
     消费Consumer<T> void accept(T)
     供给Supplier<T> T get()
     函数Function<T,R> R apply(T)
     断定Predicate<T> boolean test(T)


*   方法引用与构造器引用 就是lambda表达式  是一个深层次表达
    要求： 抽象方法的参数和返回值 与方法引用的相同 操作符：：
    对象：：非静态方法
    PrintStream ps = System.out
    Consumer<String> con2 = ps::println
    con2.accept("。。。。")
    类：：静态方法
    先用Lambda重写compare方法
    Comparator<Integer> com2 = Integer::compare;
    com2.compare(1,2)
   类：：非静态方法
        (s1,s2)->s1.compareTo(s2)
    com2 = String::compareTo；
    com2.compare("abc","abd")
  格式： 先定义lambda表达式  在用函数引用

    构造器 引用：
        ()-> new Employee();
        Employee::new;

     数组引用：
        length->new String[length]
        String[]::new ;
*   强大的Stream API
      把真正的函数式编程风格引入Java
      Stream API 对集合数据操作，类似SQL对数据库操作
      集合讲的是数据，Stream讲的是计算跟CPU打交道
      1 创建
        1:通过集合 Stream<T> stream() 返回一个顺序流
                  Stream<T> parallelStream 返回并行流
        2:通过数组 Arrays.stream(T[] array) 返回一个流
            多个重载： IntStream ...
        3: Stream.of(1,2,3,4,5)
        4: 无限流
            Stream.iterate(final T seed,final UnaryIperator<t>f)
            Stream.generate(Supplier<T> s)

      2 中间操作  连成链不操作
          1 筛选切片
            filter(Predicate p) 接受Lamdda表达式，从流排除元素
            limit(n) 截断流  使元素不超过给定值
            skip(n) 跳过前n个值
            distinct() 筛选，通过hashCode和equals去重

          2映射
            map(Function f) 接收函数，函数应用到每个元素上
            mapToInt(ToIntFunction f) 接受函数，函数应用到每个元素，返回一个IntStream流
            重载...
            flatMap(Function f) 接受函数，将流每个值替换一个流，把所有流连接为一个流

        3排序
           sorted() 产生新流，按自然排序
           sorted(Comparator com) 产生新流，按比较器

      3终止操作 执行操作 就执行中间操作链 称“惰性求值”
            1 匹配与查找
       allMatch(Predicate p) 是否全部匹配
       anyMatch(Predicate p) 是否有一个匹配
       noneMatch(Predicate p) 没有匹配
       findFirst()
        findAny() 返回任一元素
       count() 计数
       max(Comparator c)
       min(Comparator c)
       forEach(Consumer c) 内部迭代
            2归约
     reduce(T iden,BinaryOperator b) 将元素反复结合，返回一个值
     reduce(BinaryOperator b) 将元素反复结合得到一个值，返回Optional<T>
        3收集
    collect(Collector c)接受一个Collector的实现用于元素汇总
  c中的方法决定流的操作
  Collector中的方法 toList toSet toCollection 计数 求和 求平均等

*   Optional<T>类 容器类保存T的值代表存在，保存null表示不存在，可以避免空指针
 实例化 : .of(T)  .empty()null, .ofNUllable(T) 可以为空

    optional.get() 返回内部值，
    optional.orElse(T) 返回内部值若为NULL则返回T
*
* */
public class Test {
    public static void main(String[] args) {
        int a[] = new int[20];
        System.out.println(-100);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(-100,500);
        System.out.println(map.containsKey(-100));

    }

}
