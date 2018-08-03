class MyException extends Exception {
	public MyException () {}
	public MyException(String msg){
		super(msg);
	}
}
public class Demo3 {
	public static void main(String[] args){
		try{
			test();
		}catch(MyException e){
			System.out.println("Catch My Exception is eariler than construct Exception Class");
			e.printStackTrace();
		}
	}

	public static void test() throws MyException{
		//运行时异常,编译器检查可以通过,但是运行会出错
		try {
			int i=10/0;
			System.out.println("i="+i);
		}catch(ArithmeticException e){
			throw new MyException("This is MyException");
		}
	}
}
