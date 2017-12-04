package com.taketicket.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.taketicket.constant.MyConstant;
import com.taketicket.entity.Ticket;
import com.taketicket.entity.TicketVO;
import com.taketicket.entity.Ticket_Caller_Business_VO;
import com.taketicket.entity.Ticket_TakeDate_VO;
import com.taketicket.server.dao.TicketDAO;
import com.taketicket.server.dao.exception.DAOException;
import com.taketicket.util.jdbc.JDBCTemplate;
import com.taketicket.util.jdbc.RowMapper;

public class TicketDAOImplJDBC implements TicketDAO {

	@Override
	public int insertTicket(Ticket ticket) {

		String[] sqls = { "insert into ticket(id, num, business_id, takeDate, waitCount, takeIP) values(?,?,?,?,?,?)" };

		Object[][] properties = { { ticket.getId(), ticket.getNum(),
				ticket.getBusiness_id(), ticket.getTakeDate(),
				ticket.getWaitCount(), ticket.getTakeIp() } };

		return this.update(sqls, properties);
	}

	@Override
	public int updateById(Ticket ticket) {

		String[] sqls = { "update ticket set callerId = ?,isCalled = ?, isSuccess = ?, caller_name = ? where id = ?" };

		Object[][] properties = { { ticket.getCaller_id(),
				ticket.getIsCalled(), ticket.getIsSuccess(),
				ticket.getCaller_name(), ticket.getId() } };

		return this.update(sqls, properties);

	}

