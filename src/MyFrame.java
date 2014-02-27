
import java.awt.BorderLayout; 

import javax.swing.JPanel; 

import javax.swing.JFrame; 

import java.awt.Dimension; 

import javax.swing.JLabel; 

import java.awt.Rectangle; 

import javax.swing.JTextField; 

import javax.swing.JTextArea; 

import javax.swing.JButton; 

  

public class MyFrame extends JFrame 

 

{ 

// 

  

// String str2 = null
// GetMessage gm = new GetMessage(str2); 
// 
private static final long serialVersionUID = 1L; 

private JPanel jContentPane = null; 

private JLabel l1 = null; 

private JTextField t = null; 
 
private JLabel l2 = null; 

private JTextArea tvalue = null; 

private JLabel l3 = null;  

private JTextArea tresponse = null; 

private JButton b = null; 

/**  

 

 

* This is the default constructor 

 

 

*/  

 

public MyFrame() { 

super(); 

initialize(); 

}  
/**  

 

 

* This method initializes this 

 

 

* 

  

 

 

* @return void 

 

 

*/  

 

private void initialize() { 

 

 

this.setSize(300, 506); 

 

 

this.setContentPane(getJContentPane()); 

 

 

this.setTitle("JFrame"); 

 

}  

 

 

/**  

 

 

* This method initializes jContentPane 

 

 

* 

  

 

 

* @return javax.swing.JPanel 

 

 

*/  

 

private JPanel getJContentPane() { 

if (jContentPane == null) { 

l3 = new JLabel(); 

l3.setBounds(new Rectangle(14, 258, 44, 35)); 

l3.setText("收信箱"); 

l2 = new JLabel(); 

l2.setBounds(new Rectangle(14, 89, 43, 36)); 

l2.setText("内容");  

l1 = new JLabel(); 

l1.setBounds(new Rectangle(12, 27, 44, 28)); 

l1.setText("手机号"); 

jContentPane = new JPanel(); 

jContentPane.setLayout(null); 

jContentPane.add(l1, null); 

jContentPane.add(getT(), null);  

jContentPane.add(l2, null); 

jContentPane.add(getTvalue(), null); 

jContentPane.add(l3, null); 

jContentPane.add(getTresponse(), null); 

jContentPane.add(getB(), null); 

this.setDefaultCloseOperation(3); 

this.setVisible(true); 

}  

return jContentPane;  

}  

/**  

 

 

* This method initializes t 

 

 

 

* 

 

  

 

 

* @return javax.swing.JTextField 

 

 

 

*/  
private JTextField getT() { 

if (t == null) { 

t = new JTextField(); 

t.setBounds(new Rectangle(69, 26, 176, 32)); 

} 

return t; 

}  
/**  

 

 

* This method initializes tvalue 

 

 

 

* 

 

  

 

 

* @return javax.swing.JTextArea 

 

 

 

*/  
private JTextArea getTvalue() { 

if (tvalue == null) { 

tvalue = new JTextArea(); 

tvalue.setBounds(new Rectangle(68, 90, 180, 153)); 

} 

return tvalue; 

}  
/**  

 

 

* This method initializes tresponse 

  

 

 

* 

 

  

 

 

* @return javax.swing.JTextArea 

 

 

 

*/  
private JTextArea getTresponse() { 

if (tresponse == null) {  

tresponse = new JTextArea(); 

tresponse.setBounds(new Rectangle(67, 260, 182, 142)); 

} 

return tresponse; 

} 

/** 

 

 

* This method initializes b 

 

 

 

* 

 

 

 

 

* @return javax.swing.JButton 

 

 

 

*/ 

private JButton getB() { 

if (b == null) { 

b = new JButton(); 

b.setBounds(new Rectangle(69, 419, 96, 38)); 

b.setText("发送信息"); 

b.addActionListener(new java.awt.event.ActionListener() { 

public void actionPerformed(java.awt.event.ActionEvent e) { 

//按钮的功能编写在该方法中

String tid = t.getText();
//获取文本框的信息

String value = tvalue.getText(); 

System.out.println(tid+"#"+value); 

Thread Send = new SendMessage(tid+"#"+value); 

Send.start(); 

} 

}); 

} 

return b; 

} 

}
