
public class Test1 {

	public static void main(String[] args) {
		//总结：字符串String就是字符的序列char[]。
		//return false,内容相同类型不同不等；'a'默认是char型
		System.out.println(new Character('a').equals(new Byte((byte) 'a')));
		//混沌中
		//说法1：新建一个String对象--“abcd”，原因--该代码经过编译器优化后变为String a = "abcd"，亲测，确实！
		//说法2：新建三个String对象--“ab”、“cd”、“abcd”，全部于‘字符串池’中创建
		String a = "ab" + "cd";
		//未新建对象，在‘字符串池’中查找“abcd”，返回引用
		String b = "abcd";
		//目测相当于String c = new String(a+b);，空间中新建一个对象，未放入‘字符串池’
		String c = a + b;
		//‘字符串池’中创建一个新对象
		String d = "abcdabcd";
		a = a + b;
		System.out.println(a == d);
		//return false
		System.out.println(c == d);
		//intern()方法，‘字符串池’中查找相同值对象，存在返回引用，不存在则新建
		String f = new String("abc");
		//相当于把“abc”放入‘字符串池’
		f.intern();
		String h = new String(new char[]{'a','b','c','d'});
		String i = h.intern();
		//return true
		System.out.println(i == b);
	} 

}
