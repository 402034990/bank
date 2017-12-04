package com.taketicket.manager.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.taketicket.entity.Business_WindowVO;
import com.taketicket.entity.Window;
import com.taketicket.manager.services.BusinessService;
import com.taketicket.manager.services.WindowService;
import com.taketicket.manager.services.impl.BusinessServiceImplJDBC;
import com.taketicket.manager.services.impl.WindowServiceImplJDBC;
import com.taketicket.util.ui.MyClock;

public class WindowManage extends JFrame {

	private final JPanel contentPane;
	private final JTable table;
	private final JTable table_1;
	private final JTable table_2;
	private final JTable table_3;
	private final JTextField textField;
	private final JTextField textField_1;
	private final JTextField textField_2;
	private final JTextField textField_3;
	private final JTextField numTextField_4;
	private final JTextField textField_7;
	private final JTextField textField_8;
	private final JTextField textField_10;
	private JComboBox businessTypeComboBox;
	private final JFrame mainFrame;

	private final WindowService windowService = new WindowServiceImplJDBC();
	private final BusinessService businessService = new BusinessServiceImplJDBC();
	private final JRadioButton yesRadioButton;
	private final JRadioButton noRadioButton;

	JRadioButton radioButton = new JRadioButton("确定");
	JRadioButton radioButton_1 = new JRadioButton("取消");

	private final JPanel panel_9 = new JPanel();
	private final JPanel panel_10 = new JPanel();
	JComboBox comboBox_1 = new JComboBox();

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
	// WindowManage frame = new WindowManage();
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
	public WindowManage(JFrame mainFrame) {

		try {
			UIManager.setLookAndFeel(Flavor.FLAVOR_PATH);
		} catch (Exception e1) {
			System.out.println("change flavor fail");
		}

		this.mainFrame = mainFrame;
		this.setTitle("\u7A97\u53E3\u7BA1\u7406");
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

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 504, 172);
		panel.add(scrollPane_1);

