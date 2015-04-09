package mefju.testswt;

import mefju.testswt.data.GeoM2TConverter;
import mefju.testswt.data.GeoT2MConverter;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TestWindow extends Shell {
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;

	private TestData myData;
	
	private Text firstTextTrial;
	private Text geoText;

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
		
		firstTextTrial = new Text(this, SWT.BORDER);
		firstTextTrial.setBounds(68, 62, 264, 36);
		
		geoText = new Text(this, SWT.BORDER);
		geoText.setBounds(66, 128, 406, 21);
		m_bindingContext = initDataBindings();
		
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(firstTextTrial);
		IObservableValue nameDataObserveValue = PojoProperties.value("name").observe(myData);
		bindingContext.bindValue(observeTextTextObserveWidget, nameDataObserveValue, null, null);
		//
		IObservableValue observeTextGeoTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(geoText);
		IObservableValue wpMyDataObserveValue = PojoProperties.value("wp").observe(myData);
		UpdateValueStrategy geot2m = new UpdateValueStrategy();
		geot2m.setConverter(new GeoT2MConverter());
		UpdateValueStrategy geom2t = new UpdateValueStrategy();
		geom2t.setConverter(new GeoM2TConverter());
		bindingContext.bindValue(observeTextGeoTextObserveWidget, wpMyDataObserveValue, geot2m, geom2t);
		//
		return bindingContext;
	}
}
