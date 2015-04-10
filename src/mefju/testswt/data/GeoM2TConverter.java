package mefju.testswt.data;



import org.eclipse.core.databinding.conversion.Converter;

public class GeoM2TConverter extends Converter {

	public GeoM2TConverter() {
		super(GeoPoint.class, String.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object convert(Object fromObject) {
		// TODO Auto-generated method stub
		if (fromObject instanceof GeoPoint) {
			GeoPoint wp = (GeoPoint) fromObject;
			return Iso6709.print(wp.getLatitude(), wp.getLongitude(),Iso6709.Format.DMS_DEC);
		}
		return null;
	}

}
