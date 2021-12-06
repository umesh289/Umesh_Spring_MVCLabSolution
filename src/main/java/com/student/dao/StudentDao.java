package com.student.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.student.beans.Student;  
  
public class StudentDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Student p){  
    String sql="insert into Student(name,department,country) values('"+p.getName()+"',"+p.getDepartment()+",'"+p.getCountry()+"')";  
    return template.update(sql);  
}  
public int update(Student p){  
    String sql="update Student set name='"+p.getName()+"', department="+p.getDepartment()+",country='"+p.getCountry()+"' where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Student where id="+id+"";  
    return template.update(sql);  
}  
public Student getStudentById(int id){  
    String sql="select * from Student where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
}  
public List<Student> getStudents(){  
    return template.query("select * from Student",new RowMapper<Student>(){  
        public Student mapRow(ResultSet rs, int row) throws SQLException {  
            Student e=new Student();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setDepartment(rs.getString(3));  
            e.setCountry(rs.getString(4));  
            return e;  
        }  
    });  
}  
}  