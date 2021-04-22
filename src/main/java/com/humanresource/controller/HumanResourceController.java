package com.humanresource.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.humanresource.apicaller.ApiCaller;
import com.humanresource.dao.HrLoginDao;
import com.humanresource.entities.Employee;
import com.humanresource.entities.HrLoginEntity;

@Controller
@RequestMapping("/hrmanager")
public class HumanResourceController {

    @Autowired
    private HrLoginDao hrLoginDao;
    @Autowired
    private ApiCaller apiCaller;
    
    @RequestMapping({"/","/log"})
    public String Log() {
        return "login";
    }
    @SuppressWarnings("null")
    @RequestMapping("/welcome")
    public ModelAndView login(@ModelAttribute("HrLoginEntity") HrLoginEntity entity,HttpServletRequest request) {
        ModelAndView modelAndView=new ModelAndView();
        HttpSession session=request.getSession();
        
        System.out.println(session.getAttribute("logout"));
        if(session.getAttribute("logout")==null && this.hrLoginDao.checkPassword(entity))
        {
            session=request.getSession();
            System.out.println("hello1");
            session.setAttribute("email", entity.getUsername());
            System.out.println(entity.getUsername());
            modelAndView.addObject("user",entity.getUsername());
            modelAndView.addObject("list",this.apiCaller.getEmployees());
            modelAndView.setViewName("welcome");
            entity=null;
            return modelAndView;
        }
        session.removeAttribute("logout");
        System.out.println("hello3");
        modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
    @RequestMapping("/add")
    public ModelAndView addEmployee(HttpSession session) {
        ModelAndView modelAndView=new ModelAndView();
        if(session.getAttribute("email")==null)
        {
            modelAndView.setViewName("login");
            return modelAndView;
        }else {
            modelAndView.setViewName("addEmployee");
        }
        return modelAndView;
    }
    
    @RequestMapping(value="/save",method=RequestMethod.POST)
    private ModelAndView saveEmployee(@ModelAttribute("Employee")Employee employee,HttpSession  session) {
        ModelAndView modelAndView=new ModelAndView();
        System.out.println(employee);
        if(session.getAttribute("email")==null)
        {
            System.out.println("not saving");
            modelAndView.setViewName("login");
            
        }else {
            System.out.println("Saving details");
            this.apiCaller.addEmployee(employee);
            modelAndView.addObject("list",this.apiCaller.getEmployees());
            modelAndView.setViewName("welcome");
        }
        return modelAndView;
    }
    
    @RequestMapping(value="/editEmployee",method=RequestMethod.POST)
    private ModelAndView editEmployee(@RequestParam("employeeCode") int code,HttpSession session) {
        ModelAndView modelAndView=new ModelAndView();
        
        if(session.getAttribute("email")==null)
        {
            System.out.println("not saving");
            modelAndView.setViewName("login");
            
        }else {
            System.out.println("Saving details");
            modelAndView.addObject("code", code);
            modelAndView.setViewName("editEmployee");
        }
        return modelAndView;
    }
    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        ModelAndView modelAndView=new ModelAndView();
        if(session.getAttribute("email")!=null) {
            System.out.println("logout aalo");
            session.removeAttribute("email");
            System.out.println(session.getAttribute("email"));
            session.setAttribute("logout", "logout");

            modelAndView.setViewName("login");
        }else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
        
    }
    
    @RequestMapping("/deleteEmployee")
    public ModelAndView delete(@RequestParam("employeeCode") int id) {
        ModelAndView modelAndView=new ModelAndView();
        this.apiCaller.deleteEmployee(id);
        modelAndView.addObject("list",this.apiCaller.getEmployees());
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
    
    @RequestMapping("/download")
    public void download(HttpServletRequest req,HttpServletResponse res) throws IOException {
        this.apiCaller.downloadList(req, res);
    }
}
