package com.flatiron.spring.FlatironSpring.BitcoinTests;

import com.flatiron.spring.FlatironSpring.Controller.BitCoinController;
import com.flatiron.spring.FlatironSpring.Service.BitcoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BitcoinControllerUnitTest {
    @Test
    void returnPriceStatement(){
        BitcoinService bitcoinService = Mockito.mock(BitcoinService.class);
        String bitcoinPriceStatement = "Hello the current price of Bitcoin is: $4";
        BitCoinController bitCoinController = new BitCoinController(bitcoinService);
        when(bitcoinService.getBitcoinPrice("Bitcoin")).thenReturn("$4");
        String actual = bitCoinController.price("$4");
        assertEquals(bitcoinPriceStatement,actual);
    }
    @Test
    void returnPriceStatementforCoin(){
        String coin = "bitcoin";
        String price = "$4";
        BitcoinService bitcoinService = Mockito.mock(BitcoinService.class);
        String bitcoinPriceStatement = "Hello the current price of "+coin+" is: "+price;
        BitCoinController bitCoinController = new BitCoinController(bitcoinService);
        when(bitcoinService.getBitcoinPrice(coin)).thenReturn(price);
        String actual = bitCoinController.price(coin);
        assertEquals(bitcoinPriceStatement,actual);
    }
}
