package mefju.testswt.data;

import mefju.testswt.TestData.WP;

import org.eclipse.core.databinding.conversion.Converter;

public class GeoM2TConverter extends Converter {

	public GeoM2TConverter() {
		super(WP.class, String.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object convert(Object fromObject) {
		// TODO Auto-generated method stub
		if (fromObject instanceof WP) {
			WP wp = (WP) fromObject;
			return Iso6709.print(wp.getLatitude(), wp.getLongitude());
		}
		return null;
	}

}
