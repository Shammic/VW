package com.misynss.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Product: solSyn - NDB MIS Solution <br/>
 * Description: Utility Functions <br/>
 * Copyright: Copyright, 2007 (c) <br/>
 * Company: M.I. Synergy (Pvt) Ltd <br/>
 * @author Chamila Perera
 * @version 1.0
 */
public class Utility {

    private static int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String loanList[] = {"1AF", "1PL", "1ST", "2AF", "3AF", "IL"};
    //private static String depositList[] = {"1AF","1PL","1ST","2AF","3AF","IL"};
    private static String strMonths[] = {"January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"};

    /**
     * Returns the bank code
     *
     * @return Bank code as <tt>int</tt>
     */
    public static int getBankCode() {
        return 7214;
    }

    /**
     * Returns the bank code
     *
     * @return Bank code as <tt>int</tt>
     */
    public static int getBankCode2() {
        return 7214;
    }

    /**
     * Returns the branch code
     *
     * @return Branch code as <tt>int</tt>
     */
    public static int getBranchCode() {
        return 900;
    }

    /**
     * Returns the language name for the given language ID
     *
     * @param <tt>languageID</tt> Language ID
     * @return Language name as <tt>String</tt>
     */
    public static String getLanguage(int languageID) {
        switch (languageID) {
            case 1:
                return "ENGLISH";
            case 2:
                return "SINHALA";
            case 3:
                return "TAMIL";
            default:
                return "ENGLISH";
        }
    }

    /**
     * Returns the language name for the given language code
     *
     * @param <tt>languageCode</tt> Language Code
     * @return Language ID as <tt>int</tt>
     */
    public static int getLanguageID(char languageCode) {
        switch (languageCode) {
            case 'E':
                return 1;
            case 'S':
                return 2;
            case 'T':
                return 3;
            default:
                return 1;
        }
    }

    /**
     * Returns the numeric value given the short month value
     *
     * @param <tt>month</tt> Month name
     * @return Short month name as <tt>int</tt>
     */
    public static int getNumericMonth(String month) {
        String months[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
            "AUG", "SEP", "OCT", "NOV", "DEC"};
        int i = 0;
        while (i < 12) {
            if (months[i].equalsIgnoreCase(month)) {
                return (i + 1);
            }
            i++;
        }
        return 0;
    }

    /**
     * Returns the short month value given the numeric value
     *
     * @param <tt>month</tt> Numeric month value
     * @return Short month name as <tt>String</tt>
     */
    public static String getMonthName(int month) {
        String strMonths[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
            "Aug", "Sep", "Oct", "Nov", "Dec"};
        return strMonths[month - 1];
    }

    
    public static String getMonthName_capital(int month) {
        String strMonths[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
            "AUG", "SEP", "OCT", "NOV", "DEC"};
        return strMonths[month - 1];
    }
    /**
     * Returns the month name given the numeric value
     *
     * @param <tt>month</tt> Numeric month value
     * @param <tt>language</tt> Language : 1 - English , 2 - Sinhala , 3 - Tamil
     * @return Short month name as <tt>String</tt>
     */
    public static String getMonthFullName(int month, int language) {
        return strMonths[month - 1];
    }

    /**
     * Returns the month name given the numeric value
     *
     * @param <tt>month</tt> Numeric month value
     * @return Short month name as <tt>String</tt>
     */
    public static String getMonthFullName(String month) {
        return getMonthFullName(Integer.parseInt(month));
    }

    /**
     * Returns the month name given the numeric value
     *
     * @param <tt>month</tt> Numeric month value
     * @return Short month name as <tt>String</tt>
     */
    public static String getMonthFullName(int month) {
        return strMonths[month - 1];
    }

    /**
     * Returns the last day of the month
     *
     * @param <tt>year</tt> Year
     * @param <tt>month</tt> Month
     * @return Last day of the month as <tt>int</tt>
     */
    public static int getLastDayOfMonth(int year, int month) {
        if (month == 2) {
            return ((0 == year % 4) && (0 != (year % 100)))
                    || (0 == year % 400) ? 29 : 28;
        } else {
            return daysInMonth[month - 1];
        }
    }

    /**
     * A recursive function to add zeros in front for a given length;
     *
     * @param <tt>str</tt> Input string
     * @param <tt>length</tt> String length
     * @return Output string as <tt>String</tt>
     */
    public static String addZeroRJ(String str, int length) {
        return str.length() < length ? addZeroRJ("0" + str, length) : str;
    }

