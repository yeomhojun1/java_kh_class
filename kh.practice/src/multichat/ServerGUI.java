package multichat;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea jta = new JTextArea(40,25);
	private JTextField jtf= new JTextField(25);
	private ServerBackground sb= new ServerBackground();
	public ServerGUI() {
		setBounds(200,100,400,600);
		setTitle("서버창");
		jta.setEditable(false);
		jta.setFont(new Font("맑은 고딕",Font.PLAIN, 18));
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
//		sb.setGui(this);
//		sb.settint();
	}
	
	public void appendMsg(String msg) {
		jta.append(msg);
		jta.append("\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = jtf.getText();
		System.out.println(msg+"\n");
		jtf.setText("");
		
		
	}

	
	
	
}
