package mefju.testswt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;

public class TestWindow extends Shell {
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;

	private TestData myData;
	
	private Text text;

	public TestWindow(Display display) throws Exception {
		
		super(display, SWT.SHELL_TRIM);
		
		myData=new TestData();
		
		if(myData==null)
		{
			System.out.println("something very wrong 2015-04-07/1");
			throw new Exception("no data");
		}
		
		setSize(800, 600);
		setLayout(null);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(68, 62, 281, 71);
		m_bindingContext = initDataBindings();
		
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	// this is a comment that should stay!
	protected DataBindingContext initDataBindings() {
		
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(text);
		IObservableValue nameDataObserveValue = PojoProperties.value("name").observe(myData);
		bindingContext.bindValue(observeTextTextObserveWidget, nameDataObserveValue, null, null);
		//
		return bindingContext;
	}
}
