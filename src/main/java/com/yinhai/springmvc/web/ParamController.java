package com.yinhai.springmvc.web;

import com.yinhai.springmvc.bean.Car;
import com.yinhai.springmvc.bean.Goods;
import com.yinhai.springmvc.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

/**
 * @author casper
 * 参数绑定：
 * 	    1.1 默认参数绑定	
 *		1.2基本数据类型的绑定
 *		1.3包装数据类型的绑定
 *		1.4BigDecimal BigInteger的绑定
 *		1.5字符串的绑定
 *		1.6日期类型绑定
 *		1.7基本数组类型绑定
 *		1.8Java Bean基本对象的绑定（基本数据类型）
 *		1.9对象数组的绑定（不推荐这样，直接使用1.11使用集合对象去绑定，更加nice）
 *		1.10java组合对象的绑定（对象的引用）
 *		1.11java.util.List类型的绑定
 *		1.12java.util.Map类型的绑定
 * 参数绑定错误的说明：
 * 	http400 参数不匹配
 */
//类上后面的@RequestMapping的修饰，就是访问所有的本类的方法，都要加上/param的前缀
@RequestMapping("param/")
@Controller
public class ParamController {
	
	/**
	 * 1.1默认参数的绑定
	 * 访问的url:http://localhost:8080/springmvcdemo/param/test
	 * @return
	 */
	@RequestMapping(value="test")
	public String test(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
		System.out.println("默认参数......");
		//能拿到request，response，session 我就不用说这个比Struts有好强大的了吧 在这里你就可以使用 这些对象随便做点什么了.....
		System.out.println("request对象："+request);
		System.out.println("response对象："+response);
		System.out.println("session对象："+session);
		System.out.println("model对象: "+model);
		return "param";
	}
	
	/**
	 * 1.2基本数据类型的绑定
	 * 访问的url:
	 * http://localhost:8080/springmvcdemo/param/test1?num1=124&num2=234&num3=2345&flag=false&c1=f&num4=12.67
	 * http://localhost:8080/springmvcdemo/param/test1?num1=124&num2=234&num3=2345&flag=0&c1=A&num4=12.67
	 * 当参数不匹配的时候会出现http 400的错误
	 * http://localhost:8080/springmvcdemo/param/test1?num1=12.4&num2=234&num3=2345&flag=0&c1=A&num4=12.67
	 */
	@RequestMapping(value="test1",method={RequestMethod.GET,RequestMethod.POST})
	public String test1(byte num1,int num2,long num3,boolean flag,char c1,double num4){
		System.out.println("基本数据类型绑定.......");
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(flag);
		System.out.println(c1);
		return "param";
	}
	
	/**
	 * 1.3包装类型数据的转换
	 * 访问url：http://localhost:8080/springmvcdemo/param/test2?num1=124&num2=234&num3=2345&flag=false&c1=f&num4=12.67
	 */
	@RequestMapping(value="test2",method={RequestMethod.GET,RequestMethod.POST})
	public String test2(Byte num1,Integer num2,Long num3,Boolean flag,Character c1,Double num4){
		System.out.println("包装数据类型绑定.......");
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(flag);
		System.out.println(c1);
		return "param";
	}
	
	/**
	 * 1.4大整数和浮点数的绑定
	 * 访问的url:http://localhost:8080/springmvcdemo/param/test3?num1=1234&num2=123.5
	 * @param num1
	 * @param num2
	 * @return
	 */
	@RequestMapping("test3")
	public String test3(BigInteger num1,BigDecimal num2){
		System.out.println("大整数的和浮点数的绑定");
		System.out.println(num1);
		System.out.println(num2);
		return "param";
	}
	
	/**
	 * 1.5字符串类型的绑定
	 * 访问url:http://localhost:8080/springmvcdemo/param/test4?name=casper&pass=qwer
	 * @return
	 */
	@RequestMapping("test4")
	public String test4(String name,StringBuffer pass){
		System.out.println("字符串参数的绑定");
		System.out.println(name);
		System.out.println(pass.toString());
		return "param";
	}
	
	/**
	 * 1.6日期类型的字符串的绑定
	 * 访问url:http://localhost:8080/springmvcdemo/param/test5?date=1923-01-12
	 * 可以测试不同的pattern
	 */
	@RequestMapping("test5")
	public String test5(@DateTimeFormat(pattern="yyyy-MM-dd") Date date){
		System.out.println("日期类型的参数的绑定");
		System.out.println(date);
		return "param";
	}
	
	/**
	 * 1.7基本数组类型的绑定
	 * 访问url：http://localhost:8080/springmvcdemo/param/test6?ids=23&ids=45&ids=98
	 * @param ids
	 * @return
	 */
	@RequestMapping("test6")
	public String test6(Integer[] ids){
		System.out.println("数组类型的绑定");
		System.out.println(Arrays.toString(ids));
		return "param";
	}
	
	/**
	 * 1.8基本bean的绑定
	 * 访问url:http://localhost:8080/springmvcdemo/param/test7?id=123&name=casper&age=18&birthday=1994-08-23&isParty=false
	 */
	@RequestMapping("test7")
	public String test7(User user){
		System.out.println("基本bean的绑定....");
		System.out.println(user);
		return "param";
	}
	
	/**
	 * 1.9对象数组的绑定(不推荐这样做，可以直接使用集合对象绑定List<Goods>比数组更优势)
	 */
	@RequestMapping("test8")
	public String test8(Goods[] goodsArr){
		System.out.println("对象数组的绑定.....");
		System.out.println(Arrays.toString(goodsArr));
		return "param";
	}
	
	/**
	 * 1.10组合对象的绑定
	 * 访问url:http://localhost:8080/springmvcdemo/param/test9?id=001&user.id=12&user.name=casper&user.age=18
	 */
	@RequestMapping("test9")
	public String test9(Car car){
		System.out.println("组合对象的绑定....");
		System.out.println(car);
		return "param";
	}
	
	/**
	 * 1.11List集合对象的绑定
	 * 注意单独的List<Goods>数据对象绑定好像不支持
	 * 访问url:http://localhost:8080/springmvcdemo/param/test10?id=001&user.id=12&user.name=casper&user.age=18&goodsList[0].id=23&goodsList[0].name=whh&goodsList[0].desc=nice
	 */
	@RequestMapping("test10")
	public String test10(Car car){
		System.out.println("List集合对象的绑定");
		for(Goods goods:car.getGoodsList()){
			System.out.println(goods);
		}
		return "param";
	}
	
	/**
	 * 1.12java.util.Map参数类型的绑定
	 * 注意单独的Map<String,String>好像不支持参数绑定
	 * 访问url:http://localhost:8080/springmvcdemo/param/test11?maps[name]=casper&maps[age]=13
	 */
	@RequestMapping("test11")
	public String test11(Car car){
		System.out.println("Map参数类型的绑定");
		for(String str :car.getMaps().keySet()){
			System.out.println(str+"   ----  " +car.getMaps().get(str));
		}
		return "param";
	}
}
