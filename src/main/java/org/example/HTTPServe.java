package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class HTTPServe {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(9090),0);
        server.createContext("/", new Handler("/"));
        server.createContext("/about-us", new Handler("/about-us"));
        server.createContext("/home-page", new Handler("/home-page"));
        server.createContext("/services", new Handler("/services"));
        server.createContext("/contact-us", new Handler("/contact-us"));
        server.setExecutor(null);
        server.start();


    }

    static class Handler implements HttpHandler {
        private String path;

        public Handler(String path) {
            this.path = path;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response;
            System.out.println("This is the current path "+path);
            if (Objects.equals(path.length(), 1)){
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "<meta charset=\"UTF-8\">\n" +
                        "<title>HomePage</title>\n" +
                        "<img src="+"https://th.bing.com/th/id/OIP.Z08_6ZOj7elNxrYxctCYYgHaH8?rs=1&pid=ImgDetMain\" alt=\"logo\"\" width=\"150\" \n\" +\n" +
                        "height = \"90\"/>\n"+

                        "</head>\n" +
                        "<br>" +
                        "<br>" +
                        "<br>" + 
                        "<body>\n" +
                        "<ul style=\"margin-right: 2rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                                                "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/>Home</a></li>\n"+
                                                "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\" href = "+"/about-us>About Me</a></li>\n"+
                                                "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\" href = "+"/services>Services</a></li>\n"+
                                                "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\"  href = "+"/contact-us>Contact</a></li>\n"+
                                                "                  </ul>\n "+
                        "<br>" +
                        "<br>" +  
                        "<img src="+"https://images.squarespace-cdn.com/content/5f186205320ade2ea49c5223/1683631424961-SVU7WTVIS70PJ5CI1SZR/1.png?format=1500w&content-type=image%2Fpng/"+
                        "width=\"3000\" \n" +
                        "height=\"800\" />" +
                        "<h3> The Cultured Food is the modern day food company. We give you the best without loosing your cultural heritage </h3>"  +
                        "<br>"+
                        "</body>\n" +
                        "</html>";
            } else if (path.contains("/about-us")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<ul style=\"margin-right: 2rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                                                "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/>Home</a></li>\n"+
                                                "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\" href = "+"/about-us>About Me</a></li>\n"+
                                                "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\" href = "+"/services>Services</a></li>\n"+
                                                "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\"  href = "+"/contact-us>Contact</a></li>\n"+
                                                "                  </ul>\n "+
                        "<br>"+
                        "<h2>Vision</h2>\n" +
                        "<img src="+"https://images.squarespace-cdn.com/content/v1/556cad85e4b00735676c983e/1657298838984-65UTVFJFKZO2P8IOK2BD/Z62_0536+(1).JPG>"+
                        "<h3>Embrace diverse flavors, fostering culinary connections that celebrate cultural richness. Our vision is to be a global epicenter of authentic, responsibly sourced, and innovative cultural foods, uniting communities through the joy of shared culinary experiences.</h3>" +
                        "<br>" +
                        "</body>\n" +
                        "</html>";
            } else if (path.contains("/services")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Services</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<ul style=\"margin-right: 2rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                                                "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/>Home</a></li>\n"+
                                                "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\" href = "+"/about-us>About Me</a></li>\n"+
                                                "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\" href = "+"/services>Services</a></li>\n"+
                                                "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\"  href = "+"/contact-us>Contact</a></li>\n"+
                                                "                 </ul>\n "+
                         "<br>"+
                        "<h2> Services </h2>\n" +
                        "<img src="+"https://foodhistoria.com/wp-content/uploads/2023/06/k-12-foodservice-is-evolving.jpg />"+
                        //"<img src="+"https://hospitalityinsights.ehl.edu/hubfs/Hospitality_Insights_EHL_Food_Service_Industry_Banner.jpg/>"+
                        "<h3>We are committed to serving you in the best way possible. We are detailed about nutrient and taste</h3>"+
                        "<br>"+
                        "</body>\n" +
                        "</html>";
            } else if (path.contains("/contact-us")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>ContactUs</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<ul style=\"margin-right: 2rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                                                "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/>Home</a></li>\n"+
                                                "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\" href = "+"/about-us>About Me</a></li>\n"+
                                                "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\" href = "+"/services>Services</a></li>\n"+
                                                "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: none;\"  href = "+"/contact-us>Contact</a></li>\n"+
                                                "                  </ul>\n "+
                        "<br>"+
                        "<h1> Contact Us </h1>\n" +
                        "<img src="+"https://www.shutterstock.com/image-photo/contact-us-communication-connection-feedback-260nw-500129104.jpg/>"+
                        "<h3>Phone NO: 09038156653,  email Address: c.food@gmail.com</h3>"+
                        "<br>"+
                        "</body>\n" +
                        "</html>";
            } else{
                response =  "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1> 404 Page Not Found</h1>\n" +
                        "<a href = "+"localhost"+":8085/about-us>About Us</a>\n"+
                        "<a href = "+"localhost"+":8085/>Home page</a>\n"+
                        "<a href = "+"localhost"+":8085/>services</a>\n"+
                        "<a href = "+"localhost"+":8085/>contact-us</a>\n"+
                        "</body>\n" +
                        "</html>";
            }


            exchange.getResponseHeaders().set("Content-type","text/html");
            exchange.sendResponseHeaders(200, response.length());
            try(OutputStream outputStream = exchange.getResponseBody()){
                outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}
