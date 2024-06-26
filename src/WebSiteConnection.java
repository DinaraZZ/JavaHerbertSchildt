// Java. Полное руководство - Г.Шилдт
// Доступ к атрибутам удалённого ресурса
// стр. 920

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class WebSiteConnection {
    public static void main(String[] args) throws Exception{
        int c;
        URL hp = new URL("https://vk.com");
        URLConnection hpCon = hp.openConnection();

        long d = hpCon.getDate();
        if(d != 0){
            System.out.println("Date: " + new Date(d));
        }

        System.out.println("Content-Type: " + hpCon.getContentType());

        d = hpCon.getExpiration();
        if(d != 0){
            System.out.println("Expiration date: " + new Date(d));
        }

        d = hpCon.getLastModified();
        if(d != 0){
            System.out.println("Last modified: " + new Date(d));
        }

        long len = hpCon.getContentLengthLong();
        if(len != 0){
            System.out.println("Content length: " + len);
            System.out.println();
            InputStream in = hpCon.getInputStream();
            while ((c = in.read()) != -1){
                System.out.print((char) c);
            }
            in.close();
        }

    }
}