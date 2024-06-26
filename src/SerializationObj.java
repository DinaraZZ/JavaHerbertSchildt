// Java. Полное руководство - Г.Шилдт
// Сериализация и десериализация объекта
// стр. 866

import java.io.*;

public class SerializationObj {
    public static void main(String[] args) throws Exception {
        // Сериализация объекта
        FileOutputStream fileOutputStream = new FileOutputStream(".\\src\\serial.txt");
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(fileOutputStream)) {
            MyClass object1 = new MyClass("Hello", -7, 2.3);
            System.out.println(object1);
            objOStrm.writeObject(object1);
        } catch (Exception e) {
        }

        // Десериализация объекта
        try (ObjectInputStream objOStrm = new ObjectInputStream(new FileInputStream(".\\src\\serial.txt"))) {
            MyClass object2 = (MyClass) objOStrm.readObject();
            System.out.println(object2);
        } catch (Exception e) {
        }
    }
}

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    public String toString() {
        return s + " " + i + " " + d;
    }
}