class Person{
private String name;
private int age;
public Person(String name,int age){
this.name=name;
this.age=age;

}

public void getIofo(){
System.out.println("姓名"+this.name+",年龄"+this.age);

}
}

public class TestArrayOOP{
public static void main(String[] args){
Person[] per = new Person[3];
per[0]=new Person("张三",1);
per[1]=new Person("李四",2);
per[2]=new Person("王五",3);



for(int x=0;x<per.length;x++){
per[x].getIofo();
}

}

}