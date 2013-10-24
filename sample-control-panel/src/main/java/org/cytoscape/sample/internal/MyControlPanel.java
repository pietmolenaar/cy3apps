package org.cytoscape.sample.internal;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import javax.swing.JLabel;

public class MyControlPanel extends JPanel implements CytoPanelComponent {
	
	private static final long serialVersionUID = 8292806967891823933L;


	public MyControlPanel(GetSelectedNodesAction selectionAction) {
		
		JLabel lbXYZ = new JLabel("This is my new Control Panel");
		JButton selectBT = new JButton("Select nodes");
		selectBT.setAction(selectionAction);
		this.add(selectBT);
		this.add(lbXYZ);
		this.setVisible(true);
	}


	public Component getComponent() {
		return this;
	}


	public CytoPanelName getCytoPanelName() {
		return CytoPanelName.WEST;
	}


	public String getTitle() {
		return "Bundle App Panel";
	}


	public Icon getIcon() {
		return null;
	}
}
