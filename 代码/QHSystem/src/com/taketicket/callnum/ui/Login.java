package com.taketicket.callnum.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.taketicket.callnum.services.impl.CallerLoginServiceImplJDBC;
import com.taketicket.constant.Flavor;
import com.taketicket.constant.MyConstant;
import com.taketicket.entity.Business;
import com.taketicket.entity.Caller;
import com.taketicket.entity.Window;
import com.taketicket.manager.services.WindowService;
import com.taketicket.manager.services.impl.BusinessServiceImplJDBC;
import com.taketicket.manager.services.impl.WindowServiceImplJDBC;
import com.taketicket.util.ui.MyClock;

public class Login extends JFrame {

	private final JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private final JLabel lblNewLabel_1 = new JLabel("\u7A97\u53E3\r\n\uFF1A");
	private final JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\uFF1A");
	private final JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801\uFF1A");
	private final JTextField usernameField;
	private final JPasswordField passwordField;
	private JFrame work;
	private final JLabel picLabel;
	private JLabel lblNewLabel;
	private final JComboBox businessNamecomboBox;

	private String businessName;
	private String callerName;
	private int callerId;
	private final BusinessServiceImplJDBC businessServiceImplJDBC = new BusinessServiceImplJDBC();
	private final WindowService windowerviceimplJDBC = new WindowServiceImplJDBC();
	private int windowNum;

	public int getWindowNum() {
		return this.windowNum;
	}

	public String getCallerName() {
		return this.callerName;
	}

	public int getCallerId() {
		return this.callerId;
	}

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

					Login frame = new Login();
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
	public Login() {

		try {
			UIManager.setLookAndFeel(Flavor.FLAVOR_PATH);
		} catch (Exception e1) {
			System.out.println("change flavor fail");
		}

		this.setResizable(false);
		this.setTitle("\u53EB\u53F7\u7CFB\u7EDF\u767B\u5F55");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 297);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		this.layeredPane.setBounds(0, 0, 443, 269);
		this.contentPane.add(this.layeredPane);
		this.lblNewLabel_1.setBounds(127, 68, 75, 31);

		this.layeredPane.add(this.lblNewLabel_1);
		this.lblNewLabel_2.setBounds(127, 111, 75, 31);

		this.layeredPane.add(this.lblNewLabel_2);
		this.lblNewLabel_3.setBounds(127, 152, 75, 31);

		this.layeredPane.add(this.lblNewLabel_3);

		this.businessNamecomboBox = new JComboBox();
		this.businessNamecomboBox.setModel(new DefaultComboBoxModel(
				new String[] { "VIP\u4E1A\u52A1", "\u666E\u901A\u4E1A\u52A1",
						"\u5BF9\u516C\u4E1A\u52A1" }));
		this.businessNamecomboBox.setSelectedIndex(0);
		this.businessNamecomboBox.setBounds(180, 68, 153, 28);
		this.layeredPane.add(this.businessNamecomboBox);

		this.passwordField = new JPasswordField();
		this.passwordField.setBounds(180, 152, 153, 28);
		this.layeredPane.add(this.passwordField);

		this.usernameField = new JTextField();
		this.usernameField.setBounds(180, 110, 153, 28);
		this.layeredPane.add(this.usernameField);
		this.usernameField.setColumns(10);

		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.this.btnNewButtonActionPerformed(e);
			}
		});
		loginButton.setBounds(149, 203, 153, 44);
		this.layeredPane.add(loginButton);

		JLabel clockLabel = new JLabel(MyClock.getDateTime());
		MyClock.showTimeAtLabel(clockLabel);
		clockLabel.setBounds(10, 10, 180, 23);
		this.layeredPane.add(clockLabel);

		this.picLabel = new JLabel("");
		this.picLabel.setIcon(new ImageIcon(Login.class
				.getResource(Flavor.BACKGROUND_ICON_PATH)));
		this.picLabel.setBounds(0, 0, 443, 269);
		this.layeredPane.add(this.picLabel);

		this.setLocationRelativeTo(null);// 窗口在屏幕中间显示
	}

	private void btnNewButtonActionPerformed(ActionEvent evt) {

		if (this.usernameField.getText().isEmpty()
				|| this.passwordField.getText().isEmpty()) {
			String msg = "账号或密码不能为空";
			this.showDialog(msg);
			return;
		}
		CallerLoginServiceImplJDBC csj = new CallerLoginServiceImplJDBC();
		Caller caller = null;
		caller = csj.queryByAccount(this.usernameField.getText());
		// System.out.println(this.usernameField.getText());
		if (caller == null) {

			this.showDialog("您输入的账号名错误");
			return;
		}
		if (caller.getDisabled() == MyConstant.DISABLED) {

			this.showDialog("该帐户被禁用");
			return;
		}

		String password = caller.getPassword();

		if (!password.equals(this.passwordField.getText())) {
			this.showDialog("您输入的密码错误");
			return;
		}

		this.callerName = caller.getName();
		this.callerId = caller.getId();

		// TODO 根据业务名称查出业务Id 再查出对应窗口号并把传到标签上显示

		this.businessName = (String) this.businessNamecomboBox
				.getSelectedItem();
		// System.out.println(businessName);

		String businessname = this.getBusinessName();// 获取对应业务类型名称BusinessName
		// System.out.println(businessname);
		Business business = this.businessServiceImplJDBC
				.queryByName(businessname);// 查询到businessID

		if (business == null) {
			this.showDialog("暂无该业务");
			return;
		}
		if (business.getDisabled() == MyConstant.DISABLED) {
			this.showDialog("该业务已被禁用");
			return;
		}

		Window window = this.windowerviceimplJDBC
				.queryWindowByBusinessId(business.getId());

		if (window == null) {
			this.showDialog("暂无该业务对应的窗口");
			return;
		}
		// System.out.println(business.getId());
		// System.out.println(window.getNum());

		this.windowNum = window.getNum();
		// ******************************

		// if (this.work == null) {
		// System.out.println("创建work对象");
		// this.work = new Work(this);
		//
		// }

		this.work = new Work(this);
		this.usernameField.setText("");
		this.passwordField.setText("");
		this.work.setVisible(true);
		this.setVisible(false);
		this.dispose();

	}

	private void showDialog(String msg) {
		JOptionPane.showMessageDialog(null, msg, "错误提示",
				JOptionPane.ERROR_MESSAGE);
	}

	public String getBusinessName() {
		return this.businessName;
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
