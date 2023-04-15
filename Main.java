package JavaAndroid;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.myip.com/";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setDoOutput(true);
        BufferedReader br = new BufferedReader( new InputStreamReader(connection.getInputStream()));
        String input;
        if ((input = br.readLine()) != null){
            IP now = gson.fromJson(input,IP.class);
            System.out.println(now.getIp());
            System.out.println(now.getCountry());
            System.out.println(now.getCc());
        }
        br.close();
    }
}

class IP {
    String ip;
    String country;
    String cc;

    public IP(String ip, String country, String cc) {
        this.ip = ip;
        this.country = country;
        this.cc = cc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}