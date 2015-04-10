package mefju.testswt.data;

import java.util.List;

import mefju.testswt.TestData.WP;

import org.eclipse.core.databinding.conversion.Converter;

public class GeoT2MConverter extends Converter {

	public GeoT2MConverter() {
		super(String.class, WP.class);
		
	}

	@Override
	public Object convert(Object fromObject) {
		// TODO Auto-generated method stub
		if(fromObject instanceof String)
		{
			String str = (String)fromObject;
		 List<GeoPoint> parsed = Iso6709.parse(str);
			if(parsed.size()>0)
			{
				 IGeoPoint wp1 = (IGeoPoint) parsed.get(0);
				 return new WP(wp1.getLatitude(),wp1.getLongitude());
			}
		}
		return null;
	}

	

}
