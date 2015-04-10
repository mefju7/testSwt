package mefju.testswt;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Display;

public class BindingTestWindow {

	public static void main(String[] args) throws Exception {

		Display display = Display.getDefault();
		Realm realm = SWTObservables.getRealm(display);
		Realm.runWithDefault(realm, new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					TestWindow tw = new TestWindow(display);
					tw.open();
					tw.layout();
					// message loop
					while (display.getShells().length > 0) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

}
