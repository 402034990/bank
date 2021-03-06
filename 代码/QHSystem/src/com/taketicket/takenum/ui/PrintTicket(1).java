package com.taketicket.takenum.ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.taketicket.constant.Flavor;
import com.taketicket.util.ui.MyClock;

public class PrintTicket extends JFrame {

	private final JPanel contentPane;

	private final JLabel picLabel;
	private JLabel businessTypeLabel;
	public JLabel ticketNumLabel;
	
	private JLabel waitNumLabel;
	
	

	public JLabel getwaitNumLabel() {
		return waitNumLabel;
	}

	public void setwaitNumLabel(JLabel lblNewLabel_7) {
		this.waitNumLabel = lblNewLabel_7;
	}

	public JLabel getBusinessTypeLabel() {
		return businessTypeLabel;
	}
	
	public JLabel getticketNumLabel() {
		return ticketNumLabel;
	}

	public void setLblNewLabel_5(JLabel lblNewLabel_5) {
		this.ticketNumLabel = lblNewLabel_5;
	}



	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	//
	// EventQueue.invokeLater(new Runnable() {
	// @Override
	// public void run() {
	// try {
	// PrintTicket frame = new PrintTicket();
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
	public PrintTicket() {

		try {
			UIManager.setLookAndFeel(Flavor.FLAVOR_PATH);
		} catch (Exception e1) {
			System.out.println("change flavor fail");
		}

		this.setTitle("\u6253\u5370\u5C0F\u7968");
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 387, 399);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 381, 371);
		this.contentPane.add(layeredPane);

		JLabel lblNewLabel_1 = new JLabel(
				"\u6D66\u53D1\u94F6\u884C\u771F\u8BDA\u4E3A\u60A8\u670D\u52A1\uFF01\r\n");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 90, 381, 31);
		layeredPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"\u60A8\u4E3B\u529E\u7684\u4E1A\u52A1\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(78, 130, 129, 26);
		layeredPane.add(lblNewLabel_2);

		businessTypeLabel = new JLabel("\u666E\u901A\u4E1A\u52A1");
		businessTypeLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		businessTypeLabel.setBounds(217, 123, 106, 36);
		layeredPane.add(businessTypeLabel);

		JLabel lblNewLabel_4 = new JLabel("\u6392\u961F\u53F7\u7801\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(78, 166, 105, 15);
		layeredPane.add(lblNewLabel_4);

		ticketNumLabel = new JLabel("A001");
		ticketNumLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		ticketNumLabel.setBounds(205, 151, 90, 36);
		layeredPane.add(ticketNumLabel);

		JLabel lblNewLabel_6 = new JLabel(
				"\u60A8\u7684\u524D\u9762\u8FD8\u6709");
		lblNewLabel_6.setBounds(87, 210, 82, 15);
		layeredPane.add(lblNewLabel_6);

		waitNumLabel = new JLabel("0");
		waitNumLabel.setBounds(166, 210, 24, 15);
		layeredPane.add(waitNumLabel);

		JLabel lblNewLabel_8 = new JLabel("\u5F53\u524D\u65F6\u95F4\uFF1A");
		lblNewLabel_8.setBounds(114, 248, 69, 15);
		layeredPane.add(lblNewLabel_8);

		JLabel clockLabel = new JLabel(MyClock.getDateTime());
		clockLabel.setBounds(187, 240, 184, 31);
		MyClock.showTimeAtLabel(clockLabel);
		layeredPane.add(clockLabel);

		JLabel lblNewLabel_10 = new JLabel("\u8BF7\u7559\u5FC3\u53EB\u53F7");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(0, 273, 381, 15);
		layeredPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel(
				"\u4EBA\u5728\u7B49\u5019\uFF0C\u8BF7\u8010\u5FC3\u7B49\u5F85");
		lblNewLabel_11.setBounds(187, 210, 136, 15);
		layeredPane.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("\u8FC7\u53F7\u4F5C\u5E9F\uFF01");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(0, 313, 381, 15);
		layeredPane.add(lblNewLabel_12);

		this.picLabel = new JLabel("");
		this.picLabel.setIcon(new ImageIcon(PrintTicket.class
				.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.picLabel.setBounds(0, -12, 381, 383);
		layeredPane.add(this.picLabel);

		this.setLocationRelativeTo(null);// 窗口在屏幕中间显示
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
