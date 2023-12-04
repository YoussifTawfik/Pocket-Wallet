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
}
