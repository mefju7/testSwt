package mefju.testswt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TestWindow extends Shell {

	public TestWindow(Display display) {
		// TODO Auto-generated constructor stub
		super(display, SWT.SHELL_TRIM);
		setSize(800, 600);
		setLayout(null);
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
