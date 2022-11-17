package Self;

public class Main {
  public static void main(String[] args) {
    //
    Child obj = new Child();
    obj.setNum1(1);
    obj.setNum2(2);

    System.out.println(obj.addTwoNum(obj.getNum1(), obj.getNum2()));
  }
}
