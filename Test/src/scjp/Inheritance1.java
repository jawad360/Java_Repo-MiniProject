package scjp;

public class Inheritance1 
{
	public static void main(String args[])
	{
		M h = new H();
		C c = new H();
		c.eat(h);
	}

}
class M
{
	void eat(M m)
	{
		System.out.println("M");
	}
}
class C extends M
{
	void eat(C c)
	{
		
	}
}
class H extends C
{
	void eat(H h)
	{
		System.out.println("H");
	}
}