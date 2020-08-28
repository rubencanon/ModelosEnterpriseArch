import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class EnterpriseSrchBuilder extends UIBuilder {

  private JTextField txtEnterpriseName = new JTextField(20);
  private JTextField txtNit = new JTextField(20);
  private JTextField txtCountry = new JTextField(20);
  private JTextField txtAddress = new JTextField(40);

  public void addUIControls() {
    searchUI = new JPanel();
    JLabel lblEnterpriseName = new JLabel("Enterprise Name :");
    JLabel lblNit = new JLabel("NIT:");
    JLabel lblCountry = new JLabel("Country :");
    JLabel lblAddress = new JLabel("Address :");

    
    GridBagLayout gridbag = new GridBagLayout();
    searchUI.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();
    searchUI.add(lblEnterpriseName);
    searchUI.add(txtEnterpriseName);
    searchUI.add(lblNit);
    searchUI.add(txtNit);
    searchUI.add(lblCountry);
    searchUI.add(txtCountry);
    searchUI.add(lblAddress);
    searchUI.add(txtAddress);
   
/////////////////////////
    
    gbc.anchor = GridBagConstraints.WEST;

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblEnterpriseName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblNit, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gridbag.setConstraints(lblCountry, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gridbag.setConstraints(lblAddress, gbc);
    
    
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(txtEnterpriseName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(txtNit, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(txtCountry, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gridbag.setConstraints(txtAddress, gbc);
  }

  public void initialize() {

    txtEnterpriseName.setText("Enter EnterpriseName Here");
    txtCountry.setText("Enter Country Here");
    txtNit.setText("Enter NIT Here");
    txtAddress.setText("Enter Address Here");
  }

  public String getSQL() {
    return ("Select * from Enterprise where enterpriseName='" +
            txtEnterpriseName.getText() + "'" + " and nit='" +
            txtNit.getText() + "' and country='" +
            txtCountry.getText() + "' and address='" +
            txtAddress.getText() + "'");
  }

}
