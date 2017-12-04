package com.taketicket.manager.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.taketicket.constant.Flavor;
import com.taketicket.constant.MyConstant;
import com.taketicket.entity.Caller;
import com.taketicket.entity.Manager;
import com.taketicket.manager.services.impl.CallerServiceImplJDBC;
import com.taketicket.manager.services.impl.ManagerServiceImplJDBC;
import com.taketicket.util.ui.MyClock;

// import org.eclipse.wb.swing.FocusTraversalOnArray;

public class UserManage extends JFrame {

	private final JPanel contentPane;
	private final JTable table;
	private final JTextField textField;
	private final JTextField textField_1;
	private final JTable table_1;
	private final JTable table_2;
	private final JTable table_3;
	private final JTextField textField_2;
	private final JTextField textField_3;
	private final JTextField textField_4;
	private JTextField textField_5;
	private JButton button_30;
	private JButton button_31;
	private JButton button_1;
	private JButton button;
	private JButton button_2;
	private JPanel panel_11;
	private JTextField textField_6;
	private JButton button_5;
	private JButton button_6;
	private JPanel panel_12;
	private JTextField textField_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JPanel panel_14;
	private JTextField textField_8;
	private JButton button_11;
	private JButton button_12;
	private JTextField textField_10;
	private JLabel label_3;
	private JLabel label_5;
	private JLabel label_6;
	private JButton button_13;
	private JTextField textField_11;
	private JTable table_5;
	private JLabel label_7;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private final JTable table_4;
	private final JTable table_6;
	private final JTable table_7;
	private final JTextField textField_12;
	private final JTextField textField_13;
	private final JTextField textField_14;
	private final JTextField textField_15;
	private final JTextField textField_16;
	private final JTextField textField_17;
	private final JTextField textField_18;
	private final JTextField textField_19;
	private final JTextField textField_20;
	private final JTextField textField_22;
	private final JTextField textField_23;
	private final JFrame mainFrame;

