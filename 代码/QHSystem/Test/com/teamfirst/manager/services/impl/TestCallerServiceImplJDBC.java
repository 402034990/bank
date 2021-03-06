package com.teamfirst.manager.services.impl;

import java.util.List;

import com.taketicket.entity.Caller;
import com.taketicket.manager.services.impl.CallerServiceImplJDBC;

public class TestCallerServiceImplJDBC {

	private static CallerServiceImplJDBC callerServiceImplJDBC = new CallerServiceImplJDBC();

	private static Caller caller = new Caller("a", "李四", "aaaa");

	public static void main(String[] args) {

		TestCallerServiceImplJDBC.queryAllTest();
	}

	public static void queryAllTest() {

		List<Caller> callers = TestCallerServiceImplJDBC.callerServiceImplJDBC
				.queryAll();

		for (Caller caller : callers) {
			System.out.println(caller.getAccount());
			System.out.println(caller.getName());
			System.out.println(">>>>>>>>>>>>>>>>>>");
		}
	}

	public static void queryByNameTest() {

		// Caller caller1 = TestCallerServiceImplJDBC.callerServiceImplJDBC
		// .queryByName(TestCallerServiceImplJDBC.caller.getName());

		// if (caller1 == null) {
		// System.out.println("查询失败");
		// return;
		// }
		// System.out.println(caller1.getId());
		// System.out.println(caller1.getName());
		// System.out.println(caller1.getAccount());
		// System.out.println(caller1.getPassword());
	}

	public static void queryByAccountTest() {

		Caller caller1 = TestCallerServiceImplJDBC.callerServiceImplJDBC
				.queryByAccount(TestCallerServiceImplJDBC.caller.getAccount());

		if (caller1 == null) {
			System.out.println("查询失败");
			return;
		}
		System.out.println(caller1.getId());
		System.out.println(caller1.getName());
		System.out.println(caller1.getPassword());
	}

	public static void updatePasswordByAccountTest() {

		int rows = TestCallerServiceImplJDBC.callerServiceImplJDBC
				.updatePasswordByAccount(TestCallerServiceImplJDBC.caller);

		if (rows == 1) {
			System.out.println("更新密码成功");
		} else if (rows == 0) {
			System.out.println("更新密码失败");
		} else {
			System.out.println("非法!!");
		}
	}

	public static void deleteCallerByNameTest() {

		int rows = TestCallerServiceImplJDBC.callerServiceImplJDBC
				.deleteCallerByName("    ");
		if (rows == 1) {
			System.out.println("删除成功");
		} else if (rows == 0) {
			System.out.println("删除失败");
		} else {
			System.out.println("非法!!");
		}
	}

	public static void insertCallerTest() {

		int rows = TestCallerServiceImplJDBC.callerServiceImplJDBC
				.insertCaller(TestCallerServiceImplJDBC.caller);
		if (rows == 1) {
			System.out.println("插入成功");
		} else if (rows == 0) {
			System.out.println("插入失败");
		} else {
			System.out.println("非法!!");
		}
	}

	public static void deleteCallerByAccountTest() {

		int rows = TestCallerServiceImplJDBC.callerServiceImplJDBC
				.deleteCallerByAccount(TestCallerServiceImplJDBC.caller
						.getAccount());
		if (rows == 1) {
			System.out.println("删除成功");
		} else if (rows == 0) {
			System.out.println("删除失败");
		} else {
			System.out.println("非法!!");
		}
	}
}
