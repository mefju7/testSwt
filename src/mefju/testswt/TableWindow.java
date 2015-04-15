package mefju.testswt;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class TableWindow extends Shell {
	
	
	private Table tblRoutes;
	private Table tblWaypoints;
	
	

	public TableWindow(Display display) throws Exception {
		
		super(display, SWT.SHELL_TRIM);
		
		setSize(641, 414);
		setLayout(new GridLayout(2, true));
		
		Label lblRoutes = new Label(this, SWT.NONE);
		lblRoutes.setText("Routes");
		
		Label lblWaypoints = new Label(this, SWT.NONE);
		lblWaypoints.setText("Waypoints");
		
		TableViewer tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblRoutes = tableViewer.getTable();
		tblRoutes.setLinesVisible(true);
		tblRoutes.setHeaderVisible(true);
		tblRoutes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tbclFromLocation = tableViewerColumn.getColumn();
		tbclFromLocation.setWidth(100);
		tbclFromLocation.setText("From Location");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclToLocation = tableViewerColumn_1.getColumn();
		tblclToLocation.setWidth(100);
		tblclToLocation.setText("To Location");
		
		
		TableViewer tableViewer_1 = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblWaypoints = tableViewer_1.getTable();
		tblWaypoints.setLinesVisible(true);
		tblWaypoints.setHeaderVisible(true);
		tblWaypoints.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tableColumn = tableViewerColumn_2.getColumn();
		tableColumn.setWidth(40);
		tableColumn.setText("#");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnLatitude = tableViewerColumn_3.getColumn();
		tblclmnLatitude.setWidth(100);
		tblclmnLatitude.setText("Latitude");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnLongitude = tableViewerColumn_4.getColumn();
		tblclmnLongitude.setWidth(100);
		tblclmnLongitude.setText("Longitude");
		
		Group grpCommands = new Group(this, SWT.NONE);
		grpCommands.setText("Commands");
		RowLayout rl_grpCommands = new RowLayout(SWT.HORIZONTAL);
		rl_grpCommands.spacing = 15;
		rl_grpCommands.fill = true;
		rl_grpCommands.center = true;
		grpCommands.setLayout(rl_grpCommands);

		grpCommands.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		
		Button btnNewButton = new Button(grpCommands, SWT.NONE);
		btnNewButton.setText("Load KML-file");
		
		Button btnNewButton_1 = new Button(grpCommands, SWT.NONE);
		btnNewButton_1.setText("Show in Map");
		
		
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