		this.table_3 = new JTable();
		scrollPane_1.setViewportView(this.table_3);
		this.table_3.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "\u4E1A\u52A1\u5E8F\u53F7",
						"\u9ED8\u8BA4\u4E1A\u52A1\u7C7B\u578B",
						"\u7A97\u53E3\u53F7", "\u662F\u5426\u7981\u7528" }));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null,
				"\u6309\u7A97\u53E3\u53F7\u67E5\u8BE2", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_4.setBounds(10, 180, 235, 135);
		panel.add(panel_4);
		panel_4.setLayout(null);

		this.textField = new JTextField();
		this.textField.setBounds(40, 36, 139, 30);
		panel_4.add(this.textField);
		this.textField.setColumns(10);

		JButton okButton1_1 = new JButton("\u786E\u5B9A");
		okButton1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.okButton1_1ActionPerformed(e);
			}

		});
		okButton1_1.setBounds(40, 79, 66, 30);
		panel_4.add(okButton1_1);

		JButton resetButton1_1 = new JButton("\u91CD\u7F6E");
		resetButton1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.textField.setText("");
			}
		});
		resetButton1_1.setBounds(113, 79, 66, 30);
		panel_4.add(resetButton1_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\u6309\u4E1A\u52A1\u7C7B\u578B\u67E5\u8BE2",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_5.setBounds(252, 205, 240, 135);
		panel.add(panel_5);
		panel_5.setLayout(null);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(52, 37, 148, 30);
		panel_5.add(this.textField_1);
		this.textField_1.setColumns(10);

		JButton okButton1_2 = new JButton("\u786E\u5B9A");
		okButton1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.okButton1_2ActionPerformed(e);
			}

		});
		okButton1_2.setBounds(52, 80, 66, 30);
		panel_5.add(okButton1_2);

		JButton resetButton1_2 = new JButton("\u91CD\u7F6E");
		resetButton1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.textField_1.setText("");
			}
		});
		resetButton1_2.setBounds(134, 80, 66, 30);
		panel_5.add(resetButton1_2);

		JButton showAll = new JButton("\u67E5\u770B\u5168\u90E8");
		showAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.showAllActionPerformed(e);
			}

		});
		showAll.setBounds(395, 170, 97, 30);
		panel.add(showAll);

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
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "\u4E1A\u52A1\u5E8F\u53F7",
						"\u9ED8\u8BA4\u4E1A\u52A1\u7C7B\u578B",
						"\u7A97\u53E3\u53F7", "\u662F\u5426\u7981\u7528" }));

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null,
				"\u6DFB\u52A0\u65B0\u7A97\u53E3", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_8.setBounds(57, 170, 389, 169);
		panel_1.add(panel_8);

		this.numTextField_4 = new JTextField();
		this.numTextField_4.setColumns(10);
		this.numTextField_4.setBounds(140, 41, 148, 30);
		panel_8.add(this.numTextField_4);

		JButton okButton_8 = new JButton("\u786E\u5B9A");
		okButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.okButton_8ActionPerformed(e);
			}

		});
		okButton_8.setBounds(302, 113, 76, 30);
		panel_8.add(okButton_8);

		JButton resetButton_9 = new JButton("\u91CD\u7F6E");
		resetButton_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		resetButton_9.setBounds(302, 82, 76, 30);
		panel_8.add(resetButton_9);

		this.yesRadioButton = new JRadioButton("\u662F");
		this.yesRadioButton.setBounds(166, 130, 53, 18);
		panel_8.add(this.yesRadioButton);

		this.noRadioButton = new JRadioButton("\u5426");
		this.noRadioButton.setSelected(true);
		this.noRadioButton.setBounds(221, 130, 53, 18);
		panel_8.add(this.noRadioButton);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(this.yesRadioButton);
		buttonGroup.add(this.noRadioButton);

		JLabel lblNewLabel = new JLabel("\u7A97\u53E3\u53F7\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(20, 47, 108, 18);
		panel_8.add(lblNewLabel);

		JLabel label_1 = new JLabel(
				"\u9ED8\u8BA4\u4E1A\u52A1\u7C7B\u578B\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(20, 88, 108, 18);
		panel_8.add(label_1);

		JLabel label_3 = new JLabel("\u662F\u5426\u7981\u7528\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(20, 130, 108, 18);
		panel_8.add(label_3);

		JButton showAllButton_10 = new JButton("\u67E5\u770B\u5168\u90E8");
		showAllButton_10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.showAllButton_10ActionPerformed(e);
			}

		});
		showAllButton_10.setBounds(289, 25, 89, 30);
		panel_8.add(showAllButton_10);
		panel_8.add(this.getBusinessTypeComboBox());

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
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "\u4E1A\u52A1\u5E8F\u53F7",
						"\u9ED8\u8BA4\u4E1A\u52A1\u7C7B\u578B",
						"\u7A97\u53E3\u53F7", "\u662F\u5426\u7981\u7528" }));

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null,
				"\u6309\u7A97\u53E3\u53F7\u7981\u7528", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_6.setBounds(10, 180, 235, 135);
		panel_2.add(panel_6);

		this.textField_2 = new JTextField();
		this.textField_2.setColumns(10);
		this.textField_2.setBounds(40, 36, 139, 30);
		panel_6.add(this.textField_2);

		JButton okButton_3 = new JButton("\u786E\u5B9A");
		okButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.okButton_3ActionPerformed(e);
			}

		});
		okButton_3.setBounds(40, 79, 66, 30);
		panel_6.add(okButton_3);

		JButton resetButton_4 = new JButton("\u91CD\u7F6E");
		resetButton_4.setBounds(113, 79, 66, 30);
		panel_6.add(resetButton_4);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\u6309\u4E1A\u52A1\u7C7B\u578B\u7981\u7528",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
						59)));
		panel_7.setBounds(252, 205, 240, 135);
		panel_2.add(panel_7);

		this.textField_3 = new JTextField();
		this.textField_3.setColumns(10);
		this.textField_3.setBounds(52, 37, 148, 30);
		panel_7.add(this.textField_3);

		JButton okButton_5 = new JButton("\u786E\u5B9A");
		okButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.okButton_5ActionPerformed(e);
			}

		});
		okButton_5.setBounds(52, 80, 67, 30);
		panel_7.add(okButton_5);

		JButton resetButton_6 = new JButton("\u91CD\u7F6E");
		resetButton_6.setBounds(133, 80, 67, 30);
		panel_7.add(resetButton_6);

		JButton showAllButton_7 = new JButton("\u67E5\u770B\u5168\u90E8");
		showAllButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.showAllButton_7ActionPerformed(e);
			}

		});
		showAllButton_7.setBounds(396, 170, 96, 30);
		panel_2.add(showAllButton_7);

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
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "\u4E1A\u52A1\u5E8F\u53F7",
						"\u9ED8\u8BA4\u4E1A\u52A1\u7C7B\u578B",
						"\u7A97\u53E3\u53F7", "\u662F\u5426\u7981\u7528" }));

		this.panel_10.setBounds(115, 190, 280, 134);
		panel_3.add(this.panel_10);
		this.panel_10.setLayout(null);
		this.panel_10
				.setBorder(new TitledBorder(
						null,
						"\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7A97\u53E3\u7684\u5E8F\u53F7",
						TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(59, 59, 59)));

		this.textField_10 = new JTextField();
		this.textField_10.setColumns(10);
		this.textField_10.setBounds(49, 51, 149, 30);
		this.panel_10.add(this.textField_10);

		JButton okButton_14 = new JButton("\u786E\u5B9A");
		okButton_14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.okButton_14ActionPerformed(e);

			}

		});
		okButton_14.setBounds(49, 93, 66, 30);
		this.panel_10.add(okButton_14);

		JButton resetButton_15 = new JButton("\u91CD\u7F6E");
		resetButton_15.setBounds(133, 93, 65, 30);
		this.panel_10.add(resetButton_15);

		JButton showAllButton_13 = new JButton("\u67E5\u770B\u5168\u90E8");
		showAllButton_13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.showAllButton_13ActionPerformed(e);
			}

		});
		showAllButton_13.setBounds(176, 16, 92, 30);
		this.panel_10.add(showAllButton_13);

		this.panel_9.setLayout(null);
		this.panel_9.setBorder(new TitledBorder(null,
				"\u4FEE\u6539\u7A97\u53E3", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)));
		this.panel_9.setBounds(57, 170, 389, 169);
		panel_3.add(this.panel_9);
		this.panel_9.setVisible(false);

		this.textField_7 = new JTextField();
		this.textField_7.setEnabled(false);
		this.textField_7.setEditable(false);
		this.textField_7.setColumns(10);
		this.textField_7.setBounds(140, 25, 148, 30);
		this.panel_9.add(this.textField_7);

		JButton button_11 = new JButton("\u786E\u5B9A");
		button_11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				WindowManage.this.button_11ActionPerformed(e);

			}

		});
		button_11.setBounds(302, 113, 76, 30);
		this.panel_9.add(button_11);

		JButton cancelButton_12 = new JButton("\u53D6\u6D88");
		cancelButton_12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.panel_9.setVisible(false);
				WindowManage.this.panel_10.setVisible(true);
			}
		});
		cancelButton_12.setBounds(302, 82, 76, 30);
		this.panel_9.add(cancelButton_12);

		this.textField_8 = new JTextField();
		this.textField_8.setColumns(10);
		this.textField_8.setBounds(140, 60, 148, 30);
		this.panel_9.add(this.textField_8);

		this.radioButton.setBounds(150, 130, 57, 18);
		this.panel_9.add(this.radioButton);

		this.radioButton_1.setSelected(true);
		this.radioButton_1.setBounds(221, 130, 57, 18);
		this.panel_9.add(this.radioButton_1);

		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(this.radioButton);
		buttonGroup2.add(this.radioButton_1);

		JLabel label_4 = new JLabel("\u5E8F\u53F7\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(20, 31, 108, 18);
		this.panel_9.add(label_4);

		JLabel label_5 = new JLabel("\u7A97\u53E3\u53F7\uFF1A");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(20, 66, 108, 18);
		this.panel_9.add(label_5);

		JLabel label_6 = new JLabel(
				"\u9ED8\u8BA4\u4E1A\u52A1\u7C7B\u578B\uFF1A");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(6, 101, 122, 18);
		this.panel_9.add(label_6);

		JLabel label_7 = new JLabel("\u662F\u5426\u7981\u7528\uFF1A");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(20, 130, 108, 18);
		this.panel_9.add(label_7);

		JButton showAllButton_16 = new JButton("\u67E5\u770B\u5168\u90E8");
		showAllButton_16.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.showAllButton_16ActionPerformed(e);
			}

		});
		showAllButton_16.setBounds(283, 25, 95, 30);
		this.panel_9.add(showAllButton_16);

		this.comboBox_1.setModel(new DefaultComboBoxModel(new String[] {
				"\u666E\u901A\u4E1A\u52A1", "VIP\u4E1A\u52A1",
				"\u5BF9\u516C\u4E1A\u52A1" }));
		this.comboBox_1.setBounds(140, 96, 148, 28);
		this.panel_9.add(this.comboBox_1);

		JButton button_2 = new JButton("\u4E3B\u83DC\u5355");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowManage.this.button_2ActionPerformed(e);
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
		this.picLabel.setIcon(new ImageIcon(WindowManage.class
				.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.picLabel.setBounds(0, 0, 504, 572);
		this.contentPane.add(this.picLabel);

		this.setLocationRelativeTo(null);// 窗口在屏幕中间显示
	}

	private void button_11ActionPerformed(ActionEvent e) {

		int id = Integer.valueOf(this.textField_7.getText());

		String numStr = this.textField_8.getText();
		if (numStr == null || numStr.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "请输入窗口号", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int num = 0;
		try {

			num = Integer.valueOf(numStr);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "请输入数字", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		String businessName = (String) this.comboBox_1.getSelectedItem();
		int disabled = MyConstant.ABLE;
		if (this.radioButton.isSelected()) {
			disabled = MyConstant.DISABLED;
		}
		Business business = this.businessService.queryByName(businessName);

		Window window = new Window(id, num, business.getId(), disabled);

		int rows = 0;
		try {
			rows = this.windowService.updateWindowById(window);
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage(), "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (rows == 0) {
			JOptionPane.showMessageDialog(null, "添加失败", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			JOptionPane.showMessageDialog(null, "添加成功", "提示",
					JOptionPane.PLAIN_MESSAGE);
			return;
		}
	}

	private void okButton_14ActionPerformed(ActionEvent e) {

		String idStr = this.textField_10.getText();
		if (idStr == null || idStr.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "请输入窗口序号", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int id = 0;
		try {

			id = Integer.valueOf(idStr);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "请输入数字", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Window window = this.windowService.queryWindowById(id);
		if (window == null) {
			JOptionPane.showMessageDialog(null, "请输入正确的窗口序号", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			this.panel_10.setVisible(false);
			this.panel_9.setVisible(true);
			this.textField_7.setText(idStr);
			this.textField_8.setText("" + window.getNum());
		}

	}

	private void okButton_5ActionPerformed(ActionEvent e) {
		String businessName = this.textField_3.getText();
		if (businessName == null || businessName.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "请输入业务类型", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// System.out.println(businessName);
		Business business = this.businessService.queryByName(businessName);
		if (business == null) {
			JOptionPane.showMessageDialog(null, "禁用失败", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int rows = this.windowService.updateDisabledByBusinessId(business
				.getId());
		if (rows == 0) {
			JOptionPane.showMessageDialog(null, "禁用失败", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			JOptionPane.showMessageDialog(null, "禁用成功", "提示",
					JOptionPane.PLAIN_MESSAGE);
			this.showAll(this.table_1);
			return;
		}
	}

	private void okButton_3ActionPerformed(ActionEvent e) {
		String numStr = this.textField_2.getText();
		if (numStr == null || numStr.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "请输入窗口号", "错误提示",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		int num = 0;
		try {

			num = Integer.valueOf(numStr);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "请输入数字", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int rows = this.windowService.updateDisabledByNum(num);
		if (rows == 0) {
			JOptionPane.showMessageDialog(null, "禁用失败", "错误提示",
					JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			JOptionPane.showMessageDialog(null, "禁用成功", "提示",
					JOptionPane.INFORMATION_MESSAGE);
			this.showAll(this.table_1);
			return;
		}
	}

	private void okButton_8ActionPerformed(ActionEvent e) {

		String numStr = this.numTextField_4.getText();
		if (numStr == null || numStr.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "请输入窗口号", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int num = 0;
		try {

			num = Integer.valueOf(numStr);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "请输入数字", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// int idx = this.businessTypeComboBox.getSelectedIndex();
		// System.out.println(idx);
		String businessName = (String) this.businessTypeComboBox
				.getSelectedItem();
		// System.out.println(obj);
		int disabled = MyConstant.ABLE;
		if (this.yesRadioButton.isSelected()) {
			disabled = MyConstant.DISABLED;
		}
		Business business = this.businessService.queryByName(businessName);

		if (business == null) {
			JOptionPane.showMessageDialog(null, "暂无此业务类型", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Window window = new Window(num, business.getId(), disabled);

		int rows = 0;
		try {
			rows = this.windowService.insertWindow(window);
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage(), "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (rows == 0) {
			JOptionPane.showMessageDialog(null, "添加失败", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			JOptionPane.showMessageDialog(null, "添加成功", "提示",
					JOptionPane.PLAIN_MESSAGE);
			return;
		}

	}

	private void showAllButton_16ActionPerformed(ActionEvent e) {
		this.showAll(this.table);
	}

	private void showAllButton_13ActionPerformed(ActionEvent e) {
		this.showAll(this.table);
	}

	private void showAllButton_7ActionPerformed(ActionEvent e) {
		this.showAll(this.table_1);
	}

	private void showAllButton_10ActionPerformed(ActionEvent e) {
		this.showAll(this.table_2);
	}

	private void showAllActionPerformed(ActionEvent e) {

		this.showAll(this.table_3);
	}

	private void showAll(JTable table_100) {

		List<Business_WindowVO> lists = this.windowService
				.queryAllForBusinessVO();
		if (lists == null || lists.size() == 0) {
			// System.out.println(windows == null);
			JOptionPane.showMessageDialog(null, "数据库中暂无数据", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// System.out.println(windows.size());
		DefaultTableModel tableModel = (DefaultTableModel) table_100.getModel();
		tableModel.setRowCount(0);// 清除原有行
		if (lists.size() < 10) {

			tableModel.setRowCount(10);
		} else {
			tableModel.setRowCount(lists.size());
		}
		for (int i = 0; i < lists.size(); i++) {

			Business_WindowVO vo = lists.get(i);

			String disabled = "否";
			if (vo.getWindowDisabled() == MyConstant.DISABLED) {
				disabled = "已禁用";
			}

			table_100.setValueAt(vo.getWindowId(), i, 0);
			table_100.setValueAt(vo.getBusinessName(), i, 1);
			table_100.setValueAt(vo.getWindowNum(), i, 2);
			table_100.setValueAt(disabled, i, 3);
		}
	}

	private void okButton1_2ActionPerformed(ActionEvent e) {

		String name = this.textField_1.getText();
		if (name == null || name.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "请输入数据", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		List<Business_WindowVO> lists = this.windowService
				.queryByBusinessNameForBusinessVO(name);

		if (lists == null) {
			JOptionPane.showMessageDialog(null, "您输入错误", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// System.out.println(window);
		DefaultTableModel tableModel = (DefaultTableModel) this.table_3
				.getModel();
		tableModel.setRowCount(0);// 清除原有行
		if (lists.size() < 10) {
			tableModel.setRowCount(10);
		} else {
			tableModel.setRowCount(lists.size());
		}
		for (int i = 0; i < lists.size(); i++) {

			Business_WindowVO vo = lists.get(i);

			String disabled = "否";
			if (vo.getWindowDisabled() == MyConstant.DISABLED) {
				disabled = "已禁用";
			}

			this.table_3.setValueAt(vo.getWindowId(), i, 0);
			this.table_3.setValueAt(vo.getBusinessName(), i, 1);
			this.table_3.setValueAt(vo.getWindowNum(), i, 2);
			this.table_3.setValueAt(disabled, i, 3);
		}
	}

	private void okButton1_1ActionPerformed(ActionEvent e) {

		String numStr = this.textField.getText();
		if (numStr == null || numStr.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "请输入数据", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int num = 0;
		try {

			num = Integer.valueOf(numStr);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "请输入数字", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		List<Business_WindowVO> lists = this.windowService
				.queryByNumForBusinessVO(num);

		if (lists == null || lists.size() == 0) {
			JOptionPane.showMessageDialog(null, "您输入窗口号错误", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// System.out.println(window);
		DefaultTableModel tableModel = (DefaultTableModel) this.table_3
				.getModel();
		tableModel.setRowCount(0);// 清除原有行
		if (lists.size() < 10) {
			tableModel.setRowCount(10);
		} else {
			tableModel.setRowCount(lists.size());
		}
		for (int i = 0; i < lists.size(); i++) {

			Business_WindowVO vo = lists.get(i);

			String disabled = "否";
			if (vo.getWindowDisabled() == MyConstant.DISABLED) {
				disabled = "已禁用";
			}

			this.table_3.setValueAt(vo.getWindowId(), i, 0);
			this.table_3.setValueAt(vo.getBusinessName(), i, 1);
			this.table_3.setValueAt(vo.getWindowNum(), i, 2);
			this.table_3.setValueAt(disabled, i, 3);
		}

	}

	private JComboBox getBusinessTypeComboBox() {
		if (this.businessTypeComboBox == null) {
			this.businessTypeComboBox = new JComboBox();
			this.businessTypeComboBox.setModel(new DefaultComboBoxModel(
					new String[] { "\u666E\u901A\u4E1A\u52A1",
							"VIP\u4E1A\u52A1", "\u5BF9\u516C\u4E1A\u52A1" }));
			this.businessTypeComboBox.setBounds(140, 83, 148, 28);
		}
		return this.businessTypeComboBox;
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
