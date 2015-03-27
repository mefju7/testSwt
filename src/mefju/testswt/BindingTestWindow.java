package mefju.testswt;

import org.eclipse.swt.widgets.Display;

public class BindingTestWindow {

	public static void main(String[] args) {

		Display display = Display.getDefault();
		TestWindow tw = new TestWindow(display);
		// message loop
				while (display.getShells().length > 0) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
	}

}
