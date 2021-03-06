package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.CySwingApplication;

import org.cytoscape.sample.internal.MyControlPanel;
import org.cytoscape.sample.internal.ControlPanelAction;

import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CyAction;

import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		CySwingApplication cytoscapeDesktopService = getService(bc,CySwingApplication.class);
		
		CyApplicationManager cyApplicationManager = getService(bc, CyApplicationManager.class);

		GetSelectedNodesAction getSelectedNodesAction = new GetSelectedNodesAction(cyApplicationManager);
		registerService(bc,getSelectedNodesAction,CyAction.class,new Properties());

		
		MyControlPanel myControlPanel = new MyControlPanel(getSelectedNodesAction);
		ControlPanelAction controlPanelAction = new ControlPanelAction(cytoscapeDesktopService,myControlPanel);
		
		registerService(bc,myControlPanel,CytoPanelComponent.class, new Properties());
		registerService(bc,controlPanelAction,CyAction.class, new Properties());
	}
}

