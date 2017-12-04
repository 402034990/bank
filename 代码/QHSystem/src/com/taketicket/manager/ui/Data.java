package com.taketicket.manager.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.taketicket.constant.Flavor;
import com.taketicket.entity.Ticket_Caller_Business_VO;
import com.taketicket.entity.Ticket_TakeDate_VO;
import com.taketicket.manager.services.TicketService;
import com.taketicket.manager.services.impl.TicketServiceImplJDBC;
import com.taketicket.util.ui.MyClock;

public class Data extends JFrame {

	private final JPanel contentPane;
	private final JTable table;
	private final JTable table_1 = new JTable();
	private final JTable table_2;
	private final JFrame mainFrame;

	private JTabbedPane tabbedPane;

	private final JLabel picLabel;
	private boolean isFirst = true;

	public JTable getTable_1() {
		return this.table_1;
	}

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// try {
	// UIManager
	// .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	// } catch (Throwable e) {
	// e.printStackTrace();
	// }
	// EventQueue.invokeLater(new Runnable() {
	// @Override
	// public void run() {
	// try {
	// UIManager
	// .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	// Data frame = new Data();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	public JLabel getPicLabel() {
		return this.picLabel;
	}

	/**
	 * Create the frame.
	 */
	public Data(JFrame mainFrame) {
		this.setTitle("\u6570\u636E\u7EDF\u8BA1");

		try {
			UIManager.setLookAndFeel(Flavor.FLAVOR_PATH);
		} catch (Exception e1) {
			System.out.println("change flavor fail");
		}

		this.mainFrame = mainFrame;
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 510, 600);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 504, 572);
		this.contentPane.add(layeredPane);

		this.tabbedPane = new JTabbedPane(SwingConstants.TOP);
		this.tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {

				Data.this.tabbedPaneStateChanged(e);
			}

		});
		this.tabbedPane.setBounds(0, 118, 504, 377);
		layeredPane.add(this.tabbedPane);

		JPanel panel_2 = new JPanel();
		this.tabbedPane.addTab("按人物查询", null, panel_2, null);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 504, 348);
		panel_2.add(scrollPane);

		// this.table_1 = new JTable();
		scrollPane.setViewportView(this.table_1);
		this.table_1.setToolTipText("\u6309\u4EBA\u7269\u67E5\u8BE2\r\n");
		this.table_1.setModel(new DefaultTableModel(new Object[][] {
				{ "", "", "", "", null, null },
				{ null, null, null, null, null, null },
				{ null, null, null, null, null, null },
				{ null, null, null, null, null, null },
				{ null, null, null, null, null, null },
				{ null, null, null, null, null, null },
				{ null, null, null, null, null, null },
				{ null, null, null, null, null, null },
				{ null, null, null, null, null, null },
				{ null, null, null, null, null, null }, }, new String[] {
				"\u59D3\u540D", "\u5DE5\u53F7", "\u6240\u5728\u7A97\u53E3",
				"\u4E3B\u529E\u4E1A\u52A1", "\u6210\u529F\u4EBA\u6570",
				"\u5931\u8D25\u4EBA\u6570" }));

		JPanel panel = new JPanel();
		this.tabbedPane.addTab("按业务查询", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 504, 348);
		panel.add(scrollPane_1);

		this.table = new JTable();
		scrollPane_1.setViewportView(this.table);
		this.table.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "\u4E1A\u52A1\u540D\u79F0",
						"\u529E\u7406\u7A97\u53E3", "\u6210\u529F\u4EBA\u6570",
						"\u5931\u8D25\u4EBA\u6570" }));

		JPanel panel_1 = new JPanel();
		this.tabbedPane.addTab("按时间查询", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 504, 348);
		panel_1.add(scrollPane_2);

		this.table_2 = new JTable();
		scrollPane_2.setViewportView(this.table_2);
		this.table_2.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "\u65F6\u95F4\u6BB5",
						"\u4E1A\u52A1\u7C7B\u578B", "\u6210\u529F\u4EBA\u6570",
						"\u5931\u8D25\u4EBA\u6570" }));

		JButton button = new JButton("\u4E3B\u83DC\u5355");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Data.this.buttonActionPerformed(e);
			}

		});
		button.setBounds(25, 516, 102, 39);
		layeredPane.add(button);

		JLabel clockLabel = new JLabel(MyClock.getDateTime());
		clockLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		MyClock.showTimeAtLabel(clockLabel);
		clockLabel.setBounds(271, 516, 223, 39);
		layeredPane.add(clockLabel);

		this.picLabel = new JLabel("");
		this.picLabel.setIcon(new ImageIcon(Data.class
				.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.picLabel.setBounds(0, 0, 504, 572);
		layeredPane.add(this.picLabel);

		this.setLocationRelativeTo(null);// 窗口在屏幕中间显示
	}

	private void tabbedPaneStateChanged(ChangeEvent e) {

		if (((JTabbedPane) e.getSource()).getSelectedIndex() == 0) {

			if (this.isFirst) {
				this.isFirst = false;
				return;
			}

			TicketService ticketService = new TicketServiceImplJDBC();
			List<Ticket_Caller_Business_VO> list = ticketService
					.queryDataByTicket_Caller_Business_VO();

			if (list == null || list.size() == 0) {
				JOptionPane.showMessageDialog(null, "暂无数据", "警告",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			DefaultTableModel tableModel = (DefaultTableModel) this.table_1
					.getModel();
			tableModel.setRowCount(0);// 清除原有行

			if (list.size() < 26) {
				tableModel.setRowCount(26);
			} else {
				tableModel.setRowCount(list.size());
			}

			Map<Ticket_Caller_Business_VO, Integer> successhMap = new HashMap<Ticket_Caller_Business_VO, Integer>();
			Map<Ticket_Caller_Business_VO, Integer> failedMap = new HashMap<Ticket_Caller_Business_VO, Integer>();

			for (int i = 0; i < list.size(); i++) {

				Ticket_Caller_Business_VO vo = list.get(i);

				if (vo.getSuccess() == 1) {
					if (successhMap.get(vo) == null) {
						successhMap.put(vo, 1);
					} else {
						int count = successhMap.get(vo);
						successhMap.put(vo, count + 1);
					}
				} else {
					if (failedMap.get(vo) == null) {
						failedMap.put(vo, 1);
					} else {
						int count = failedMap.get(vo);
						failedMap.put(vo, count + 1);
					}

					// table123.setValueAt(vo.getIsCalled(), i, 4);

				}

			}

			Set<Ticket_Caller_Business_VO> keySet = successhMap.keySet();
			int i = 0;
			for (Ticket_Caller_Business_VO key : keySet) {
				this.table_1.setValueAt(key.getCaller_name(), i, 0);
				this.table_1.setValueAt(key.getCaller_id(), i, 1);
				this.table_1.setValueAt(key.getWindow_num(), i, 2);
				this.table_1.setValueAt(key.getBusiness_name(), i, 3);
				this.table_1.setValueAt(successhMap.get(key) == null ? 0
						: successhMap.get(key), i, 4);
				this.table_1.setValueAt(failedMap.get(key) == null ? 0
						: failedMap.get(key), i, 5);
				i++;
			}

		} else if (((JTabbedPane) e.getSource()).getSelectedIndex() == 1) {

			TicketService ticketService = new TicketServiceImplJDBC();
			List<Ticket_Caller_Business_VO> list = ticketService
					.queryDataByTicket_Caller_Business_VO2();

			if (list == null || list.size() == 0) {
				JOptionPane.showMessageDialog(null, "暂无数据", "警告",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			DefaultTableModel tableModel = (DefaultTableModel) this.table
					.getModel();
			tableModel.setRowCount(0);// 清除原有行

			if (list.size() < 26) {
				tableModel.setRowCount(26);
			} else {
				tableModel.setRowCount(list.size());
			}

			Map<Ticket_Caller_Business_VO, Integer> successhMap = new HashMap<Ticket_Caller_Business_VO, Integer>();
			Map<Ticket_Caller_Business_VO, Integer> failedMap = new HashMap<Ticket_Caller_Business_VO, Integer>();

			for (int i = 0; i < list.size(); i++) {

				Ticket_Caller_Business_VO vo = list.get(i);

				if (vo.getSuccess() == 1) {
					if (successhMap.get(vo) == null) {
						successhMap.put(vo, 1);
					} else {
						int count = successhMap.get(vo);
						successhMap.put(vo, count + 1);
					}
				} else {
					if (failedMap.get(vo) == null) {
						failedMap.put(vo, 1);
					} else {
						int count = failedMap.get(vo);
						failedMap.put(vo, count + 1);
					}

				}

			}

			Set<Ticket_Caller_Business_VO> keySet = successhMap.keySet();
			int i = 0;
			for (Ticket_Caller_Business_VO key : keySet) {
				this.table.setValueAt(key.getBusiness_name(), i, 0);
				this.table.setValueAt(key.getWindow_num(), i, 1);
				this.table.setValueAt(successhMap.get(key) == null ? 0
						: successhMap.get(key), i, 2);
				this.table.setValueAt(failedMap.get(key) == null ? 0
						: failedMap.get(key), i, 3);
				i++;
			}

		} else if (((JTabbedPane) e.getSource()).getSelectedIndex() == 2) {

			TicketService ticketService = new TicketServiceImplJDBC();
			List<Ticket_TakeDate_VO> list = ticketService
					.queryDataByTicket_Caller_Business_VO1();

			if (list == null || list.size() == 0) {
				JOptionPane.showMessageDialog(null, "暂无数据", "警告",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			DefaultTableModel tableModel = (DefaultTableModel) this.table
					.getModel();
			tableModel.setRowCount(0);// 清除原有行

			if (list.size() < 26) {
				tableModel.setRowCount(26);
			} else {
				tableModel.setRowCount(list.size());
			}

			Map<Ticket_TakeDate_VO, Integer> successhMap = new HashMap<Ticket_TakeDate_VO, Integer>();
			Map<Ticket_TakeDate_VO, Integer> failedMap = new HashMap<Ticket_TakeDate_VO, Integer>();

			for (int i = 0; i < list.size(); i++) {

				Ticket_TakeDate_VO vo = list.get(i);

				// System.out.println(vo.getTicket_takeDate());
				if (vo.getSuccess() == 1) {
					if (successhMap.get(vo) == null) {
						successhMap.put(vo, 1);
					} else {
						int count = successhMap.get(vo);
						successhMap.put(vo, count + 1);
					}
				} else {
					if (failedMap.get(vo) == null) {
						failedMap.put(vo, 1);
					} else {
						int count = failedMap.get(vo);
						failedMap.put(vo, count + 1);
					}

				}

			}
			// System.out.println(successhMap.size());
			// System.out.println(failedMap.size());

			Set<Ticket_TakeDate_VO> keySet = successhMap.keySet();
			Set<Ticket_TakeDate_VO> kSet = failedMap.keySet();
			Set<Ticket_TakeDate_VO> keySet1 = new HashSet<Ticket_TakeDate_VO>(
					keySet);
			Set<Ticket_TakeDate_VO> kSet1 = new HashSet<Ticket_TakeDate_VO>(
					kSet);
			int i = 0;
			int j = 0;

			for (Ticket_TakeDate_VO key : keySet) {
				this.table_2.setValueAt(key.getTicket_takeDate(), i, 0);
				this.table_2.setValueAt(key.getBusiness_name(), i, 1);
				this.table_2.setValueAt(successhMap.get(key) == null ? 0
						: successhMap.get(key), i, 2);
				this.table_2.setValueAt(failedMap.get(key) == null ? 0
						: failedMap.get(key), i, 3);
				i++;
				kSet1.remove(key);
				keySet1.remove(key);
			}

			for (Ticket_TakeDate_VO key1 : kSet1) {
				this.table_2.setValueAt(key1.getTicket_takeDate(), i, 0);
				this.table_2.setValueAt(key1.getBusiness_name(), i, 1);
				this.table_2.setValueAt(successhMap.get(key1) == null ? 0
						: successhMap.get(key1), i, 2);
				this.table_2.setValueAt(failedMap.get(key1) == null ? 0
						: failedMap.get(key1), i, 3);
				i++;
			}
			for (Ticket_TakeDate_VO key1 : keySet1) {
				this.table_2.setValueAt(key1.getTicket_takeDate(), i, 0);
				this.table_2.setValueAt(key1.getBusiness_name(), i, 1);
				this.table_2.setValueAt(successhMap.get(key1) == null ? 0
						: successhMap.get(key1), i, 2);
				this.table_2.setValueAt(failedMap.get(key1) == null ? 0
						: failedMap.get(key1), i, 3);
				i++;
			}

		} else {

			// System.out.println("hello4");
		}
	}

	private void buttonActionPerformed(ActionEvent e) {
		this.mainFrame.setVisible(true);
		this.setVisible(false);
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
