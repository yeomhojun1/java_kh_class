package multichat;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI {
	private JTextArea jta= new JTextArea(90,25);
	private JTextField jtf= new JTextField(25);
	private String nickName;
	private ClientBackground cb= new ClientBackground()	;
	
	public ClientGUI(String nickname) {
		this.nickName= nickname;
		
	}
}
