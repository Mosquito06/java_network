package java_network.udp;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChattingFrame extends JFrame {
	private JTextArea ta;
	private JTextField tf;
	private Messenger messenger;
	
	
	public ChattingFrame(String title, int myPort, int otherPort, String addr) throws HeadlessException {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tf = new JTextField(30);
		tf.addActionListener(listener);
		
		ta = new JTextArea(10, 30);
		ta.setEditable(false);
		
		add(tf, BorderLayout.SOUTH);
		add(ta, BorderLayout.CENTER);
		pack();
		
		messenger = new Messenger(myPort, otherPort, addr);
		messenger.setTextArea(ta);
		messenger.start();
		
		setVisible(true);
	}

	ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String msg = tf.getText().trim();
			messenger.sendMessage(msg);
			ta.append("SEND :" + msg + "\n");
			tf.selectAll();
			ta.setCaretPosition(ta.getDocument().getLength());
			
		}
	};
	
}
