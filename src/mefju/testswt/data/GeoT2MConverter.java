package mefju.testswt.data;

import java.util.List;

import mefju.testswt.data.GeoPoint.Builder;

import org.eclipse.core.databinding.conversion.Converter;

public class GeoT2MConverter extends Converter {

	public GeoT2MConverter() {
		super(String.class, GeoPoint.class);
		
	}

	@Override
	public Object convert(Object fromObject) {
		// TODO Auto-generated method stub
		if(fromObject instanceof String)
		{
			String str = (String)fromObject;
			Builder gpb = new GeoPoint.Builder();
		 List<IGeoPoint> parsed = Iso6709.parse(gpb, str);
			if(parsed.size()>0)
			{
				 IGeoPoint wp1 = (IGeoPoint) parsed.get(0);
				 if(wp1 instanceof GeoPoint)
					 return (GeoPoint) wp1;
				  return new GeoPoint(wp1.getLatitude(),wp1.getLongitude());
			}
		}
		return null;
	}

	

}