    /**
     * A recursive function to add spaces in front for a given length;
     *
     * @param <tt>str</tt> Input string
     * @param <tt>length</tt> String length
     * @return Output string as <tt>String</tt>
     */
    public static String paddSpaceLJ(String str, int length) {
        return str.length() <= length ? paddSpaceLJ(str + " ", length) : str.substring(0, length);
    }

    /**
     * A recursive function to add spaces in front for a given length;
     *
     * @param <tt>str</tt> Input string
     * @param <tt>length</tt> String length
     * @return Output string as <tt>String</tt>
     */
    public static String paddSpaceLJ2(String str, int length) {
        return str.length() < length ? paddSpaceLJ2(str + "  ", length + 1) : str;
    }

    /**
     * A recursive function to add spaces to the back for a given length;
     *
     * @param <tt>str</tt> Input string
     * @param <tt>length</tt> String length
     * @return Output string as <tt>String</tt>
     */
    public static String paddSpaceRJ(String str, int length) {
        return str.length() < length ? paddSpaceRJ(" " + str, length) : str;
    }

    /**
     * A recursive function to add spaces to the back for a given length;
     *
     * @param <tt>str</tt> Input string
     * @param <tt>length</tt> String length
     * @return Output string as <tt>String</tt>
     */
    public static String paddSpaceRJ2(String str, int length) {
        return str.length() < length ? paddSpaceRJ2("   " + str, length + 1) : str;
    }

    /**
     * A recursive function to add spaces to the back for a given length;
     *
     * @param <tt>str</tt> Input string
     * @param <tt>length</tt> String length
     * @return Output string as <tt>String</tt>
     */
    public static String paddSpaceRJ3(String str, int length) {
        return str.length() < length ? paddSpaceRJ3("       " + str, length + 2) : str;
    }

    /**
     * A recursive function to add spaces to the front and back for a given length;
     *
     * @param <tt>str</tt> Input string
     * @param <tt>length</tt> String length
     * @return Output string as <tt>String</tt>
     */
    public static String paddSpaceCenter(String str, int length) {
        return str.length() < length ? paddSpaceCenter(" " + str + " ", length) : str;
    }

    /**
     * Format currency
     *
     * @param <tt>value</tt> Currency value
     * @return Formatted currency value as <tt>String</tt>
     */
    public static String formatCurrency(String value) {
        BigDecimal bg = new BigDecimal(value);
        return formatCurrency(bg.doubleValue());
    }

    /**
     * Format currency
     *
     * @param <tt>value</tt> Currency value
     * @return Formatted currency value as <tt>String</tt>
     */
    public static String formatCurrency(double value) {
        DecimalFormat df = new DecimalFormat("###,##0.00;(###,##0.00)");
        return df.format(value);
    }

    /**
     * Format currency
     *
     * @param <tt>value</tt> Currency value
     * @param <tt>delim</tt> Currency delimeter
     * @return Formatted currency value as <tt>String</tt>
     */
    public static String formatCurrency(String value, String delim) {
        BigDecimal bg = new BigDecimal(value);
        return formatCurrency(bg.doubleValue(), delim);
    }

    /**
     * Format currency
     *
     * @param <tt>value</tt> Currency value
     * @param <tt>delim</tt> Currency delimeter
     * @return Formatted currency value as <tt>String</tt>
     */
    public static String formatCurrency(double value, String delim) {
        DecimalFormat df = new DecimalFormat("###,##0.00;" + delim + "###,##0.00");
        return df.format(value);
    }

    /**
     * Format currency
     *
     * @param <tt>value</tt> Currency value
     * @param <tt>delim</tt> Currency delimeter
     * @param <tt>decimal</tt> Currency decilmal values
     * @return Formatted currency value as <tt>String</tt>
     */
    public static String formatCurrency(double value, String delim, String decimal) {
        DecimalFormat df = new DecimalFormat("###,##0." + decimal + ";" + delim + "###,##0." + decimal + "");
        return df.format(value);
    }

    /**
     * Format currency
     *
     * @param <tt>value</tt> Currency value
     * @param <tt>delim</tt> Currency delimeter
     * @param <tt>decimal</tt> Currency decilmal values
     * @return Formatted currency value as <tt>String</tt>
     */
    public static String formatCurrency(String value, String delim, String decimal) {
        BigDecimal bg = new BigDecimal(value);
        return formatCurrency(bg.doubleValue(), delim, decimal);
    }

