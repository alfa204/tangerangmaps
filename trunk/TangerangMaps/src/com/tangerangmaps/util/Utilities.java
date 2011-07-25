package com.tangerangmaps.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

public class Utilities {

	 public static void CopyStream(InputStream is, OutputStream os)
	    {
	        final int buffer_size=1024;
	        try
	        {
	            byte[] bytes=new byte[buffer_size];
	            for(;;)
	            {
	              int count=is.read(bytes, 0, buffer_size);
	              if(count==-1)
	                  break;
	              os.write(bytes, 0, count);
	            }
	        }
	        catch(Exception ex){}
	    }
	 
	 public static double getDistanceBetweenTwoLocation(double u_lat, double u_lon, double b_lat, double b_lon){
			double dist;
			double radian = 6371;
			
			double dLat = (b_lat - u_lat)*Math.PI/180;
			double dLon = (b_lon - u_lon)*Math.PI/180;
			
			double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(u_lat * (Math.PI/180)) * Math.cos(b_lat * (Math.PI/180)) * Math.sin(dLon/2) * Math.sin(dLon/2);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
			
			dist = radian * c;
			
			return dist;
	}
	
//	public static double calcGeoDistance(final double lat1, final double lon1, final double lat2, final double lon2)
//	{
//		double distance = 0.0;
//		
//		try
//		{
//			final float[] results = new float[3];
//			
//			Location.distanceBetween(lat1, lon1, lat2, lon2, results);
//			
//			distance = results[0];
//		}
//		catch (final Exception ex)
//		{
//			distance = 0.0;
//		}
//		
//		return distance * 0.001;
//	}
	 
	public static double RoundDecimal(double value, int decimalPlace)
	{
			BigDecimal bd = new BigDecimal(value);
			
			bd = bd.setScale(decimalPlace, 6);
			
			return bd.doubleValue();
	}
	 
	 public static String goToGeocoder(Context ctx, double paramDouble1, double paramDouble2)
	  {
	    Object localObject = null;
	    StringBuilder localStringBuilder1 = new StringBuilder();
	    try
	    {
	      Locale localLocale = Locale.getDefault();
	      Geocoder localGeocoder = new Geocoder(ctx, localLocale);
	      double d1 = paramDouble1;
	      double d2 = paramDouble2;
	      List localList = localGeocoder.getFromLocation(d1, d2, 5);
	      if (localList != null)
	      {
	        Address localAddress = (Address)localList.get(0);
	        String str1 = localAddress.getAdminArea();
	        String str2 = str1;
	        if ((localAddress.getAddressLine(0).equals(null)) || (localAddress.getAddressLine(0).equals("")))
	          localObject = localAddress.getFeatureName();
	        String str3 = String.valueOf(localAddress.getAddressLine(0));
	        StringBuilder localStringBuilder2 = new StringBuilder(str3).append(" ");
	        String str4 = localAddress.getAdminArea();
	        String str5 = str4;
	        localObject = str5;
	      }
	      return (String) localObject;
	    }
	    catch (IOException localIOException)
	    {
	      while (true)
	      {
	        String str6 = localIOException.getMessage();
	      }
	    }
	  }
}
