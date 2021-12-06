package com.student.controllers;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.beans.Student;
import com.student.dao.StudentDao;  
@Controller  
public class StudentController {  
    @Autowired  
    StudentDao dao;//will inject dao from xml file  
       
    @RequestMapping("/empform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Student());
    	return "empform"; 
    }  
    
    
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Student emp){  
        dao.save(emp);  
        return "redirect:/viewemp";
    }
    
    @RequestMapping("/viewemp")  
    public String viewemp(Model m){  
    	System.out.println("++++++++viewemp ++++++");
        List<Student> list=dao.getStudents();  
        m.addAttribute("list",list);
        return "viewemp";  
    }  

    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Student emp=dao.getStudentById(id);  
        m.addAttribute("command",emp);
        return "empeditform";  
    } 
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("emp") Student emp){  
        dao.update(emp);  
        return "redirect:/viewemp";  
    }  
    
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewemp";  
    }
}  