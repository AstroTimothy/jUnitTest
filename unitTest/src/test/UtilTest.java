package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import common.Util;
import exception.DateLengthException;

public class UtilTest {

	@Test
	public void emptyBlankTest() {
		String result = Util.emptyBlank("Test String");
		
		assertThat(result, is("Test String"));
		assertThat(Util.emptyBlank(null), is(""));
		assertThat(Util.emptyBlank(1), is("1"));
		assertThat(Util.emptyBlank(0), is(""));
	}

	@Test
	public void splitTest () {
		String str = "boo:and:foo";
		
		String[] result = str.split(":");
		assertThat(result[0], is("boo"));
		assertThat(result[1], is("and"));
		assertThat(result[2], is("foo"));
		assertThat(result.length, is(3));
		
	}
	
	@Test
	public void splitTest2() {
		String str = "boo:and:foo";

		String[] result1 = str.split(":and:");
		assertThat(result1[0], is("boo"));
		assertThat(result1[1], is("foo"));
		assertThat(result1.length, is(2));
	}
	
	@Test
	public void equalsTest() {
		String a = "hello!";
		String b = new String("hello!");
		
		assertThat(a.equals(b), is(true));
	}
	
	@Test
	public void equalsTest2() {
		String a = "hello!";
		String b = new String("hello!");
		
		assertThat((a == b), is(false));
	}
	
	@Test
	public void equalsTest3() {
		String a = "hello!";
		String b = "hello!";
		
		assertThat((a == b), is(true));
	}
	
//	���� TDD
	@Test
	public void dateFormatTest() {
		
//		given
//		DB���� 8�ڸ��� ��¥�� ����
		String creDate = "19861206";
		
		
//		when
		String viewDate = ""; 
//		1. ���ڿ��� 4, 2, 2�� �ڸ� �� '-'����
		String yyyy = creDate.substring(0, 4);
		String mm = creDate.substring(4, 6);
		String dd = creDate.substring(6, 8);
		
		viewDate = yyyy + "-" + mm + "-" + dd;
		
//		2. SimpleDateFormat Ŭ���� ���
		
		
//		then
//		ȭ�鿡�� YYYY-MM-DD�� ���� �������� ��µ�
		assertThat(viewDate, is("1986-12-06"));
	}
	
	@Test
	public void dateFormatTest2() throws Exception {
		
//		given
//		DB���� 8�ڸ��� ��¥�� ����
		String creDate = "19861206";
		
		String viewDate = Util.dateFormat(creDate);
		
//		2. SimpleDateFormat Ŭ���� ���
		
		
//		then
//		ȭ�鿡�� YYYY-MM-DD�� ���� �������� ��µ�
		assertThat(viewDate, is("1986-12-06"));
	}
	
	@Test
	public void dateFormatTest3() throws Exception {
		String creDate = null;
		String result = Util.dateFormat(creDate);
	
		assertThat(result, is("1986-12-06"));
	}
	
	@Test(expected=DateLengthException.class)
	public void dateFormatTest4() throws DateLengthException {
		String creDate = "1986120610";
		String result = Util.dateFormat(creDate);
		
		assertThat(result, is("8�ڸ��� �ƴմϴ�."));
		
	}
	
	@Test
	public void substringTest() {
		String creDate = "19861206";

		assertThat(creDate.substring(0,4), is("1986"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
