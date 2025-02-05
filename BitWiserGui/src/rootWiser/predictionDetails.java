package rootWiser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class predictionDetails {

	public static JFrame frmPredictionDetails;
	private JTextField textPredictionResult,textFileParameter,textUserParameter,textReviewerParameter;

	public predictionDetails() {
		initialize();
		try {
			frmPredictionDetails.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initialize() {
		frmPredictionDetails = new JFrame();
		frmPredictionDetails.setTitle("ChangeSet Predictions");
		frmPredictionDetails.setBounds(200, 200, 450, 400);
		frmPredictionDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPredictionDetails.getContentPane().setLayout(new BorderLayout(0, 0));
		frmPredictionDetails.setLocationRelativeTo(null);
		
		JPanel panelRootWise = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelRootWise.getLayout();
		flowLayout.setVgap(50);
		frmPredictionDetails.getContentPane().add(panelRootWise, BorderLayout.CENTER);
		
		JPanel panelPrediction = new JPanel();
		panelRootWise.add(panelPrediction);
		
		JLabel lblRootWise = new JLabel("RootWiswe Prediction:", SwingConstants.CENTER);
		panelRootWise.add(lblRootWise);

		

		textPredictionResult = new JTextField("");
		panelRootWise.add(textPredictionResult);
		textPredictionResult.setColumns(20);
		textPredictionResult.setText("MANUAL INTERVENTION REQUIRED");
		
		JPanel panelFactors = new JPanel();
		panelRootWise.add(panelFactors);
		
		JLabel lblFactors = new JLabel("<html>Factors Influencing Prediction</br></br> </html>", SwingConstants.CENTER);
		panelRootWise.add(lblFactors);
		
		JPanel panelFileParameter = new JPanel();
		panelRootWise.add(panelFileParameter);
		
		JLabel lblFileParameter = new JLabel("<html></br>File Parameter :</html>", SwingConstants.CENTER);
		panelRootWise.add(lblFileParameter);

		

		textFileParameter = new JTextField("");
		panelRootWise.add(textFileParameter);
		textFileParameter.setColumns(10);
		textFileParameter.setText("HIGH");
		
		JPanel panelUserParameter = new JPanel();
		panelRootWise.add(panelUserParameter);
		
		JLabel lblUserParameter = new JLabel("<html></br>User Parameter :</html>", SwingConstants.CENTER);
		panelRootWise.add(lblUserParameter);

		

		textUserParameter = new JTextField("");
		panelRootWise.add(textUserParameter);
		textUserParameter.setColumns(10);
		textUserParameter.setText("HIGH");
		
		JPanel panelReviewerParameter = new JPanel();
		panelRootWise.add(panelReviewerParameter);
		
		JLabel lblReviewerParameter = new JLabel("<html></br>Reviewer Parameter :</html>", SwingConstants.CENTER);
		panelRootWise.add(lblReviewerParameter);

		

		textReviewerParameter = new JTextField("");
		panelRootWise.add(textReviewerParameter);
		textReviewerParameter.setColumns(10);
		textReviewerParameter.setText("LOW");
		
		JPanel panelLogin = new JPanel();
		frmPredictionDetails.getContentPane().add(panelLogin, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Get Recommendation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
				{
				new suggestionDetails();
				frmPredictionDetails.setVisible(false);
				}
			});
		panelLogin.add(btnNewButton);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPredictionDetails.setVisible(false);
				frmPredictionDetails.dispose();
			}
		});
		panelLogin.add(btnCancel);
		
			}
		
		
	}



