package com.ujiuye.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujiuye.javabean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/stuservlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student1 = new Student(1,"jim",19);
        Student student2 = new Student(2,"tom",39);
        Student student3 = new Student(3,"tim",29);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        ObjectMapper mapper = new ObjectMapper();
        String res = mapper.writeValueAsString(list);
        System.out.println("res = " + res);
        resp.getWriter().print(res);
        resp.getWriter().close();
    }
}