	@Override
	public Ticket queryByDate(Date date) {

		String sql = "select * from ticket where takeDate = ?";

		Object[] properties = { date };

		List<Ticket> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public Ticket queryById(int id) {

		String sql = "select * from ticket where id = ?";

		Object[] properties = { id };

		List<Ticket> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public Ticket queryByBusinessId(int businessId) {

		String sql = "select * from ticket where business_id = ?";

		Object[] properties = { businessId };

		List<Ticket> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public List<Ticket> queryAll() {

		String sql = "select * from ticket";

		Object[] properties = {};

		return this.query(sql, properties);
	}

	private List<Ticket> query(String sql, Object[] properties) {
		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						Ticket ticket = new Ticket();

						try {

							ticket.setId(resultSet.getInt("id"));
							ticket.setNum(resultSet.getInt("num"));
							ticket.setBusiness_id(resultSet
									.getInt("business_id"));
							ticket.setTakeDate(resultSet.getDate("takeDate"));
							ticket.setWaitCount(resultSet.getInt("waitCount"));
							ticket.setTakeIp(resultSet.getString("takeIP"));
							ticket.setCaller_id(resultSet.getInt("callerId"));
							ticket.setIsCalled(resultSet.getInt("isCalled"));
							ticket.setIsSuccess(resultSet.getInt("isSuccess"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return ticket;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	private int update(String[] sqls, Object[][] properties) {
		boolean success = JDBCTemplate.update(sqls, properties);

		if (success) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Ticket> queryTicketsByBusinessId(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from ticket where business_id = ?";
		// , isCalled = 0
		Object[] properties = { id };

		List<Ticket> list = this.query(sql, properties);

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public List<Ticket> queryAllByisCalled(int isCalled) {
		// TODO Auto-generated method stub
		String sql = "select * from ticket where isCalled=? ";

		Object[] properties = { isCalled };

		return this.query(sql, properties);

	}

	@Override
	public void updateByid(int id) {
		// TODO Auto-generated method stub
		String[] sqls = { "update ticket set  isCalled = ? where id = ?" };

		Object[][] properties = { { MyConstant.IS_CALLED, id } };
		this.update(sqls, properties);
	}

	@Override
	public List<TicketVO> queryLogByTicketVO() {

		String sql = "SELECT DATE(ticket.takeDate),ticket.takeIP,caller.name,business.name,count(*)"
				+ " FROM ticket,business,caller"
				+ " WHERE ticket.business_id = business.id AND caller.id = ticket.callerId AND  ticket.isCalled = 1"
				+ " GROUP BY DATE(ticket.takeDate),business.name,caller.name ORDER BY DATE(ticket.takeDate)";

		Object[] properties = {};

		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						TicketVO ticketVO = new TicketVO();

						try {

							ticketVO.setBusiness_name(resultSet
									.getString("business.name"));
							ticketVO.setCaller_name(resultSet
									.getString("caller.name"));
							ticketVO.setTicket_takeDate(resultSet
									.getDate("DATE(ticket.takeDate)"));
							ticketVO.setTicket_takeIP(resultSet
									.getString("ticket.takeIP"));
							ticketVO.setCount(resultSet.getInt("count(*)"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return ticketVO;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}

	}

	@Override
	public List<Ticket_Caller_Business_VO> queryDataByTicket_Caller_Business_VO() {

		String sql = "select caller.name, caller.id, window.num, business.name,ticket.isCalled,ticket.isSuccess "
				+ " from caller, window, business, ticket WHERE ticket.callerId = caller.id"
				+ " AND window.business_id = business.id"
				+ " AND business.id = ticket.business_id";

		Object[] properties = {};

		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						Ticket_Caller_Business_VO ticketVO = new Ticket_Caller_Business_VO();

						try {

							ticketVO.setBusiness_name(resultSet
									.getString("business.name"));
							ticketVO.setCaller_name(resultSet
									.getString("caller.name"));
							ticketVO.setCaller_id(resultSet.getInt("caller.id"));
							ticketVO.setWindow_num(resultSet
									.getInt("window.num"));
							ticketVO.setIsCalled(resultSet
									.getInt("ticket.isCalled"));
							ticketVO.setSuccess(resultSet
									.getInt("ticket.isSuccess"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return ticketVO;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public List<Ticket_TakeDate_VO> queryDataByTicket_Caller_Business_VO1() {

		String sql = "select  ticket.takeDate, window.num, business.name,ticket.isCalled,ticket.isSuccess "
				+ " from ticket, window, business WHERE "
				+ " ticket.isCalled =1 AND window.business_id = business.id"
				+ " AND business.id = ticket.business_id";

		Object[] properties = {};

		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						Ticket_TakeDate_VO ticketVO = new Ticket_TakeDate_VO();

						try {

							ticketVO.setTicket_takeDate(resultSet
									.getDate("takeDate"));
							ticketVO.setBusiness_name(resultSet
									.getString("business.name"));
							ticketVO.setWindow_num(resultSet
									.getInt("window.num"));
							ticketVO.setIsCalled(resultSet
									.getInt("ticket.isCalled"));
							ticketVO.setSuccess(resultSet
									.getInt("ticket.isSuccess"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return ticketVO;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public List<TicketVO> queryDataByTicketVO() {

		String sql = "SELECT ticket.takeDate,ticket.takeIP,caller.name,"
				+ " business.name, ticket.isCalled FROM ticket,business,caller WHERE"
				+ " ticket.business_id = business.id"
				+ " AND caller.id = ticket.callerId";

		Object[] properties = {};

		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						TicketVO ticketVO = new TicketVO();

						try {

							ticketVO.setBusiness_name(resultSet
									.getString("business.name"));
							ticketVO.setCaller_name(resultSet
									.getString("caller.name"));
							ticketVO.setTicket_takeDate(resultSet
									.getDate("ticket.takeDate"));
							ticketVO.setTicket_takeIP(resultSet
									.getString("ticket.takeIP"));
							ticketVO.setIsCalled(resultSet.getInt("isCalled"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return ticketVO;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public List<TicketVO> queryCheckByTicketVO(int key) {

		String sql = "";
		Object[] properties = {};
		switch (key) {
		case 1: {// ���ղ�ѯ
			sql = "SELECT Date(ticket.takeDate) as date,business.name, count(*)"
					+ " FROM ticket,business"
					+ " WHERE ticket.business_id = business.id"
					+ " GROUP BY Date(ticket.takeDate), business.name"
					+ " ORDER BY Date(ticket.takeDate)";

			break;
		}
		case 2: { // ���²�ѯ
			sql = "SELECT Date(ticket.takeDate) as date,business.name, count(*)"
					+ " FROM ticket,business"
					+ " WHERE ticket.business_id = business.id"
					+ " GROUP BY YEAR(ticket.takeDate),MONTH(ticket.takeDate), business.name"
					+ " ORDER BY Date(ticket.takeDate)";

			break;
		}
		case 3: { // �����Ȳ�ѯ
			sql = "SELECT Date(ticket.takeDate) as date,business.name, count(*)"
					+ " FROM ticket,business"
					+ " WHERE ticket.business_id = business.id"
					+ " GROUP BY YEAR(ticket.takeDate),QUARTER(ticket.takeDate), business.name"
					+ " ORDER BY Date(ticket.takeDate)";

			break;
		}
		case 4: { // �����ѯ
			sql = "SELECT Date(ticket.takeDate) as date,business.name, count(*)"
					+ " FROM ticket,business"
					+ " WHERE ticket.business_id = business.id"
					+ " GROUP BY YEAR(ticket.takeDate), business.name"
					+ " ORDER BY Date(ticket.takeDate)";

			break;
		}
		case 5: {

			sql = "SELECT Date(ticket.takeDate) as date,business.name, count(*)"
					+ " FROM ticket,business"
					+ " WHERE ticket.business_id = business.id"
					+ " GROUP BY business.name";

			break;
		}

		default:
			break;
		}

		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						TicketVO ticketVO = new TicketVO();

						try {

							ticketVO.setBusiness_name(resultSet
									.getString("business.name"));

							ticketVO.setTicket_takeDate(resultSet
									.getDate("date"));

							ticketVO.setCount(resultSet.getInt("count(*)"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());

						}
						return ticketVO;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public int updateByID(Ticket ticket) {

		String[] sqls = { "update ticket set num = ?,takeIp=?,isCalled=?,callerId= ?, isSuccess = ?, caller_name = ? where id = ?" };

		Object[][] properties = { { ticket.getNum(), ticket.getTakeIp(),
				ticket.getIsCalled(), ticket.getCaller_id(),
				ticket.getIsSuccess(), ticket.getCaller_name(), ticket.getId() } };

		return this.update(sqls, properties);

	}

	@Override
	public List<Ticket_Caller_Business_VO> queryDataByTicket_Caller_Business_VO2() {

		String sql = "select  ticket.takeDate, window.num, business.name,ticket.isCalled,ticket.isSuccess "
				+ " from ticket, window, business WHERE "
				+ " ticket.isCalled =1 AND window.business_id = business.id"
				+ " AND business.id = ticket.business_id";

		Object[] properties = {};

		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						Ticket_Caller_Business_VO ticketVO = new Ticket_Caller_Business_VO();

						try {

							ticketVO.setTicket_takeDate(resultSet
									.getDate("takeDate"));
							ticketVO.setBusiness_name(resultSet
									.getString("business.name"));
							ticketVO.setWindow_num(resultSet
									.getInt("window.num"));
							ticketVO.setIsCalled(resultSet
									.getInt("ticket.isCalled"));
							ticketVO.setSuccess(resultSet
									.getInt("ticket.isSuccess"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return ticketVO;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	public List<TicketVO> querySuccessByTicketVO(int success) {

		String sql = "SELECT Date(ticket.takeDate),business.name,isSuccess,count(*)"
				+ " FROM ticket,business"
				+ " WHERE ticket.business_id = business.id AND isSuccess = ? "
				+ " GROUP BY Date(ticket.takeDate), business.name"
				+ " ORDER BY Date(ticket.takeDate)";

		Object[] properties = { success };

		List list = JDBCTemplate.queryByProperties(sql, properties,
				new RowMapper() {
					@Override
					public Object mapRow(ResultSet resultSet) {

						TicketVO ticketVO = new TicketVO();

						try {

							ticketVO.setBusiness_name(resultSet
									.getString("business.name"));

							ticketVO.setTicket_takeDate(resultSet
									.getDate("Date(ticket.takeDate)"));

							ticketVO.setCount(resultSet.getInt("count(*)"));

						} catch (SQLException e) {

							throw new DAOException(e.getMessage());
						}
						return ticketVO;
					}
				});

		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

}
