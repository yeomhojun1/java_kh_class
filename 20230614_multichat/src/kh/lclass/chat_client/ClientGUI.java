package kh.lclass.chat_client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -7102614246813124677L;
	private JTextArea jta= new JTextArea(90,25);
	private JTextField jtf= new JTextField(25);
	private String nickName ;
	private ClientBackground cb= new ClientBackground(); 
	//채팅 socket기능을 담당할 객체
	public ClientGUI(String nickname) {
		this.nickName = nickname;
		cb.setNickName(nickname);
		
		setBounds(600,100,400,600);
		setTitle(nickname+"님 창");
		jta.setEditable(false);
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18));
		jta.setBackground(new Color(100,70,100));
		
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		cb.setGui(this);
		cb.connection();
		
	}
	public void appendMsg(String msg) {
		//jta (채팅창)에 msg를 추가함
		jta.append(msg);
		jta.append("\n");
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg= jtf.getText();
		System.out.println(msg);
		jtf.setText("");
		//todo server에 전달하기 위해 background에 전달함
		cb.sendMessage(msg);
	}
}

