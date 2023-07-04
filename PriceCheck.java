// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;

class PriceCheck {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(bf.readLine());
        String products[] = new String[n1];
        int index = 0;
        while(index<n1){
            products[index] = bf.readLine();
            index++;
        }
        index=0;
        
        int n2 = Integer.parseInt(bf.readLine());
        double prices[] = new double[n2];
        while(index<n1){
            prices[index] = Double.parseDouble(bf.readLine());
            index++;
        }
        index=0;
        
        int n3 = Integer.parseInt(bf.readLine());
        String shopProd[] = new String[n3];
        while(index<n3){
            shopProd[index] = bf.readLine();
            index++;
        }
        index=0;
        
        int n4 = Integer.parseInt(bf.readLine());
        double shopPrices[] = new double[n4];
        while(index<n4){
            shopPrices[index] = Double.parseDouble(bf.readLine());
            index++;
        }
        index=0;
        int count=0;
        for(int i=0;i<shopProd.length;i++){
            String prod = shopProd[i];
            for(int j=0;j<products.length;j++){
                if(prod.equals(products[j]) && prices[j]!=shopPrices[i]){
                    count++;
                    break;
                }
            }
        }
        
        System.out.println(count);
        
        
    }
}