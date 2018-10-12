
import java.io.*;
import java.net.*;
import java.nio.charset.*;

public class Main{
	public static void main(String... args){ 
		String[] url = {"http://dota2.com/"};
		for(String label : url){
		try{
		FileOutputStream path = new FileOutputStream("site.html");
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(path, StandardCharsets.UTF_8));

		URL obj = new URL(label);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		connection.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		String inputLine;

		StringBuffer response = new StringBuffer();

		while((inputLine = in.readLine())!=null){
			response.append(inputLine);
			br.write(inputLine);
			br.flush();
			
		}

		in.close();

		System.out.println(response.toString());
		} catch(IOException e){
			System.out.print(e);
		}

	}
	}
}