    /**
     * Format Currency
     *
     * @param <tt>value</tt> Number
     * @return Formatted number as <tt>String</tt>
     */
    public static String formatCurrency(BigDecimal value) {
        String output = "";
        String decimal = "00";
        String tempStr = value.toString();
        int index = tempStr.indexOf(".");
        if (index > 0) {
            decimal = tempStr.substring(index + 1);
            tempStr = tempStr.substring(0, index);
        }
        index = tempStr.length();
        for (int x = 0; x < tempStr.length(); x++) {
            if (((x % 3) == 0) && (x != 0)) {
                output = "," + output;
            }
            output = tempStr.charAt(index - x - 1) + output;
        }
        return output + "." + decimal;
    }

    /**
     * Format currency
     *
     * @param <tt>value</tt> Currency value
     * @param <tt>decimal</tt> Currency decilmal values
     * @return Formatted currency value as <tt>String</tt>
     */
    public static String formatCurrency2(String value, String decimal) {
        return formatCurrency2(Double.parseDouble(value), decimal);
    }

    /**
     * Format currency
     *
     * @param <tt>value</tt> Currency value
     * @param <tt>decimal</tt> Currency decilmal values
     * @return Formatted currency value as <tt>String</tt>
     */
    public static String formatCurrency2(double value, String decimal) {
        DecimalFormat df = new DecimalFormat("#####0." + decimal + ";-#####0." + decimal + "");
        return df.format(value);
    }

    /**
     * Format number
     *
     * @param <tt>value</tt> Number
     * @return Formatted number as <tt>String</tt>
     */
    public static String formatNumber(int value) {
        DecimalFormat df = new DecimalFormat("###,##0;(###,##0)");
        return df.format(value);
    }

    /**
     * Format number
     *
     * @param <tt>value</tt> Number
     * @return Formatted number as <tt>String</tt>
     */
    public static String formatNumber(String value) {
        BigInteger bi = new BigInteger(value);
        return formatNumber(bi.intValue());
    }

    /**
     * Format number
     *
     * @param <tt>value</tt> Number
     * @return Formatted number as <tt>String</tt>
     */
    public static String formatNumber(long value) {
        BigInteger bi = new BigInteger(String.valueOf(value));
        return formatNumber(bi.intValue());
    }

    /**
     * Format number
     *
     * @param <tt>value</tt> Number
     * @return Formatted number as <tt>String</tt>
     */
    public static String formatNumber(BigDecimal value) {
        String output = "";
        String tempStr = value.toString();
        int index = tempStr.indexOf(".");
        if (index > 0) {
            tempStr = tempStr.substring(0, index);
        }
        index = tempStr.length();
        for (int x = 0; x < tempStr.length(); x++) {
            if (((x % 3) == 0) && (x != 0)) {
                output = "," + output;
            }
            output = tempStr.charAt(index - x - 1) + output;
        }
        return output;
    }

