package mefju.testswt.data;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Iso6709 {
	private static DecimalFormat dnf=null;

	static {
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		dnf = null;
		if(nf instanceof DecimalFormat)
		{
		
			dnf = (DecimalFormat) nf;
			dnf.applyLocalizedPattern("00.0######");
			dnf.setRoundingMode(RoundingMode.DOWN);
			System.out.println("got decimal format");
		}
	}
	
	private static Pattern pattern = Pattern
			.compile("([+-])(\\d{2})(\\d{2}(\\d{2})?)?(\\.\\d*)?([+-])(\\d{3})(\\d{2}(\\d{2})?)?(\\.\\d*)?((\\d(\\.\\d*)?)?CRS([^/]*))?(/)?");
	private static final String MinusSign = "-";

	public static   List<GeoPoint> parse(String s)

	{
		List<GeoPoint> gpList = new ArrayList<>();
		Matcher m = pattern.matcher(s);
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		while (m.find()) {
			if (m.groupCount() < 13)
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
			if (latdec == null)
				latdec = "";
			if (latmin == null)
				latdeg += latdec;
			else if (latsec == null)
				latmin += latdec;
			else
				latsec += latdec;
			if (londec == null)
				londec = "";
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
						latitude = nf.parse(latsec).doubleValue();
						latitude /= 60.0;
					}
					latitude += nf.parse(latmin).doubleValue();
					latitude /= 60.0;
				}
				latitude += nf.parse(latdeg).doubleValue();
				if (MinusSign.equals(latsign))
					latitude = -latitude;
				if (lonmin != null) {
					if (lonsec != null) {
						longitude = nf.parse(lonsec).doubleValue();
						longitude /= 60.0;
					}
					longitude += nf.parse(lonmin).doubleValue();
					longitude /= 60.0;
				}
				longitude += nf.parse(londeg).doubleValue();
				if (MinusSign.equals(lonsign))
					longitude = -longitude;
				@SuppressWarnings("unused")
				String crs = m.group(12);
				GeoPoint ngp = new GeoPoint(latitude, longitude);
				gpList.add(ngp);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gpList;
	}

	public enum Format {
		D_DEC, DM_DEC, DMS_DEC
	};

	public static String print(double latitude, double longitude, Format f) {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		
//		char latSign, lngSign;
//		int latdeg, lngdeg, latmin, lngmin;
		if (f == Format.D_DEC) {
			formatter.format("%+010.6f%+011.6f/", latitude, longitude);
		} else {
			char latSign = latitude >= 0 ? '+' : '-';
			char lngSign = longitude > 0 ? '+' : '-';
			if (latitude < 0)
				latitude = -latitude;
			if (longitude < 0)
				longitude = -longitude;
			int latdeg = (int) Math.floor(latitude);
			latitude -= latdeg;
			latitude*=60;
			int lngdeg = (int) Math.floor(longitude);
			longitude-= lngdeg;
			longitude*=60;
			if(f==Format.DM_DEC)
			{
				if(dnf!=null)
				{
					formatter.format("%c%02d%s%c%03d%s/",latSign,latdeg,dnf.format(latitude),lngSign,lngdeg,dnf.format(longitude));
				}
				else
				formatter.format("%c%02d%07.4f%c%03d%07.4f/", latSign,latdeg,latitude,lngSign,lngdeg,longitude);
			}
			else
			{
				int latmin = (int)Math.floor(latitude);
				latitude-=latmin;
				latitude*=60;
				int lngmin = (int)Math.floor(longitude);
				longitude-=lngmin;
				longitude*=60;
//				String s = Double.toString(longitude);
				if(dnf!=null)
					formatter.format("%c%02d%02d%s%c%03d%02d%s/", latSign,latdeg,latmin,dnf.format(latitude),lngSign,lngdeg,lngmin,dnf.format(longitude));
				else
				formatter.format("%c%02d%02d%06.3f%c%03d%02d%06.3f/", latSign,latdeg,latmin,latitude,lngSign,lngdeg,lngmin,longitude);
			}
		}
		formatter.close();
		return sb.toString();
	}
	public static void main(String[] args)
	{
		String[] strs2match = new String[] { "+10-005/", // just degrees
				"+10.5-006.3/", // one point one comma
				"+07.5+256.333/", // with many more digits
				"+64.478-01025.58CRSWGS_84/", // mixed case
				"-1056.3333+012.56789/+6447.8-01025.58/", // 2 coordinates
		};
		for(String str: strs2match)
		{
			System.out.println("parsing '"+str+"'");
			List<GeoPoint> gpl = parse(str);
			for(IGeoPoint wp: gpl)
			{
				System.out.println("d_dec: "+print(wp.getLatitude(),wp.getLongitude(),Format.D_DEC));
				System.out.println("dm_dec: "+print(wp.getLatitude(),wp.getLongitude(),Format.DM_DEC));
				System.out.println("dms_dec: "+print(wp.getLatitude(),wp.getLongitude(),Format.DMS_DEC));
				System.out.println("--");
			}
			System.out.println(" -----");
		}
		
	}
}
