package kh.lclass.chat_client;

import javax.swing.JOptionPane;

public class ClientRUn {

	public static void main(String[] args) {
		String nickName= JOptionPane.showInputDialog("닉네임을 입력해주세요. ");
		new ClientGUI(nickName);
	}

}
