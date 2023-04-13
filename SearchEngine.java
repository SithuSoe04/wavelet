import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> stringList = new ArrayList<>();
    ArrayList<String> toReturn = new ArrayList<>();


    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return stringList.toString();
        } else if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    stringList.add(parameters[1]);
                    return stringList.toString();
                }
            return parameters[1] + "added!";
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                String keyword = parameters[1];
                for (int i = 0; i < stringList.size(); i++){
                    if (stringList.get(i).contains(keyword)){
                        toReturn.add(stringList.get(i));
                    }
                }
            }
            return "404 Not Found!";
        }
    }
}

// class NumberServer {
//     public static void main(String[] args) throws IOException {
//         if(args.length == 0){
//             System.out.println("Missing port number! Try any number between 1024 to 49151");
//             return;
//         }

//         int port = Integer.parseInt(args[0]);

//         Server.start(port, new Handler());
//     }
// }

public class SearchEngine {
    
}
