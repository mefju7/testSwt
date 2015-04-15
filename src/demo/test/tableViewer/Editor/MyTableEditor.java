package demo.test.tableViewer.Editor;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MyTableEditor extends ApplicationWindow {

	public MyTableEditor() {
		super(null);
		
	}

	public void run() {
		// TODO Auto-generated method stub
		 // Don't return from open() until window closes
	    setBlockOnOpen(true);

	    // Open the main window
	    open();

	    // Dispose the display
	    Display.getCurrent().dispose();
	}
	@Override
	protected void configureShell(Shell shell) {
		// TODO Auto-generated method stub
		super.configureShell(shell);
		 shell.setSize(400, 400);
	}
	@Override
	protected Control createContents(Composite parent) {
		// TODO Auto-generated method stub
		return new Ch9TableEditorComposite(parent);
	}
	/**
	   * The application entry point
	   * 
	   * @param args
	   *            the command line arguments
	   */
	  public static void main(String[] args) {
	    new MyTableEditor().run();
	  }
}
