package reflect;

import java.lang.reflect.Method;
/**
java�ķ����÷���(�쳣�����д���)
���ҵ��ࣺClass cl = Class.forName("java.util.Date");
�ڴ�������(Ҫ��������к��пղ����Ĺ��췽��)��Object obj = cl.newInstence();
�۸������ƺͲ����ҷ�����Method method1 = cl.getMethod("getTime");//���û�в�������д�ڶ�����������в������磺Method method2 = cl.getMethod("setTime",long.class);
����ĳ����������ִ�з�����Object result = method1.invoke(obj);//����в�����Object result = method2.invoke(obj,21317362721);
ִ�еķ�����з���ֵ��������ֵ���أ����򷵻�null
 */
public class Test {

    public static void main(String[] args) {
        show("yerasel.Person");
    }
    private static void show(String name) {
        try {
            // JVM��ʹ����A����װ����,����Aװ���ڴ�(ǰ����:��A��û��װ���ڴ�),������A����ĳ�ʼ������
            Class classtype3 = Person.class;
            // ���classtype�еķ���
            Method getMethod3 = classtype3.getMethod("getName", new Class[] {});
            Class[] parameterTypes3 = { String.class, int.class };
            Method setMethod3 = classtype3
                    .getMethod("setName", parameterTypes3);

            // ʵ����������Ϊ��һ��Ż��������̬��ʼ�����Լ�����ʼ����
            Object obj3 = classtype3.newInstance();
            // ͨ��ʵ������Ķ�����÷���
            getMethod3.invoke(obj3); // ��ȡĬ��ֵ
            setMethod3.invoke(obj3, "Setting new ", 3); // ����
            getMethod3.invoke(obj3); // ��ȡ����
            System.out.println("----------------");

            // ��������ʱ������ָ�Ķ���
            Person p = new Person();
            Class classtype = p.getClass();// Class.forName(name);
            // ���classtype�еķ���
            Method getMethod = classtype.getMethod("getName", new Class[] {});
            Class[] parameterTypes = { String.class, int.class };
            Method setMethod = classtype.getMethod("setName", parameterTypes);
            getMethod.invoke(p);// ��ȡĬ��ֵ
            setMethod.invoke(p, "Setting new ", 1); // ����
            getMethod.invoke(p);// ��ȡ����
            System.out.println("----------------");

            // װ����,������ĳ�ʼ��
            Class classtype2 = Class.forName(name);
            // ���classtype�еķ���
            Method getMethod2 = classtype2.getMethod("getName", new Class[] {});
            Class[] parameterTypes2 = { String.class, int.class };
            Method setMethod2 = classtype2
                    .getMethod("setName", parameterTypes2);
            // ʵ��������
            Object obj2 = classtype2.newInstance();
            // ͨ��ʵ������Ķ�����÷���
            getMethod2.invoke(obj2); // ��ȡĬ��ֵ
            setMethod2.invoke(obj2, "Setting new ", 2); // ����
            getMethod2.invoke(obj2); // ��ȡ����

            System.out.println("----------------");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}