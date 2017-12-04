package com.taketicket.manager.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.taketicket.constant.Flavor;
import com.taketicket.util.ui.MyClock;

public class TheLog extends JFrame {

	private final JPanel contentPane;
	private final JTable table_3;
	private final JFrame mainFrame;

	private final JLabel picLabel;

	public JTable getTable_3() {
		return this.table_3;
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
	// TheLog frame = new TheLog();
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
	public TheLog(JFrame mainFrame) {
		this.setTitle("\u65E5\u5FD7\u8BB0\u5F55");

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

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 118, 504, 345);
		this.contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("日志记录", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 504, 320);
		panel.add(scrollPane_1);

		this.table_3 = new JTable();
		scrollPane_1.setViewportView(this.table_3);
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
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
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
				"\u65F6\u95F4\u6BB5", "IP", "\u67DC\u5458\u59D3\u540D",
				"\u4E1A\u52A1\u7C7B\u578B", "\u529E\u7406\u4EBA\u6570" }));

		JButton button_2 = new JButton("\u4E3B\u83DC\u5355");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TheLog.this.button_2ActionPerformed(e);
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
		this.picLabel.setIcon(new ImageIcon(TheLog.class
				.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.picLabel.setBounds(0, 0, 504, 572);
		this.contentPane.add(this.picLabel);

		this.setLocationRelativeTo(null);// 窗口在屏幕中间显示
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
