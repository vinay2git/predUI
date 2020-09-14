package rootWiser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class suggestionDetails {

	public static JFrame frmSuggestionDetails;
	private JTextField textPredictionResult,textFileParameter,textUserParameter,textReviewerParameter;

	public suggestionDetails() {
		initialize();
		try {
			frmSuggestionDetails.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initialize() {
		frmSuggestionDetails = new JFrame();
		frmSuggestionDetails.setTitle("Suggested Actions");
		frmSuggestionDetails.setBounds(200, 200, 450, 400);
		frmSuggestionDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSuggestionDetails.getContentPane().setLayout(new BorderLayout(0, 0));
		frmSuggestionDetails.setLocationRelativeTo(null);
		
		JPanel panelLogin = new JPanel();
		frmSuggestionDetails.getContentPane().add(panelLogin, BorderLayout.SOUTH);

		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSuggestionDetails.setVisible(false);
				frmSuggestionDetails.dispose();
			}
		});
		panelLogin.add(btnCancel);
	}
}
