package com.salil.messageFormat;


/**
 * Created by Salil on 29/06/17.
 */
public class MessageFormat {
    public static void main(String args[]){
        String message = "http://localhost:8080/v2/{0}/category?lang={1}&site={2}";
        String site = "news";
        String lang = "en";

        String FormattedMessage = new StringBuilder(java.text.MessageFormat.format(message,site,lang,site)).toString();
        System.out.println(FormattedMessage);

    }
}
