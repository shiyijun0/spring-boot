package com.imooc.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试加签验签
 */
public class RSAUtilTest {



    static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDovNC1bzzZ3lu//xLUIud8a8Fu\n" +
            "bvgXVxFu7Z3jbBjc3thot8gIrpZt951MkdfcUK091kHiDmwiAnMkDJvZI1Y9cWcF\n" +
            "gyKjczR1iDusUTPMGwHkligBx4ocVyoREz8mC0JliSnn8OKhutvnegyFsDI5lVuV\n" +
            "ZyFQPGbzvXtYIJ+cBwIDAQAB";
    static final String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAOi80LVvPNneW7//\n" +
            "EtQi53xrwW5u+BdXEW7tneNsGNze2Gi3yAiulm33nUyR19xQrT3WQeIObCICcyQM\n" +
            "m9kjVj1xZwWDIqNzNHWIO6xRM8wbAeSWKAHHihxXKhETPyYLQmWJKefw4qG62+d6\n" +
            "DIWwMjmVW5VnIVA8ZvO9e1ggn5wHAgMBAAECgYEA5Zkn2GWVxWUcZGtxmr+YWGFB\n" +
            "YP2uV/A4LZPSuAHzASoCmkP73bzGgFPP5TLXnewlDCTrt+P8fwylpEGgGfVHY9Jj\n" +
            "xYFFIqcLN7pjZDvIB6sUv7puV+OisyqcmpiwLyyG0pfhoAWnSwvoO8IPft9dOLO4\n" +
            "0GikdRRymqgZbMMzQAkCQQD4wnQa7A4KRwMn1AC3R46sw4uz4F2YFSMM1r2PsQP6\n" +
            "Z4DPNeqb7V4iMBN3O8lZP5Mr4dBSblz5k0+Xq+Tzr4u7AkEA74L6qDOnYbzGusAs\n" +
            "PneGZ9bXDktix+IjA+7BalZe3dwAbc0bUBcozxMy5MrtXzYO2cOPeFO5FD1EXr/D\n" +
            "NFmeJQJBAKCOCRgTQWCawsujBq9ErS6Oq412g5IUGmI/+2tRygqFYVrcJsdrJfWU\n" +
            "6Att+B/1a4zIG4gImVOwI4/2LzilFd8CQBvO0D1hKejeGxCpqTljdTZvKi7dr81X\n" +
            "Qwt81/X5qzAFEAOvkaE93x4Ts4/+w4qPYzADVY/54H4qEtsRVp+oXAUCQQDO2uuT\n" +
            "s8rPZ4Et/fiJAdeUpgW9J5Wiu6hCkZXPXfYcii8cxUMQzXWgy8WPjWUXHGfFQii5\n" +
            "YFFM9D047GDim3Dp";

    static final String publicKey1 ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5sNWySA+cBS+/DjLRk5s/ej1mi81dBBKsaIFb1JYiliW21OwOQAmBZ4flxMysRFZzuvj/C39atL26NhF7Vb124Tn+HmbXepTvDsD2XzkkqZ/+EPOqwH+4xQ92iGznvncIHfMbI2Rl74ysE5PIjmmqsm14twYs6b9Y7b8IqGAtIQIDAQAB";
    static final String privateKey1 ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALmw1bJID5wFL78OMtGTmz96PWaLzV0EEqxogVvUliKWJbbU7A5ACYFnh+XEzKxEVnO6+P8Lf1q0vbo2EXtVvXbhOf4eZtd6lO8OwPZfOSSpn/4Q86rAf7jFD3aIbOe+dwgd8xsjZGXvjKwTk8iOaaqybXi3Bizpv1jtvwioYC0hAgMBAAECgYEAi80sBk6kmeV5vhD1h73mq1Lf+V2V3srbODxx7+5MnnuGp3EEy/HAdlG5Ce8x3RySLg19u58vYd4j3ZcpcD7sJdSKpIcb5/lwsjxK5YSvEvspOcpEtjkaHpHgRR3n/BUolaqhbTPpyPBgBy+xBOVxzg5wdjKS3pd5WHCwe3gb/3ECQQDosQZzuYUUCGRaq2JeHv6sPMcSYlCr0d3L+txftfZlz25Hi6xGZ5z8R0U0luGkGaUWSwfNr1cMbOx/0816WS39AkEAzEqOWATG3htKndn0SDivC35i+pyTtYhkSeqTiaoKECIZfHaC6M0sBDTGfTzZ2Tk+CESju0QZa7JbcUK2MCby9QJAfAjQ/aLokxMeG0678pvm+Py0yNHrWotWBUNFcSdXnlGB4VVMkYLtpXSAKVY8FPMuksGP+U37wr3VGxZVs2ASKQJAUDYl1aFqg+KrVXcyVvkKobSqIERCKtC2r98Otsqw0MzSvO+7TrTgR3aBSMMPth6noI9yyiBe6s5I4RuUdSuV0QJAF4LQHKsIlKZbICvNvQ1i2ZjvALpM+noZEIk/Bxivo01vvxxhBRIcwQoTvXiNdighyZfOjsOdUW6e9KbnTFBzzQ==";

    @Test
    public void signTest(){
        String text = "{\"amount\":1000,\"chanId\":\"111\",\"chanUserId\":\"123\",\"createAt\":\"2019-01-17 13:26:48\",\"memo\":\"理财下单\",\"outerOrderId\":\"10001\",\"productId\":\"123456\"}";
        String sign = RSAUtil.sign(text,privateKey);
        System.out.println(sign);
        System.out.println(RSAUtil.verify(text, sign, publicKey));
    }

    @Test
    public void sign(){
        String text="{\n" +
                "  \"amount\": 1000,\n" +
                "  \"chanId\": \"1\",\n" +
                "  \"chanUserId\": \"2\",\n" +
                "  \"createAt\": \"2019-01-17 05:42:12\",\n" +
                "  \"memo\": \"理财收益\",\n" +
                "  \"outerOrderId\": \"3\",\n" +
                "  \"productId\": \"123456\"\n" +
                "}";
        String sign=RSAUtil.sign(text,privateKey1);
        System.out.println(sign);
        System.out.println(RSAUtil.verify(text,sign,publicKey1));


    }
}
