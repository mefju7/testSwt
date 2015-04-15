package mefju.testswt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.TrayItem;

public class TableWindow extends Shell {
	private Table table;
	private Table table_1;
	/**
	 * @wbp.nonvisual location=33,479
	 */
	
	

	public TableWindow(Display display) throws Exception {
		
		super(display, SWT.SHELL_TRIM);
		
		setSize(641, 414);
		setLayout(new GridLayout(2, true));
		
		Label lblRoutes = new Label(this, SWT.NONE);
		lblRoutes.setText("Routes");
		
		Label lblWaypoints = new Label(this, SWT.NONE);
		lblWaypoints.setText("Waypoints");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnFromPort = new TableColumn(table, SWT.LEFT);
		tblclmnFromPort.setWidth(100);
		tblclmnFromPort.setText("From Port");
		
		TableColumn tblclmnToPort = new TableColumn(table, SWT.NONE);
		tblclmnToPort.setWidth(100);
		tblclmnToPort.setText("To Port");
		
		table_1 = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table_1, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("#");
		
		TableColumn tblclmnLatitude = new TableColumn(table_1, SWT.NONE);
		tblclmnLatitude.setWidth(100);
		tblclmnLatitude.setText("Latitude");
		
		TableColumn tblclmnLongitude = new TableColumn(table_1, SWT.NONE);
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