	private final JLabel picLabel;

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
	// UserManage frame = new UserManage();
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
	public UserManage(JFrame mainFrame) {
		this.setTitle("\u7528\u6237\u7BA1\u7406");

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

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 118, 504, 377);
		layeredPane.add(tabbedPane);

		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("\u67E5\u8BE2");
		tabbedPane.addTab("\u7BA1\u7406\u5458\u5E10\u6237\u7BA1\u7406", null,
				panel_2, null);
		panel_2.setLayout(null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(SwingConstants.LEFT);
		tabbedPane_1.setBounds(0, 0, 504, 348);
		panel_2.add(tabbedPane_1);

		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("\u67E5\u8BE2", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 454, 145);
		panel_1.add(scrollPane);

		this.table = new JTable();
		this.table.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, }, new String[] {
				"\u8D26\u53F7", "\u59D3\u540D", "\u5BC6\u7801" }));
		scrollPane.setViewportView(this.table);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null,
				"\u6309\u8D26\u53F7\u67E5\u8BE2", TitledBorder.LEADING,
				TitledBorder.TOP, null, SystemColor.desktop));
		panel_6.setBounds(10, 157, 220, 136);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		this.textField = new JTextField();
		this.textField.setBounds(36, 43, 150, 29);
		panel_6.add(this.textField);
		this.textField.setColumns(10);
		panel_6.add(this.getButton_31());
		panel_6.add(this.getButton());

		JPanel panel_7 = new JPanel();
		panel_7.setToolTipText("\u6309\u59D3\u540D\u67E5\u8BE2\r\n");
		panel_7.setBorder(new TitledBorder(null,
				"\u6309\u59D3\u540D\u67E5\u8BE2", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setBounds(236, 198, 212, 136);
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(37, 41, 138, 29);
		panel_7.add(this.textField_1);
		this.textField_1.setColumns(10);
		panel_7.add(this.getButton_1());
		panel_7.add(this.getButton_2());
		panel_1.add(this.getButton_30());
		// panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(
		// new Component[] { scrollPane, this.table, panel_6,
		// btnNewButton, button, this.textField, panel_7,
		// this.textField_1, button_1, button_2, btnNewButton_1 }));

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		tabbedPane_1.addTab("\u6DFB\u52A0", null, panel_8, null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 454, 145);
		panel_8.add(scrollPane_1);

		this.table_1 = new JTable();
		this.table_1.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, }, new String[] {
				"\u8D26\u53F7", "\u59D3\u540D", "\u5BC6\u7801" }));
		scrollPane_1.setViewportView(this.table_1);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(null, "\u6DFB\u52A0\u8D26\u6237",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_9.setBounds(29, 157, 389, 181);
		panel_8.add(panel_9);

		this.textField_2 = new JTextField();
		this.textField_2.setColumns(10);
		this.textField_2.setBounds(140, 25, 148, 30);
		panel_9.add(this.textField_2);

		JButton button_3 = new JButton("\u786E\u5B9A");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO

				String account = UserManage.this.textField_2.getText();
				String name = UserManage.this.textField_3.getText();
				String psw1 = UserManage.this.textField_4.getText();
				String psw2 = UserManage.this.textField_5.getText();
				if (!psw1.equals(psw2)) {
					JOptionPane.showMessageDialog(null, "密码不一致");
					return;
				}
				if (account.equals(name)) {
					JOptionPane.showMessageDialog(null, "账号和姓名不能相同");
					return;
				}
				Manager manager = new Manager(account, name, psw1);

				int row = 0;
				try {

					row = new ManagerServiceImplJDBC().insertManager(manager);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "账号已存在！");
					return;
				}

				if (row == 1) {
					JOptionPane.showMessageDialog(null, "成功添加");
					return;
				}
				// if (row == 0) {
				// JOptionPane.showMessageDialog(null, "添加失败");
				// }

			}
		});
		button_3.setBounds(302, 130, 76, 30);
		panel_9.add(button_3);

		JButton button_4 = new JButton("\u91CD\u7F6E");
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManage.this.textField_2.setText("");
				UserManage.this.textField_3.setText("");
				UserManage.this.textField_4.setText("");
				UserManage.this.textField_5.setText("");
			}
		});
		button_4.setBounds(302, 95, 76, 30);
		panel_9.add(button_4);

		this.textField_3 = new JTextField();
		this.textField_3.setColumns(10);
		this.textField_3.setBounds(140, 60, 148, 30);
		panel_9.add(this.textField_3);

		this.textField_4 = new JTextField();
		this.textField_4.setColumns(10);
		this.textField_4.setBounds(140, 95, 148, 30);
		panel_9.add(this.textField_4);

		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(20, 31, 108, 18);
		panel_9.add(label);

		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(20, 66, 108, 18);
		panel_9.add(label_1);

		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(6, 101, 122, 18);
		panel_9.add(label_2);

		JLabel label_16 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setBounds(20, 136, 108, 18);
		panel_9.add(label_16);

		JButton button_7 = new JButton("\u67E5\u770B\u5168\u90E8");
		button_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO

				int j = 0;
				List<Manager> list = new ManagerServiceImplJDBC().queryAll();
				if (list == null || list.size() == 0) {
					JOptionPane.showMessageDialog(null, "数据库中暂无数据");
					return;
				}
				DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table_1
						.getModel();
				tableModel.setRowCount(0);// 清除原有行
				if (list.size() < 10) {
					tableModel.setRowCount(10);
				} else {
					tableModel.setRowCount(list.size());
				}
				for (int i = 0; i < list.size(); i++) {
					Manager manager = list.get(i);

					// int id = business.getId();
					String account = manager.getAccount();
					String name = manager.getName();
					String psw = manager.getPassword();

					UserManage.this.table_1.setValueAt(name, j, 1);
					UserManage.this.table_1.setValueAt(psw, j, 2);
					UserManage.this.table_1.setValueAt(account, j, 0);
					j++;
				}

			}
		});
		button_7.setBounds(291, 24, 88, 30);
		panel_9.add(button_7);
		panel_9.add(this.getTextField_5());

		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		tabbedPane_1.addTab("\u5220\u9664", null, panel_10, null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 454, 145);
		panel_10.add(scrollPane_2);

		this.table_2 = new JTable();
		this.table_2.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, }, new String[] {
				"\u8D26\u53F7", "\u59D3\u540D", "\u5BC6\u7801" }));
		scrollPane_2.setViewportView(this.table_2);
		panel_10.add(this.getPanel_11());
		panel_10.add(this.getPanel_12());
		panel_10.add(this.getButton_10());

		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		tabbedPane_1.addTab("\u4FEE\u6539\r\n", null, panel_13, null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 454, 145);
		panel_13.add(scrollPane_3);
		scrollPane_3.setViewportView(this.getTable_5());
		panel_13.add(this.getPanel_14());

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setToolTipText("\u67E5\u8BE2");
		tabbedPane.addTab("\u67DC\u5458\u7BA1\u7406", null, panel_3, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(SwingConstants.LEFT);
		tabbedPane_2.setBounds(0, 0, 504, 348);
		panel_3.add(tabbedPane_2);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane_2.addTab("\u67E5\u8BE2", null, panel, null);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 454, 145);
		panel.add(scrollPane_4);

		this.table_3 = new JTable();
		this.table_3.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, }, new String[] {
				"\u5E10\u6237", "\u59D3\u540D", "\u5BC6\u7801" }));
		scrollPane_4.setViewportView(this.table_3);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null,

		"\u6309\u8D26\u53F7\u67E5\u8BE2", TitledBorder.LEADING,

		TitledBorder.TOP, null, SystemColor.desktop));
		panel_4.setBounds(10, 157, 220, 136);
		panel.add(panel_4);

		this.textField_12 = new JTextField();
		this.textField_12.setColumns(10);
		this.textField_12.setBounds(36, 43, 150, 29);
		panel_4.add(this.textField_12);

		JButton button_14 = new JButton("\u786E\u5B9A");
		button_14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//
				// List<Caller> list = new CallerServiceImplJDBC().queryAll();
				// tableModel.setRowCount(list.size());

				String account = UserManage.this.textField_12.getText();
				if (account == null || account.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "账户不能为空");
					return;
				}
				Caller caller = new CallerServiceImplJDBC()
						.queryByAccount(account);
				if (caller == null) {
					UserManage.this.textField.setText("请输入正确的代码");
				} else {
					DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table_3
							.getModel();
					tableModel.setRowCount(0);// 清除原有行
					tableModel.setRowCount(10);

					String name = caller.getName();
					String psw = caller.getPassword();
					UserManage.this.table_3.setValueAt(account, 0, 0);
					UserManage.this.table_3.setValueAt(psw, 0, 2);
					UserManage.this.table_3.setValueAt(name, 0, 1);

				}

			}
		});
		button_14.setBounds(36, 78, 69, 30);
		panel_4.add(button_14);

		JButton button_15 = new JButton("\u53D6\u6D88");
		button_15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManage.this.textField_12.setText("");
			}
		});
		button_15.setBounds(117, 78, 69, 30);
		panel_4.add(button_15);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setToolTipText("\u6309\u59D3\u540D\u67E5\u8BE2\r\n");
		panel_5.setBorder(new TitledBorder(null,

		"\u6309\u59D3\u540D\u67E5\u8BE2", TitledBorder.LEADING,

		TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(236, 199, 212, 136);
		panel.add(panel_5);

		this.textField_13 = new JTextField();
		this.textField_13.setColumns(10);
		this.textField_13.setBounds(37, 41, 138, 29);
		panel_5.add(this.textField_13);

		JButton button_16 = new JButton("\u786E\u5B9A");
		button_16.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//
				// List<Caller> list = new CallerServiceImplJDBC().queryAll();
				// DefaultTableModel tableModel = (DefaultTableModel)
				// UserManage.this.table_3
				// .getModel();
				// tableModel.setRowCount(0);// 清除原有行
				//
				// tableModel.setRowCount(list.size());

				String name = UserManage.this.textField_13.getText();
				if (name == null || name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "请输入要查询的姓名");
					return;

				}
				List<Caller> list1 = new CallerServiceImplJDBC()
						.queryByName(name);
				if (list1 == null || list1.size() == 0) {
					JOptionPane.showMessageDialog(null, "输入有误");
				} else {

					DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table_3
							.getModel();
					tableModel.setRowCount(0);// 清除原有行
					if (list1.size() < 10) {
						tableModel.setRowCount(10);
					} else {
						tableModel.setRowCount(list1.size());
					}

					int i = 0;
					int j = 0;
					int a = list1.size();
					while (a > 0) {
						a--;

						Caller caller = list1.get(0);
						String account = caller.getAccount();
						String psw = caller.getPassword();
						UserManage.this.table_3.setValueAt(account, i, 0);
						UserManage.this.table_3.setValueAt(psw, i, 2);
						UserManage.this.table_3.setValueAt(name, i, 1);
						j++;
						i++;
					}

				}

			}
		});
		button_16.setBounds(37, 82, 66, 30);
		panel_5.add(button_16);

		JButton button_17 = new JButton("\u53D6\u6D88");
		button_17.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManage.this.textField_13.setText("");
			}
		});
		button_17.setBounds(109, 82, 66, 30);
		panel_5.add(button_17);

		JButton button_18 = new JButton("\u67E5\u770B\u5168\u90E8");
		button_18.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int j = 0;
				List<Caller> list = new CallerServiceImplJDBC().queryAll();
				if (list == null || list.size() == 0) {
					JOptionPane.showMessageDialog(null, "数据库中暂无数据");
					return;
				}
				DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table_3
						.getModel();
				tableModel.setRowCount(0);// 清除原有行
				if (list.size() < 10) {
					tableModel.setRowCount(10);
				} else {
					tableModel.setRowCount(list.size());
				}
				for (int i = 0; i < list.size(); i++) {
					Caller caller = list.get(i);

					// int id = business.getId();
					String account = caller.getAccount();
					String name = caller.getName();
					String psw = caller.getPassword();

					UserManage.this.table_3.setValueAt(name, j, 1);
					UserManage.this.table_3.setValueAt(psw, j, 2);
					UserManage.this.table_3.setValueAt(account, j, 0);
					j++;
				}

			}
		});
		button_18.setBounds(356, 157, 92, 30);
		panel.add(button_18);

		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		tabbedPane_2.addTab("\u6DFB\u52A0", null, panel_15, null);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(0, 0, 454, 145);
		panel_15.add(scrollPane_5);

		this.table_4 = new JTable();
		this.table_4.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, }, new String[] {
				"\u8D26\u53F7", "\u59D3\u540D", "\u5BC6\u7801" }));
		scrollPane_5.setViewportView(this.table_4);

		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(new TitledBorder(null, "\u6DFB\u52A0\u8D26\u6237",

		TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,

		59)));
		panel_16.setBounds(29, 157, 389, 181);
		panel_15.add(panel_16);

		this.textField_14 = new JTextField();
		this.textField_14.setColumns(10);
		this.textField_14.setBounds(140, 25, 148, 30);
		panel_16.add(this.textField_14);

		JButton button_19 = new JButton("\u786E\u5B9A");
		button_19.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String account = UserManage.this.textField_14.getText();
				String name = UserManage.this.textField_15.getText();
				String psw1 = UserManage.this.textField_16.getText();
				String psw2 = UserManage.this.textField_17.getText();
				if (!psw1.equals(psw2)) {
					JOptionPane.showMessageDialog(null, "密码不一致");
					return;
				}
				if (account.equals(name)) {
					JOptionPane.showMessageDialog(null, "账号和姓名不能相同");
					return;
				}
				Manager manager = new Manager(account, name, psw1);
				Caller caller = new Caller(account, name, psw2);

				int row = 0;
				try {
					row = new CallerServiceImplJDBC().insertCaller(caller);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "账号不能重复");
					return;
				}

				if (row == 1) {
					JOptionPane.showMessageDialog(null, "成功添加");
				}
				if (row == 0) {
					JOptionPane.showMessageDialog(null, "添加失败");
				}

			}
		});
		button_19.setBounds(302, 130, 76, 30);
		panel_16.add(button_19);

		JButton button_20 = new JButton("\u91CD\u7F6E");
		button_20.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManage.this.textField_14.setText("");
				UserManage.this.textField_15.setText("");
				UserManage.this.textField_16.setText("");
				UserManage.this.textField_17.setText("");
			}
		});
		button_20.setBounds(302, 95, 76, 30);
		panel_16.add(button_20);

		this.textField_15 = new JTextField();
		this.textField_15.setColumns(10);
		this.textField_15.setBounds(140, 60, 148, 30);
		panel_16.add(this.textField_15);

		this.textField_16 = new JTextField();
		this.textField_16.setColumns(10);
		this.textField_16.setBounds(140, 95, 148, 30);
		panel_16.add(this.textField_16);

		JLabel label_8 = new JLabel("\u8D26\u53F7\uFF1A");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(20, 31, 108, 18);
		panel_16.add(label_8);

		JLabel label_9 = new JLabel("\u59D3\u540D\uFF1A");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(20, 66, 108, 18);
		panel_16.add(label_9);

		JLabel label_10 = new JLabel("\u5BC6\u7801\uFF1A");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(6, 101, 122, 18);
		panel_16.add(label_10);

		JLabel label_11 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(20, 136, 108, 18);
		panel_16.add(label_11);

		JButton button_21 = new JButton("\u67E5\u770B\u5168\u90E8");
		button_21.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO

				int j = 0;
				List<Caller> list = new CallerServiceImplJDBC().queryAll();
				if (list == null || list.size() == 0) {
					JOptionPane.showMessageDialog(null, "数据库中暂无数据");
					return;
				}
				DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table_4
						.getModel();
				tableModel.setRowCount(0);// 清除原有行
				if (list.size() < 10) {
					tableModel.setRowCount(10);
				} else {
					tableModel.setRowCount(list.size());
				}
				for (int i = 0; i < list.size(); i++) {
					Caller caller = list.get(i);

					// int id = business.getId();
					String account = caller.getAccount();
					String name = caller.getName();
					String psw = caller.getPassword();

					UserManage.this.table_4.setValueAt(name, j, 1);
					UserManage.this.table_4.setValueAt(psw, j, 2);
					UserManage.this.table_4.setValueAt(account, j, 0);
					j++;
				}

			}
		});
		button_21.setBounds(295, 25, 83, 30);
		panel_16.add(button_21);

		this.textField_17 = new JTextField();
		this.textField_17.setColumns(10);
		this.textField_17.setBounds(140, 130, 148, 30);
		panel_16.add(this.textField_17);

		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		tabbedPane_2.addTab("\u5220\u9664", null, panel_17, null);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(0, 0, 454, 145);
		panel_17.add(scrollPane_6);

		this.table_6 = new JTable();
		this.table_6.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, }, new String[] {
				"\u8D26\u53F7", "\u59D3\u540D", "\u5BC6\u7801" }));
		scrollPane_6.setViewportView(this.table_6);

		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBorder(new TitledBorder(null,

		"\u6309\u8D26\u53F7\u5220\u9664", TitledBorder.LEADING,

		TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_18.setBounds(10, 157, 220, 136);
		panel_17.add(panel_18);

		this.textField_18 = new JTextField();
		this.textField_18.setColumns(10);
		this.textField_18.setBounds(36, 43, 150, 29);
		panel_18.add(this.textField_18);

		JButton button_22 = new JButton("\u786E\u5B9A");
		button_22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String account = UserManage.this.textField_18.getText();
				if (account == null || account.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "账号不能为空");
					return;
				}
				int row = new CallerServiceImplJDBC()
						.deleteCallerByAccount(account);
				if (row == 1) {
					JOptionPane.showMessageDialog(null, "成功删除");
				}
				if (row == 0) {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}
		});
		button_22.setBounds(36, 78, 67, 30);
		panel_18.add(button_22);

		JButton button_23 = new JButton("\u53D6\u6D88");
		button_23.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManage.this.textField_18.setText("");
			}
		});
		button_23.setBounds(119, 78, 67, 30);
		panel_18.add(button_23);

		JPanel panel_19 = new JPanel();
		panel_19.setLayout(null);
		panel_19.setToolTipText("\u6309\u59D3\u540D\u67E5\u8BE2\r\n");
		panel_19.setBorder(new TitledBorder(null,

		"\u6309\u59D3\u540D\u5220\u9664", TitledBorder.LEADING,

		TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_19.setBounds(236, 199, 212, 136);
		panel_17.add(panel_19);

		this.textField_19 = new JTextField();
		this.textField_19.setColumns(10);
		this.textField_19.setBounds(37, 41, 138, 29);
		panel_19.add(this.textField_19);

		JButton button_24 = new JButton("\u786E\u5B9A");
		button_24.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String name = UserManage.this.textField_19.getText();
				if (name == null || name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "账号不能为空");
					return;
				}
				int row = new CallerServiceImplJDBC().deleteCallerByName(name);
				if (row == 1) {
					JOptionPane.showMessageDialog(null, "成功删除所有同名账户");
				}
				if (row == 0) {
					JOptionPane.showMessageDialog(null, "删除失败");
				}

			}
		});
		button_24.setBounds(37, 82, 66, 30);
		panel_19.add(button_24);

		JButton button_25 = new JButton("\u53D6\u6D88");
		button_25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManage.this.textField_19.setText("");
			}
		});
		button_25.setBounds(109, 82, 66, 30);
		panel_19.add(button_25);

		JButton button_26 = new JButton("\u67E5\u770B\u5168\u90E8");
		button_26.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO

				int j = 0;
				List<Caller> list = new CallerServiceImplJDBC().queryAll();
				if (list == null || list.size() == 0) {
					JOptionPane.showMessageDialog(null, "数据库中暂无数据");
					return;
				}
				DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table_6
						.getModel();
				tableModel.setRowCount(0);// 清除原有行
				if (list.size() < 10) {
					tableModel.setRowCount(10);
				} else {
					tableModel.setRowCount(list.size());
				}
				for (int i = 0; i < list.size(); i++) {
					Caller caller = list.get(i);

					String account = caller.getAccount();
					String name = caller.getName();
					String psw = caller.getPassword();

					UserManage.this.table_6.setValueAt(name, j, 1);
					UserManage.this.table_6.setValueAt(psw, j, 2);
					UserManage.this.table_6.setValueAt(account, j, 0);
					j++;
				}

			}
		});
		button_26.setBounds(355, 157, 93, 30);
		panel_17.add(button_26);

		JPanel panel_20 = new JPanel();
		panel_20.setLayout(null);
		tabbedPane_2.addTab("\u4FEE\u6539", null, panel_20, null);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(0, 0, 454, 145);
		panel_20.add(scrollPane_7);

		this.table_7 = new JTable();
		this.table_7.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, }, new String[] {
				"\u8D26\u53F7", "\u59D3\u540D", "\u5BC6\u7801" }));
		scrollPane_7.setViewportView(this.table_7);

		JPanel panel_21 = new JPanel();
		panel_21.setLayout(null);
		panel_21.setBorder(new TitledBorder(null, "\u4FEE\u6539\u5BC6\u7801",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_21.setBounds(33, 145, 389, 197);
		panel_20.add(panel_21);

		this.textField_20 = new JTextField();
		this.textField_20.setColumns(10);
		this.textField_20.setBounds(140, 25, 148, 30);
		panel_21.add(this.textField_20);

		final JRadioButton radioButton_2 = new JRadioButton("\u662F");
		radioButton_2.setBounds(150, 166, 62, 18);
		panel_21.add(radioButton_2);

		final JRadioButton radioButton_3 = new JRadioButton("\u5426");
		radioButton_3.setSelected(true);
		radioButton_3.setBounds(214, 166, 56, 18);
		panel_21.add(radioButton_3);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton_3);
		buttonGroup.add(radioButton_2);

		JButton button_27 = new JButton("\u786E\u5B9A");
		button_27.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CallerServiceImplJDBC callerServiceImplJDBC = new CallerServiceImplJDBC();
				String account = UserManage.this.textField_20.getText();
				String psw1 = UserManage.this.textField_22.getText();
				String psw2 = UserManage.this.textField_23.getText();

				if (!psw1.equals(psw2)) {
					JOptionPane.showMessageDialog(null, "两次密码要一致");
					return;
				}
				if (account.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "账号不能为空");
					return;
				}
				int disabled = 0;

				if (radioButton_2.isSelected()) {
					disabled = MyConstant.DISABLED;
				}
				if (radioButton_3.isSelected()) {
					disabled = MyConstant.ABLE;
				}
				Manager manager = new Manager(account, "", psw1);
				Caller caller = new Caller(1, account, "", psw1, disabled);
				int row = callerServiceImplJDBC.updatePasswordByAccount(caller);
				int r = callerServiceImplJDBC.updateDisableByAccount(caller);

				if (row == 1) {
					JOptionPane.showMessageDialog(null, "修改成功");
					return;
				}
				if (row == 0) {

					JOptionPane.showMessageDialog(null, "修改失败");
				}

			}
		});
		button_27.setBounds(302, 154, 76, 30);
		panel_21.add(button_27);

		JButton button_28 = new JButton("\u91CD\u7F6E");
		button_28.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManage.this.textField_20.setText("");
				UserManage.this.textField_22.setText("");
				UserManage.this.textField_23.setText("");
			}
		});
		button_28.setBounds(302, 114, 76, 30);
		panel_21.add(button_28);

		this.textField_22 = new JTextField();
		this.textField_22.setColumns(10);
		this.textField_22.setBounds(140, 78, 148, 30);
		panel_21.add(this.textField_22);

		JLabel label_12 = new JLabel("\u8D26\u53F7\uFF1A");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setBounds(20, 31, 108, 18);
		panel_21.add(label_12);

		JLabel label_14 = new JLabel("\u5BC6\u7801\uFF1A");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setBounds(8, 83, 122, 18);
		panel_21.add(label_14);

		JLabel label_15 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setBounds(20, 136, 108, 18);
		panel_21.add(label_15);

		JButton button_29 = new JButton("\u67E5\u770B\u5168\u90E8");
		button_29.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO

				int j = 0;
				List<Caller> list = new CallerServiceImplJDBC().queryAll();
				if (list == null || list.size() == 0) {
					JOptionPane.showMessageDialog(null, "数据库中暂无数据");
					return;
				}
				DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table_7
						.getModel();
				tableModel.setRowCount(0);// 清除原有行
				if (list.size() < 10) {
					tableModel.setRowCount(10);
				} else {
					tableModel.setRowCount(list.size());
				}
				for (int i = 0; i < list.size(); i++) {
					Caller caller = list.get(i);

					// int id = business.getId();
					String account = caller.getAccount();
					String name = caller.getName();
					String psw = caller.getPassword();

					UserManage.this.table_7.setValueAt(name, j, 1);
					UserManage.this.table_7.setValueAt(psw, j, 2);
					UserManage.this.table_7.setValueAt(account, j, 0);
					j++;
				}

			}
		});
		button_29.setBounds(289, 25, 90, 30);
		panel_21.add(button_29);

		this.textField_23 = new JTextField();
		this.textField_23.setColumns(10);
		this.textField_23.setBounds(140, 130, 148, 30);
		panel_21.add(this.textField_23);

		JLabel label_17 = new JLabel("\u662F\u5426\u7981\u7528\uFF1A");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setBounds(20, 166, 108, 18);
		panel_21.add(label_17);

		JButton button_32 = new JButton("\u4E3B\u83DC\u5355");
		button_32.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManage.this.button_32ActionPerformed(e);
			}

		});
		button_32.setBounds(21, 514, 102, 39);
		layeredPane.add(button_32);

		JLabel clockLabel = new JLabel(MyClock.getDateTime());
		clockLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		MyClock.showTimeAtLabel(clockLabel);
		clockLabel.setBounds(271, 516, 223, 39);
		layeredPane.add(clockLabel);

		this.picLabel = new JLabel("");
		this.picLabel.setIcon(new ImageIcon(UserManage.class
				.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.picLabel.setBounds(0, 0, 504, 572);
		layeredPane.add(this.picLabel);

		this.setLocationRelativeTo(null);// 窗口在屏幕中间显示
	}

	private JTextField getTextField_5() {
		if (this.textField_5 == null) {
			this.textField_5 = new JTextField();
			this.textField_5.setBounds(140, 130, 148, 30);
			this.textField_5.setColumns(10);
		}
		return this.textField_5;
	}

	private JButton getButton_30() {
		if (this.button_30 == null) {
			this.button_30 = new JButton("\u67E5\u770B\u5168\u90E8");
			this.button_30.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO

					int j = 0;
					List<Manager> list = new ManagerServiceImplJDBC()
							.queryAll();
					if (list == null || list.size() == 0) {
						JOptionPane.showMessageDialog(null, "数据库中暂无数据");
						return;
					}

					DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table
							.getModel();
					tableModel.setRowCount(0);// 清除原有行
					if (list.size() < 10) {

						tableModel.setRowCount(10);
					} else {

						tableModel.setRowCount(list.size());
					}

					for (int i = 0; i < list.size(); i++) {
						Manager manager = list.get(i);

						// int id = business.getId();
						String account = manager.getAccount();
						String name = manager.getName();
						String psw = manager.getPassword();

						UserManage.this.table.setValueAt(name, j, 1);
						UserManage.this.table.setValueAt(psw, j, 2);
						UserManage.this.table.setValueAt(account, j, 0);
						j++;
					}

				}
			});
			this.button_30.setBounds(359, 156, 89, 30);
		}
		return this.button_30;
	}

	private JButton getButton_31() {
		if (this.button_31 == null) {
			this.button_31 = new JButton("\u786E\u5B9A");
			this.button_31.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// List<Manager> list = new ManagerServiceImplJDBC()
					// .queryAll();
					// if (list == null || list.size() == 0) {
					// JOptionPane.showMessageDialog(null, "数据库无数据");
					// return;
					// }
					// DefaultTableModel tableModel = (DefaultTableModel)
					// UserManage.this.table
					// .getModel();
					// tableModel.setRowCount(0);// 清除原有行
					// if (list.size() < 10) {
					// tableModel.setRowCount(10);
					// } else {
					// tableModel.setRowCount(list.size());
					// }

					String account = UserManage.this.textField.getText();
					if (account == null || account.trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "请输入要查询的账号");
						return;
					}
					Manager manager = new ManagerServiceImplJDBC()
							.queryByAccount(account);
					if (manager == null) {
						UserManage.this.textField.setText("请输入正确的代码");
					} else {
						DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table
								.getModel();
						tableModel.setRowCount(0);// 清除原有行

						tableModel.setRowCount(10);

						String name = manager.getName();
						String psw = manager.getPassword();
						UserManage.this.table.setValueAt(account, 0, 0);
						UserManage.this.table.setValueAt(psw, 0, 2);
						UserManage.this.table.setValueAt(name, 0, 1);

					}

				}
			});
			this.button_31.setBounds(36, 78, 67, 30);
		}
		return this.button_31;
	}

	private JButton getButton_1() {
		if (this.button_1 == null) {
			this.button_1 = new JButton("\u786E\u5B9A");
			this.button_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO

					// List<Manager> list = new ManagerServiceImplJDBC()
					// .queryAll();
					// tableModel.setRowCount(list.size());

					String name = UserManage.this.textField_1.getText();
					if (name == null || name.trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "请输入要查询的姓名");
						return;
					}
					Manager manager = new ManagerServiceImplJDBC()
							.queryByName(name);
					if (manager == null) {
						UserManage.this.textField_1.setText("请输入正确的名称");

					} else {

						DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table
								.getModel();
						tableModel.setRowCount(0);// 清除原有行
						tableModel.setRowCount(10);//

						String account = manager.getAccount();
						String psw = manager.getPassword();

						UserManage.this.table.setValueAt(account, 0, 0);
						UserManage.this.table.setValueAt(psw, 0, 2);
						UserManage.this.table.setValueAt(name, 0, 1);

					}

				}
			});
			this.button_1.setBounds(37, 82, 68, 30);
		}
		return this.button_1;
	}

	private JButton getButton() {
		if (this.button == null) {
			this.button = new JButton("\u53D6\u6D88");
			this.button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					UserManage.this.textField.setText("");
				}
			});
			this.button.setBounds(119, 78, 67, 30);
		}
		return this.button;
	}

	private JButton getButton_2() {
		if (this.button_2 == null) {
			this.button_2 = new JButton("\u53D6\u6D88");
			this.button_2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					UserManage.this.textField_1.setText("");
				}
			});
			this.button_2.setBounds(107, 82, 68, 30);
		}
		return this.button_2;
	}

	private JPanel getPanel_11() {
		if (this.panel_11 == null) {
			this.panel_11 = new JPanel();
			this.panel_11.setLayout(null);
			this.panel_11.setBorder(new TitledBorder(null,
					"\u6309\u8D26\u53F7\u5220\u9664", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 0, 0)));
			this.panel_11.setBounds(10, 157, 220, 136);
			this.panel_11.add(this.getTextField_6());
			this.panel_11.add(this.getButton_5());
			this.panel_11.add(this.getButton_6());
		}
		return this.panel_11;
	}

	private JTextField getTextField_6() {
		if (this.textField_6 == null) {
			this.textField_6 = new JTextField();
			this.textField_6.setColumns(10);
			this.textField_6.setBounds(36, 43, 150, 29);
		}
		return this.textField_6;
	}

	private JButton getButton_5() {
		if (this.button_5 == null) {
			this.button_5 = new JButton("\u786E\u5B9A");
			this.button_5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String account = UserManage.this.textField_6.getText();
					if (account == null || account.trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "账号不能为空");
						return;
					}
					int row = new ManagerServiceImplJDBC()
							.deleteManagerByAccount(account);
					if (row == 1) {
						JOptionPane.showMessageDialog(null, "成功删除");
					}
					if (row == 0) {
						JOptionPane.showMessageDialog(null, "删除失败");
					}

				}
			});
			this.button_5.setBounds(36, 78, 67, 30);
		}
		return this.button_5;
	}

	private JButton getButton_6() {
		if (this.button_6 == null) {
			this.button_6 = new JButton("\u53D6\u6D88");
			this.button_6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					UserManage.this.textField_6.setText("");
				}
			});
			this.button_6.setBounds(119, 78, 67, 30);
		}
		return this.button_6;
	}

	private JPanel getPanel_12() {
		if (this.panel_12 == null) {
			this.panel_12 = new JPanel();
			this.panel_12.setLayout(null);
			this.panel_12.setToolTipText("\u6309\u59D3\u540D\u67E5\u8BE2\r\n");
			this.panel_12.setBorder(new TitledBorder(null,
					"\u6309\u59D3\u540D\u5220\u9664", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 0, 0)));
			this.panel_12.setBounds(236, 199, 212, 136);
			this.panel_12.add(this.getTextField_7());
			this.panel_12.add(this.getButton_8());
			this.panel_12.add(this.getButton_9());
		}
		return this.panel_12;
	}

	private JTextField getTextField_7() {
		if (this.textField_7 == null) {
			this.textField_7 = new JTextField();
			this.textField_7.setColumns(10);
			this.textField_7.setBounds(37, 41, 138, 29);
		}
		return this.textField_7;
	}

	private JButton getButton_8() {
		if (this.button_8 == null) {
			this.button_8 = new JButton("\u786E\u5B9A");
			this.button_8.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String name = UserManage.this.textField_7.getText();
					if (name == null || name.trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "账号不能为空");
						return;
					}

					int row = new ManagerServiceImplJDBC()
							.deleteManagerByName(name);
					if (row == 1) {
						JOptionPane.showMessageDialog(null, "成功删除所有同名账户");
					}
					if (row == 0) {
						JOptionPane.showMessageDialog(null, "删除失败");
					}

				}
			});
			this.button_8.setBounds(37, 82, 66, 30);
		}
		return this.button_8;
	}

	private JButton getButton_9() {
		if (this.button_9 == null) {
			this.button_9 = new JButton("\u53D6\u6D88");
			this.button_9.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					UserManage.this.textField_7.setText("");
				}
			});
			this.button_9.setBounds(109, 82, 66, 30);
		}
		return this.button_9;
	}

	private JButton getButton_10() {
		if (this.button_10 == null) {
			this.button_10 = new JButton("\u67E5\u770B\u5168\u90E8");
			this.button_10.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO

					int j = 0;
					List<Manager> list = new ManagerServiceImplJDBC()
							.queryAll();
					if (list == null || list.size() == 0) {
						JOptionPane.showMessageDialog(null, "数据库中暂无数据");
						return;
					}
					DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table_2
							.getModel();
					tableModel.setRowCount(0);// 清除原有行
					if (list.size() < 10) {
						tableModel.setRowCount(10);
					} else {
						tableModel.setRowCount(list.size());
					}
					for (int i = 0; i < list.size(); i++) {
						Manager manager = list.get(i);

						// int id = business.getId();
						String account = manager.getAccount();
						String name = manager.getName();
						String psw = manager.getPassword();

						UserManage.this.table_2.setValueAt(name, j, 1);
						UserManage.this.table_2.setValueAt(psw, j, 2);
						UserManage.this.table_2.setValueAt(account, j, 0);
						j++;
					}

				}
			});
			this.button_10.setBounds(355, 157, 93, 30);
		}
		return this.button_10;
	}

	private JPanel getPanel_14() {
		if (this.panel_14 == null) {
			this.panel_14 = new JPanel();
			this.panel_14.setLayout(null);
			this.panel_14.setBorder(new TitledBorder(null,
					"\u4FEE\u6539\u5BC6\u7801", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(59, 59, 59)));
			this.panel_14.setBounds(33, 145, 389, 197);
			this.panel_14.add(this.getTextField_8());
			this.panel_14.add(this.getButton_11());
			this.panel_14.add(this.getButton_12());
			this.panel_14.add(this.getTextField_10());
			this.panel_14.add(this.getLabel_3());
			this.panel_14.add(this.getLabel_5());
			this.panel_14.add(this.getLabel_6());
			this.panel_14.add(this.getButton_13());
			this.panel_14.add(this.getTextField_11());
			this.panel_14.add(this.getLabel_7());
			this.panel_14.add(this.getRadioButton());
			this.panel_14.add(this.getRadioButton_1());
			ButtonGroup buttonGroup = new ButtonGroup();
			buttonGroup.add(this.radioButton);
			buttonGroup.add(this.radioButton_1);
		}
		return this.panel_14;
	}

	private JTextField getTextField_8() {
		if (this.textField_8 == null) {
			this.textField_8 = new JTextField();
			this.textField_8.setColumns(10);
			this.textField_8.setBounds(140, 25, 148, 30);
		}
		return this.textField_8;
	}

	private JButton getButton_11() {
		if (this.button_11 == null) {
			this.button_11 = new JButton("\u786E\u5B9A");
			this.button_11.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					ManagerServiceImplJDBC managerServiceImplJDBC = new ManagerServiceImplJDBC();
					String account = UserManage.this.textField_8.getText();
					String psw1 = UserManage.this.textField_10.getText();
					String psw2 = UserManage.this.textField_11.getText();

					if (!psw1.equals(psw2)) {
						JOptionPane.showMessageDialog(null, "两次密码要一致");
						return;
					}
					if (account.trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "账号不能为空");
						return;
					}
					// int disabled = 0;
					//
					// if (UserManage.this.radioButton.isSelected()) {
					// disabled = MyConstant.DISABLED;
					// }
					// if (UserManage.this.radioButton_1.isSelected()) {
					// disabled = MyConstant.ABLE;
					// }
					Manager manager = new Manager(account, "", psw1);

					int row = managerServiceImplJDBC
							.updatePasswordByAccount(manager);
					// int r = managerServiceImplJDBC
					// .updateDisableByAccount(manager);

					// if (row == 1 && r == 1) {
					// JOptionPane.showMessageDialog(null, "修改成功");
					// return;
					// }
					// if (row == 0 || r == 0) {
					//
					// JOptionPane.showMessageDialog(null, "修改失败");
					// }

					if (row == 1) {
						JOptionPane.showMessageDialog(null, "修改成功");
						return;
					}
					if (row == 0) {

						JOptionPane.showMessageDialog(null, "修改失败", "警告",
								JOptionPane.WARNING_MESSAGE);
					}

				}
			});
			this.button_11.setBounds(302, 154, 76, 30);
		}
		return this.button_11;
	}

	private JButton getButton_12() {
		if (this.button_12 == null) {
			this.button_12 = new JButton("\u91CD\u7F6E");
			this.button_12.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					UserManage.this.textField_8.setText("");
					UserManage.this.textField_10.setText("");
					UserManage.this.textField_11.setText("");
				}
			});
			this.button_12.setBounds(302, 112, 76, 30);
		}
		return this.button_12;
	}

	private JTextField getTextField_10() {
		if (this.textField_10 == null) {
			this.textField_10 = new JTextField();
			this.textField_10.setColumns(10);
			this.textField_10.setBounds(140, 76, 148, 30);
		}
		return this.textField_10;
	}

	private JLabel getLabel_3() {
		if (this.label_3 == null) {
			this.label_3 = new JLabel("\u8D26\u53F7\uFF1A");
			this.label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			this.label_3.setBounds(20, 31, 108, 18);
		}
		return this.label_3;
	}

	private JLabel getLabel_5() {
		if (this.label_5 == null) {
			this.label_5 = new JLabel("\u5BC6\u7801\uFF1A");
			this.label_5.setHorizontalAlignment(SwingConstants.RIGHT);
			this.label_5.setBounds(10, 91, 122, 18);
		}
		return this.label_5;
	}

	private JLabel getLabel_6() {
		if (this.label_6 == null) {
			this.label_6 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
			this.label_6.setHorizontalAlignment(SwingConstants.RIGHT);
			this.label_6.setBounds(20, 136, 108, 18);
		}
		return this.label_6;
	}

	private JButton getButton_13() {
		if (this.button_13 == null) {
			this.button_13 = new JButton("\u67E5\u770B\u5168\u90E8");
			this.button_13.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO

					int j = 0;
					List<Manager> list = new ManagerServiceImplJDBC()
							.queryAll();
					if (list == null || list.size() == 0) {
						JOptionPane.showMessageDialog(null, "数据库中暂无数据");
						return;
					}
					DefaultTableModel tableModel = (DefaultTableModel) UserManage.this.table_5
							.getModel();
					tableModel.setRowCount(0);// 清除原有行
					if (list.size() < 10) {
						tableModel.setRowCount(10);
					} else {
						tableModel.setRowCount(list.size());
					}
					for (int i = 0; i < list.size(); i++) {
						Manager manager = list.get(i);

						// int id = business.getId();
						String account = manager.getAccount();
						String name = manager.getName();
						String psw = manager.getPassword();

						UserManage.this.table_5.setValueAt(name, j, 1);
						UserManage.this.table_5.setValueAt(psw, j, 2);
						UserManage.this.table_5.setValueAt(account, j, 0);
						j++;
					}

				}
			});
			this.button_13.setBounds(289, 25, 89, 30);
		}
		return this.button_13;
	}

	private JTextField getTextField_11() {
		if (this.textField_11 == null) {
			this.textField_11 = new JTextField();
			this.textField_11.setColumns(10);
			this.textField_11.setBounds(140, 130, 148, 30);
		}
		return this.textField_11;
	}

	private JTable getTable_5() {
		if (this.table_5 == null) {
			this.table_5 = new JTable();
			this.table_5.setModel(new DefaultTableModel(new Object[][] {
					{ null, null, null }, { null, null, null },
					{ null, null, null }, { null, null, null },
					{ null, null, null }, { null, null, null },
					{ null, null, null }, { null, null, null },
					{ null, null, null }, { null, null, null }, },
					new String[] { "\u8D26\u6237", "\u59D3\u540D",
							"\u5BC6\u7801" }));
		}
		return this.table_5;
	}

	private JLabel getLabel_7() {
		if (this.label_7 == null) {
			this.label_7 = new JLabel("\u662F\u5426\u7981\u7528\uFF1A");
			this.label_7.setHorizontalAlignment(SwingConstants.RIGHT);
			this.label_7.setBounds(20, 166, 108, 18);
		}
		return this.label_7;
	}

	private JRadioButton getRadioButton() {
		if (this.radioButton == null) {
			this.radioButton = new JRadioButton("\u662F");
			this.radioButton.setBounds(150, 166, 62, 18);
		}
		return this.radioButton;
	}

	private JRadioButton getRadioButton_1() {
		if (this.radioButton_1 == null) {
			this.radioButton_1 = new JRadioButton("\u5426");
			this.radioButton_1.setSelected(true);
			this.radioButton_1.setBounds(214, 166, 51, 18);
		}
		return this.radioButton_1;
	}

	private void button_32ActionPerformed(ActionEvent e) {
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
