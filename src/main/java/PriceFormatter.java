public class PriceFormatter {
    public static String getStringFromDoubleWithToDigitsAfterPoint(double val){
        return String.format("%.2f",val);
    }

    public static String getCorrectRubStringByDouble(double val){
        int roundedVal = (int)(Math.floor(val));
        String strVal = String.format("%d",roundedVal);
        String rubString = "рублей";
        if(strVal.endsWith("1") && !strVal.endsWith("11"))
        {
            rubString = "рубль";
        }
        else if( (strVal.endsWith("2") && !strVal.endsWith("12"))||
                (strVal.endsWith("3") && !strVal.endsWith("13")) ||
                (strVal.endsWith("4") && !strVal.endsWith("14")) )
        {
            rubString = "рубля";
        }
        return rubString;
    }

    public static String getFormattedPriceWithRubStringByDouble(double val){
        return getStringFromDoubleWithToDigitsAfterPoint(val) + " " +
                getCorrectRubStringByDouble(val);
    }
}
