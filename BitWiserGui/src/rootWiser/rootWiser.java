package rootWiser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.ActionEvent;

public class rootWiser {

	public static JFrame frmRootWise;
	private JTextField textChangeSetID, textField1;
	private JLabel lblNewLabel, lblNewLabel1;
	private String changeSetId;
	private URL url;
	private HttpURLConnection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new rootWiser();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					rootWiser.frmRootWise.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public rootWiser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRootWise = new JFrame();
		frmRootWise.setTitle("RootWise");
		frmRootWise.setBounds(100, 100, 450, 300);
		frmRootWise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRootWise.getContentPane().setLayout(new BorderLayout(0, 0));
		frmRootWise.setLocationRelativeTo(null);
		
		JPanel panelRootWise = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelRootWise.getLayout();
		flowLayout.setVgap(40);
		frmRootWise.getContentPane().add(panelRootWise, BorderLayout.CENTER);
		
		JPanel panelUsername = new JPanel();
		panelRootWise.add(panelUsername);
		
		JLabel lblRootWise = new JLabel("<html>Welcome to Root Wise <br/><br/> Enter ChangeSet ID:</html>", SwingConstants.CENTER);
		panelRootWise.add(lblRootWise);

		//JLabel lblChangeSet = new JLabel("");
		//panelRootWise.add(lblChangeSet);
		/*JLabel lblRootWise = new JLabel("RootWise Prediction:");
		panelRootWise.add(lblRootWise);
		lblRootWise.setVisible(false);*/

		textChangeSetID = new JTextField("");
		panelRootWise.add(textChangeSetID);
		textChangeSetID.setColumns(30);
		
			JPanel panelLogin = new JPanel();
			frmRootWise.getContentPane().add(panelLogin, BorderLayout.SOUTH);
	
			JButton btnNewButton = new JButton("Prediction");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
				changeSetId = textChangeSetID.getText();
				new predictionDetails();
				frmRootWise.setVisible(false);
				
				try {
					url = new URL("http://10.196.79.132:9092/analyzer/predict/" + changeSetId);
					con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					int status = con.getResponseCode();
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						content.append(inputLine);

					}
					in.close();

					JSONObject myResponse;
					try {
						myResponse = new JSONObject(content.toString());
						System.out.println("filePassRate- " + myResponse.getJSONObject("passRateFactors")
								.getBoolean("fileParameterValueLowPassrate"));
						//lblNewLabel1.setVisible(true);

					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		});
			panelLogin.add(btnNewButton);
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmRootWise.setVisible(false);
					frmRootWise.dispose();
				}
			});
			panelLogin.add(btnCancel);
	}

}
