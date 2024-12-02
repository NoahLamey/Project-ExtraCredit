
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExtraCredit extends JPanel {
	//frame with settings
	public static void main (String[] args) {
	JFrame window = new JFrame("Multiplication Table");
	window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
	window.setSize(500, 300);
	window.setLayout(new FlowLayout());
	
	//components
	JTextField xInput = new JTextField(5);
	JTextField yInput = new JTextField(5);
	
	
	JButton button = new JButton("Generate table");
	
	
	JTextArea results = new JTextArea(10,30);
	results.setEditable(false);
	
	//adding everything to panel and formatting
	JPanel panel1 = new JPanel();
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	
	JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	panel2.add(new JLabel("X: "));
	panel2.add(xInput);
	
	JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	panel3.add(new JLabel("Y: "));
	panel3.add(yInput);
	
	panel1.add(panel2);
	panel1.add(Box.createVerticalStrut(10));
	panel1.add(panel3);
	panel1.add(button);
	
	window.add(panel1);
	window.add(results);
	
	
	
	button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//after button is pressed this operation happens to do the multiplication
			try { 
				int x = Integer.parseInt(xInput.getText()); 
				int y = Integer.parseInt(yInput.getText()); 
				results.setText(""); 
				multiplication(1, 1, x, y, results);
			//printing exception
			} catch (NumberFormatException ex) {
				System.out.print(ex);
			}
		}
		
	});

	window.setVisible(true);
	
	
	}
	//recursion to generate the table after the button is pressed
	private static void multiplication(int r, int c, int r2, int c2, JTextArea results) {
		if(r > r2){
			return;
		} 
		
		if(c > c2){
			results.append("\n"); 
			multiplication(r + 1, 1, r2, c2, results); 
		}else{ 
				
		results.append(r + " x " + c + " = " + (r * c) + "\n");
		multiplication(r, c + 1, r2, c2, results); }
	}
}