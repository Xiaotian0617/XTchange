package org.knowm.xchange;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import org.knowm.xchange.currency.Currency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CurrencyTest {

  @Test
  public void testCurrencyCode() {
    assertEquals(Currency.CNY.getCodeCurrency("CNY"), Currency.CNY);
    assertEquals(Currency.CNY.getCodeCurrency("cny"), Currency.CNY);
  }

  @Test
  public void testGetInstance() {
    assertEquals(Currency.BTC, Currency.getInstance("BTC"));
    assertEquals(Currency.BTC, Currency.getInstance("btc"));
    assertEquals(new Currency("btc"), Currency.getInstance("BTC"));
  }

  @Test
  public void testGetInstanceNoCreate() {
    assertEquals(Currency.CNY, Currency.getInstanceNoCreate("CNY"));
    assertEquals(Currency.CNY, Currency.getInstanceNoCreate("cny"));
    assertEquals(new Currency("cny"), Currency.getInstanceNoCreate("CNY"));
  }

  @Test
  public void testEquals() {
    assertEquals(Currency.BTC, Currency.XBT);
    assertNotEquals(Currency.LTC, Currency.XBT);

    Currency btc = SerializationUtils.deserialize(SerializationUtils.serialize(Currency.BTC));
    assertEquals(Currency.BTC, btc);
    assertEquals(Currency.XBT, btc);
    assertNotEquals(Currency.LTC, btc);
  }
}
