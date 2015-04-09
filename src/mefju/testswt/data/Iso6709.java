package mefju.testswt.data;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Iso6709 {

	public static class GeoPoint
	{
		public double getLatitude() {
			return latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public String getCrs() {
			return crs;
		}
		public GeoPoint(double latitude, double longitude, String crs) {
			super();
			this.latitude = latitude;
			this.longitude = longitude;
			this.crs = crs;
		}
		private double latitude;
		private double longitude;
		private String crs;
	}
	
	private static Pattern pattern=Pattern.compile("([+-])(\\d{2})(\\d{2}(\\d{2})?)?(\\.\\d*)?([+-])(\\d{3})(\\d{2}(\\d{2})?)?(\\.\\d*)?(CRS([^/]*))?(/)?");
	private static final String MinusSign= "-";
	
	public static List<GeoPoint> parse(String s)
	{
		List<GeoPoint> gpList=new ArrayList<>();
		Matcher m = pattern.matcher(s);
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		while(m.find())
		{
			if(m.groupCount()<13)
				return null;
			String latsign = m.group(1);
			String latdeg = m.group(2);
			String latmin = m.group(3);
			String latsec = m.group(4);
			String latdec = m.group(5);
			String lonsign = m.group(6);
			String londeg = m.group(7);
			String lonmin = m.group(8);
			String lonsec = m.group(9);
			String londec = m.group(10);
			if(latdec==null)
				latdec="";
			if (latmin == null)
				latdeg += latdec;
			else if (latsec == null)
				latmin += latdec;
			else
				latsec += latdec;
			if(londec==null)
				londec="";
			if (lonmin == null)
				londeg += londec;
			else if (lonsec == null)
				lonmin += londec;
			else
				lonsec += londec;
			double latitude = 0;
			double longitude = 0;
			try {
				if (latmin != null) {
					if (latsec != null) {
						latitude =  nf.parse(latsec).doubleValue();
						latitude /= 60.0;
					}
					latitude +=  nf.parse(latmin).doubleValue();
					latitude /= 60.0;
				}
				latitude +=  nf.parse(latdeg).doubleValue();
				if (MinusSign.equals(latsign))
					latitude = -latitude;
				if (lonmin != null) {
					if (lonsec != null) {
						longitude =  nf.parse(lonsec).doubleValue();
						longitude /= 60.0;
					}
					longitude +=  nf.parse(lonmin).doubleValue();
					longitude /= 60.0;
				}
				longitude +=  nf.parse(londeg).doubleValue();
				if(MinusSign.equals(lonsign))
					longitude=-longitude;
				String crs=m.group(12);
				GeoPoint ngp = new GeoPoint(latitude, longitude, crs);
				gpList.add(ngp);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gpList;
	}
}
