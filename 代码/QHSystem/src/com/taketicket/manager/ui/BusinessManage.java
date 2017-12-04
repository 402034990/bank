package com.taketicket.manager.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
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
import com.taketicket.entity.Business;
import com.taketicket.manager.services.impl.BusinessServiceImplJDBC;
import com.taketicket.server.dao.impl.BusinessDAOImplJDBC;
import com.taketicket.util.ui.MyClock;

public class BusinessManage extends JFrame {
	BusinessDAOImplJDBC businessDAOImplJDBC = new BusinessDAOImplJDBC();
	private final JPanel contentPane;
	private final JTable table;
	private final JTable table_1;
	private final JTable table_2;
	private final JTable table_3;
	private final JTextField textField;
	private final JTextField textField_1;
	private final JTextField textField_2;
	private final JTextField textField_3;
	private final JTextField textField_4;
	private final JTextField textField_5;
	private final JTextField textField_6;
	private final JTextField textField_7;
	private final JTextField textField_8;
	private final JTextField textField_9;
	private final JTextField textField_10;
	private final JFrame mainFrame;

	private final JLabel picLabel;
	private final JScrollPane scrollPane_1;

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
	// BusinessManage frame = new BusinessManage();
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
	public BusinessManage(JFrame mainFrame) {

		try {
			UIManager.setLookAndFeel(Flavor.FLAVOR_PATH);
		} catch (Exception e1) {
			System.out.println("change flavor fail");
		}

		this.mainFrame = mainFrame;
		this.setTitle("\u4E1A\u52A1\u7BA1\u7406");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 510, 600);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 118, 504, 377);
		this.contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("查询", null, panel, null);
		panel.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 170, 499, 2);
		panel.add(separator_1);

		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(0, 0, 504, 172);
		panel.add(this.scrollPane_1);

		this.table_3 = new JTable();
		this.scrollPane_1.setViewportView(this.table_3);
		this.table_3.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null }, }, new String[] {
				"\u5E8F\u53F7", "\u4E1A\u52A1\u4EE3\u7801",
				"\u4E1A\u52A1\u540D\u79F0",
				"\u6BCF\u5929\u6700\u5927\u529E\u7406\u91CF",
				"\u662F\u5426\u7981\u7528" }));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null,
				"\u6309\u4E1A\u52A1\u4EE3\u7801\u67E5\u8BE2",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_4.setBounds(10, 180, 235, 135);
		panel.add(panel_4);
		panel_4.setLayout(null);

		this.textField = new JTextField();
		this.textField.setBounds(40, 36, 139, 30);
		panel_4.add(this.textField);
		this.textField.setColumns(10);

		JButton btnNewButton = new JButton("\u786E\u5B9A");

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// List<Business> list = new
				// BusinessServiceImplJDBC().queryAll();

				// int j = 0;
				// for (int i = 0; i < list.size(); i++) {
				// BusinessManage.this.table_3.setValueAt("", j, 0);
				// BusinessManage.this.table_3.setValueAt("", j, 2);
				// BusinessManage.this.table_3.setValueAt("", j, 3);
				// BusinessManage.this.table_3.setValueAt("", j, 4);
				// BusinessManage.this.table_3.setValueAt("", j, 1);
				// j++;
				// }

				String code = BusinessManage.this.textField.getText();
				if (code == null || code.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "请输入代码");
					return;
				}
				Business b = new BusinessServiceImplJDBC().queryByCode(code);

				if (b == null) {
					JOptionPane.showMessageDialog(null, "请输入正确的代码");
					return;
				} else {

					DefaultTableModel tableModel = (DefaultTableModel) BusinessManage.this.table_3
							.getModel();
					tableModel.setRowCount(0);// 清除原有行
					tableModel.setRowCount(10);

					int id = b.getId();
					String name = b.getName();
					int limitCount = b.getLimitCount();
					String disable = b.getDisabled() == MyConstant.DISABLED ? "已禁用"
							: "否";

					BusinessManage.this.table_3.setValueAt(id, 0, 0);
					BusinessManage.this.table_3.setValueAt(name, 0, 2);
					BusinessManage.this.table_3.setValueAt(limitCount, 0, 3);
					BusinessManage.this.table_3.setValueAt(disable, 0, 4);
					BusinessManage.this.table_3.setValueAt(code, 0, 1);

				}

			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});

		btnNewButton.setBounds(40, 79, 65, 30);
		panel_4.add(btnNewButton);

		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessManage.this.textField.setText("");
			}
		});
		button_1.setBounds(114, 79, 65, 30);
		panel_4.add(button_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null,
				"\u6309\u4E1A\u52A1\u540D\u79F0\u67E5\u8BE2",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_5.setBounds(252, 205, 240, 135);
		panel.add(panel_5);
		panel_5.setLayout(null);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(52, 37, 148, 30);
		panel_5.add(this.textField_1);
		this.textField_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO
				// int j = 0;
				// List<Business> list = new
				// BusinessServiceImplJDBC().queryAll();
				// for (int i = 0; i < list.size(); i++) {
				//
				// BusinessManage.this.table_3.setValueAt("", j, 0);
				// BusinessManage.this.table_3.setValueAt("", j, 2);
				// BusinessManage.this.table_3.setValueAt("", j, 3);
				// BusinessManage.this.table_3.setValueAt("", j, 4);
				// BusinessManage.this.table_3.setValueAt("", j, 1);
				// j++;
				// }
				String name = BusinessManage.this.textField_1.getText();
				if (name == null || name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "请输入业务名称");
					return;
				}
				Business b = new BusinessServiceImplJDBC().queryByName(name);
				if (b == null) {
					JOptionPane.showMessageDialog(null, "请输入正确的业务名称");
					return;
				} else {

					DefaultTableModel tableModel = (DefaultTableModel) BusinessManage.this.table_3
							.getModel();
					tableModel.setRowCount(0);// 清除原有行
					tableModel.setRowCount(10);

					int id = b.getId();
					String code = b.getCode();
					int limitCount = b.getLimitCount();
					String disable = b.getDisabled() == MyConstant.DISABLED ? "已禁用"
							: "否";
					BusinessManage.this.table_3.setValueAt(id, 0, 0);
					BusinessManage.this.table_3.setValueAt(name, 0, 2);
					BusinessManage.this.table_3.setValueAt(limitCount, 0, 3);
					BusinessManage.this.table_3.setValueAt(disable, 0, 4);
					BusinessManage.this.table_3.setValueAt(code, 0, 1);

				}

			}
		});
		btnNewButton_1.setBounds(52, 80, 65, 30);
		panel_5.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessManage.this.textField_1.setText("");
			}
		});
		btnNewButton_2.setBounds(135, 80, 65, 30);
		panel_5.add(btnNewButton_2);

		JButton button = new JButton("\u67E5\u770B\u5168\u90E8");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JTable table123 = BusinessManage.this.table_3;
				BusinessManage.this.showAll123(table123);
			}

		});
		button.setBounds(402, 170, 90, 30);
		panel.add(button);

		// JLabel label_1 = new
		// JLabel("\u6309\u4E1A\u52A1\u4EE3\u7801\u67E5\u8BE2");
		// TitledBorder titledBorder = new TitledBorder("按业务代码查询");
		// label_1.setBounds(25, 222, 92, 18);
		// titledBorder.
		// panel.add(titledBorder);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("添加", null, panel_1, null);
		panel_1.setLayout(null);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 170, 499, 2);
		panel_1.add(separator_5);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 504, 172);
		panel_1.add(scrollPane_2);

		this.table_2 = new JTable();
		scrollPane_2.setViewportView(this.table_2);
		this.table_2.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null }, }, new String[] {
				"\u5E8F\u53F7", "\u4E1A\u52A1\u4EE3\u7801",
				"\u4E1A\u52A1\u540D\u79F0",
				"\u6BCF\u5929\u6700\u5927\u529E\u7406\u91CF",
				"\u662F\u5426\u7981\u7528" }));

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "\u6DFB\u52A0\u4E1A\u52A1",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_8.setBounds(57, 170, 389, 169);
		panel_1.add(panel_8);

		this.textField_4 = new JTextField();
		this.textField_4.setColumns(10);
		this.textField_4.setBounds(140, 25, 148, 30);
		panel_8.add(this.textField_4);

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("\u662F");
		rdbtnNewRadioButton.setBounds(166, 130, 53, 18);
		panel_8.add(rdbtnNewRadioButton);

		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5426");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBounds(221, 130, 53, 18);
		panel_8.add(rdbtnNewRadioButton_1);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);

		JButton button_8 = new JButton("\u786E\u5B9A");
		button_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO

				String code = BusinessManage.this.textField_4.getText();
				if (code == null || code.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "请输入业务代码");
					return;
				}
				String name = BusinessManage.this.textField_5.getText();
				if (name == null || name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "请输入业务名称");
					return;
				}

				// int a;
				// try {
				// a = Integer.valueOf(code);
				// } catch (Exception e2) {
				// // TODO: handle exception
				// JOptionPane.showMessageDialog(null, "业务代码为整数");
				// return;
				// }
				// if (a <= 0) {
				// JOptionPane.showMessageDialog(null, "业务代码为大于0的整数");
				// return;
				// }
				int limitCount = 0;
				try {
					limitCount = Integer
							.valueOf(BusinessManage.this.textField_6.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "业务量为数字");
					return;
				}
				if (limitCount <= 0) {
					JOptionPane.showMessageDialog(null, "业务办理量是大于0的整数");
					return;
				}
				int disabled = 0;
				if (rdbtnNewRadioButton.isSelected()) {
					disabled = MyConstant.DISABLED;
				}
				if (rdbtnNewRadioButton_1.isSelected()) {
					disabled = MyConstant.ABLE;
				}

				Business business = new Business(code, name, disabled,
						limitCount);

				int row = new BusinessServiceImplJDBC()
						.insertBusiness(business);

				if (row == 1) {
					JOptionPane.showMessageDialog(null, "成功插入");
				}
				if (row == 0) {
					JOptionPane.showMessageDialog(null, "插入失败");
				}

			}
		});
		button_8.setBounds(298, 113, 80, 30);
		panel_8.add(button_8);

		JButton button_9 = new JButton("\u91CD\u7F6E");
		button_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessManage.this.textField_4.setText("");
				BusinessManage.this.textField_5.setText("");
				BusinessManage.this.textField_6.setText("");
			}
		});
		button_9.setBounds(298, 82, 80, 30);
		panel_8.add(button_9);

		this.textField_5 = new JTextField();
		this.textField_5.setBounds(140, 60, 148, 30);
		panel_8.add(this.textField_5);
		this.textField_5.setColumns(10);

		this.textField_6 = new JTextField();
		this.textField_6.setBounds(140, 95, 148, 30);
		panel_8.add(this.textField_6);
		this.textField_6.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u4E1A\u52A1\u4EE3\u7801\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(20, 31, 108, 18);
		panel_8.add(lblNewLabel);

		JLabel label_1 = new JLabel("\u4E1A\u52A1\u540D\u79F0\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(20, 66, 108, 18);
		panel_8.add(label_1);

		JLabel label_2 = new JLabel(
				"\u6BCF\u5929\u6700\u5927\u529E\u7406\u91CF\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(6, 101, 122, 18);
		panel_8.add(label_2);

		JLabel label_3 = new JLabel("\u662F\u5426\u7981\u7528\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(20, 130, 108, 18);
		panel_8.add(label_3);

		JButton button_10 = new JButton("\u67E5\u770B\u5168\u90E8");
		button_10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				BusinessManage.this.showAll123(BusinessManage.this.table_2);

			}
		});
		button_10.setBounds(295, 25, 84, 30);
		panel_8.add(button_10);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("禁用", null, panel_2, null);
		panel_2.setLayout(null);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(0, 170, 499, 2);
		panel_2.add(separator_7);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 504, 172);
		panel_2.add(scrollPane_3);

		this.table_1 = new JTable();
		scrollPane_3.setViewportView(this.table_1);
		this.table_1.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null }, }, new String[] {
				"\u5E8F\u53F7", "\u4E1A\u52A1\u4EE3\u7801",
				"\u4E1A\u52A1\u540D\u79F0",
				"\u6BCF\u5929\u6700\u5927\u529E\u7406\u91CF",
				"\u662F\u5426\u7981\u7528" }));

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null,
				"\u6309\u4E1A\u52A1\u4EE3\u7801\u7981\u7528",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_6.setBounds(10, 180, 235, 135);
		panel_2.add(panel_6);

		this.textField_2 = new JTextField();
		this.textField_2.setColumns(10);
		this.textField_2.setBounds(40, 36, 139, 30);
		panel_6.add(this.textField_2);

		JButton button_3 = new JButton("\u786E\u5B9A");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String code = BusinessManage.this.textField_2.getText();
				if (code == null || code.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "代码不能为空");
					return;
				}
				Business business = new Business(code, "", MyConstant.DISABLED,
						1);
				// int flag = BusinessManage.this.businessDAOImplJDBC
				// .updateDisabledByCode(business);
				int flag = new BusinessServiceImplJDBC()
						.updateDisabledByCode(business);
				if (flag == 1) {
					JOptionPane.showMessageDialog(null, "禁用成功");
				}
				if (flag == 0) {
					JOptionPane.showMessageDialog(null, "禁用失败");
				}
			}
		});
		button_3.setBounds(40, 79, 65, 30);
		panel_6.add(button_3);

		JButton button_4 = new JButton("\u91CD\u7F6E");
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessManage.this.textField_2.setText("");
			}
		});
		button_4.setBounds(114, 79, 65, 30);
		panel_6.add(button_4);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(null,
				"\u6309\u4E1A\u52A1\u540D\u79F0\u7981\u7528",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_7.setBounds(252, 205, 240, 135);
		panel_2.add(panel_7);

		this.textField_3 = new JTextField();
		this.textField_3.setColumns(10);
		this.textField_3.setBounds(52, 37, 148, 30);
		panel_7.add(this.textField_3);

		JButton button_5 = new JButton("\u786E\u5B9A");
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String name = BusinessManage.this.textField_3.getText();

				Business business = new Business("", name, MyConstant.DISABLED,
						2);
				// int flag = BusinessManage.this.businessDAOImplJDBC
				// .updateDisabledByName(business);
				int flag = new BusinessServiceImplJDBC()
						.updateDisabledByName(business);
				if (flag == 1) {
					JOptionPane.showMessageDialog(null, "禁用成功");
				}
				if (flag == 0) {
					JOptionPane.showMessageDialog(null, "禁用失败");
				}

			}
		});
		button_5.setBounds(52, 80, 65, 30);
		panel_7.add(button_5);

		JButton button_6 = new JButton("\u91CD\u7F6E");
		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessManage.this.textField_3.setText("");
			}
		});
		button_6.setBounds(135, 80, 65, 30);
		panel_7.add(button_6);

		JButton button_7 = new JButton("\u67E5\u770B\u5168\u90E8");
		button_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				BusinessManage.this.showAll123(BusinessManage.this.table_1);

			}
		});
		button_7.setBounds(403, 170, 89, 30);
		panel_2.add(button_7);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("修改", null, panel_3, null);
		panel_3.setLayout(null);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 170, 499, 2);
		panel_3.add(separator_3);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 504, 172);
		panel_3.add(scrollPane_4);

		this.table = new JTable();
		scrollPane_4.setViewportView(this.table);
		this.table.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null }, }, new String[] {
				"\u5E8F\u53F7", "\u4E1A\u52A1\u4EE3\u7801",
				"\u4E1A\u52A1\u540D\u79F0",
				"\u6BCF\u5929\u6700\u5927\u529E\u7406\u91CF",
				"\u662F\u5426\u7981\u7528" }));
		final JPanel panel_9 = new JPanel();
		final JPanel panel_10 = new JPanel();
		panel_10.setBounds(115, 190, 274, 134);
		panel_3.add(panel_10);
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(
				null,
				"\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u4E1A\u52A1\u7684\u5E8F\u53F7",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));

		this.textField_10 = new JTextField();
		this.textField_10.setColumns(10);
		this.textField_10.setBounds(50, 51, 135, 30);
		panel_10.add(this.textField_10);

		JButton button_14 = new JButton("\u786E\u5B9A");
		button_14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = BusinessManage.this.textField_10.getText();
				int a = 0;
				try {
					a = Integer.valueOf(id);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "输入正确的数字序号");
					return;
				}

				// TODO
				if (a <= 0 || id == null || id.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "输入正确的数字序号");
					return;
				} else {

					// int j = 0;
					// List<Business> list = new BusinessServiceImplJDBC()
					// .queryAll();
					// for (int i = 0; i < list.size(); i++) {
					//
					// BusinessManage.this.table.setValueAt("", j, 0);
					// BusinessManage.this.table.setValueAt("", j, 2);
					// BusinessManage.this.table.setValueAt("", j, 3);
					// BusinessManage.this.table.setValueAt("", j, 4);
					// BusinessManage.this.table.setValueAt("", j, 1);
					// j++;
					// }

					DefaultTableModel tableModel = (DefaultTableModel) BusinessManage.this.table
							.getModel();
					tableModel.setRowCount(0);// 清除原有行
					tableModel.setRowCount(10);

					// Business business = new
					// BusinessDAOImplJDBC().queryById(id);
					Business business = new BusinessServiceImplJDBC()
							.queryById(id);

					if (business == null) {
						JOptionPane.showMessageDialog(null, "输入有误");
						return;
					}
					String code = business.getCode();
					int disable = business.getDisabled();
					int limitCount = business.getLimitCount();
					String name = business.getName();

					BusinessManage.this.table.setValueAt(id, 0, 0);
					BusinessManage.this.table.setValueAt(name, 0, 2);
					BusinessManage.this.table.setValueAt(limitCount, 0, 3);
					BusinessManage.this.table.setValueAt(disable, 0, 4);
					BusinessManage.this.table.setValueAt(code, 0, 1);

					panel_10.setVisible(false);
					panel_9.setVisible(true);

				}
			}
		});
		button_14.setBounds(50, 93, 65, 30);
		panel_10.add(button_14);

		JButton button_15 = new JButton("\u91CD\u7F6E");
		button_15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessManage.this.textField_10.setText("");
			}
		});
		button_15.setBounds(120, 93, 65, 30);
		panel_10.add(button_15);

		JButton button_13 = new JButton("\u67E5\u770B\u5168\u90E8");
		button_13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				BusinessManage.this.showAll123(BusinessManage.this.table);

			}
		});
		button_13.setBounds(181, 16, 87, 30);
		panel_10.add(button_13);

		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(null, "\u4FEE\u6539\u4E1A\u52A1",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_9.setBounds(57, 170, 389, 169);
		panel_3.add(panel_9);
		panel_9.setVisible(false);

		this.textField_7 = new JTextField();
		this.textField_7.setColumns(10);
		this.textField_7.setBounds(140, 25, 148, 30);
		panel_9.add(this.textField_7);
		final JRadioButton radioButton = new JRadioButton("\u662F");
		radioButton.setBounds(150, 130, 57, 18);
		panel_9.add(radioButton);

		final JRadioButton radioButton_1 = new JRadioButton("\u5426");
		radioButton_1.setSelected(true);
		radioButton_1.setBounds(221, 130, 57, 18);
		panel_9.add(radioButton_1);
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(radioButton);
		buttonGroup2.add(radioButton_1);

		JButton button_11 = new JButton("\u786E\u5B9A");
		button_11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(BusinessManage.this.textField_10
						.getText());
				String code = BusinessManage.this.textField_7.getText();
				String name = BusinessManage.this.textField_8.getText();
				if (name == null || name.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "业务名称不能为空");
					return;
				}
				if (code == null || code.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "业务代码不能为空");
					return;
				}
				// if (code.equals(name)) {
				// JOptionPane.showMessageDialog(null, "业务名称与业务代码不能相同");
				// return;
				// }

				int limitCount = 0;
				int disabled = 0;
				try {
					limitCount = Integer
							.valueOf(BusinessManage.this.textField_9.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,
							"输入正确的办理量（只能为大于等于0小于99999的数字）");
					return;

				}
				if (radioButton.isSelected()) {
					disabled = MyConstant.DISABLED;
				}
				if (radioButton_1.isSelected()) {
					disabled = MyConstant.ABLE;
				}
				Business business = new Business(id, code, name, disabled,
						limitCount);
				int a = 0;
				try {
					// a = new
					// BusinessDAOImplJDBC().updateBusinessById(business);
					a = new BusinessServiceImplJDBC()
							.updateBusinessById(business);
					if (a == 1) {
						JOptionPane.showMessageDialog(null, "修改成功");
					} else {
						JOptionPane.showMessageDialog(null, "修改不成功");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "业务代码或业务名称重复，请重新输入");
					return;
				}

			}
		});
		button_11.setBounds(302, 113, 76, 30);
		panel_9.add(button_11);

		JButton button_12 = new JButton("\u53D6\u6D88");
		button_12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessManage.this.textField_7.setText("");
				BusinessManage.this.textField_8.setText("");
				BusinessManage.this.textField_9.setText("");
				panel_10.setVisible(true);
				panel_9.setVisible(false);
			}
		});
		button_12.setBounds(302, 82, 76, 30);
		panel_9.add(button_12);

		this.textField_8 = new JTextField();
		this.textField_8.setColumns(10);
		this.textField_8.setBounds(140, 60, 148, 30);
		panel_9.add(this.textField_8);

		this.textField_9 = new JTextField();
		this.textField_9.setColumns(10);
		this.textField_9.setBounds(140, 95, 148, 30);
		panel_9.add(this.textField_9);

		JLabel label_4 = new JLabel("\u4E1A\u52A1\u4EE3\u7801\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(20, 31, 108, 18);
		panel_9.add(label_4);

		JLabel label_5 = new JLabel("\u4E1A\u52A1\u540D\u79F0\uFF1A");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(20, 66, 108, 18);
		panel_9.add(label_5);

		JLabel label_6 = new JLabel(
				"\u6BCF\u5929\u6700\u5927\u529E\u7406\u91CF\uFF1A");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(6, 101, 122, 18);
		panel_9.add(label_6);

		JLabel label_7 = new JLabel("\u662F\u5426\u7981\u7528\uFF1A");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(20, 130, 108, 18);
		panel_9.add(label_7);

		JButton button_16 = new JButton("\u67E5\u770B\u5168\u90E8");
		button_16.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				BusinessManage.this.showAll123(BusinessManage.this.table);

			}
		});
		button_16.setBounds(287, 25, 91, 30);
		panel_9.add(button_16);

		JButton button_2 = new JButton("\u4E3B\u83DC\u5355");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BusinessManage.this.button_2ActionPerformed(e);
			}

		});
		button_2.setBounds(12, 520, 102, 39);
		this.contentPane.add(button_2);

		JLabel clockLabel = new JLabel(MyClock.getDateTime());
		clockLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		MyClock.showTimeAtLabel(clockLabel);
		clockLabel.setBounds(271, 516, 223, 39);
		this.contentPane.add(clockLabel);

		this.picLabel = new JLabel("");
		this.picLabel.setIcon(new ImageIcon(BusinessManage.class
				.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.picLabel.setBounds(0, 0, 504, 572);
		this.contentPane.add(this.picLabel);

		this.setLocationRelativeTo(null);// 窗口在屏幕中间显示
	}

	private void showAll123(JTable table123) {
		List<Business> list = new BusinessServiceImplJDBC().queryAll();
		if (list == null || list.size() == 0) {
			JOptionPane.showMessageDialog(null, "数据库中暂无数据");
			return;
		}

		DefaultTableModel tableModel = (DefaultTableModel) table123.getModel();
		tableModel.setRowCount(0);// 清除原有行
		if (list.size() < 10) {
			tableModel.setRowCount(10);
		} else {
			tableModel.setRowCount(list.size());
		}

		int j = 0;
		for (int i = 0; i < list.size(); i++) {
			Business business = list.get(i);

			int id = business.getId();
			String code = business.getCode();
			String disable = business.getDisabled() == MyConstant.DISABLED ? "已禁用"
					: "否";

			int limitCount = business.getLimitCount();
			String name = business.getName();

			table123.setValueAt(id, j, 0);
			table123.setValueAt(name, j, 2);
			table123.setValueAt(limitCount, j, 3);
			table123.setValueAt(disable, j, 4);
			table123.setValueAt(code, j, 1);
			j++;
		}
	}

	private void button_2ActionPerformed(ActionEvent e) {
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
