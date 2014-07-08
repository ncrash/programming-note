package com.ncrash.code.hsqldb;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.sql.SQLException;

import org.junit.Test;

public class UserDaoTest {

	@Test
	public void addAndGet() throws Exception {

		UserDao dao = new UserDao();

		User user = new User();
		user.setId("younghoe");
		user.setName("안영회");
		user.setPassword("hello");

		dao.add(user);

		User user2 = dao.get(user.getId());

		assertThat(user.getId(), is(user2.getId()));
		assertThat(user.getName(), is(user2.getName()));
		assertThat(user.getPassword(), is(user2.getPassword()));
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		UserDao dao = new UserDao();

		User user = new User();
		user.setId("younghoe");
		user.setName("안영회");
		user.setPassword("hello");

		dao.add(user);

		System.out.println(user.getId() + " 등록 성공");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + " 조회 성공");
	}
}
