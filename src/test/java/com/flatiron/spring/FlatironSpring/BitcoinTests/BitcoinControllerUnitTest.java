package com.flatiron.spring.FlatironSpring.BitcoinTests;

import com.flatiron.spring.FlatironSpring.Controller.BitCoinController;
import com.flatiron.spring.FlatironSpring.Service.BitcoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BitcoinControllerUnitTest {

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
