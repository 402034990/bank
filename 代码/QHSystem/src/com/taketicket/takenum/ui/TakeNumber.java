package com.taketicket.takenum.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.taketicket.constant.Flavor;
import com.taketicket.constant.MyConstant;
import com.taketicket.entity.Business;
import com.taketicket.entity.Ticket;
import com.taketicket.manager.services.impl.BusinessServiceImplJDBC;
import com.taketicket.manager.services.impl.TicketServiceImplJDBC;
import com.taketicket.util.ui.AutoChangeFlavor;
import com.taketicket.util.ui.DrawClockPanel;

public class TakeNumber extends JFrame {

	private JPanel contentPane;
	private PrintTicket printTicket;

	private JLabel picLabel;
	// 修改局部变量！
	JButton vipButton;
	JButton commonButton;
	JButton publicButton;

	public JLabel getPicLabel() {
		return this.picLabel;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TakeNumber frame = new TakeNumber();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TakeNumber() {

		try {
			UIManager.setLookAndFeel(Flavor.FLAVOR_PATH);
		} catch (Exception e1) {
			System.out.println("change flavor fail");
		}

		this.setResizable(false);
		this.setTitle("\u53D6\u53F7\u7AEF");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 794, 572);
		this.contentPane.add(layeredPane);

		this.vipButton = new JButton("VIP业务");

		this.vipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				TakeNumber.this.btnNewButtonActionPerformed(e);
			}

		});
		this.vipButton.setBounds(600, 94, 153, 53);
		layeredPane.add(this.vipButton);

		this.commonButton = new JButton("\u666E\u901A\u4E1A\u52A1");
		this.commonButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TakeNumber.this.btnNewButton_1ActionPerformed(e);
			}

		});
		this.commonButton.setBounds(600, 185, 153, 53);
		layeredPane.add(this.commonButton);

		this.publicButton = new JButton("\u5BF9\u516C\u4E1A\u52A1");
		this.publicButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TakeNumber.this.btnNewButton_2ActionPerformed(e);
			}

		});
		this.publicButton.setBounds(600, 285, 153, 53);
		layeredPane.add(this.publicButton);

		DrawClockPanel clockPanel = new DrawClockPanel();
		clockPanel.setBounds(0, 208, 500, 364);
		// clockPanel.setBackground(null);
		clockPanel.setOpaque(false);
		layeredPane.add(clockPanel);
		new Thread(clockPanel).start();

		this.picLabel = new JLabel("");
		this.picLabel.setIcon(new ImageIcon(TakeNumber.class
				.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.picLabel.setBounds(0, 0, 794, 572);
		layeredPane.add(this.picLabel);

		new AutoChangeFlavor(this.picLabel).autoChangeFlavor();

		this.setLocationRelativeTo(null);// 窗口在屏幕中间显示
	}

	private void btnNewButtonActionPerformed(ActionEvent e) {
		if (this.printTicket == null) {
			System.out.println("创建printTicket对象");
			this.printTicket = new PrintTicket();
		}
		// 获取按钮上业务类型
		this.printTicket.getBusinessTypeLabel().setText(
				this.vipButton.getText());

		TicketServiceImplJDBC tsi = new TicketServiceImplJDBC();
		// 根据 button 上 text 判断业务类型
		BusinessServiceImplJDBC bsi = new BusinessServiceImplJDBC();

		Business business = bsi.queryByName(this.vipButton.getText());

		if (business == null || business.getDisabled() == MyConstant.DISABLED) {
			JOptionPane.showMessageDialog(null, "该业务暂时停止办理");
			return;
		}

		int businessId = business.getId();

		// int businessId = bsi.queryByName(this.vipButton.getText()).getId();
		List<Ticket> all = tsi.queryAll();
		List<Ticket> list = tsi.queryTicketsByBusinessId(businessId);
		if (all == null) {
			// 异常处理
			Ticket t = new Ticket(1, -1, businessId, 1, new Date(), 1, "-1", 1,
					1, "-1");
			tsi.insertTicket(t);

			// System.out.println("+++++++++++++++++++++++++++");
			this.printTicket.getticketNumLabel().setText("" + 1);
			this.printTicket.getwaitNumLabel().setText("0"); // 处理第一张小票
		} else {
			int id = all.get(all.size() - 1).getId() + 1;
			// System.out.println("id= " + id);
			// 点击按钮插入一个数据 businessId
			Ticket t = new Ticket(id, -1, businessId, 1, new Date(), 1, "-1",
					1, 1, "-1");
			// System.out.println((list == null) + "-------" + businessId);
			if (list == null) {
				tsi.insertTicket(t);
				this.printTicket.getticketNumLabel().setText("" + t.getId());
				this.printTicket.getwaitNumLabel().setText("0");
				this.printTicket.setVisible(true);
				return;
			}

			int m = 0;
			int ticketCount = 1;
			for (Ticket ticket : list) {
				if (ticket.getIsCalled() == MyConstant.IS_NOT_CALLED) {
					m++;
				}
				ticketCount++;
			}
			// System.out.println(ticketCount);
			if (ticketCount > business.getLimitCount()) {
				JOptionPane.showMessageDialog(null, "该业务暂时停止办理");
				return;
			}

			tsi.insertTicket(t);
			this.printTicket.getticketNumLabel().setText("" + (id));

			// int m = 0;
			// for (Ticket ticket : list) {
			// if (ticket.getIsCalled() == MyConstant.IS_NOT_CALLED) {
			// m++;
			// }
			// }
			// System.out.println("m == " + m);
			this.printTicket.getwaitNumLabel().setText("" + (m));
		}
		this.printTicket.setVisible(true);
	}

	private void btnNewButton_1ActionPerformed(ActionEvent e) {
		if (this.printTicket == null) {
			System.out.println("创建printTicket对象");
			this.printTicket = new PrintTicket();
		}
		this.printTicket.getBusinessTypeLabel().setText(
				this.commonButton.getText());

		TicketServiceImplJDBC tsi = new TicketServiceImplJDBC();
		// 根据 button 上 text 判断业务类型
		BusinessServiceImplJDBC bsi = new BusinessServiceImplJDBC();

		Business business = bsi.queryByName(this.commonButton.getText());

		if (business == null || business.getDisabled() == MyConstant.DISABLED) {
			JOptionPane.showMessageDialog(null, "该业务暂时停止办理");
			return;
		}

		int businessId = business.getId();
		List<Ticket> all = tsi.queryAll();
		if (all == null) {
			// 异常处理
			Ticket t = new Ticket(1, -1, businessId, 1, new Date(), 1, "-1", 1,
					1, "-1");
			tsi.insertTicket(t);
			this.printTicket.getticketNumLabel().setText("" + 1);
			this.printTicket.getwaitNumLabel().setText("0");
		} else {

			int id = all.get(all.size() - 1).getId() + 1;
			// System.out.println("id= " + id);
			// 点击按钮插入一个数据 businessId
			Ticket t = new Ticket(id, -1, businessId, 1, new Date(), 1, "-1",
					1, 1, "-1");
			List<Ticket> list = tsi.queryTicketsByBusinessId(businessId);
			// System.out.println((list == null) + "-------" + businessId);
			if (list == null) {
				tsi.insertTicket(t);
				this.printTicket.getticketNumLabel().setText("" + t.getId());
				this.printTicket.getwaitNumLabel().setText("0");
				this.printTicket.setVisible(true);
				return;
			}
			int m = 0;
			int ticketCount = 1;
			for (Ticket ticket : list) {
				if (ticket.getIsCalled() == MyConstant.IS_NOT_CALLED) {
					m++;
				}
				ticketCount++;
			}
			// System.out.println(ticketCount);
			if (ticketCount > business.getLimitCount()) {
				JOptionPane.showMessageDialog(null, "该业务暂时停止办理");
				return;
			}

			tsi.insertTicket(t);

			this.printTicket.getticketNumLabel().setText("" + (id));
			// System.out.println("m == " + m);
			this.printTicket.getwaitNumLabel().setText("" + (m));
		}
		this.printTicket.setVisible(true);
	}

	private void btnNewButton_2ActionPerformed(ActionEvent e) {
		if (this.printTicket == null) {
			System.out.println("创建printTicket对象");
			this.printTicket = new PrintTicket();
		}

		// 获取按钮上的业务类型

		this.printTicket.getBusinessTypeLabel().setText(
				this.publicButton.getText());
		TicketServiceImplJDBC tsi = new TicketServiceImplJDBC();

		BusinessServiceImplJDBC bsi = new BusinessServiceImplJDBC();

		Business business = bsi.queryByName(this.publicButton.getText());

		if (business == null || business.getDisabled() == MyConstant.DISABLED) {
			JOptionPane.showMessageDialog(null, "该业务暂时停止办理");
			return;
		}

		int businessId = business.getId();

		List<Ticket> all = tsi.queryAll();

		if (all == null) {
			// 异常处理
			// System.out.println(list == null);
			Ticket t = new Ticket(1, -1, businessId, 1, new Date(), 1, "-1", 1,
					1, "-1");
			tsi.insertTicket(t);

			this.printTicket.getticketNumLabel().setText("" + 1);
			this.printTicket.getwaitNumLabel().setText("0");
		} else {
			// System.out.println((list == null)+"qqqqqqqqqq");
			int id = all.get(all.size() - 1).getId() + 1;
			// System.out.println("id= " + id);
			// 点击按钮插入一个数据 businessId
			Ticket t = new Ticket(id, -1, businessId, 1, new Date(), 1, "-1",
					1, 1, "-1");
			List<Ticket> list = tsi.queryTicketsByBusinessId(businessId);
			// System.out.println((list == null) + "-------" + businessId);
			if (list == null) {
				tsi.insertTicket(t);
				this.printTicket.getticketNumLabel().setText("" + t.getId());
				this.printTicket.getwaitNumLabel().setText("0");
				this.printTicket.setVisible(true);
				return;
			}

			int m = 0;
			int ticketCount = 1;
			for (Ticket ticket : list) {
				if (ticket.getIsCalled() == MyConstant.IS_NOT_CALLED) {
					m++;
				}
				ticketCount++;
			}
			// System.out.println(ticketCount);
			if (ticketCount > business.getLimitCount()) {
				JOptionPane.showMessageDialog(null, "该业务暂时停止办理");
				return;
			}
			tsi.insertTicket(t);
			// int n = 0;//用于存储全部票数
			// for(int i = 0; i < list.size(); i++) {
			// n++;
			// }
			// System.out.println(n);
			this.printTicket.getticketNumLabel().setText("" + (id));
			// printTicket.getwaitNumLabel().setText(""+(n));

			// int m = 0;
			// for (Ticket ticket : list) {
			// if (ticket.getIsCalled() == MyConstant.IS_NOT_CALLED) {
			// m++;
			// }
			// }
			// System.out.println("m == " + m);
			this.printTicket.getwaitNumLabel().setText("" + (m));
		}
		this.printTicket.setVisible(true);
		// //点击按钮插入一个数据 businessId
		// Ticket t = new Ticket(1,businessById,3,new
		// Date(),1,"1111",1,1,"1111");
		// tsi.insertTicket(t);
		// //通过 businessId (类别 public) 查询数据id id叠加生成小票的号数
		// List<Ticket> list = tsi.queryTicketsByBusinessId(businessById);
		// int n = 0;
		// for(int i = 0; i < list.size(); i++) {
		// n++;
		// }
		// System.out.println(n);
		// printTicket.getticketNumLabel().setText(""+n);
		// printTicket.getwaitNumLabel().setText(""+(n-1));
		// //查询还有多人等候
		// CallNumServiceImplJDBC csi = new CallNumServiceImplJDBC();
		//
		// List<Ticket> list1 = csi.queryTicketAllByisCalled(1); //所有已叫过号的！！！
		// List<Ticket> list2 = new ArrayList<Ticket>(); //用于存放一种业务 已经被叫过的号
		//
		// if(list1 == null){
		// System.out.println("全部人都在排队没有一个被叫过号");
		// return;
		// }
		//
		// for(int i = 0;i<list1.size();i++){
		// if(list1.get(i).getBusiness_id() ==
		// bsi.queryByName(publicButton.getText()).getId()){
		// list2.add(list1.get(i)); //得出被叫过号的business_id为 对公业务 类型的 存入 list2中
		// }
		// }
		// if(list2.size()==0){
		// System.out.println("业务为对公业务的号数一个也没有被叫过");
		// return;
		// }
		//
		// int a = 0 ; //a：已被叫人数
		// for(int i = 0; i< list2.size();i++){
		// a++;
		// }
		// System.out.println(a);
		// int m = n-a ;
		// printTicket.getwaitNumLabel().setText(""+(m-1));

	}

	public void updateFlavor() {
		try {
			UIManager.setLookAndFeel(Flavor.FLAVOR_PATH);
		} catch (Exception e1) {
			System.out.println("change flavor fail");
		}
		SwingUtilities.updateComponentTreeUI(this.getContentPane());
	}
}
