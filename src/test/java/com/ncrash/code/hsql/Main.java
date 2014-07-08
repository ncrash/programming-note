package com.ncrash.code.hsql;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author Daekwon.Kang
 * @since 2010. 6. 22.
 * @see
 */
public class Main {
	public static void main(String args[]) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"context.xml", Main.class);
		DataSource dataSource = (DataSource) ac.getBean("dataSource");
		// DataSource mysqlDataSource = (DataSource)
		// ac.getBean("mysqlDataSource");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.execute("create table Course (course_id integer, name varchar, course varchar, PRIMARY KEY (course_id)); ");
		jdbcTemplate.batchUpdate(new String[] {
				"insert into Course values (1,'Sam', 'Java');",
				"insert into Course values (2,'peter', 'J2EE');  ",
				"insert into Course values (3,'paul', 'JSF');  ",
				"insert into Course values (4,'jonathan', 'Hibernate');  ",
				"insert into Course values (5,'james', 'Spring');  "});
		int rowCount = jdbcTemplate.queryForInt("select count(0) from Course");
		
		System.out.println(rowCount);
	}
}