    /**
     * Removes formatting in the currency
     *
     * @param <tt>value</tt> Currency value
     * @return Re-formatted currency value as <tt>String</tt>
     */
    public static String reFormatCurrency(String value) {
        StringBuffer buf = new StringBuffer();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char ch = value.charAt(i);
            if (ch == ',') {
                buf.append("");
            } else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

    /**
     * Format Oracle date format to MySQL date format
     *
     * @param <tt>inputDate</tt> Input Date
     * @return Formatted date as <tt>String</tt>
     */
    public static String toMySqlDate(String inputDate) {
        try {
            return "20" + inputDate.substring(7, 9) + "-"
                    + addZeroRJ(String.valueOf(getNumericMonth(inputDate.substring(3, 6))), 2)
                    + "-" + inputDate.substring(0, 2);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Format Oracle date format to MySQL date format
     *
     * @param <tt>inputDate</tt> Input Date
     * @return Formatted date as <tt>String</tt>
     */
    public static String toMySqlDate2(String inputDate) {
        try {
            return inputDate.substring(7, 11) + "-"
                    + addZeroRJ(String.valueOf(getNumericMonth(inputDate.substring(3, 6))), 2)
                    + "-" + inputDate.substring(0, 2);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Format MySQL date format to Oracle date format
     *
     * @param <tt>inputDate</tt> Input Date
     * @return Formatted date as <tt>String</tt>
     */
    public static String toOracleDate(String inputDate) {
        try {
            return inputDate.substring(8, 10) + " " + getMonthName(Integer.parseInt(inputDate.substring(5, 7))) + " " + inputDate.substring(0, 4);
        } catch (Exception e) {
            return "";
        }
    }
    
    /**
     * Format MySQL date format to Oracle date format
     *
     * @param <tt>inputDate</tt> Input Date
     * @return Formatted date as <tt>String</tt>
     */
    public static String toviewDateFormat(String inputDate) {
        try {
            return inputDate.substring(8, 10) + " " + getMonthName(Integer.parseInt(inputDate.substring(5, 7))) + " " + inputDate.substring(0, 4)+" "+inputDate.substring(11, 19);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Format a string by replacing characters
     *
     * @param <tt>text</tt> Input text
     * @return Formatted string as <tt>String</tt>
     */
    public static String formatHTMLText(String text) {
        StringBuffer buf = new StringBuffer();
        int length = text.length();
        for (int i = 0; i < length; i++) {
            switch (text.charAt(i)) {
                case '&':
                    buf.append("and");
                    break;
                case '<':
                    buf.append("&lt;");
                    break;
                case '>':
                    buf.append("&gt;");
                    break;
                case '\"':
                    buf.append("&quot;");
                    break;
                case '\'':
                    buf.append("&quot;");
                    break;
                default:
                    buf.append(text.charAt(i));
                    break;
            }
        }
        return buf.toString();
    }

    /**
     * Format a URL by replacing characters
     *
     * @param <tt>url</tt> Input URL
     * @return Formatted URL as <tt>String</tt>
     */
    public static String formatURL(String url) {
        StringBuffer buf = new StringBuffer();
        int len = url.length();
        for (int i = 0; i < len; i++) {
            switch (url.charAt(i)) {
                case ' ':
                    buf.append("%20");
                    break;
                case ':':
                    buf.append("%3a");
                    break;
                case '/':
                    buf.append("%2f");
                    break;
                default:
                    buf.append(url.charAt(i));
                    break;
            }
        }
        return buf.toString();
    }

    /**
     * Format a URL by replacing characters
     *
     * @param <tt>url</tt> Input URL
     * @return Formatted URL as <tt>String</tt>
     */
    public static String formatFileUploadURL(String url) {
        StringBuffer buf = new StringBuffer();
        int len = url.length();
        for (int i = 0; i < len; i++) {
            switch (url.charAt(i)) {
                case '\\':
                    buf.append("/");
                    break;
                default:
                    buf.append(url.charAt(i));
                    break;
            }
        }
        return buf.toString();
    }

    /**
     * Format a string by replacing characters
     *
     * @param <tt>text</tt> Input text
     * @return Formatted string as <tt>String</tt>
     */
    public static String formatDBString(String text) {
        StringBuffer buf = new StringBuffer();
        if (!text.equals("") && text != null) {
            int length = text.length();
            for (int i = 0; i < length; i++) {
                switch (text.charAt(i)) {
                    case '\"':
                        buf.append("~");
                        break;
                    case '\'':
                        buf.append("~");
                        break;
                    default:
                        buf.append(text.charAt(i));
                        break;
                }
            }
        }
        return buf.toString();
    }

    /**
     * Format a string by replacing spaces
     *
     * @param <tt>text</tt> Input text
     * @return Formatted string as <tt>String</tt>
     */
    public static String removeSpaces(String text) {
        StringBuffer buf = new StringBuffer("");
        if (!text.equals("") && text != null) {
            int length = text.length();
            char ch = ' ';
            for (int i = 0; i < length; i++) {
                ch = text.charAt(i);
                if (ch == ' ') {
                    buf.append("");
                } else {
                    buf.append(ch);
                }
            }
            return buf.toString();
        }
        return buf.toString();
    }

    /**
     * Format a string by replacing characters
     *
     * @param <tt>text</tt> Input text
     * @return Formatted string as <tt>String</tt>
     */
    public static String reFormatDBString(String text) {
        StringBuffer buf = new StringBuffer();
        if (!text.equals("") && text != null) {
            int length = text.length();
            for (int i = 0; i < length; i++) {
                switch (text.charAt(i)) {
                    case '~':
                        buf.append("'");
                        break;
                    default:
                        buf.append(text.charAt(i));
                        break;
                }
            }
        }
        return buf.toString();
    }

    /**
     * Returns formatted date/time
     *
     * @param <tt>fmt</tt> Date/time format
     * @return Date/time as <tt>String</tt>
     */
    private static String javaDate(String fmt) {
        String dd;
        TimeZone gmt530 = TimeZone.getTimeZone("GMT");
        gmt530.setRawOffset((11 * 30) * 60 * 1000);
        SimpleDateFormat formatter = new SimpleDateFormat(fmt);
        formatter.setTimeZone(gmt530);
        dd = formatter.format(new java.util.Date());
        return dd;
    }

    public static String getCusormerDateFormat(String date, String cust_date_format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(cust_date_format);
        String m_date = "2001-01-01";
        try {
            m_date = dateFormat.format(dateFormat.parse(date));
        } catch (Exception e) {
        }
        return m_date;
    }

    public static String getCusormerDateFormat(String getDate, String get_format, String put_format) {
        DateFormat formatter = new SimpleDateFormat(get_format);
        SimpleDateFormat parse = new SimpleDateFormat(put_format);

        Date date = null;
        try {
            date = (Date) formatter.parse(getDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String parsed = parse.format(date);
        return (parsed);
    }

    /**
     * Return the date in YYYY-MM-DD format
     *
     * @return Formatted date as <tt>String</tt>
     */
    public static String sysDate() {
        return javaDate("yyyy-MM-dd");
    }

    /**
     * Return the date in the given format
     *
     * @param <tt>dateFormat</tt> Date format
     * @return Formatted date <tt>String</tt>
     */
    public static String sysDate(String dateFormat) {
        return javaDate(dateFormat);
    }

    /**
     *
     * Return the time in HH:MM:SS format
     *
     * @return Formatted time as <tt>String</tt>
     */
    public static String sysTime() {
        return javaDate("HH:mm:ss");
    }

    public static boolean isValidDate(String date, String cust_date_format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(cust_date_format);
        boolean b = false;
        String m_date = "";
        try {
            m_date = dateFormat.format(dateFormat.parse(date));
            b = true;
        } catch (Exception e) {
            b = false;

        }
        return b;
    }

    /**
     * Checks whether the given account type is a loan
     *
     * @param <tt>accountType</tt> Account Type
     * @return Status as <tt>boolean</tt>
     */
    public static boolean isLoan(String accountType) {
        boolean status = false;

        for (int i = 0; i < loanList.length; i++) {
            if (loanList[i].equals(accountType)) {
                status = true;
                break;
            }
        }
        return status;
    }

    /**
     * Return full user type
     *
     * @param <tt>type</tt> User type
     * @return Full user type as <tt>String</tt>
     */
    public static String getFullSystemUserType(char type) {
        type = Character.toUpperCase(type);
        switch (type) {
            case 'O':
                return "OPERATOR";
            case 'S':
                return "OFFICER";
            case 'M':
                return "MANAGER";
            default:
                return "";
        }
    }

    /**
     * Return full system user status
     *
     * @param <tt>userStatus</tt> User status
     * @return Full system user status as <tt>String</tt>
     */
    public static String getFullSystemUserStatus(char userStatus) {
        userStatus = Character.toUpperCase(userStatus);
        switch (userStatus) {
            case 'A':
                return "ACTIVE";
            case 'D':
                return "DISABLED";
            case 'L':
                return "LOCKED";
            case 'P':
                return "PENDING LOGIN";
            default:
                return "";
        }
    }

    /**
     * Return full user status
     *
     * @param <tt>userStatus</tt> User status
     * @return Full user status as <tt>String</tt>
     */
    public static String getFullUserStatus(char userStatus) {
        userStatus = Character.toUpperCase(userStatus);
        switch (userStatus) {
            case 'A':
                return "ACTIVE";
            case 'C':
                return "CLOSED";
            case 'D':
                return "DISABLED";
            case 'L':
                return "LOCKED";
            case 'P':
                return "PENDING PASSWORD PRINT";
            case 'X':
                return "PENDING LOGIN";
            default:
                return "";
        }
    }

    /**
     * Return full Branch status
     *
     * @param <tt>status</tt> Status
     * @return Full Branch status as <tt>String</tt>
     */
    public static String getFullBranchStatus(char status) {
        status = Character.toUpperCase(status);
        switch (status) {
            case 'A':
                return "ACTIVE";
            case 'C':
                return "CLOSED";
            case 'D':
                return "DISABLED";
            default:
                return "";
        }
    }

    /**
     * Format the given phone number
     *
     * @param <tt>phoneNo</tt> Phone Number
     * @return Formatted Phone Number as <tt>String</tt>
     */
    public static String formatPhoneNumber(String phoneNo) {
        String newPhoneNumber = "";

        phoneNo = phoneNo.trim();
        newPhoneNumber = phoneNo;

        if ((phoneNo.length() == 13)) {
            //if (phoneNo.startsWith("919477")) newPhoneNumber = phoneNo;
            //else if (phoneNo.startsWith("919471")) newPhoneNumber = "0" + phoneNo.substring(4);
            //else if (phoneNo.startsWith("919472")) newPhoneNumber = "0" + phoneNo.substring(4);
            //else if (phoneNo.startsWith("919478")) newPhoneNumber = "0" + phoneNo.substring(4);
            newPhoneNumber = "0" + phoneNo.substring(4);
        } else if ((phoneNo.length() == 11)) {
            //if (phoneNo.startsWith("9477")) newPhoneNumber = "91" + phoneNo;
            //else if (phoneNo.startsWith("9471")) newPhoneNumber = "0" + phoneNo.substring(2);
            //else if (phoneNo.startsWith("9472")) newPhoneNumber = "0" + phoneNo.substring(2);
            //else if (phoneNo.startsWith("9478")) newPhoneNumber = "0" + phoneNo.substring(2);
            newPhoneNumber = "0" + phoneNo.substring(2);
        } else if ((phoneNo.length() == 9)) {
            //if (phoneNo.startsWith("77")) newPhoneNumber = "9194" + phoneNo;
            //else if (phoneNo.startsWith("71")) newPhoneNumber = "0" + phoneNo;
            //else if (phoneNo.startsWith("72")) newPhoneNumber = "0" + phoneNo;
            //else if (phoneNo.startsWith("78")) newPhoneNumber = "0" + phoneNo;
            newPhoneNumber = "0" + phoneNo;
        }
        return newPhoneNumber.trim();
    }

    /**
     * Validate Suntel phone uumber
     *
     * @param <tt>phoneNumber</tt> Phone Number
     * @return Validity as <tt>boolean</tt>
     */
    public static boolean validateSuntelPhone(String phoneNumber) {
        if (phoneNumber.charAt(3) == '4') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validate Suntel phone uumber
     *
     * @param <tt>phoneNumber</tt> Phone Number
     * @return Validity as <tt>boolean</tt>
     */
    public static boolean validateSuntelPhone2(String phoneNumber) {
        try {
            Integer temp = new Integer(phoneNumber);
            phoneNumber = formatPhoneNumber(temp.toString());
            if (phoneNumber.charAt(3) == '4') {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static long getNoDaysDateDiff(String passDate, String date_format) {
        long days = 0;
        SimpleDateFormat df = new SimpleDateFormat(date_format);
        Date date_current = null;
        Date date_passs = null;

        try {
            date_current = new Date();
            date_passs = df.parse(passDate);
            long diff = date_current.getTime() - date_passs.getTime();
            days = (diff / (1000 * 60 * 60 * 24));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return days;

    }

    public static long getNoMiniutsTimeDiff(String passTime, String time_format) {
        long times = 0;
        SimpleDateFormat df = new SimpleDateFormat(time_format);
        Date date_current = null;
        Date date_passs = null;

        try {
            date_current = new Date();

            date_passs = df.parse(passTime);
            long diff = date_current.getTime() - date_passs.getTime();
            times = (diff) / (1000 * 60);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return times;

    }

    public static long getNoSecondsTimeDiff(String passTime, String time_format) {
        long times = 0;
        SimpleDateFormat df = new SimpleDateFormat(time_format);
        Date date_current = null;
        Date date_passs = null;

        try {
            date_current = new Date();

            date_passs = df.parse(passTime);
            long diff = date_current.getTime() - date_passs.getTime();
            times = (diff) / (1000);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return times;

    }

    public static synchronized boolean isValiedFileName(String fileName, String fileExt[]) {
        String name = fileName.toLowerCase().trim();
        //String fileExt[]={".jpg",".jpeg",".gif",".bmp",".png",".tiff",".pdf",".doc",".docx"};

        int i = -1;
        for (int x = 0; x < fileExt.length; x++) {
            i = name.lastIndexOf(fileExt[x]);
            if (i > 0) {
                //System.out.println("index of "+fileExt[x]+ " "+i);
                return true;
            }
        }

        return false;

    }

    public static synchronized String getddMMyyyy(String date) {
        String d = date.trim();

        if (d.length() == 8) {
            d = d.substring(4, 8) + "-" + d.substring(2, 4) + "-" + d.substring(0, 2);
        }
        return d;

    }

    public static boolean isValiedFileName(String fileName) {
        String name = fileName.toLowerCase().trim();
        String fileExt[] = {".jpg", ".jpeg", ".gif", ".bmp", ".png", ".tiff", ".pdf", ".doc", ".docx"};

        int i = -1;
        for (int x = 0; x < fileExt.length; x++) {
            i = name.lastIndexOf(fileExt[x]);
            if (i > 0) {
                //System.out.println("index of "+fileExt[x]+ " "+i);
                return true;
            }
        }

        return false;

    }

        public static boolean isValiedFileName1(String fileName) {
        String name = fileName.toLowerCase().trim();
        String fileExt[] = {".pdf"};

        int i = -1;
        for (int x = 0; x < fileExt.length; x++) {
            i = name.lastIndexOf(fileExt[x]);
            if (i > 0) {
                //System.out.println("index of "+fileExt[x]+ " "+i);
                return true;
            }
        }

        return false;

    }
        
      public static boolean isWeekend(Date date) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if((dayOfWeek == Calendar.SUNDAY)||dayOfWeek == Calendar.SATURDAY){
            return true;
            }else
            return false;
        }
      

      public static String previousDateString(String dateString , int nuOfDate) 
              throws ParseException {

          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

          Date myDate = dateFormat.parse(dateString);

          Calendar calendar = Calendar.getInstance();
          calendar.setTime(myDate);
          calendar.add(Calendar.DAY_OF_YEAR, -nuOfDate);

          Date previousDate = calendar.getTime();
          String result = dateFormat.format(previousDate);

          return result;
      }
      

      public static Date previousDate(String dateString,int nuOfDate) 
              throws ParseException {

          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

          Date myDate = dateFormat.parse(dateString);

          Calendar calendar = Calendar.getInstance();
          calendar.setTime(myDate);
          calendar.add(Calendar.DAY_OF_YEAR, -nuOfDate);

          Date previousDate = calendar.getTime();

          return previousDate;
      }

  /*  public static void main(String arg[]) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(" Format " + getCusormerDateFormat("2001-12-23 12:00:00", "yyyy-MM-dd HH:mm:ss"));

        long elapsed = 0;
        long startTime = dateFormat.parse("2010-01-09 14:35:00").getTime();//System.currentTimeMillis();

        long currentTime = new Date().getTime();//System.currentTimeMillis();

        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        elapsed = currentTime - startTime;
        if (startTime < currentTime) {
            System.out.println(elapsed / (1000 * 60));
        }
        System.out.println("start time :" + startTime);
        System.out.println("current time :" + currentTime);
        System.out.println(dateFormat.format(new Date(elapsed)));


        //System.out.println("No Day :"+getNoDaysDateDiff("2010-01-09","yyyy-MM-dd"));
        System.out.println("No Miniuts :" + getNoMiniutsTimeDiff("2010-06-20 09:50", "yyyy-MM-dd HH:mm"));
        System.out.println("No Seconds :" + getNoSecondsTimeDiff(sysDate("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(formatCurrency(1.0));


    }*/
      
      public static void main(String arg[]) throws Exception {
    	  String inputDate ="2010-01-09 14:35:00";
            System.out.println(inputDate.substring(8, 10) + " " + getMonthName(Integer.parseInt(inputDate.substring(5, 7))) + " " + inputDate.substring(0, 4)+" "+inputDate.substring(11, 19));
      }
      
      
//      public static String toviewDateFormat(String inputDate) {
//          try {
//              return inputDate.substring(8, 10) + " " + getMonthName(Integer.parseInt(inputDate.substring(5, 7))) + " " + inputDate.substring(0, 4);
//          } catch (Exception e) {
//              return "";
//          }
//      }
}
