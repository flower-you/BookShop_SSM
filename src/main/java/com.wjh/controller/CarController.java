package com.wjh.controller;

import com.wjh.bean.TBook;
import com.wjh.bean.TShopcar;
import com.wjh.bean.TUser;
import com.wjh.service.IBookService;
import com.wjh.service.ICarService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:   17976
 * Date:     2019/2/11 19:12
 * Description: 购物车控制类
 */
@Controller
public class CarController {
    @Autowired
    private ICarService carService;
    @Autowired
    private IBookService bookService;

    //Ajax方式请求后台时，未登录访问购物车被拦截，ajax请求失败，但是一直在请求？所以被拦截之后拦截器无法跳转到登录页面
    @ResponseBody//将函数返回值作为请求返回值，没有这个注解的话，请求的响应应该是一个页面，不需要页面的话应该加上这个注解。
    @RequestMapping(value = "addToCar",method = RequestMethod.POST)
    public Map<String,String> addToCar(TShopcar tShopcar) throws ServletException, IOException {
        System.out.println("-----addToCar-----"+tShopcar);
        Map<String,String> map=new HashMap<String,String>();
        map.put("bid",tShopcar.getBid().toString());
        boolean flag=carService.addBook(tShopcar);
        if(flag){
            System.out.println("添加成功");
        //网站端跳转到添加成功的页面，如果是手机端不用跳转
            map.put("res","addSuccess?bid=");
        }
        else {
            //添加失败，购物车已满！
            map.put("res","carbookDetail?bid=");
        }
        System.out.println("carController addToCar map===>"+map.get("res"));
        return map;
    }

    @RequestMapping(value = "addSuccess",method=RequestMethod.GET)
    public  String addSuccess(int bid,HttpServletRequest request){
        TBook book=bookService.selectBookById(bid);
        request.setAttribute("book",book);
        HttpSession session=request.getSession();
        TUser user=(TUser)session.getAttribute("user");
        List<TShopcar> bookList=carService.QueryCar(user.getId());
       request.setAttribute("shopCount",bookList.size());
        return "car/addSuccess";
    }

    @RequestMapping(value = "carbookDetail",method=RequestMethod.GET)
    public  String addFail(int bid,Model model){
        TBook book=bookService.selectBookById(bid);
        model.addAttribute("book",book);
        return "book/bookDetail";
    }

    @RequestMapping(value = "queryCar",method = RequestMethod.GET)
    public String queryCar(int uid,Model model){
        List<TShopcar> bookInCar=carService.QueryCar(uid);
        //查出TShopcar需要用到的属性有num即商品的件数，还有bid，需要根据bid去查找出对应的book
        //<书，书的件数>
         Map shopCarList=new HashMap<TBook,Integer>();
         for (TShopcar shopcar:bookInCar){
             shopCarList.put(bookService.selectBookById(shopcar.getBid()),shopcar.getNum());
         }
        model.addAttribute("shopCarList",shopCarList);
        return "car/shopcarList";
    }
}
