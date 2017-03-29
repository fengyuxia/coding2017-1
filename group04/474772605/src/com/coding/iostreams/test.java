package com.coding.iostreams;

public class test {
	
	public int test(int a ,int b) {
		return -1;
	}
	public test(){
		
	}
	
	/*public static void main(String[] args) {
		int i =1;
		i>>>=2;
		System.out.println(i);
		long b =-2048;
		b<<=10;
		System.out.println(b);
		boolean q =false;
		System.out.println(q);
	}*/
	 public static void main(String[] args) {
   	  Banana a = new Banana();
   	Banana b = new Banana();
   	  a.setabc(2);
 	  System.out.println(a.abc);
 	  System.out.println(b.abc);
 	 int[] ad = new int[100];;
 	 ad[0]=1;
 	 int[] av;
 	 av=ad;
 	  System.out.println(av[2]);
	}
	  
}
	
class Banana{
	public   int abc;
	
	int setabc(int a){
		abc+=a;
		return this.abc;
	}
	  void f(int i){
		System.out.println("i="+i);
		if(i<2)
		f(i);
		this.abc++;
		System.out.println("this.f="+i);
	}
	  Banana b(int i){
			System.out.println("i="+i);
			if(i<2)
			this.b(i);
			System.out.println("this.f="+i);
			return this;
		}
	  void d(int i){
		  int a = 0;
		  a++;
			System.out.println("i="+i);
			if(i<2)
			f(i);
			
			System.out.println("this.f="+i);
		}
	 
   
}



	
	
	
