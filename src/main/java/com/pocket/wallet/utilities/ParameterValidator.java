/*
 * Licensed Material - Property of Fawry Integrated Systems � Copyright Fawry Integrated Systems
 * 2009. All Rights Reserved.
 */
package com.pocket.wallet.utilities;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Youssif Tawfik
 */
@Component
public class ParameterValidator {

  /**
   * validate if the string empty.
   * 
   * @param param String
   * @return true if the string is empty or null
   */
  public boolean isEmptyString(final String param) {
    if (isNull(param) || param.equals("")) {
      return true;
    }
    return false;
  }

  public boolean isEmptyByteArray(byte[] securePin) {

    return securePin == null || securePin.length == 0;
  }

  /**
   * @param param parameter of type Long to be validated
   * @return true if zero else return false
   */
  public boolean isEmptyNumber(final Long param) {
    if (isNull(param) || param == 0) {
      return true;
    }

    return false;
  }

  /**
   * @param param parameter of type Long to be validated
   * @return true if zero else return false
   */
  public boolean isEmptyNumber(final Integer param) {
    if (isNull(param) || param == 0) {
      return true;
    }

    return false;
  }

  /**
   * @param param parameter of type double to be validated
   * @return true if zero else return false
   */
  public boolean isEmptyNumber(final Double param) {
    if (isNull(param) || param == 0) {
      return true;
    }

    return false;
  }

  /**
   * @param param parameter of type BigInteger to be validated
   * @return true if zero else return false
   */
  public boolean isEmptyNumber(final BigInteger param) {
    if (isNull(param) || param.equals(BigInteger.ZERO)) {
      return true;
    }

    return false;
  }

  /**
   * validate if object is null .
   * 
   * @param param object parameter
   * @return true if the object parameter is null
   */
  public boolean isNull(final Object param) {
    if (param == null) {
      return true;
    }

    return false;
  }

  public boolean isDWPEmptyString(final String param) {
    if (isNull(param) || param.equals("") || param.equals("none")) {
      return true;
    }
    return false;
  }

  /**
   * @param param
   * @return true if the paramList is null or have no elements
   */
  public boolean isNullOrEmpty(final Collection<? extends Object> param) {
    if (param == null || param.isEmpty())
      return true;
    return false;
  }

  public <K, V> boolean isNullOrEmptyMap(final Map<K, V> param) {
    if (param == null || param.isEmpty())
      return true;
    return false;
  }

  /**
   * validate if object is null .
   * @return true if the object parameter is null
   */
  public boolean isEmptyCollection(final Collection<? extends Object> collection) {
    if (isNull(collection) || collection.isEmpty()) {
      return true;
    }

    return false;
  }

  public long getLongValue(String value) {
    try {
      return Long.parseLong(value);
    } catch (Exception e) {
      return 0;
    }
  }

  public boolean searchForValue(String searchKey, String configureList) {
    return searchForValue(searchKey, ",", configureList);
  }

  public boolean searchForValue(String searchKey, String delimitar, String configureList) {

    if (isEmptyString(searchKey) || isEmptyString(configureList))
      return false;

    return Pattern.compile("(^|" + delimitar + ")" + Pattern.quote(searchKey) + "(" + delimitar + "|$)").matcher(configureList).find();
  }

  public boolean searchForContainValue(String searchKey, String inputString) {

    if (isEmptyString(searchKey) || isEmptyString(inputString))
      return false;

    return Pattern.compile("(^|)" + Pattern.quote(searchKey) + "(|$)").matcher(inputString).find();
  }

  public String removeStringDuplicate(String value) {
    Set<String> uniqueValues = new HashSet<String>(Arrays.asList(value.split(";")));
    return uniqueValues.toString().replace("[", "").replace("]", "");
  }

  public boolean validateCharRuleValue(String checkBooleanValue) {
    if (isEmptyString(checkBooleanValue))
      return false;

    return "Y".equalsIgnoreCase(checkBooleanValue);
  }

  public List<Long> convertStrToLongList(String input) {

    List<Long> longList = null;
    if (input == null)
      return longList;

    List<String> inputList = Arrays.asList(input.split(","));

    if (inputList == null || inputList.isEmpty())
      return longList;

    longList = new ArrayList<Long>();
    for (String value : inputList) {
      try {

        longList.add(Long.valueOf(value));
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
    return longList;
  }

  public String getNotNullValue(String item) {

    if (item == null)
      return "";
    else
      return item;
  }

  public Number getNotNullValue(Number item) {

    if (item == null)
      return -1;
    else
      return item;
  }

  public boolean isNumeric(String str) {

    try {
      Double.parseDouble(str);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  public <T> Collection<T> emptyIfNull(final Collection<T> list) {

    return list == null ? Collections.<T>emptyList() : list;
  }
}
