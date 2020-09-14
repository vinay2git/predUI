package rootWiser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RootWiseGUI {

	private JFrame frame;
	private JSONObject json;
	private final Action action = new SwingAction();
	private final Action action2 = new SwingAction2();
	private JTextPane textPane;
	private static final Map<String, String> sampleResponseMap = new HashMap<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RootWiseGUI window = new RootWiseGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RootWiseGUI() {
		initData();
		initialize();
	}

	private void initData() {

		String jsonManual = "{" + 
				"  \"passRateFactors\" : {" + 
				"    \"reviewerParameterValueLowPassrate\" : true," + 
				"    \"userParameterValueLowPassrate\" : true," + 
				"    \"fileParameterValueLowPassrate\" : true" + 
				"  }," + 
				"  \"relevanceFactors\" : {" + 
				"    \"fileParameterValueLowRelevance\" : false," + 
				"    \"userParameterValueLowRelevance\" : false," + 
				"    \"reviewerParameterValueLowRelevance\" : true" + 
				"  }," + 
				"  \"probableInfraIssues\" : [ \"The run is invalid or Timed out due to infra structure issues\", \"[2018-03-02 13:13:58 UTC][postBoot][RuntimeError] Demo content initialization failed!nimbusmtsgitnimbuslibtestframeworksvratestvra-postboot-util.rb:1215:in `install_single_old_demo_content_pack'\", \"[2018-03-05 22:24:10 UTC][postBoot][RuntimeError] The following error(s) occured while executing SSH command \", \"[2018-03-06 17:29:06 UTC][vcqa-launcher][LoadError] cannot load such file -- mtsgitnimbuslibtestframeworksvratestvra-testbed-horizon-win2012-postboot.rbmtsgitnimbuslibtestframeworksvratestvra-testbed-vrb-postboot.rb:1:in `require_relative'\", \"[2018-03-02 07:13:44 UTC][deployment][RbVmomi::VIM::DuplicateName] DuplicateName: The name 'svc.vra-cat-aut-vcqa-cat-63463862-0.vra-iaas-template.0' already exists.nimbusmtsgitrbvmomilibrbvmomivimTask.rb:11:in `wait_for_completion'\" ]," + 
				"  \"probableTestIssues\" : [ \"Functional-vSphere\", \"Install-HA-UI\", \"Upgrade-72\", \"B2B-Upgrade-71\", \"Preflight-Integration-Tests-Horizon2\" ]," + 
				"  \"recommendedReviewers\" : [ \"Philip Balinov\" ]," + 
				"  \"suggestedRemediation\" : \"Needs more Testing AND Review\"," + 
				"  \"changeId\" : \"ad43ea559b07070be91e44f399b01738e68adeaa\"," + 
				"  \"tokenActivationRecommeded\" : \"Token activation needs manual decision\"," + 
				"  \"tokenActivationRecommendationReason\" : \"Low pass rate of change but High relevance\"," + 
				"  \"infraStability\" : \"HIGH\"," + 
				"  \"testStability\" : \"HIGH\"," + 
				"  \"releveant\" : true" + 
				"}";

		String jsonGood = "{" + 
				"  \"passRateFactors\" : {" + 
				"    \"reviewerParameterValueLowPassrate\" : false," + 
				"    \"userParameterValueLowPassrate\" : false," + 
				"    \"fileParameterValueLowPassrate\" : false" + 
				"  }," + 
				"  \"relevanceFactors\" : {" + 
				"    \"fileParameterValueLowRelevance\" : false," + 
				"    \"userParameterValueLowRelevance\" : false," + 
				"    \"reviewerParameterValueLowRelevance\" : true" + 
				"  }," + 
				"  \"probableInfraIssues\" : [ \"The run is invalid or Timed out due to infra structure issues\", \"[2018-03-02 13:13:58 UTC][postBoot][RuntimeError] Demo content initialization failed!nimbusmtsgitnimbuslibtestframeworksvratestvra-postboot-util.rb:1215:in `install_single_old_demo_content_pack'\", \"[2018-03-05 22:24:10 UTC][postBoot][RuntimeError] The following error(s) occured while executing SSH command \", \"[2018-03-06 17:29:06 UTC][vcqa-launcher][LoadError] cannot load such file -- mtsgitnimbuslibtestframeworksvratestvra-testbed-horizon-win2012-postboot.rbmtsgitnimbuslibtestframeworksvratestvra-testbed-vrb-postboot.rb:1:in `require_relative'\", \"[2018-03-02 07:13:44 UTC][deployment][RbVmomi::VIM::DuplicateName] DuplicateName: The name 'svc.vra-cat-aut-vcqa-cat-63463862-0.vra-iaas-template.0' already exists.nimbusmtsgitrbvmomilibrbvmomivimTask.rb:11:in `wait_for_completion'\" ]," + 
				"  \"probableTestIssues\" : [ \"Functional-vSphere\", \"Install-HA-UI\", \"Upgrade-72\", \"B2B-Upgrade-71\", \"Preflight-Integration-Tests-Horizon2\" ]," + 
				"  \"recommendedReviewers\" : [ \"Bryan Halter\", \"Martin Draganchev (c)\", \"Georgi Peshterski\", \"Philip Balinov\", \"Dora Laskova\" ]," + 
				"  \"suggestedRemediation\" : \"Needs more Review\"," + 
				"  \"changeId\" : \"e8feb60864c8b6a93e973fb63266536c8cd68833\"," + 
				"  \"tokenActivationRecommeded\" : \"Token activation recommended\"," + 
				"  \"tokenActivationRecommendationReason\" : \"High pass rate of change\"," + 
				"  \"infraStability\" : \"HIGH\"," + 
				"  \"testStability\" : \"HIGH\"," + 
				"  \"releveant\" : true" + 
				"}";

		String jsonBad = "{" + 
				"  \"passRateFactors\" : {" + 
				"    \"reviewerParameterValueLowPassrate\" : true," + 
				"    \"userParameterValueLowPassrate\" : true," + 
				"    \"fileParameterValueLowPassrate\" : false" + 
				"  }," + 
				"  \"relevanceFactors\" : {" + 
				"    \"fileParameterValueLowRelevance\" : true," + 
				"    \"userParameterValueLowRelevance\" : false," + 
				"    \"reviewerParameterValueLowRelevance\" : true" + 
				"  }," + 
				"  \"probableInfraIssues\" : [ \"The run is invalid or Timed out due to infra structure issues\", \"[2018-03-02 13:13:58 UTC][postBoot][RuntimeError] Demo content initialization failed!nimbusmtsgitnimbuslibtestframeworksvratestvra-postboot-util.rb:1215:in `install_single_old_demo_content_pack'\", \"[2018-03-05 22:24:10 UTC][postBoot][RuntimeError] The following error(s) occured while executing SSH command \", \"[2018-03-06 17:29:06 UTC][vcqa-launcher][LoadError] cannot load such file -- mtsgitnimbuslibtestframeworksvratestvra-testbed-horizon-win2012-postboot.rbmtsgitnimbuslibtestframeworksvratestvra-testbed-vrb-postboot.rb:1:in `require_relative'\", \"[2018-03-02 07:13:44 UTC][deployment][RbVmomi::VIM::DuplicateName] DuplicateName: The name 'svc.vra-cat-aut-vcqa-cat-63463862-0.vra-iaas-template.0' already exists.nimbusmtsgitrbvmomilibrbvmomivimTask.rb:11:in `wait_for_completion'\" ]," + 
				"  \"probableTestIssues\" : [ \"Functional-vSphere\", \"Install-HA-UI\", \"Upgrade-72\", \"B2B-Upgrade-71\", \"Preflight-Integration-Tests-Horizon2\" ]," + 
				"  \"recommendedReviewers\" : [ \"Bryan Halter\", \"Martin Draganchev (c)\", \"Georgi Peshterski\", \"Philip Balinov\", \"Dora Laskova\" ]," + 
				"  \"suggestedRemediation\" : \"Needs more Testing AND Review\"," + 
				"  \"changeId\" : \"2f4fd6135cd9a8e54c9e86052a8009fbc402127e\"," + 
				"  \"tokenActivationRecommeded\" : \"Token activation not recommended\"," + 
				"  \"tokenActivationRecommendationReason\" : \"Low pass rate of change and Low relevance\"," + 
				"  \"infraStability\" : \"HIGH\"," + 
				"  \"testStability\" : \"HIGH\"," + 
				"  \"releveant\" : false" + 
				"}";


		sampleResponseMap.put("e8feb60864c8b6a93e973fb63266536c8cd68833", jsonGood);
		sampleResponseMap.put("2f4fd6135cd9a8e54c9e86052a8009fbc402127e", jsonBad);
		sampleResponseMap.put("ad43ea559b07070be91e44f399b01738e68adeaa", jsonManual);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblRootwiseDelivering = new JLabel("RootWise - Delivering Software wisely");
		lblRootwiseDelivering.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblRootwiseDelivering.setBounds(99, 11, 515, 65);
		frame.getContentPane().add(lblRootwiseDelivering);

		JLabel lblEnterTheChange = new JLabel("Enter the Change ID for which you want to predict  success of build");
		lblEnterTheChange.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblEnterTheChange.setBounds(47, 121, 641, 42);
		frame.getContentPane().add(lblEnterTheChange);

		textPane = new JTextPane();
		textPane.setBounds(150, 221, 424, 42);
		frame.getContentPane().add(textPane);

		JButton btnPredict = new JButton("Predict");
		btnPredict.setAction(action);
		btnPredict.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnPredict.setBounds(276, 346, 186, 49);
		btnPredict.setActionCommand("predict");
		frame.getContentPane().add(btnPredict);
	}

	private class SwingAction2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction2() {
			putValue(NAME, "Get Recommendations and Suggested Remediations");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			frame = new JFrame();
			frame.setBounds(100, 100, 728, 579);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setVisible(true);

			JLabel lblSuggestedRemediationApproach = new JLabel("Suggested Remediation Approach");
			lblSuggestedRemediationApproach.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblSuggestedRemediationApproach.setHorizontalAlignment(SwingConstants.CENTER);
			lblSuggestedRemediationApproach.setBounds(196, 11, 382, 39);
			frame.add(lblSuggestedRemediationApproach);

			JTextField textField_7 = new JTextField();
			textField_7.setBounds(206, 61, 354, 39);
			textField_7.setHorizontalAlignment(SwingConstants.CENTER);
			textField_7.setFont(new Font("Tahoma", Font.BOLD, 16));
			frame.add(textField_7);
			textField_7.setColumns(10);
			try {
				textField_7.setText(json.getString("suggestedRemediation"));
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			JLabel lblProbableInfrastructureIssues = new JLabel("Probable Infrastructure Issues");
			lblProbableInfrastructureIssues.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblProbableInfrastructureIssues.setBounds(21, 149, 316, 33);
			frame.add(lblProbableInfrastructureIssues);

			JLabel lblRecommendedTestsTo = new JLabel("Recommended Tests to run");
			lblRecommendedTestsTo.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblRecommendedTestsTo.setBounds(21, 261, 316, 33);
			frame.add(lblRecommendedTestsTo);

			JLabel lblRecommendedReviewers = new JLabel("Recommended Reviewers");
			lblRecommendedReviewers.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblRecommendedReviewers.setBounds(21, 397, 316, 33);
			frame.add(lblRecommendedReviewers);

			DefaultListModel<String> model1 = new DefaultListModel<>();
			DefaultListModel<String> model2 = new DefaultListModel<>();
			DefaultListModel<String> model3 = new DefaultListModel<>();
			
			
			JList list_1 = new JList(model2);
			list_1.setBounds(349, 239, 354, 89);
			frame.add(list_1);

			JList list = new JList(model1);
			list.setBounds(349, 118, 354, 89);
			frame.add(list);

			JList list_2 = new JList(model3);
			list_2.setBounds(349, 376, 354, 89);
			frame.add(list_2);
			
			JSONArray listHolder;
			try {
				listHolder = json.getJSONArray("probableInfraIssues");

				for (int i = 0; i < listHolder.length(); i++) {
					model1.add(i, listHolder.getString(i));
				}
				
				listHolder = json.getJSONArray("probableTestIssues");

				for (int i = 0; i < listHolder.length(); i++) {
					model2.add(i, listHolder.getString(i));
				}
				
				listHolder = json.getJSONArray("recommendedReviewers");

				for (int i = 0; i < listHolder.length(); i++) {
					model3.add(i, listHolder.getString(i));
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
		}
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Predict");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String changeId = textPane.getText().trim();
			json = null;
			String value = null;
			try {
				json = new JSONObject(sampleResponseMap.get(changeId));

				frame.setVisible(false);
				frame = new JFrame();
				frame.setBounds(100, 100, 728, 579);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				frame.setVisible(true);
				JLabel lblRootwisePrediction = new JLabel("RootWise Prediction");
				lblRootwisePrediction.setFont(new Font("Tahoma", Font.PLAIN, 31));
				lblRootwisePrediction.setBounds(43, 53, 279, 79);
				frame.add(lblRootwisePrediction);

				JTextField textField = new JTextField();
				textField.setBackground(Color.WHITE);
				textField.setBounds(332, 74, 296, 47);
				textField.setColumns(10);
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setFont(new Font("Tahoma", Font.BOLD, 18));

				switch (json.getString("tokenActivationRecommeded")) {
				case "Token activation not recommended":
					textField.setForeground(Color.RED);
					textField.setText("Change is predicted to FAIL");
					break;
				case "Token activation recommended":
					textField.setForeground(Color.GREEN);
					textField.setText("Change is predicted to PASS");
					break;
				default:
					textField.setForeground(Color.BLUE);
					textField.setText("MANUAL intervention needed");
				}

				frame.add(textField);

				JLabel label = new JLabel(
						"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				label.setBounds(10, 143, 707, 20);
				frame.add(label);

				JLabel lblFactorsForPrediction = new JLabel("Factors for prediction");
				lblFactorsForPrediction.setFont(new Font("Tahoma", Font.PLAIN, 21));
				lblFactorsForPrediction.setBounds(43, 181, 209, 35);
				frame.add(lblFactorsForPrediction);

				JLabel lblDeveloperSuccessRate = new JLabel("Developer Success Rate");
				lblDeveloperSuccessRate.setBounds(82, 239, 155, 14);
				frame.add(lblDeveloperSuccessRate);

				JLabel lblMeanArtifactSuccess = new JLabel("Artifact Success Rate");
				lblMeanArtifactSuccess.setBounds(82, 319, 139, 14);
				frame.add(lblMeanArtifactSuccess);

				JLabel lblMeanReviewerSuccess = new JLabel("Reviewer Success Rate");
				lblMeanReviewerSuccess.setBounds(82, 415, 155, 14);
				frame.add(lblMeanReviewerSuccess);

				JLabel lblFrequencyOfDeveloper = new JLabel("Freq Developer Checkins");
				lblFrequencyOfDeveloper.setBounds(369, 239, 171, 14);
				frame.add(lblFrequencyOfDeveloper);

				JLabel lblFrequencyOfArtifact = new JLabel("Freq Artifact Modifications");
				lblFrequencyOfArtifact.setBounds(369, 319, 190, 14);
				frame.add(lblFrequencyOfArtifact);

				JLabel lblFrequencyOfReviewer = new JLabel("Freq Reviewer Review");
				lblFrequencyOfReviewer.setBounds(369, 415, 171, 14);
				frame.add(lblFrequencyOfReviewer);

				JTextField textField_1 = new JTextField();
				textField_1.setHorizontalAlignment(SwingConstants.CENTER);
				textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				textField_1.setBounds(236, 236, 86, 20);
				frame.add(textField_1);
				textField_1.setColumns(10);
				value = json.getJSONObject("passRateFactors").getBoolean("userParameterValueLowPassrate") ? "Low"
						: "High";
				textField_1.setText(value);

				JTextField textField_2 = new JTextField();
				textField_2.setBounds(236, 316, 86, 20);
				textField_2.setHorizontalAlignment(SwingConstants.CENTER);
				textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				frame.add(textField_2);
				textField_2.setColumns(10);
				value = json.getJSONObject("passRateFactors").getBoolean("fileParameterValueLowPassrate") ? "Low"
						: "High";
				textField_2.setText(value);

				JTextField textField_3 = new JTextField();
				textField_3.setBounds(236, 412, 86, 20);
				textField_3.setHorizontalAlignment(SwingConstants.CENTER);
				textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
				frame.add(textField_3);
				textField_3.setColumns(10);
				value = json.getJSONObject("passRateFactors").getBoolean("reviewerParameterValueLowPassrate")
						? "Low"
								: "High";
				textField_3.setText(value);

				JTextField textField_4 = new JTextField();
				textField_4.setBounds(567, 236, 86, 20);
				textField_4.setHorizontalAlignment(SwingConstants.CENTER);
				textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
				frame.add(textField_4);
				textField_4.setColumns(10);
				value = json.getJSONObject("relevanceFactors").getBoolean("userParameterValueLowRelevance") ? "Low"
						: "High";
				textField_4.setText(value);

				JTextField textField_5 = new JTextField();
				textField_5.setBounds(567, 316, 86, 20);
				textField_5.setHorizontalAlignment(SwingConstants.CENTER);
				textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
				frame.add(textField_5);
				textField_5.setColumns(10);
				value = json.getJSONObject("relevanceFactors").getBoolean("fileParameterValueLowRelevance") ? "Low"
						: "High";
				textField_5.setText(value);

				JTextField textField_6 = new JTextField();
				textField_6.setBounds(567, 412, 86, 20);
				textField_6.setHorizontalAlignment(SwingConstants.CENTER);
				textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
				frame.add(textField_6);
				textField_6.setColumns(10);
				value = json.getJSONObject("relevanceFactors").getBoolean("reviewerParameterValueLowRelevance")
						? "Low"
								: "High";
				textField_6.setText(value);

				JButton btnGetRecommendationsAnd = new JButton("Get Recommendations and Suggested Remediations");
				btnGetRecommendationsAnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnGetRecommendationsAnd.setBounds(82, 455, 557, 43);
				btnGetRecommendationsAnd.setAction(action2);
				btnGetRecommendationsAnd.setActionCommand("reco");
				
				if (json.getString("tokenActivationRecommeded").equalsIgnoreCase("Token activation recommended")) {
					btnGetRecommendationsAnd.setEnabled(false);
				}
				
				frame.add(btnGetRecommendationsAnd);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}
}
