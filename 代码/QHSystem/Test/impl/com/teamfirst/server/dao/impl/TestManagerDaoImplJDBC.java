package impl.com.teamfirst.server.dao.impl;

import com.taketicket.server.dao.impl.ManagerDAOImplJDBC;

public class TestManagerDaoImplJDBC {

	private static ManagerDAOImplJDBC managerDaoImplJDBC = new ManagerDAOImplJDBC();

	public static void main(String[] args) {
		TestManagerDaoImplJDBC.queryByAccountTest();
	}

	public static void queryByAccountTest() {
		// ���Ӳ��ԵĴ���
		TestManagerDaoImplJDBC.managerDaoImplJDBC.queryByAccount(null);
	}

}
