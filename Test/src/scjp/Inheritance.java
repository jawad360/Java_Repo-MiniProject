package scjp;

public class Inheritance 
{

	public static void main(String args[])
	{
		
		B a= new B();
		a.display(new B());				//op will be 'B' when B a = new B();
										//a.display(new B());
	}
}

class A
{
	  void display(A a)
	{
		System.out.println("A");
	}
}
class B extends A
{
	  void display(B b)			//if display(A b) then overload & op:B
										//access modifier do not effect overriding or loading
	{
		System.out.println("B");
	}
	  void print()
	  {
		  A a = new B();
		  display(new B());			//op depend on new xx() assingment
	  }
	
}