package reflect;

import java.lang.reflect.Method;
/**
java的反射用法：(异常请自行处理)
①找到类：Class cl = Class.forName("java.util.Date");
②创建对象(要求这个类中含有空参数的构造方法)：Object obj = cl.newInstence();
③根据名称和参数找方法：Method method1 = cl.getMethod("getTime");//如果没有参数不用写第二个参数如果有参数的如：Method method2 = cl.getMethod("setTime",long.class);
④在某个对象上面执行方法，Object result = method1.invoke(obj);//如果有参数的Object result = method2.invoke(obj,21317362721);
执行的方如果有返回值，将返回值返回，否则返回null
 */
public class Test {

    public static void main(String[] args) {
        show("yerasel.Person");
    }
    private static void show(String name) {
        try {
            // JVM将使用类A的类装载器,将类A装入内存(前提是:类A还没有装入内存),不对类A做类的初始化工作
            Class classtype3 = Person.class;
            // 获得classtype中的方法
            Method getMethod3 = classtype3.getMethod("getName", new Class[] {});
            Class[] parameterTypes3 = { String.class, int.class };
            Method setMethod3 = classtype3
                    .getMethod("setName", parameterTypes3);

            // 实例化对象，因为这一句才会输出“静态初始化”以及“初始化”
            Object obj3 = classtype3.newInstance();
            // 通过实例化后的对象调用方法
            getMethod3.invoke(obj3); // 获取默认值
            setMethod3.invoke(obj3, "Setting new ", 3); // 设置
            getMethod3.invoke(obj3); // 获取最新
            System.out.println("----------------");

            // 返回运行时真正所指的对象
            Person p = new Person();
            Class classtype = p.getClass();// Class.forName(name);
            // 获得classtype中的方法
            Method getMethod = classtype.getMethod("getName", new Class[] {});
            Class[] parameterTypes = { String.class, int.class };
            Method setMethod = classtype.getMethod("setName", parameterTypes);
            getMethod.invoke(p);// 获取默认值
            setMethod.invoke(p, "Setting new ", 1); // 设置
            getMethod.invoke(p);// 获取最新
            System.out.println("----------------");

            // 装入类,并做类的初始化
            Class classtype2 = Class.forName(name);
            // 获得classtype中的方法
            Method getMethod2 = classtype2.getMethod("getName", new Class[] {});
            Class[] parameterTypes2 = { String.class, int.class };
            Method setMethod2 = classtype2
                    .getMethod("setName", parameterTypes2);
            // 实例化对象
            Object obj2 = classtype2.newInstance();
            // 通过实例化后的对象调用方法
            getMethod2.invoke(obj2); // 获取默认值
            setMethod2.invoke(obj2, "Setting new ", 2); // 设置
            getMethod2.invoke(obj2); // 获取最新

            System.out.println("----------------");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}