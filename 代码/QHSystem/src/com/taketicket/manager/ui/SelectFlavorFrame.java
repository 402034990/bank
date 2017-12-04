package com.taketicket.manager.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.taketicket.constant.Flavor;

public class SelectFlavorFrame extends JFrame {

	private final JPanel contentPane;
	private final MainFrame mainFrame;

	private final JLabel picLabel;
	private JButton btnTexture;
	private JButton btnBernstein;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// @Override
	// public void run() {
	// try {
	// SelectFlavorFrame frame = new SelectFlavorFrame();
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
	public SelectFlavorFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 444, 271);
		this.contentPane.add(layeredPane);

		JButton btnMac = new JButton("\u82F9\u679C\u98CE\u683C");
		btnMac.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectFlavorFrame.this.btnMacActionPerformed(e);
			}

		});
		btnMac.setBounds(165, 70, 111, 38);
		layeredPane.add(btnMac);

		JButton btnWindows = new JButton("Window\u98CE\u683C");
		btnWindows.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectFlavorFrame.this.btnWindowsActionPerformed(e);
			}

		});
		btnWindows.setBounds(300, 70, 111, 38);
		layeredPane.add(btnWindows);

		JButton btnHifi = new JButton("\u9ED1\u8272\u98CE\u683C");
		btnHifi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectFlavorFrame.this.btnHifiActionPerformed(e);
			}

		});
		btnHifi.setBounds(33, 162, 111, 38);
		layeredPane.add(btnHifi);

		JButton btnNimbus = new JButton("\u9ED8\u8BA4\u98CE\u683C");
		btnNimbus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectFlavorFrame.this.btnNimbusActionPerformed(e);
			}

		});
		btnNimbus.setBounds(33, 70, 111, 38);
		layeredPane.add(btnNimbus);
		layeredPane.add(this.getBtnTexture());
		layeredPane.add(this.getBtnBernstein());

		this.picLabel = new JLabel("");
		this.picLabel.setIcon(new ImageIcon(SelectFlavorFrame.class
				.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.picLabel.setBounds(0, 0, 444, 271);
		layeredPane.add(this.picLabel);
	}

	private void btnMacActionPerformed(ActionEvent e) {
		Flavor.FLAVOR_PATH = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
		Flavor.BACKGROUND_ICON_PATH = "";

		this.changeFlavor();
	}

	private void btnNimbusActionPerformed(ActionEvent e) {
		Flavor.FLAVOR_PATH = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
		Flavor.BACKGROUND_ICON_PATH = "/resource/images/background/5.jpg";

		this.changeFlavor();
	}

	private void btnTextureActionPerformed(ActionEvent e) {
		Flavor.FLAVOR_PATH = "com.jtattoo.plaf.texture.TextureLookAndFeel";
		Flavor.BACKGROUND_ICON_PATH = "";

		this.changeFlavor();
	}

	private void btnBernsteinActionPerformed(ActionEvent e) {
		Flavor.FLAVOR_PATH = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
		Flavor.BACKGROUND_ICON_PATH = "";

		this.changeFlavor();
	}

	private void btnWindowsActionPerformed(ActionEvent e) {
		Flavor.FLAVOR_PATH = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		Flavor.BACKGROUND_ICON_PATH = "";

		this.changeFlavor();

	}

	private void btnHifiActionPerformed(ActionEvent e) {
		Flavor.FLAVOR_PATH = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
		Flavor.BACKGROUND_ICON_PATH = "";

		this.changeFlavor();

	}

	private void changeFlavor() {

		this.mainFrame.updateFlavor();
		this.updateFlavor();

		this.mainFrame.getPicJLabel().setIcon(
				new ImageIcon(MainFrame.class
						.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.getPicLabel().setIcon(
				new ImageIcon(MainFrame.class
						.getResource(Flavor.BACKGROUND_ICON_PATH)));

		BusinessManage businessManage = (BusinessManage) this.mainFrame
				.getBusinessManagement();

		CheckForSituation checkForSituation = (CheckForSituation) this.mainFrame
				.getCheckForSituation();

		Data data = (Data) this.mainFrame.getData();

		Login login = (Login) this.mainFrame.getLogin();

		TheLog theLog = (TheLog) this.mainFrame.getTheLog();

		UserManage userManage = (UserManage) this.mainFrame.getUserManage();

		WindowManage windowManage = (WindowManage) this.mainFrame
				.getWindowManage();

		if (!(businessManage == null)) {
			businessManage.getPicLabel().setIcon(
					new ImageIcon(MainFrame.class
							.getResource(Flavor.BACKGROUND_ICON_PATH)));
			businessManage.updateFlavor();
		}
		if (!(checkForSituation == null)) {
			checkForSituation.getPicLabel().setIcon(
					new ImageIcon(MainFrame.class
							.getResource(Flavor.BACKGROUND_ICON_PATH)));
			checkForSituation.updateFlavor();
		}
		if (!(data == null)) {
			data.getPicLabel().setIcon(
					new ImageIcon(MainFrame.class
							.getResource(Flavor.BACKGROUND_ICON_PATH)));
			data.updateFlavor();
		}
		if (!(login == null)) {
			login.getPicLabel().setIcon(
					new ImageIcon(MainFrame.class
							.getResource(Flavor.BACKGROUND_ICON_PATH)));
			login.updateFlavor();
		}
		if (!(theLog == null)) {
			theLog.getPicLabel().setIcon(
					new ImageIcon(MainFrame.class
							.getResource(Flavor.BACKGROUND_ICON_PATH)));
			theLog.updateFlavor();
		}
		if (!(userManage == null)) {
			userManage.getPicLabel().setIcon(
					new ImageIcon(MainFrame.class
							.getResource(Flavor.BACKGROUND_ICON_PATH)));
			userManage.updateFlavor();
		}
		if (!(windowManage == null)) {
			windowManage.getPicLabel().setIcon(
					new ImageIcon(MainFrame.class
							.getResource(Flavor.BACKGROUND_ICON_PATH)));
			windowManage.updateFlavor();
		}

	}

	public void updateFlavor() {
		try {
			UIManager.setLookAndFeel(Flavor.FLAVOR_PATH);
		} catch (Exception e1) {
			System.out.println("change flavor fail");
		}
		SwingUtilities.updateComponentTreeUI(this.getContentPane());
	}

	private JButton getBtnTexture() {
		if (this.btnTexture == null) {
			this.btnTexture = new JButton("\u6728\u8D28\u9ED1\u98CE\u683C");
			this.btnTexture.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SelectFlavorFrame.this.btnTextureActionPerformed(e);
				}
			});
			this.btnTexture.setBounds(165, 162, 111, 38);
		}
		return this.btnTexture;
	}

	private JButton getBtnBernstein() {
		if (this.btnBernstein == null) {
			this.btnBernstein = new JButton("\u9EC4\u8272\u98CE\u683C");
			this.btnBernstein.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SelectFlavorFrame.this.btnBernsteinActionPerformed(e);
				}
			});
			this.btnBernstein.setBounds(300, 162, 111, 38);
		}
		return this.btnBernstein;
	}
}
