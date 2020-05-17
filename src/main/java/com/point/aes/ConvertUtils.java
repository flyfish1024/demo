package com.point.aes;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

public abstract class ConvertUtils {

    private static final DecimalFormat simpleFormat = new DecimalFormat("####");

    public static final boolean objectToBoolean(Object o){
        return o != null ? Boolean.valueOf(o.toString()).booleanValue() : false;
    }

    public static final int objectToInt(Object o){
        if(o instanceof Number)
            return ((Number)o).intValue();
        try{
            if(o == null)
                return -1;
            else
                return Integer.parseInt(o.toString());
        }catch(NumberFormatException e){
            return -1;
        }
    }

    public static final short objectToShort(Object o){
        if(o instanceof Number)
            return ((Number)o).shortValue();
        try{
            if(o == null)
                return -1;
            else
                return Short.parseShort(o.toString());
        }catch(NumberFormatException e){
            return -1;
        }
    }

    public static final float objectToFloat(Object o){
        if(o instanceof Number)
            return ((Number)o).floatValue();
        try{
            if(o == null)
                return -1f;
            else
                return Float.parseFloat(o.toString());
        }catch(NumberFormatException e){
            return -1f;
        }
    }

    public static final long objectToLong(Object o)
    {
        if(o instanceof Number)
            return ((Number)o).longValue();
        try{
            if(o == null)
                return -1L;
            else
                return Long.parseLong(o.toString());
        }catch(NumberFormatException e){
            return -1L;
        }
    }

    public static final String objectToString(Object obj, DecimalFormat fmt)
    {
        fmt.setDecimalSeparatorAlwaysShown(false);
        if(obj instanceof Float)
            return fmt.format(((Float)obj).floatValue());
        if(obj instanceof Long)
            return fmt.format(((Long)obj).longValue());
        else
            return obj.toString();
    }

    public static final Object getObjectValue(String value)
    {
        try{
            return Long.valueOf(value);
        }catch(NumberFormatException e) {}

        try{
            return Float.valueOf(value);
        }catch(NumberFormatException e){
            return value;
        }
    }

    public static String longToSimpleString(long value){
        return simpleFormat.format(value);
    }

    public static String asHex(byte hash[]){
        return toHex(hash);
    }

    public static String toHex(byte input[]){
        if(input == null)
            return null;
        StringBuffer output = new StringBuffer(input.length * 2);
        for(int i = 0; i < input.length; i++){
            int current = input[i] & 0xff;
            if(current < 16)
                output.append("0");
            output.append(Integer.toString(current, 16));
        }

        return output.toString();
    }

    public static byte[] fromHex(String input){
        if(input == null)
            return null;
        byte output[] = new byte[input.length() / 2];
        for(int i = 0; i < output.length; i++)
            output[i] = (byte) Integer.parseInt(input.substring(i * 2, (i + 1) * 2), 16);

        return output;
    }

    public static String stringToHexString(String input, String encoding)
        throws UnsupportedEncodingException {
        return input != null ? toHex(input.getBytes(encoding)) : null;
    }

    public static String stringToHexString(String input){
        try{
            return stringToHexString(input, "UTF-8");
        }catch(UnsupportedEncodingException e){
            throw new IllegalStateException("UTF-8 encoding is not supported by JVM");
        }
    }

    public static String hexStringToString(String input, String encoding)
        throws UnsupportedEncodingException {
        return input != null ? new String(fromHex(input), encoding) : null;
    }

    public static String hexStringToString(String input){
        try{
            return hexStringToString(input, "UTF-8");
        }catch(UnsupportedEncodingException e){
            throw new IllegalStateException("UTF-8 encoding is not supported by JVM");
        }
    }

    private ConvertUtils(){}

}
